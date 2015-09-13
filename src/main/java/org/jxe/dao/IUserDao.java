package org.jxe.dao;

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
public interface IUserDao {
	public Integer save(Map<String, Object> map) throws Exception;
	public Map<String, Object> login(Map<String, Object> map) throws Exception;
	public Integer saveLicense(Map<String, Object> map) throws Exception;
	public Integer retrieve(Map<String, Object> map) throws Exception;
	public Integer updpwd(Map<String, Object> map) throws Exception;
	public Integer update(Map<String, Object> map) throws Exception;
	public Integer finduser(Map<String, Object> map) throws Exception;
	
}
