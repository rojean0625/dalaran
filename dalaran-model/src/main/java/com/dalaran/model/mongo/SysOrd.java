package com.dalaran.model.mongo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sysord")
public class SysOrd implements Serializable {

	private String id;

	private String systemFlowId;

	private double sysAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemFlowId() {
		return systemFlowId;
	}

	public void setSystemFlowId(String systemFlowId) {
		this.systemFlowId = systemFlowId;
	}

	public double getSysAmount() {
		return sysAmount;
	}

	public void setSysAmount(double sysAmount) {
		this.sysAmount = sysAmount;
	}


}
