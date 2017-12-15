package com.dalaran.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dalaran.best.choice.InvoiceComparator;
import com.dalaran.model.Invoice;

public class SortInvoiceList {

	public static void main(String[] args) {
		List<Invoice> arr = new ArrayList<Invoice>();
		Invoice v1 = new Invoice();
		v1.setId("1");
		v1.setInvoiceAmt(1);
		arr.add(v1);

		Invoice v2 = new Invoice();
		v2.setId("2");
		v2.setInvoiceAmt(7);
		arr.add(v2);

		Invoice v = new Invoice();
		v.setId("8");
		v.setInvoiceAmt(4);
		arr.add(v);

		Invoice v4 = new Invoice();
		v4.setId("4");
		v4.setInvoiceAmt(5);
		arr.add(v4);

		for(Invoice bean:arr){
			System.out.println(bean.getInvoiceAmt());
		}
		System.out.println("#");
		Collections.sort(arr, new InvoiceComparator());
		for(Invoice bean:arr){
			System.out.println(bean.getInvoiceAmt());
		}
	}

}
