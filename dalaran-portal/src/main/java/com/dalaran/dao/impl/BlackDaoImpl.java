package com.dalaran.dao.impl;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.BlackDao;
import com.dalaran.mapper.DalaranBaseMapper;
import com.dalaran.mapper.BlackMapper;
import com.dalaran.model.Black;

@Repository("blackDao")
public class BlackDaoImpl extends DalaranBaseMapper<Black> implements BlackDao {

	public BlackDaoImpl() {
		super(BlackMapper.class.getName());
	}

	/**
	 * 更新 版本号 ，在原版本号上 加一
	 * @throws Exception
	 */
	@Override
	public void updateOptimistic(Black black) throws Exception {
		String method = this.mapperClassName + ".updateOptimistic";
		super.getSqlSession().update(method, black);
		System.out.println("do update [Black] optimistic.");
		int b = black.getFlag();
		if(b == 0){
			throw new Exception("UpdateBlack Fail.");
		}
	}

	@Override
	public Black findById(String id){
		String method = this.mapperClassName + ".findById";
		return super.getSqlSession().selectOne(method, id);
	}
	/**
	 * 还原 版本号，设置 版本号为 0
	 */
	@Override
	public void restoreOptimistic(Black black) {
		String method = this.mapperClassName + ".restoreOptimistic";
		super.getSqlSession().update(method, black);
	}

}
