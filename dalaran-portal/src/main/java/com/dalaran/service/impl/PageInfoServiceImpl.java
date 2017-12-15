package com.dalaran.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dalaran.dao.PageInfoDao;
import com.dalaran.model.PageInfo;
import com.dalaran.service.PageInfoService;

@Service("pageInfoService")
public class PageInfoServiceImpl implements PageInfoService {

	@Resource
	private PageInfoDao pageInfoDao;

	@Override
	public List<PageInfo> findByMap(Map<String, String> map) {
		return pageInfoDao.findByMap(map);
	}

}
