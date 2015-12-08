package com.business.service.Invoice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.service.BaseService;

/**
 * @author 姚俊喜
 * @date 2013-10-11下午11:41:59
 * @email toybaby@tenwa.com.cn
 * @function 
 */
public interface TaxRentService extends BaseService {
	public void submitRentCorpusOnce(Map<String, String> model) throws Exception;

	public void submitRentPlan(Map<String, String> model) throws Exception;

	void backRentPlan(Map<String, String> model) throws Exception;

	void submitRentIncome(Map<String, String> model) throws Exception;

	void backRentIncome(Map<String, String> model) throws Exception;

	void removeRentIncome(Map<String, String> model) throws Exception;
	
	public void addTaxRentHcInfoInvoice(Map<String, String> model) throws Exception;

	void submitRentPlanReceipt(Map<String, String> model)  throws Exception;

	void backRentPlanReceipt(Map<String, String> model) throws Exception;
	
	void updateRentIncomestatus(Map<String, String> model) throws Exception;

	void submitRentIncomeReceipt(Map<String, String> model) throws Exception;

	void updateRentPlanStatus(Map<String, String> model) throws Exception;
	
	void backRentIncomeReceipt(Map<String, String> model) throws Exception;
	void confirmRentIncomeReceipt(Map<String, String> model) throws Exception;
	String updateExpTaxRentInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
}
