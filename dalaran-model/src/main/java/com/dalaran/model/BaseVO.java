package com.dalaran.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class BaseVO implements Serializable,Cloneable {

	/** 主键 */
	public String id;
	/** 版本号 */
	public int optimistic;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOptimistic() {
		return optimistic;
	}
	public void setOptimistic(int optimistic) {
		this.optimistic = optimistic;
	}

}
