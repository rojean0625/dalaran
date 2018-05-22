package com.dalaran.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.TableDao;

@Repository("tableDao")
public class TableDaoImpl implements TableDao {

	@Override
	public List<String> findByMap(Map<String, String> map) {
		return Arrays.asList(new String[] {"ELEMENT-1","ELEMENT-2","ELEMENT-3"});
	}

}
