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

	@Value("${dubbo.protocol}")
	private String protocol;

	@Value("${dubbo.port}")
	private int port;

	@Value("${dubbo.accepts}")
	private int accepts;

	@Value("${dubbo.connections}")
	private int connections;

	@Bean
	public ApplicationConfig application() {
		ApplicationConfig applicationConfig = new ApplicationConfig(
				"dalaran-core");
		applicationConfig.setMonitor(monitor());
		applicationConfig.setRegistry(registry());
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registry() {
		RegistryConfig registryConfig = new RegistryConfig(resAddress);
		registryConfig.setUsername(resUsername);
		registryConfig.setPassword(resPassowrd);
		registryConfig.setProtocol(protocol);
		registryConfig.setPort(port);
		return registryConfig;
	}

	@Bean
	public ProtocolConfig protocol() {
		ProtocolConfig protocolConfig = new ProtocolConfig(protocol, port);
		protocolConfig.setThreads(5);
		protocolConfig.setAccepts(2000);
		return protocolConfig;
	}

	@Bean
	public ProviderConfig provider() {
		ProviderConfig config = new ProviderConfig();
		config.setAccepts(accepts);
		config.setConnections(connections);
		return config;
	}

	@Bean
	public MonitorConfig monitor() {
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		return monitorConfig;
	}
}
