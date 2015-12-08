package com.business.serviceImpl;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.business.dao.BaseDao;
import com.business.dao.TableDao;
import com.business.entity.base.BaseDocumentConfig;
import com.business.entity.base.BaseDocumentConfigData;
import com.business.entity.base.BaseDocumentSavedData;
import com.business.entity.base.BaseDocumentSavedInfo;
import com.business.model.ExcelVersionEnum;
import com.business.model.Table;
import com.business.service.BeforeTableParamsLoadService;
import com.business.service.TableService;
import com.kernal.utils.BeanFieldUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.FileUtil;
import com.kernal.utils.MathUtil;
import com.kernal.utils.PoiExcelUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.WebUtil;
import com.kernal.utils.XMLDataUtil;

@Service(value="tableService")
public class TableServiceImpl extends AbstractBaseServiceImpl implements TableService 
{
	@Resource(name="tableDao")
    private TableDao tableDao;

	@Override
	public String getTableJsonData(String xmlFileNameOrPath,Map<String, String> model) throws Exception 
    {
		String beforeTableParamsLoadServiceName = model.get("beforeTableParamsLoadServiceName");
		if(null != beforeTableParamsLoadServiceName){
			BeforeTableParamsLoadService beforeTableParamsLoadService = (BeforeTableParamsLoadService)WebUtil.getApplicationContext().getBean(beforeTableParamsLoadServiceName);
			beforeTableParamsLoadService.beforeTableParamsLoad(model);
		}
		 Table table = new Table();
		 table.setTableXmlLoadingDirectoryFilePath(ResourceUtil.getTablesDataSourceDirectoryPath());
		 table.setTableXmlTableFileNameOrPath(xmlFileNameOrPath);
		 table.setModel(model);
		 this.readTabletXmlInfo(table,false);
		 if(ResourceUtil.isDebug())
		 {
			 if(table.isShowSql())
			 {
				 System.out.println("###tableXml:"+table.getTableXmlTableFileNameOrPath());
				 System.out.println("###tableSql:"+table.getTargetSql());
			 }
		 }

		 int start = 0;
		 int limit = Integer.MAX_VALUE;
		 
		 String startStr ="";
		 String limitStr = ""; 
         if(model.get("start")==null){
        	 startStr = StringUtil.nullToString(model.get("pageIndex"));
		 }else{
			 startStr = StringUtil.nullToString(model.get("start"));
		 }
         
         if(model.get("limit")==null){
        	 limitStr = StringUtil.nullToString(model.get("pageSize")); 
		 }else{
			 limitStr = StringUtil.nullToString(model.get("limit")); 
		 }
         
		 if(!startStr.isEmpty())
		 {
			 start = Integer.parseInt(startStr);
		 }
		 if((!"99999999".equals(limit))&&(!limitStr.isEmpty()))
		 {
			 limit = Integer.parseInt(limitStr);
		 }
		 table.setStart(start);
		 table.setLimit(limit);
		 
		 if(StringUtil.nullToString(table.getSourceSql()).isEmpty())
		 {
			 System.out.println("tracywindy导出异常，异常sql：【"+table.getSourceSql()+"】");
			 System.out.println("traycwindyExcel导出异常,excelXML："+table.getTableXmlTableFileNameOrPath());
			 System.out.println("请求参数列表："+table.getModel());
		 }
		 this.tableDao.getTableInfo(table,false);
		 
		 Map<String,String> headers = table.getHeaders();
		 int totalCount  = table.getTotalCount();
		 /*JSONArray tableJsonDatas = table.getTableJsonArrayData();
		 
		 JSONObject jsonRoot = new JSONObject();
		 String  noRecordFlag = "false";
		 if((totalCount <= 0)||(0==tableJsonDatas.length())){
			 totalCount = 0;
			 noRecordFlag="true";
			 JSONObject headerObj = new JSONObject();
			 tableJsonDatas.put(headerObj);
			 for(String key : headers.keySet())
			 {
				 headerObj.put(StringUtil.getJsonString(key).toLowerCase() ,"");
			 }
		 }
		 jsonRoot.put("totalCount", totalCount)
		         .put("norecord"  , noRecordFlag)
		         .put("datas"     , tableJsonDatas)
		         ;*/
		 String data_json = table.getTableJsonArrayStringDatas();//table.getTableJsonArrayData().toString();
		 StringBuffer sb = new StringBuffer();
		 if(model.get("limit")!=null){
		 if((totalCount <= 0)||("[]".equals(data_json)))
         {
			 int tempIndex = 0;
			 sb.append("{totalCount:0,norecord:\"true\",datas:");
					 StringBuffer tempDataJsonString = new StringBuffer();
					 tempDataJsonString.append("[{");
					 for(String key : headers.keySet())
					 {
						 String value = "";
						 if(0 < tempIndex)
						 {
							tempDataJsonString.append(",");
						 }
						 tempDataJsonString.append("\"")
							       .append(StringUtil.getJsonString(key).toLowerCase() )
							       .append("\":")
							       .append("\"")
							       .append(value)
							       .append("\"");
						 tempIndex++;
					 }
					 tempDataJsonString.append("}]");
					 sb.append(tempDataJsonString);
		   }
		  else
		  {
			 sb.append("{totalCount:"+totalCount+",norecord:\"false\",datas:");
			 sb.append(data_json);
		  }
		 sb.append("}"); 
		 }else{
			 if((totalCount <= 0)||("[]".equals(data_json)))
	         {
				 int tempIndex = 0;
				 sb.append("{total:0,norecord:\"true\",datas:");
						 StringBuffer tempDataJsonString = new StringBuffer();
						 tempDataJsonString.append("[");
						 /*for(String key : headers.keySet())
						 {
							 String value = "";
							 if(0 < tempIndex)
							 {
								tempDataJsonString.append(",");
							 }
							 tempDataJsonString.append("\"")
								       .append(StringUtil.getJsonString(key).toLowerCase() )
								       .append("\":")
								       .append("\"")
								       .append(value)
								       .append("\"");
							 tempIndex++;
						 }*/
						 tempDataJsonString.append("]");
						 sb.append(tempDataJsonString);
			   }
			  else
			  {
				 sb.append("{total:"+totalCount+",norecord:\"false\",datas:");
				 sb.append(data_json);
			  }
			 sb.append("}");
		 }
		 
		 
		 return sb.toString();
		 //return jsonRoot.toString();
	}
	@Override
	public void readTabletXmlInfo(Table table,boolean isOnlyExportByXmlFile) throws Exception
	{
		String tableXmlLoadingDirectoryFilePath = table.getTableXmlLoadingDirectoryFilePath();
		String tableXmlTableFileNameOrPath = table.getTableXmlTableFileNameOrPath();
		Map<String,String> tableInfoFromXmlFile = null;
		if(ResourceUtil.isDebug()||isOnlyExportByXmlFile)
		{
			String tableXmlfileNameFullPath = tableXmlLoadingDirectoryFilePath+"/"+tableXmlTableFileNameOrPath;
			tableXmlfileNameFullPath = FileUtil.getFilePathString(tableXmlfileNameFullPath);
			tableInfoFromXmlFile = XMLDataUtil.readTableInfoFromXmlFile(tableXmlfileNameFullPath);
		}
		else
		{
			tableInfoFromXmlFile = WebUtil.getAllXMLTable().get(table.getXmlTableFileFullPathWithoutFileSeparator());
		}
		String show_sql = tableInfoFromXmlFile.get("show_sql");
		String table_sql = tableInfoFromXmlFile.get("table_sql");
		String excel_sql = tableInfoFromXmlFile.get("excel_sql");
		String dataSource = tableInfoFromXmlFile.get("dataSource");
		
		table.setShowSql(show_sql);
		table.setSourceSql(table_sql);
		table.setExcelSourceSql(excel_sql);
		table.setDataSourceName(dataSource);
	}
	@Override
	public  void doExportExcel(String xmlFileNameOrPath,Map<String, String> model,boolean isExportTitle,OutputStream os,boolean isOnlyExportByXmlFile) throws Exception
	{
			String beforeTableParamsLoadServiceName = model.get("beforeTableParamsLoadServiceName");
			if(null != beforeTableParamsLoadServiceName){
				BeforeTableParamsLoadService beforeTableParamsLoadService = (BeforeTableParamsLoadService)WebUtil.getApplicationContext().getBean(beforeTableParamsLoadServiceName);
				beforeTableParamsLoadService.beforeTableParamsLoad(model);
			}
		   try {
			String fileTitleName = model.get("excelTitleName");
			   fileTitleName = URLDecoder.decode(fileTitleName, "utf-8").trim();
			   String complexHeadersStr = StringUtil.nullToString(model.get("complexHeadersStr"));
			   String columnsStr = StringUtil.nullToString(model.get("columnsStr"));
			   //String forceExportExcelIndexs =  StringUtil.nullToString(model.get("forceExportExcelIndexs"));
				ExcelVersionEnum excelVersionEnum = ExcelVersionEnum.VERSION2007;
				String exportExcelVersion = StringUtil.nullToString(model.get("exportExcelVersion"),"2007");
				if(exportExcelVersion.trim().equals("2003")){
					excelVersionEnum = ExcelVersionEnum.VERSION2003;
				}
			   if("local".equals(model.get("loadMode")))
			   {
				   JSONArray  columnsJsonArray = new JSONArray(columnsStr);
			       List<String> columns_mapping  = new ArrayList<String>();
			       Map<String,String> columnTypesMapping = new HashMap<String,String>();
				   for(int i=0;i<columnsJsonArray.length();i++)
				   {
					   JSONObject columnJson = columnsJsonArray.getJSONObject(i);
					   String mapping = columnJson.getString("mapping");
					   columns_mapping.add(mapping);
					   String exportType = "varchar" ;
					   if(columnJson.has("exportType"))
					   {
						   exportType = columnJson.getString("exportType").toLowerCase();
					   }
					   else if(columnJson.has("type")){
						   exportType = columnJson.getString("type").toLowerCase();
					   }
					   columnTypesMapping.put(mapping, exportType);
				   }
			       List<Map<String,String>> datas = new ArrayList<Map<String,String>>();
			       String datasStr = model.get("datasStr");
			       JSONArray datasJsonArray = new JSONArray(datasStr);
			       for(int i=0;i<datasJsonArray.length();i++)
			       {
			    	   JSONObject dataJson = datasJsonArray.getJSONObject(i);
			    	   Map<String,String> rowData = new HashMap<String,String>();
			    	   for(String columnName:columns_mapping){
			    		   String columnData = "";
			    		   if(dataJson.has(columnName))
			    		   {
			    			   columnData = StringUtil.nullToString(dataJson.getString(columnName));
			    		   }
			    		   rowData.put(columnName, columnData);
			    	   }
			    	   datas.add(rowData);
			       }
				   this.dealExcelDatas(excelVersionEnum,complexHeadersStr, columnsStr, datas,columnTypesMapping,fileTitleName,isExportTitle, os);
			   }
			   else
			   {
				   Table table = new Table();
				   table.setTableXmlLoadingDirectoryFilePath(ResourceUtil.getTablesDataSourceDirectoryPath());
				   table.setTableXmlTableFileNameOrPath(xmlFileNameOrPath);
				   table.setModel(model);
				   this.readTabletXmlInfo(table,isOnlyExportByXmlFile);
				   int start = 0;
				   int limit = Integer.MAX_VALUE;
				   table.setStart(start);
				   table.setLimit(limit);
				   this.tableDao.getTableExportExcelInfo(table,false);
				   if(!table.getExcelSourceSql().equals(table.getSourceSql()))
				   {
					   columnsStr = table.getColumnsJsonArray().toString();
				   }
			       this.dealExcelDatas(excelVersionEnum,complexHeadersStr, columnsStr, table.getDatas(),table.getColumnTypesMapping(), fileTitleName,isExportTitle, os);
			   }
		} 
	    finally{
	    	if(null != os){
			   os.flush();
			   os.close();
	    	}
		}
	}
	@Override
	public void dealExcelDatas(ExcelVersionEnum excelVersionEnum,String complexHeadersStr,String columnsStr,List<Map<String,String>> datas,Map<String,String> dataTypesMapping,String fileTitleName,boolean isExportTitle,OutputStream os) throws Exception
	{
		String exportDate   = DateUtil.getSystemDateTime();
		Workbook workbook = PoiExcelUtil.createExcelWorkbook(excelVersionEnum);
		CellStyle fileTitleStyle = PoiExcelUtil.getExportFileNameStyle(workbook);
		CellStyle fileDateStyle = PoiExcelUtil.getExportDateStyle(workbook);//.getExportContentDateStyle(workbook);
		CellStyle complexHeaderTitleStyle= PoiExcelUtil.getExportComplexHeaderTitleStyle(workbook);
		CellStyle contentTitleStyle = PoiExcelUtil.getExportContentTitleStyle(workbook);
		CellStyle cotentStyle  = PoiExcelUtil.getExportContentStyle(workbook);
		
		//CellStyle numberCotentStyle = PoiExcelUtil.getExportContentNumberStyle(workbook);
		//CellStyle DateCotentStyle = PoiExcelUtil.getExportContentDateStyle(workbook);
		//create sheet 
		int pageSize = 50000;
		//内容
		Sheet sheet = null;
		int rowIndex = -1;
		int realColIndex = -1;
		JSONArray columns = null;
		int sheetNum = 0;
        //保存自适应宽度
		Map<String,Integer> savedWidthMap = new HashMap<String,Integer>();
		//无数据时候，只显示标题行
        if(0 == sheetNum)
        {
			sheet = PoiExcelUtil.createExcelSheet(workbook,null/*fileTitleName+"（"+(++sheetNum)+"）"*/);
			int len = 0;
			columns = new JSONArray(columnsStr);
			for(int topIndex=0;topIndex<columns.length();topIndex++)
			{
				if(!columns.getJSONObject(topIndex).getBoolean("hidden"))
				{
					len++;
				}
			}
        	if(isExportTitle)
        	{
				//excel标题行
				Row excelTitleRow = PoiExcelUtil.createExcelRow(sheet, 0);
				Cell excelTitleCell = PoiExcelUtil.createLabelExcelCell(excelTitleRow,0,fileTitleStyle,(fileTitleName),CellStyle.ALIGN_LEFT);
				PoiExcelUtil.createMergeRegion(sheet, excelTitleCell,1,len);
				//日期行
				Row excelDateRow = PoiExcelUtil.createExcelRow(sheet, 1);
				Cell excelDateCell = PoiExcelUtil.createLabelExcelCell(excelDateRow,0,fileDateStyle,exportDate,CellStyle.ALIGN_LEFT);
				PoiExcelUtil.createMergeRegion(sheet, excelDateCell,1,len);
				//行号(从3开始)
				rowIndex = 2;
				//创建复杂表头
				if((!complexHeadersStr.isEmpty())&&(complexHeadersStr.matches("^\\[(.|\\W)*\\]$")))
				{
					JSONArray complexHeadersArray = new JSONArray(complexHeadersStr);
					rowIndex+=complexHeadersArray.length();
					for(int chIndex=0;chIndex<(rowIndex-2);chIndex++)
					{
						     Row   complexHeaderRow = PoiExcelUtil.createExcelRow(sheet, chIndex+2);
						     JSONArray complexHeaderRowData = (JSONArray) complexHeadersArray.get(chIndex);
							 int currentColumnRealIndex = 0;
							 int beforeCurrentColumnRealIndex = 0;
							 int disperRealIndex =0;
				        	 for(int complexColIndex=0;complexColIndex<complexHeaderRowData.length();complexColIndex++)
				        	 {
				        		 int rowspan = 1;
				        		 int colspan = 1;
				        		 
				        		 JSONObject complexHeaderRowDataColumn = (JSONObject)complexHeaderRowData.get(complexColIndex);
				        		 String columnHeader = StringUtil.nullToString(complexHeaderRowDataColumn.get("header"));
				        		 //String tempColumnHeaderAlign = StringUtil.nullToString(complexHeaderRowDataColumn.get("headerAlign"));
				        		 
				        		 String rowspanStr = complexHeaderRowDataColumn.isNull("rowspan")?"":StringUtil.nullToString(complexHeaderRowDataColumn.get("rowspan"));
				        		 String colspanStr = complexHeaderRowDataColumn.isNull("colspan")?"":StringUtil.nullToString(complexHeaderRowDataColumn.get("colspan"));
				        		 
				        		 beforeCurrentColumnRealIndex = currentColumnRealIndex;
				        		 if(!rowspanStr.isEmpty())
				        		 {
				        			 rowspan = Integer.parseInt(rowspanStr);
				        		 }
				        		 if(!colspanStr.isEmpty())
				        		 {
				        			 colspan = Integer.parseInt(colspanStr);
				        		 }
				        		 int realComplexColIndex = beforeCurrentColumnRealIndex-disperRealIndex;
				        		 if(complexHeaderRowDataColumn.has("startColNum")){
				        			 realComplexColIndex = complexHeaderRowDataColumn.getInt("startColNum") - 1;
				        			 currentColumnRealIndex = realComplexColIndex;
				        		 }
				        		  
				        		 Cell complexHeaderCell = PoiExcelUtil.createLabelExcelCell(complexHeaderRow,realComplexColIndex ,complexHeaderTitleStyle , columnHeader, CellStyle.ALIGN_CENTER);
				        		 
				        		 currentColumnRealIndex+=colspan;
				        		 for(int colConfigIndex=beforeCurrentColumnRealIndex;colConfigIndex<currentColumnRealIndex;colConfigIndex++)
				        		 {
				        			 if(columns.getJSONObject(colConfigIndex).getBoolean("hidden"))
				        			 {
				        				 colspan--;
				        				 disperRealIndex++;
				        			 }
				        		 }
				        		PoiExcelUtil.createMergeRegion(sheet, complexHeaderCell, rowspan, colspan);
				        	 }
					}
				}
        	}
        	else
        	{
        		rowIndex = 0;
        	}
			realColIndex = 0;
			//内容标题行
			Row contentTitleRow = PoiExcelUtil.createExcelRow(sheet,rowIndex++);
			for(int index = 0;index<columns.length();index++)
			{
				JSONObject columnObject = columns.getJSONObject(index);
				if(columnObject.getBoolean("hidden"))
				{
					continue;
				}
				String headerValue  = columnObject.getString("header");
				Integer currentSavedColWidth = savedWidthMap.get("col_"+realColIndex);
				Integer currentColWidth = headerValue.getBytes().length;
				if(null != currentSavedColWidth){
					currentColWidth = Integer.valueOf(Math.max(currentColWidth,currentSavedColWidth.intValue()));
				}
				savedWidthMap.put("col_"+realColIndex, currentColWidth);
				PoiExcelUtil.createLabelExcelCell(contentTitleRow, realColIndex, contentTitleStyle,headerValue,CellStyle.ALIGN_LEFT);
				realColIndex++;
			}
        }
		for(int dataIndex = 0;dataIndex<datas.size();dataIndex++)
		{
			if((0!=dataIndex)&&( 0 == dataIndex%pageSize))
			{
				sheet = PoiExcelUtil.createExcelSheet(workbook,null/*fileTitleName+"（"+(++sheetNum)+"）"*/);
				int len = 0;
				columns = new JSONArray(columnsStr);
				for(int topIndex=0;topIndex<columns.length();topIndex++)
				{
					if(!columns.getJSONObject(topIndex).getBoolean("hidden"))
					{
						len++;
					}
				}
	        	if(isExportTitle)
	        	{
					//excel标题行
					Row excelTitleRow = PoiExcelUtil.createExcelRow(sheet, 0);
					Cell excelTitleCell = PoiExcelUtil.createLabelExcelCell(excelTitleRow,0,fileTitleStyle,(fileTitleName),CellStyle.ALIGN_LEFT);
					PoiExcelUtil.createMergeRegion(sheet, excelTitleCell,1,len);
					//日期行
					Row excelDateRow = PoiExcelUtil.createExcelRow(sheet, 1);
					Cell excelDateCell = PoiExcelUtil.createLabelExcelCell(excelDateRow,0,fileDateStyle,exportDate,CellStyle.ALIGN_LEFT);
					PoiExcelUtil.createMergeRegion(sheet, excelDateCell,1,len);
					//行号(从3开始)
					rowIndex = 2;
					//创建复杂表头
					if((!complexHeadersStr.isEmpty())&&(complexHeadersStr.matches("^\\[(.|\\W)*\\]$")))
					{
						JSONArray complexHeadersArray = new JSONArray(complexHeadersStr);
						rowIndex+=complexHeadersArray.length();
						for(int chIndex=0;chIndex<(rowIndex-2);chIndex++)
						{
							     Row   complexHeaderRow = PoiExcelUtil.createExcelRow(sheet, chIndex+2);
							     JSONArray complexHeaderRowData = (JSONArray) complexHeadersArray.get(chIndex);
								 int currentColumnRealIndex = 0;
								 int beforeCurrentColumnRealIndex = 0;
								 int disperRealIndex =0;
					        	 for(int complexColIndex=0;complexColIndex<complexHeaderRowData.length();complexColIndex++)
					        	 {
					        		 int rowspan = 1;
					        		 int colspan = 1;
					        		 
					        		 JSONObject complexHeaderRowDataColumn = (JSONObject)complexHeaderRowData.get(complexColIndex);
					        		 String columnHeader = StringUtil.nullToString(complexHeaderRowDataColumn.get("header"));
					        		 //String tempColumnHeaderAlign = StringUtil.nullToString(complexHeaderRowDataColumn.get("headerAlign"));
					        		 
					        		 String rowspanStr = complexHeaderRowDataColumn.isNull("rowspan")?"":StringUtil.nullToString(complexHeaderRowDataColumn.get("rowspan"));
					        		 String colspanStr = complexHeaderRowDataColumn.isNull("colspan")?"":StringUtil.nullToString(complexHeaderRowDataColumn.get("colspan"));
					        		 
					        		 beforeCurrentColumnRealIndex = currentColumnRealIndex;
					        		 if(!rowspanStr.isEmpty())
					        		 {
					        			 rowspan = Integer.parseInt(rowspanStr);
					        		 }
					        		 if(!colspanStr.isEmpty())
					        		 {
					        			 colspan = Integer.parseInt(colspanStr);
					        		 }
					        		 //System.out.println(beforeCurrentColumnRealIndex-disperRealIndex+"：");
					        		 Cell complexHeaderCell = PoiExcelUtil.createLabelExcelCell(complexHeaderRow, beforeCurrentColumnRealIndex-disperRealIndex,complexHeaderTitleStyle , columnHeader, CellStyle.ALIGN_CENTER);
					        		 currentColumnRealIndex+=colspan;
					        		 for(int colConfigIndex=beforeCurrentColumnRealIndex;colConfigIndex<currentColumnRealIndex;colConfigIndex++)
					        		 {
					        			 if(columns.getJSONObject(colConfigIndex).getBoolean("hidden"))
					        			 {
					        				 colspan--;
					        				 disperRealIndex++;
					        			 }
					        		 }
					        		 PoiExcelUtil.createMergeRegion(sheet, complexHeaderCell, rowspan, colspan);
					        	 }
						}
					}
	        	}
	        	else
	        	{
	        		rowIndex = 0;
	        	}
				realColIndex = 0;
				//内容标题行
				Row contentTitleRow = PoiExcelUtil.createExcelRow(sheet,rowIndex++);
				for(int index = 0;index<columns.length();index++)
				{
					JSONObject columnObject = columns.getJSONObject(index);
					if(columnObject.getBoolean("hidden"))
					{
						continue;
					}
					String headerValue = columnObject.getString("header");
					PoiExcelUtil.createLabelExcelCell(contentTitleRow, realColIndex, contentTitleStyle,headerValue,CellStyle.ALIGN_LEFT);
					realColIndex++;
				}
			}
			realColIndex=0;
			Map<String,String> dataRow = datas.get(dataIndex);
			Row contentRow = PoiExcelUtil.createExcelRow(sheet,rowIndex++);
			for(int index = 0;index<columns.length();index++)
			{
				if(columns.getJSONObject(index).getBoolean("hidden"))
				{
					continue;
				}
				String mappingName = null;
				try
				{
					mappingName = StringUtil.nullToString(columns.getJSONObject(index).getString("mapping"));
				}catch(Exception e)
				{
					mappingName = "";
				}
				
				String value = "-";
				if(!mappingName.isEmpty())
				{
					value = StringUtil.empty2Other(dataRow.get(mappingName), "-");
				}
				Integer currentSavedColWidth = savedWidthMap.get("col_"+realColIndex);
				Integer currentColWidth = value.getBytes().length;
				if(null != currentSavedColWidth){
					currentColWidth = Integer.valueOf(Math.max(currentColWidth,currentSavedColWidth.intValue()));
				}
				savedWidthMap.put("col_"+realColIndex, currentColWidth);
				//通过数据库类型判断 单元格类型
				String typeName = null;
				try{
					typeName = StringUtil.nullToString(dataTypesMapping.get(mappingName)).toLowerCase();
				}catch(Exception e){
					typeName = "VARCHAR2".toLowerCase();
				}
				//int typeName_int = Integer.parseInt(StringUtil.nullToString(dataTypes_int.get(index)));
				boolean isNumber = false;
			    if((typeName.indexOf("int")>-1))
				{
					isNumber=true;
				}
				else if((typeName.indexOf("float")>-1))
				{
					isNumber=true;
				}
				else if((typeName.indexOf("double")>-1))
				{
					isNumber=true;
				}
				else if(typeName.indexOf("decimal")>-1)
				{
					isNumber=true;
				}
				else if(typeName.indexOf("number")>-1)
				{
					isNumber=true;
				}
			    if("-".equals(value))
			    {
			    	isNumber = false;
			    }
			    if("false".equalsIgnoreCase(value)||"true".equalsIgnoreCase(value))
			    {
			    	isNumber = false;
			    }
				if(isNumber)
				{
				   PoiExcelUtil.createNumberExcelCell(contentRow, realColIndex, cotentStyle,value ,20);
				}
				else
				{
			       PoiExcelUtil.createLabelExcelCell(contentRow, realColIndex, cotentStyle, value,CellStyle.ALIGN_LEFT);
				}
				realColIndex++;
			}
		}
		PoiExcelUtil.setMergeRegionsCellStyle(sheet,cotentStyle);
		//PoiExcelUtil.setAutoColumnWidth(sheet,true);
		PoiExcelUtil.setAutoColumnWidthByMap(sheet,savedWidthMap);
		//生成excel
		PoiExcelUtil.writeWorkBook(workbook, os);
	}
	
	
	 /**
	 * (non-Javadoc)
	 * @see com.business.service.TableService#getTreeJsonData(java.lang.String, java.util.Map)
	 **/
	@Override
	public String getTreeJsonData(String xmlFileNameOrPath,Map<String, String> model) throws Exception {
		 return this.getJsonArrayData(xmlFileNameOrPath, model).toString();
	}
	@Override
	public JSONArray getJsonArrayData(String xmlFileNameOrPath,Map<String, String> model) throws Exception {
		 Table table = new Table();
		 table.setTableXmlLoadingDirectoryFilePath(ResourceUtil.getTablesDataSourceDirectoryPath());
		 table.setTableXmlTableFileNameOrPath(xmlFileNameOrPath);
		 table.setModel(model);
		 this.readTabletXmlInfo(table,false);
		 int start = 0;
		 int limit = Integer.MAX_VALUE;
		 table.setStart(start);
		 table.setLimit(limit);
		 if(ResourceUtil.isDebug())
		 {
			 if(table.isShowSql())
			 {
				 System.out.println("###tableXml:"+table.getTableXmlTableFileNameOrPath());
				 System.out.println("###tableSql:"+table.getTargetSql());
			 }
		 }
		 if(StringUtil.nullToString(table.getSourceSql()).isEmpty())
		 {
			 System.out.println("异常sql：【"+table.getSourceSql()+"】");
			 System.out.println("请求参数列表："+table.getModel());
		 }
		 this.tableDao.getTableInfo(table,true);
		 
		 
		 return table.getTableJsonArrayData();
	}
	
	 /**
	 * (non-Javadoc)
	 * @see com.business.serviceImpl.AbstractBaseServiceImpl#getBussinessDao()
	 **/
	
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return this.tableDao;
	}
	
	 /**
	 * (non-Javadoc)
	 * @see com.business.service.TableService#importExcel(org.springframework.web.multipart.MultipartFile, java.util.Map)
	 **/
	
	@SuppressWarnings("unchecked")
	@Override
	public String importExcel(MultipartFile multipartFile,
			Map<String, String> modelData) throws Exception {
		InputStream is = null;
		JSONArray resultJsonArray;
		try {
			String importExcelColumnStr = modelData.get("importExcelColumnStr");
			JSONArray importExcelColumnJsonArray = new JSONArray(importExcelColumnStr);
			Map<String,String> mappingMap = new HashMap<String,String>();
			Map<String,String> hiddenNameMap = new HashMap<String,String>();
			Map<String,String> entityClassNameMap = new HashMap<String,String>();
			Map<String,String> entityHeaderFieldNameMap = new HashMap<String,String>();
			Map<String,String> entityHeaderFieldTypeNameMap = new HashMap<String,String>();
			for(int i = 0;i<importExcelColumnJsonArray.length();i++)
			{
			   JSONObject jsonColumn = 	importExcelColumnJsonArray.getJSONObject(i);
			   String header = "";
			   String name   = jsonColumn.getString("mapping");
			   String hiddenName = null;
			   String entityClassName = null;
			   String entityHeaderFieldName = null;
			   String entityHeaderFieldTypeName = null;
			   if(jsonColumn.has("hiddenName")){
				   hiddenName = StringUtil.empty2Other(jsonColumn.getString("hiddenName"), null);
			   }
			   if(jsonColumn.has("entityClassName")){//DictionaryData
				   entityClassName = StringUtil.empty2Other(jsonColumn.getString("entityClassName"),null);
			   }
			   if(jsonColumn.has("entityHeaderFieldName")){//name
				   entityHeaderFieldName = StringUtil.empty2Other(jsonColumn.getString("entityHeaderFieldName"),null);
			   }
			   else{
				   entityHeaderFieldName = name;
			   }
			   if(jsonColumn.has("type")){
				   entityHeaderFieldTypeName = jsonColumn.getString("type").toLowerCase();
			   }
			   else{
				   entityHeaderFieldTypeName = "VARCHAR2".toLowerCase();
			   }
			   if(jsonColumn.has("header"))
			   {
				   header = jsonColumn.getString("header");
			   }
			   else
			   {
				   header = name;
			   }
			   mappingMap.put(header, name);
			   hiddenNameMap.put(header, hiddenName);
			   entityClassNameMap.put(header, entityClassName);
			   entityHeaderFieldNameMap.put(header, entityHeaderFieldName);
			   entityHeaderFieldTypeNameMap.put(header, entityHeaderFieldTypeName);
			}
			is = multipartFile.getInputStream();
			resultJsonArray = new JSONArray();
			Workbook wb = null;
			String importFileName = multipartFile.getOriginalFilename().toLowerCase();
			if(importFileName.endsWith("xlsx")){
				wb = PoiExcelUtil.readWorkbook(is,ExcelVersionEnum.VERSION2007);
			}else{
				wb = PoiExcelUtil.readWorkbook(is,ExcelVersionEnum.VERSION2003);
			}
			
			Sheet sheet = wb.getSheetAt(0);
			
			String skipRowCountStr = StringUtil.nullToString( modelData.get("skipRowCount"),"0");
			int skipRowCount = Integer.parseInt(skipRowCountStr);
			//标题行
			Row   headerRow = sheet.getRow(skipRowCount);
			 //遍历列和单元格  
			//Iterator<Row> rit = sheet.rowIterator();
			//跳过标题行
			/*for(int si=1;si<=skipRowCount;si++){
				System.out.println("####KKKK:"+si);
				rit.next();
			}*/
			int rowCount = sheet.getPhysicalNumberOfRows();
			//遍历行数据
			//while(rit.hasNext())
			for(int rowIndex = skipRowCount+1;rowIndex < rowCount;rowIndex++)
			{  
				JSONObject jsonObj = new JSONObject();
				Row row = (Row)sheet.getRow(rowIndex);//rit.next();  
				for(Iterator cit = row.cellIterator();cit.hasNext();)
				{  
					Cell cell = (Cell)cit.next(); 
					String value = "";
					switch(cell.getCellType()){
					   case Cell.CELL_TYPE_NUMERIC :{
						   try{
							   value = MathUtil.decimal(cell.getNumericCellValue(), 10);
						   }catch(Exception e){
							   value = cell.getStringCellValue()+"";
							   value = MathUtil.decimal(Double.parseDouble(value.replaceAll(",", "")), 10);
						   }
						break;}
					   case Cell.CELL_TYPE_STRING :{value = cell.getStringCellValue()+"";break;}
					   case Cell.CELL_TYPE_BOOLEAN :{value = cell.getBooleanCellValue()+"";break;}
					}
					value = value.trim();
					int    colIndex = cell.getColumnIndex();
					String header = headerRow.getCell(colIndex).getStringCellValue().trim();
					String name   = mappingMap.get(header);
					String hiddenName = hiddenNameMap.get(header);
					String entityClassName = entityClassNameMap.get(header);
					String entityHeaderFieldName = entityHeaderFieldNameMap.get(header);
					String entityHeaderFieldTypeName = entityHeaderFieldTypeNameMap.get(header);
					if(null != name){
						jsonObj.put(name, value);
					}
					if((null != hiddenName)&&(null != entityClassName)&&(null != entityHeaderFieldName)){
						Class<?> entityClass = Class.forName(entityClassName);
						Map<String,Object> filterMap = new HashMap<String,Object>();
						//通过数据库类型判断 单元格类型
						Object filterValue = value;
					    if((entityHeaderFieldTypeName.indexOf("int")>-1))
						{
					    	filterValue = new Integer(value);
						}
						else if((entityHeaderFieldTypeName.indexOf("float")>-1))
						{
							filterValue = new Float(value);
						}
						else if((entityHeaderFieldTypeName.indexOf("double")>-1))
						{
							filterValue = new Double(value);
						}
						else if(entityHeaderFieldTypeName.indexOf("decimal")>-1)
						{
							filterValue = new BigDecimal(value);
						}
						else if(entityHeaderFieldTypeName.indexOf("number")>-1)
						{
							filterValue = new Integer(value);
						}
						else if(entityHeaderFieldTypeName.indexOf("boolean")>-1)
						{
							filterValue = new Boolean(value);
						}
					    filterMap.put(entityHeaderFieldName, filterValue);
					    String hiddenValue = null;
					    List objList = this.findEntityByProperties(entityClass, filterMap);
					    if(objList.size()>0){
					    	hiddenValue = (entityClass.getMethod("getId").invoke(objList.get(0))).toString();
					    }
						jsonObj.put(hiddenName, hiddenValue);
					}
				}  
				resultJsonArray.put(jsonObj);
			}
		} 
		finally{
			if(null != is){
				is.close();
			}
		}  
		return resultJsonArray.toString();
	}
	public String createTree2TableJsonString(String savedDataKey,String dictTableName,String dictTableDataName,String rootDictId,boolean isLoadDictData,Map<String,String> savedDataKeyMap) throws Exception
	{
		String treeTableJson    = "";
		String treeDataMapping  = "";
		int    maxTreeLevel     = 0;
		int    maxTreeDataCount = 0;
		String valuesMapping   = "";
		
		savedDataKeyMap.put("savedDataKey", savedDataKey);
		savedDataKeyMap.put("dictTableName", dictTableName);
		savedDataKeyMap.put("dictTableDataName", dictTableDataName);
		savedDataKeyMap.put("rootDictId", rootDictId);
		
		JSONArray treeTableInfoArray = this.getJsonArrayData("tree2table/queryTreeTableInfo.xml", savedDataKeyMap);
		if(0 < treeTableInfoArray.length())
		{
			JSONObject treeTableInfoJson = treeTableInfoArray.getJSONObject(0);
			treeTableJson    = treeTableInfoJson.getString("tree_table_json_");
			treeDataMapping  = treeTableInfoJson.getString("tree_data_mapping_");
			maxTreeLevel     = treeTableInfoJson.getInt("max_tree_level_");
			maxTreeDataCount = treeTableInfoJson.getInt("max_tree_data_count_");
			valuesMapping    = treeTableInfoJson.getString("values_mapping_");
		}
		else
		{
			//各个级别对应的节点
			JSONArray allLevelTreeJsonArray = this.getJsonArrayData("tree2table/queryAllLevelTree.xml", savedDataKeyMap);
			//各个级别对应的子节点数量
			JSONArray allLevelTreeCountJsonArray = this.getJsonArrayData("tree2table/queryAllLevelTreeCount.xml", savedDataKeyMap);
			Map<String,Integer>  levelDataCountMap =  new HashMap<String,Integer>();
			for(int i=0;i<allLevelTreeCountJsonArray.length();i++){
				JSONObject jsonObj = allLevelTreeCountJsonArray.getJSONObject(i);
				int childrenCount = jsonObj.getInt("children_count_");
				String itemId     = jsonObj.getString("item_id_");
				levelDataCountMap.put(itemId, childrenCount);
			}
			//最大级别
			JSONArray maxLevelJsonArray = this.getJsonArrayData("tree2table/queryMaxLevel.xml", savedDataKeyMap);
			int maxLevel =0;
			//获取maxTreeLevel
			for(int i=0;i<maxLevelJsonArray.length();i++){
				JSONObject jsonObj = maxLevelJsonArray.getJSONObject(i);
				maxLevel = jsonObj.getInt("max_item_level_");
			}
			//数据明细
			JSONArray allLevelColumnDetailJsonArray = this.getJsonArrayData("tree2table/queryAllLevelColumnDetail.xml", savedDataKeyMap);
			//数据明细最大列数
			JSONArray allLevelColumnDetailMaxCountJsonArray = this.getJsonArrayData("tree2table/queryAllLevelColumnDetailMaxCount.xml", savedDataKeyMap);
			//已经保存的数值
			JSONArray valuesMappingJsonArray = this.getJsonArrayData("tree2table/queryValuesMapping.xml", savedDataKeyMap);
			
			//迭代treeTableJson
			JSONObject jsonRootObj  = null;
			Map<String,JSONObject> remainJSONObjectMap = new HashMap<String,JSONObject>();
			int currentRowIndex   = 0;
			for(int index = 0;index<allLevelTreeJsonArray.length();index++ )
			{
				JSONObject levelDataMap = allLevelTreeJsonArray.getJSONObject(index);
				JSONObject cellJsonObj  = new JSONObject();
				String  itemPid    = StringUtil.nullToString(levelDataMap.get("item_pid_"));
				String  itemId     = StringUtil.nullToString(levelDataMap.get("item_id_"));
				String  itemName   = StringUtil.nullToString(levelDataMap.get("item_name_"));
				String  itemCode   = StringUtil.nullToString(levelDataMap.get("item_code_"));
				String  itemValue  = StringUtil.nullToString(levelDataMap.get("item_value_"));
				String  itemType   = StringUtil.nullToString(levelDataMap.get("item_type_"));
				String  itemDescription   = StringUtil.nullToString(levelDataMap.get("item_description_"));
				String  itemPosition      = StringUtil.nullToString(levelDataMap.get("item_position_"));
				String  itemIsStatistic    = StringUtil.nullToString(levelDataMap.get("item_is_statistic_"));
				String  itemEnabled       = StringUtil.nullToString(levelDataMap.get("item_enabled_"));
				String  itemWidth       = StringUtil.nullToString(levelDataMap.get("item_width_"));
				String  itemHeight       = StringUtil.nullToString(levelDataMap.get("item_height_"));
				boolean isLeaf     = Boolean.parseBoolean(StringUtil.nullToString(levelDataMap.get("is_leaf_")));
				int     itemLevel  = Integer.parseInt(StringUtil.nullToString(levelDataMap.get("item_level_")));
				int     rowSpan    = levelDataCountMap.get(itemId).intValue();
				cellJsonObj.put("pid"  , itemPid);
				cellJsonObj.put("id"  , itemId);
				cellJsonObj.put("itemIsStatistic"  , itemIsStatistic);
				cellJsonObj.put("name", itemName);
				cellJsonObj.put("code", itemCode);
				cellJsonObj.put("value", itemValue);
				cellJsonObj.put("type", itemType);
				cellJsonObj.put("description", itemDescription);
				cellJsonObj.put("width", itemWidth);
				cellJsonObj.put("height", itemHeight);
				cellJsonObj.put("position", itemPosition);
				cellJsonObj.put("enabled", itemEnabled);
				cellJsonObj.put("level", itemLevel);
				cellJsonObj.put("leaf", isLeaf);
				cellJsonObj.put("rowSpan", rowSpan);
				cellJsonObj.put("colSpan",isLeaf ? (maxLevel-itemLevel+1) : 1);
				
				if(1 == itemLevel){
					cellJsonObj.put("trs", new JSONArray());
					jsonRootObj = cellJsonObj;
				}
				else{
					JSONArray  jsonArray    = jsonRootObj.getJSONArray("trs"); 
					JSONObject rowJsonObj = remainJSONObjectMap.get("tr-"+currentRowIndex);
					if(null == rowJsonObj){
						rowJsonObj = new JSONObject();
						rowJsonObj.put("tds", new JSONArray());
						jsonArray.put(rowJsonObj);
						remainJSONObjectMap.put("tr-"+currentRowIndex,rowJsonObj);
					}
					JSONArray cellsArray = rowJsonObj.getJSONArray("tds");
					cellsArray.put(cellJsonObj);
				}
				if(isLeaf){
					++currentRowIndex;
				} 
			}
			//迭代treeDataMapping
			int maxDataDetailCount = 0;
			Map<String,List<Map<String,String>>> dataDetailListMap = new HashMap<String,List<Map<String,String>>>();
			if(isLoadDictData)
			{
		         for(int i=0;i<allLevelColumnDetailJsonArray.length();i++)
		         {
		    	    JSONObject jsonObj = allLevelColumnDetailJsonArray.getJSONObject(i);
					String  itemPid    = StringUtil.nullToString(jsonObj.getString("item_pid_"));
					String  itemIsStatistic    = StringUtil.nullToString(jsonObj.getString("item_is_statistic_"));
					String  itemId     = StringUtil.nullToString(jsonObj.getString("item_id_"));
					String  itemName   = StringUtil.nullToString(jsonObj.getString("item_name_"));
					String  itemCode   = StringUtil.nullToString(jsonObj.getString("item_code_"));
					String  itemValue  = StringUtil.nullToString(jsonObj.getString("item_value_"));
					String  itemType   = StringUtil.nullToString(jsonObj.getString("item_type_"));
					String  itemWidth   = StringUtil.nullToString(jsonObj.getString("item_width_"));
					String  itemHeight   = StringUtil.nullToString(jsonObj.getString("item_height_"));
					String  itemDescription   = StringUtil.nullToString(jsonObj.getString("item_description_"));
					String  itemPosition      = StringUtil.nullToString(jsonObj.getString("item_position_"));
					String  itemEnabled       = StringUtil.nullToString(jsonObj.getString("item_enabled_"));
					Map<String,String>  dataMap = new HashMap<String,String>();
					dataMap.put("pid"  ,itemPid);
					dataMap.put("id"  , itemId);
					dataMap.put("name", itemName);
					dataMap.put("code", itemCode);
					dataMap.put("value", itemValue);
					dataMap.put("type", itemType);
					dataMap.put("description", itemDescription);
					dataMap.put("width", itemWidth);
					dataMap.put("height", itemHeight);
					dataMap.put("position", itemPosition);
					dataMap.put("itemIsStatistic", itemIsStatistic);
					dataMap.put("enabled", itemEnabled);
					List<Map<String,String>> dataDetailList = dataDetailListMap.get(itemPid);
					if(null == dataDetailList){
						dataDetailList = new ArrayList<Map<String,String>>();
						dataDetailListMap.put(itemPid, dataDetailList);
					}
					dataDetailList.add(dataMap);
			     }
		         //获取maxTreeDataCount
				 for(int i=0;i<allLevelColumnDetailMaxCountJsonArray.length();i++){
						JSONObject jsonObj = allLevelColumnDetailMaxCountJsonArray.getJSONObject(i);
						maxDataDetailCount = jsonObj.getInt("max_item_count_");
				 }
		   }
			//迭代valuesMapping
		   JSONObject valuesMappingJson = new JSONObject();
		   for(int i=0;i<valuesMappingJsonArray.length();i++){
		    	    JSONObject jsonObj = valuesMappingJsonArray.getJSONObject(i);
					String dictId          = jsonObj.getString("dict_id_");
					String columnId        = jsonObj.getString("column_id_");
					JSONArray   valuesMappingJsonColumns  = null; 
					String savedData       = jsonObj.getString("saved_data_");
					try {
						if(valuesMappingJson.has(dictId)){
							valuesMappingJsonColumns = valuesMappingJson.getJSONArray(dictId);
						}else{
							valuesMappingJsonColumns = new JSONArray(); 
							valuesMappingJson.put(dictId, valuesMappingJsonColumns);
						}
						JSONObject  valueJson = new JSONObject();
						valueJson.put("columnId" , columnId);
						valueJson.put("savedData", savedData);
					} catch (JSONException e) {
						throw new SQLException("grant value exception");
					}
		    }
			//返回结果
			ObjectMapper mapper     = new ObjectMapper();  
			treeTableJson    = jsonRootObj.toString();
			treeDataMapping  = mapper.writeValueAsString(dataDetailListMap);
			maxTreeLevel     = maxLevel;
			maxTreeDataCount = maxDataDetailCount;
			valuesMapping  = valuesMappingJson.toString();
		}

		StringBuffer returnJsonString = new StringBuffer();
		returnJsonString.append("{")
		                .append("\"treeTableJson\":"+treeTableJson)
		                .append(",")
		                .append("\"treeDataMapping\":"+treeDataMapping)
		                .append(",")
		                .append("\"maxTreeLevel\":"+maxTreeLevel)
		                .append(",")
		                .append("\"maxTreeDataCount\":"+maxTreeDataCount)
		                .append(",")
		                .append("\"valuesMapping\":"+valuesMapping)
		                .append("}");
		return returnJsonString.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String savedTree2TableData(String savedDataKey, String savedDataDetailJson,Map<String,String> savedDataKeyMap) throws Exception {
		
		Map<String,Object>  propertiesMap = new HashMap<String,Object>();
		
        for(String key : savedDataKeyMap.keySet()){
        	if(key.startsWith("savedDataKey")){
        		String value = savedDataKeyMap.get(key);
        		if(null != value){
        			propertiesMap.put(key, value);
        		}
        	}
        }
        BaseDocumentSavedInfo baseDocumentSavedInfo = (BaseDocumentSavedInfo)this.tableDao.getNewOrUpdateObject(BaseDocumentSavedInfo.class, propertiesMap);
		this.tableDao.copyAndOverrideExistedValueFromStringMap(savedDataKeyMap, baseDocumentSavedInfo, null);
        this.tableDao.saveOrUpdateEntity(baseDocumentSavedInfo);
        //this.tableDao.getHibernateTemplate().clear();
        this.tableDao.updateByHSQL("delete from BaseDocumentSavedData bdsd where bdsd.savedInfo.id= ?", baseDocumentSavedInfo.getId());
		JSONObject savedDataJsonObj = new JSONObject(savedDataDetailJson);  
		Iterator iter =  savedDataJsonObj.keys();
		//int index = 0;
		while(iter.hasNext()){
			String dictId = iter.next().toString();
			BaseDocumentConfig dict = (BaseDocumentConfig)this.tableDao.findEntityByID(BaseDocumentConfig.class, dictId);
			JSONArray savedDataJSONArray = savedDataJsonObj.getJSONArray(dictId);
			for(int i=0;i<savedDataJSONArray.length();i++){
				JSONObject data  = savedDataJSONArray.getJSONObject(i);
				String columnId  = data.getString("columnId");
				String savedData = data.getString("savedData");
				BaseDocumentSavedData baseDocumentSavedData = new BaseDocumentSavedData();
				baseDocumentSavedData.setSavedInfo(baseDocumentSavedInfo);
				baseDocumentSavedData.setDict(dict);
				baseDocumentSavedData.setSavedData(savedData);
				BaseDocumentConfigData column = (BaseDocumentConfigData)this.tableDao.findEntityByID(BaseDocumentConfigData.class, columnId);;
				baseDocumentSavedData.setColumn(column);
				this.tableDao.saveEntity(baseDocumentSavedData);
				//if((++index % 50)==0 )
				{
					this.tableDao.updateFlush();
					this.tableDao.getHibernateTemplate().evict(baseDocumentSavedData);
				}
			}
		}
		return null;
	}

	@Override
	public String getCollectionJsonString(Collection<?> collection, HashMap<String, String> mappingField) throws Exception {
		Iterator<?> it = collection.iterator();
		JSONArray collectionJsonArray = new JSONArray();
		while (it.hasNext()) {
			Object entityObject = (Object) it.next();
			Class<?> entityClass = entityObject.getClass();
			PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(entityClass);
			JSONObject jsonObject = new JSONObject();

			for (PropertyDescriptor pd : pds) {
				Method readMethod = pd.getReadMethod();
				Class<?> readMethodClass = readMethod.getReturnType();
				if (!Collection.class.isAssignableFrom(readMethodClass)) {
					Object valueObject = readMethod.invoke(entityObject);
					if (valueObject == null) {
						continue;
					}

					if (BeanFieldUtil.isWrapClass(readMethodClass)) {// 基础类型
						jsonObject.putOpt(pd.getName().toLowerCase(), valueObject);
					} else {// 引用类型
						String readMethodName = readMethodClass.getSimpleName();
						Set<String> mappingNameSet = mappingField.keySet();
						if (mappingField.get(readMethodName) == null) {// 如果匹配字段集合中不包含引用类型，则默认添加ID
							Class<?> citeClass = valueObject.getClass();

							PropertyDescriptor citePd = BeanUtils.getPropertyDescriptor(citeClass, "id");
							Method citeMethod = citePd.getReadMethod();
							Object value = citeMethod.invoke(valueObject);
							jsonObject.putOpt(pd.getName().toLowerCase(), value);
						}

						for (String valueName : mappingNameSet) {
							if (valueName.toLowerCase().startsWith(readMethodName.toLowerCase())) {
								//String perfixName = valueName;
								String suffixName = "";
								if (valueName.indexOf(".") != -1) {
									//perfixName = valueName.substring(0, valueName.indexOf("."));
									suffixName = valueName.substring(valueName.indexOf("."));
								}

								String citeFieldName = mappingField.get(valueName);// 引用类的引用字段
								if (citeFieldName != null) {
									Class<?> citeClass = valueObject.getClass();

									PropertyDescriptor citePd = BeanUtils.getPropertyDescriptor(citeClass, citeFieldName);
									Method citeMethod = citePd.getReadMethod();
									Object value = citeMethod.invoke(valueObject);

									jsonObject.putOpt(pd.getName().toLowerCase() + suffixName, value);
									
									//对数据字典的特殊处理
									if(valueName.equals("DictionaryData")){
										PropertyDescriptor namePd = BeanUtils.getPropertyDescriptor(citeClass, "name");
										Method nameMethod = namePd.getReadMethod();
										String rawValue = (String) nameMethod.invoke(valueObject);
										
										jsonObject.putOpt("rawValue_" + pd.getName().toLowerCase() + suffixName, rawValue);
										
									}
									
								}
							}
						}
					}
				} else {
					continue;
				}
			}
			if (jsonObject != null) {
				collectionJsonArray.put(jsonObject);
			}

		}
		return collectionJsonArray.toString();
	}
	/**
	 * 
	 * @param variablesMap 
	 * @param projInfo 当前合同实例
	 * @param processDefinitionId 流程实例id
	 * @throws Exception
	 */
	@Override
	public void getAttachment(Map<String, String> variablesMap, String project_id,String processDefinitionId) throws Exception{
		//将项目立项里面上传的附件带过来
		    List<Long> dbid = this.tableDao.findResultsByHSQL("select jhi.historyProcessInstanceImpl.dbid  from JBPMWorkflowHistoryInfo jhi  where  jhi.processDefinitionId=? and jhi.keyNine = ? and jhi.historyTaskInstanceImpl is  null", processDefinitionId,project_id);
		    if(!dbid.isEmpty()){
		        Long  projApproveProcessInstanceDBID = dbid.get(0);
		    	variablesMap.put("projApproveProcessInstanceDBID", projApproveProcessInstanceDBID.toString());
		    }
		
	}
}
