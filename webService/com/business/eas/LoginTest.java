package com.business.eas;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.business.easEntity.ServiceInfo;
import com.client.WSContext;
import com.ormrpc.services.EASLogin.EASLoginProxyServiceLocator;
 
public class LoginTest {
	
	/** 第3步 登陆 
	 * web service客户端登陆 
	 * @param1: 用户名
	 * @param2: 密码
	 * @param3: slnName  eas
	 * @param4: 数据中心,对应的是dataCenter中数据中心id (代码)
	 * @param5: 语言 L2简体
	 * @param6: 数据库类型 0:sqlServer 1:db2 2:oracle 
	 */
	public WSContext login(){
		EASLoginProxyServiceLocator proxy = new EASLoginProxyServiceLocator();
		WSContext cxt = null;
		//TODO:增加一张表
//		create table eas_login(
//				 id varchar(100) not null,
//				 userName varchar(100) not null,
//				 [password]  varchar(100) not null,
//				 slnName    varchar(100) not null,
//				 dataCenter_id varchar (100) not null,
//				 lung   varchar(100) not null,
//				 [dataBase]  varchar(100) not null
//		) 
		//cxt = proxy.getEASLogin().login("user", "eas2010", "eas", "1", "l2", 0);
		String id = "01";//唯一确定登录的调教
		String userName = "";//用户名
		String password = "";//密码
		String slnName = "";//eas
		String dataCenter_id = "";//
		String lung = "";//
		int dataBase = 0;
 
			//测试登录条件:
//			* @param1: 用户名
//			* @param2: 密码
//			* @param3: slnName  eas
//			* @param4: 数据中心,对应的是dataCenter中数据中心id (代码)
//			* @param5: 语言 L2简体
//			* @param6: 数据库类型 0:sqlServer 1:db2 2:oracle 
		//http://192.168.1.2:6888/ormrpc/services
			try {
				cxt = proxy.getEASLogin().login("user", "deyin1602", "eas", "easdb", "l2", 2);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Sessinid:+++++++++++++++: "+cxt.getSessionId());
		 
		return cxt;
	}	
	
	
	
	
	/**
	 * <p>DB字符串取出处理。</p>
	 * @author common.jsp
	 * @param str 传入字符串
	 * @return 字符串为空返回空串
	 */
	public String getDBStr(String str){
		try
		{
	        String temp_n = str;
	        if ((temp_n == null) || (temp_n.equals("")) || (temp_n.equals("null"))){
	        	temp_n = "";
	        }
	        return temp_n; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		//测试登录条件:
//		* @param1: 用户名
//		* @param2: 密码
//		* @param3: slnName  eas
//		* @param4: 数据中心,对应的是dataCenter中数据中心id (代码)
//		* @param5: 语言 L2简体
//		* @param6: 数据库类型 0:sqlServer 1:db2 2:oracle 
		System.out.println("用户名1:"+ServiceInfo.getUserName());
		System.out.println("密码2:"+ServiceInfo.getPassword());
		System.out.println("slnName3:"+ServiceInfo.getSlnName());
		System.out.println("数据中心4:"+ServiceInfo.getDcName());
		System.out.println("语言5:"+ServiceInfo.getLanguage());
		System.out.println("数据库类型6:"+ServiceInfo.getDbType());
		
		WSContext cxt;
		LoginTest login = new LoginTest();
		
		cxt = login.login();
		if(cxt == null){
			System.out.println("登陆失败!");
		}else{
			System.out.println("SESSION:"+cxt.getSessionId());
			System.out.println("用户名:"+cxt.getUserName());
			System.out.println("密码:"+cxt.getPassword());
			System.out.println("SlnName:"+cxt.getSlnName());
			
		}
		System.out.println("Sessinid:+++++++++++++++: "+cxt.getSessionId());
	}
	
}
