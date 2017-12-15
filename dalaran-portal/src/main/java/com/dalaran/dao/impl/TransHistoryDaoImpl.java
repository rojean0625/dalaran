package com.dalaran.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.TransHistoryDao;
import com.dalaran.mapper.DalaranBaseMapper;
import com.dalaran.mapper.TransHistoryMapper;
import com.dalaran.model.TransHistory;
@Repository("transHistoryDao")
public class TransHistoryDaoImpl extends DalaranBaseMapper<TransHistory> implements TransHistoryDao {

	public TransHistoryDaoImpl(){
		super(TransHistoryMapper.class.getName());
	}

	@Override
	public List<TransHistory> findByMap(Map<String, String> map) {
		String method = this.mapperClassName + ".findByMap";
		return super.getSqlSession().selectList(method, map);
	}

	@Override
	public int insert(TransHistory obj) {
		String method = this.mapperClassName + ".insert";
		return super.getSqlSession().insert(method, obj);
	}

	@Override
	public int insertList(List<TransHistory> list) {
		String method = this.mapperClassName + ".insertList";
		return super.getSqlSession().insert(method, list);
	}
}
