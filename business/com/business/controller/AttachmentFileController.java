
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.controller
 * 文件名：         AttachmentFileController.java
 * 版本信息：    1.0.0
 * 创建日期：     2012-11-9-上午11:41:07
 * Copyright：2012XX公司-版权所有
 **/

package com.business.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.model.FileProcess;
import com.business.service.AttachmentFileService;
import com.kernal.utils.QueryUtil;


 /**
 * 类名称：     AttachmentFileController
 * 类描述：     
 * 创建人：     tracywindy
 * 修改人：     tracywindy
 * 修改时间：2012-11-9 上午11:41:07
 * 修改备注：
 * @version 1.0.0
 **/
@Controller(value="attachmentFileController")
@RequestMapping("/**/attachmentfile")
public class AttachmentFileController extends BaseController 
{
   @Resource(name="attachmentFileService")
   private AttachmentFileService attachmentFileService ;

	@RequestMapping(value="/getAttachmentFileTableData.action")
	public String getAttachmentFileTableData(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String returnInfo = this.attachmentFileService.getAttachmentFileDetailsJsonString(modelData);
		this.output(response, returnInfo);
		return null;
	}
	
	@RequestMapping(value="/getAttachmentFileUploadedPercent.action")
	public String getAttachmentFileUploadedPercent(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		//Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String attachmentFileProcessKey = "attachmentFileProcessKey";//modelData.get("attachmentFileProcessKey");
		HttpSession session = request.getSession();
		String uploadedPercent =  "0.1";
		Object FileProcessKey = session.getAttribute(attachmentFileProcessKey);
		
		if(null != FileProcessKey){
			FileProcess fileProcess = (FileProcess)FileProcessKey;
			uploadedPercent = fileProcess.getUploadedPercent();
			boolean uploadedFinish = fileProcess.getUploadedFinish();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("uploadedFinish",uploadedFinish );
			jsonObj.put("uploadedPercent",uploadedPercent );
			if(100 == Double.parseDouble(uploadedPercent)){
				if(!uploadedFinish){
					fileProcess.setUploadedFinish(true);
					fileProcess.setUploadedSize(0);
				}
				else
				{
					session.removeAttribute(attachmentFileProcessKey);
				}
			}
			this.output(response,jsonObj.toString());
		}
		return null;
	}
	
	@RequestMapping(value="/uploadAttachmentFile.action")
	public String uploadAttachmentFile(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile  multipartFile = multipartRequest.getFile("name_upload_file_name");
		String returnInfo = this.attachmentFileService.uploadAttachmentFile(request,multipartFile, modelData);
		String ajaxCallBackScript = "<script type='text/javascript'>window.parent.uploadAttachmentFileCallBack('"+returnInfo+"');</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}
	@RequestMapping(value="/downloadAttachmentFile.action")
	public String downloadAttachmentFile(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String uploadAttachmentFileDetailId = modelData.get("uploadAttachmentFileDetailId");
		String browserType = modelData.get("browserType");
		this.attachmentFileService.downloadAttachmentFile(response,uploadAttachmentFileDetailId,browserType);
		return null;
	}
	//批量下载
	@RequestMapping(value="/downloadBatchAttachmentFiles.action")
	public String downloadBatchAttachmentFiles(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String attchmentDetailBatchDownloadIdStr = modelData.get("attchmentDetailBatchDownloadIdStr");
		String batchDownloadAttachmentFileTitle =  modelData.get("batchDownloadAttachmentFileTitle");
		String browserType = modelData.get("browserType");
		this.attachmentFileService.downloadBatchAttachmentFiles(response,batchDownloadAttachmentFileTitle,attchmentDetailBatchDownloadIdStr,browserType);
		return null;
	}
	@RequestMapping(value="/removeAttachmentFile.action")
	public String removeAttachmentFile(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String uploadAttachmentFileDetailId = modelData.get("uploadAttachmentFileDetailId");
		String returnInfo = this.attachmentFileService.removeAttachmentFile(uploadAttachmentFileDetailId);
		String ajaxCallBackScript = "<script type='text/javascript'>window.parent.uploadAttachmentFileCallBack('"+returnInfo+"');</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}
	 /**
	 * @param attachmentFileService the attachmentFileService to set
	 **/
	
	public void setAttachmentFileService(AttachmentFileService attachmentFileService) {
		this.attachmentFileService = attachmentFileService;
	}
	
	
	 /**
	 * attachmentFileService
	 * @return the attachmentFileService
	 * @since 1.0.0
	 **/
	
	public AttachmentFileService getAttachmentFileService() {
		return attachmentFileService;
	} 
	
	@RequestMapping(value="/updateOnlineAttachmentFile.action")
	public String updateOnlineAttachmentFile(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile  multipartFile = multipartRequest.getFile("editOnlineAttachmentFile");
		String returnInfo = this.attachmentFileService.updateOnlineAttachmentFile(multipartFile, modelData);
		String ajaxCallBackScript = "<script type='text/javascript'>window.top.updateOnlineAttachmentFileCallBack('"+returnInfo+"');</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}
	
}
