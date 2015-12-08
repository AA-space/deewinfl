package com.business.controller.check;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.service.check.CheckServer;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-5-21 下午3:21:31 类说明
 */
@Controller(value = "checkController")
@RequestMapping(value = "/**/leasing")
public class CheckController  extends BaseController {
	@Resource(name = "checkServer")
	private CheckServer checkService;


	@RequestMapping(value = "/equipmentManagerCheck.action")
	@ResponseBody
	public String  checkCharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String status = this.checkService.checekEquipmentManager(request, response);
		return status;
	}
	
	@RequestMapping(value = "/validateChassisnum.action")
	@ResponseBody
	public String  validateChassisnum(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String status = this.checkService.validateChassisnum(request);
		return status;
	}
	
}
