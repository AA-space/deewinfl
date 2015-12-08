package com.business.controller.check;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.service.TableService;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-5-21 下午3:21:31 类说明
 */
@Controller(value = "conditionController")
@RequestMapping(value = "/**/leasing")
public class ConditionController  extends BaseController {
	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/updateManagerCondition.action")
	@ResponseBody
	public String  updateManagerCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String contractId = request.getParameter("id");
		 String freedefainterday = request.getParameter("freedefainterday");
		 String startdate = request.getParameter("startdate");
		 
		 if (  null != contractId )
		 {
			 String sql  ="update contract_condition set free_defa_inter_day=? ,start_date_=?  where contract_id='"+contractId+"'";
			 this.tableService.updateBySql(sql,freedefainterday,startdate);
			 return "yes";
		 }
		 return "no";
	}
	 
}
