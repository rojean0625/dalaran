package com.dalaran.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dalaran.dao.SysOrderDao;
import com.dalaran.model.mongo.SysOrd;
import com.dalaran.service.SysOrderService;
@Service
public class SysOrderServiceImpl implements SysOrderService {

	@Resource
	private SysOrderDao sysOrderDao;

	@Override
	public SysOrd findById(String id) {
		return sysOrderDao.findById(id);
	}

}
