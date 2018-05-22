package com.dalaran.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class LambdaThread {

	public static void main(String[] args){
		// new Thread
		new Thread(() ->  System.out.println("1. This is Lambda Thread Method.")).start();

		//Iterator Collection
		List<String> list =  Arrays.asList("10.0","20.0","30.0");
		String[] arr = new String[1];
		StringBuffer strBufferA = new StringBuffer();
		list.forEach(v ->strBufferA.append("-").append(v));
		System.out.println("2. Lambda iterator list: "+strBufferA.substring(1));
		// Map

		// Reduce
		List<Integer> intList = Arrays.asList(1,7,5,2,4);
		int result = intList.stream().reduce((sum,x) -> sum+x).get();
		System.out.println("3. Reduce Sum: "+result);

		// Filter

		List<Integer> filterList = Arrays.asList(30,50,20,44);
		List<Integer> resultList = filterList.stream().filter(douV -> douV>30).collect(Collectors.toList());
		resultList.forEach(v -> System.out.println(v));

		//Predicate

		// toArray(Integer[]::new);
		// collect(Collectors.toList());
		// limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素
		// 第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素。这个方法返回值类型是Optional
		// allMatch：Stream 中全部元素符合传入的 predicate，返回 true
		// anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
		// noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true

		System.out.println("##### Fill Date in List #####");
		List<BillResponse> response = new ArrayList<BillResponse>();
		response.add(new BillResponse("OID001",1));
		response.add(new BillResponse("OID002", 2));
		response.add(null);

		BillOrder order = new BillOrder();
		order.setDetail(response.stream().map(bean->{
			BillDetail detail = new BillDetail();
			return detail;
		}).collect(Collectors.toList()));

		System.out.println("elements size:"+order.getDetail().size());


		Optional.ofNullable(response.get(0)).ifPresent(v -> System.out.println(v.getObjID()));
		Optional.ofNullable(response.get(2)).ifPresent(v -> System.out.println(v.getObjID()));

		Map<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("K", "V");

		Optional o = Optional.ofNullable(dataMap.get("K"));
		o.ifPresent(v->{System.out.println(v);});


	}
}
