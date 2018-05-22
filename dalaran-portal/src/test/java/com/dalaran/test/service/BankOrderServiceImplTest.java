package com.dalaran.test.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.taglibs.standard.lang.jstl.Constants;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.dalaran.context.RedisCacheConfig;
import com.dalaran.model.TransOrder;
import com.dalaran.service.TableService;
import com.dalaran.test.context.BaseTest;

public class BankOrderServiceImplTest extends BaseTest {

	//@Resource
	//private BankOrderService bankOrderService;

	@Resource
	TableService tableService;

	@Resource
	private RedisCacheConfig config;

	@Test
	public void testA(){
		System.out.println("testA");
		//tableService.updateTable(new String[]{"a","c"});

		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("code", "123");
		tableService.findByMap(queryMap);

	}





	public void testQueryBankOrderByCheckId(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("checkId", "checkId001");
		TransOrder ord = null;// bankOrderService.findByCheckId(map);
		System.out.println("ORD INFO: "+ord.getCheckId() + " " + ord.getTransAmount());
	}


}
