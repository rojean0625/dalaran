package com.dalaran.mapper;

import java.util.List;
import java.util.Map;

import com.dalaran.model.TransHistory;

public interface TransHistoryMapper {

	List<TransHistory> findByMap(Map<String, String> map);

	int insert(TransHistory obj);

	int insertList(List<TransHistory> list);
}
