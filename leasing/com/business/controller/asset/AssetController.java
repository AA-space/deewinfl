package com.business.controller.asset;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.asset.FundEbankData;
import com.business.service.asset.AssetServer;

/**
 * @author Jason 2013-3-13
 */
@Controller(value = "assetController")
@RequestMapping(value = "/**/leasing")
public class AssetController extends BaseController  {
	@Resource
	private AssetServer assetServer;
	
	
	/**
	 * 查看能否核销
	 * @param ebank_id 网银id
	 * @param contract_id 合同id
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value="/canStartFlow.action")
	@ResponseBody
	public String canStartFlow(@RequestParam("ebank_id") String ebank_id, @RequestParam("contract_id") String contract_id) throws Exception{
		
		return this.assetServer.canStartFlow(contract_id, ebank_id).toString();
	}
	
	public Object findFundEbankData(@RequestParam("ebank_id") String ebank_id) throws Exception{
		return this.assetServer.findEntityById(FundEbankData.class, "ebank_id");
	}
	
	@RequestMapping(value="/calculateEbank.action")
	@ResponseBody
	public Map<String, String> calculateEbank(String ebank_id) throws Exception{
		return this.assetServer.calculateEbank(ebank_id);
	}
	
	@RequestMapping(value="/calculateFundIncome.action")
	@ResponseBody
	public Map<String, String> calculateFundIncome(HttpRequest request) throws Exception{
		
		return this.assetServer.calculateFundIncome(request);
	}
	
	
	

	public AssetServer getAssetServer() {
		return assetServer;
	}

	public void setAssetServer(AssetServer assetServer) {
		this.assetServer = assetServer;
	}

}
