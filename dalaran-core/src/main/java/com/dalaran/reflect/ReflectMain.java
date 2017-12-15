package com.dalaran.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.dalaran.model.Invoice;

public class ReflectMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?> classT = Invoice.class;

		// All Method
		Method[] methods = classT.getMethods();
		System.out.println("## Method List");
		for(Method method:methods){
			System.out.println(method.getName());
		}

		// All Public fields
		Field[] fields =  classT.getDeclaredFields();
		System.out.println("## Fields List");
		for(Field field:fields){
			System.out.println(field.getType()+"  " +field.getName());
		}

		// New Instance
		Object obj = classT.newInstance();
		// SetParameter
		Method targetMethod = classT.getMethod("setInvoiceCode",String.class);
		targetMethod.invoke(obj, "20171121");
		// invoke targetMethod
		targetMethod = classT.getMethod("chekInvoice",null);
		targetMethod.invoke(obj);
	}

}
