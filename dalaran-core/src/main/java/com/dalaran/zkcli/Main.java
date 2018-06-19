package com.dalaran.zkcli;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		ZkCliServiceImpl serv = new ZkCliServiceImpl();
		serv.create();

		Map<String,String> map = new HashMap<String,String>();
		map.put("", null);
		map.get("");

	}

}
