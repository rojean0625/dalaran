package com.dalaran.service;

import com.dalaran.model.mongo.SysOrd;

public interface SysOrderService {

	SysOrd findById(String id);
}
