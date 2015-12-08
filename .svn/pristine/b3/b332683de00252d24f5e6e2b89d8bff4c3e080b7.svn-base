package com.business.controller.message;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.service.message.MessageService;
/**
 * 
 * @author 刘念
 * @date 2013年8月6日16:41:29
 * @info 信息发布页面Action
 * @Copyright 
 * Tenwa
 */
@Controller(value = "messageInfoController")
@RequestMapping(value = "/**/acl")
public class MessageInfoController {
	private Logger logger=Logger.getLogger(MessageInfoController.class);
	@Resource(name="messageService")
	private MessageService messageService;
	// #################
	@RequestMapping(value = "/addMessageInfo.acl")
	public String addMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			messageService.addMessaage(request, response);
			if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
			 }
		}catch (Exception e) {
			e.printStackTrace();
			return "新增失败!["+e.getMessage()+"]";
		}
		return null;
	}

	@RequestMapping(value = "/updateMessageInfo.acl")
	public String updateMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			messageService.updateMessage(request, response);
			if(logger.isInfoEnabled()){
				 logger.info("修改成功!");
			 }
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	@RequestMapping(value = "/removeMessageInfo.acl")
	public String removeMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			messageService.removeMessage(request, response);
			if(logger.isInfoEnabled()){
				logger.info("删除成功!");
			}
		}catch (Exception e) {
			return "删除失败!["+e.getMessage()+"]";
		}
		return null;
	}
}
