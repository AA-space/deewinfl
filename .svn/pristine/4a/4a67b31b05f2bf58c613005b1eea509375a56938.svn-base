package com.tenwa.leasing.bean;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.tenwa.leasing.util.LeasingException;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list .properts属性文件读取工具类)
 */
public class PropBean {

	public String	properFile	= "/config.properties";			// 默认在src下面

	private Logger	logger		= Logger.getLogger(PropBean.class);


	public String getProperFile() {
		return properFile;
	}


	public void setProperFile(String properFile) {
		this.properFile = properFile;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 读取指定目录下的.properties文件)
	 * 
	 * @return
	 * @throws LeasingException
	 */
	@SuppressWarnings("unchecked")
	public Hashtable getProperties() {

		Properties prop = new Properties();
		InputStream in;
		Hashtable ht_prop = new Hashtable();

		try {
			in = getClass().getResourceAsStream(properFile);

			prop.load(in);
			Set keyValue = prop.keySet();
			for (Iterator it = keyValue.iterator(); it.hasNext();) {
				String key = (String) it.next();
				ht_prop.put(key, prop.get(key).toString());
			}
		} catch (Exception e) {
			logger.error("IO读取出错，找不到" + properFile + "!");
		}
		return ht_prop;
	}


	public static void main(String[] args) {
		PropBean pb = new PropBean();
		// pb.setProperFile("/test/com/tenwaleasing/a.properties");
		pb.getProperties();

	}

}
