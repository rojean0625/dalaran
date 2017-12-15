package com.dalaran.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain {

	// Reg Express - java.util.regex
	public static void main(String[] args) {
		String info = "IND171013ACOM";
		/** 忽略大小写
		(?i)abc 表示abc都忽略大小写
		a(?i)bc 表示bc忽略大小写
		a((?i)b)c 表示只有b忽略大小写
		**/
		Pattern pattern = Pattern.compile("(?i)IND\\d{6}ACOM");
		Pattern pattern2 = Pattern.compile("IND\\d{6}ACOM",Pattern.CASE_INSENSITIVE);
		Pattern pattern3 = Pattern.compile("IND\\d{6}(?i)ACOM");
		Matcher matcher = pattern3.matcher(info);
		boolean result = matcher.matches();

		System.out.println(result);
	}

}
