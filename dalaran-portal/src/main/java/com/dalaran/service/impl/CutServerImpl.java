package com.dalaran.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.core.task.support.ExecutorServiceAdapter;

public class CutServerImpl {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(new AtomicLong().getAndIncrement());
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<String> futrue = pool.submit(new X());
		System.out.println("1" + futrue.isDone());
		System.out.println("2");

		while(true){
			if(futrue.isDone()){
				System.out.println("true");
				System.out.println(futrue.get());
				break;
			}
		}
		System.out.println("complete");

	}

}
