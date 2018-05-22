package com.dalaran.absandinter;

public abstract class AbsBill implements IBill {

	void handle(){
		System.out.println("Abs Bill Handle");
		doHandle();
	}
}
