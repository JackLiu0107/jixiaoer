package org.jxe.utils;

import java.util.Map;

/**
 * 分页算法
* @Title: Pages.java 
* @Package org.ydzw.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liuy
* @date 2015年6月3日 上午10:45:57 
* @version V1.0
 */
public class Pages {
	
	/**
	 * 分页算法一
	* @Title: setPage
	* @Package org.ydzw.utils 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年6月3日 上午10:46:08 
	* @param map
	* @return
	 */
	public static Map<String, Object> setPage(Map<String, Object>  map){
		int size = Integer.parseInt(map.get("size")==null?"10":map.get("size").toString());// 每页显示几条
		int page = (Integer.parseInt(map.get("page")==null?"0":map.get("page").toString())-1)*size;// 计算从第几条开始
		map.put("page", page);
		map.put("size", size);
		return map;
	}
	

}
