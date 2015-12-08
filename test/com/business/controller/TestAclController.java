package com.business.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.tenwa.test.BaseMVCTest;

public class TestAclController extends BaseMVCTest{
	private static Logger	log	= LoggerFactory.getLogger(TestAclController.class);
		
	@Autowired
	private AclController aclController;
	
	@Test
	public void testNull(){
		
	}
	//@Test
	public void testqueryMenu() throws Exception {
		request.setRequestURI("acl/queryMenus.acl");
		request.setMethod(HttpMethod.POST.name());
		request.setParameter("id", "402880813fa35182013fa35389a30000");
		request.setParameter("datasourcename", "1");
		request.setParameter("datasourcetype", "JDBC");
		handlerAdapter.handle(request, response, new HandlerMethod(aclController, "getMenusTreeMenu", HttpServletRequest.class,
				HttpServletResponse.class));
	}
}
