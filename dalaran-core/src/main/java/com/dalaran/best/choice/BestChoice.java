package com.dalaran.best.choice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dalaran.model.Invoice;

public class BestChoice {

	public static void main(String[] args) {

		Invoice v1 = new Invoice();
		v1.setId("1");
		v1.setInvoiceAmt(550);

		Invoice v2 = new Invoice();
		v2.setId("2");
		v2.setInvoiceAmt(780);

		Invoice v3 = new Invoice();
		v3.setId("3");
		v3.setInvoiceAmt(800);

		Invoice v4 = new Invoice();
		v4.setId("4");
		v4.setInvoiceAmt(2000);

		List<Invoice> list = new ArrayList<Invoice>();
		list.add(v1);
		list.add(v4);
		list.add(v3);
		list.add(v2);
		Collections.sort(list, new InvoiceComparator());
		double finalAmt = 3500.00;
		double wallet = 0.0;
		System.out.println("需要拿：￥"+finalAmt);
		Map<String,Object> noteMap = new LinkedHashMap<String,Object>();
		for(Invoice bean:list){
			double amt = bean.getInvoiceAmt();
			// 没装满继续装
			if(wallet < finalAmt){
				//本次拿出的金额 < 要总共拿的金额
				if(amt < finalAmt){
					//判断钱包满了没有
					if(wallet + amt < finalAmt){
						wallet = wallet + amt;
						System.out.println("从发票："+bean.getId() + " - 拿了  ￥"+amt+" - 目前拿了:" + wallet);
						noteMap.put(bean.getId(), amt);
					}else{
						// 要拿的钱  减去   钱包已经装的钱
						double willGet = finalAmt - wallet;
						// 放入钱包
						wallet = wallet + willGet;
						double balance = amt - willGet;
						System.out.println("从发票："+bean.getId() + " - 拿了  ￥"+ willGet+ " 再放回去  ￥"+ balance +" - 目前拿了:" + wallet);
						noteMap.put(bean.getId(), willGet);
					}
				}else{
					double willGet = finalAmt;
					// 放入钱包
					wallet = wallet + willGet;
					double balance = amt - willGet;
					System.out.println("从发票："+bean.getId() + " - 拿了  ￥"+willGet+" - 再放回去 ￥"+ balance+" - 目前拿了:" + wallet + "一次拿够了");
					noteMap.put(bean.getId(), willGet);
				}
			}//End
		}//

		System.out.println("##########最终拾取记录###########");
		System.out.println(noteMap.toString());
	}

}
