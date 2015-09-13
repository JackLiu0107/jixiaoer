package org.jxe.utilsjson;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class UserJson {
	
	public static JSONObject login(Map<String, Object> map){
		JSONObject obj=new JSONObject();
		obj.put("phone",isnull(map.get("phone")));
		obj.put("id", isnull(map.get("id")));
		obj.put("name",isnull(map.get("name")));
		obj.put("head", isnull(map.get("head")));
		return obj;
	}
	
	public static String isnull(Object o){
		if(o !=null){
			return o.toString();
		}
		return "";
		
	}

}
