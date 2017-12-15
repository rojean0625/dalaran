package com.dalaran.busiExcp;

public class SpringUncheckException extends Exception {

	private static final long serialVersionUID = 6099771732724694312L;

	private String errorCode = "UnCheck-Exception";

	public SpringUncheckException() {
		super("抛出 SpringUncheckException ！");
	}

	public SpringUncheckException(String message) {
		super("抛出 SpringUncheckException ！");
	}
}
