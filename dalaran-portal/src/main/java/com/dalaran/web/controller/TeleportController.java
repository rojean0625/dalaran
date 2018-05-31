package com.dalaran.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dalaran.api.TeleportInterface;

@Controller
@RequestMapping("teleport")
public class TeleportController {

	private Logger logger = LoggerFactory.getLogger(TeleportController.class);


	@Resource
	private TeleportInterface teleportInterface;

	@RequestMapping("toTeleportPage")
	public ModelAndView toTeleportPage(HttpServletRequest request){
		String path = request.getScheme() + "://" + request.getServerName() + (80 == request.getServerPort() || 443 == request.getServerPort() ? "" : (":" + request.getServerPort()));
		String context = request.getContextPath();
		path = path + context;
		ModelAndView mv = new ModelAndView("/teleport/teleportPage");
		mv.addObject("path", path);
		return mv;
	}

	@RequestMapping("doTeleport1")
	public void doTeleport1(String location){
		teleportInterface.toStormwind();
		logger.info("## Teleport doTeleport1");
	}

	@RequestMapping("doTeleport2")
	public void doTeleport2(String location) throws InterruptedException, ExecutionException{
		String v = teleportInterface.toKenruito();
		System.out.println("v #   " + v);

		Future<Object> future= RpcContext.getContext().getFuture();
		Object o = future.get();
		System.out.println("v ##   " + o);

		logger.info("## Teleport doTeleport2");
	}

	@RequestMapping("doUpdatePDF")
	public void doUpdatePDF(@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException{
		System.out.println("#"+files);
//		if(null != files){
//			//遍历并保存文件
//			for(MultipartFile file : files){
//	    	   file.transferTo(new File("D://" + file.getOriginalFilename()));
//	        }
//	    }
	}
}
