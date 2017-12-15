package com.dalaran.mock;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.dalaran.model.TransHistory;
import com.dalaran.utils.HttpUtils;


public class T {

	public static void main(String[] args) {
		///AppKey 23726193
		//AppSecret fc4b373567ab3488b6eac2cca08d900c
		//AppCode 983ad7390e1c48dcb4f8d535c683fa40

		  String host = "https://ali-stock.showapi.com";
		    String path = "/sz-sh-stock-history";
		    String method = "GET";
		    String appcode = "983ad7390e1c48dcb4f8d535c683fa40";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("begin", "2017-01-01");
		    querys.put("code", "002739");
		    querys.put("end", "2017-01-31");


		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		    	//System.out.println(response.toString());
		    	//获取response的body
		    	System.out.println("======");
		    	System.out.println(EntityUtils.toString(response.getEntity()));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
//
//		    ParseFile p = new ParseFile();
//		    List<TransHistory> r = p.parseTransHistory();
//		    System.out.println(r.size());

	}

}
