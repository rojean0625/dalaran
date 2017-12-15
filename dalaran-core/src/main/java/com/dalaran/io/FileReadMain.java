package com.dalaran.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadMain {

	public static void main(String[] args) throws IOException {
		//File
		//FileInputStream
		//InputStreamReader
		//BufferReader

		File file = new File("f:/bankfiles/IO文本.txt");

		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis,"gbk");
		BufferedReader br = new BufferedReader(reader);

		int v;
		String result = "";
		String info = "";
		while((info = br.readLine()) != null){
			System.out.println(info);
			result = result + info;
		}
		System.out.println(result);
	}

}
