package com.dalaran.test.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.dalaran.model.TransOrder;
import com.dalaran.service.TableService;
import com.dalaran.test.context.BaseTest;

public class BankOrderServiceImplTest extends BaseTest {

	//@Resource
	//private BankOrderService bankOrderService;

	@Resource
	TableService tableService;

	@Test
	public void testA(){
		System.out.println("x");
		tableService.updateTable(new String[]{"a","c"});

	}
	public void testQueryBankOrderByCheckId(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("checkId", "checkId001");
		TransOrder ord = null;// bankOrderService.findByCheckId(map);
		System.out.println("ORD INFO: "+ord.getCheckId() + " " + ord.getTransAmount());
	}


}
