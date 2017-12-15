package com.dalaran.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.aopalliance.intercept.MethodInterceptor;
import org.mybatis.spring.transaction.SpringManagedTransaction;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionDalaran {
	private Connection conn = null;
	private Savepoint savepoint = null;

	public void beginTransaction() throws SQLException{
		try{
			conn = this.getConnection();
			//手动提交
			conn.setAutoCommit(false);
			//设置还原点
			savepoint = conn.setSavepoint("DalaranSavePoint");
			//执行jdbc操作
			this.insertData();
		}catch(Exception e){
			if(savepoint != null){
				// 回滚到还原点
				conn.rollback(savepoint);
			}else{
				conn.rollback();
			}
		}finally{
			// 提交事务
			conn.commit();
			conn.close();
		}
	}


	public void insertData(){
		TransactionTemplate tt = null;

	}




	public Connection getConnection(){
		TransactionInterceptor xi;
		MethodInterceptor mi;
		TransactionAspectSupport tas;
		SpringManagedTransaction st;
		return null;
	}


}
