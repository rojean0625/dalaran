package com.dalaran.design.strategy;

import java.util.HashMap;
import java.util.Map;

import com.dalaran.enumb.RechargeType;

public class StrategyFactory {

	private static Map strategyMap = new HashMap();

	private static StrategyFactory factory = new StrategyFactory();

	static{
		strategyMap.put(RechargeType.CHANNEL_ONLINE.getKeyName(), new OnlineStrategy());
		strategyMap.put(RechargeType.CHANNEL_OFFLINE.getKeyName(), new OfflineStrategy());
	}


	public Strategy create(String type){
		return (Strategy)strategyMap.get(type);
	}

	public static StrategyFactory getInstance(){
		return factory;
	}
}
