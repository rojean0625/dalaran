package com.dalaran.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.com.caucho.hessian.io.JavaSerializer;
import com.dalaran.annot.CacheAnt;
import com.dalaran.context.RedisCacheConfig;
import com.dalaran.dao.TableDao;
import com.dalaran.model.TransOrder;
import com.dalaran.service.TableService;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
/**
 * 定义连接点  JoinPoint
 * @author Administrator
 *
 */
@Service("tableService")
public class TableServiceImpl implements TableService {

	@Resource
	private TableDao tableDao;

	//@Resource
	private RedisCacheConfig config;

	/**
	 * 连接点（joinpoint）
	 */
	@Override
	public void updateTable(String[] args) {
		System.out.println("TableServiceImpl。updateTable 执行更新数据操作  update table set ..");
	}

	@CacheAnt(modelName="tableDao")
	@Override
	public List<String> findByMap(Map<String, String> map) {
		TransOrder ord = new TransOrder();
		ord.setId("code01");
		ord.setCheckId("chk001");
		ord.setOptimistic(0);
		ord.setPayInterface("payinterface001");
		ord.setTransAmount(5500);
		ord.setTransTime(new Date());

		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Output output = new Output(stream);
		kryo.writeClassAndObject(output, ord);
		output.flush();
		output.close();

		byte[] dt = stream.toByteArray();

		JedisPool pool = config.getRedisConnection();
		Jedis jedis = pool.getResource();
		jedis.set("k".getBytes(), dt);
		System.out.println("######### Redis ###########");

		System.out.println(new String(dt));

		ByteArrayInputStream bais = new ByteArrayInputStream(dt);
	    Input input = new Input(bais);
	    TransOrder o = (TransOrder) kryo.readClassAndObject(input);

	    System.out.println(o.getTransAmount());
		System.out.println("tableDao findByMap  " + dt.length);
		return tableDao.findByMap(map);

	}

}
