package com.dalaran.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dalaran.busiExcp.SpringCheckException;
import com.dalaran.busiExcp.SpringUncheckException;
import com.dalaran.dao.BlackDao;
import com.dalaran.dao.WhiteDao;
import com.dalaran.model.Black;
import com.dalaran.model.White;
import com.dalaran.service.BlackService;
import com.dalaran.service.DalaranService;
import com.dalaran.service.WhiteService;

@Service("dalaranService")
public class DalaranServiceImpl implements DalaranService {

	Logger logger = LoggerFactory.getLogger(DalaranServiceImpl.class);

	/**
	 * 接口注入
	 */
	@Resource
	private WhiteService whiteService;
	@Resource
	private BlackService blackService;

	@Resource
	private WhiteDao whiteDao;
	@Resource
	private BlackDao blackDao;

	/**
	 * Propagation.REQUIRED
	 * Propagation.REQUIRED
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void proRequired(int w,int b) throws Exception{
		logger.info("## Propagation.REQUIRED begin ");
		whiteService.updateOptimistic(new White(w));
		blackService.updateOptimistic(new Black(b));
	}

	@Transactional(timeout=5,rollbackFor=Exception.class)
	public void proRequiredTimeOut(int w,int b) throws Exception{
		logger.info("## Propagation.REQUIRED begin ");
		logger.info("Tread Sleep begin");
		Thread.sleep(8000);
		logger.info("Tread Sleep end");
		try{
		whiteService.updateOptimistic(new White(w));
		blackService.updateOptimistic(new Black(0));
		}catch(Exception e){
			logger.info("## TimeOut: {}",e.getMessage());
			throw e;
		}
	}


	/**
	 * Propagation.RequiredNew
	 * Propagation.RequiredNew
	 * 内层事务独立，外层事务回滚不会导致内层事务回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=SpringCheckException.class)
	public void proRequiredNew(int w, int b) throws Exception{
		logger.info("## Propagation.REQUIRES_NEW begin");
		// 1 外层事务
		whiteService.updateOptimistic(new White(w));
		// 2 suppending

		// 3 new Connection
		// 调用 Propagation.REQUIRES_NEW
		blackService.updateOptimisticRequiredNew(new Black(b));
		// comit / rollback;

		//4 resumer
		//5 comit /rollback;
		if(b == 1){
			throw new SpringCheckException("外层事务异常");
		}
	}


	/**
	 * Propagation.REQUIRES_NESTED
	 * Propagation.REQUIRES_NESTED
	 * 内外层事务嵌套，内层事务依赖外层事务，外层事务回滚，导致内层事务回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=SpringCheckException.class)
	public void proNested(int w,int b) throws Exception{
		logger.info("## Propagation.REQUIRES_NESTED begin");
		// 1 conn
		whiteService.updateOptimistic(new White(w));
		// 2 savePoint

		// 3 joinComm
		blackService.updateOptimisticNested(new Black(b));
		// 如果成功不会立刻提交，失败 返回到还原点。


		if(b == 1){
			throw new SpringCheckException("外层事务异常");
		}
		// comit/rollback;
	}

	/**
	 * Propagation.SUPPORTS
	 * Propagation.SUPPORTS
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void proSupportsHasTx(int w, int b) throws Exception {
		logger.info("## Propagation.SUPPORTS has Tx begin");
		whiteService.updateOptimisticSupport(new White(1));
		blackService.updateOptimisticSupport(new Black(0));
	}

	@Override
	public void proSupportsHaventTx(int w, int b) throws Exception {
		logger.info("## Propagation.SUPPORTS haven't Tx begin");
		whiteService.updateOptimisticSupportSucc();
		blackService.updateOptimisticSupportFail();

	}


	/**
	 * ExceptionCatch
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=SpringCheckException.class)
	public void proRequiredExcpFilter(int w,int b) throws Exception{
		logger.info("## Propagation.REQUIRED begin");
		logger.info("## rollbackFor SpringCheckException.class");
		whiteDao.updateOptimistic(new White(1));
		throw new SpringUncheckException();
	}


	/**
	 * ReadOnly
	 * @throws InterruptedException
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,isolation=Isolation.READ_COMMITTED)
	public void readOnlyTransaction() throws Exception {
		logger.info("Tread Sleep begin");
		Thread.sleep(8000);
		White w = whiteService.findById("white01");
		logger.info("White optimistic  - {}",w.getOptimistic());

		Thread.sleep(10000);
		Black b = blackService.findById("black01");
		logger.info("Black optimistic  - {}",b.getOptimistic());
	}

	/**
	 * ##########################################################################
	 * 测试更新 、还原
	 */
	@Override
	public void testUpdate() throws Exception {
		blackService.updateOptimistic(new Black(1));
		whiteService.updateOptimistic(new White(1));
	}

	@Override
	public void testRestore() {
		blackService.restoreOptimistic(null);
		whiteService.restoreOptimistic(null);
	}



}
