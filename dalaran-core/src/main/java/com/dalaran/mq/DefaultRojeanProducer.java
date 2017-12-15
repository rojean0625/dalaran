package com.dalaran.mq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

public class DefaultRojeanProducer {

	private DefaultMQProducer mqproduct;

	public DefaultRojeanProducer(){
		mqproduct = new DefaultMQProducer("rmq-group");
		mqproduct.setNamesrvAddr("127.0.0.1:9876");
		mqproduct.setInstanceName("rmq-instance");
	}

	public void start() throws MQClientException{
		mqproduct.start();
	}


	public void shutdown(){
		if(mqproduct != null){
			mqproduct.shutdown();
		}
	}

	public RojeanProducer createProducer(String topic){
		RojeanProducer producer = new RojeanProducer(this.mqproduct);
		producer.setTopic(topic);
		return producer;
	}
}
