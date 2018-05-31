package com.dalaran.api.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dalaran.api.TeleportInterface;

@Service("teleportInterface")
public class TeleportInterfaceImpl implements TeleportInterface {

	@Override
	public void toStormwind() {
		System.out.println("stormwind");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toKenruito() {
		System.out.println("kenruito");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
