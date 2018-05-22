package com.dalaran.data.construct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

import org.jboss.netty.util.internal.ConcurrentHashMap;

public class DataConstructMain {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(1);
		list.add(5);
		Collections.sort(list,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		list.forEach(v->System.out.println(v));

		Queue<String> queue = new ConcurrentLinkedQueue<String>();
	}

}
