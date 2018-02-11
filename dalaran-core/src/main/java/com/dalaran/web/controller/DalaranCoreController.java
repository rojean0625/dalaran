package com.dalaran.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dalaran.api.BankOrderInterface;
import com.dalaran.model.TransOrder;
import com.dalaran.model.mongo.SysOrd;
import com.dalaran.mq.RojeanProducer;
import com.dalaran.service.TransOrderService;
import com.dalaran.service.SysOrderService;

@Controller
@RequestMapping("dalaran")
public class DalaranCoreController {
	Logger logger = LoggerFactory.getLogger(DalaranCoreController.class);

	@Resource
	private TransOrderService transOrderService;

	@Resource
	private RojeanProducer producer;

	@RequestMapping("producer")
	public void producer() throws Exception{
		logger.info("#rmq ready.");
		producer.sendMessage("insert message");
		logger.info("#rmq succ.");
	}

	@RequestMapping("queryTransOrder")
	public void queryTransOrder(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("checkId", "check01");
		map.put("tableName", "trans_order");
		TransOrder ord = transOrderService.findByCheckId(map);
		System.out.println("MariaDB queryResult - ORD INFO: "+ord.getCheckId()  + " " + ord.getTransAmount());
	}

	@RequestMapping("insertTransOrder")
	public void insertTransOrder(){
		TransOrder ord = new TransOrder();
		ord.setId(UUID.randomUUID().toString().substring(8));
		ord.setCheckId("check"+UUID.randomUUID().toString().substring(10));
		ord.setOptimistic(0);
		ord.setPayInterface("48380000");
		ord.setTransAmount(5000d);
		ord.setTransTime(new Date());
		transOrderService.insertTransOrder(ord);
	}

	@RequestMapping("batchInsertTransOrder")
	public void batchInsertTransOrder(){
		List<TransOrder> lst = new ArrayList<TransOrder>();

		TransOrder ord = new TransOrder();
		ord.setId(UUID.randomUUID().toString().substring(8));
		ord.setCheckId("check"+UUID.randomUUID().toString().substring(10));
		ord.setOptimistic(0);
		ord.setPayInterface("48381000");
		ord.setTransAmount(2000d);
		ord.setTransTime(new Date());
		lst.add(ord);

		ord = new TransOrder();
		ord.setId(UUID.randomUUID().toString().substring(8));
		ord.setCheckId("check"+UUID.randomUUID().toString().substring(10));
		ord.setOptimistic(0);
		ord.setPayInterface("48382000");
		ord.setTransAmount(3000d);
		ord.setTransTime(new Date());
		lst.add(ord);

		int result = transOrderService.batchInsertTransOrder(lst);
		logger.info("## batchInsert TransOrder Result: {}",result);
	}
}
