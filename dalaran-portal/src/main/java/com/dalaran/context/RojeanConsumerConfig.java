package com.dalaran.context;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.dalaran.mq.CallBackMessageListener;
import com.dalaran.mq.DefaultRojeanConsumer;

@Configuration
@PropertySource("classpath:/rojean-consumer.properties")
public class RojeanConsumerConfig {
	@Resource
	private CallBackMessageListener callbackMessageListener;

	@Value("${com.dalaran.test1.topic}")
	private String topic;

	@Bean(name="rojeanCustomer",initMethod="start",destroyMethod="shutdown")
	public DefaultRojeanConsumer defaultProducer(){
		System.out.println("#### Spring Root Customer.");
		// 1
		DefaultRojeanConsumer atConsumer = new DefaultRojeanConsumer();
		try {
			// 2
			atConsumer.subscribe(topic, callbackMessageListener);
		} catch (MQClientException e) {
			e.printStackTrace();
		}
		// 3
		return atConsumer;
	}

}
