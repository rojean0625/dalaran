package com.dalaran.enumb;

public enum RechargeType {

	CHANNEL_ONLINE("ONLINE",0.85),
	CHANNEL_OFFLINE("OFFLINE",0.90);

	private String keyName;
	private double fee;

	private RechargeType(String key,double fee){
		this.keyName = key;
		this.fee = fee;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
