package com.dalaran.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.dalaran.model.BaseVO;

@Scope(value = "prototype")
public abstract class DalaranBaseMapper<T extends BaseVO> extends SqlSessionDaoSupport implements BaseMapper<T> {

	private Logger logger = LoggerFactory.getLogger(DalaranBaseMapper.class);

	public String mapperClassName;

	public DalaranBaseMapper(String mapperClassName) {
		this.mapperClassName = mapperClassName;
	}


	@Override
	public T findById(String id) {
		try {
			String nameSpaceMethod = mapperClassName + ".findById";
			return getSqlSession().selectOne(nameSpaceMethod, id);
		} catch (Exception e) {
			String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
			String method = Thread.currentThread().getStackTrace()[1].getMethodName();
			logger.error(clazz + "." + method + "-errorMsg:" + e.getMessage());
		}
		return null;
	}


	@Autowired
	public void setMyBatisSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		setSqlSessionFactory(sqlSessionFactory);
	}
}
