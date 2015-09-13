package org.jxe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
	public Object login(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object register(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object retrieve(Map<String, Object> map,HttpServletRequest request) throws Exception;
	public Object updpwd(Map<String, Object> map,HttpServletRequest request) throws Exception;
	public Object update(Map<String, Object> map,HttpServletRequest request) throws Exception;
}
