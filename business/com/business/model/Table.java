package com.business.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.StringUtil;

public class Table 
{
	private String showSql ;
    private String dataSourceName;
    private String sourceSql;
    private List<String> replaceKeyList = new ArrayList<String>();
    private List<String> replaceValueList = new ArrayList<String>();
    private String excelSourceSql;
    private Map<String,String> columnTypesMapping = new LinkedHashMap<String,String>();
    private List<Map<String,String>>  datas;
    private JSONArray columnsJsonArray;
    private final Map<String,String> headers = new LinkedHashMap<String,String>();
    public Map<String, String> getHeaders() {
		return headers;
	}
	private String tableXmlLoadingDirectoryFilePath;
    private String tableXmlTableFileNameOrPath;
    private Map<String,String> model;
    private int start = -1;
	private int limit = -1;
	private int totalCount = 0;
   
	public String getSourceSql() {
		return sourceSql;
	}
	public void setSourceSql(String sourceSql) {
		this.sourceSql = sourceSql;
	}
	
	public List<String> getReplaceKeyList() {
		return replaceKeyList;
	}
	public void setReplaceKeyList(List<String> replaceKeyList) {
		this.replaceKeyList = replaceKeyList;
	}
	public List<String> getReplaceValueList() {
		return replaceValueList;
	}
	public void setReplaceValueList(List<String> replaceValueList) {
		this.replaceValueList = replaceValueList;
	}
	@SuppressWarnings("unchecked")
	public String getTargetSql() 
	{
		try 
		{
			if("SQLSERVER".equalsIgnoreCase(ResourceUtil.getDBType())){
				   String noSpaceSql = this.sourceSql.toUpperCase().replaceAll("\\s", "");
				   if(!noSpaceSql.startsWith("SELECTTOP100PERCENT"))
				   {
					   this.sourceSql = "SELECT TOP 100 PERCENT "+this.sourceSql.trim().substring(6);
					   //System.out.println("$$$$$$$$$$$$$EEEE:"+this.sourceSql );
				   }
			}
			String topSql = ("SQLSERVER".equalsIgnoreCase(ResourceUtil.getDBType()))?" TOP 100 PERCENT " : ""; 
			String text    = "SELECT "+topSql+"TT_SORT_OUTER.* FROM("+this.sourceSql+")TT_SORT_OUTER /~TableRemoteSortField: ORDER BY  {TableRemoteSortField} {TableRemoteSortDir}~/";
			//兼容miniui 排序
			text+="/~sortField: ORDER BY  {sortField} {sortOrder}~/";
			Map<String,Object> returnMap = QueryUtil.getQueryStringWithSqlFilter(model, text, true);
			String targetSql = returnMap.get("transferedText").toString();
			@SuppressWarnings("rawtypes")
			List[] transferedKeyValueListArr = (List[])returnMap.get("transferedKeyValueListArr");
			this.setReplaceKeyList((List<String>)transferedKeyValueListArr[0]);
			this.setReplaceValueList((List<String>)transferedKeyValueListArr[1]);
			return targetSql;
			//return QueryUtil.getQueryString(model, "SELECT "+topSql+"TT_SORT_OUTER.* FROM("+this.sourceSql+")TT_SORT_OUTER /~TableRemoteSortField: ORDER BY  {TableRemoteSortField} {TableRemoteSortDir}~/");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	public String getExcelTargetSql() 
	{
		/*try 
		{
			return QueryUtil.getQueryString(model, this.excelSourceSql);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "";*/
		try 
		{
			Map<String,Object> returnMap = QueryUtil.getQueryStringWithSqlFilter(model, this.excelSourceSql, true);
			String targetSql = returnMap.get("transferedText").toString();
			List[] transferedKeyValueListArr = (List[])returnMap.get("transferedKeyValueListArr");
			this.setReplaceKeyList((List<String>)transferedKeyValueListArr[0]);
			this.setReplaceValueList((List<String>)transferedKeyValueListArr[1]);
			return targetSql;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	public List<Map<String,String>> getDatas() 
	{
		return datas;
	}
	public void setDatas(List<Map<String,String>> datas) 
	{
		this.datas = datas;
	}
	public void setDataSourceName(String dataSourceName) 
	{
		this.dataSourceName = dataSourceName;
	}
	public String getDataSourceName() {
		return dataSourceName;
	}
	public void setModel(Map<String,String> model) {
		this.model = model;
	}
	public Map<String,String> getModel() {
		return model;
	}
	public String getTableXmlLoadingDirectoryFilePath() {
			return tableXmlLoadingDirectoryFilePath;
	}
	public void setTableXmlLoadingDirectoryFilePath(
				String tableXmlLoadingDirectoryFilePath) {
			this.tableXmlLoadingDirectoryFilePath = tableXmlLoadingDirectoryFilePath;
	}
	public String getTableXmlTableFileNameOrPath() {
			return tableXmlTableFileNameOrPath;
	}
	public void setTableXmlTableFileNameOrPath(String tableXmlTableFileNameOrPath) {
			this.tableXmlTableFileNameOrPath = tableXmlTableFileNameOrPath;
	}
	public String getXmlTableFileFullPathWithoutFileSeparator()
	{
		return (this.tableXmlLoadingDirectoryFilePath+this.tableXmlTableFileNameOrPath).replaceAll("(\\\\)|(/)|(%5C)","").replaceAll("\\s","");
	}
    public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setExcelSourceSql(String excelSourceSql) {
		this.excelSourceSql = excelSourceSql;
	}
	public String getExcelSourceSql() {
		return excelSourceSql;
	}
	public JSONArray getTableJsonArrayData() throws Exception
	{
		JSONArray  jsonArrayData = new JSONArray();
		for(int i=0;i<this.datas.size();i++ )
		{
			JSONObject jsonObj = new JSONObject();
			for(String nameMapping : this.headers.keySet()){
				String jsonKey = StringUtil.getJsonString(nameMapping).toLowerCase();
				String jsonValue = StringUtil.getJsonString(this.datas.get(i).get(nameMapping));
				if("iconcls".equalsIgnoreCase(jsonKey))
				{
					jsonKey = "iconCls";
				}
				else if(jsonKey.startsWith("rawvalue_")){
					jsonKey = jsonKey.replace("rawvalue_","rawValue_");
				}
				
				jsonObj.put(jsonKey, jsonValue);
			}
			jsonArrayData.put(jsonObj);
		}
		return jsonArrayData;
	}
	public String getTableJsonArrayStringDatas() throws Exception
	{
		StringBuffer jsonArrayString = new StringBuffer("[");
		for(int i=0 ; i<this.datas.size(); i++ )
		{
			if(0 < i){
				jsonArrayString.append(",");
			}
			jsonArrayString.append("{");
			//JSONObject jsonObj = new JSONObject();
			int j = 0;
			for(String nameMapping : this.headers.keySet()){
				String jsonKey = StringUtil.getJsonString(nameMapping).toLowerCase();
				String jsonValue = StringUtil.getJsonString(this.datas.get(i).get(nameMapping));
				if("iconcls".equalsIgnoreCase(jsonKey))
				{
					jsonKey = "iconCls";
				}
				else if(jsonKey.startsWith("rawvalue_")){
					jsonKey = jsonKey.replace("rawvalue_","rawValue_");
				}
				if(0 < j++){
					jsonArrayString.append(",");
				}
				jsonArrayString.append("\""+jsonKey+"\":\""+jsonValue+"\"");
				//jsonObj.put(jsonKey, jsonValue);
			}
			jsonArrayString.append("}");
			//jsonArrayData.put(jsonObj);
		}
		jsonArrayString.append("]");
		return jsonArrayString.toString();
	}
	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}
	
	
	public String getShowSql() {
		return showSql;
	}
	public boolean isShowSql()
	{
		return "true".equalsIgnoreCase(this.showSql);
	}
	
	public void setColumnsJsonArray(JSONArray columnsJsonArray) throws Exception {
		headers.clear();
		for(int i=0;i<columnsJsonArray.length();i++){
			JSONObject columnObj = columnsJsonArray.getJSONObject(i);
			headers.put(columnObj.getString("mapping"), columnObj.getString("header"));
		}
		this.columnsJsonArray = columnsJsonArray;
	}
	public JSONArray getColumnsJsonArray() {
		return columnsJsonArray;
	}
	public void setColumnTypesMapping(Map<String,String> columnTypesMapping) {
		this.columnTypesMapping = columnTypesMapping;
	}
	public Map<String,String> getColumnTypesMapping() {
		return columnTypesMapping;
	}
	
}

