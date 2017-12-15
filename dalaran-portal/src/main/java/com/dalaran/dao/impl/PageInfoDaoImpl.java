package com.dalaran.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.PageInfoDao;
import com.dalaran.mapper.DalaranBaseMapper;
import com.dalaran.mapper.PageInfoMapper;
import com.dalaran.model.PageInfo;

@Repository("pageInfoDao")
public class PageInfoDaoImpl extends DalaranBaseMapper<PageInfo> implements PageInfoDao {

	public PageInfoDaoImpl () {
		super(PageInfoMapper.class.getName());
	}

	@Override
	public List<PageInfo> findByMap(Map<String, String> map) {
		String method = this.mapperClassName + ".findByMap";
		return super.getSqlSession().selectList(method, map);
	}

}
