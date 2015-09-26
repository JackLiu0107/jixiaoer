package org.jxe.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.service.ICommentService;
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
@RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private ICommentService iCommentService;
	
	/**
	 *发评论
	 * @Title: save 
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		try {
			return iCommentService.save(map, request);
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
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> map,HttpServletRequest request) {
		try {
			if(map.get("page")!=null){
				map.put("page", Integer.parseInt(map.get("page").toString()));
			}
			if(map.get("szie")!=null){
				map.put("szie", Integer.parseInt(map.get("szie").toString()));
			}
			return iCommentService.list(map, request);
		} catch (Exception e) {
			e.printStackTrace();
			return JSONUtils.getJSON(Constants.CODE_NUMBER_500,e.toString(),"系统错误");
		}
	}  
	
	

}
