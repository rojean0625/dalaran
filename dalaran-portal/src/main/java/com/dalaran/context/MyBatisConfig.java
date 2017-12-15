package com.dalaran.context;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@MapperScan("com.dalaran.mapper")
@EnableTransactionManagement
public class MyBatisConfig {
	@javax.annotation.Resource
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		try {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			Resource configLocation = new org.springframework.core.io.ClassPathResource("mybatis-config.xml");
			bean.setConfigLocation(configLocation);
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 事务管理器
	 * DataSourceTransactionManager
	 * 控制着从DataSource中获得的JDBC Connection上的事务的执行
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		DataSourceTransactionManager mgr = new DataSourceTransactionManager(dataSource);
		mgr.setNestedTransactionAllowed(true);
		return mgr;
	}


}
