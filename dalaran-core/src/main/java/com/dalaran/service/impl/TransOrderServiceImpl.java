package com.dalaran.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dalaran.dao.TransOrderDao;
import com.dalaran.mapper.TransOrderMapper;
import com.dalaran.model.TransOrder;
import com.dalaran.service.TransOrderService;

@Service("transOrderService")
public class TransOrderServiceImpl implements TransOrderService {

	@Resource
	private TransOrderDao transOrderDao;

	@Override
	public TransOrder findByCheckId(Map<String, String> map) {
		return transOrderDao.findByCheckId(map);
	}

	@Override
	public int insertTransOrder(TransOrder ord) {
		return transOrderDao.insertTransOrder(ord);
	}

	@Override
	public int batchInsertTransOrder(List<TransOrder> lst) {
		return transOrderDao.batchInsertTransOrder(lst);
	}

}
