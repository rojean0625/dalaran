package com.dalaran.design.strategy;

import com.dalaran.enumb.RechargeType;

public class Context {

	private Strategy strategy;

	double getFee(RechargeType type){
		strategy = (Strategy)StrategyFactory.getInstance().create(type.getKeyName());
		return strategy.fee();
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

}
