package com.dalaran.mq;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;

public class RojeanProducer {

	private Logger logger = LoggerFactory.getLogger(RojeanProducer.class);
	private final DefaultMQProducer producer;
	private String topic;


	public RojeanProducer(DefaultMQProducer producer){
		this.producer = producer;
	}

	public void sendMessage(String msg) throws Exception{
		Message message = new Message();
		message.setTopic(topic);
		message.setTags("Tag");
		message.setBody(msg.getBytes(Charset.forName("UTF-8")));

		try {
			SendResult sendResult = this.producer.send(message);
			if(SendStatus.SEND_OK == sendResult.getSendStatus() ){

			}else{

			}
			logger.info("Rojean MQ Send: {} -  SendStatus: {}",msg,sendResult.getSendStatus());
		} catch (Exception e) {
			throw new Exception("");
		}
	}




	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}






}
