package org.jxe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IFactoryService {
	public Object findpage(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object saveOrderForm(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object login(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object orderFactory(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object detailed(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object orderforUser(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object findpageOrder(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object ordersumit(Map<String, Object> map,HttpServletRequest request) throws Exception;
	public Object updorder(Map<String, Object> map,HttpServletRequest request) throws Exception;
	public Object updorderprice(Map<String, Object> map,HttpServletRequest request) throws Exception;
}
