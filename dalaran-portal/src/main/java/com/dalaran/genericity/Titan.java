package com.dalaran.genericity;

public class Titan<T> {

	public <T extends Fruit>  void methodA(T t){
		System.out.println("titan system out print" + t);
	}
}
