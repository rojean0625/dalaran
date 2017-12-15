package com.dalaran.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dalaran.dao.BlackDao;
import com.dalaran.model.Black;
import com.dalaran.service.BlackService;

@Service("blackService")
public class BlackServiceImpl implements BlackService {

	@Resource
	private BlackDao blackDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateOptimistic(Black black) throws Exception {
		blackDao.updateOptimistic(black);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void updateOptimisticRequiredNew(Black black) throws Exception {
		blackDao.updateOptimistic(black);
	}

	@Override
	@Transactional(propagation=Propagation.NESTED,rollbackFor=Exception.class)
	public void updateOptimisticNested(Black black) throws Exception {
		blackDao.updateOptimistic(black);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
	public void updateOptimisticSupport(Black black) throws Exception {
		blackDao.updateOptimistic(black);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
	public void updateOptimisticSupportFail() throws Exception {
		updateBlackOptimistic();
	}


	@Override
	public void restoreOptimistic(Black black) {
		blackDao.restoreOptimistic(black);
	}

	@Override
	public Black findById(String id) {
		// TODO Auto-generated method stub
		return blackDao.findById(id);
	}




	private void updateBlackOptimistic() throws Exception{
		throw new Exception("UpdateBlack Fail.");
	}

}
