package org.jxe.utilsjson;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FactoryJson {
	
	public static JSONObject findpage(Map<String, Object> map,List list){
		JSONObject obj=new JSONObject();
		obj.put("name", map.get("name"));
		obj.put("id", map.get("id"));
		obj.put("phone", map.get("phone"));
		obj.put("telephone", map.get("telephone"));
		obj.put("longitude", map.get("longitude"));
		obj.put("latitude", map.get("latitude"));
		obj.put("integral", map.get("integral"));
		obj.put("address", map.get("address"));
		obj.put("introduce", map.get("introduce"));
		obj.put("discount", map.get("discount"));
		obj.put("nature", map.get("nature"));
		obj.put("path", list);
		return obj;
	}
	
	
	
	public static JSONObject orderFactory(Map<String, Object> map){
		JSONObject obj=new JSONObject();
		obj.put("userId", map.get("userId"));
		obj.put("id", map.get("id"));
		obj.put("username", map.get("username"));
		obj.put("phone", map.get("phone"));
		obj.put("head", map.get("head"));
		obj.put("status", map.get("status"));
		obj.put("integral", map.get("integral"));
		obj.put("price", map.get("price"));
		obj.put("introduce", map.get("introduce"));
		obj.put("discount", map.get("discount"));
		obj.put("nature", map.get("nature"));
		return obj;
	}
	
	public static JSONArray orderFactoryList(List<Map<String, Object>> list){
		JSONArray arr=new JSONArray();
		for (Map<String, Object> map : list) {
			arr.add(orderFactory(map));
		}
		return arr;
	}

}
