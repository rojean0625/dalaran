package com.dalaran.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@PropertySource("classpath:/dubbo.properties")
public class DubboConfig {

	@Value("${dubbo.resAddress}")
	private String resAddress;

	@Value("${dubbo.resUsername}")
	private String resUsername;

	@Value("${dubbo.resPassowrd}")
	private String resPassowrd;

	@Bean
	public MonitorConfig monitor() {
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		return monitorConfig;
	}

	@Bean
	public ApplicationConfig application() {
		ApplicationConfig applicationConfig = new ApplicationConfig("dalaran-portal");
		applicationConfig.setRegistry(registry());
		applicationConfig.setMonitor(monitor());
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registry() {
		RegistryConfig registryConfig = new RegistryConfig(resAddress);
		registryConfig.setUsername(resUsername);
		registryConfig.setPassword(resPassowrd);
		return registryConfig;
	}

	@Bean
	public ProtocolConfig protocol() {
		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", 20880);
		protocolConfig.setThreads(5);
		protocolConfig.setAccepts(2000);
		protocolConfig.setSerialization("kryo");
		return protocolConfig;
	}
}
