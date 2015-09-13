package org.jxe.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.service.IUserService;
import org.jxe.utils.Constants;
import org.jxe.utils.JSONUtils;
import org.jxe.utils.PhotoReadFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/user")
public class UserInfoController {
	
	@Resource
	private IUserService iUserService;
	
	/**
	 * 用户注册
	 * @Title: register 
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public Object register(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iUserService.register(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}

	/**
	 * 
	* @Title: userLogin
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月23日 上午11:37:28 
	* @param map
	* @return
	 */
	@RequestMapping(value="/login")
	@ResponseBody
	public Object login(@RequestParam Map<String, Object> map,HttpServletRequest request) {
		try {
			if(map.get("phone")==null || "".equals(map.get("phone").toString())){
				return JSONUtils.getJSON(Constants.CODE_NUMBER_300,"","请输入手机号");
			}
			if(map.get("password")==null ||"".equals(map.get("password").toString())){
				return JSONUtils.getJSON(Constants.CODE_NUMBER_300,"","请输入密码");
			}
			return iUserService.login(map, request);
		} catch (Exception e) {
			e.printStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Object updateUserInfo(@RequestParam Map<String, Object> map,HttpServletRequest request) {
		try {
			return iUserService.update(map, request);
		} catch (Exception e) {
			e.getStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,"","失败");
		}
	}
	
	/**
	 * 
	* @Title: updatepwd
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月23日 上午11:38:48 
	* @param map
	* @param request
	* @return
	 */
	@RequestMapping(value="/updpwd", method=RequestMethod.POST)
	@ResponseBody
	public Object updatepwd(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iUserService.updpwd(map, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	* @Title: retrievePassword
	* @Package org.jxe.controller 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月23日 上午11:38:42 
	* @param map
	* @return
	 */
	@RequestMapping(value="/retrieve", method=RequestMethod.POST)
	@ResponseBody
	public Object retrievePassword(@RequestParam Map<String, Object> map,HttpServletRequest request){
		try {
			return iUserService.retrieve(map, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadPhoto(@RequestParam("annex") MultipartFile imgFile, HttpServletRequest request){
		String fileName = imgFile.getOriginalFilename();  
		String space="users";
        //获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
         String name = fileName.substring(0,fileName.lastIndexOf(".")+1)+fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()).toLowerCase();  
         try {
        	 JSONObject json = PhotoReadFileUtil.PhotoReadFile(imgFile,name,space);
        	 if(json.size()>0){
        		 return	JSONUtils.getJSON(Constants.CODE_NUMBER_200, json ,"上传成功");
        	 }else{
        		 return JSONUtils.getJSON(Constants.CODE_NUMBER_500, "" ,"上传失败");
        	 }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	
	

}
