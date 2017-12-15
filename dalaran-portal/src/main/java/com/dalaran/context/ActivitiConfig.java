package com.dalaran.context;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

public class ActivitiConfig {

	@javax.annotation.Resource
	private DataSource dataSource;

//	@Bean
//	public SpringProcessEngineConfiguration processEngineConfiguration(){
//
//		return null;
//	}
}
