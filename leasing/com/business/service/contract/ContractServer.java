package com.business.service.contract;   

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-9-12 下午1:46:49
 * 类说明
 */
public interface ContractServer {

	public String saveDocSend(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public String getCurrentPlanList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public String saveDocReturn(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
  
