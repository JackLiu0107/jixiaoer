package org.jxe.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jxe.dao.SystemHeader;

import com.alibaba.fastjson.JSONObject;

public class MapUtil {

	public static Map<String, Object> getParameterMap(String... string){
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i  = 0;i<string.length;i++){
			map.put(i+"", string[i]);
		}
		return map;
	}
	
	/**
	 * 验证数据是否为空
	 * @Title: isNotNull 
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean isNotNull(Map<String, Object> map, String...str){
		for(String s : str){
			if(!map.containsKey(s) || map.get(s)==null || map.get(s).toString().length()==0){
				return true;
			}
		}
		return false;
	}
	/**
	 * 将map转换成json（单纯map，里面没有嵌套）
	 * @Title: getJSONObjectByMap 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	public static JSONObject getJSONObjectByMap(Map<String, Object> map){
		JSONObject json = new JSONObject();
		if(map!=null && map.size()>0){
			JSONObject dept = new JSONObject();
			for(Object key : map.keySet()){
				dept.put((String) key, map.get(key));
			}
		}
		return json;
	}
	
	/**
	 * 将第二个map值复制到第一个map中，如果第一个map为空，则返回第二个map值，如果第二个map值为空则返回第一个map，如果俩个map中有相同的值，第二个map里的值会覆盖第一个map的值
	 * @Title: copyMap 
	 * @Description: 将第二个map值复制到第一个map中，如果第一个map为空，则返回第二个map值，如果第二个map值为空则返回第一个map，如果俩个map中有相同的值，第二个map里的值会覆盖第一个map的值
	 * @param @param map1
	 * @param @param map2
	 * @param @return    设定文件 
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	public static Map<String, Object> copyMap(Map<String, Object> map1, Map<String, Object> map2){
		if(map1!=null && map2 == null) return map1;
		if(map1==null && map2 != null) return map2;
		for(Object obj : map2.keySet()){
			if(map2.containsKey(obj) && map2.get(obj)!=null){
				map1.put((String) obj, map2.get(obj));
			}
		}
		return map1;
	}
	
	public static Map<String, Object> copyMap(Map<String, Object> map, HttpServletRequest request){
		Map<String, Object> header = new SystemHeader(request).getMap();
		//将头部信息复制到参数map中
		map = MapUtil.copyMap(map, header);
		return map;
	}
	
	
	public static void main(String[] args) {
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("name", "张氏");
		m1.put("birthday", "2013-09-09");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("name", "历史");
		m2.put("phone", "18501377889");
		System.out.println(copyMap(m1,m2));
	}
}
