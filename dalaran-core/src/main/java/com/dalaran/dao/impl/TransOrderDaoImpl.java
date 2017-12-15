package com.dalaran.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.TransOrderDao;
import com.dalaran.mapper.DalaranBaseMapper;
import com.dalaran.mapper.TransOrderMapper;
import com.dalaran.model.TransOrder;

@Repository("transOrderDao")
public class TransOrderDaoImpl extends DalaranBaseMapper<TransOrder> implements TransOrderDao {

	public TransOrderDaoImpl() {
		super(TransOrderMapper.class.getName());
	}

	@Override
	public TransOrder findByCheckId(Map<String, String> map) {
		String method= this.mapperClassName + ".findByCheckId";
		TransOrder order = super.getSqlSession().selectOne(method, map);
		return order;
	}

	@Override
	public int insertTransOrder(TransOrder ord) {
		String method = this.mapperClassName + ".insertTransOrder";
		return super.getSqlSession().insert(method, ord);
	}

	@Override
	public int batchInsertTransOrder(List<TransOrder> lst) {
		String method = this.mapperClassName + ".batchInsertTransOrder";
		return super.getSqlSession().insert(method, lst);
	}

}
