package com.business.eas;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.business.easEntity.ServiceInfo;
import com.client.WSContext;
import com.ormrpc.services.EASLogin.EASLoginProxy;
import com.ormrpc.services.EASLogin.EASLoginProxyServiceLocator;

public class EasLogin {
	/**
	  * <p>EAS登录。</p>
	  * @author sea
	  * @param service EAS登录所具备的必要条件
	  * @return
	 */
	@SuppressWarnings("static-access")
	protected WSContext doEASLogin(ServiceInfo service){
		java.net.URL endpoint = null;
		
		try {
			//获取登录URL
			endpoint = new java.net.URL(service.getServerName()+"EASLogin");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		EASLoginProxy proxy = null;
		
		try {
			proxy = new EASLoginProxyServiceLocator().getEASLogin(endpoint);
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			//传入登录参数
//			* @param1: 用户名
//			* @param2: 密码
//			* @param3: slnName  eas
//			* @param4: 数据中心,对应的是dataCenter中数据中心id (代码)
//			* @param5: 语言 L2简体
//			* @param6: 数据库类型 0:sqlServer 1:db2 2:oracle 
			return proxy.login(service.getUserName(), service.getPassword(),
					service.getSlnName(), service.getDcName(), 
					service.getLanguage(), service.getDbType());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
