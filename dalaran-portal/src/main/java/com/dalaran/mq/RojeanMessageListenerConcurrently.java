package com.dalaran.mq;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
public class RojeanMessageListenerConcurrently implements MessageListenerConcurrently{

	private final Map<String, MessageListener> listeners = new HashMap<String, MessageListener>();

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,ConsumeConcurrentlyContext context) {
		int i = 0;
		for(MessageExt msg : msgs){
			try {
				this.onMessage(msg.getTopic(), msg);
			} catch (Exception e){
				System.out.println("msgId="+msg.getMsgId());
				context.setAckIndex(i);
				return ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}
			i++;
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

	private void onMessage(String topic, MessageExt msg) throws Exception{
		String message = new String(msg.getBody());
		boolean findTopic = false;
		for(Entry<String, MessageListener> entry : this.listeners.entrySet()){
			if(entry.getKey().equals(topic)){
				findTopic = true;
				// callBack
				entry.getValue().onMessage(message);

			}
		}
		if(!findTopic) {
			throw new Exception("No topic listener find for " + topic);
		}
	}

	public void registerMessageListener(String topic, MessageListener listener) {
		System.out.println("regist Listener ！");
		MessageListener old = listeners.put(topic, listener);
		if(old != null) {
			System.out.println("Listener with topic {} is override" + topic);
		}
	}
}
