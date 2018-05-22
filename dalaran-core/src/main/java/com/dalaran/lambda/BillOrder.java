package com.dalaran.lambda;

import java.util.List;

public class BillOrder {

	private String billId;
	private List<BillDetail> detail;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public List<BillDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<BillDetail> detail) {
		this.detail = detail;
	}

}
