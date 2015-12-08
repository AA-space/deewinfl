
 /**
 * 项目名称：    系统名称
 * 包名：              com.bussiness.service
 * 文件名：         IHelloService.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-7-上午10:49:24
 * Copyright：2013XX公司-版权所有
 **/

package com.business.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
//import javax.jws.soap.SOAPBinding;
//import javax.jws.soap.SOAPBinding.Style;
//import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;


 /**
 * 类名称：     IHelloService
 * 类描述：     
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-5-7 上午10:49:24
 * 修改备注：
 * @version 1.0.0
 **/

//接口   
@WebService(targetNamespace="http://service.ws.mywebapp.com/")  
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@WSDLDocumentationCollection(  
		    {  
		    	@WSDLDocumentation(value="###默认顶层注释<>"),  
		        @WSDLDocumentation(value = "###注释My top level description",  
		                           placement = WSDLDocumentation.Placement.TOP),  
		        @WSDLDocumentation(value = "###注释My binding description",  
		                           placement = WSDLDocumentation.Placement.BINDING)  
		    }  
)
public interface HelloWorld { 
	//@SOAPBinding(style = Style.RPC,use = Use.LITERAL)
	@WebMethod(action="sayHello",operationName="sayHello",exclude=false)
	@WSDLDocumentation(value="####方法注释")
    public String sayHello(@WebParam(partName="p1",mode=WebParam.Mode.IN,name = "username") String username);  
}  
