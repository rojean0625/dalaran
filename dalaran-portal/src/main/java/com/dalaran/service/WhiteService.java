package com.dalaran.service;

import com.dalaran.model.White;

public interface WhiteService {

	void updateOptimistic(White white) throws Exception ;

	void updateOptimisticSupport(White white) throws Exception ;


	/**
	 * 还原 版本号，设置 版本号为 0
	 */
	void restoreOptimistic(White white);
	White findById(String id);
	void updateOptimisticSupportSucc() throws Exception ;
}
