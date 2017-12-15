package com.dalaran.busiExcp;


public class SpringCheckException extends Exception {

	private static final long serialVersionUID = 911368254165326094L;

	private String errorCode = "Check-Exception";

	public SpringCheckException() {
		super("抛出 SpringCheckException 异常！");
	}

	public SpringCheckException(String msg) {
		super(msg);
	}
}
