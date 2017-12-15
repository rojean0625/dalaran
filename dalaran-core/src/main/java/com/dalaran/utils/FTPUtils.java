package com.dalaran.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FTPUtils {

	private static Logger log = LoggerFactory.getLogger(FTPUtils.class);

	/** SFTP服务器主机地址（IP地址） */
	private String host;
	/** SFTP连接端口 */
	private int port;
	/** SFTP登录用户名 */
	private String username;
	/** SFTP登录密码 */
	private String password;
	/** SFTP连接会话 */
	private Session session;

	/**
	 * 无参构造方法
	 */
	public FTPUtils() {}

	/**
	 * 构造方法
	 * @param host
	 *            SFTP服务器主机地址（IP地址）
	 * @param port
	 *            SFTP连接端口
	 * @param username
	 *            SFTP登录用户名
	 * @param password
	 *            SFTP登录密码
	 * @throws JSchException
	 */
	public FTPUtils(String host, int port, String username, String password) throws JSchException {
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		// 获得SFTP服务器连接
		this.createSession();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获得SFTP服务器连接
	 * @throws JSchException
	 *             JSCH异常
	 */
	public void createSession() throws JSchException {
		// 创建JSch对象
		JSch jsch = new JSch();
		// 根据登录用户名、SFTP服务器主机地址（IP地址）、SFTP连接端口获取一个Session对象
		session = jsch.getSession(username, host, port);
		// 设置登录密码
		session.setPassword(password);
		// 设置不验证 HostKey
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		// 设置超时5分钟
		 session.setTimeout(5 * 60 * 1000);
		//session.setTimeout(10000);
		try {
			// 打开会话连接
			session.connect();
		} catch (JSchException jse) {
			// 如果连接已打开，需要销毁连接
			if (session.isConnected()) {
				session.disconnect();
			}
			throw new JSchException("Connect to the server failed.Please check HOST[" + host + "],PORT[" + port + "],USERNAME[" + username + "],PASSWORD["
					+ password + "].And check the network connection is working or if the request was denied by the firewall:" + jse.getMessage());
		}
	}

	/**
	 * 断开（销毁）Sessioin
	 */
	public void disSession() {
		if (session != null) {
			session.disconnect();
			session = null;
		}
	}

	/**
	 * 获得SFTP连接
	 * @return
	 * @throws JSchException
	 */
	private ChannelSftp getChannelSftp() throws JSchException {
		// 打开SFTP连接通道
		Channel channel = session.openChannel("sftp");
		try {
			// 打开渠道连接
			channel.connect();
		} catch (JSchException jse) {
			// 如果连接已打开，需要销毁连接
			if (channel.isConnected()) {
				channel.disconnect();
			}
			throw new JSchException("Connect to the server failed.Please check HOST[" + host + "],PORT[" + port + "],USERNAME[" + username + "],PASSWORD["
					+ password + "].And check the network connection is working or if the request was denied by the firewall:" + jse.getMessage());
		}
		ChannelSftp channelSftp = (ChannelSftp) channel;
		return channelSftp;
	}

	/**
	 * 断开（销毁）SFTP连接
	 */
	private void disChannelSftp(ChannelSftp channelSftp) {
		if (channelSftp != null) {
			channelSftp.disconnect();
			channelSftp.exit();
			channelSftp = null;
		}
	}

	/**
	 * 上传文件
	 * @param directory
	 *            待上传的目录（如：/finance）
	 * @param uploadFile
	 *            待上传的文件
	 * @param uploadFileName
	 *            上传文件的新文件名（FTP服务器上存储的文件名，如：EACQ_YNLF_20130615.xls）
	 * @throws FileNotFoundException
	 *             文件未不到异常
	 * @throws SftpException
	 *             SFTP异常
	 * @throws
	 */
	public void upload(String directory, File uploadFile, String uploadFileName) throws JSchException, FileNotFoundException, SftpException {
		// 获得SFTP服务器连接
		ChannelSftp channelSftp = null;
		BufferedInputStream binput = null;
		try {
			channelSftp = getChannelSftp();
			// 进入目录
			channelSftp.cd(directory);
			// 创建往本地文件中输入的流
			binput = new BufferedInputStream(new FileInputStream(uploadFile));
			// 上传
			channelSftp.put(binput, uploadFileName);
		} finally {
			if (binput != null) {
				try {
					binput.close();
				} catch (IOException ioe) {}
			}
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
	}

	/**
	 * 下载文件
	 * @param directory
	 *            待下载目录（如：/finance）
	 * @param downloadFileName
	 *            待下载的文件名(EACQ_YNLF_20130615.xls)
	 * @param saveFile
	 *            下载后存入本地的文件
	 * @throws FileNotFoundException
	 *             文件未不到异常
	 * @throws SftpException
	 *             SFTP异常
	 */
	public void download(String directory, String downloadFileName, File saveFile) throws JSchException, FileNotFoundException, SftpException {
		ChannelSftp channelSftp = null;
		BufferedOutputStream boutput = null;
		try {
			// 获得SFTP服务器连接
			channelSftp = getChannelSftp();
			// 进入目录
			channelSftp.cd(directory);
			// 创建往SFTP上输出的流
			boutput = new BufferedOutputStream(new FileOutputStream(saveFile));
			// 下载
			channelSftp.get(downloadFileName, boutput);
		} finally {
			if (boutput != null) {
				try {
					boutput.close();
				} catch (IOException ioe) {}
			}
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
	}

	/**
	 * 删除文件. 仅支持删除文件，不支持删除目录
	 * @param directory
	 *            待删除文件所在目录
	 * @param deleteFile
	 *            待删除的文件（文件名全称，如：EACQ_YNLF_20130615-up.xls）
	 * @throws SftpException
	 *             SFTP异常
	 * @throws JSchException
	 */
	public void delete(String directory, String deleteFile) throws JSchException, SftpException {
		ChannelSftp channelSftp = null;
		try {
			// 获得SFTP服务器连接
			channelSftp = getChannelSftp();
			// 进入目录
			channelSftp.cd(directory);
			// 删除文件
			channelSftp.rm(deleteFile);
		} finally {
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
	}

	/**
	 * 列出目录下的文件
	 * @param directory
	 *            待列出的目录
	 * @return 目录中的所有文件名列表（包括后缀名，如：EACQ_YNLF_20130615.xls）
	 * @throws SftpException
	 *             SFTP异常
	 */
	public Vector<String> listFiles(String directory) throws JSchException, SftpException {
		ChannelSftp channelSftp = null;
		Vector<String> fileNameList = new Vector<String>();
		try {
			// 获得SFTP服务器连接
			channelSftp = getChannelSftp();
			Vector<Object> objectList = channelSftp.ls(directory);
			for (Object obj : objectList) {
				// 获取文件名（包括后缀名）
				// -rw-r--r-- 1 hsm users 975872 Jul 9 03:26
				// EACQ_YNLF_20130615.xls
				String curStr = obj.toString();
				curStr = curStr.substring(curStr.lastIndexOf(" ") + 1);
				if (".".equals(curStr) || "..".equals(curStr)) {// .表示当前目录，..表示上一级目录
					continue;
				}
				fileNameList.add(curStr);
			}
		} finally {
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
		return fileNameList;
	}

	/**
	 * 用于模糊查询某个远程目录下的文件名称. 只要文件名中包含｛valiStr｝即可列出
	 * @param directory
	 *            远程目录
	 * @param valiStr
	 *            文件名称
	 * @return 远程目录下的文件名称列表（包括后缀名，如：EACQ_YNLF_20130615.xls）
	 * @throws SftpException
	 *             SFTP异常
	 */
	public Vector<String> listFileNames(String directory, String valiStr) throws JSchException, SftpException {
		ChannelSftp channelSftp = null;
		Vector<String> fileNameList = new Vector<String>();
		try {
			// 获得SFTP服务器连接
			channelSftp = getChannelSftp();
			Vector<Object> objectList = channelSftp.ls(directory);
			for (Object obj : objectList) {
				// 获取文件名（包括后缀名）
				// -rw-r--r-- 1 hsm users 975872 Jul 9 03:26
				// EACQ_YNLF_20130615.xls
				String curStr = obj.toString();
				curStr = curStr.substring(curStr.lastIndexOf(" ") + 1);
				// 检查文件名是否包含｛valiStr｝
				if (curStr.contains(valiStr)) {
					// 包含即加如Vector
					fileNameList.add(curStr);
				}
			}
		} finally {
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
		return fileNameList;
	}

	/**
	 * 检查文件是否存在
	 * @param directory
	 *            远程目录
	 * @param valiStr
	 *            文件名称
	 * @return 是否存在（true-存在 false-不存在）
	 * @throws SftpException
	 *             SFTP异常
	 */
	public boolean isExists(String directory, String valiStr) throws JSchException, SftpException {
		ChannelSftp channelSftp = null;
		try {
			// 获得SFTP服务器连接
			channelSftp = getChannelSftp();
			Vector<Object> objectList = channelSftp.ls(directory);
			for (Object obj : objectList) {
				// 获取文件名（包括后缀名）
				// -rw-r--r-- 1 hsm users 975872 Jul 9 03:26
				// EACQ_YNLF_20130615.xls
				String curStr = obj.toString();
				curStr = curStr.substring(curStr.lastIndexOf(" ") + 1);
				// 检查文件名是否包含｛valiStr｝
				if (curStr.equals(valiStr)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		} finally {
			// 断开（销毁）SFTP连接
			disChannelSftp(channelSftp);
		}
		return false;
	}
}
