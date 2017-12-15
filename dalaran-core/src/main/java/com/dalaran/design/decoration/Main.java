package com.dalaran.design.decoration;

public class Main {

	public static void main(String[] args) {
		//基础实现
		TransOrderInterface interfaceOrd = new TransOrderImpl();
		interfaceOrd = new OnlineBankOrder(interfaceOrd);
		interfaceOrd.downloadFile();
		System.out.println("------------------");
		// 重置基础实现
		interfaceOrd = new TransOrderImpl();
		interfaceOrd= new OfflineBankOrder(interfaceOrd);
		interfaceOrd.downloadFile();
	}

}
