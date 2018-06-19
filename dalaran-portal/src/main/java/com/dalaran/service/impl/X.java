package com.dalaran.service.impl;

import java.util.concurrent.Callable;

public class X implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return "x";
	}

}
