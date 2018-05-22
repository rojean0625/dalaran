package com.dalaran.genericity;

public class Plate<T> {

	public T item;

	public Plate(T t){
		item = t;
	}

	public T getPlate(){
		return item;
	}

	public void setPlate(T t){
		item = t;
	}
}
