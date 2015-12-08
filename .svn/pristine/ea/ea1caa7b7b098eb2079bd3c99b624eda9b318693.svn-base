package com.business.serviceImpl.reckon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

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
import com.business.service.reckon.ContractFundRentDataToHisService;
import com.kernal.utils.StringUtil;
import com.kernal.utils.UUIDUtil;

@Service(value = "contractFundRentDataToHisService")
public class ContractFundRentDataToHisServiceImpl implements ContractFundRentDataToHisService {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public void saveContractFundRentDataToHis(String contractId, String docId,
			String hisType, Map<String, String> datas,String rentPlanKey) throws Exception {
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);
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
		//合同租金计划()
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
			if(!dbmap2.containsKey(rentlist)){
				contractFundRentPlan.setId(null);
				contractFundRentPlan.setContractId(contractInfo);
				contractFundRentPlan.setWorkFlag(0);
				contractFundRentPlan.setPenalty(BigDecimal.ZERO);
				contractFundRentPlan.setPenaltyOverage(BigDecimal.ZERO);
				contractFundRentPlan.setCardExportStatus("0");
				
			}
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
		
		//合同租金计划HIS
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
	}

}
