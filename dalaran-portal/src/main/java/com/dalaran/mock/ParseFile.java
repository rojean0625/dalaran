package com.dalaran.mock;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.utils.DateUtils;
import org.springframework.format.datetime.DateFormatter;

import com.alibaba.dubbo.common.store.support.SimpleDataStore;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dalaran.model.TransHistory;

public class ParseFile {

	private Date toParseDate(String date,String e) throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat(e);
		return fmt.parse(date);
	}

	public List<TransHistory> parseTransHistory(){
		 	byte[] buffer = null;
		 	int count = 0;
		 	List<TransHistory> list = new ArrayList<TransHistory>();
	        try {
	            File file = new File("e:/info.txt");
	            FileInputStream fis = new FileInputStream(file);
	            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
	            byte[] b = new byte[1000];
	            int n;
	            while ((n = fis.read(b)) != -1) {
	                bos.write(b, 0, n);
	            }
	            fis.close();
	            bos.close();
	            buffer = bos.toByteArray();
	            String info = new String(buffer,"gbk");

	            JSONObject js = JSONObject.parseObject(info);
	            String c = js.getString("showapi_res_body");
	            js = JSONObject.parseObject(c);
	            c = js.getString("list");

	            JSONArray dataList = JSONArray.parseArray(c);
	            System.out.println("List size: " + dataList.size());
	            for(int i=0;i<dataList.size();i++){
	                 JSONObject record =  (JSONObject) dataList.get(i);
	                 TransHistory h = new TransHistory();
	                 //1
	                 String code = record.getString("code");
	                 h.setCode(code);
	                 //2
	                 String market = record.getString("market");
	                 h.setMarket(market);
	                 //3
	                 String stockName = record.getString("stockName");
	                 h.setStockName(stockName);
	                 //4
	                 h.setBordName("Wanda");
	                 //5
	                 int trade_num= Integer.parseInt(record.getString("trade_num"));
	                 h.setTradeNum(trade_num);
	                 //
	                 int trade_money = Integer.parseInt(record.getString("trade_money"));
	                 h.setTradeMoney(trade_money);
	                 //7
	                 double open_price = Double.parseDouble(record.getString("open_price"));
	                 h.setOpenPrice(open_price);
	                 double close_price = Double.parseDouble(record.getString("close_price"));
	                 h.setClosePrice(close_price);

	                 double max_price = Double.parseDouble(record.getString("max_price"));
	                 h.setMaxPrice(max_price);
	                 double min_price = Double.parseDouble(record.getString("min_price"));
	                 h.setMinPrice(min_price);

	                 String tdate =record.getString("date");
	                 Date date = this.toParseDate(tdate, "yyyy-MM-dd");
	                 h.setTradeDate(date);

	                 double turnover = Double.parseDouble(record.getString("turnover"));
	                 h.setTurnover(turnover);


	                 double swing = Double.parseDouble(record.getString("swing"));
	                 h.setSwing(swing);
	                 double diff_rate = Double.parseDouble(record.getString("diff_rate"));
	                 h.setDiffRate(diff_rate);
	                 double diff_money = Double.parseDouble(record.getString("diff_money"));
	                 h.setDiffMoney(diff_money);

	                 String id = code +"_"+tdate;
	                 h.setId(id);
	                 list.add(h);
	                 count ++;
	            }
	        } catch (Exception e) {
	           System.out.println(e + " " + e.getMessage() );
	           System.out.println("error Count: "+ e);
	        }finally{
	        	System.out.println("end "+ count);
	        	return list;
	        }
	}
}
