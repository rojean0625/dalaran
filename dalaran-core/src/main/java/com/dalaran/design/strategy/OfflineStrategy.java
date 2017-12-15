package com.dalaran.design.strategy;

public class OfflineStrategy implements Strategy {

	@Override
	public double fee() {
		return 0.90;
	}

}
