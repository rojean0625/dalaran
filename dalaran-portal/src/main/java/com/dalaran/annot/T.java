package com.dalaran.annot;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class T {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {

//		Mediven m = new Mediven();
//		// Method method = m.getClass().getMethod("sheep", null);
//	    // method.invoke(null, null);
//		Field field = m.getClass().getDeclaredField("ip");
//		Kenruito a = field.getAnnotation(Kenruito.class);
//		System.out.println(a.code());


		Class<?> o = Class.forName("com.dalaran.annot.Mediven");
		Object instance = o.newInstance();
		instance.getClass();
		Field field = instance.getClass().getDeclaredField("ip");
		field.setAccessible(true);
		field.set(instance, "127.0.0.1");

		System.out.println(field.get(instance));
		System.out.println(instance.getClass().getName());

		Method m = instance.getClass().getMethod("sheep", null);
		m.invoke(instance, null);


	}



}
