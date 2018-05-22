package com.dalaran.create.obj;

import java.lang.reflect.Method;
import java.util.Optional;

import com.dalaran.lambda.BillOrder;

public class MainT {

	public static <T> T createBean(Class<T> clazz) throws InstantiationException, IllegalAccessException{
		return clazz.newInstance();
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		BillOrder order = (BillOrder) Class.forName("com.dalaran.lambda.BillOrder").newInstance();
		System.out.println(order);

		BillOrder ord = MainT.createBean(BillOrder.class);
		ord.setBillId("billId0001");

		CreateService service = new CreateService();
		Optional.ofNullable(service.getBeanMethods(ord.getClass())).ifPresent(map->{
			Method method = map.get("getBillId");
			try {
				Object obj = method.invoke(ord, null);
				System.out.println("Exec: " + obj.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


	}

}
