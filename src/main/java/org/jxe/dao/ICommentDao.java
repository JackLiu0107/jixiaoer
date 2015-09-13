package org.jxe.dao;

import java.util.List;
import java.util.Map;

/**
 * 
* @Title: IUserDao.java 
* @Package org.jxe.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liuy
* @date 2015年7月23日 下午2:02:04 
* @version V1.0
 */
public interface ICommentDao {
	public Integer save(Map<String, Object> map) throws Exception;
	public Map<String, Object> findlist(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> commentimg(Map<String, Object> map) throws Exception;
	
}
