package com.dalaran.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dalaran.dao.SysOrderDao;
import com.dalaran.model.mongo.SysOrd;

@Repository("sysOrderDao")
public class SysOrdDaoImpl implements SysOrderDao {

	//#@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public SysOrd findById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("systemFlowId").is(id));
		return mongoTemplate.findOne(query, SysOrd.class);
	}

}
