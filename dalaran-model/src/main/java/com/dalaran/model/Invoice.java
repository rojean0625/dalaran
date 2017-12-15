package com.dalaran.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("invoice")
public class Invoice{
	// 作为属性
	@XStreamAsAttribute
	private String id;
	//忽略节点
	@XStreamOmitField
	private int optimistic;

	private String invoiceCode;

	private String invoiceNum;

	private String invoiceDate;

	private String taxId;

	private double invoiceAmt;

	//忽略父节点，变更子节点别名
	//@XStreamImplicit(itemFieldName="item")
	private List<InvoiceItem> items;

	public Invoice(){}
	public void chekInvoice(){
		System.out.println("do inCheck - " + this.getInvoiceCode());
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getOptimistic() {
		return optimistic;
	}
	public void setOptimistic(int optimistic) {
		this.optimistic = optimistic;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(double invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	public List<InvoiceItem> getItems() {
		return items;
	}
	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}


}
