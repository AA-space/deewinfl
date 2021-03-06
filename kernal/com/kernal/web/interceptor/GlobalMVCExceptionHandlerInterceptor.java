
 /**
 * 项目名称：    系统名称
 * 包名：              com.kernal.web.interceptor
 * 文件名：         GlobalMVCExceptionHandlerInterceptor.java
 * 版本信息：    1.0.0
 * 创建日期：     2012-12-14-上午10:50:04
 * Copyright：2012XX公司-版权所有
 **/

package com.kernal.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.business.entity.SystemLog;
import com.business.entity.SystemLogResource;
import com.business.entity.User;
import com.business.entity.SystemLog.Level;
import com.business.entity.SystemLog.Type;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.LicenseUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.WebUtil;



 /**
 * 类名称：     GlobalMVCExceptionHandlerInterceptor
 * 类描述：     
 * 创建人：     tracywindy
 * 修改人：     tracywindy
 * 修改时间：2012-12-14 上午10:50:04
 * 修改备注：
 * @version 1.0.0
 **/

public class GlobalMVCExceptionHandlerInterceptor implements HandlerInterceptor 
{
	
	 public String getIpAddr(HttpServletRequest request) 
	 {  
	   String ip = request.getHeader("x-forwarded-for");  
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("Proxy-Client-IP");  
	   }  
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("WL-Proxy-Client-IP");  
       }  
	   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	      ip = request.getRemoteAddr();  
	   }  
       return ip;  
    }

	//private Log log =  LogFactory.getLog(this.getClass());
	//private final String DETAULT_ERROR_PAGE = "WEB-INF/jsps/solutions/errorPages/error.jsp";
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object source, Exception ex) throws Exception 
	{
		HandlerMethod hm = (HandlerMethod)source;
		String content   = null;
		  Map<String, String> model = null;
		  String requestType = request.getHeader("X-Requested-With");  
		  if((null != requestType)&&("XMLHttpRequest".equalsIgnoreCase(requestType)))
		  {
			  model = QueryUtil.getRequestParameterMapByAjax(request);
		  }
		  else{
			  model  = QueryUtil.getRequestParameterMapNoAjax(request);
		  }
		String remark    = hm.toString()+",参数信息："+model;
		User user    =  null;
		try{
			user = (User)SecurityUtil.getPrincipal();
		}catch(Exception e){
			return;
		}
		String currentTime = DateUtil.getSystemDateTime();
		String ipAdd          = this.getIpAddr(request);
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI().replaceAll("//+","/");
		String operateName = null;
		AntPathMatcher pathMatcher = new AntPathMatcher();
		BaseService baseService = ((BaseService)WebUtil.getApplicationContext().getBean("baseService"));
		List<SystemLogResource> systemLogResources = (List<SystemLogResource>)baseService.findEntities(SystemLogResource.class);
		for(SystemLogResource systemLogResource : systemLogResources){
			String iterUrl = StringUtil.nullToString(systemLogResource.getUrl());
			iterUrl = "/"+request.getContextPath()+"/"+iterUrl.replaceAll("//+", "/");
			if(pathMatcher.match(iterUrl, requestUri)){
				operateName = systemLogResource.getName();
				break;
			}
		}
		/*String isOccuredUserLoginBySystem  =  StringUtil.nullToString(WebUtils.getSessionAttribute(request,"isOccuredUserLoginBySystem"));
		if("true".equals(isOccuredUserLoginBySystem)){//登录日志
			String loginUserInfo = WebUtils.getSessionAttribute(request, "login_realname")+" ( "+WebUtils.getSessionAttribute(request, "login_username")+" ) ";
			content = "用户 《 "+loginUserInfo+"》 登录了管理系统";
			SystemLog systemLog = new SystemLog(); 
			systemLog.setTime(currentTime);
			systemLog.setLevel(Level.WARN);
			systemLog.setOperateUser(user);
			systemLog.setOperateName("用户登录");
			systemLog.setType(Type.SYSTEM);
			systemLog.setUrl(requestUrl);
			systemLog.setIpAdd(ipAdd);
			systemLog.setContent(content);
			systemLog.setRemark(remark);
			baseService.saveEntity(systemLog);
			WebUtils.setSessionAttribute(request, "isOccuredUserLoginBySystem", null);
		}*/
		String isOccuredOperationException = StringUtil.nullToString(request.getAttribute("isOccuredOperationException"));
		if("true".equalsIgnoreCase(isOccuredOperationException))//异常日志
		{
			String occuredOperationExceptionInfo = StringUtil.nullToString(request.getAttribute("occuredOperationExceptionInfo"));
			content  = "操作异常日志，《内容》："+occuredOperationExceptionInfo;//.replaceAll("\\s+"," ").substring(0,occuredOperationExceptionInfo.length() > 500 ? 500 : occuredOperationExceptionInfo.length()) ;
			SystemLog systemLog = new SystemLog(); 
			systemLog.setTime(currentTime);
			systemLog.setLevel(Level.ERROR);
			systemLog.setOperateUser(user);
			systemLog.setOperateName((null == operateName)?"请求异常":operateName);
			systemLog.setType(Type.ERROR);
			systemLog.setUrl(requestUrl);
			systemLog.setIpAdd(ipAdd);
			systemLog.setContent(content);
			systemLog.setRemark(remark);
			baseService.saveEntity(systemLog);
		}
		else if(null != operateName)//非异常日志
		{
			content = "业务操作成功日志";
			SystemLog systemLog = new SystemLog(); 
			systemLog.setTime(currentTime);
			systemLog.setLevel(Level.WARN);
			systemLog.setOperateUser(user);
			systemLog.setOperateName(operateName);
			systemLog.setType(Type.BUSINESS);
			systemLog.setUrl(requestUrl);
			systemLog.setIpAdd(ipAdd);
			systemLog.setContent(content);
			systemLog.setRemark(remark);
			baseService.saveEntity(systemLog);
		}
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object source, ModelAndView modelAndView) throws Exception {
		//QueryUtil.printQueryParameters(request);
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object source) throws Exception {
		QueryUtil.printQueryParameters(request);
		AntPathMatcher pathMatcher = new AntPathMatcher();
		String requestUri = request.getRequestURI().replaceAll("//+","/");
		  if( (null == request.getAttribute("licenseChecked")) && (!pathMatcher.match("/**/*license*", requestUri)) && (!pathMatcher.match("/**/*License*", requestUri))){
			  try{
			      LicenseUtil.updateUploadLicenseInfo(null, null, null, (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate"));
			  }catch(Exception e){
				  request.setAttribute("licenseChecked", true);
				  request.getRequestDispatcher("/WEB-INF/jsps/solutions/acl/licenseUpload.jsp").forward(request, response);
				  return false;
			  }
		  }
		  return true;
	}
	protected void ajaxReturn(HttpServletResponse response, String returnInfo) throws IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(returnInfo);
		out.flush();
		out.close();
	}
}
