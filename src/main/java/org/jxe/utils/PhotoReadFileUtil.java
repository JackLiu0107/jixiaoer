package org.jxe.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class PhotoReadFileUtil {

	public static void PhotoReadFile(String photoUrl) {
		try {
			// 创建文件输入流对象
			FileInputStream is = new FileInputStream(photoUrl);
			// 设定读取的字节数
			int n = 512;
			byte buffer[] = new byte[n];
			// 读取输入流
			while ((is.read(buffer, 0, n) != -1) && (n > 0)) {
				System.out.print(new String(buffer));
			}
			// 关闭输入流
			is.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * @Title: PhotoReadFile 
	 * @param @param imgFile
	 * @param @param fileName    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static JSONObject PhotoReadFile(MultipartFile imgFile,String fileName){
    	UploadManager uploadManager = new UploadManager();
        Auth auth = Auth.create("98CcaXCQx_GHeUoY7KA2-A8Jlajc_RdpppY41S29", "cmTNCTP0yXdyjZZQ642uwb2yrECs-oz9ijjYHuS9");
        StringMap params = new StringMap().put("x:foo", "foo_val");
        String token = auth.uploadToken("users", fileName);
        Response r = null;
        try {
            r = uploadManager.put(imgFile.getBytes(), fileName, token, params, null, false);
        } catch (QiniuException e) {
        	e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
        StringMap map = null;
        try {
            map = r.jsonToMap();
        } catch (QiniuException e) {
        }
        JSONObject json = new JSONObject();
        json.put("key", map.get("key"));
//        System.out.println(map.get("hash"));
//        System.out.println(map.get("key"));
        return json;
    }
	
	/**
	 * 
	 * @Title: PhotoReadFile 
	 * @param @param imgFile
	 * @param @param fileName    设定文件 
	 * work  上传空间
	 * @return void    返回类型 
	 * @throws
	 */
	public static JSONObject PhotoReadFile(MultipartFile imgFile,String fileName,String work){
    	UploadManager uploadManager = new UploadManager();
        Auth auth = Auth.create("98CcaXCQx_GHeUoY7KA2-A8Jlajc_RdpppY41S29", "cmTNCTP0yXdyjZZQ642uwb2yrECs-oz9ijjYHuS9");
        StringMap params = new StringMap().put("x:foo", "foo_val");
        String token = auth.uploadToken(work, fileName);
        Response r = null;
        try {
            r = uploadManager.put(imgFile.getBytes(), fileName, token, params, null, false);
        } catch (QiniuException e) {
        	e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
        StringMap map = null;
        try {
            map = r.jsonToMap();
        } catch (QiniuException e) {
        }
        JSONObject json = new JSONObject();
        json.put("key", map.get("key"));
        return json;
    }
	
	/**
	 * 
	 * @Title: PhotoReadFile 
	 * @param @param imgFile
	 * @param @param fileName    设定文件 
	 * work  上传空间
	 * @return void    返回类型 
	 * @throws
	 */
	public static JSONObject PhotoReadFile(MultipartFile imgFile [],String work){
		JSONObject json = new JSONObject();
		for (MultipartFile multipartFile : imgFile) {
			String fileName = multipartFile.getOriginalFilename();  
			String name = fileName.substring(0,fileName.lastIndexOf(".")+1)+fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()).toLowerCase();  
	    	UploadManager uploadManager = new UploadManager();
	        Auth auth = Auth.create("F-avIMF9MZ4yHD9ZujbAfmqLWwkhTuo0VU72HbxL", "mqqSIG7OUNMx5WAc_LBcBBiB_G1hHFA7soAj_3sN");
	        StringMap params = new StringMap().put("x:foo", "foo_val");
	        String token = auth.uploadToken(work, fileName);
	        Response r = null;
	        try {
	            r = uploadManager.put(multipartFile.getBytes(), name, token, params, null, false);
	        } catch (QiniuException e) {
	        	e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			}
	        StringMap map = null;
	        try {
	            map = r.jsonToMap();
	        } catch (QiniuException e) {
	        }
	        json.put("key", map.get("key"));
		}
        return json;
    }

}
