package com.business.serviceImpl;

import java.util.List;
import java.util.Map;

import com.business.dao.BaseDao;
import com.business.entity.AttachmentFileUploadInfo;
import com.business.entity.DictionaryData;
import com.kernal.utils.WebUtil;

public abstract class AbstractAttachmentFileList  {
	public abstract List<DictionaryData> getAttachmentFileDictList(String attachmentType,Map<String,String> identifiersMap,Map<String,String> modelData) throws Exception;
	public List<AttachmentFileUploadInfo> getHaveUploadedAttachmentFileUploadInfoList(String attachmentType,Map<String,String> identifiersMap,Map<String,String> modelData) throws Exception{
		String queryHsql = " select afui from AttachmentFileUploadInfo afui  " +
		" where afui.identifierOne = :identifierOne";
		BaseDao baseDao = (BaseDao)WebUtil.getApplicationContext().getBean("baseDao");
		List<AttachmentFileUploadInfo> attachmentFileInfosList = baseDao.findResultsByNamedParamHSQL(queryHsql, new String[]{"identifierOne"},new Object[]{identifiersMap.get("One")});
		return attachmentFileInfosList;
	}
}
