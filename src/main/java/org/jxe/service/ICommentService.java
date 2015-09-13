package org.jxe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ICommentService {
	public Object save(Map<String, Object> map, HttpServletRequest request) throws Exception;
	public Object findlist(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	public Object list(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	
	
}
