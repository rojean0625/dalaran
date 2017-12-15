package com.dalaran.mapper;

import com.dalaran.model.BaseVO;


public interface BaseMapper<T extends BaseVO> {

	/**
	 * @Description 根据Id查找
	 * @param id
	 * @return
	 * @see 需要参考的类或方法
	 */
	T findById(String id);

}
