package com.dalaran.dao;

import com.dalaran.model.mongo.SysOrd;

public interface SysOrderDao {

	SysOrd findById(String id);
}
