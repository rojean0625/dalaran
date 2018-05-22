package com.dalaran.context;

import java.util.Queue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T {

	private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	class innerClass{

		private boolean flag = false;
		void ini(){
			//queue.add("elements1");
			//queue.add("elements2");
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 ScheduledExecutorService e = Executors.newScheduledThreadPool(2);
		 ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

		 e.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					try {
						queue.put("e");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("## Put elements.");
			}

		 }, 0, 2, TimeUnit.SECONDS);


		 e.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				try {
					System.out.println("## Get elements." + queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}}, 0, 5, TimeUnit.SECONDS);
	}


}
