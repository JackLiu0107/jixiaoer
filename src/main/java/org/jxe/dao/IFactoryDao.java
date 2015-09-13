package org.jxe.dao;

import java.util.List;
import java.util.Map;

/**
 * 
* @Title: IFactoryDao
* @Package org.jxe.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liuy
* @date 2015年7月23日 下午2:02:04 
* @version V1.0
 */
public interface IFactoryDao {
	public List<Map<String, Object>> findpage(Map<String, Object> map) throws Exception;
	public Integer saveOrderForm(Map<String, Object> map) throws Exception;
	public Map<String, Object> login(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> orderFactory(Map<String, Object> map) throws Exception;
	public Map<String, Object> detailed(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> orderforUser(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> factoryimg(Map<String, Object> map) throws Exception;
}
