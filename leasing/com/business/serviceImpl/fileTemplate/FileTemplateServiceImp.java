package com.business.serviceImpl.fileTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.base.BaseFileRecorder;
import com.business.entity.base.FileTemplate;
import com.business.entity.base.FileTemplateDataConfig;
import com.business.exception.BusinessException;
import com.business.model.ExcelVersionEnum;
import com.business.service.TableService;
import com.business.service.fileTemplate.FileExcelService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.service.vouchersFactory.TaxVatUploadInfoService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
import com.jbpm.utils.JBPMUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.FileUtil;
import com.kernal.utils.PoiExcelUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.UUIDUtil;
import com.kernal.utils.WebUtil;
import com.kernal.utils.XMLDataUtil;
import com.tenwa.leasing.util.StrTools;
import com.tenwa.leasing.util.excel.ReadExecl;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

@Service(value = "fileTemplateService")
public class FileTemplateServiceImp extends AbstractBaseServiceImpl implements FileTemplateService {

	@Resource
	private BaseDao baseDao;

	@Resource(name = "tableService")
	private TableService tableService;

	@Resource(name = "fileExcelService")
	private FileExcelService fileExcelService;
	
	@Resource(name="taxVatUploadInfoService")
	private TaxVatUploadInfoService taxVatUploadInfoService;

	private Logger logger = Logger.getLogger(FileTemplateServiceImp.class);
	private String wordTemplateDir = ResourceUtil.getWordTemplatesRelativeStorePath();
	private String wordSourceTemplateDir = ResourceUtil.getWordSourceTemplatesRelativeStorePath();
	private String contractWordDir = ResourceUtil.getWordFilesRelativeStorePath();
	private static ObjectMapper jsonMapper = new ObjectMapper();
    
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public String addFileTemplate(Map<String, String> model) throws Exception {
		// TODO Auto-generated method stub
		FileTemplate ft = new FileTemplate();
		Map<String, String> classFieldMapping = new HashMap<String, String>();
		classFieldMapping.put("DictionaryData", "code");
		this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(model, ft, null);
		ft.setTemplateNo(WorkflowUtil.getFileTemplateNoInfoSerialNumber(null, this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate()));
		this.getBussinessDao().saveOrUpdateEntity(ft);
		return null;
	}

	@Override
	public String updateFileTemplate(Map<String, String> model) throws Exception {
		String id = model.get("id");
		FileTemplate fileTemplate = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, id);
		this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(model, fileTemplate, null);
		this.getBussinessDao().saveOrUpdateEntity(fileTemplate);
		return null;
	}

	@Override
	public String removeFileTemplate(Map<String, String> model) throws Exception {
		String id = model.get("id");
		FileTemplate baseWord;
		baseWord = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, id);
		/*
		 * String uploadDirPath =
		 * FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath
		 * ())+this.wordTemplateDir; String
		 * uploadedFileFullPath=uploadDirPath+"/"+baseWord.getTemplatePath();
		 * try {
		 * ResourceUtil.getFileUploadOperation().removeFile(uploadedFileFullPath
		 * ); }catch(Exception e) { String info =
		 * "强制删除文件："+uploadedFileFullPath; if(logger.isInfoEnabled()) {
		 * logger.info(info); } }
		 */
		this.getBussinessDao().removeEntity(baseWord);
		return null;
	}

	@Override
	public BaseFile saveUpFiletoService(MultipartFile multipartFile, Map<String, String> modelData) throws Exception {
		// TODO Auto-generated method stub
		BaseFile bf = new BaseFile();
		String SystemDate = DateUtil.getSystemDate();
		Map<String, String> classFieldMapping = new HashMap<String, String>();
		String modelname = modelData.get("modelname");
		classFieldMapping.put("DictionaryData", "code");
		this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(modelData, bf, classFieldMapping);
		bf.setFileName(multipartFile.getOriginalFilename());
		InputStream source = multipartFile.getInputStream();
		String uploadDirPath = getuploadFileAllDir(modelname);
		String dirpath = getuploadFileDir(modelname);
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		String fileName = UUID.randomUUID() + suffix;
		String uploadedFileFullPath = uploadDirPath + fileName;
		bf.setFileRealAddress(dirpath + fileName);
		ResourceUtil.getFileUploadOperation().uploadFile(uploadedFileFullPath, source, null);
		this.getBussinessDao().saveOrUpdateEntity(bf);
		this.addlogFileOper(bf, "上传");
		return bf;
	}

	@Override
	/**
	 * 将Excl中数据导入实体
	 */
	public <T> Collection<T> getEntitysFromExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List newC = new ArrayList();
		InputStream is = null;
		JSONArray resultJsonArray;
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile("tableImportTemplate");
			if (null == multipartFile) {
				throw new BusinessException("没有上传附件");
			}
			Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String targetClass = model.get("targetClass");
			if (null == targetClass) {
				throw new BusinessException("没有要插入的实体");
			}
			Class<?> targetObject = Class.forName(targetClass);
			String custMethod = "";
			Method operatormethod = null;
			if (model.containsKey("custoperatorMethod")) {
				custMethod = model.get("custoperatorMethod");
				if (null != custMethod && (!"".equals(custMethod.toString().trim()))) {
					try {
						operatormethod = fileExcelService.getClass().getMethod(custMethod, targetObject, Map.class, Integer.class);
					} catch (Exception e) {
						throw new BusinessException("getEntitysFromExcel中没有自定义方法" + custMethod + ":" + e.getMessage());
					}
				}
			}
			BaseFile bf = saveUpFiletoService(multipartFile, model);// 记录上传操作
			// 列名对象解析
			String importExcelColumnStr = model.get("parames");
			JSONArray importExcelColumnJsonArray = new JSONArray(importExcelColumnStr);
			String header = "";
			String mapping = "";
			String fieldclass = "";
			String field = "";
			Map<String, String> classFieldMap = new HashMap<String, String>();
			Map<String, String> excelFieldMap = new HashMap<String, String>();
			List excelObject = new ArrayList();
			try {
				for (int i = 0; i < importExcelColumnJsonArray.length(); i++) {
					header = "";
					mapping = "";
					fieldclass = "";
					field = "";
					JSONObject jsonColumn = importExcelColumnJsonArray.getJSONObject(i);
					// {header:'付款账号',mapping:'clientaccount',fieldclass:'',field:''},
					header = jsonColumn.getString("header");
					mapping = jsonColumn.getString("mapping");
					if (jsonColumn.has("fieldclass")) {
						fieldclass = StringUtil.empty2Other(jsonColumn.getString("fieldclass"), "");
					}
					if (jsonColumn.has("field")) {
						field = StringUtil.empty2Other(jsonColumn.getString("field"), "");
					}
					if (fieldclass != "" && field != "") {
						classFieldMap.put(fieldclass, field);
					}
					excelFieldMap.put(header, mapping);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new BusinessException("解析配置的参数出错" + e1.getMessage());
			}
			// 读EXCEL
			is = multipartFile.getInputStream();
			resultJsonArray = new JSONArray();
			Workbook wb = null;
			String importFileName = multipartFile.getOriginalFilename().toLowerCase();
			Sheet sheet;
			try {
				if (importFileName.endsWith("xlsx")) {
					wb = PoiExcelUtil.readWorkbook(is, ExcelVersionEnum.VERSION2007);
				} else {
					wb = PoiExcelUtil.readWorkbook(is, ExcelVersionEnum.VERSION2003);
				}
				sheet = wb.getSheetAt(0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new BusinessException("解析excel现错" + e1.getMessage());
			}
			/*
			 * String skipRowCountStr = StringUtil.nullToString(
			 * model.get("skipRowCount"),"0"); int skipRowCount =
			 * Integer.parseInt(skipRowCountStr);
			 */
			String headerIndexStr = StringUtil.nullToString(model.get("headerIndex"), "1");
			String dataIndexStr = StringUtil.nullToString(model.get("dataIndex"), "2");
			int headerIndex = Integer.parseInt(headerIndexStr);
			int dataIndex = Integer.parseInt(dataIndexStr);
			String[] headerIndexs = headerIndexStr.split(",");
			List<Row> headerRows = new ArrayList<Row>();
			Boolean empty = true;
			// 标题行
			for (int i = 0; i < headerIndexs.length; i++) {
				headerRows.add(sheet.getRow(Integer.parseInt(headerIndexs[i]) - 1));
			}
			// 遍历列和单元格
			Iterator rit = sheet.rowIterator();
			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int rowIndex = dataIndex - 1; rowIndex < rowCount; rowIndex++) {
				JSONObject jsonObj = new JSONObject();
				Row row = (Row) sheet.getRow(rowIndex);// rit.next();
				//System.out.println("行号=====:" + rowIndex);
				empty = true;
				if(null!=row){
					for( int j=0;j<row.getPhysicalNumberOfCells();j++){
						Cell cell = (Cell) row.getCell(j);
		            	String value = "";
					value = PoiExcelUtil.getCellValue(cell);
					int colIndex = cell.getColumnIndex();
					String headerName = "";
					String name = "";
					String tname = "";
					System.out.print("列： "+cell.getColumnIndex() + "=  ");
					for (Row r : headerRows) {
						String headername = r.getCell(colIndex).getStringCellValue().trim();
						System.out.print(headername + " | ");
						name = excelFieldMap.get(headername);
						if (null != name && (!"".equals(name))) {
							tname = name;
						}
					}
					if ((!"".equals(tname)) && (!"".equals(value))) {
						empty = false;
						jsonObj.put(tname, value);
						System.out.println(value);
					}
				}}
				if (empty == false) {
					Object sourectObject = targetObject.newInstance();
					
					//导入的数据在入库之前做回调, 每行数据做回调。
					if (model.get("uploadDataCallBack")!=null) { 
						String uploadDataCallBack = model.get("uploadDataCallBack").toString();
						if (null != uploadDataCallBack && (!"".equals(uploadDataCallBack.toString().trim()))) {
							try {
								Method dataInitMehtodObject = fileExcelService.getClass().getMethod(uploadDataCallBack, JSONObject.class);
								
								jsonObj =  (JSONObject) dataInitMehtodObject.invoke(fileExcelService, jsonObj);
								
							} catch (Exception e1) {
								throw new BusinessException("自定义方法没有找到" + uploadDataCallBack);
							}
						}
					}	
					
					this.tableService.copyAndOverrideExistedValueFromJSONObject(jsonObj, sourectObject, classFieldMap);
					try {
						BeanUtils.getPropertyDescriptor(sourectObject.getClass(), "upLoadId").getWriteMethod().invoke(sourectObject, bf);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						throw new BusinessException("没有文件的ID:upLoadId"+e1.getMessage());
					}
					if (!"".equals(operatormethod) && null != operatormethod) {
						try {
							sourectObject = operatormethod.invoke(fileExcelService, sourectObject, model, (Integer) (rowIndex+1));

						} catch (Exception e) {
							InvocationTargetException targetEx = (InvocationTargetException) e;
							Throwable t = targetEx.getTargetException();
							throw new BusinessException(t.getMessage());
						}
					}
					newC.add(sourectObject);
				}

			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			is.close();
			throw new BusinessException(e.getMessage());
		}
		//throw new BusinessException("123");
		return newC;
	}

	@Override
	public String getuploadFileAllDir(String modelname) throws Exception {
		// TODO Auto-generated method stub
		String SystemDate = DateUtil.getSystemDate();
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir + "/";
		String dirpath = modelname + "/" + SystemDate.replaceAll("-", "/") + "/";
		return uploadDirPath + dirpath;
	}

	@Override
	public String getuploadFileDir(String modelname) throws Exception {
		// TODO Auto-generated method stub
		String SystemDate = DateUtil.getSystemDate();
		String dirpath = modelname + "/" + SystemDate.replaceAll("-", "/") + "/";
		return dirpath;
	}

	@Override
	public String addFileTempalteDateConfig(Map<String, String> model) throws Exception {
		String jsonData = model.get("jsonData");
		String wordid = model.get("id");
		FileTemplate bw = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, wordid);
		Map<String, String> propertiesMap = new HashMap<String, String>();
		propertiesMap.put("DictionaryData", "code");
		this.getBussinessDao().updateOneToManyCollections(bw, "fileTemplateDataConfigs", FileTemplateDataConfig.class, "fileTemplate", jsonData, propertiesMap, true);
		return null;
	}

	@Override
	public String loadFileTemplateDateConfig(Map<String, String> model) throws Exception {
		String wordid = model.get("id");
		List<FileTemplateDataConfig> fileTemplatelist = new ArrayList<FileTemplateDataConfig>();
		FileTemplate ft = new FileTemplate();
		ft = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, wordid);
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("fileTemplate", ft);
		Map<String, String> fieldClassMapping = new HashMap<String, String>();
		fieldClassMapping.put("FileTemplate", "id");
		fileTemplatelist = (List<FileTemplateDataConfig>) this.getBussinessDao().findEntityByProperties(FileTemplateDataConfig.class, propertiesMap);
		for (int i = 0; i < fileTemplatelist.size(); i++) {
			fileTemplatelist.get(i).setOperType("old");
		}
		if (fileTemplatelist != null && fileTemplatelist.size() > 0) {
			return this.getBussinessDao().getCollectionEntitiesPropertiesToJsonArrayString(fileTemplatelist, fieldClassMapping);
		}
		return "";
	}

	@Override
	public String uploadTemplateFtl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String parames = modelData.get("parames");
		Map[] newSetMaps = jsonMapper.readValue("[" + parames + "]", Map[].class);
		Map<String, String> paramesMap = newSetMaps[0];
		FileTemplate fileTemplate;
		fileTemplate = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, paramesMap.get("id"));
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("tableImportTemplate");
		InputStream source = multipartFile.getInputStream();
		String uploadDirPath =WebUtil.getWebContextRealPath()+"template/"+ this.wordTemplateDir;
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		String uuid="";
		if(null!=fileTemplate.getTemplatePath()){
			uuid=fileTemplate.getTemplatePath();
			uuid=uuid.substring(0, uuid.indexOf("."));
		}else{
			uuid=UUID.randomUUID().toString();
		}
		String fileName =uuid+ suffix;
		String uploadedFileFullPath = FileUtil.getFilePathString(uploadDirPath + "/" + fileName);
		fileTemplate.setTemplatePath(fileName);
		this.getBussinessDao().saveOrUpdateEntity(fileTemplate);
		ResourceUtil.getFileUploadOperation().uploadFile(uploadedFileFullPath, source, null);
		return null;
	}

	@Override
	public String downloadTemplateFtl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
			String id = modelData.get("id");
			FileTemplate fileTemplate;
			fileTemplate = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, id);
			String paddress = fileTemplate.getTemplatePath();
			String suffix = paddress.substring(paddress.lastIndexOf("."));
			String fileTitleName = fileTemplate.getTemplateName() + suffix;
			fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
			String uploadDirPath = WebUtil.getWebContextRealPath()+"template/" + this.wordTemplateDir;
			String downloadedFileFullPath = uploadDirPath + "/" + fileTemplate.getTemplatePath();
			downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
			File file=new File(downloadedFileFullPath);
			if(!file.isFile()){
				throw new BusinessException("没有下载文件：");
			}
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
			response.setContentType("text/html; charset=UTF-8");
			OutputStream out = response.getOutputStream();
			ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		return null;
	}

	@Override
	public String removeTemplateFtl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadTemplateSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String parames = modelData.get("parames");
		Map[] newSetMaps = jsonMapper.readValue("[" + parames + "]", Map[].class);
		Map<String, String> paramesMap = newSetMaps[0];
		FileTemplate fileTemplate;
		fileTemplate = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, paramesMap.get("id"));
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("tableImportTemplate");
		InputStream source = multipartFile.getInputStream();
		String uploadDirPath =WebUtil.getWebContextRealPath()+"template/"+this.wordSourceTemplateDir; 
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		String uuid="";
		if(null!=fileTemplate.getSoureTemplatePath()){
			uuid=fileTemplate.getSoureTemplatePath();
			uuid=uuid.substring(0, uuid.indexOf("."));
		}else{
			uuid=UUID.randomUUID().toString();
		}
		String fileName = uuid + suffix;
		String uploadedFileFullPath = FileUtil.getFilePathString(uploadDirPath + "/" + fileName);
		System.out.println(uploadedFileFullPath);
		fileTemplate.setSoureTemplatePath(fileName);
		this.getBussinessDao().saveOrUpdateEntity(fileTemplate);
		ResourceUtil.getFileUploadOperation().uploadFile(uploadedFileFullPath, source, null);
		BaseFile bf = new BaseFile();
		modelData.remove("id");
		this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(modelData, bf, null);
		bf.setFileName(multipartFile.getOriginalFilename());
		bf.setFileRealAddress("/" + fileName);
		this.getBussinessDao().saveOrUpdateEntity(bf);
		this.addlogFileOper(bf, "上传");
		return null;
	}

	@Override
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);

		modelData.remove("id");
		String SystemDate = DateUtil.getSystemDate();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("tableImportTemplate");
		InputStream source = multipartFile.getInputStream();
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir + "/" + SystemDate;
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		String fileName = UUID.randomUUID() + suffix;
		String uploadedFileFullPath = uploadDirPath + "/" + fileName;
		BaseFile bf = new BaseFile();

		ResourceUtil.getFileUploadOperation().uploadFile(uploadedFileFullPath, source, null);
		this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(modelData, bf, null);
		bf.setFileName(multipartFile.getOriginalFilename());
		bf.setFileRealAddress(SystemDate + "/" + fileName);
		this.getBussinessDao().saveOrUpdateEntity(bf);
		this.addlogFileOper(bf, "上传");
		return bf.getId();
	}

	@Override
	public void addlogFileOper(BaseFile bf, String operType) throws Exception {
		// TODO Auto-generated method stub
		BaseFileRecorder bfr = new BaseFileRecorder();
		bfr.setBaseFile(bf);
		bfr.setOperatorType(operType);
		boolean isWithUser = true;
		User user = null;
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			isWithUser = false;
		}
		if (isWithUser) {
			String systemDate = DateUtil.getSystemDateTime();
			bfr.setCreator(user);
			bfr.setCreateDate(systemDate);
		}
		this.getBussinessDao().saveOrUpdateEntity(bfr);

	}

	@Override
	public String downloadTemplateSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
			String wordid = modelData.get("id");
			FileTemplate fileTemplate;
			fileTemplate = (FileTemplate) this.getBussinessDao().findEntityByID(FileTemplate.class, wordid);
			String paddress = fileTemplate.getSoureTemplatePath();
			String suffix = paddress.substring(paddress.lastIndexOf("."));
			String fileTitleName = fileTemplate.getTemplateName() + suffix;
			fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
			String uploadDirPath = WebUtil.getWebContextRealPath()+"template/"  + this.wordSourceTemplateDir;
			String downloadedFileFullPath = uploadDirPath + "/" + fileTemplate.getSoureTemplatePath();
			downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
			File file=new File(downloadedFileFullPath);
			if(!file.isFile()){
				throw new BusinessException("没有下载文件");
			}
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
			response.setContentType("text/html; charset=UTF-8");
			OutputStream out = response.getOutputStream();
			ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return null;
	}

	@Override
	public String removeTemplateSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FileTemplate> LoadTemplateByClassify(Map<String, String> modelData) throws Exception {
		List<FileTemplate> listTemplate;
		List<FileTemplate> listTemplate2 = null;
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		if (modelData.containsKey("oneClassify") && modelData.get("oneClassify") != null && !"".equals(modelData.get("oneClassify"))) {
			propertiesMap.put("oneClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("oneClassify")));
		}
		if (modelData.containsKey("twoClassify") && modelData.get("twoClassify") != null && !"".equals(modelData.get("twoClassify"))) {
			propertiesMap.put("twoClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("twoClassify")));
		}
		if (modelData.containsKey("threethClassify") && modelData.get("threethClassify") != null && !"".equals(modelData.get("threethClassify"))) {
			propertiesMap.put("threethClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("threethClassify")));
		}
		if (modelData.containsKey("fourClassify") && modelData.get("fourClassify") != null && !"".equals(modelData.get("fourClassify"))) {
			propertiesMap.put("fourClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("fourClassify")));
		}
		if (modelData.containsKey("fiveClassify") && modelData.get("fiveClassify") != null && !"".equals(modelData.get("fiveClassify"))) {
			propertiesMap.put("fiveClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("fiveClassify")));
		}
		if (modelData.containsKey("sixClassify") && modelData.get("sixClassify") != null && !"".equals(modelData.get("sixClassify"))) {
			propertiesMap.put("sixClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("sixClassify")));
		}
		if (modelData.containsKey("eightClassify") && modelData.get("eightClassify") != null && !"".equals(modelData.get("eightClassify"))) {
			propertiesMap.put("eightClassify", this.getBussinessDao().findEntityByID(DictionaryData.class, modelData.get("eightClassify")));
		}
		propertiesMap.put("status", "0");
		listTemplate = (List<FileTemplate>) this.getBussinessDao().findEntityByProperties(FileTemplate.class, propertiesMap);
		//如果是法人客户 带出 董事会和股东决议模板
		String cust_class = modelData.get("sevenClassify");
		if("CUST_INFO_COMPANY".equals(cust_class)){
			if (modelData.containsKey("sevenClassify") && cust_class != null && !"".equals(cust_class)) {
				listTemplate2 = this.getBussinessDao().findResultsByHSQL(" from FileTemplate where sevenClassify.code=?", cust_class);
			}
			if(listTemplate2!=null){
				for(FileTemplate fileTemplate:listTemplate2){
					listTemplate.add(fileTemplate);
				}
			}
		}
		
		return listTemplate;
	}

	public String createCheckBoxByTemplate(List<FileTemplate> wcList, int changeRowNum) throws Exception {

		String box = "";
		int i = 0;
		box = "<table><tr>";
		for (FileTemplate wc : wcList) {
			box += "<td><input type='checkbox' name='contract_word_list_check_box' value='" + wc.getId() + "'>" + wc.getTemplateName() + "</input></td>";
			i++;
			if (changeRowNum > 0) {
				if (i == changeRowNum) {
					i = 0;
					box = box + "</tr><tr>";
				}
			}
		}
		for (; i < changeRowNum; i++) {
			box = box + "<td></td>";
		}
		box = box + "</tr></table>";
		return box;
	}

	public String createFileByTemplate(Map<String, String> model) throws Exception {
		String templateids = model.get("templateid");
		String modename = model.get("modename");
		List<FileTemplate> fileTemplates = new ArrayList<FileTemplate>();
		String[] ids;
		try {
			ids = templateids.split(",");
			Set<FileTemplateDataConfig> templatedataConfigs;
			Map<String, Object> DataMap = new HashMap<String, Object>();
			fileTemplates = this.getBussinessDao().findEntityByIDArray(FileTemplate.class, ids);
			boolean isWithUser = true;
			User user = null;
			try {
				user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			} catch (Exception e) {
				isWithUser = false;
			}
			DictionaryData modelDict = null;
			if (model.containsKey("modename")) {
				modelDict = this.getBussinessDao().findEntityByID(DictionaryData.class, model.get("modename"));
			    if(null==modelDict){
			    	throw new BusinessException("没有找到模块"+model.get("modename"));
			    }
			}
			// 得到当前页面的数据
			Map<String, String> pageMap = new HashMap<String, String>();
			String currentProcessInstanceDBID = "";
			if (model.containsKey("flowunid")) {
				currentProcessInstanceDBID = model.get("flowunid");
				pageMap = JBPMUtil.getProcessInstanceHistoryData(this.getBussinessDao().getHibernateTemplate(), currentProcessInstanceDBID);
			}
			pageMap.putAll(model);
			List<BaseFile> cws = new ArrayList<BaseFile>();
			if (fileTemplates.size() > 0) {
				for (int i = 0; i < fileTemplates.size(); i++) {
					FileTemplate ft = (FileTemplate) fileTemplates.get(i);
					logger.info("开始操作" + ft.getTemplateName());
					// 查找配置
					templatedataConfigs = ft.getFileTemplateDataConfigs();
					// 获得数据
					if (templatedataConfigs.size() > 0) {
						DataMap = getTemplateData(templatedataConfigs, pageMap);
					}
					String fileName = createRealFile(ft, DataMap, modename);
					if (!fileName.equalsIgnoreCase("")) {
						BaseFile cw = new BaseFile();
						this.getBussinessDao().copyAndOverrideExistedValueFromMap(model, cw);
						if (null != modelDict) {
							cw.setModelName(modelDict);
						}
						cw.setFlowUnid(currentProcessInstanceDBID);
						cw.setFileRealAddress(fileName);
						cw.setFileTemplate(ft);
						cw.setTemplateName(ft.getTemplateName());
						cw.setTemplateShowName(ft.getTemplateShowName());
						cw.setFileName(ft.getTemplateShowName());
						if (isWithUser) {
							String systemDate = DateUtil.getSystemDateTime();
							cw.setCreator(user);
							cw.setCreateDate(systemDate);
						}
						cws.add(cw);
					}
				}
			}
			if (cws.size() > 0) {
				this.getBussinessDao().saveAllEntities(cws);
				Map<String, String> fieldClassMapping = new HashMap<String, String>();
				fieldClassMapping.put("DictionaryData", "code");
				fieldClassMapping.put("FileTemplate", "id");
				return this.getBussinessDao().getCollectionEntitiesPropertiesToJsonArrayString(cws, fieldClassMapping);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
			
		}
		return "";
	}

	public String getfile(Map<String, String> model, BaseFile bf) throws Exception {
		List<BaseFile> cws = new ArrayList<BaseFile>();
		// this.getBussinessDao().copyAndOverrideExistedValueFromMap(model, bf);
		bf.setFlowUnid(bf.getId());
		cws.add(bf);
		Map<String, String> fieldClassMapping = new HashMap<String, String>();
		fieldClassMapping.put("DictionaryData", "code");
		fieldClassMapping.put("FileTemplate", "id");
		return this.getBussinessDao().getCollectionEntitiesPropertiesToJsonArrayString(cws, fieldClassMapping);
		// return bf.getId();
	}

	public Map getTemplateData(Set<FileTemplateDataConfig> templateDataConfigs, Map<String, String> pageMap) throws Exception {
		Map<String, Object> worddata = new HashMap<String, Object>();
		String functionField="";
		String[]vfunctionField=null;
		String function="";
		String[] vfunction=null;
		Map<String,Method>custmethod=null;
		//自定义取数
		if(pageMap.containsKey("functionField")){
			functionField=pageMap.get("functionField");
			if(null==functionField||"".equals(functionField)||"null".equalsIgnoreCase(functionField)){
				functionField="";
			}
		}
		if(pageMap.containsKey("function")){
			function=pageMap.get("function");
			if(null==function||"".equals(function)||"null".equalsIgnoreCase(function)){
				function="";
			}
		}
		if("".equals(functionField)||"".equals(function)){}
		else{
			custmethod = new HashMap<String, Method>();
			vfunctionField=functionField.split(",");
			vfunction=function.split(",");
		}
		if(null!=vfunctionField&&null!=vfunction){
			if(vfunctionField.length!=vfunction.length){
				throw new BusinessException("配置的自己数据转换域的和方法的数量不相等"+functionField+":"+function);
			}else{
				Method operatormethod=null;
				for(int i=0;i<vfunctionField.length;i++){
					try {
						operatormethod = fileExcelService.getClass().getMethod(vfunction[i], String.class);
					} catch (Exception e1) {
						throw new BusinessException("自定义方法没有找到" + vfunction[i]);
					}
					if(null!=operatormethod){
						custmethod.put(vfunctionField[i], operatormethod);
					}
				}
				
			}
		}
		try {
			for (FileTemplateDataConfig bw : templateDataConfigs) {
				logger.info("开始初始化" + bw.getWordKey() + "字段类型" + bw.getKeyType() + "数据源" + bw.getDataSource());
				if (bw.getDataSource().equalsIgnoreCase("page")) {
					// 从前台的数据中抓取数据
					if (bw.getKeyType().equalsIgnoreCase("STRING")) {
						// 字段
						if (pageMap.containsKey(bw.getWordKey() + "." + bw.getWordField())) {
							worddata.put(bw.getWordKey() + bw.getWordField(), StringUtil.nullToString(pageMap.get(bw.getWordKey() + "." + bw.getWordField())));
						} else {
							logger.info(bw.getWordField() + "没有数据");
							//德银合同审批生成合同可能没生成业务合同号,先补空格
							if("contract_infocontractnumber".equals(bw.getWordKey() + bw.getWordField())){
								worddata.put("contract_infocontractnumber","                         ");
							}else{
							   worddata.put(bw.getWordKey() + bw.getWordField(), "");
							}
						}
					} else if (bw.getKeyType().equalsIgnoreCase("LIST")) {
						// 列表
						String[] fields = bw.getWordField().split(",");
						List<String> fielddata = new ArrayList<String>();
						for (String field : fields) {
							if (pageMap.containsKey(bw.getWordKey() + "." + field)) {
								fielddata.add( StringUtil.nullToString(pageMap.get(bw.getWordKey() + "." + field)));
							} else {
								logger.info(bw.getWordKey() + "." + field + "没有数据");
								//德银合同审批生成合同可能没生成业务合同号,先补空格
								if("contract_info.contractnumber".equals(bw.getWordKey() + "." + field)){
									fielddata.add("                         ");
								}else{
								    fielddata.add("");
								}
							}
						}
						worddata.put(bw.getWordKey(), fielddata);
					} else {
						// 表格
						String jsonData = pageMap.get(bw.getMultiWordField());
						if (jsonData.equalsIgnoreCase("[]")) {
							return null;
						}
						;  
						Map[] newSetMaps = jsonMapper.readValue(jsonData, Map[].class);
						String[] fields = bw.getWordField().split(",");
						List<List> tabledata = new ArrayList<List>();
						for (int i = 0; i < newSetMaps.length; i++) {
							Map<String, Object> dataMap = new HashMap<String, Object>();
							dataMap = newSetMaps[i];
							List<String> fielddata = new ArrayList<String>();
							for (String field : fields) {
								if (dataMap.containsKey(field)) {
									fielddata.add( StringUtil.nullToString(dataMap.get(field)));
								} else {
									//生成收据号
									String twoclass=pageMap.get("twoClassify");
									if("wordtempletypetwo1234".equals(twoclass)){
										String ReceiptNo = WorkflowUtil.getReceiptNoInfoSerialNumber(null, tableService.getBussinessDao().getHibernateTemplate(), tableService.getBussinessDao().getJdbcTemplate());
										fielddata.add(ReceiptNo);
									}else{
									    logger.info(bw.getWordKey() + "." + field + "没有数据");
									    fielddata.add("");
									}
								}
							}
							
							tabledata.add(fielddata);
						}
						worddata.put(bw.getWordKey(), tabledata);
					}
				} else {
					// 从数据库中抓取数据
					String sql = bw.getDataSql();
					if (sql.toLowerCase().indexOf(".xml") > 0) {
						String realPath = ResourceUtil.getTablesDataSourceDirectoryPath() + "/" + sql;
						realPath = FileUtil.getFilePathString(realPath);
						String tempSql = XMLDataUtil.readTableInfoFromXmlFile(realPath).get("table_sql");
						String realSql = QueryUtil.getQueryString(pageMap, tempSql);
						sql = realSql.replaceAll("\"", "");
					} else {
						sql = StrTools.setSqlCondtion(sql, pageMap);
					}
					System.out.println("操作的SQL: " + sql);
					List rows = this.getBussinessDao().getJdbcTemplate().queryForList(sql);
					
					if (pageMap.containsKey("sqlDataCallback")) {
						String sqlDataCallback = pageMap.get("sqlDataCallback").toString();
						if (null != sqlDataCallback && (!"".equals(sqlDataCallback.toString().trim()))) {
							try {
								Method dataInitMehtodObject = fileExcelService.getClass().getMethod(sqlDataCallback, List.class);
								
								rows = (List) dataInitMehtodObject.invoke(fileExcelService, rows);
								
							} catch (Exception e1) {
								throw new BusinessException("自定义方法没有找到" + sqlDataCallback);
							}
						}
					}	
					
					Iterator it = rows.iterator();
					if (bw.getKeyType().equalsIgnoreCase("STRING")) {
						// 字段
						if (it.hasNext()) {
							Map dataMap = (Map) it.next();
							if (dataMap.containsKey(bw.getWordField())) {
								worddata.put(bw.getWordKey() + bw.getWordField(), StringUtil.nullToString(dataMap.get(bw.getWordField())));
							} else {
								logger.info(bw.getWordField() + "没有数据");
								worddata.put(bw.getWordKey() + bw.getWordField(), "");
							}
						}
					} else if (bw.getKeyType().equalsIgnoreCase("LIST")) {
						// 列表
						if (it.hasNext()) {
							Map dataMap = (Map) it.next();
							String[] fields = bw.getWordField().split(",");
							List<String> fielddata = new ArrayList<String>();
							for (String field : fields) {
								if (dataMap.containsKey(field)) {
									// fielddata.add((String)dataMap.get(field));
									fielddata.add(StringUtil.nullToString(dataMap.get(field)).toString());
								} else {
									logger.info(bw.getWordKey() + "." + field + "没有数据");
									fielddata.add("");
								}
							}
							worddata.put(bw.getWordKey(), fielddata);
						}
					} else {
						// 表格
						String[] fields = bw.getWordField().split(",");
						List<List> tabledata = new ArrayList<List>();
						String splitField = "";
						Double rangeValue = 0.00;
						int index = -1;
						try {
							if (pageMap.containsKey("splitField")) {
								splitField = pageMap.get("splitField");
							}
							if (pageMap.containsKey("rangeValue")) {
								rangeValue = Double.valueOf(pageMap.get("rangeValue"));
							}
						} catch (Exception e) {
							logger.info("取拆分字段时出错:");
							splitField = "";
							rangeValue = 0.00;
						}
						while (it.hasNext()) {
							Map dataMap = (Map) it.next();
							List<String> fielddata = new ArrayList<String>();
							int i = -1;
							for (String field : fields) {
								i = i + 1;
								if (null != splitField && (!"".equals(splitField))) {
									if (splitField.equalsIgnoreCase(field)) {
										index = i;
									}
								}
								if (dataMap.containsKey(field)) {
									if(null!=custmethod&&custmethod.containsKey(field)){
										String value="";
										if (null != custmethod.get(field)) {
											try {
												value=(String)custmethod.get(field).invoke(fileExcelService, StringUtil.nullToString(dataMap.get(field)).toString());
											} catch (Exception e) {
												InvocationTargetException targetEx = (InvocationTargetException) e;
												Throwable t = targetEx.getTargetException();
												throw new BusinessException(t.getMessage());
											}
										}
										 fielddata.add(value);
									}else{
									   fielddata.add(StringUtil.nullToString(dataMap.get(field)).toString());
									}
								} else {
									logger.info(bw.getWordKey() + "." + field + "没有数据");
									fielddata.add("");
								}
							}
							if (index > 0 && rangeValue > 0) {
								tabledata.addAll(this.SplitListByConfig(fielddata, rangeValue, index));
							} else {
								tabledata.add(fielddata);
							}
						}
						worddata.put(bw.getWordKey(), tabledata);
					}
				}
			}
		}catch(BusinessException b){
			throw new BusinessException("加载数据时出错,"+b.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException("加载数据时出错,"+e.getMessage());
		}
		return worddata;
	}

	public String createRealFile(FileTemplate ft, Map<String, Object> dataMap, String modelname) throws Exception {
		String SystemDate = DateUtil.getSystemDate();
		String wordfile;
		try {
			System.out.println("################");
			String uploadDirPath = WebUtil.getWebContextRealPath()+"template/" + this.wordTemplateDir;
			System.out.println("uploadDirPath:"+uploadDirPath);
			System.out.println(ft.getTemplatePath()+"^^^^^^");
			String uploadedFileFullPath = uploadDirPath + "/" + ft.getTemplatePath();
			String fileName = FileUtil.getFilePathString(uploadedFileFullPath);
			String paddress = ft.getTemplateShowName();
			System.out.println("paddress:"+paddress);
			String suffix = paddress.substring(paddress.lastIndexOf("."));
			System.out.println(fileName+"=fileName");
			File file = new File(fileName);
			wordfile = "";
			if (file.isFile()) {
				String wordDir = getuploadFileAllDir(modelname);
				wordfile = UUID.randomUUID() + suffix;
				String uploadFiel = FileUtil.getFilePathString(wordDir + "/" + wordfile);
				String tempFile = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath() + "/" + wordfile);
				if (suffix.indexOf("doc") > 0) {
					try {
						Configuration cfg = new Configuration();
						cfg.setDefaultEncoding("utf-8");
						cfg.setDirectoryForTemplateLoading(new File(uploadDirPath));
						cfg.setObjectWrapper(new DefaultObjectWrapper());
						Template temp = cfg.getTemplate(ft.getTemplatePath().replaceAll(this.wordTemplateDir + "/", ""));
						File outFile = new File(tempFile);
						Writer out = null;
						out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
					    System.out.println("dataMap:"+dataMap.toString());
						temp.process(dataMap, out);
						out.flush();
						out.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new BusinessException("写入word模板时出错"+e.getMessage());
					}
				} else {
					try {
						this.writeDatatoTemplateExcel(fileName, dataMap, tempFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new BusinessException("写入excel模板时出错"+e.getMessage());
					}
				}
				File inFile = new File(tempFile);
				InputStream source = new FileInputStream(inFile);
				ResourceUtil.getFileUploadOperation().uploadFile(uploadFiel, source, null);
				inFile.delete();
				logger.info("生功生成合同");
			} else {
				throw new BusinessException(ft.getTemplateShowName() + "没有模板+("+fileName+")");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("createRealFile中的"+e.getMessage());
		}
		return getuploadFileDir(modelname) + wordfile;
	}

	public String downloadAttachById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String id = modelData.get("id");
		BaseFile bw = (BaseFile) this.getBussinessDao().findEntityByID(BaseFile.class, id);
		// 记录下载的信息

		String fileAddress = bw.getFileRealAddress();
		// String fileTitleName =bw.getFileTemplate().getTemplateShowName();
		String fileTitleName = bw.getFileName();
		this.addlogFileOper(bw, "下载");
		fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir;
		String downloadedFileFullPath = uploadDirPath + "/" + fileAddress;
		downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
		response.setContentType("text/html; charset=UTF-8");
		OutputStream out = response.getOutputStream();
		ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		return null;
	}

	public String downloadAttachByIdToEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String id = modelData.get("id");
		BaseFile bw = (BaseFile) this.getBussinessDao().findEntityByID(BaseFile.class, id);
		// 记录下载的信息
		String fileAddress = bw.getFileRealAddress();
		// String fileTitleName =bw.getFileTemplate().getTemplateShowName();

		String fileTitleName = bw.getFileRealAddress();
		fileTitleName = fileTitleName.substring(fileTitleName.lastIndexOf("/") + 1).replaceAll("-", "");
		this.addlogFileOper(bw, "下载");
		fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir;
		String downloadedFileFullPath = uploadDirPath + "/" + fileAddress;
		downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
		response.setContentType("text/html; charset=UTF-8");
		OutputStream out = response.getOutputStream();
		ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		return null;
	}

	public String downloadAttachByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String fileName = modelData.get("filename");
		String fileTitleName = fileName.substring(fileName.indexOf("/") + 1);
		fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir;
		String downloadedFileFullPath = uploadDirPath + "/" + fileName;
		downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
		response.setContentType("text/html; charset=UTF-8");
		OutputStream out = response.getOutputStream();
		ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		return null;
	}

	public String uploadEditTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("fileid");
		BaseFile bf = this.getBussinessDao().findEntityByID(BaseFile.class, id);
		String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath()) + this.contractWordDir;
		String downloadedFileFullPath = uploadDirPath + "/" + bf.getFileRealAddress();
		try {
			ResourceUtil.getFileUploadOperation().removeFile(downloadedFileFullPath);
		} catch (Exception e) {
			String info = "强制删除文件：" + downloadedFileFullPath;
			if (logger.isInfoEnabled()) {
				logger.info(info);
			}
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> multipartFiles = multipartRequest.getFileMap();
		MultipartFile multipartFile = multipartFiles.get("upLoadFile");
		InputStream source = multipartFile.getInputStream();
		ResourceUtil.getFileUploadOperation().uploadFile(downloadedFileFullPath, source, null);
		this.addlogFileOper(bf, "编辑");
		return "编辑成功";
	}

	public String downloadFileTempalteByClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		FileTemplate fileTemplate;
		fileTemplate = this.LoadTemplateByClassify(modelData).get(0);
		String paddress = fileTemplate.getTemplatePath();
		String suffix = paddress.substring(paddress.lastIndexOf("."));
		String fileTitleName = fileTemplate.getTemplateName() + suffix;
		fileTitleName = this.getdownloadfileName(modelData, fileTitleName);
		try {
			String uploadDirPath = WebUtil.getWebContextRealPath()+"template/"+ this.wordTemplateDir;
			String downloadedFileFullPath = uploadDirPath + "/" + fileTemplate.getTemplatePath();
			downloadedFileFullPath = FileUtil.getFilePathString(downloadedFileFullPath);
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
			response.setContentType("text/html; charset=UTF-8");
			OutputStream out = response.getOutputStream();
			ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
		} catch (Exception e) {
			throw new BusinessException("服务器上没有这个文件");
		}
		return null;
	}
	public BaseFile createFileByTemplateClass(Map<String, String> model, DataMapCallBack... dataMapCallBacks) throws Exception {
		String dateInitMethod="";
		Method dataInitMehtodObject=null;
		if (model.containsKey("dateInitMethod")) {
			
			dateInitMethod = model.get("dateInitMethod").toString();
			//System.out.println(dateInitMethod+"========");
			if (null != dateInitMethod && (!"".equals(dateInitMethod.toString().trim()))) {
				try {
					dataInitMehtodObject = fileExcelService.getClass().getMethod(dateInitMethod, TableService.class, Map.class,BaseFile.class);
				} catch (Exception e1) {
					throw new BusinessException("自定义方法没有找到" + dateInitMethod);
				}
			}
		}	
		FileTemplate ft=null;
		try {
			ft = this.LoadTemplateByClassify(model).get(0);
		} catch (Exception e2) {
			throw new BusinessException("没有找到模板,"+e2.getMessage());
		}
		Set<FileTemplateDataConfig> templatedataConfigs;
		templatedataConfigs = ft.getFileTemplateDataConfigs();
		List<BaseFile> bfs = new ArrayList<BaseFile>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> pageMap = new HashMap<String, String>();
		String currentProcessInstanceDBID = "";
		if (model.containsKey("flowunid")) {
			currentProcessInstanceDBID = model.get("flowunid");
			pageMap = JBPMUtil.getProcessInstanceHistoryData(this.getBussinessDao().getHibernateTemplate(), currentProcessInstanceDBID);
		}
		DictionaryData modelDict = null;
		if (model.containsKey("modename")) {
			modelDict = this.getBussinessDao().findEntityByID(DictionaryData.class, model.get("modename"));
		}
		Map<String, String> classFieldMapping = new HashMap<String, String>();
		classFieldMapping.put("DictionaryData", "code");
		String fileParames = model.get("parames");
		BaseFile lastBaseFile = null;
		if (fileParames != null) {
			ObjectMapper jsonMapper = new ObjectMapper();
			JSONArray jsonArray = new JSONArray(fileParames);
			JSONArray newjsonArray = new JSONArray();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				Map[] newSetMaps = jsonMapper.readValue("[" + jsonObj.toString() + "]", Map[].class);
				Map<String, String> dataModel = newSetMaps[0];
				dataModel.putAll(pageMap);
				dataModel.putAll(model);
				
				if (templatedataConfigs.size() > 0) {
					dataMap = getTemplateData(templatedataConfigs, dataModel);
					if (dataMapCallBacks.length > 0) {
						for (DataMapCallBack dataMapCallBack : dataMapCallBacks) {
							dataMapCallBack.dataMapCallBack(dataMap);
						}
					}
				}

				Map<String, Object> sourceDataMap = new HashMap<String, Object>();
				BaseFile cw = new BaseFile();
				String modename = dataModel.get("modelname");
				String fileName = createRealFile(ft, dataMap, modename);
				//System.out.println("fileName:"+fileName);
				if (!fileName.equalsIgnoreCase("")) {
					dataModel.remove("id");
					this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(dataModel, cw, classFieldMapping);
					if (dataModel.containsKey("filename")) {
					} else {
						cw.setFileName(ft.getTemplateShowName());
					}
					if (null != modelDict) {
						cw.setModelName(modelDict);
					}
					cw.setFileRealAddress(fileName);
					cw.setFileTemplate(ft);
					cw.setTemplateName(ft.getTemplateName());
					cw.setTemplateShowName(ft.getTemplateShowName());
				}
				bfs.add(cw);
			}
		} else {
			model.putAll(pageMap);
			if (templatedataConfigs.size() > 0) {
				dataMap = getTemplateData(templatedataConfigs, model);
				if (dataMapCallBacks.length > 0) {
					for (DataMapCallBack dataMapCallBack : dataMapCallBacks) {
						dataMapCallBack.dataMapCallBack(dataMap);
					}
				}
			}

			BaseFile cw = new BaseFile();
			this.baseDao.saveEntity(cw);
			
			if (model.containsKey("SystemSN")) {
				dataMap.put("SystemSN", model.get("SystemSN"));
			}
			String modename = model.get("modelname");
			String fileName="";
			try {
				fileName = createRealFile(ft, dataMap, modename);
			}catch(BusinessException b){
				throw new BusinessException(b.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!fileName.equalsIgnoreCase("")) {
				model.remove("id");
				this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(model, cw, classFieldMapping);
				if (model.containsKey("filename")) {
				} else {
					cw.setFileName(ft.getTemplateShowName());
				}
				if (null != modelDict) {
					cw.setModelName(modelDict);
				}
				cw.setFileRealAddress(fileName);
				cw.setFileTemplate(ft);
				cw.setTemplateName(ft.getTemplateName());
				cw.setTemplateShowName(ft.getTemplateShowName());
			}
			
			try {
				if (null != dataInitMehtodObject){
					dataInitMehtodObject.invoke(fileExcelService, tableService, dataMap, cw);
				}
			} catch (Exception e) {
				InvocationTargetException targetEx = (InvocationTargetException) e;
				Throwable t = targetEx.getTargetException();
				throw new BusinessException(t.getMessage());
			}
			bfs.add(cw);

		}
		if (bfs.size() > 1) {
			String modelname = model.get("modelname");
			String baseDir = new File(ResourceUtil.getFileUploadDataPath()).getAbsolutePath();
			String zipfile = getuploadFileDir(modelname) + UUID.randomUUID() + ".zip";
			String filename = FileUtil.getFilePathString(baseDir + "/" + this.contractWordDir + "/" + zipfile);
			String tempFileName = WebUtil.getWebContextRealPath() + "/tempFilesDir/" + UUIDUtil.getUUID() + ".zip";
			uploadBatchAttachmentFilesByBaseFiles(filename, bfs, tempFileName);
			BaseFile cw = new BaseFile();
			this.getBussinessDao().copyAndOverrideExistedValueFromObject(bfs.get(0), cw);
			cw.setMemo("");
			for (BaseFile bf : bfs) {
				cw.setMemo(cw.getMemo() + bf.getMemo() + ",");
			}
			if (null != modelDict) {
				cw.setModelName(modelDict);
			}
			cw.setFileRealAddress(zipfile);
			cw.setFileTemplate(ft);
			cw.setTemplateName(ft.getTemplateName());
			cw.setTemplateShowName(ft.getTemplateShowName());
			cw.setFileName(ft.getTemplateName() + ".zip");
			this.getBussinessDao().saveOrUpdateEntity(cw);
			this.addlogFileOper(cw, "生成");
			lastBaseFile = cw;
		} else {
			BaseFile bf = bfs.get(0);
			boolean isWithUser = true;
			User user = null;
			try {
				user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			} catch (Exception e) {
				isWithUser = false;
			}
			if (isWithUser) {
				String systemDate = DateUtil.getSystemDateTime();
				bf.setCreator(user);
				bf.setCreateDate(systemDate);
			}
			this.getBussinessDao().saveOrUpdateEntity(bf);

			this.addlogFileOper(bfs.get(0), "生成");
			lastBaseFile = bfs.get(0);
		}
		String custMethod = "";
		Method operatormethod = null;
		if (model.containsKey("custoperatorMethod")) {

			custMethod = model.get("custoperatorMethod").toString();
			if (null != custMethod && (!"".equals(custMethod.toString().trim()))) {
				try {
					operatormethod = fileExcelService.getClass().getMethod(custMethod, TableService.class, Map.class, BaseFile.class);
				} catch (Exception e1) {
					throw new BusinessException("自定义方法没有找到" + custMethod);
				}
				try {
					if (null != operatormethod) {
						operatormethod.invoke(fileExcelService, tableService, model, lastBaseFile);
					}
				} catch (Exception e) {
					InvocationTargetException targetEx = (InvocationTargetException) e;
					Throwable t = targetEx.getTargetException();
					throw new BusinessException(t.getMessage());
				}
			}
		}
		return lastBaseFile;
	}

	public void uploadBatchAttachmentFilesByBaseFiles(String uploadRemoteFullPath, List<BaseFile> bfs, String tempFileFullPath) throws Exception {
		File tempFileOut = new File(tempFileFullPath);
		File parentFile = tempFileOut.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		OutputStream os = new FileOutputStream(tempFileFullPath);
		ZipOutputStream out = null;
		String charSetName = "GB2312";
		String baseDir = new File(ResourceUtil.getFileUploadDataPath()).getAbsolutePath();

		try {
			out = new ZipOutputStream(os);
			out.setEncoding(charSetName);
			for (BaseFile bf : bfs) {
				// 下载文件
				String inputFileFullPath = FileUtil.getFilePathString(baseDir + "/" + this.contractWordDir + "/" + bf.getFileRealAddress());
				String chineseName = bf.getFileName();
				out.putNextEntry(new ZipEntry(chineseName));
				ResourceUtil.getFileUploadOperation().readInputStreamToOutputStream(inputFileFullPath, out);
			}
		} finally {
			if (null != out) {
				out.closeEntry();
				out.flush();
				out.close();
			}
			if (null != os) {
				os.flush();
				os.close();
			}
		}
		File tempFile = new File(tempFileFullPath);
		ResourceUtil.getFileUploadOperation().uploadFile(uploadRemoteFullPath, new FileInputStream(tempFile), null);
		tempFile.delete();
	}

	@Override
	public void writeDatatoTemplateExcel(String tempfile, Map<String, Object> model, String targetFile) throws Exception {
		Row templateRow;
		Cell cell;
		Workbook wb=null;
		String custMethod = "";
		Method operatormethod = null;
		Boolean flag;
		Class WorkflowUtilClass = Class.forName("com.business.util.WorkflowUtil");
		// 插入之前调自定义方法
		try {
			if (tempfile.endsWith("xlsx")) {
				wb = PoiExcelUtil.readWorkbook(tempfile, ExcelVersionEnum.VERSION2007);
			} else {
				wb = PoiExcelUtil.readWorkbook(tempfile, ExcelVersionEnum.VERSION2003);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException("加载excel时出错"+e.getMessage());
		}
		ReadExecl readExecl=null;
		Sheet templateSheet=null;
		try {
			readExecl = new ReadExecl(tempfile);
			templateSheet = wb.getSheetAt(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException("加载readExecl时出");
		}
		for (Iterator it = model.entrySet().iterator(); it.hasNext();) {
			Map.Entry element = (Map.Entry) it.next();
			String title_name = element.getKey().toString().trim();// 获得列名
			if (logger.isInfoEnabled()) {
				logger.info("Excel开始生成写入" + title_name + "块");
			}
			Object t_value = element.getValue();
			if (null != t_value && title_name != "SystemSN") {
				if (t_value instanceof String) {
					templateSheet = wb.getSheetAt(readExecl.getCell(readExecl.getCellReference(title_name)).getSheet_index());
					int col_index = readExecl.getCellColNum(title_name);
					int row_index = readExecl.getCellRowNum(title_name);
					if (col_index >= 0 && row_index >= 0) {
						templateRow = templateSheet.getRow(row_index);
						cell = templateRow.getCell(col_index);
						cell.setCellValue(t_value.toString());
						if (logger.isInfoEnabled()) {
							logger.info("Excel开始生成写入" + title_name + ":" + t_value.toString());
						}
					}
				} else {
					List templistvalue = (List) t_value;
					if (templistvalue.size() > 0 && templistvalue.get(0) instanceof List) {
						// 表格
						// 查找sheet
						int col_index = 0;
						int row_index = 0;
						if (title_name.startsWith("MS_")) {

						} else {
							if (title_name.startsWith("listtable")) {
								col_index = readExecl.getCellColNum(title_name + "_start");
								row_index = readExecl.getCellRowNum(title_name + "_start");
								templateSheet = wb.getSheetAt(readExecl.getCell(readExecl.getCellReference(title_name + "_start")).getSheet_index());
							} else {
								col_index = readExecl.getCellColNum(title_name);
								row_index = readExecl.getCellRowNum(title_name);
								templateSheet = wb.getSheetAt(readExecl.getCell(readExecl.getCellReference(title_name)).getSheet_index());

							}
						}
						if (col_index >= 0 && row_index >= 0) {
							if (title_name.startsWith("listtable")) {
								// 条件表格
								int col_startindex = readExecl.getCellColNum(title_name + "_start");
								int row_startindex = readExecl.getCellRowNum(title_name + "_start");
								int col_endindex = readExecl.getCellColNum(title_name + "_end");
								int row_endindex = readExecl.getCellRowNum(title_name + "_end");
								int region = row_endindex - row_startindex + 1;
								if (templistvalue.size() > 0) {
									PoiExcelUtil.insertRowArea(templateSheet, row_startindex + 1, row_endindex + 1, templistvalue.size() - 1);
									readExecl.bookNamesMove(row_startindex + 1, row_endindex + 1, templistvalue.size() - 1);
									for (int i = 0; i < templistvalue.size(); i++) {
										List tempvalue = (List) templistvalue.get(i);
										for (int j = 0; j < tempvalue.size(); j++) {
											row_index = readExecl.getCellRowNum(title_name + "_" + j);
											templateRow = templateSheet.getRow(row_index + i * region);
											col_index = readExecl.getCellColNum(title_name + "_" + j);
											if (col_index >= 0) {
												cell = templateRow.getCell(col_index);
												cell.setCellValue(tempvalue.get(j).toString());
												if (logger.isInfoEnabled()) {
													logger.info("Excel开始生成写入" + title_name + "[" + row_index + i * region + 1 + "][" + col_index + "]:" + tempvalue.get(j).toString());
												}
											}
										}
									}
								} else {
								}
							} else if (title_name.startsWith("MS_")) {
								// 多个sheet表，复制第一个sheet
								if (templistvalue.size() > 0) {
									for (int i = 1; i < templistvalue.size(); i++) {
										    List tempvalue = (List) templistvalue.get(i);
								        	Sheet targetSheet = wb.createSheet(tempvalue.get(0).toString());
											PoiExcelUtil.CopySheet(templateSheet, targetSheet);	
									}
									for (int i = 0; i < templistvalue.size(); i++) {
										templateSheet = wb.getSheetAt(i);
										List tempvalue = (List) templistvalue.get(i);
										for (int j = 1; j < tempvalue.size(); j++) {
											row_index = readExecl.getCellRowNum(title_name + "_" + (j-1));
											col_index = readExecl.getCellColNum(title_name + "_" + (j-1));
											templateRow = templateSheet.getRow(row_index);
											if(null!=templateRow){
											cell = templateRow.getCell(col_index);
											String value = tempvalue.get(j).toString();
											if (tempvalue.get(j).toString().equalsIgnoreCase("SystemSN")) {
												String sn = "";
												if (model.containsKey("SystemSN")) {
													String SystemSN = model.get("SystemSN").toString();
													if (null == SystemSN || "null".equalsIgnoreCase(SystemSN) || "".equals(SystemSN)) {

													} else {
														Method operatorS = WorkflowUtilClass.getMethod(SystemSN, Map.class, HibernateTemplate.class, JdbcTemplate.class);
														if (null != operatorS) {
															sn = (String) operatorS.invoke(WorkflowUtilClass, null, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
														}
													}
												}
												value = sn;
											}
											cell.setCellValue(value);
											}else{
												System.out.println(title_name + "_" + j);
											}
											// if(logger.isInfoEnabled())
											// {
											// logger.info("Excel开始生成写入"+title_name+"["+row_index+"]["+col_index+"]:"+tempvalue.get(j).toString());
											// }
										}
									}
								}

							} else {
								PoiExcelUtil.insertRow(templateSheet, row_index, templistvalue.size() - 1);
								readExecl.bookNamesMove(row_index, row_index + templistvalue.size() - 1, 1);
								for (int i = 0; i < templistvalue.size(); i++) {
									List tempvalue = (List) templistvalue.get(i);
									templateRow = PoiExcelUtil.getRow(templateSheet, row_index + i);
									for (int j = 0; j < tempvalue.size(); j++) {
										cell = PoiExcelUtil.getCell(templateRow, col_index + j);
										cell.setCellValue(tempvalue.get(j).toString());
										System.out.println("Excel开始生成写入" + title_name + "[" + row_index + i + "][" + col_index + j + "]:" + tempvalue.get(j).toString());
										if (logger.isInfoEnabled()) {
											logger.info("Excel开始生成写入" + title_name + "[" + row_index + i + "][" + col_index + j + "]:" + tempvalue.get(j).toString());
										}
									}
								}
							}
						}

					} else {
						int col_index = 0;
						int row_index = 0;
						// 删除没有数据的列表
						if (title_name.startsWith("listtable")) {
							col_index = readExecl.getCellColNum(title_name + "_start");
							row_index = readExecl.getCellRowNum(title_name + "_start");
							templateSheet = wb.getSheetAt(readExecl.getCell(readExecl.getCellReference(title_name + "_start")).getSheet_index());
							int col_startindex = readExecl.getCellColNum(title_name + "_start");
							int row_startindex = readExecl.getCellRowNum(title_name + "_start");
							int col_endindex = readExecl.getCellColNum(title_name + "_end");
							int row_endindex = readExecl.getCellRowNum(title_name + "_end");
							int region = row_endindex - row_startindex + 1;
							PoiExcelUtil.deleteRowByArea(templateSheet, row_startindex, row_endindex);
							readExecl.bookNamesMove(row_startindex, row_endindex, -1);
						}
						// 列表
						// 查找sheet
						if (templistvalue.size() > 0) {
							templateSheet = wb.getSheetAt(readExecl.getCell(readExecl.getCellReference(title_name + "_0")).getSheet_index());
							for (int i = 0; i < templistvalue.size(); i++) {
								col_index = readExecl.getCellColNum(title_name + "_" + i);
								row_index = readExecl.getCellRowNum(title_name + "_" + i);
								if (col_index >= 0 && row_index >= 0) {
									templateRow = templateSheet.getRow(row_index);
									cell = templateRow.getCell(col_index);
									cell.setCellValue(templistvalue.get(i).toString());
									if (logger.isInfoEnabled()) {
										logger.info("Excel开始生成写入" + title_name + "_" + i + ":" + templistvalue.get(i).toString());
									}
								}
							}
						}
					}
				}
			}
		}
		OutputStream osServer = new FileOutputStream(targetFile);
		wb.write(osServer);
		osServer.close();
	}

	/*	@Override
	public String uploadExcelFileToObject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			List ccri = new ArrayList();
			ccri = (List) getEntitysFromExcel(request, response);
			String message = "";
			if (null != ccri && ccri.size() > 0) {
				this.tableService.saveOrUpdateAllEntities(ccri);
				message = "导入成功:导入" + ccri.size() + "条";
			} else {
				throw new BusinessException("没有数据导入");
				//message = "没有数据导入";
			}
			return message;
		} catch (BusinessException b) {
			throw new BusinessException("上传出错:" + b.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("上传出错:" + e.getMessage());

		}
	}*/
	
	@Override
	public String uploadExcelFileToObject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			String fileupdatedate="";
			Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String isSaveTo="";
			if(model.containsKey("isSaveTo")){
				isSaveTo=model.get("isSaveTo").toString();
			}else{
				isSaveTo="savedate";
			}
			Map<String,String>prototypesClassFieldMap=new HashMap<String,String>();
			prototypesClassFieldMap.put("CustInfo", "id");
			List ccri = new ArrayList();
			ccri = (List) getEntitysFromExcel(request, response);
			String message = "";
			if (null != ccri && ccri.size() > 0) {
				logger.debug("上传输出:");
				logger.debug(ccri.get(0));
				
				if(isSaveTo=="savedate"){
				    this.tableService.saveOrUpdateAllEntities(ccri);
				    
				   message = "\"message\":\"成功导入导入" + ccri.size() + "条\"";
				}else{
					fileupdatedate=this.tableService.getCollectionEntitiesPropertiesToJsonArray(ccri,prototypesClassFieldMap).toString();
					message = "\"message\":\"成功导入导入" + ccri.size() + "条\",\"fileupdatedate\":"+fileupdatedate+"";
						
				}
			} else {
				message = "\"message\":\"\"";
			}
			  
			  Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
		         Matcher m = p.matcher(message);  
		         message = m.replaceAll("");  
			return message;
		} catch (BusinessException b) {
			throw new BusinessException("上传出错:" + b.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("上传出错:" + e.getMessage());

		}
	}
	
	@Override
	public String getDefaultAjaxCallBack(String message) throws Exception {
		// TODO Auto-generated method stub
		String ajaxCallBackScript = "<script type='text/javascript'>window.parent.DefaultAjaxCallBack(\"" + message + "\");</script>";
		return ajaxCallBackScript;
	}

	public List<List> SplitListByConfig(List<String> ExcelData, double dual, int index) throws Exception {
		String sourceDouble = ExcelData.get(index).toString();
		Double cmoney = 0.00;
		cmoney = Double.valueOf(sourceDouble);
		List<String> temp = new ArrayList<String>();
		List<List> tabledata = new ArrayList<List>();
		if (cmoney > 0 && cmoney > dual) {
			while (cmoney > 0) {
				temp = new ArrayList<String>();
				for (int i = 0; i < ExcelData.size(); i++) {
					if (i != index) {
						temp.add(ExcelData.get(i));
					} else {
						if(cmoney > dual){
						   temp.add(String.valueOf(dual));
						}else{
						   temp.add(cmoney.toString());	
						}
					}
				}
				tabledata.add(temp);
				cmoney = cmoney - dual;
			}
		} else {
			tabledata.add(ExcelData);
		}
		return tabledata;
	}

	public String getdownloadfileName(Map<String, String> model, String fileName) throws Exception {

		String browserType = model.get("browserType");
		String fileTitleName = fileName;
		if ("firefox".equals(browserType)) {
			fileTitleName = new String(fileTitleName.getBytes("GB2312"), "ISO-8859-1");
		} else if ("chrome".equals(browserType)) {
			fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
		} else if ("safari".equals(browserType)) {
			fileTitleName = new String(fileTitleName.getBytes("UTF-8"), "ISO-8859-1");
		} else {
			fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
		}
		return fileTitleName;
	}
	public String removeTemplate()throws Exception{
		 List<FileTemplate> templates=new ArrayList<FileTemplate>();
		 templates=this.tableService.findEntities(FileTemplate.class);
		 String sourcepath= ResourceUtil.getFileUploadDataPath();
		 String targetPath=WebUtil.getWebContextRealPath()+"template/";
		 for(FileTemplate t : templates){
	          if(null!=t.getTemplatePath()){
	        	  String file=sourcepath+this.wordTemplateDir+"/" + t.getTemplatePath();;
	        	  String targerfile=targetPath+this.wordTemplateDir +"/" + t.getTemplatePath();
	        	  File f=new File(file);
	        	  if(null!=f && f.isFile()){
	        		  InputStream source = new FileInputStream(f);
	  				ResourceUtil.getFileUploadOperation().uploadFile(targerfile, source, null); 
	        	  }
	          }
	          if(null!=t.getSoureTemplatePath()){
	        	  String file=sourcepath+this.wordSourceTemplateDir+"/" + t.getSoureTemplatePath();;
	        	  String targerfile=targetPath+this.wordSourceTemplateDir+"/" + t.getSoureTemplatePath();
	        	 // System.out.println(file);
	        	  //System.out.println(targerfile);
	        	  File f=new File(file);
	        	  if(null!=f && f.isFile()){
	        		  InputStream source = new FileInputStream(f);
	  				ResourceUtil.getFileUploadOperation().uploadFile(targerfile, source, null); 
	        	  }
	          }
		 }
		 return "";
	 }
}
