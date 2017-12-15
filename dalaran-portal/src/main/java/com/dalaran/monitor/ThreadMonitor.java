package com.dalaran.monitor;

import java.util.Map;
import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//Component
public class ThreadMonitor {

	private Logger monitorLog = LoggerFactory.getLogger(ThreadMonitor.class);

	//@Resource
	private Map<String, Executor> poolsMap;

	//@Scheduled(cron="${threadMonitor.cron}")
	public void execute(){
		for (String  threadName: poolsMap.keySet()) {
			monitorLog.info(String.format("ThreadPoolName=%s state={%s}", threadName, poolsMap.get(threadName).toString()));
        }
	}
}
