package com.dalaran.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 关注点：DML方法前后的 事务管理
 * @author Administrator
 *
 */
@Aspect
@Component
public class TransactionIntercepter {

	/**
	 * 切入点，对连接点进行拦截的定义
	 */
	@Pointcut("execution(* com.dalaran.service.impl.TableServiceImpl.*(..))")
	private void transactionMgr(){
		System.out.println("Intercepter catch");
	}


	@Before("transactionMgr()")
	public void doCreateConn(){
		System.out.println("## setAutoComt=false ，开始事务");
	}


	@AfterReturning("transactionMgr()")
	public void doCloseConn(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		String[] arg = (String[])args[0];
		System.out.println("####################joinpont:" + arg);
		System.out.println("## Connection Close 关闭数据库连接");
	}

	@After("transactionMgr()")
	public void doCommit(){
		System.out.println("## 执行完成");
	}

	@AfterThrowing("transactionMgr()")
	public void rollBack(){
		System.out.println("## 回滚异常。。");
	}

	@Around("transactionMgr()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("## Create Sql Connection 建立数据库连接。。");
        Object object = joinPoint.proceed();//执行该方法
        System.out.println("## Commit. 执行成功，提交事务。。");
        return object;
    }


}
