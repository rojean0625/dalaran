package com.dalaran.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.dalaran.api.BankOrderInterface;
import com.dalaran.context.RedisCacheConfig;
import com.dalaran.mock.ParseFile;
import com.dalaran.model.TransOrder;
import com.dalaran.model.PageInfo;
import com.dalaran.model.TransHistory;
import com.dalaran.service.PageInfoService;
import com.dalaran.service.TransHistoryService;
/**
 * Gnomeregan.2017
 * 诺莫瑞根 （Gnomeregan） 等级：24-33级 位于丹莫罗西
 * @author Administrator
 *
 */
@Controller
@RequestMapping("gnomeregan")
public class GnomereganController {
	Logger logger = LoggerFactory.getLogger(GnomereganController.class);

	//@Resource
	private RedisCacheConfig config;
	//@Resource
	private BankOrderInterface bankOrderInterface;

	//@Resource
	//private BankOrderService bankOrderService;
	@Resource
	private PageInfoService pageInfoService;
	@Resource
	private TransHistoryService transHistoryService;

	//@Resource
	private ExecutorService threadPool;

	@RequestMapping("toIndexPage")
	public ModelAndView toIndexPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String path = request.getScheme() + "://" + request.getServerName() + (80 == request.getServerPort() || 443 == request.getServerPort() ? "" : (":" + request.getServerPort()));
		String context = request.getContextPath();
		path = path + context;
		Map<String,String> map = new LinkedHashMap<String,String>();
		List<PageInfo> pageInfoList = pageInfoService.findByMap(map);
		//ParseFile s = new ParseFile();
		//List<TransHistory> list =s.parseTransHistory();
		//int nn = transHistoryService.insertList(list);
		mv.addObject("domain",path);
		mv.addObject("pageInfo",pageInfoList);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("toTestPage")
	public ModelAndView testPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testPage");
		return mv;
	}


	@RequestMapping("testThreadPool")
	public void testThreadPool(){
		List<Future<String>> fs = new ArrayList<Future<String>>();
		String info ="task";
		int count = 5000;
		for(int i=0;i<count;i++){
			fs.add(threadPool.submit(new Callable<String>(){
				@Override
				public String call() throws Exception {
					String v = Math.random() + info;
					Thread.sleep(1200);
					return v;
				}
			}));
		}

		for(Future<String> result : fs){
			try {
				result.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Test mybatis
	 * @return
	 */
	@RequestMapping("queryBankOrder")
	public ModelAndView queryBankOrder(){
		ModelAndView mv = new ModelAndView();
		Map<String,String> map = new HashMap<String,String>();
		map.put("checkId", "checkId001");
		TransOrder ord = null;// bankOrderService.findByCheckId(map);
		//System.out.println("ORD INFO: "+ord.getCheckId() + " "+ ord.getAccessInst() + " " + ord.getTransAmount());
		mv.setViewName("/bankOrder/bankOrderQuery");
		return mv;
	}


	@RequestMapping("bankOrdExport")
	public ModelAndView bankOrdExport(){
		ModelAndView mv = new ModelAndView();
		List<TransOrder> list = new ArrayList<TransOrder>();
		TransOrder ord = new TransOrder();
		list.add(ord);

		ord = new TransOrder();
		list.add(ord);
		mv.addObject("list", list);
		mv.setViewName("/bankOrder/bankOrderExport");
		return mv;
	}


	/**
	 * Call dubbo
	 * @return
	 */
	@RequestMapping("callDub")
	public ModelAndView portal(){
		ModelAndView mv = new ModelAndView();
		logger.info("#### dalaran-portal ####  -  {}   {}","Successfully.",bankOrderInterface);
		String info = bankOrderInterface.getBankOrderInvalidate("bankFlowId");
		mv.setViewName("/bankOrder/bankOrderQuery");
		return mv;
	}

	@RequestMapping("toAddBankOrder")
	public void toAddBankOrder() {
		JedisPool pool = config.getRedisConnection();
		Jedis jedis = pool.getResource();
		String bankOrderId = "#1121";
		System.out.println("toAddBankOrder: " + bankOrderId);
		jedis.set("bankOrder",bankOrderId);
	}

	@RequestMapping("toDelBankOrder")
	public void toDelBankOrder(){
		JedisPool pool = config.getRedisConnection();
		Jedis jedis = pool.getResource();
		jedis.del("bankOrder");
	}
}
