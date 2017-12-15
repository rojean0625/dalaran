package com.dalaran.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dalaran.dao.TransHistoryDao;
import com.dalaran.model.TransHistory;
import com.dalaran.service.TransHistoryService;

@Service("transHistoryService")
public class TransHistoryServiceImpl implements TransHistoryService {

	@Resource
	private TransHistoryDao transHistoryDao;

	@Override
	public List<TransHistory> findByMap(Map<String, String> map) {
		return transHistoryDao.findByMap(map);
	}

	@Override
	public int insert(TransHistory obj) {
		return transHistoryDao.insert(obj);
	}

	@Override
	public int insertList(List<TransHistory> list) {
		return transHistoryDao.insertList(list);
	}

}
