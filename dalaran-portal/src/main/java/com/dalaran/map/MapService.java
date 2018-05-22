package com.dalaran.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MapService {


	public static void main(String[] args) throws ParseException {

		String[] arr = {"a","b","c","d","e","f"};
		String[] arr2 = {"1","2","3","4","5","6"};
		System.arraycopy(arr, 3, arr, 2,3);

		System.out.println(Arrays.asList(arr));

		List lst = new LinkedList();
		lst.add("a");
		lst.add("b");
		lst.add(1, "c");
//		lst.get(0);
//		lst.remove("0");

		System.out.println(lst);
//
//		Dt d1 = new Dt("k1");
//		Dt d2 = new Dt("k2");
//
//		Dt d = d1;
//		d1 = d2;
//		System.out.println(d1.getKey());















	}

}
