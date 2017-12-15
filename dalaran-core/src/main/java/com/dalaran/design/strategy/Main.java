package com.dalaran.design.strategy;

import com.dalaran.enumb.RechargeType;

public class Main {
	public static void main(String[] args) {
		Context ctx = new Context();
		double fee = ctx.getFee(RechargeType.CHANNEL_OFFLINE);
		System.out.println(fee);
	}
}
