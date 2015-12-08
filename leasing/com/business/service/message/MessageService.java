
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.service.message
 * 文件名：         MessageService.java
 * 版本信息：    1.0.0
 * 创建日期：     2013年8月7日14:44:29
 * Copyright：2013XX公司-版权所有
 **/

package com.business.service.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 /**
 * 类名称：     MessageService
 * 类描述：     
 * 创建人：     刘念
 * 修改人：     刘念
 * 修改时间：2013年8月7日14:44:51
 * 修改备注：
 * @version 1.0.0
 **/

public interface MessageService{
	public void addMessaage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public void updateMessage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public void addMyMessaage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public void updateMyMessage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public void removeMessage(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
