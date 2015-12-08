
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.serviceImpl
 * 文件名：         HelloService.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-7-上午10:50:19
 * Copyright：2013XX公司-版权所有
 **/

package com.business.serviceImpl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.business.service.HelloWorld;


 /**
 * 类名称：     HelloService
 * 类描述：     
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-5-7 上午10:50:19
 * 修改备注：
 * @version 1.0.0
 **/
//实现   

@Component("helloWorld") 
@WebService(endpointInterface = "com.business.service.HelloWorld",targetNamespace="http://service.ws.mywebapp.com/")   
public class HelloWorldImpl implements HelloWorld { 
	@WebMethod(operationName="sayHello",exclude=false)
    public String sayHello(@WebParam(name = "username") String username) {   
        return username+"! Welcome to CXF in Method[HelloService sayHello]";   
    }   
} 
