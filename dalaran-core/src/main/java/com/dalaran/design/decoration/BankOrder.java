package com.dalaran.design.decoration;

public abstract class BankOrder implements TransOrderInterface {

	private final TransOrderInterface transOrderInterface;

	public BankOrder(TransOrderInterface transOrderInterface){
		super();
		this.transOrderInterface = transOrderInterface;
	}

	@Override
	public void parseFile() {
		this.transOrderInterface.parseFile();
	}

	@Override
	public void downloadFile() {
		this.transOrderInterface.downloadFile();
	}

}
