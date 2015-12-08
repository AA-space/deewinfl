package com.business.serviceImpl.financeReport;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.dao.BaseDao;
import com.business.entity.base.BaseFile;
import com.business.entity.base.FinanceReportBean;
import com.business.entity.base.FinanceReportParamBean;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.model.ExcelVersionEnum;
import com.business.service.TableService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.service.financeReport.FinanceReportService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.kernal.annotation.FieldIndex;
import com.kernal.annotation.FieldName;
import com.kernal.utils.PoiExcelUtil;
import com.kernal.utils.QueryUtil;
import com.tenwa.leasing.bean.ExeclBean;
/**
 * 
 * @author XU
 * @version 创建时间：2013-10-23 上午10:44:15
 * 财务报表导入
 */
@Service(value = "financeReportService")
public class FinanceReportServiceImpl extends AbstractBaseServiceImpl implements FinanceReportService {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	@Resource(name="tableService")
	private TableService tableService;
	
	@Resource(name="fileTemplateService")
	private FileTemplateService templateService;
	
	@Override
	public String insertFinanceReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 //获得上传的附件
		InputStream is = null;
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
	     MultipartFile  multipartFile = multipartRequest.getFile("tableImportTemplate");
	     if(null==multipartFile){
	    	 throw new BusinessException("没有上传财务报表");
	     }
	     //上传的参数据 
	     Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	     //列名对象解析
	     String  financeparams = model.get("parames");
		 if(null==financeparams||"".equals(financeparams)||"null".equalsIgnoreCase(financeparams.trim())){
			 throw new BusinessException("没有对Excel的配置");
		 }	
		try {
			BaseFile bf= templateService.saveUpFiletoService(multipartFile, model);
			String custid="";
			CustInfo custinfo=null;
			if(model.containsKey("custid")){
				custid=model.get("custid");
			    custinfo=this.tableService.findEntityByID(CustInfo.class, custid);
			    if(null==custinfo){
			    	 throw new BusinessException("给定的客户的ID没有找到客户");
			    }
			}else{
				 throw new BusinessException("没有给定客户的ID");
			}
			
			 Workbook wb = null;
			 is = multipartFile.getInputStream();
			 String importFileName = multipartFile.getOriginalFilename().toLowerCase();
			 if(importFileName.endsWith("xlsx")){
				wb = PoiExcelUtil.readWorkbook(is,ExcelVersionEnum.VERSION2007);
			 }else{
				wb = PoiExcelUtil.readWorkbook(is,ExcelVersionEnum.VERSION2003);
			 }
			List<FinanceReportParamBean>inintParam=this.getImportParams(financeparams);
			if(inintParam.size()>0){
				  for(FinanceReportParamBean param:inintParam){
					  Map<String, FinanceReportBean>  Mapfield=this.getClassFieldExcel(param.getSheeName(), param.getTargetClass());
					  if(Mapfield.keySet().size()>0){
				    	  try {
							Sheet sheet = wb.getSheet(param.getSheeName());
							if(null!=sheet){
							List finance=(List)this.getFinanceReprotEntitysByConfig(sheet, Mapfield, param,bf,custinfo);
							//保证实体
							if(null!=finance){
							 this.tableService.saveOrUpdateAllEntities(finance);	
							}}else{
								throw new BusinessException("上传的EXCEL中没有"+param.getSheeName());
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							throw new BusinessException("上传的EXCEL中没有"+param.getSheeName()+":"+e.getMessage());
						}
				    	  
				    	  
				      }else{
				    	  throw new BusinessException("excel中"+param.getSheeName()+"没有配置相应的类");
				      }
				  }
			}else{
				throw new BusinessException("没有对Excel的配置");
			}
		}catch(BusinessException b){
			throw new BusinessException(b.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		return "成功";
	}
	@Override
	public BaseDao getBussinessDao() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * 获得实体类和Excel的对应关系
     */
	@Override
	public Map<String, FinanceReportBean> getClassFieldExcel(String targetTable,String className)
			throws Exception {
		Map<String, FinanceReportBean> FinanceField=new HashMap<String, FinanceReportBean>();
		String tablename="";
		String sfieldIndex="";
		String sfieldName="";
		String sfield="";
		if(null==className||"".equals(className)||"null".equalsIgnoreCase(className)){
			throw new BusinessException("没有给定要导的实体类");
		}else{
			 try {
				Class<?> demo1=null;
				  demo1=Class.forName(className);
				  FieldName ctableField=(FieldName) demo1.getAnnotation(FieldName.class);
				  if(null== ctableField){
					  throw new BusinessException("类"+className+"没有加@FieldName注解");
				  }else{
					  tablename=ctableField.name();
					  if("".equals(tablename)){
						  throw new BusinessException("类"+className+"类表上没@FieldName有加注解"); 
					  }
					  if(!targetTable.equalsIgnoreCase(tablename)){
						  throw new BusinessException("要导入的实体类"+targetTable+"和类上@FieldName有加注解"+tablename+"不一样"); 
					  }
				  }
				  Field[] field = demo1.getDeclaredFields();
				  for (int i = 0; i < field.length; i++) {
					  sfieldIndex="";
				      sfieldName="";
				      sfield="";
					  Field fd=field[i];
		        	  FieldName anF= (FieldName)fd.getAnnotation(FieldName.class);
		        	  FieldIndex index=(FieldIndex)fd.getAnnotation(FieldIndex.class);
		        	  if(null!=index){
		        	    if(!"".equals(index.value())){
		        	    	sfieldIndex=index.value();
		        	    	sfield=fd.getName().toLowerCase().toString().trim();
		        	    	 if(null==anF || "".equals(anF.name().toString().trim())){
		        	    		 throw new BusinessException("类"+tablename+"的"+sfield+"没有加@FieldName注解"); 
		        	    	 } else{
		        	    		 sfieldName=anF.name().toString().trim();
		        	    	 }
		        	    	 
		        	    	 FinanceField.put(sfieldIndex, new FinanceReportBean(sfieldIndex,sfieldName,sfield)); 
		        	    }
		             }
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new BusinessException("getClassFieldExcel在解析实体类时出错"+e.getMessage());
			}
		}
		return FinanceField;
	}
	/**
	 * 将配置的参数据转化为实体
	 */
	@Override
	public List<FinanceReportParamBean> getImportParams(String params)
			throws Exception {
		// TODO Auto-generated method stub
		 JSONArray importExcelJsonArray = new JSONArray(params);
		 String sheetname="";
		 String targetClass="";
		 String headerCell="";
		 String dataCell="";
		 List<FinanceReportParamBean> importParam=new ArrayList<FinanceReportParamBean>();
		 try {
			for(int i = 0;i<importExcelJsonArray.length();i++)
			{    
				 sheetname="";
				 targetClass="";
				 headerCell="";
				 dataCell="";
				 JSONObject jsonExcel =importExcelJsonArray.getJSONObject(i);
				 if(jsonExcel.has("sheetname")){
					 sheetname=jsonExcel.getString("sheetname");
				 }
				 if(jsonExcel.has("targetClass")){
					 targetClass=jsonExcel.getString("targetClass");
				 }
				 if(jsonExcel.has("headerCell")){
					 headerCell=jsonExcel.getString("headerCell");
				 }
				 if(jsonExcel.has("dataCell")){
					 dataCell=jsonExcel.getString("dataCell");
				 }
				 if("".equals(sheetname)||"".equals(targetClass)||"".equals(headerCell)||"".equals(dataCell)){
					 throw new BusinessException("参数不全:将excel中的sheet("+sheetname+")导入到"+targetClass+"中表头列的cell("+headerCell+")数据列的cell("+dataCell+")"); 
				 }else{
					 String []vheaderCell=headerCell.split(",");
					 String []vdataCell=dataCell.split(",");
					 if(vheaderCell.length!=vdataCell.length){
				    	 throw new BusinessException("参数配置出错:标题cell和数据cell不一样多"); 
				    }
					 importParam.add(new FinanceReportParamBean(sheetname,targetClass,headerCell,dataCell)); 
				 }
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new BusinessException("getImportParams在解析配置时出错请检查传过去的参数据"+e.getMessage()); 
		}
		return importParam;
	}
	/**
	 * 将 excel中的sheet解析成对应的实体
	 */
	@Override
	public <T> Collection<T> getFinanceReprotEntitysByConfig(Sheet sheet,Map<String,FinanceReportBean> financebean, FinanceReportParamBean financeParam,BaseFile bf,CustInfo ci)
			throws Exception {  
		// TODO Auto-generated method stub
		String targetClass=financeParam.getTargetClass();
		Class<?> targetObject=Class.forName(targetClass);
		String sheaderCell=financeParam.getHeaderCell();
		String sdataCell=financeParam.getDataCell();
	    String vheaderCell[]=sheaderCell.split(",");
	    String vdataCell[]=sdataCell.split(",");
	    String headerCell="";
	    String dataCell="";
	    int  headerCellRowIndex=0;
	    int  headerCellCellIndex=0;
	    int  dataCellRowIndex=0;
	    int  dataCellCellIndex=0;
	    int sheetRowNum=sheet.getLastRowNum();
	    int datalength=0;
	    String cellvalue="";
	    String headerValue="";
	    String field="";
	    Boolean flag=true;
	    Boolean empty=false;
	    Map<String,JSONObject>FinanceEntiies=new HashMap<String,JSONObject>();
	    List finance=new ArrayList();
	    String year="";
	    try {
			for(int i=0;i<vheaderCell.length;i++){
				datalength=0;
				headerCellRowIndex=0;
			    headerCellCellIndex=0;
			    dataCellRowIndex=0;
			    dataCellCellIndex=0;
				headerCell=vheaderCell[i];
				dataCell=vdataCell[i];
				ExeclBean headerInfo=PoiExcelUtil.getExcelBean(headerCell);
				ExeclBean dataInfo=PoiExcelUtil.getExcelBean(dataCell);
				headerCellRowIndex=headerInfo.getRow_num()+1;
			    headerCellCellIndex=headerInfo.getCol_num();
			    dataCellRowIndex=dataInfo.getRow_num();
			    dataCellCellIndex=dataInfo.getCol_num();
			    flag=true;
			    
			    if(headerCellRowIndex>sheetRowNum ||dataCellRowIndex>sheetRowNum){
			    	 throw new BusinessException("解析excel出错:配置的标题cell("+headerCellRowIndex+")或数据cell("+dataCellRowIndex+")大于实际 sheet("+sheet.getSheetName()+")的row长度"); 
			    }else{
			       	Row datarow=sheet.getRow(dataCellRowIndex);
			       	datalength=0;
			       	//获得数据列的长度
			       	for(int j=dataCellCellIndex;j<datarow.getLastCellNum();j++){
			       		Cell datacell=datarow.getCell(j);
			       		cellvalue=PoiExcelUtil.getCellValue(datacell);
			       		if(flag==true){
			       		   if(null!=cellvalue &&(!"".equals(cellvalue))){
			       			  datalength=datalength+1;
			       	      }else{
			       	    	  flag=false;
			       	      }
			       		}
			       	}
			       	List<JSONObject>entity=new ArrayList<JSONObject>();
			       	for(int j=0;j<datalength;j++){
			       	   cellvalue="";
			           empty=true;
			           JSONObject financeEntityJson = new JSONObject();
			           datarow=sheet.getRow(dataCellRowIndex);
			           Cell cell=datarow.getCell(dataCellCellIndex+j);
			           year=PoiExcelUtil.getCellValue(datarow.getCell(dataCellCellIndex+j));
			           //隐藏列则不写入数据库
			          if(!sheet.isColumnHidden(dataCellCellIndex+j)){
			           if(!"".equals(year.trim())){
			       	      for(int h=dataCellRowIndex;h<sheetRowNum;h++){
			       	    	 datarow=sheet.getRow(h);
			       	    	 if(null!=datarow){
			       		     if(headerCellCellIndex<datarow.getLastCellNum()){
			       		     if(null!=datarow.getCell(headerCellCellIndex)){
			       		       headerValue=PoiExcelUtil.getCellValue(datarow.getCell(headerCellCellIndex));
			       		     }
			       		     if(dataCellCellIndex+j<datarow.getLastCellNum()){
			       		     if(null!=datarow.getCell(dataCellCellIndex+j)){
			       		    	cell= datarow.getCell(dataCellCellIndex+j);
			       		        cellvalue=PoiExcelUtil.getCellValue(datarow.getCell(dataCellCellIndex+j));
			       		     if(null!=cellvalue&&(!"".equals(cellvalue))){
			       			    field="";
			       			    flag=true;
			       			    if(h==dataCellRowIndex){flag=false;}
			       			    field=this.getExcelTableField(headerValue, (cell.getRowIndex()+1)+"_"+i, financebean, flag);
			       			    System.out.println(headerValue+":"+((cell.getRowIndex()+1)+"_"+i)+":"+cellvalue);
			       			    if(!"".equals(field)){
			       			    	financeEntityJson.put(field, cellvalue);
			       				   empty=false;
			       			    }
			       		     }}
			       	      }}}}
			       	      if(empty==false){
			       	    	  //根据年进行合并
			       		      if(FinanceEntiies.containsKey(year)){
			       		    	JSONObject temp=FinanceEntiies.get(year);
			       		    	Iterator it = financeEntityJson.keys();
			       		    	while (it.hasNext()) {
			       		    		String key = (String) it.next();  
			       		    		temp.put(key,financeEntityJson.get(key).toString());
			       		    	}
			       		    	FinanceEntiies.put(year, temp);
			       		      }else{
			       		    	FinanceEntiies.put(year, financeEntityJson);
			       		      }
			       	      }
			           }  
			          }
			       	}
			        
			    }	
			}
			System.out.println(FinanceEntiies);
			if(!FinanceEntiies.isEmpty()){
				Set<String> key = FinanceEntiies.keySet();
				for (Iterator it = key.iterator(); it.hasNext();) {
					 year = (String) it.next();
					 JSONObject jsonObj=FinanceEntiies.get(year);
					Object sourectObject=targetObject.newInstance();
					this.tableService.copyAndOverrideExistedValueFromJSONObject(jsonObj, sourectObject,null);
					try {
						BeanUtils.getPropertyDescriptor(sourectObject.getClass(), "upLoadId").getWriteMethod().invoke(sourectObject, bf);
						BeanUtils.getPropertyDescriptor(sourectObject.getClass(), "custId").getWriteMethod().invoke(sourectObject, ci);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new BusinessException("在记录上传文件的ID和客户时出请检查实体类中有没有upLoadId和custId字段"+e.getMessage());
					}
					finance.add(sourectObject);
					
				}
				
				return finance;
			}
			
	    }catch(BusinessException b){
	    	 b.printStackTrace();
	    	 throw new BusinessException(b.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		return null;
	}
	@Override
	public String getExcelTableField(String headerTitle, String rowIndex,Map<String, FinanceReportBean> financebean,Boolean flag) throws Exception {
		// TODO Auto-generated method stub
		FinanceReportBean fb=null;
		if(financebean.containsKey(rowIndex)){
			fb=financebean.get(rowIndex);
			if(flag==true){
			   if(fb.getFieldName().trim().equals(headerTitle)){
			       return fb.getField();
			   }else{
				throw new BusinessException("导入的EXCEL中的标题"+headerTitle+"和数据库中的实体对应的标题一不样");
			  }}else{
				  return fb.getField();
			}
		}else{
			return "";
		}
	}
}
