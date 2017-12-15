package com.dalaran.service.impl;

import org.springframework.stereotype.Service;

import com.dalaran.service.TableService;
/**
 * 定义连接点  JoinPoint
 * @author Administrator
 *
 */
@Service("tableService")
public class TableServiceImpl implements TableService {

	/**
	 * 连接点（joinpoint）
	 */
	@Override
	public void updateTable() {
		System.out.println("TableServiceImpl。updateTable 执行更新数据操作  update table set ..");
	}

}
