package com.dalaran.dao;

import java.util.List;
import java.util.Map;

public interface TableDao {

	List<String> findByMap(Map<String, String> map);
}
