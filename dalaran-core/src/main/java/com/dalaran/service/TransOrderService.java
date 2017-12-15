package com.dalaran.service;

import java.util.List;
import java.util.Map;

import com.dalaran.model.TransOrder;

public interface TransOrderService {

	TransOrder findByCheckId(Map<String,String> map);

	int insertTransOrder(TransOrder ord);

	int batchInsertTransOrder(List<TransOrder> lst);
}
