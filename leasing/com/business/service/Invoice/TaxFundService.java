package com.business.service.Invoice;

import java.util.Map;

import com.business.service.BaseService;

/**
 * @author 姚俊喜
 * @date 2013-10-11下午11:41:59
 * @email toybaby@tenwa.com.cn
 * @function 
 */
public interface TaxFundService extends BaseService {
	public void submitFundPlanInvoice(Map<String,String> model) throws Exception;

	public void backFundPlanInvoice(Map<String, String> model) throws Exception;

	public void submitFundChargeInvoice(Map<String, String> model) throws Exception;
	
	public void updateFundstatus(Map<String, String> model) throws Exception;

	public void removeFundChargeInvoice(Map<String, String> model) throws Exception;

	public void backFundChargeInvoice(Map<String, String> model) throws Exception;
	
	public void addTaxFundHcInfoInvoice(Map<String, String> model) throws Exception;

	

	
}
