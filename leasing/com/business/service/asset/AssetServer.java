package com.business.service.asset;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpRequest;

import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.BaseService;


public interface AssetServer extends BaseService {
	public Boolean canStartFlow(String contract_id, String ebank_id) throws Exception;

	public Object findEntityById(Class<?> clazz, String id) throws Exception;
	
	public Map<String, String> calculateEbank(String ebank_id) throws Exception;

	public Map<String, String> calculateFundIncome(HttpRequest request) throws Exception;
	
	public HashMap<String, String> calculatePenalty(ContractFundRentPlan cplan,String factdate) throws Exception;
	
}
