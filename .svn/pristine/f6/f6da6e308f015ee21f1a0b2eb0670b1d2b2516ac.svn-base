package com.tenwa.leasing.bean;

import java.util.Hashtable;

import com.tenwa.leasing.util.xml.ParseXMLConfigFactory;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 读取classes指定目录下.xml文件中的配置信息 默认为:config.xml)
 */
public class ConfigBean {

	private String	configFile	= "config.xml"; // 默认值


	public String getConfigFile() {
		return configFile;
	}


	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 读取指定文件（默认为config.xml文件）的键值信息,并以HashTable形式保存)
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable getConfigInfo() throws Exception {
		ParseXMLConfigFactory parse = new ParseXMLConfigFactory();
		Hashtable ht = new Hashtable();
		// 设置所要读取的文件
		parse.setConfigFile(configFile);
		ht = parse.getConfiguration();
		// System.out.println(ht);
		return ht;

	}


	public static void main(String[] args) throws Exception {
		ConfigBean cfb = new ConfigBean();
		cfb.getConfigInfo();
	}

}
