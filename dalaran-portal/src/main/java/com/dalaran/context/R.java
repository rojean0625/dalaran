package com.dalaran.context;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class R {

	WeakReference<String> key = new WeakReference<String>(null);

	public static void main(String[] args){

		int a = 1;
		int b = a ++;
		System.out.println(a);
		System.out.println(b);

		System.out.println();

		int aa = 1;
		int bb = ++ aa;
		System.out.println(aa);
		System.out.println(bb);


		Map<String,String> map = new HashMap<String,String>();
		map.put("", null);
		map.get("");
	}
}
