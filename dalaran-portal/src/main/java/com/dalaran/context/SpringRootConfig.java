/**
 *
 */
package com.dalaran.context;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: SpringRootConfig 此处填写需要参考的类
 * @version 2016年7月30日 上午11:35:21
 * @author chao.luo
 */
@Configuration
@EnableScheduling
@EnableAspectJAutoProxy
//@Import({MariaDBConfig.class,MyBatisConfig.class})
@Import({MariaDBConfig.class,MyBatisConfig.class,DubboConfig.class,DubboClientConfig.class})
@ComponentScan(basePackages = "com.dalaran", excludeFilters = { @Filter(Controller.class), @Filter(Configuration.class) })
public class SpringRootConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Validator validator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    return new CommonsMultipartResolver();
	}
}
