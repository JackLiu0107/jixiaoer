package org.jxe.utils;

/**
 * 工具类
* @Title: ObjectUtil.java 
* @Package org.jxe.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liuy
* @date 2015年7月13日 下午4:57:55 
* @version V1.0
 */
public class ObjectUtil {
	
	
	/**
	 * 对象是否为空
	* @Title: isNonEmpty
	* @Package org.jxe.utils 
	* @Description: TODO(用一句话描述该文件做什么) 
	* @author liuy
	* @date 2015年7月13日 下午4:58:13 
	* @param obj
	* @return
	 */
	  public static boolean isNonEmpty(Object obj) {
	        return (obj != null) && (obj.toString().trim().length() != 0);
	  }
	  
	  /**
	   * 对象为null，替换
	  * @Title: isNotNull
	  * @Package org.jxe.utils 
	  * @Description: TODO(用一句话描述该文件做什么) 
	  * @author liuy
	  * @date 2015年7月13日 下午4:58:27 
	  * @param obj
	  * @return
	   */
	  public static Object isNotNull(Object obj){
			if(obj==null || obj.toString().length()==0){
				if (obj instanceof String){
					return "";
				} if (obj instanceof Integer){
					return 0;
				}
			}
			return obj;
		}

}
