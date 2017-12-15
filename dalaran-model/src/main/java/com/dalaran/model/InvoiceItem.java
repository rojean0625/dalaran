package com.dalaran.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("invoiceItem")
public class InvoiceItem extends BaseVO {

	private String itemName;
	private double price;
	private int count;
	private double amt;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
}
