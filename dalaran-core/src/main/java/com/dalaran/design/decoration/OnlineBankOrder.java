package com.dalaran.design.decoration;

public class OnlineBankOrder extends BankOrder {

	public OnlineBankOrder(TransOrderInterface transOrderInterface) {
		super(transOrderInterface);
	}


	public void notice(){
		System.out.println("Send Wechat Notice.");
	}


	@Override
	public void downloadFile(){
		notice();
		super.downloadFile();
	}
}
