package org.jxe.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统头实体类
 * 项目名称：ydzw     
 * 类名称：SystemHeader     
 * 类描述：     
 * 创建人：liuy     
 * 创建时间：2015年4月20日 下午1:29:22     
 * 修改人：liuy     
 * 修改时间：2015年4月20日 下午1:29:22     
 * 修改备注：     
 * @version      
 *
 */
public class SystemHeader {
	
	private Map<String, Object> map = new HashMap<String, Object>();
	

	public SystemHeader(HttpServletRequest request) {
		super();
		map.put("userId", request.getHeader("userid"));
		map.put("userId", request.getHeader("userid"));
		map.put("token", request.getHeader("token"));
		map.put("v", request.getHeader("v"));
	}

	public Map<String, Object> getMap() {
		return map;
	}
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
