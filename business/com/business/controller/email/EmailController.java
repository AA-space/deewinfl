/**
 * 项目名称：    系统名称
 * 包名：              com.business.controller.notice
 * 文件名：         NoticeController.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-7-30-上午10:06:54
 * Copyright：2013XX公司-版权所有
 **/

package com.business.controller.email;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.notice.EmailNotice;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.email.SendEmailUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;

/**
 * 类名称： EmailController 类描述： 创建人： Administrator 修改人： Administrator
 * 修改时间：2013-7-30 上午10:06:54 修改备注：
 * 
 * @version 1.0.0
 **/
@Controller(value = "emailController")
@RequestMapping(value = "/**/acl")
public class EmailController extends BaseController {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/downloadEmailAttachmentFile.acl")
	public String downloadEmailAttachmentFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String fileName = model.get("fileName");
		String filePath = model.get("filePath");
		String browserType = model.get("browserType");
		if ("firefox".equals(browserType)) {
			fileName = new String(fileName.getBytes("GB2312"), "ISO-8859-1");
		} else if ("chrome".equals(browserType)) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else if ("safari".equals(browserType)) {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		} else {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		response.setContentType("text/html; charset=UTF-8");
		OutputStream out = response.getOutputStream();
		ResourceUtil.getFileUploadOperation().downloadFile(filePath, out, null);
		return null;
	}

	@RequestMapping(value = "/addEmailTask.acl")
	public String addEmailTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		EmailNotice notice = new EmailNotice();
		this.baseService.copyAndOverrideExistedValueFromStringMap(model, notice, null);
		String result = null;
		String sendNow = model.get("sendnow");
		if("on".equals(sendNow)){
			try {
				result = SendEmailUtil.sendSimpleMessage(notice.getEmailAddress(), notice.getEmailTitle(), notice.getEmailContent(), notice.getFileAddress());
			} catch (Exception e) {
				logger.error("邮件发送任务执行失败。", e);
				result = "发送失败，发送遇到异常：" + e.getMessage();
			}
			notice.setEmailType("IMMEDIATELY");
			notice.setSendResult(result);
			notice.setSendTime(sdf.format(new Date()));
			notice.setSendFlag(1);
		}
		this.baseService.saveEntity(notice);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/sendEmailNow.acl")
	public String sendEmailNow(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String [] ids = model.get("ids").split(",");
		for(String id : ids){
			EmailNotice notice = (EmailNotice) this.tableService.findEntityByID(EmailNotice.class, id);
			if(notice != null){
				if(notice.getSendFlag() == 0){
					String result = null;
					try {
						result = SendEmailUtil.sendSimpleMessage(notice.getEmailAddress(), notice.getEmailTitle(), notice.getEmailContent(), notice.getFileAddress());
					} catch (Exception e) {
						logger.error("邮件发送任务执行失败。", e);
						result = "发送失败，发送遇到异常：" + e.getMessage();
					}
					notice.setEmailType("IMMEDIATELY");
					notice.setSendResult(result);
					notice.setSendTime(sdf.format(new Date()));
					notice.setSendFlag(1);
				}
				this.baseService.updateEntity(notice);
			}
		}
		return "{result : 'success'}";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/sendEmailAgain.acl")
	public String sendEmailAgain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String [] ids = model.get("ids").split(",");
		for(String id : ids){
			EmailNotice notice = (EmailNotice) this.tableService.findEntityByID(EmailNotice.class, id);
			if(notice != null){
				String result = null;
				try {
					result = SendEmailUtil.sendSimpleMessage(notice.getEmailAddress(), notice.getEmailTitle(), notice.getEmailContent(), notice.getFileAddress());
				} catch (Exception e) {
					logger.error("邮件发送任务执行失败。", e);
					result = "发送失败，发送遇到异常：" + e.getMessage();
				}
				notice.setSendResult(result);
				notice.setSendTime(sdf.format(new Date()));
				notice.setSendFlag(1);
				this.baseService.updateEntity(notice);
			}
		}
		return "{result : 'success'}";
	}
	
	
	@RequestMapping(value = "/updateEmailTask.acl")
	public String updateEmailTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		EmailNotice notice = (EmailNotice) this.tableService.findEntityByID(EmailNotice.class, model.get("id"));
		String result = null;
		if(notice != null){
			String noticeTime = model.get("noticetime");
			String emailContent = model.get("emailcontent");
			String emailAddress = model.get("emailaddress");
			String emailTitle = model.get("emailtitle");
			notice.setNoticeTime(noticeTime);
			notice.setEmailContent(emailContent);
			notice.setEmailAddress(emailAddress);
			notice.setEmailTitle(emailTitle);
			String sendNow = model.get("sendnow");
			if("on".equals(sendNow) && notice.getSendFlag() == 0){
				try {
					result = SendEmailUtil.sendSimpleMessage(notice.getEmailAddress(), notice.getEmailTitle(), notice.getEmailContent(), notice.getFileAddress());
				} catch (Exception e) {
					logger.error("邮件发送任务执行失败。", e);
					result = "发送失败，发送遇到异常：" + e.getMessage();
				}
				notice.setEmailType("IMMEDIATELY");
				notice.setSendResult(result);
				notice.setSendTime(sdf.format(new Date()));
				notice.setSendFlag(1);
			}
			this.baseService.updateEntity(notice);
		}
		return null;
	}

	@RequestMapping(value = "/removeEmailTask.acl")
	public String removeEmailTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String id = model.get("id");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("id", id);
		EmailNotice notice = (EmailNotice) this.baseService.getNewOrUpdateObject(EmailNotice.class, propertiesMap);
		if(notice != null){
			notice.setSendFlag(2);
			this.baseService.updateEntity(notice);
		}
		return null;
	}

	public String getError(String message) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public BaseService getBaseService() {
		return baseService;
	}
}
