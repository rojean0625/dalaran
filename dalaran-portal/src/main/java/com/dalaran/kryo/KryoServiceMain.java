package com.dalaran.kryo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.dalaran.model.TransOrder;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

public class KryoServiceMain {

	private byte[] messageToByte(Kryo kryo,Object obj,boolean isRef){
		//kryo.addDefaultSerializer(obj.getClass(), new KryoSerializable());

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Output output = new Output(stream);
		kryo.writeObject(output, obj);
		output.flush();
		output.close();
		byte[] dt = stream.toByteArray();
		return dt;
	}



	private byte[] toByte(Object obj) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		baos.close();
		return baos.toByteArray();
	}


	private Object toMessage(byte[] bt) throws IOException, ClassNotFoundException{
		ByteArrayInputStream bais = new ByteArrayInputStream(bt);
		ObjectInputStream is = new ObjectInputStream(bais);
		Object obj = is.readObject();
		is.close();
		bais.close();
		return obj;
	}

	public static void main(String[] args) throws IOException {
		TransOrder ord = new TransOrder();
		ord.setId("code01");
		ord.setCheckId("chk001");
		ord.setOptimistic(0);
		ord.setPayInterface("payinterface001");
		ord.setTransAmount(5500);
		ord.setTransTime(new Date());

		List<TransOrder> list = new LinkedList<TransOrder>();

		for(int i=0;i<100000;i++){
			list.add(ord);
		}

		KryoServiceMain main = new KryoServiceMain();

		Kryo kryo = new Kryo();
		kryo.register(TransOrder.class);
		kryo.setReferences(false);


		System.out.println("begin");
		long start =  System.currentTimeMillis();

		for(TransOrder v: list){
			main.messageToByte(kryo,v, false);
		}

	    System.out.println("Times :" + (System.currentTimeMillis() - start) + " ms" );


	    System.out.println("begin");
	    start =  System.currentTimeMillis();

	    for(TransOrder v: list){
	    	 main.toByte(v);
		}

	    System.out.println("Times :" + (System.currentTimeMillis() - start) + " ms" );




	}

}
