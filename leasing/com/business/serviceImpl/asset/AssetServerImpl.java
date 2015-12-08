package com.business.serviceImpl.asset;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.cxf.tools.common.toolspec.parser.BadUsageException;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.dao.CommDao;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.exception.BusinessException;
import com.business.service.asset.AssetServer;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.kernal.utils.BeanFieldUtil;

@Service(value="assetServer")
public class AssetServerImpl extends AbstractBaseServiceImpl implements AssetServer {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return this.baseDao;
	}

	@Override
	public Boolean canStartFlow(String contract_id, String ebank_id) throws Exception {
		return this.baseDao.findResultsByHSQL("from FundEbankProcess p where p.contractId.id = ? and p.ebdataId.id = ?", new String[]{contract_id, ebank_id}).isEmpty();
	}

	@Override
	public Object findEntityById(Class<?> clazz, String id) throws Exception {
		return this.baseDao.findEntityByID(clazz, id);
	}

	@Override
	public Map<String, String> calculateEbank(String ebank_id) throws Exception {
		FundEbankData fundEbankData = (FundEbankData) this.baseDao.findEntityByID(FundEbankData.class, ebank_id);
		Set<FundEbankProcess> fundEbankProcesses = fundEbankData.getFundEbankProcesses();
		
		//计算其他流程占用的金额
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		for (FundEbankProcess fundEbankProce : fundEbankProcesses) {
			totalAmount =totalAmount.add(fundEbankProce.getProcessAmount());
		}
		
		//计算已经核销的金额
		List<BigDecimal> rentList = this.baseDao.findResultsByHSQL("SELECT rent  FROM ContractFundRentInCome WHERE ebankNumber = ?", fundEbankData);
		for (int i = 0; i < rentList.size(); i++) {
			totalAmount =totalAmount.add( rentList.get(i));
		}
		
		//将Ebank数据加上可核销金额解析成json
		BigDecimal canVerificationValue = fundEbankData.getFactMoney().subtract(totalAmount);
		Map<String, String> jsonEbank = this.baseDao.getEntityPropertiesToStringMap(fundEbankData, null, "fundEbankData");
		jsonEbank.put("fundEbankData.canVerificationMoney", canVerificationValue.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		return jsonEbank;
	}

	@Override
	public Map<String, String> calculateFundIncome(HttpRequest request) throws Exception {
		
		
		
		return null;
	}

	public HashMap<String, String> calculatePenalty(ContractFundRentPlan cplan,String factdate) throws Exception{
		HashMap<String, String> map=new HashMap<String, String>();
		
		String hsql="select getPenalty(?,?,?) as penalty from dual";
		List<Map<String, Object>> penaltylist=this.baseDao.queryListBySql(hsql,cplan.getContractId().getId(),cplan.getRentList(),factdate);
		String penalty=penaltylist.get(0).get("penalty") == null ? "0.00" : penaltylist.get(0).get("penalty").toString();
		map.put("penalty", penalty);
		System.out.println(penalty);
		
		String hsql1="select getPlanpenalty(?,?,?) as planpenalty from dual";
		List<Map<String, Object>> planpenaltylist=this.baseDao.queryListBySql(hsql1,cplan.getContractId().getId(),cplan.getRentList(),factdate);
		String planpenalty=planpenaltylist.get(0).get("planpenalty") == null ? "0.00" : planpenaltylist.get(0).get("planpenalty").toString();
		map.put("planpenalty", planpenalty);
		System.out.println("planpenalty=="+planpenalty);
		return map;
	}
	
}
