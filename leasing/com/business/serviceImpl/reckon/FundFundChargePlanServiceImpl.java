package com.business.serviceImpl.reckon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.entity.util.OwnInfo;
import com.business.service.TableService;
import com.business.service.reckon.FundFundChargePlanService;
import com.tenwa.leasing.bean.FundFundChargePlanBean;

@Service(value = "fundFundChargePlanService")
public class FundFundChargePlanServiceImpl implements FundFundChargePlanService{
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	
	public List<FundFundChargePlanBean> createFundChargePlan(Map<String, String> conditionMap) throws Exception {
		List<FundFundChargePlanBean> ffcpList = new ArrayList<FundFundChargePlanBean>();
		/**
		 * 收款项: 手续费 保证金 管理费 留购价款 首付款 厂商返利 保险费 其他收入 租前息 期末余值 代码: FeeType1
		 * FeeType2 FeeType3 FeeType4 FeeType5 FeeType6 FeeType7 FeeType8
		 * FeeType9 FeeType12 付款项: 保证金 保险费 其它支出 设备款 代码: FeeType2 FeeType7
		 * FeeType11 FeeType10
		 */
		String[] feeTypeName = { "手续费", "保证金", "管理费", "留购价款", "首付款", "厂商返利", "保险费", "其它收入", "租前息", "期末余值", "保证金", "保险费", "其它支出", "设备款", "天行健GPS服务费", "天行健GPS服务费" };
		String[] feeTypeCode = { "FeeType1", "FeeType2", "FeeType3", "FeeType4", "FeeType5", "FeeType6", "FeeType7", "FeeType8", "FeeType9", "FeeType12", "FeeType2", "FeeType7", "FeeType11", "FeeType10", "FeeType15", "FeeType15" };
		String[] feeTypeFied = { "handlingchargemoney", "cautionmoney", "managementmoney", "nominalprice", "firstpayment", "returnamt", "insuremoney", "otherincome", "beforeinterest", "equipendvalue", "cautionmoney", "insuremoney", "otherexpenditure", "equipamt", "gpsmoney", "gpsmoney" };
		String[] feeTypeDate = { "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "enddate", "startdate", "startdate", "startdate", "startdate", "startdate" };
		String[] payTypeCode = { "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_out", "pay_type_out", "pay_type_out", "pay_type_out", "pay_type_in", "pay_type_out" };
		String[] payTypeName = { "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "付款", "付款", "付款", "付款", "收款", "付款" };
		int in = 1;
		int out = 1;
		for (int i = 0; i < feeTypeCode.length; i++) {
			String temp = conditionMap.get("framework_condition." + feeTypeFied[i]);
			if (temp != null && !temp.equals("")) {
				if (Double.parseDouble(temp) > 0) {
					FundFundChargePlanBean ffcp = new FundFundChargePlanBean();
					String contractId = ffcp.getContractId();
					if(contractId == null || contractId.isEmpty()){
						contractId = conditionMap.get("framework_condition.contractid");
					}
					if (contractId == null || contractId.isEmpty()) {
						contractId = conditionMap.get("framework_condition.projid");
					}
					if (contractId == null || contractId.isEmpty()) {
						contractId = conditionMap.get("framework_condition.custid");
					}
					
					ContractInfo ci = tableService.findEntityByID(ContractInfo.class, contractId);
					ProjInfo pi = tableService.findEntityByID(ProjInfo.class, contractId);
					CustInfo cci = tableService.findEntityByID(CustInfo.class, contractId);
					
					if (ci != null) {
						contractId = ci.getContractId();
					} else if (pi != null){
						contractId = pi.getProjId();
					} else if (cci != null){
						contractId = cci.getCustNumber();
					}
					ffcp.setContractId(contractId);
					ffcp.setPlanDate(conditionMap.get("framework_condition." + feeTypeDate[i]));
					ffcp.setPlanMoney(Double.parseDouble(temp));
					ffcp.setFeeTypeName(feeTypeName[i]);
					ffcp.setFeeType(feeTypeCode[i]);
					ffcp.setPayTypeName(payTypeName[i]);
					ffcp.setPayType(payTypeCode[i]);
					String planId = "";
					if (payTypeName[i].equals("收款")) {
						String custName = (cci==null?conditionMap.get("framework_condition.custname"):cci.getCustName());
						ffcp.setPayObj(custName);
						if (in > 9) {
							planId = "0" + in;
						} else {
							planId = "00" + in;
						}
						in++;
						planId = "I-" + ffcp.getContractId() + "-" + planId;
					} else {
						ffcp.setPayObj("融资公司");
						if (out > 9) {
							planId = "0" + out;
						} else {
							planId = "00" + out;
						}
						out++;
						planId = "O-" + ffcp.getContractId() + "-" + planId;
					}
					ffcp.setPaymentId(planId);
					ffcp.setDocId(conditionMap.get("framework_condition.docid"));
					ffcpList.add(ffcp);
				}
			}
		}
		return ffcpList;
	}
	
	
	public Map<String, Object> createFundPlan(Map<String, String> modelData, String endDate, OwnInfo ownInfo) throws Exception {
		Map<String, String> conditionMap = new HashMap<String, String>(modelData);
		conditionMap.put("framework_condition.enddate", endDate);
		List<FundFundChargePlanBean> ffcpList = new ArrayList<FundFundChargePlanBean>();
		// 获取融资工资信息
		if (ownInfo == null) {
			ownInfo = new OwnInfo();
			ownInfo.setOwnName("德银融资公司");
		}

		/**
		 * 收款项: 手续费 保证金 管理费 留购价款 首付款 厂商返利 保险费 其他收入 租前息 期末余值 代码: FeeType1
		 * FeeType2 FeeType3 FeeType4 FeeType5 FeeType6 FeeType7 FeeType8
		 * FeeType9 FeeType12 付款项: 保证金 保险费 其它支出 设备款 代码: FeeType2 FeeType7
		 * FeeType11 FeeType10
		 */
		String[] feeTypeName = { "手续费", "保证金", "管理费", "留购价款", "首付款", "厂商返利", "保险费", "其它收入", "租前息", "期末余值", "保证金", "保险费", "其它支出", "设备款", "天行健GPS服务费", "天行健GPS服务费" };
		String[] feeTypeCode = { "FeeType1", "FeeType2", "FeeType3", "FeeType4", "FeeType5", "FeeType6", "FeeType7", "FeeType8", "FeeType9", "FeeType12", "FeeType2", "FeeType7", "FeeType11", "FeeType10", "FeeType15", "FeeType15" };
		String[] feeTypeFied = { "handlingchargemoney", "cautionmoney", "managementmoney", "nominalprice", "firstpayment", "returnamt", "insuremoney", "otherincome", "beforeinterest", "equipendvalue", "cautionmoney", "insuremoney", "otherexpenditure", "equipamt", "gpsmoney", "gpsmoney" };
		String[] feeTypeDate = { "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "startdate", "enddate", "startdate", "startdate", "startdate", "startdate", "startdate" };
		String[] payTypeCode = { "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_in", "pay_type_out", "pay_type_out", "pay_type_out", "pay_type_out", "pay_type_in", "pay_type_out" };
		String[] payTypeName = { "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "收款", "付款", "付款", "付款", "付款", "收款", "付款" };
		int in = 1;
		int out = 1;
		for (int i = 0; i < feeTypeCode.length; i++) {
			String temp = conditionMap.get("framework_condition." + feeTypeFied[i]);
			if (temp != null && !temp.equals("")) {
				if (Double.parseDouble(temp) > 0) {
					FundFundChargePlanBean ffcp = new FundFundChargePlanBean();
					String contractId = ffcp.getContractId();
					if(contractId == null || contractId.isEmpty()){
						contractId = conditionMap.get("framework_condition.contractid");
					}
					if (contractId == null || contractId.isEmpty()) {
						contractId = conditionMap.get("framework_condition.projid");
					}
					if (contractId == null || contractId.isEmpty()) {
						contractId = conditionMap.get("framework_condition.custid");
					}
					
					ContractInfo ci = tableService.findEntityByID(ContractInfo.class, contractId);
					ProjInfo pi = tableService.findEntityByID(ProjInfo.class, contractId);
					CustInfo cci = tableService.findEntityByID(CustInfo.class, contractId);
					
					if (ci != null) {
						contractId = ci.getContractId();
					} else if (pi != null){
						contractId = pi.getProjId();
					} else if (cci != null){
						contractId = cci.getCustNumber();
					}
					ffcp.setContractId(contractId);
					ffcp.setPlanDate(conditionMap.get("framework_condition." + feeTypeDate[i]));
					ffcp.setPlanMoney(Double.parseDouble(temp));
					ffcp.setFeeTypeName(feeTypeName[i]);
					ffcp.setFeeType(feeTypeCode[i]);
					ffcp.setPayTypeName(payTypeName[i]);
					ffcp.setPayType(payTypeCode[i]);
					String planId = "";
					if (payTypeName[i].equals("收款")) {
						String custName = (cci==null?conditionMap.get("framework_condition.custname"):cci.getCustName());
						ffcp.setPayObj(custName);
						if (in > 9) {
							planId = "0" + in;
						} else {
							planId = "00" + in;
						}
						in++;
						planId = "I-" + ffcp.getContractId() + "-" + planId;
					} else {
						ffcp.setPayObj(ownInfo.getOwnName());
						if (out > 9) {
							planId = "0" + out;
						} else {
							planId = "00" + out;
						}
						out++;
						planId = "O-" + ffcp.getContractId() + "-" + planId;
					}
					ffcp.setPaymentId(planId);
					ffcp.setDocId(conditionMap.get("framework_condition.docid"));
					ffcpList.add(ffcp);
				}
			}
		}
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("fundchargeplan", ffcpList);
		return returnMap;
	}
}
