package com.dalaran.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	private void show(String v){
		System.out.println("show " + v);
	}

	public static void main(String[] args){
		List<String> codeList = new ArrayList<String>();
		codeList.add("agent01");
		codeList.add("agent02");
		codeList.add("core01");

		List<String> result = codeList.stream().filter(v -> v.contains("agent")).collect(Collectors.toList());
		Optional.ofNullable(result).ifPresent(v ->{
			new Main().show(result.get(0));
		});

	}





















}
