package com.dalaran.api.impl;

import org.springframework.stereotype.Service;

import com.dalaran.api.TeleportInterface;

@Service("teleportInterface")
public class TeleportInterfaceImpl implements TeleportInterface {

	@Override
	public void toStormwind() {
		System.out.println(1);
	}

}
