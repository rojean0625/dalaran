package com.dalaran.annot;

public class Mediven {

	@Kenruito(code="101",dalaranGroup=true)
	public String ip;

	public Mediven(){}

	public void sheep(){
		System.out.println("Sheep.");
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}



}
