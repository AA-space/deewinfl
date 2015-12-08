package com.business.serviceImpl.reckon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.business.entity.DictionaryData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractCashDetailHis;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailHis;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.condition.ContractConditionHis;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanHis;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanHis;
import com.business.entity.contract.reckon.fund.FundRentAdjust;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjCashDetailHis;
import com.business.entity.proj.reckon.ProjCondition;
import com.business.entity.proj.reckon.ProjConditionHis;
import com.business.entity.proj.reckon.ProjFinaCashDetail;
import com.business.entity.proj.reckon.ProjFinaCashDetailHis;
import com.business.entity.proj.reckon.ProjFinaRentPlan;
import com.business.entity.proj.reckon.ProjFinaRentPlanHis;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.entity.proj.reckon.ProjFundRentPlanHis;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.util.Tools;

@Service(value = "conditionDataToHisService")
public class ConditionDataToHisServiceImpl implements ConditionDataToHisService {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	Logger log = Logger.getLogger(ConditionDataToHisServiceImpl.class);
	
	@Override
	public void saveProjConditionDataToHis(String projId, String docId,
			String hisType, Map<String, String> datas, String conditioinKey,
			String rentPlanKey, String finaPlanKey, String rentCashKey,
			String finaCashKey) throws Exception {
		ProjInfo projInfo = (ProjInfo)this.baseService.findEntityByID(ProjInfo.class, projId);
		//先设定入历史表的类型
		Map<String, Object> whereMap=new HashMap<String, Object>();
		DictionaryData hisBefore=new DictionaryData();
		DictionaryData hisAfter=new DictionaryData();
		DictionaryData hisTypeDict=new DictionaryData();
		whereMap.put("code", "his_status_before");
		hisBefore=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", "his_status_after");
		hisAfter=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", hisType);
		hisTypeDict=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		//商务条件
		ProjCondition pCondition=projInfo.getProjCondition();
	    ProjConditionHis pConditionHis=new ProjConditionHis();
		BeanUtils.copyProperties(pCondition, pConditionHis);
		//pConditionHis=(ProjConditionHis)this.baseService.copyAndOverrideExistedValueFromObject(pCondition, pConditionHis);
		pConditionHis.setModStatus(hisBefore);
		pConditionHis.setModReason(hisTypeDict);
		pConditionHis.setId(null);
		pConditionHis.setDocId(docId);
		this.baseService.saveEntity(pConditionHis);
		//合同租金计划
		Set<ProjFundRentPlan> fundRentPlans=projInfo.getProjFundRentPlans();
		List<ProjFundRentPlanHis> fundRentPlanHiss=new ArrayList<ProjFundRentPlanHis>();
		for (ProjFundRentPlan projFundRentPlan : fundRentPlans) {
			ProjFundRentPlanHis fundRentPlanHis=new ProjFundRentPlanHis();
			BeanUtils.copyProperties(projFundRentPlan, fundRentPlanHis);
			fundRentPlanHis.setModStatus(hisBefore);
			fundRentPlanHis.setModReason(hisTypeDict);
			fundRentPlanHis.setId(null);
			fundRentPlanHis.setDocId(docId);
			fundRentPlanHiss.add(fundRentPlanHis);
		}
		this.baseService.saveAllEntities(fundRentPlanHiss);
		//会计租金计划
		Set<ProjFinaRentPlan> finaRentPlans=projInfo.getProjFinaRentPlans();
		List<ProjFinaRentPlanHis> finaRentPlanHiss=new ArrayList<ProjFinaRentPlanHis>();
		for (ProjFinaRentPlan projFinaRentPlan : finaRentPlans) {
			ProjFinaRentPlanHis finaRentPlanHis=new ProjFinaRentPlanHis();
			BeanUtils.copyProperties(projFinaRentPlan, finaRentPlanHis);
			finaRentPlanHis.setModStatus(hisBefore);
			finaRentPlanHis.setModReason(hisTypeDict);
			finaRentPlanHis.setId(null);
			finaRentPlanHis.setDocId(docId);
			finaRentPlanHiss.add(finaRentPlanHis);
		}
		this.baseService.saveAllEntities(finaRentPlanHiss);
		//合同现金流
		Set<ProjCashDetail> fundCashDetails=projInfo.getProjCashDetails();
		List<ProjCashDetailHis> fundCashDetailHiss=new ArrayList<ProjCashDetailHis>();
		for (ProjCashDetail projCashDetail : fundCashDetails) {
			ProjCashDetailHis fundCashDetailHis=new ProjCashDetailHis();
			BeanUtils.copyProperties(projCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisBefore);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		//会计现金流
		Set<ProjFinaCashDetail> finaCashDetails=projInfo.getProjFinaCashDetails();
		List<ProjFinaCashDetailHis> finaCashDetailHiss=new ArrayList<ProjFinaCashDetailHis>();
		for (ProjFinaCashDetail projFundCashDetail : finaCashDetails) {
			ProjFinaCashDetailHis finaCashDetailHis=new ProjFinaCashDetailHis();
			BeanUtils.copyProperties(projFundCashDetail, finaCashDetailHis);
			finaCashDetailHis.setModStatus(hisBefore);
			finaCashDetailHis.setModReason(hisTypeDict);
			finaCashDetailHis.setId(null);
			finaCashDetailHis.setDocId(docId);
			finaCashDetailHiss.add(finaCashDetailHis);
		}
		this.baseService.saveAllEntities(finaCashDetailHiss);
		//删除正式表
		this.baseService.removeAllEntites(projInfo.getProjFundRentPlans());
		this.baseService.removeAllEntites(projInfo.getProjFinaRentPlans());
		this.baseService.removeAllEntites(projInfo.getProjCashDetails());
		this.baseService.removeAllEntites(projInfo.getProjFinaCashDetails());
		projInfo=(ProjInfo)this.baseService.findEntityByID(ProjInfo.class, projId);
		//再入正式表
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		ProjCondition projCondition=(ProjCondition)this.baseService.findEntityByID(ProjCondition.class, projInfo.getProjCondition().getId());
		this.baseService.copyAndOverrideExistedValueFromStringMap(datas, projCondition, dictDataClassMapping);
		this.baseService.removeEntity(projInfo.getProjCondition());
		this.baseService.saveOrUpdateEntity(projCondition);
		
		// 2.2合同租金计划
		String json_fund_rent_plan_str = datas.get(rentPlanKey);
		JSONArray jsonArray = new JSONArray(json_fund_rent_plan_str);
		JSONArray newjsonArray = new JSONArray();
		List<String> jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(projInfo, "projFundRentPlans", ProjFundRentPlan.class, "projId", jsonFundList.toString(),null);
		// 2.3合同现金流
		String json_fund_cash_flow_str = datas.get(rentCashKey);
		jsonArray = new JSONArray(json_fund_cash_flow_str);
	    newjsonArray = new JSONArray();
	    jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		
		this.baseService.updateOneToManyCollections(projInfo, "projCashDetails", ProjCashDetail.class, "projId", jsonFundList.toString(),null);
		// 2.4会计租金计划
		String json_finance_rent_plan_str = datas.get(finaPlanKey);
		jsonArray = new JSONArray(json_finance_rent_plan_str);
	    newjsonArray = new JSONArray();
	    jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(projInfo, "projFinaRentPlans", ProjFinaRentPlan.class, "projId", jsonFundList.toString(),null);
		// 2.5会计现金流
		String json_finance_cash_flow_str = datas.get(finaCashKey);
	 
		jsonArray = new JSONArray(json_finance_cash_flow_str);
	    newjsonArray = new JSONArray();
	    jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(projInfo, "projFinaCashDetails", ProjFinaCashDetail.class, "projId", jsonFundList.toString(),null);
		//再入历史表
		projInfo = (ProjInfo)this.baseService.findEntityByID(ProjInfo.class, projId);
		//商务条件
		pCondition=projInfo.getProjCondition();
		pConditionHis=new ProjConditionHis();
		BeanUtils.copyProperties(pCondition, pConditionHis);
		pConditionHis.setModStatus(hisAfter);
		pConditionHis.setModReason(hisTypeDict);
		pConditionHis.setId(null);
		pConditionHis.setDocId(docId);
		this.baseService.saveEntity(pConditionHis);
		//合同租金计划
		fundRentPlans=projInfo.getProjFundRentPlans();
		fundRentPlanHiss=new ArrayList<ProjFundRentPlanHis>();
		for (ProjFundRentPlan projFundRentPlan : fundRentPlans) {
			ProjFundRentPlanHis fundRentPlanHis=new ProjFundRentPlanHis();
			BeanUtils.copyProperties(projFundRentPlan, fundRentPlanHis);
			fundRentPlanHis.setModStatus(hisAfter);
			fundRentPlanHis.setModReason(hisTypeDict);
			fundRentPlanHis.setId(null);
			fundRentPlanHis.setDocId(docId);
			fundRentPlanHiss.add(fundRentPlanHis);
		}
		this.baseService.saveAllEntities(fundRentPlanHiss);
		//会计租金计划
		finaRentPlans=projInfo.getProjFinaRentPlans();
		finaRentPlanHiss=new ArrayList<ProjFinaRentPlanHis>();
		for (ProjFinaRentPlan projFinaRentPlan : finaRentPlans) {
			ProjFinaRentPlanHis finaRentPlanHis=new ProjFinaRentPlanHis();
			BeanUtils.copyProperties(projFinaRentPlan, finaRentPlanHis);
			finaRentPlanHis.setModStatus(hisAfter);
			finaRentPlanHis.setModReason(hisTypeDict);
			finaRentPlanHis.setId(null);
			finaRentPlanHis.setDocId(docId);
			finaRentPlanHiss.add(finaRentPlanHis);
		}
		this.baseService.saveAllEntities(finaRentPlanHiss);
		//合同现金流
		fundCashDetails=projInfo.getProjCashDetails();
		fundCashDetailHiss=new ArrayList<ProjCashDetailHis>();
		for (ProjCashDetail projCashDetail : fundCashDetails) {
			ProjCashDetailHis fundCashDetailHis=new ProjCashDetailHis();
			BeanUtils.copyProperties(projCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisAfter);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		//会计现金流
		finaCashDetails=projInfo.getProjFinaCashDetails();
		finaCashDetailHiss=new ArrayList<ProjFinaCashDetailHis>();
		for (ProjFinaCashDetail projFundCashDetail : finaCashDetails) {
			ProjFinaCashDetailHis finaCashDetailHis=new ProjFinaCashDetailHis();
			BeanUtils.copyProperties(projFundCashDetail, finaCashDetailHis);
			finaCashDetailHis.setModStatus(hisAfter);
			finaCashDetailHis.setModReason(hisTypeDict);
			finaCashDetailHis.setId(null);
			finaCashDetailHis.setDocId(docId);
			finaCashDetailHiss.add(finaCashDetailHis);
		}
		   
		this.baseService.saveAllEntities(finaCashDetailHiss);
		//this.baseService.saveEntity(projInfo);
	}
        
	@Override
	public void saveContractConditionDataToHis(String contractId, String docId,
			String hisType, Map<String, String> datas, String conditioinKey,
			String rentPlanKey, String finaPlanKey, String rentCashKey,
			String finaCashKey) throws Exception {
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);
		//------------start[增加判断参数  contract_info  bussiness_type_equip  设备的 需要ContractFinaCashDetail 和ContractFinaRentPlan 表的his 表操作]
		String bussinessTypeEquip = "";
		if(contractInfo!=null){
			bussinessTypeEquip = contractInfo.getBusinessType().getCode();
		}
		//------------end[增加判断参数  contract_info  bussiness_type_equip  设备的 需要ContractFinaCashDetail 和ContractFinaRentPlan 表的his 表操作]
		//先设定入历史表的类型
		Map<String, Object> whereMap=new HashMap<String, Object>();
		DictionaryData hisBefore=new DictionaryData();
		DictionaryData hisAfter=new DictionaryData();
		DictionaryData hisTypeDict=new DictionaryData();
		whereMap.put("code", "his_status_before");
		hisBefore=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", "his_status_after");
		hisAfter=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", hisType);
		hisTypeDict=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		//商务条件
		ContractCondition cCondition=contractInfo.getContractCondition();
		ContractConditionHis cConditionHis=new ContractConditionHis();
		BeanUtils.copyProperties(cCondition, cConditionHis);
		cConditionHis.setModStatus(hisBefore);
		cConditionHis.setModReason(hisTypeDict);
		cConditionHis.setId(null);
		cConditionHis.setDocId(docId);
		this.baseService.saveEntity(cConditionHis);
		//合同租金计划
		Set<ContractFundRentPlan> fundRentPlans=contractInfo.getContractFundRentPlans();
		List<ContractFundRentPlanHis> fundRentPlanHiss=new ArrayList<ContractFundRentPlanHis>();
		for (ContractFundRentPlan contractFundRentPlan : fundRentPlans) {
			ContractFundRentPlanHis fundRentPlanHis=new ContractFundRentPlanHis();
			BeanUtils.copyProperties(contractFundRentPlan, fundRentPlanHis);
			fundRentPlanHis.setModStatus(hisBefore);
			fundRentPlanHis.setModReason(hisTypeDict);
			fundRentPlanHis.setId(null);
			fundRentPlanHis.setDocId(docId);
			fundRentPlanHiss.add(fundRentPlanHis);
		}
		
		this.baseService.saveAllEntities(fundRentPlanHiss);
		//判断如果是租赁物是设备的话 保存数据到 租金计划表 ，因为车辆没有这张表
		if("bussiness_type_equip".equals(bussinessTypeEquip)){
			//会计租金计划
			Set<ContractFinaRentPlan> finaRentPlans=contractInfo.getContractFinaRentPlans();
			List<ContractFinaRentPlanHis> finaRentPlanHiss=new ArrayList<ContractFinaRentPlanHis>();
			for (ContractFinaRentPlan contractFinaRentPlan : finaRentPlans) {
				ContractFinaRentPlanHis finaRentPlanHis=new ContractFinaRentPlanHis();
				BeanUtils.copyProperties(contractFinaRentPlan, finaRentPlanHis);
				finaRentPlanHis.setModStatus(hisBefore);
				finaRentPlanHis.setModReason(hisTypeDict);
				finaRentPlanHis.setId(null);
				finaRentPlanHis.setDocId(docId);
				finaRentPlanHiss.add(finaRentPlanHis);
			}
			this.baseService.saveAllEntities(finaRentPlanHiss);
		}
		
		//合同现金流
		Set<ContractCashDetail> fundCashDetails=contractInfo.getContractCashDetails();
		List<ContractCashDetailHis> fundCashDetailHiss=new ArrayList<ContractCashDetailHis>();
		for (ContractCashDetail contractCashDetail : fundCashDetails) {
			ContractCashDetailHis fundCashDetailHis=new ContractCashDetailHis();
			BeanUtils.copyProperties(contractCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisBefore);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		
		//判断如果是租赁物是设备的话 保存数据到 会计现金流表 ，因为车辆没有这张表
		if("bussiness_type_equip".equals(bussinessTypeEquip)){
			//会计现金流
			Set<ContractFinaCashDetail> finaCashDetails=contractInfo.getContractFinaCashDetails();
			List<ContractFinaCashDetailHis> finaCashDetailHiss=new ArrayList<ContractFinaCashDetailHis>();
			for (ContractFinaCashDetail contractFundCashDetail : finaCashDetails) {
				ContractFinaCashDetailHis finaCashDetailHis=new ContractFinaCashDetailHis();
				BeanUtils.copyProperties(contractFundCashDetail, finaCashDetailHis);
				finaCashDetailHis.setModStatus(hisBefore);
				finaCashDetailHis.setModReason(hisTypeDict);
				finaCashDetailHis.setId(null);
				finaCashDetailHis.setDocId(docId);
				finaCashDetailHiss.add(finaCashDetailHis);
			}
			this.baseService.saveAllEntities(finaCashDetailHiss);
		}
		/*删除正式表 有主外键不能移除
		this.baseService.removeAllEntites(contractInfo.getContractFundRentPlans());
		this.baseService.removeAllEntites(contractInfo.getContractFinaRentPlans());
		this.baseService.removeAllEntites(contractInfo.getContractFinaCashDetails());*/
		this.baseService.removeAllEntites(contractInfo.getContractCashDetails());
	   contractInfo.setContractCashDetails(new HashSet<ContractCashDetail>());
	   
		//再入正式表
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		ContractCondition contractCondition=(ContractCondition)this.baseService.findEntityByID(ContractCondition.class, contractInfo.getContractCondition().getId());
		this.baseService.copyAndOverrideExistedValueFromStringMap(datas, contractCondition, dictDataClassMapping,conditioinKey);
		contractCondition.setContractId(contractInfo);
		this.baseService.saveOrUpdateEntity(contractCondition);
		
		// 2.2合同租金计划
		System.out.println("datas:"+datas);
		System.out.println("rentPlanKey:"+rentPlanKey);
		String json_fund_rent_plan_str = datas.get(rentPlanKey);
		System.out.println("json_fund_rent_plan_str:"+json_fund_rent_plan_str);
		//load 原租金计划替换现在的ID
		/**
		 * 1.把json中的数据转成 jsonmap1  key 是 id  jsonmap2 key 是 rentlist
		 * 2.把数据库中的数据转成 dbmap1 key 是 id dbmap2 key是 rentlist
		 * 按照 jsonmap2和 dbmap2的关系构建新的newmap 用dbmap中key存jsonmap1中的value[原id和新数据的map]
		 * 3.更新income中的引用按照rentlist
		 */
		Map<String, ContractFundRentPlan> jsonmap1=new LinkedHashMap<String, ContractFundRentPlan>();
		Map<String, ContractFundRentPlan> jsonmap2=new LinkedHashMap<String, ContractFundRentPlan>();
		Map<String, ContractFundRentPlan> dbmap1=new LinkedHashMap<String, ContractFundRentPlan>();
		Map<String, ContractFundRentPlan> dbmap2=new LinkedHashMap<String, ContractFundRentPlan>();
		Map<String, ContractFundRentPlan> newmap=new LinkedHashMap<String, ContractFundRentPlan>();
		List<ContractFundRentPlan> newList=new ArrayList<ContractFundRentPlan>();
		List<ContractFundRentPlan> removeList=new ArrayList<ContractFundRentPlan>();
		List<ContractFundRentPlan> listRentPlanData=new ArrayList<ContractFundRentPlan>(contractInfo.getContractFundRentPlans());
		for (ContractFundRentPlan contractFundRentPlan : listRentPlanData) {
			dbmap1.put(contractFundRentPlan.getId(), contractFundRentPlan);
			dbmap2.put(contractFundRentPlan.getRentList().toString(), contractFundRentPlan);
		}
		ObjectMapper jsonMapper = new ObjectMapper();
		Map[] newSetMaps = jsonMapper.readValue(json_fund_rent_plan_str, Map[].class);
		for (int j = 0; j < newSetMaps.length; j++) {//构建出json中的map对象
			System.out.println("j:"+j);
			String key=newSetMaps[j].get("id").toString();
			String rentlist=newSetMaps[j].get("rentlist").toString();
			ContractFundRentPlan contractFundRentPlan=new ContractFundRentPlan();
			if(dbmap2.containsKey(rentlist)){
				contractFundRentPlan=dbmap2.get(rentlist);
				newSetMaps[j].remove("id");
				newSetMaps[j].remove("contractid");
				newSetMaps[j].remove("quotid");
				newSetMaps[j].remove("quotid1");
			}
			this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[j], contractFundRentPlan, null);
			jsonmap1.put(key, contractFundRentPlan);
			jsonmap2.put(newSetMaps[j].get("rentlist").toString(), contractFundRentPlan);
			if(dbmap2.containsKey(rentlist)){
				newmap.put(contractFundRentPlan.getId(), contractFundRentPlan);
			}else{
				newmap.put(key, contractFundRentPlan);
			}
			newList.add(contractFundRentPlan);
		}
		//保存 newmap
		this.baseService.saveOrUpdateAllEntities(newList);
		
		//更新income
		Set<String> dbmap1set=dbmap1.keySet();
		for (String id : dbmap1set) {
			if(!newmap.containsKey(id)){
				Set<ContractFundRentInCome> incomSet=dbmap1.get(id).getContractFundRentInComes();
				List<ContractFundRentInCome> incomeList=new ArrayList<ContractFundRentInCome>();
				for (ContractFundRentInCome income : incomSet) {
					Integer rentList=income.getPlanList();
					while(!jsonmap2.containsKey(rentList.toString())){
						rentList=rentList-1;
					}
					income.setPlanId(jsonmap2.get(rentList.toString()));
					income.setPlanList(rentList);
					incomeList.add(income);
				}
				if(incomeList.size()>0){
					this.baseService.updateAllEntities(incomeList);
					this.baseService.removeEntity(dbmap1.get(id));
				}
				removeList.add(dbmap1.get(id));
			}
		}
		this.baseService.removeAllEntites(removeList);
		
		/*Map<String, ContractFundRentPlan> mapRentPlanJsonData=new LinkedHashMap<String, ContractFundRentPlan>();
		List<ContractFundRentPlan> listRentPlanData=new ArrayList<ContractFundRentPlan>(contractInfo.getContractFundRentPlans());
		ObjectMapper jsonMapper = new ObjectMapper();
		Map[] newSetMaps = jsonMapper.readValue(json_fund_rent_plan_str, Map[].class);
		for (int j = 0; j < newSetMaps.length; j++) {//构建出json中的map对象
			String key=newSetMaps[j].get("id").toString();
			ContractFundRentPlan contractFundRentPlan=new ContractFundRentPlan();
			if(StringUtil.nullToString(key).isEmpty()){
				key=UUIDUtil.getUUID();
				contractFundRentPlan.setId(key);
			}
			this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[j], contractFundRentPlan, null);
			mapRentPlanJsonData.put(key, contractFundRentPlan);
		}
		this.baseService.updateOneToManyCollections(contractInfo, "contractFundRentPlans", ContractFundRentPlan.class, "contractId", json_fund_rent_plan_str,null);*/
		// 2.3合同现金流
		String json_fund_cash_flow_str = datas.get(rentCashKey);
		JSONArray jsonArray = new JSONArray(json_fund_cash_flow_str);
		List<String> jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", jsonFundList.toString(),null);
		// 2.4会计租金计划
		/*String json_finance_rent_plan_str = datas.get(finaPlanKey);
		jsonArray = new JSONArray(json_finance_rent_plan_str);
		newjsonArray = new JSONArray();
		jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(contractInfo, "contractFinaRentPlans", ContractFinaRentPlan.class, "contractId", jsonFundList.toString(),null);*/
		// 2.5会计现金流
		/*String json_finance_cash_flow_str = datas.get(finaCashKey);
		jsonArray = new JSONArray(json_finance_cash_flow_str);
		newjsonArray = new JSONArray();
		jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(contractInfo, "contractFinaCashDetails", ContractFinaCashDetail.class, "contractId", jsonFundList.toString(),null);*/
		//再入历史表
		contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);//再查一次更新数据
		//商务条件
		cCondition=contractInfo.getContractCondition();
		cConditionHis=new ContractConditionHis();
		BeanUtils.copyProperties(cCondition, cConditionHis);
		cConditionHis.setModStatus(hisAfter);
		cConditionHis.setModReason(hisTypeDict);
		cConditionHis.setId(null);
		cConditionHis.setDocId(docId);
		this.baseService.saveEntity(cConditionHis);
		//合同租金计划
		fundRentPlans=contractInfo.getContractFundRentPlans();
		fundRentPlanHiss=new ArrayList<ContractFundRentPlanHis>();
		for (ContractFundRentPlan contractFundRentPlan : fundRentPlans) {
			ContractFundRentPlanHis fundRentPlanHis=new ContractFundRentPlanHis();
			BeanUtils.copyProperties(contractFundRentPlan, fundRentPlanHis);
			fundRentPlanHis.setModStatus(hisAfter);
			fundRentPlanHis.setModReason(hisTypeDict);
			fundRentPlanHis.setId(null);
			fundRentPlanHis.setDocId(docId);
			fundRentPlanHiss.add(fundRentPlanHis);
		}
		this.baseService.saveAllEntities(fundRentPlanHiss);
		/*会计租金计划
		finaRentPlans=contractInfo.getContractFinaRentPlans();
		finaRentPlanHiss=new ArrayList<ContractFinaRentPlanHis>();
		for (ContractFinaRentPlan contractFinaRentPlan : finaRentPlans) {
			ContractFinaRentPlanHis finaRentPlanHis=new ContractFinaRentPlanHis();
			BeanUtils.copyProperties(contractFinaRentPlan, finaRentPlanHis);
			finaRentPlanHis.setModStatus(hisAfter);
			finaRentPlanHis.setModReason(hisTypeDict);
			finaRentPlanHis.setId(null);
			finaRentPlanHis.setDocId(docId);
			finaRentPlanHiss.add(finaRentPlanHis);
		}
		this.baseService.saveAllEntities(finaRentPlanHiss);*/
		//合同现金流
		fundCashDetails=contractInfo.getContractCashDetails();
		fundCashDetailHiss=new ArrayList<ContractCashDetailHis>();
		for (ContractCashDetail contractCashDetail : fundCashDetails) {
			ContractCashDetailHis fundCashDetailHis=new ContractCashDetailHis();
			BeanUtils.copyProperties(contractCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisAfter);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		/*会计现金流
		finaCashDetails=contractInfo.getContractFinaCashDetails();
		finaCashDetailHiss=new ArrayList<ContractFinaCashDetailHis>();
		for (ContractFinaCashDetail contractFundCashDetail : finaCashDetails) {
			ContractFinaCashDetailHis finaCashDetailHis=new ContractFinaCashDetailHis();
			BeanUtils.copyProperties(contractFundCashDetail, finaCashDetailHis);
			finaCashDetailHis.setModStatus(hisAfter);
			finaCashDetailHis.setModReason(hisTypeDict);
			finaCashDetailHis.setId(null);
			finaCashDetailHis.setDocId(docId);
			finaCashDetailHiss.add(finaCashDetailHis);
		}
		this.baseService.saveEntity(contractInfo);*/
		
		
		
	}
	
	
	
	public void saveDataToPlanBySQL(String contractId, String docId,
			String hisType, Map<String, String> datas, String conditioinKey,
			String rentPlanKey, String finaPlanKey, String rentCashKey,
			String finaCashKey,FundRentAdjust adjustInfo) throws Exception {
		
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);
		//------------start[增加判断参数  contract_info  bussiness_type_equip  设备的 需要ContractFinaCashDetail 和ContractFinaRentPlan 表的his 表操作]
		String bussinessTypeEquip = "";
		if(contractInfo!=null){
			bussinessTypeEquip = contractInfo.getBusinessType().getCode();
		}
		//------------end[增加判断参数  contract_info  bussiness_type_equip  设备的 需要ContractFinaCashDetail 和ContractFinaRentPlan 表的his 表操作]
		
		//先设定入历史表的类型
		Map<String, Object> whereMap=new HashMap<String, Object>();
		DictionaryData hisBefore=new DictionaryData();
		DictionaryData hisAfter=new DictionaryData();
		DictionaryData hisTypeDict=new DictionaryData();
		whereMap.put("code", "his_status_before");
		hisBefore=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", "his_status_after");
		hisAfter=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", hisType);
		hisTypeDict=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		
		//商务条件正式表数据入HIS表
		ContractCondition cCondition=contractInfo.getContractCondition();
		ContractConditionHis cConditionHis=new ContractConditionHis();
		BeanUtils.copyProperties(cCondition, cConditionHis);
		cConditionHis.setModStatus(hisBefore);
		cConditionHis.setModReason(hisTypeDict);
		cConditionHis.setId(null);
		cConditionHis.setDocId(docId);
		this.baseService.saveEntity(cConditionHis);
		
		//合同租金计划HIS表移动数据前先删除
		String delSql = this.getDelHisSql(docId,"his_status_before",hisType);
		log.info("移动数据前，租金正式表的租金计划移往HIS表前删除:"+delSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(delSql);
		
		//合同租金计划变更前数据记录HIS
		String sql = this.getHisSql(docId, "his_status_before","contract_fund_rent_plan");
		log.info("移动数据前，租金正式表的租金计划移往HIS表作为前数据:"+sql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(sql.toString());
		
		
		//判断如果是租赁物是设备的话 保存数据到 租金计划表 ，因为车辆没有这张表
		if("bussiness_type_equip".equals(bussinessTypeEquip)){
			//会计租金计划
			Set<ContractFinaRentPlan> finaRentPlans = contractInfo.getContractFinaRentPlans();
			List<ContractFinaRentPlanHis> finaRentPlanHiss=new ArrayList<ContractFinaRentPlanHis>();
			for (ContractFinaRentPlan contractFinaRentPlan : finaRentPlans) {
				ContractFinaRentPlanHis finaRentPlanHis=new ContractFinaRentPlanHis();
				BeanUtils.copyProperties(contractFinaRentPlan, finaRentPlanHis);
				finaRentPlanHis.setModStatus(hisBefore);
				finaRentPlanHis.setModReason(hisTypeDict);
				finaRentPlanHis.setId(null);
				finaRentPlanHis.setDocId(docId);
				finaRentPlanHiss.add(finaRentPlanHis);
			}
			this.baseService.saveAllEntities(finaRentPlanHiss);
		}
		
		
		//合同现金流
		Set<ContractCashDetail> fundCashDetails = contractInfo.getContractCashDetails();
		List<ContractCashDetailHis> fundCashDetailHiss = new ArrayList<ContractCashDetailHis>();
		for (ContractCashDetail contractCashDetail : fundCashDetails) {
			ContractCashDetailHis fundCashDetailHis=new ContractCashDetailHis();
			BeanUtils.copyProperties(contractCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisBefore);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		
		
		//判断如果是租赁物是设备的话 保存数据到 会计现金流表 ，因为车辆没有这张表
		if("bussiness_type_equip".equals(bussinessTypeEquip)){
			//会计现金流
			Set<ContractFinaCashDetail> finaCashDetails=contractInfo.getContractFinaCashDetails();
			List<ContractFinaCashDetailHis> finaCashDetailHiss=new ArrayList<ContractFinaCashDetailHis>();
			for (ContractFinaCashDetail contractFundCashDetail : finaCashDetails) {
				ContractFinaCashDetailHis finaCashDetailHis=new ContractFinaCashDetailHis();
				BeanUtils.copyProperties(contractFundCashDetail, finaCashDetailHis);
				finaCashDetailHis.setModStatus(hisBefore);
				finaCashDetailHis.setModReason(hisTypeDict);
				finaCashDetailHis.setId(null);
				finaCashDetailHis.setDocId(docId);
				finaCashDetailHiss.add(finaCashDetailHis);
			}
			this.baseService.saveAllEntities(finaCashDetailHiss);
		}
		this.baseService.removeAllEntites(contractInfo.getContractCashDetails());
		contractInfo.setContractCashDetails(new HashSet<ContractCashDetail>());
		
		
		//再入正式表
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		ContractCondition contractCondition=(ContractCondition)this.baseService.findEntityByID(ContractCondition.class, contractInfo.getContractCondition().getId());
		this.baseService.copyAndOverrideExistedValueFromStringMap(datas, contractCondition, dictDataClassMapping,conditioinKey);
		contractCondition.setContractId(contractInfo);
		this.baseService.saveOrUpdateEntity(contractCondition);
		
		
		// 合同租金计划
		String json_fund_rent_plan_str = datas.get(rentPlanKey);
		//load 原租金计划替换现在的ID
		/**
		 * 1.把json中的数据转成 jsonmap1  key 是 id  jsonmap2 key 是 rentlist
		 * 2.把数据库中的数据转成 dbmap1 key 是 id dbmap2 key是 rentlist
		 * 按照 jsonmap2和 dbmap2的关系构建新的newmap 用dbmap中key存jsonmap1中的value[原id和新数据的map]
		 * 3.更新income中的引用按照rentlist
		 */
		Map<String, ContractFundRentPlan> jsonmap1=new LinkedHashMap<String, ContractFundRentPlan>();//旧
		Map<String, ContractFundRentPlan> jsonmap2=new LinkedHashMap<String, ContractFundRentPlan>();//新
		Map<String, ContractFundRentPlan> dbmap1=new LinkedHashMap<String, ContractFundRentPlan>();//旧
		Map<String, ContractFundRentPlan> dbmap2=new LinkedHashMap<String, ContractFundRentPlan>();
		Map<String, ContractFundRentPlan> newmap=new LinkedHashMap<String, ContractFundRentPlan>();//新
		List<ContractFundRentPlan> newList=new ArrayList<ContractFundRentPlan>();
		List<ContractFundRentPlan> removeList=new ArrayList<ContractFundRentPlan>();
		List<ContractFundRentPlan> listRentPlanData=new ArrayList<ContractFundRentPlan>(contractInfo.getContractFundRentPlans());//正式表租金计划
		for (ContractFundRentPlan contractFundRentPlan : listRentPlanData) {
			dbmap1.put(contractFundRentPlan.getId(), contractFundRentPlan);
			dbmap2.put(contractFundRentPlan.getRentList().toString(), contractFundRentPlan);
		}
		
		ObjectMapper jsonMapper = new ObjectMapper();
		Map[] newSetMaps = jsonMapper.readValue(json_fund_rent_plan_str, Map[].class);//新的租金计划
		for (int j = 0; j < newSetMaps.length; j++) {//构建出json中的map对象
			String key=newSetMaps[j].get("id").toString();
			String rentlist=newSetMaps[j].get("rentlist").toString();
			ContractFundRentPlan contractFundRentPlan=new ContractFundRentPlan();
			if(dbmap2.containsKey(rentlist)){
				contractFundRentPlan=dbmap2.get(rentlist);
				newSetMaps[j].remove("id");
				newSetMaps[j].remove("contractid");
				newSetMaps[j].remove("quotid");
				newSetMaps[j].remove("quotid1");
			}
			this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[j], contractFundRentPlan, null);
			jsonmap1.put(key, contractFundRentPlan);//旧
			jsonmap2.put(newSetMaps[j].get("rentlist").toString(), contractFundRentPlan);//新
			if(dbmap2.containsKey(rentlist)){
				newmap.put(contractFundRentPlan.getId(), contractFundRentPlan);
			}else{
				newmap.put(key, contractFundRentPlan);
			}
			newList.add(contractFundRentPlan);
		}
		//保存 newmap
		this.baseService.saveOrUpdateAllEntities(newList);
		
		//更新income
		Set<String> dbmap1set=dbmap1.keySet();
		for (String id : dbmap1set) {
			if(!newmap.containsKey(id)){
				Set<ContractFundRentInCome> incomSet=dbmap1.get(id).getContractFundRentInComes();
				List<ContractFundRentInCome> incomeList=new ArrayList<ContractFundRentInCome>();
				for (ContractFundRentInCome income : incomSet) {
					Integer rentList=income.getPlanList();
					while(!jsonmap2.containsKey(rentList.toString())){
						rentList=rentList-1;
					}
					income.setPlanId(jsonmap2.get(rentList.toString()));
					income.setPlanList(rentList);
					incomeList.add(income);
				}
				if(incomeList.size()>0){
					this.baseService.updateAllEntities(incomeList);
				}
				removeList.add(dbmap1.get(id));
				System.out.println("id:"+id);
				//this.baseService.removeEntityById(ContractFundRentPlan.class, dbmap1.get(id).getId());
			}
		}
		//this.baseService.getBussinessDao().getHibernateTemplate().clear();
		this.baseService.removeAllEntites(removeList);
		
		// 2.3合同现金流
		String json_fund_cash_flow_str = datas.get(rentCashKey);
		JSONArray jsonArray = new JSONArray(json_fund_cash_flow_str);
		List<String> jsonFundList=new ArrayList<String>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonFundList.add(jsonObj.toString());
		}
		this.baseService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", jsonFundList.toString(),null);
		//再入历史表
		contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);//再查一次更新数据
		
		//商务条件
		cCondition=contractInfo.getContractCondition();
		cConditionHis=new ContractConditionHis();
		BeanUtils.copyProperties(cCondition, cConditionHis);
		cConditionHis.setModStatus(hisAfter);
		cConditionHis.setModReason(hisTypeDict);
		cConditionHis.setId(null);
		cConditionHis.setDocId(docId);
		this.baseService.saveEntity(cConditionHis);
		
		
		//合同租金计划HIS表移动数据前先删除
		delSql = this.getDelHisSql(docId,"his_status_after",hisType);
		log.info("移动数据前，租金临时表的租金计划移往HIS表前删除:"+delSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(delSql);
		
		//合同租金计划变更后数据记录HIS
		sql = this.getHisSql(docId, "his_status_after","contract_fund_rent_plan_temp");
		log.info("移动数据前，租金正式表的租金计划移往HIS表作为后数据:"+sql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(sql.toString());
		
		//合同现金流
		fundCashDetails=contractInfo.getContractCashDetails();
		fundCashDetailHiss=new ArrayList<ContractCashDetailHis>();
		for (ContractCashDetail contractCashDetail : fundCashDetails) {
			ContractCashDetailHis fundCashDetailHis=new ContractCashDetailHis();
			BeanUtils.copyProperties(contractCashDetail, fundCashDetailHis);
			fundCashDetailHis.setModStatus(hisAfter);
			fundCashDetailHis.setModReason(hisTypeDict);
			fundCashDetailHis.setId(null);
			fundCashDetailHis.setDocId(docId);
			fundCashDetailHiss.add(fundCashDetailHis);
		}
		this.baseService.saveAllEntities(fundCashDetailHiss);
		
		//之前的操作updateFlush下
		this.baseService.getBussinessDao().updateFlush();
		
		//将变更后的租金计划重新从临时表移往正式表一次,修改BUG系统总是不把变更后增加或减少的期项不存入正式表中去
		String delRentPlanSql =  this.getRentOfTempToPlanSql(docId, adjustInfo, "del", contractInfo);
		log.info("大于变更开始期项的数据删除:"+delRentPlanSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(delRentPlanSql);
		String insertRentPlanSql =  this.getRentOfTempToPlanSql(docId, adjustInfo, "insert", contractInfo);
		log.info("大于变更开始期项的数据重新插入:"+insertRentPlanSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(insertRentPlanSql);
		
	}
	
	/**
	 * 
	 * <p>将变更前后的租金计划从记录入HIS存档。</p>
	 * @author sea
	 * @param model 目前只用docid 例如:model.get("docid")
	 * @param hisType 流程模块名称 his_plan_change
	 * @throws Exception
	 */
	public void updateCopyFundRentPlanFromTempToHisBeforeAndAfter(Map<String, String> model,String hisType) throws Exception {
		String docid = model.get("docid");
		if(Tools.isNullOrEmpty(docid)){
			throw new Exception("文档号为空，无法将租金计划从临时更新到正式!");
		}
		
		//移动数据前先删除
		String delSql = this.getDelHisSql(docid,"his_status_before",hisType);
		log.info("移动数据前，租金正式表的租金计划移往HIS表前删除:"+delSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(delSql);
		
		//变更前数据记录HIS
		String sql = this.getHisSql(docid, "his_status_before",hisType);
		log.info("移动数据前，租金正式表的租金计划移往HIS表作为前数据:"+sql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(sql.toString());
		
		//--------------------------------------------------------------------------------------------------------------------
		//移动数据前先删除
		delSql = this.getDelHisSql(docid,"his_status_after",hisType);
		log.info("移动数据前，租金临时表的租金计划移往HIS表前删除:"+delSql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(delSql);
		
		//变更后数据记录HIS
		sql = this.getHisSql(docid, "his_status_after","contract_fund_rent_plan_temp");
		log.info("移动数据前，租金正式表的租金计划移往HIS表作为后数据:"+sql);
		this.baseService.getBussinessDao().getJdbcTemplate().execute(sql.toString());
	}
	
	/**
	 * <p>开始及结束时将租金计划移往HIS做对比记录前生成的删除HIS表记录SQL。</p>
	 * @author sea
	 * @param docid 文档号
	 * @param mod_status 前后状态: 前 : his_status_before| 后：his_status_after
	 * @param mod_reason 流程名称 
	 * @return
	 */
	private String getDelHisSql(String docid,String mod_status,String mod_reason){
		String delSql = " delete contract_fund_rent_plan_his ";
		delSql = delSql + " where doc_id = '"+docid+"' ";
		delSql = delSql + " and mod_status = '"+mod_status+"' "; 
		delSql = delSql + " and mod_reason = '"+mod_reason+"' ";
		delSql = delSql + " and contract_id in ( ";
		delSql = delSql + "   select distinct t1.contract_id  from contract_fund_rent_plan_temp t1 ";
		delSql = delSql + "   left join contract_info t2 on t2.contract_id = t1.contract_id ";
		delSql = delSql + "   where t1.doc_id = '"+docid+"' ";
		delSql = delSql + " ) ";
		
		return delSql;
	}
	
	/**
	 * <p>根据表名和前后状态将数据移往HIS的操作,作为前后对比操作。</p>
	 * @author sea
	 * @param docid 文档号
	 * @param mod_status 前后状态，前：his_status_before ，后：his_status_after
	 * @param table_name 表名称
	 * @return
	 */
	private String getHisSql(String docid,String mod_status,String table_name){
		StringBuffer sql = new StringBuffer();
		sql.append("  ")
		.append(" insert into contract_fund_rent_plan_his ( ")
		.append(" id,doc_id,rent_list,plan_date,rent,rent_adjust, ")
		.append(" corpus,corpus_business,year_rate,interest,interest_business,rent_overage, ")
		.append(" corpus_overage,interest_overage,penalty_overage,penalty, ")
		.append(" create_date,mod_status,mod_reason,creator_, ")
		.append(" modify_date,modificator_, ")
		.append(" contract_id ")
		.append(" ) ")
		.append(" select sys_guid() , '"+docid+"',rent_list,plan_date,rent,rent_adjust, ")
		.append(" corpus,corpus_business,year_rate,interest,interest_business,rent_overage, ")
		.append(" corpus_overage,interest_overage,penalty_overage,penalty, ")
		.append(" create_date,'"+mod_status+"' as mod_status,'his_rate_change' as mod_reason,creator_, ")
		.append(" modify_date,modificator_, ")
		.append("  ");
		
		if("contract_fund_rent_plan_temp".equals(table_name)){
			sql.append(" sql2.id as contract_id ")
			.append(" from contract_fund_rent_plan_temp ")
			.append(" left join ( ")
			.append("   select distinct t2.id , t1.contract_id  from contract_fund_rent_plan_temp t1 ")
			.append("   left join contract_info t2 on t2.contract_id = t1.contract_id ")
			.append("   where t1.doc_id = '"+docid+"' ")
			.append(" ) sql2  on sql2.contract_id = contract_fund_rent_plan_temp.contract_id ")
			.append(" where doc_id = '"+docid+"'  ");
		}
		
		if("contract_fund_rent_plan".equals(table_name)){
			sql.append(" contract_id ")
			.append(" from "+table_name)
			.append(" where contract_id in ( ")
			//正式表使用的是合同号对应的uuid
			.append("   select distinct t2.id as contract_id  from contract_fund_rent_plan_temp t1 ")
			.append("   left join contract_info t2 on t2.contract_id = t1.contract_id ")
			.append("   where t1.doc_id = '"+docid+"' ")
			.append(" ) ")
			.append("  ");
		}
		
		return sql.toString();
	}
	
	/**
	 * <p>将变更后的部分租金计划从临时移往正式。</p>
	 * @author sea
	 * @param docid 文档号
	 * @param adjustInfo 变更条件
	 * @param model 获取insert od delete  SQL
	 * @param contractInfo 合同表UUID，删除sql需要
	 * @return
	 */
	private String getRentOfTempToPlanSql(String docId,FundRentAdjust adjustInfo,String model,ContractInfo contractInfo){
		int startList = adjustInfo.getStartList();
		if(null == adjustInfo){
			startList = 0;
		}
		
		StringBuffer sql = new StringBuffer();
		//插入SQL
		if("insert".equals(model)){
			sql.append(" insert into contract_fund_rent_plan  ")
			.append(" ( ")
			.append(" ID,DOC_ID,QUOT_ID,ONHIRE_ID,RENT_LIST,PLAN_DATE,RENT,RENT_ADJUST,CORPUS,CORPUS_BUSINESS,YEAR_RATE,INTEREST, ")
			.append(" INTEREST_BUSINESS,RENT_OVERAGE,CORPUS_OVERAGE,INTEREST_OVERAGE,PENALTY_OVERAGE, ")
			.append(" PENALTY,CREATE_DATE,MODIFY_DATE, WORK_FLAG,CONTRACT_ID,STATUS_,CREATOR_,MODIFICATOR_, CARD_EXPORT_STATUS ")
			.append(" ) ")
			.append(" select  ")
			.append(" sys_guid(),DOC_ID,QUOT_ID,ONHIRE_ID,RENT_LIST,PLAN_DATE,RENT,RENT_ADJUST,CORPUS,CORPUS_BUSINESS,YEAR_RATE,INTEREST, ")
			.append(" INTEREST_BUSINESS,RENT_OVERAGE,CORPUS_OVERAGE,INTEREST_OVERAGE,PENALTY_OVERAGE, ")
			.append(" PENALTY,CREATE_DATE,MODIFY_DATE,0  ,(select info.id from contract_info info where info.contract_id=contract_fund_rent_plan_temp.contract_id),STATUS_,CREATOR_,MODIFICATOR_,0  ")
			.append(" from contract_fund_rent_plan_temp  ")
			.append(" where doc_id = '"+docId+"' and rent_list >= "+startList)
			.append(" ")
			.append(" order by plan_date  ");
		}
		//删除SQL
		if("del".equals(model)){
			sql.append(" delete  contract_fund_rent_plan  ")
			.append(" where contract_id = '"+contractInfo.getId()+"'  ")
			//.append(" and doc_id = '"+docId+"' ")
			.append(" and rent_list >= "+startList);
		}
		
		return sql.toString();
	}
}
