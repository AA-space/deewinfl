package com.business.service.fileTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.business.entity.base.BaseFile;
import com.business.entity.base.FileTemplate;
import com.business.entity.base.FileTemplateDataConfig;
import com.business.serviceImpl.fileTemplate.DataMapCallBack;
/**
 * 
 * @author XU
 * @version 创建时间：2013-8-9 下午02:34:47
 */
public interface FileTemplateService {
   public String addFileTemplate(Map<String,String> model) throws Exception;
   public String updateFileTemplate(Map<String,String>Model)throws Exception;
   public String removeFileTemplate(Map<String,String>model)throws Exception;
   public String addFileTempalteDateConfig(Map<String,String>model)throws Exception;
   public String loadFileTemplateDateConfig(Map<String,String>model)throws Exception;
   public String uploadTemplateFtl(HttpServletRequest request,HttpServletResponse response)throws Exception; 
   public String downloadTemplateFtl(HttpServletRequest request,HttpServletResponse response)throws Exception;
   public String removeTemplateFtl(HttpServletRequest request,HttpServletResponse response)throws Exception;
   public String uploadTemplateSource(HttpServletRequest request,HttpServletResponse response)throws Exception;
   public String downloadTemplateSource(HttpServletRequest request,HttpServletResponse response)throws Exception;
   public String removeTemplateSource(HttpServletRequest request,HttpServletResponse response)throws Exception;
   public List<FileTemplate> LoadTemplateByClassify(Map<String,String> model) throws Exception;
   public String createCheckBoxByTemplate(List<FileTemplate> wcList,int changeRowNum) throws Exception;
   public String createFileByTemplate(Map<String,String> model) throws Exception;
   public Map    getTemplateData(Set<FileTemplateDataConfig>templateDataConfigs,Map<String,String> pageMap) throws Exception;
   public String createRealFile(FileTemplate ft,Map<String,Object> dataMap,String modelname) throws Exception;
   public String downloadAttachById(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String downloadAttachByIdToEdit(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String downloadAttachByName(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String uploadEditTemplate(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String downloadFileTempalteByClass(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public void addlogFileOper(BaseFile bf,String operType) throws Exception;
   public BaseFile createFileByTemplateClass(Map<String,String>model,DataMapCallBack... dataMapCallBacks) throws Exception;
   public BaseFile saveUpFiletoService(MultipartFile  multipartFile,Map<String,String>modelData) throws Exception;
   public String getuploadFileAllDir(String modelname) throws Exception;
   public String getuploadFileDir(String modelname) throws Exception;
   public String getfile(Map<String,String> model,BaseFile bf) throws Exception;
   public void writeDatatoTemplateExcel(String tempfile,Map<String,Object> model,String targetFile ) throws Exception;
   public <T> Collection<T>  getEntitysFromExcel(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String uploadExcelFileToObject(HttpServletRequest request,HttpServletResponse response) throws Exception;
   public String getDefaultAjaxCallBack(String message) throws Exception;
   public String getdownloadfileName(Map<String,String> model,String fileName)throws Exception;
   public String removeTemplate()throws Exception;
}
