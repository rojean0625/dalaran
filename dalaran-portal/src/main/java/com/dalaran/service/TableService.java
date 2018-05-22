package com.dalaran.service;

import java.util.List;
import java.util.Map;

public interface TableService {
	// 更改表数据
	void updateTable(String[] args);

	List<String> findByMap(Map<String,String> map);
}
