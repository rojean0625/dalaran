package com.dalaran.mapper;

import java.util.List;
import java.util.Map;

import com.dalaran.model.PageInfo;

public interface PageInfoMapper {

	List<PageInfo> findByMap(Map<String, String> map);
}
