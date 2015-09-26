package org.jxe.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.service.IFactoryService;
import org.jxe.utils.Constants;
import org.jxe.utils.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/factory")
public class FactoryController {
	
	@Resource
	private IFactoryService iFactoryService;
	
	/**
	 * 
	* @Title: findpage
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月30日 下午5:15:12 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/findpage", method=RequestMethod.POST)
	@ResponseBody
	public Object findpage(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.findpage(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	/**
	 * 
	* @Title: findpageOrder
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月30日 下午5:15:12 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/findpageOrder", method=RequestMethod.POST)
	@ResponseBody
	public Object findpageOrder(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.findpageOrder(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	
	
	/**
	 * 
	* @Title: saveOrderForm
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月30日 下午6:04:34 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/saveOrder", method=RequestMethod.POST)
	@ResponseBody
	public Object saveOrderForm(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.saveOrderForm(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	/**
	 * 登陆
	* @Title: login
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年8月25日 下午9:55:06 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.login(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	@RequestMapping(value="/orderFactory", method=RequestMethod.POST)
	@ResponseBody
	public Object orderFactory(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.orderFactory(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	@RequestMapping(value="/updorder", method=RequestMethod.POST)
	@ResponseBody
	public Object updorder(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return null;//iFactoryService.updorder(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	/**
	 * 详情
	* @Title: factorydetailed
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年8月25日 下午9:54:50 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/detailed", method=RequestMethod.POST)
	@ResponseBody
	public Object factorydetailed(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.detailed(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	/**
	 * 我的订单
	* @Title: orderforUser
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年8月25日 下午10:03:54 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/orderforuser", method=RequestMethod.POST)
	@ResponseBody
	public Object orderforUser(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iFactoryService.orderforUser(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	 
	

	
	
	

}
