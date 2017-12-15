package com.dalaran.dao.impl;

import org.springframework.stereotype.Repository;

import com.dalaran.dao.WhiteDao;
import com.dalaran.mapper.DalaranBaseMapper;
import com.dalaran.mapper.WhiteMapper;
import com.dalaran.model.Black;
import com.dalaran.model.White;

@Repository("whiteDao")
public class WhiteDaoImpl extends DalaranBaseMapper<White> implements WhiteDao {

	public WhiteDaoImpl(){
		super(WhiteMapper.class.getName());
	}

	/**
	 * 更新 版本号 ，在原版本号上 加一
	 * @throws Exception
	 */
	@Override
	public void updateOptimistic(White white) throws Exception {
		String method = this.mapperClassName + ".updateOptimistic";
		super.getSqlSession().update(method, white);
		System.out.println("do update [white] optimistic.");
		int w = white.getFlag();
		if(w == 0){
			throw new Exception("UpdateWhite Fail.");
		}
	}

	@Override
	public White findById(String id){
		String method = this.mapperClassName + ".findById";
		White white = super.getSqlSession().selectOne(method,id);
		return white;
	}

	/**
	 * 还原 版本号，设置 版本号为 0
	 */
	@Override
	public void restoreOptimistic(White black) {
		String method = this.mapperClassName + ".restoreOptimistic";
		super.getSqlSession().update(method, black);
	}

}
