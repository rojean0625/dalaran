package com.dalaran.model;

import java.util.Date;

public class TransOrder extends BaseVO {

	private static final long serialVersionUID = -8802851044570359047L;

	/** 付款接口 */
	private String payInterface;
	/** 核对流水号 */
	private String checkId;
	/** 交易金额 */
	private double transAmount;
	/** 银行交易时间 */
	private Date transTime;

	public TransOrder(){}

	public String getPayInterface() {
		return payInterface;
	}
	public void setPayInterface(String payInterface) {
		this.payInterface = payInterface;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
}
