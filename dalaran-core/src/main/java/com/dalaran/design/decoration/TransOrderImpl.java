package com.dalaran.design.decoration;

public class TransOrderImpl implements TransOrderInterface {

	@Override
	public void parseFile() {
		System.out.println("base parseFile method.");
	}

	@Override
	public void downloadFile() {
		System.out.println("base downloadFile method.");
	}

}
