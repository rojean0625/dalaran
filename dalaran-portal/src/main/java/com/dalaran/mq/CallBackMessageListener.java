package com.dalaran.mq;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.dalaran.context.RedisCacheConfig;


@Component
public class CallBackMessageListener implements MessageListener {

	//#@Resource
	private RedisCacheConfig config;

	@Override
	public void onMessage(String message) {
		String info = message;
		System.out.println("dalaran-portal : get " + info);
		JedisPool pool = config.getRedisConnection();
		Jedis jedis = pool.getResource();
		jedis.set("dalaranLog",info);
		System.out.println("write redis succ");
	}


}
