package com.dalaran.lambda;

public class BillResponse {
	private String objID;
	private int count;
	public String getObjID() {
		return objID;
	}
	public void setObjID(String objID) {
		this.objID = objID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public BillResponse(){}
	public BillResponse(String id,int count){
		this.objID = id;
		this.count = count;
	}
}
