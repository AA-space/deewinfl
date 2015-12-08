package com.business.service.Insurance;

import java.util.Map;

import com.business.service.BaseService;

/**
 * 保险方式确认
 * @author Toybaby
 * 
 */
public interface InsuranceConfirmService extends BaseService {
	public void updateInsurance(Map<String,String> model) throws Exception;
	
	public void updateModifyInsurance(Map<String,String> model) throws Exception;
}
