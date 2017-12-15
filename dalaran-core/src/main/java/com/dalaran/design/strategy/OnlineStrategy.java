package com.dalaran.design.strategy;

public class OnlineStrategy implements Strategy {

	@Override
	public double fee() {
		return 0.85;
	}

}
