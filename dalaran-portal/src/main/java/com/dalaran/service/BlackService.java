package com.dalaran.service;

import com.dalaran.model.Black;

public interface BlackService {


	/**
	 * 更新 版本号 ，在原版本号上 加一
	 */
	void updateOptimistic(Black black)  throws Exception;

	void updateOptimisticRequiredNew(Black black) throws Exception;

	void updateOptimisticNested(Black black) throws Exception;

	void updateOptimisticSupport(Black black) throws Exception;




	/**
	 * 还原 版本号，设置 版本号为 0
	 */
	void restoreOptimistic(Black black);
	Black findById(String id);
	void updateOptimisticSupportFail() throws Exception;
}
