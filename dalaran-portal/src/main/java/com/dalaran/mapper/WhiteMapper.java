package com.dalaran.mapper;

import com.dalaran.model.White;

public interface WhiteMapper {

	/**
	 * 更新 版本号 ，在原版本号上 加一
	 */
	void updateOptimistic(White white) throws Exception ;
	/**
	 * 还原 版本号，设置 版本号为 0
	 */
	void restoreOptimistic(White white);

	White findById(String id);
}
