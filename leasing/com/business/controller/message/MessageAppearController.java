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
 * @author 崔天帅
 * @date 2013年9月12日16:12:04
 * @info 信息上报页面Action
 * @Copyright 
 * Tenwa
 */
@Controller(value = "messageAppearController")
@RequestMapping(value = "/**/acl")
public class MessageAppearController {
	private Logger logger=Logger.getLogger(MessageAppearController.class);
	@Resource(name="messageService")
	private MessageService messageService;
	// #################
	@RequestMapping(value = "/addMessageAppear.acl")
	public String addMessageAppear(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			messageService.addMyMessaage(request, response);
			if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
			 }
		}catch (Exception e) {
			return "新增失败!["+e.getMessage()+"]";
		}
		return null;
	}

	@RequestMapping(value = "/updateMessageAppear.acl")
	public String updateMessageAppear(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			messageService.updateMyMessage(request, response);
			if(logger.isInfoEnabled()){
				 logger.info("修改成功!");
			 }
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}

	/*@RequestMapping(value = "/removeMessageAppear.acl")
	public String removeMessageAppear(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			BaseMessage baseMessage = new BaseMessage();
			 this.baseService.copyAndOverrideExistedValueFromStringMap(model, baseMessage, null);
			 this.baseService.removeEntity(baseMessage);
			 if(logger.isInfoEnabled()){
				 logger.info("删除成功!");
			 }
		}catch (Exception e) {
			return "删除失败!["+e.getMessage()+"]";
		}
		return null;
	}*/
}
