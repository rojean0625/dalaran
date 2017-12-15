package com.dalaran.api.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dalaran.api.BankOrderInterface;
import com.dalaran.mq.RojeanProducer;

@Service("bankOrderInterface")
public class BankOrderInterfaceImpl implements BankOrderInterface{

	private Logger logger = LoggerFactory.getLogger(BankOrderInterfaceImpl.class);

	//@Resource
	private RojeanProducer producer;

	@Override
	public String getBankOrderInvalidate(String bankFlowId) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = fmt.format(new Date());
			//MQ
			//producer.sendMessage("dalaran-core bankOrderInterfaceImpl Create Log : "+ time);
			System.out.println("dalaran-core : put");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return "dubbo Succ !";
	}

}
