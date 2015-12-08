/**
 * 项目名称：    系统名称
 * 包名：              com.business.controller.notice
 * 文件名：         NoticeController.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-7-30-上午10:06:54
 * Copyright：2013XX公司-版权所有
 **/

package com.business.controller.sms;

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
import com.business.entity.notice.SmsNotice;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.utils.QueryUtil;
import com.message.SendMessageUtil;

/**
 * 类名称： SmsController 类描述： 创建人： Administrator 修改人： Administrator
 * 修改时间：2013-7-30 上午10:06:54 修改备注：
 * 
 * @version 1.0.0
 **/
@Controller(value = "smsController")
@RequestMapping(value = "/**/acl")
public class SmsController extends BaseController {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/addSmsTask.acl")
	public String addSmsTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		SmsNotice notice = new SmsNotice();
		this.baseService.copyAndOverrideExistedValueFromStringMap(model, notice, null);
		String result = null;
		String sendNow = model.get("sendnow");
		if("on".equals(sendNow)){
			try {
				result = SendMessageUtil.sendMessage(notice.getPhoneNumber(), notice.getSmsContent());
			} catch (Exception e) {
				logger.error("短信发送任务执行失败。", e);
				result = "发送失败，发送遇到异常：" + e.getMessage();
			}
			notice.setSmsType("IMMEDIATELY");
			notice.setSendResult(result);
			notice.setSendTime(sdf.format(new Date()));
			notice.setSendFlag(1);
		}
		this.baseService.saveEntity(notice);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/sendSmsNow.acl")
	public String sendSmsNow(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String [] ids = model.get("ids").split(",");
		for(String id : ids){
			SmsNotice notice = (SmsNotice) this.tableService.findEntityByID(SmsNotice.class, id);
			if(notice != null){
				if(notice.getSendFlag() == 0){
					String result = null;
					try {
						result = SendMessageUtil.sendMessage(notice.getPhoneNumber(), notice.getSmsContent());
					} catch (Exception e) {
						logger.error("短信发送任务执行失败。", e);
						result = "发送失败，发送遇到异常：" + e.getMessage();
					}
					notice.setSmsType("IMMEDIATELY");
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
	@RequestMapping(value = "/sendSmsAgain.acl")
	public String sendSmsAgain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String [] ids = model.get("ids").split(",");
		for(String id : ids){
			SmsNotice notice = (SmsNotice) this.tableService.findEntityByID(SmsNotice.class, id);
			if(notice != null){
				String result = null;
				try {
					result = SendMessageUtil.sendMessage(notice.getPhoneNumber(), notice.getSmsContent());
				} catch (Exception e) {
					logger.error("短信发送任务执行失败。", e);
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
	
	
	@RequestMapping(value = "/updateSmsTask.acl")
	public String updateSmsTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		SmsNotice notice = (SmsNotice) this.tableService.findEntityByID(SmsNotice.class, model.get("id"));
		String result = null;
		if(notice != null){
			String noticeTime = model.get("noticetime");
			String smsContent = model.get("smscontent");
			String phoneNumber = model.get("phonenumber");
			notice.setNoticeTime(noticeTime);
			notice.setSmsContent(smsContent);
			notice.setPhoneNumber(phoneNumber);
			String sendNow = model.get("sendnow");
			if("on".equals(sendNow) && notice.getSendFlag() == 0){
				try {
					result = SendMessageUtil.sendMessage(notice.getPhoneNumber(), notice.getSmsContent());
				} catch (Exception e) {
					logger.error("短信发送任务执行失败。", e);
					result = "发送失败，发送遇到异常：" + e.getMessage();
				}
				notice.setSmsType("IMMEDIATELY");
				notice.setSendResult(result);
				notice.setSendTime(sdf.format(new Date()));
				notice.setSendFlag(1);
			}
			this.baseService.updateEntity(notice);
		}
		return null;
	}

	@RequestMapping(value = "/removeSmsTask.acl")
	public String removeSmsTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String id = model.get("id");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("id", id);
		SmsNotice notice = (SmsNotice) this.baseService.getNewOrUpdateObject(SmsNotice.class, propertiesMap);
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
