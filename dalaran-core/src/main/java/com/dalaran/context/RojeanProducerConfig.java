package com.dalaran.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dalaran.mq.DefaultRojeanProducer;
import com.dalaran.mq.RojeanProducer;

@Configuration
@PropertySource("classpath:/rojean-producer.properties")
public class RojeanProducerConfig {

	@Value("${com.dalaran.test1.topic}")
	private String topic;

	@Bean(name = "defaultRojeanProducer", initMethod = "start", destroyMethod = "shutdown")
	public DefaultRojeanProducer defaultProducer() {
		return new DefaultRojeanProducer();
	}

	@Bean(name = "rojeanProducer")
	public RojeanProducer producer() {
		return defaultProducer().createProducer(topic);
	}

}
