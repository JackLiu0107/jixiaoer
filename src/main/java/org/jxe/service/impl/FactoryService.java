package org.jxe.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.dao.IFactoryDao;
import org.jxe.service.IFactoryService;
import org.jxe.utils.Constants;
import org.jxe.utils.JSONUtils;
import org.jxe.utils.Pages;
import org.jxe.utilsjson.FactoryJson;
import org.springframework.stereotype.Service;


@Service("IFactoryService")
public class FactoryService implements IFactoryService {
	
	@Resource
	private IFactoryDao iFactoryDao;


	/*
	 * (non-Javadoc)
	 * @see org.jxe.service.IFactoryService#findpage(java.util.Map, javax.servlet.http.HttpServletRequest)
	 */
	public Object findpage(Map<String, Object> map, HttpServletRequest request) throws Exception{
		map=Pages.setPage(map);
		List<Map<String, Object>> list=iFactoryDao.findpage(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,FactoryJson.findpagelist(list) ,"");
	}
	
	/**
	 * 预定
	 */
	public Object saveOrderForm(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Integer id=iFactoryDao.saveOrderForm(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,id,"");
	}
	
	public Object login(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Map<String, Object> users=iFactoryDao.login(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,FactoryJson.findpage(users),"");
	}
	
	public Object orderFactory(Map<String, Object> map, HttpServletRequest request) throws Exception{
		List<Map<String, Object>> list=iFactoryDao.orderFactory(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,FactoryJson.orderFactoryList(list),"成功");
	}
	public Object detailed(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Map<String, Object> detailed=iFactoryDao.detailed(map);
		detailed.put("images", iFactoryDao.factoryimg(map));
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,detailed,"");
	}
	
	public Object orderforUser(Map<String, Object> map, HttpServletRequest request) throws Exception{
		List<Map<String, Object>> list=iFactoryDao.orderforUser(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,FactoryJson.orderFactoryList(list),"成功");
	}
	
	
	
	
}
