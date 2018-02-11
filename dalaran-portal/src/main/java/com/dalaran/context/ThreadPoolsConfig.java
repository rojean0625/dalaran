package com.dalaran.context;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/threadpools.properties")
public class ThreadPoolsConfig {
	// 1
	@Value("${threadPool.name}")
	private String threadPoolName;

	@Value("${threadPool.threadNum}")
	private Integer threadPoolThreadNum;// 线程数

	@Value("${threadPool.keepAliveTime}")
	private Long threadPoolKeepAliveTime;// 多余的空闲线程等待time

	@Value("${threadPool.capacity}")
	private Integer threadPoolCapacity;// 队列初始容量

	// 2
	@Value("${threadPool2.name}")
	private String noticeThreadPoolName;

	@Value("${threadPool2.fixedNum}")
	private Integer noticeThreadPoolFixedNum;


	@Bean
	public Map<String, Executor> poolsMap() {
		return new HashMap<String, Executor>();
	}

	@Bean
	public ThreadPoolExecutor threadPool() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				threadPoolThreadNum, threadPoolThreadNum,
				threadPoolKeepAliveTime, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(threadPoolCapacity),
				new ThreadPoolExecutor.CallerRunsPolicy());
		this.poolsMap().put(threadPoolName, executor);
		return executor;
	}

	@Bean
	public ExecutorService noticeThreadPool() {
		ExecutorService es = Executors.newFixedThreadPool(noticeThreadPoolFixedNum);
		this.poolsMap().put(noticeThreadPoolName, es);
		return es;
	}
}
