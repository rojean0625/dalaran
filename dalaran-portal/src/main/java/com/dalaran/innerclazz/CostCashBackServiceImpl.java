package com.dalaran.innerclazz;

public class CostCashBackServiceImpl {

	private String camplainCode = "HDBH-20180302173652";

	/**
	 * 记录  推荐服务商，核心服务商 信息
	 */
	public void recordCostDiff(){
		System.out.println("recordDiff");
	}

	/**
	 * 记录  推荐服务商当日交易总金额
	 */
	public void recoredTransSum(){

	}


	class CashBack{
		public void cashBackTask(){
			System.out.println("cashBackTask" + camplainCode);
		}
	}

	static class CashBack2{
		public void cashBackTask2(){
			System.out.println("static cashBackTask2");
		}
	}
}
