package com.dalaran.service;

public interface DalaranService {

	//PROPAGATION_REQUIRED
	void proRequired(int w, int b) throws Exception;
	void proRequiredTimeOut(int w, int b) throws Exception;
	void proRequiredExcpFilter(int w, int b) throws Exception;

	//PROPAGATION_REQUIRES_NEW
	void proRequiredNew(int w, int b) throws Exception;

	//PROPAGATION_SUPPORTS
	void proSupportsHasTx(int w, int b) throws Exception;
	void proSupportsHaventTx(int w, int b) throws Exception;

	//PROPAGATION_NESTED
	void proNested(int w, int b) throws Exception;


	// readOnly
	void readOnlyTransaction() throws Exception;
	// 测试更新
	void testUpdate() throws Exception;
	// 测试还原
	void testRestore();
}
