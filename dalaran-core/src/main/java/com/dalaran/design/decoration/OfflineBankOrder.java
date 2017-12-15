package com.dalaran.design.decoration;

public class OfflineBankOrder extends BankOrder {

	public OfflineBankOrder(TransOrderInterface transOrderInterface) {
		super(transOrderInterface);
	}

	public void revoke(){
		System.out.println("revoke");
	}

	@Override
	public void downloadFile(){
		revoke();
		super.downloadFile();
	}
}
