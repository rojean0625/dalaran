package com.dalaran.genericity;

import java.util.ArrayList;
import java.util.List;

public class ExecService {

	public static void main(String[] args) {

		Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());

		p1.setPlate(null);

		Fruit fruit = p1.getPlate();
		Object obj = p1.getPlate();
		// Apple apple = p1.getPlate(); error
		// 编译器只知道容器内是 Fruit 和  其 衍生类，并不知道具体类型，所以无法准确转换类型

		Plate<? super Fruit> p2 = new Plate<Food>(new Food());

		p2.setPlate(new Fruit());
		p2.setPlate(new Apple());

		Object obj2 = p2.getPlate();
		Apple ap = (Apple)obj2;
		System.out.println(ap);

		// 总结
		// <? extends T> 上界,无法存,方便取
		// <? super T> 下界，方便存，object 取


		Titan<Apple> titan = new Titan<Apple>();
		titan.methodA(new Banana());

		List<?> listA = new ArrayList<String>();
		List<? extends Object> listObj = new ArrayList<String>();
		List<Object> listC = new ArrayList<Object>();
		listC.add("x");
		listC.get(0);
	}

}
