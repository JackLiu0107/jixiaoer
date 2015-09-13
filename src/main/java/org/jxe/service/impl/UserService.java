package org.jxe.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.dao.IUserDao;
import org.jxe.service.IUserService;
import org.jxe.utils.Constants;
import org.jxe.utils.JSONUtils;
import org.jxe.utils.MapUtil;
import org.jxe.utilsjson.UserJson;
import org.springframework.stereotype.Service;


@Service("IUserService")
public class UserService implements IUserService {
	
	@Resource
	private IUserDao iUserDao;
	/**
	 * 登陆
	 */
	public Object login(Map<String, Object> map, HttpServletRequest request) throws Exception{
		map=iUserDao.login(map);
		if(map ==null){
			return JSONUtils.getJSON(Constants.CODE_NUMBER_200,"" ,"用户不存在");
		}else{
			return JSONUtils.getJSON(Constants.CODE_NUMBER_200,UserJson.login(map) ,"");
		}
		
	}
	
	/**
	 * 注册
	 */
	public Object register(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Integer isuser=iUserDao.finduser(map);
		if(isuser>0){
			//iUserDao.save(map);
			//iUserDao.saveLicense(map);
			return JSONUtils.getJSON(Constants.CODE_NUMBER_300,null ,"用户已经存在");
		}else{
			iUserDao.save(map);
			iUserDao.saveLicense(map);
			return JSONUtils.getJSON(Constants.CODE_NUMBER_200,UserJson.login(map) ,"注册成功");
		}
		
	}
	/**
	 * 忘记密码
	 */
	public Object retrieve(Map<String, Object> map,HttpServletRequest request) throws Exception{
		iUserDao.retrieve(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,map,"成功");
	}
	
	/**
	 * 修改密码
	 */
	public Object updpwd(Map<String, Object> map,HttpServletRequest request) throws Exception{
		map=MapUtil.copyMap(map, request);
		iUserDao.updpwd(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,map,"成功");
	}
	/**
	 * 修改用户
	 */
	public Object update(Map<String, Object> map,HttpServletRequest request) throws Exception{
		map=MapUtil.copyMap(map, request);
		iUserDao.update(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,map,"成功");
	}

}
