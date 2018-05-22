package com.dalaran.create.obj;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateService {


	public <T> Map<String,Method> getBeanMethods(Class<T> clazz){
		Map<String,Method> methodsMap = Stream.of(clazz.getDeclaredMethods()).filter(method->method.getName().startsWith("get"))
		.collect(Collectors.toMap(Method::getName,method->method));
		return  methodsMap;
	}
}
