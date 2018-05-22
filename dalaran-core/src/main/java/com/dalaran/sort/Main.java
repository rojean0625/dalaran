package com.dalaran.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args){

		int[] arr = new int[]{7,1,5,3};
		List<Integer> lst  = Arrays.stream(arr). boxed().collect(Collectors.toList());
		Collections.sort(lst, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		});
		lst.stream().forEach(v -> System.out.println(v));

		double[] doubleArr = new double[]{11.0,8.0,13.0,2.0};
		for(int i=0;i<doubleArr.length-1;i++){
			for(int j=0;j<doubleArr.length -1 -i;j++){
				if(doubleArr[j]>doubleArr[j+1]){
					double temp =  doubleArr[j];
					doubleArr[j] = doubleArr[j+1];
					doubleArr[j+1] = temp;
				}
			}
		}
		Arrays.stream(doubleArr).forEach(v -> System.out.println(v));
	}

}
