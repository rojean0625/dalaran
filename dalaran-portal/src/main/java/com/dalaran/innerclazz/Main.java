package com.dalaran.innerclazz;

public class Main {

	private void callAnonymous(IQuery iquery){

	}

	public static void main(String[] args) {
		CostCashBackServiceImpl service = new CostCashBackServiceImpl();
		CostCashBackServiceImpl.CashBack innerClazz = service.new CashBack();
		innerClazz.cashBackTask();


		new StringBuffer("x").append("");
		new CostCashBackServiceImpl.CashBack2().cashBackTask2();

		new Main().callAnonymous(new IQuery(){
			@Override
			public void ini() {

			}
		});


		new Thread(new Runnable(){
			@Override
			public void run() {

			}
		}).run();




		String info = "HDBH-100200300";
		StringBuilder b = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		sb.append("x");
	}

}
