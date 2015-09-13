package org.jxe.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jxe.dao.ICommentDao;
import org.jxe.service.ICommentService;
import org.jxe.utils.Constants;
import org.jxe.utils.JSONUtils;
import org.springframework.stereotype.Service;


@Service("ICommentService")
public class CommentService implements ICommentService {
	
	@Resource
	private ICommentDao iCommentDao;

	/**
	 * pingl
	 */
	public Object save(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Integer id=iCommentDao.save(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,id,"");
	}
	
	public Object findlist(Map<String, Object> map, HttpServletRequest request) throws Exception{
		Map<String, Object> comment=iCommentDao.findlist(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,comment,"");
	}
	
	public Object list(Map<String, Object> map, HttpServletRequest request) throws Exception{
		List<Map<String, Object>> comment=iCommentDao.list(map);
		return JSONUtils.getJSON(Constants.CODE_NUMBER_200,comment,"");
	}
	

	
}
