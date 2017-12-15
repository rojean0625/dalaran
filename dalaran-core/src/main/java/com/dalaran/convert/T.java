package com.dalaran.convert;

import java.util.ArrayList;
import java.util.List;

import com.dalaran.model.Invoice;
import com.dalaran.model.InvoiceItem;
import com.thoughtworks.xstream.XStream;
/**
 * XStream 序列和反序列化
 * @author Administrator
 *
 */
public class T {

	private String beanSerializable(){
		XStream xs = new XStream();
		xs.autodetectAnnotations(true);

		Invoice inv = new Invoice();
		inv.setId("IN1001");
		inv.setOptimistic(0);
		inv.setInvoiceCode("111001776061");
		inv.setInvoiceNum("18656063");
		inv.setInvoiceDate("2017-11-09");
		inv.setTaxId("110192562134916");
		inv.setInvoiceAmt(52.80d);

		List<InvoiceItem> items = new ArrayList<InvoiceItem>();
		InvoiceItem item = new InvoiceItem();
		item.setAmt(32.80d);
		item.setCount(1);
		item.setItemName("办公用品");
		items.add(item);

		item = new InvoiceItem();
		item.setAmt(30.00d);
		item.setCount(1);
		item.setItemName("鼠标");
		items.add(item);

		inv.setItems(items);
		return xs.toXML(inv);
	}

	private Invoice beanDeserializable(String xml){
		XStream xs = new XStream();
		xs.processAnnotations(Invoice.class);
		xs.processAnnotations(InvoiceItem.class);
		return  (Invoice) xs.fromXML(xml);
	}

	public static void main(String[] args) {
		T main = new T();
		// serializable
		String xml = main.beanSerializable();
		System.out.println(xml);
		// deserializable
		Invoice invoice = main.beanDeserializable(xml);
		System.out.println(invoice.getId());
	}

}
