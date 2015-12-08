package com.kernal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.business.model.file.BaseFileOperation;
import com.business.model.file.FileStoreType;
import com.business.model.file.FtpFileOperationImpl;
import com.business.model.file.LocalFileOperationImpl;
import com.business.model.file.SmbFileOperationImpl;


public class ResourceUtil 
{
   public static void init(){
	   //获得tablexml文件路径
	   tablesDataSourceDirectoryPath =getWebConfigValue("tables_dataDirectory");
	   //获得chartxml文件路径
	   chartsDataSourceDirectoryPath =getWebConfigValue("charts_dataDirectory");
	   //获得chartflt文件路径
	   chartsFltSourceDirectoryPath =getWebConfigValue("charts_fltDirectory");
   };
   //private static  String  CONFIG_FILE_NAME = "framework-config.properties";
   private static  String  CONFIG_FILE_NAME = "quartz.properties";
   private static  Log log = LogFactory.getLog(ResourceUtil.class);
   private static  final Map<String,String> configMap = new HashMap<String,String>();
   public static String getConfigValue(String propertyName)
   {
		   if(0 == configMap.size())
		   {
				 FileInputStream fis = null;
				 try 
				 {
					fis = new FileInputStream(URLDecoder.decode(Thread.currentThread()
							.getContextClassLoader().getResource(CONFIG_FILE_NAME)
							.getFile(), "UTF-8"));
					Properties pro = new Properties();
					pro.load(fis);
					for(Object key : pro.keySet()){
						String valString = StringUtil.nullToString(pro.get(key)).trim();
						String keyString = StringUtil.nullToString(key).trim();
						configMap.put(keyString, valString);
						
				        if(log.isInfoEnabled())
				        {
				           log.info("###########加载配置文件属性：【"+keyString+" = "+valString+"】");
				        }
					}
				}
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} finally{
					try {
						if(null != fis){
							fis.close();
							fis = null;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		   }

	   return configMap.get(propertyName);
   }
   //获得项目部署相对路径名称
   public static String getWebConfigValue(String propertyName)
   {
	   String value = WebUtil.getWebContextRealPath()+StringUtil.nullToString(getConfigValue(propertyName)).trim();
	   return value;
   }
   //获得是否处于系统开发阶段
   private static boolean isDebug = "TRUE".equals(StringUtil.nullToString(getConfigValue("isDebug")).toUpperCase());
   public  static void setDebug(boolean isDebugModel){
	   isDebug = isDebugModel;
   }
   public static boolean isDebug()
   {
	   return isDebug;
   }
   //远程RMI主机地址
   private static String RMILocalIp = getConfigValue("RMILocalIp");
   public  static String getRMILocalIp(){
	   return RMILocalIp;
   }
   //远程RMI端口
   private static int RMILocalPort = Integer.parseInt(getConfigValue("RMILocalPort"));
   public  static int getRMILocalPort(){
	   return RMILocalPort;
   }
   //远程RMI服务名
   private static String RMILocalServiceName = getConfigValue("RMILocalServiceName");
   public  static String getRMILocalServiceName(){
	   return RMILocalServiceName;
   }
   //远程RMI集群
   private static String RMICluster = getConfigValue("RMICluster");
   public  static String getRMICluster(){
	   return RMICluster;
   }
   private static String rmiServiceName = getConfigValue("rmiServiceName");
   public  static String getRmiServiceName(){
	   return rmiServiceName;
   }
   //密码复杂度
   private static int minPasswordLength = Integer.parseInt(StringUtil.empty2Other(getConfigValue("minPasswordLength"), "6"));
   public  static int getMinPasswordLength(){
	   return minPasswordLength;
   }
   private static String passwordComplexityJSRegex = getConfigValue("passwordComplexityJSRegex");
   public  static String getMinPasswordComplexityJSRegex(){
	   return passwordComplexityJSRegex;
   }
   //获得数据库类型
   private static String DBTYPE = getConfigValue("org.quartz.dataSource.myDS.URL").toUpperCase();
   public static String getDBType()
   {
	   if(DBTYPE.indexOf("ORACLE")>-1){
		   DBTYPE = "ORACLE";
	   }
	   else if(DBTYPE.indexOf("SQLSERVER")>-1){
		   DBTYPE = "SQLSERVER";
	   }
	   else if(DBTYPE.indexOf("MYSQL")>-1){
		   DBTYPE = "MYSQL";
	   }
	   return DBTYPE;
   }
   //获得tablexml文件路径
   private static String tablesDataSourceDirectoryPath = null;
   public static String getTablesDataSourceDirectoryPath()
   {
	   return tablesDataSourceDirectoryPath;
   }
   //获得chartxml文件路径
   private static String chartsDataSourceDirectoryPath = null;
   public static String getChartsDataSourceDirectoryPath()
   {
	   return chartsDataSourceDirectoryPath;
   }
   //获得chartflt文件路径
   private static String chartsFltSourceDirectoryPath = null;
   public static String getFltSourceDirectoryPath()
   {
	   return chartsFltSourceDirectoryPath;
   }
   
   //获取菜单的装载方式
   private static String MENUTYPE = getConfigValue("MENUTYPE").toUpperCase();
   public static String getMenuType() 
   {
	  return MENUTYPE;
   }
   ////获取upload文件上传路径
   private static String fileUploadDataPath = getConfigValue("uploads_store_path");
   public static String getFileUploadDataPath()
   {
	   return fileUploadDataPath;
   }
   
   ////获取word模板相对文件上传路径
   private static String wordTemplatesRelativeStorePath = getConfigValue("word_templates_relative_store_path");
   public static String getWordTemplatesRelativeStorePath()
   {
	   return wordTemplatesRelativeStorePath;
   }
   ////获取word模板相对文件上传路径
   private static String wordSourceTemplatesRelativeStorePath = getConfigValue("word_source_templates_relative_store_path");
   public static String getWordSourceTemplatesRelativeStorePath()
   {
	   return wordSourceTemplatesRelativeStorePath;
   }
   ////获取word生成文件相对文件上传路径
   private static String wordFilesRelativeStorePath = getConfigValue("word_file_relative_store_path");
   public static String getWordFilesRelativeStorePath()
   {
	   return wordFilesRelativeStorePath;
   }
   //网银相对上传路径
   private static String ebankExcelRelativeStorePath=getConfigValue("ebank_excel_relative_store_path");
   public static String getEbankExcelRelativeStorePath()
   {
	   return ebankExcelRelativeStorePath;
   }
 //网银模板的相对上传路径
   private static String ebankExcelTemplatesRelativeStorePath=getConfigValue("ebank_excel_templates_relative_store_path");
   public static String getEbankExcelTemplatesRelativeStorePath()
   {
	   return ebankExcelTemplatesRelativeStorePath;
   }
   //（集群或者本地模式）
   private static BaseFileOperation<? extends Object> baseFileOperation = null;
   private static final String  type = getConfigValue("uploads_store_type").toUpperCase();
   private static final String  charset = getConfigValue("uploads_store_charset");
   private static final String  host = getConfigValue("uploads_store_host");
   private static final String  port_ = getConfigValue("uploads_store_port");
   private static final String  username = getConfigValue("uploads_store_username");
   private static final String  password = getConfigValue("uploads_store_password");
   private static int   port = port_.isEmpty() ?  21 : Integer.parseInt(port_);
   
   public  static BaseFileOperation<? extends Object> getFileUploadOperation()
   {
	   if(null == baseFileOperation)
	   {

		   switch(FileStoreType.valueOf(type)){
		   		case LOCAL :{
		   			baseFileOperation = new LocalFileOperationImpl();
		   			break;
		   		}
		   		case FTP :{
		   			baseFileOperation = new FtpFileOperationImpl(host,port,username,password,charset);
		   			break;
		   		}
		   		case SMB :{
		   			baseFileOperation = new SmbFileOperationImpl(host,username,password);
		   			break;
		   		}
		   }
	   }
	   return baseFileOperation;
   }
   //获取不检测的硬盘号
   private static String noCheckDiskNumbers = getConfigValue("noCheckDiskNumbers");
   public static String getNoCheckDiskNumbers()
   {
	   return noCheckDiskNumbers;
   }
   //获取公司名称
   private static String companyName = getConfigValue("companyName");
   public static String getCompanyName()
   {
	   return companyName;
   }
   //设置更新密码的时间
   private static int updatePasswordDays = Integer.parseInt(getConfigValue("updatePasswordDays"));
   public static int getUpdatePasswordDays()
   {
	   return updatePasswordDays;
   }
   private static boolean isNeedUpdatePermissionCache = false;
   public static void setNeedUpdatePermissionCache(boolean isNeed)
   {
	   isNeedUpdatePermissionCache = isNeed;
   }
   public static boolean isNeedUpdatePermissionCache()
   {
	   return isNeedUpdatePermissionCache ;
   }
   //sso
   private static String casServer = getConfigValue("sso.casServer");
   public  static String getCasServer(){
	   return casServer;
   }
   private static String localClient = getConfigValue("sso.localClient");
   public  static String getLocalClient(){
	   return localClient;
   }
}
