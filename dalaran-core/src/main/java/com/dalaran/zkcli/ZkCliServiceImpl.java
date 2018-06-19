package com.dalaran.zkcli;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

public class ZkCliServiceImpl {

	public void create() throws InterruptedException {
		ZkClient client = new ZkClient(new ZkConnection("127.0.0.1"),1000);
		List<String> list = client.getChildren("/dubbo");
		for(String path:list){
			System.out.println(path);
		}


		String path = "/znodeA";

		boolean result = client.exists(path);
		if(result){
			System.out.println("del");
			client.deleteRecursive(path);
		}

		client.createPersistent(path, "data-old");
		System.out.println("ReadData: "+client.readData(path));


//		client.subscribeChildChanges(path, new IZkChildListener() {
//			@Override
//			public void handleChildChange(String parentPath, List<String> currentChilds)
//					throws Exception {
//				for(String path:currentChilds){
//					System.out.println("ChangeChild: " +path);
//				}
//			}
//		});

		client.subscribeDataChanges(path, new IZkDataListener() {
			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
					System.out.println("handleDataDeleted:" + dataPath);
			}

			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.println("handleDataChange: " + dataPath + "   " + data);
			}
		});

		//Thread.sleep(5000);
	    //client.createPersistent("/super/c1", "c1内容");
		//System.out.println("do write.");
		//client.writeData(path, "data-new",-1);
	    Thread.sleep(5000);
	    System.out.println("do delete.");
	    client.delete(path);

	}

}
