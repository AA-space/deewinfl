package com.business.service.vouchersFactory;   

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.cust.CustInfo;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-11-27 下午1:38:07
 * 类说明
 */
public interface EbankImportService {
	public void createVoucher(FundEbankData ebankData) throws Exception;
	/**
	 * 用户变更凭证
	 * @param info 网银信息
	 * @param beforeCust 变更前的客户
	 * @throws Exception
	 */
	public void changeCust(FundEbankData ebankData, CustInfo beforeCust) throws Exception;
	
	/**
	 * 月底未结账凭证,客户是固定的，为 010001351 未确认
	 * @param ebankList 网银信息集合
	 * @throws Exception
	 */
	public void monthEnd(List<FundEbankData> ebankList) throws Exception;
	public void createRedVoucher(FundEbankData ebankData, CustInfo beforeCust)
			throws Exception;
	
	
}
  
