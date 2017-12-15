package com.dalaran.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

public class DefaultRojeanConsumer {

	// primal
	private DefaultMQPushConsumer consumer;
	private RojeanMessageListenerConcurrently messageListener;

	public DefaultRojeanConsumer(){
		System.out.println("## initial");
		this.consumer = new DefaultMQPushConsumer();
		this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		this.messageListener = new RojeanMessageListenerConcurrently();
	}


	public void start(){
		System.out.println("## start");
		try{
			this.consumer.setConsumerGroup("rmq-group");
			this.consumer.setNamesrvAddr("127.0.0.1:9876");
			// this.consumer.setInstanceName("rmq-instance");
			// this.consumer.subscribe("test1", "TagA");
	        this.consumer.registerMessageListener(messageListener);
	        this.consumer.start();
	        System.out.println("initial mq succ");
		}catch(Exception e){

		}
	}

	public void shutdown() {
		System.out.println("### shutdown");
		if(this.consumer != null){
			this.consumer.shutdown();
		}
	}


	public void subscribe(String topic, final MessageListener listener) throws MQClientException {
		this.consumer.subscribe(topic, "*");
		this.messageListener.registerMessageListener(topic, listener);
	}
}
