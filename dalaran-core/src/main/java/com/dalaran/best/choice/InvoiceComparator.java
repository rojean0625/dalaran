package com.dalaran.best.choice;

import java.util.Comparator;

import com.dalaran.model.Invoice;

public class InvoiceComparator implements Comparator<Invoice> {

	@Override
	public int compare(Invoice o1, Invoice o2) {
		// 返回正数 比较式 左边的放到数组靠后位置
		if(o1.getInvoiceAmt() < o2.getInvoiceAmt()){
			return 1;
		}

		if(o1.getInvoiceAmt() > o2.getInvoiceAmt()){
			return -1;
		}
		return 0;
	}

}
