package com.dalara.gson;

import java.util.HashMap;
import java.util.Map;

import com.dalaran.model.Invoice;
import com.google.gson.Gson;

public class GsonMain {

	public static void main(String[] args) {

		Gson gson = new Gson();

		// Bean To Json
		Invoice inv = new Invoice();
		inv.setId("IN1001");
		inv.setOptimistic(0);
		inv.setInvoiceCode("111001776061");
		inv.setInvoiceNum("18656063");
		inv.setInvoiceDate("2017-11-09");
		inv.setTaxId("110192562134916");
		inv.setInvoiceAmt(52.80d);
		String invoiceStr = gson.toJson(inv);
		System.out.println(invoiceStr);

		// Json to Bean
		Invoice bean = gson.fromJson(invoiceStr, Invoice.class);
		System.out.println(bean.getId());

		// Map to Json
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "value");
		String mapString = gson.toJson(map);
		System.out.println(mapString);

		//List to Json

	}

}
