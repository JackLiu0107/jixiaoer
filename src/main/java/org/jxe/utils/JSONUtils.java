package org.jxe.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 
* @Title: JSONUtils.java 
* @Package org.jxe.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liuy
* @date 2015年7月13日 下午4:44:51 
* @version V1.0
 */
public class JSONUtils {
	
	/**
	 * 数据JSON格式化
	 * @Title: getJSON
	 * @Description: 数据正确时，将传入的对象进行JSON格式化
	 * @param @param object 可以是 map list autoObject
	 * @return JSON 
	 * @override  该方法只能重写，不能改写
	 */
	public static JSONObject getJSON(int codeNumber,Object object,String msg ) {
		JSONObject json = new JSONObject();
		json.put("code", codeNumber);
		json.put("data",object);
		json.put("msg",msg);
		return json;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public static JSONObject getDataJSON(Map<String, Object> map){
		JSONObject json = new JSONObject();
		for(Object key : map.keySet()){
			 json.put((String) key, map.get(key));
		}
		return json;
	}
	
	/**
	 * json数据copy，合并数据，取交集
	 * @Title: copyJSON 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param jsonObjects
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	public static JSONObject copyJSON(JSONObject...jsonObjects){
		JSONObject json = new JSONObject();
		if(jsonObjects.length>0){
			for(JSONObject obj : jsonObjects){
				for(Object key : obj.keySet()){
					json.put((String) key, obj.get(key));
				}
			}
		}
		return json;
	}
}
