package com.dalaran.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dalaran.dao.WhiteDao;
import com.dalaran.model.Black;
import com.dalaran.model.White;
import com.dalaran.service.BlackService;
import com.dalaran.service.WhiteService;

@Service("whiteService")
public class WhiteServiceImpl implements WhiteService {


	@Resource
	private WhiteDao whiteDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateOptimistic(White white) throws Exception {
		whiteDao.updateOptimistic(white);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
	public void updateOptimisticSupport(White white) throws Exception {
		whiteDao.updateOptimistic(white);
	}

	@Override
	public void restoreOptimistic(White white) {
		whiteDao.restoreOptimistic(white);
	}

	@Override
	public White findById(String id) {
		// TODO Auto-generated method stub
		return whiteDao.findById(id);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
	public void updateOptimisticSupportSucc() throws Exception {
		whiteDao.updateOptimistic(new White(1));
	}

}
