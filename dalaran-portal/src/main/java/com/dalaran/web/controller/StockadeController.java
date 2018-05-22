package com.dalaran.web.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dalaran.dao.BlackDao;
import com.dalaran.dao.WhiteDao;
import com.dalaran.model.Black;
import com.dalaran.model.White;
import com.dalaran.service.BlackService;
import com.dalaran.service.DalaranService;
import com.dalaran.service.TableService;

/**
 * Stockade
 * Spring Transaction Control
 * @author Administrator
 *
 */
@Controller
@RequestMapping("stockade")
public class StockadeController {

	Logger logger = LoggerFactory.getLogger(StockadeController.class);

	@Resource
	private DalaranService dalaranService;
	@Resource
	private BlackService blackService;
	@Resource
	private TableService tableService;

	ThreadLocal<String> result = new ThreadLocal<String>();
	ThreadLocal<String> result2 = new ThreadLocal<String>();


	private int count = 0;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	@RequestMapping("toAddCount")
	@ResponseBody
	String toAddCount(){
		Thread t;
		logger.info("Thread: "+Thread.currentThread().getId());
		logger.info("Count-A: {}",result.get());
		result.set("haha");
		logger.info("Count-B: {}",result.get());
		result.set("bianle");
		logger.info("Count-C: {}",result.get());
		return "OK";
	}




	/**
	 * 进入页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toIniPage")
	ModelAndView toIniPage(HttpServletRequest request){
		String path = request.getScheme() + "://" + request.getServerName() + (80 == request.getServerPort() || 443 == request.getServerPort() ? "" : (":" + request.getServerPort()));
		String context = request.getContextPath();
		path = path + context;
		ModelAndView mv = new ModelAndView("/stockade/stockade");
		mv.addObject("path", path);
		return mv;
	}

	@RequestMapping("doAop")
	void doAop(){
		tableService.updateTable(null);
	}

	/**
	 * Required
	 * @param request
	 * @param w White=1 执行成功
	 * @param b Black=1执行成功
	 * @param t =1 T
	 * @param x =1 E
	 * @param r =1 ReadOnly
	 * @return
	 */
	@RequestMapping("proRequired")
	ModelAndView proRequired(HttpServletRequest request,int w,int b,int t,int x,int r){
		try {
			if(t == 1){
				// TimeOut
				dalaranService.proRequiredTimeOut(w, b);
			}else if(r == 1){
				// readOnly
				dalaranService.readOnlyTransaction();
			}else if(x == 1){
				// Exception Filter
				dalaranService.proRequiredExcpFilter(w, b);
			}else{
				// Propagation.required
				dalaranService.proRequired(w, b);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("## propagation required end");
		return this.toIniPage(request);
	}


	/**
	 * Required New
	 * @param request
	 * @param w
	 * @param b
	 * @return
	 */
	@RequestMapping("proRequiredNew")
	ModelAndView proRequiredNew(HttpServletRequest request,int w,int b){
		try {
			dalaranService.proRequiredNew(w, b);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("## propagation requiredNew end");
		return this.toIniPage(request);
	}


	/**
	 * Nested
	 * @param request
	 * @return
	 */
	@RequestMapping("proNested")
	ModelAndView proNested(HttpServletRequest request,int w,int b){
		try {
			dalaranService.proNested(w, b);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("## propagation Nested end");
		return this.toIniPage(request);
	}


	/**
	 * Supports
	 * @param request
	 * @param w
	 * @param b
	 * @return
	 */
	@RequestMapping("proSupports")
	ModelAndView proSupports(HttpServletRequest request,int w,int b){
		try {
			if(w == 1 ){
				dalaranService.proSupportsHasTx(w, b);
			}else{
				dalaranService.proSupportsHaventTx(w, b);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("## propagation Supports end");
		return this.toIniPage(request);
	}











	/**
	 * 测试
	 * @throws Exception
	 */
	@RequestMapping("testUpdate")
	ModelAndView testUpdate(HttpServletRequest request) throws Exception{
		dalaranService.testUpdate();
		logger.info("Test Update");
		return this.toIniPage(request);
	}

	@RequestMapping("testRestore")
	ModelAndView testRestore(HttpServletRequest request){
		dalaranService.testRestore();
		logger.info("Test Resotre");
		return this.toIniPage(request);
	}

}
