package com.dalaran.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.dalaran.model.BaseVO;

@Scope(value = "prototype")
public class DalaranBaseMapper<T extends BaseVO> extends SqlSessionDaoSupport implements BaseMapper<T> {

	public String mapperClassName;


	public DalaranBaseMapper(String mapperClassName){
		this.mapperClassName = mapperClassName;
	}

	@Autowired
	public void setMyBatisSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		setSqlSessionFactory(sqlSessionFactory);
	}

}
