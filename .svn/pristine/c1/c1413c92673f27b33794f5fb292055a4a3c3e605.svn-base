package com.business.serviceImpl.reckon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.business.action.leasing.contract.approval.ContractApprovalStartAction;
import com.business.entity.DictionaryData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.cust.quot.CustCashDetail;
import com.business.entity.cust.quot.CustCondition;
import com.business.entity.cust.quot.CustFinaCashDetail;
import com.business.entity.cust.quot.CustFinaRentPlan;
import com.business.entity.cust.quot.CustFundRentPlan;
import com.business.entity.proj.reckon.ProjCashDetailTemp;
import com.business.entity.proj.reckon.ProjConditionTemp;
import com.business.entity.proj.reckon.ProjFinaCashDetailTemp;
import com.business.entity.proj.reckon.ProjFinaRentPlanTemp;
import com.business.entity.proj.reckon.ProjFundRentPlanTemp;
import com.business.entity.util.OwnInfo;
import com.business.model.ConditionBean;
import com.business.model.FundRentPlanBean;
import com.business.model.RentInfoBox;
import com.business.service.TableService;
import com.business.service.convert.ConvertMapToBeanService;
import com.business.service.reckon.FundFundChargePlanService;
import com.business.service.reckon.RentCalculateService;
import com.business.util.EqualCorpusUtil;
import com.business.util.EqualDiffCorUtil;
import com.business.util.EqualPaymentUtil;
import com.business.util.EqualRatioCorpusUtil;
import com.business.util.EqualRatioRentUtil;
import com.business.util.MoneyUtils;
import com.business.util.SettleLawUtil;
import com.business.util.Tools;
import com.business.util.calc.EqualDiffRentUtil;
import com.reckon.bean.Condition;
import com.reckon.bean.RentPlan;
import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.web.RentCalcDo;
import com.tenwa.leasing.rentcharge.web.RentChargeDo;
import com.tenwa.leasing.rentcharge.web.RentPlanModDo;
import com.tenwa.leasing.util.LeasingException;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author 孙传良
 * @date 2013-3-19上午11:03:49
 * @info 租金测算的接口的实现类
 * @Copyright Tenwa
 */
@Service(value = "rentCalculateService")
@SuppressWarnings("all")
public class RentCalculateServiceImpl implements RentCalculateService {

	ConditionBean conditionBean = new ConditionBean();

	@Resource(name = "convertMapToBeanService")
	private ConvertMapToBeanService convertMapToBeanService;

	@Resource(name = "tableService")
	private TableService tableService;

	@Resource(name = "contractApprovalStartAction")
	private ContractApprovalStartAction contractApprovalStartAction;
	
	@Resource(name = "fundFundChargePlanService")
	private FundFundChargePlanService fundChargePlanService;

	
	Logger	logger	= Logger.getLogger(RentCalculateServiceImpl.class);
	
	
	public Map<String, Object> calculateRentPlan(Map<String, String> modelData) throws Exception {
		Map<String, Object> return_model = new HashMap<String, Object>();
		List<FundRentPlanBean> rentPlanDetails = new ArrayList<FundRentPlanBean>();
		conditionBean = this.convertMapToBeanService.convertContionBean(conditionBean, modelData);
		RentInfoBox rentInfoBox = new RentInfoBox();
		// 1参数的提取
		// 1.1租金测算方法
		String settle_method = conditionBean.getSettle_method();
		if ("RentCalcType1".equals(settle_method)) {// 等额租金
			rentInfoBox = EqualPaymentUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType2".equals(settle_method)) {// 等差租金
			rentInfoBox = EqualDiffRentUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType3".equals(settle_method)) {// 等比租金
			rentInfoBox = EqualRatioRentUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType4".equals(settle_method)) {// 等额本金
			rentInfoBox = EqualCorpusUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType5".equals(settle_method)) {// 等差本金
			rentInfoBox = EqualDiffCorUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType6".equals(settle_method)) {// 等比本金
			rentInfoBox = EqualRatioCorpusUtil.getRentInfoBox(conditionBean);
		} else if ("RentCalcType7".equals(settle_method)) {// 均息法
			rentInfoBox = SettleLawUtil.getRentInfoBox(conditionBean);
		}
		for (int i = 0; i < rentInfoBox.getPlanDate().size(); i++) {
			FundRentPlanBean fundRentPlanBean = new FundRentPlanBean();
			fundRentPlanBean.setRent_list(i + 1);
			fundRentPlanBean.setPlan_date(rentInfoBox.getPlanDate().get(i));
			fundRentPlanBean.setRent(rentInfoBox.getRent().get(i));
			fundRentPlanBean.setCorpus(rentInfoBox.getCorpus().get(i));
			fundRentPlanBean.setInterest(rentInfoBox.getInterest().get(i));
			fundRentPlanBean.setCorpus_overage(rentInfoBox.getCorpusOverge().get(i));
			rentPlanDetails.add(fundRentPlanBean);
		}
		return_model.put("rentPlanDetails", rentPlanDetails);
		return_model.put("rentCashDetails", rentInfoBox.getRentDetails());
		return_model.put("irr", rentInfoBox.getIrr());
		return return_model;
	}

	/**
	 * 
	 * 租金测算方法
	 * 
	 */
	@Override
	public Map<String, Object> calculateRentPlanOld(Map<String, String> modelData) throws Exception {
		
		// 构建旧测算需求要的参数
		com.tenwa.leasing.bean.ConditionBean condition = new com.tenwa.leasing.bean.ConditionBean();
		
		// 获取商务条件
		condition = this.convertMapToBeanService.convertContionBean(condition, modelData);
		String fxday = this.tableService.findEntityByID(DictionaryData.class,"mianfx01").getDescription();
		if ( fxday == null )//数据字典可配置免罚息天数
			condition.setFreeDefaInterDay("3");
		else 
			condition.setFreeDefaInterDay(fxday);
		if (modelData.get("framework_condition.contractid") == null || modelData.get("framework_condition.contractid").equals("")) {
			condition.setProjId(modelData.get("framework_condition.projid"));// 业务项目编号
		} else {
			condition.setContractId(modelData.get("framework_condition.contractid"));// 商务合同号
		}
		String reckonType = modelData.get("framework_condition.reckontype");// 测算方式:均息法/等额租金法
		String process = modelData.get("framework_condition.process");// 操作类型:租金测算/变更/调息

		if (!reckonType.toLowerCase().contains("onhire")) {
			modelData.put("framework_condition.onhireid", "");
			condition.setOnhireId(null);
		}
		// 租金计划测算和租金调整
		String rentadjust[] = null;
		if (reckonType.equals("plan") || reckonType.equals("adjust")) {
			// ====================从JSON中提取租金计划（租金计划修改后重新算息）============================
			List<RentPlan> fundRentPlanTemps = new ArrayList<RentPlan>();
			ObjectMapper jsonMapper = new ObjectMapper();
			String fundRentPlan = modelData.get("json_fund_rent_plan_str");

			Map[] newSetMaps = jsonMapper.readValue(fundRentPlan, Map[].class);
			rentadjust = new String[newSetMaps.length];
			for (int j = 0; j < newSetMaps.length; j++) {
				RentPlan temp;
				if (process.equals("proj_process")) {//等额租金法
					temp = new ProjFundRentPlanTemp();
				} else if (process.equals("quoted_price")) {//均息法
					temp = new CustFundRentPlan();
				} else {
					temp = new ContractFundRentPlanTemp();
				}
				Map map = newSetMaps[j];
				rentadjust[j] = map.get("rentadjust") == null ? "" : map.get("rentadjust").toString();
				this.tableService.copyAndOverrideExistedValueFromStringMap(map, temp, null);
				fundRentPlanTemps.add(temp);
			}
			//============================================================
			
			
			
			
			// 此处不能用tableService对bean对象进行操作,因为在旧的测算中要查数据库而这里虽然做了这个操作但是没有做提交
			// 数据的提交是事务控制的,代码运行到此处其实数据库时没有对应的实际操作的,所以在后面的测算中其实是拿不导数据的.
			// 所以这里改为由原来的老代码直接对数据库进行操作.
			Collections.sort(fundRentPlanTemps);// 排序
			com.tenwa.leasing.bean.FundRentPlanBean frpf = new com.tenwa.leasing.bean.FundRentPlanBean();
			frpf.setQuot_id(condition.getQuotId());
			frpf.setOnHire_id(condition.getOnhireId());
			List planDate_list = new ArrayList(); // 租金计划日期
			List rent_list = new ArrayList(); // 租金列表
			List corpus_list = new ArrayList(); // 本金列表
			List corpusOverage_list = new ArrayList(); // 本金余额列表
			List interest_list = new ArrayList(); // 利息列表
			List rent_adjust_list = new ArrayList(); // 利息列表
			List year_rate_list = new ArrayList();// 年利率
			List planCorpus = new ArrayList();// 业务本金
			List planInterest = new ArrayList();//业务利息
			TabCalBean tcb = new TbBeanTools().getTabInfo(process, condition);
			// new TabCalBean("contract_condition_temp", "contract_fund_rent_plan_temp", "contract_id", cb.getProj_id(), "doc_id", cb.getDocId(), "contract_cash_detail_temp", "contract_fina_rent_plan_temp", "", cb.getQuot_id());
			tcb.setCalType(process);
			for (int i = 0; i < fundRentPlanTemps.size(); i++) {
				rent_list.add(fundRentPlanTemps.get(i).getRent() == null ? "0" : fundRentPlanTemps.get(i).getRent());
				planDate_list.add(fundRentPlanTemps.get(i).getPlanDate());
				rent_adjust_list.add(fundRentPlanTemps.get(i).getRentAdjust() == null ? "" : fundRentPlanTemps.get(i).getRentAdjust());
				corpus_list.add(fundRentPlanTemps.get(i).getCorpus() == null ? "0" : fundRentPlanTemps.get(i).getCorpus());
				interest_list.add(fundRentPlanTemps.get(i).getInterest() == null ? "0" : fundRentPlanTemps.get(i).getInterest());
				planCorpus.add(fundRentPlanTemps.get(i).getCorpusBusiness() == null ? "0" : fundRentPlanTemps.get(i).getCorpusBusiness());
				planInterest.add(fundRentPlanTemps.get(i).getInterestBusiness() == null ? "0" : fundRentPlanTemps.get(i).getInterestBusiness());
				year_rate_list.add(condition.getYearRate());
				corpusOverage_list.add(fundRentPlanTemps.get(i).getCorpusOverage() == null ? "0" : fundRentPlanTemps.get(i).getCorpusOverage());
			}
			frpf.setRent_list(rent_list);
			frpf.setPlanDate_list(planDate_list);
			frpf.setRent_adjust_list(rent_adjust_list);
			frpf.setCorpus_list(corpus_list);
			frpf.setInterest_list(interest_list);
			frpf.setColumn_1(planCorpus);
			frpf.setColumn_2(planInterest);
			frpf.setYear_rate_list(year_rate_list);
			frpf.setCorpusOverage_list(corpusOverage_list);
			RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
			rpccdi.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");// 删除
			rpccdi.addRentPlan(tcb.getRentPlan_tb(), frpf, tcb, "1", "2");// 添加
		}
		
		// 调用测算
		Hashtable<String, String> re_ht = new Hashtable<String, String>();
		if (reckonType.equals("plan")) {//租金调整
			RentPlanModDo rpmd = new RentPlanModDo();
			re_ht = rpmd.updatePlan(condition.getProjId(), condition.getDocId(), "", modelData.get("framework_condition.process"));
		} else {//租金测算
			RentCalcDo rcd = new RentCalcDo();
			re_ht = rcd.rentCal(condition, modelData.get("framework_condition.process"), "", rentadjust);
		}
		
		
		Map<String, Object> return_model = null;// 构建返回数据
		if (re_ht.get("isSucess").equals("false")) {
			throw new LeasingException(re_ht.get("message"));
		} else {
			List ccts = new ArrayList();//存放租金测算时的临时商务条件
			List cfdrpts = new ArrayList();//项目租金计划(临时)
			List cfarpts = new ArrayList();//项目会计租金计划(临时)
			List ccdt = new ArrayList();//项目现金流明细(临时)
			List cfcdt = new ArrayList();//项目会计现金流明细表(临时)
			
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			
			if (process.equals("proj_process")) {
				propertiesMap.put("projId", modelData.get("framework_condition.projid"));
				propertiesMap.put("docId", modelData.get("framework_condition.docid"));
				ccts = this.tableService.findEntityByProperties(ProjConditionTemp.class, propertiesMap);
				if(ccts != null && ccts.size() > 0){
					cfdrpts = this.tableService.findEntityByProperties(ProjFundRentPlanTemp.class, propertiesMap);
					cfarpts = this.tableService.findEntityByProperties(ProjFinaRentPlanTemp.class, propertiesMap);
					ccdt = this.tableService.findEntityByProperties(ProjCashDetailTemp.class, propertiesMap);
					cfcdt = this.tableService.findEntityByProperties(ProjFinaCashDetailTemp.class, propertiesMap);
				}
			} else if (process.equals("quoted_price")) {
				propertiesMap.put("custId", modelData.get("framework_condition.custid"));
				propertiesMap.put("docId", modelData.get("framework_condition.docid"));
				ccts = this.tableService.findEntityByProperties(CustCondition.class, propertiesMap);
				if(ccts != null && ccts.size() > 0){
					cfdrpts = this.tableService.findEntityByProperties(CustFundRentPlan.class, propertiesMap);
					cfarpts = this.tableService.findEntityByProperties(CustFinaRentPlan.class, propertiesMap);
					ccdt = this.tableService.findEntityByProperties(CustCashDetail.class, propertiesMap);
					cfcdt = this.tableService.findEntityByProperties(CustFinaCashDetail.class, propertiesMap);
				}
			} else {
				propertiesMap.put("contractId", modelData.get("framework_condition.contractid"));
				propertiesMap.put("docId", modelData.get("framework_condition.docid"));
				ccts = this.tableService.findEntityByProperties(ContractConditionTemp.class, propertiesMap);
				if(ccts != null && ccts.size() > 0){
					cfdrpts = this.tableService.findEntityByProperties(ContractFundRentPlanTemp.class, propertiesMap);
					cfarpts = this.tableService.findEntityByProperties(ContractFinaRentPlanTemp.class, propertiesMap);
					ccdt = this.tableService.findEntityByProperties(ContractCashDetailTemp.class, propertiesMap);
					cfcdt = this.tableService.findEntityByProperties(ContractFinaCashDetailTemp.class, propertiesMap);
				}
			}
			
			//数据齐全时才可以反馈
			if (cfdrpts.size() > 0 && cfarpts.size() > 0 && ccdt.size() > 0 && cfcdt.size() > 0) {
				Collections.sort(cfdrpts);
				Collections.sort(cfarpts);
				Collections.sort(ccdt);
				Collections.sort(cfcdt);
				return_model = new HashMap<String, Object>();
				return_model.put("fundrentplan", cfdrpts);
				return_model.put("finarentplan", cfarpts);
				return_model.put("fundcashdetail", ccdt);
				return_model.put("finacashdetail", cfcdt);
				return_model.put("irr", ((Condition) (ccts.get(0))).getIrr());
				return_model.put("planIrr", ((Condition) (ccts.get(0))).getPlanIrr());
				// 计算租金总额
				BigDecimal renttotalmoney = BigDecimal.ZERO;
				for (RentPlan rentPlan : (List<RentPlan>) cfdrpts) {
					renttotalmoney = renttotalmoney.add(rentPlan.getRent());
				}
				return_model.put("renttotalmoney", renttotalmoney.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
				return_model.put("rentcalculaters", "yes");
				return_model.put("enddate", ((RentPlan) cfdrpts.get(cfdrpts.size() - 1)).getPlanDate());
				
				List<OwnInfo> oInfos = this.tableService.findEntities(OwnInfo.class);// 强制性在这里增加这个查询了临时性的兼容发起合同审批时就能自动生成资金计划
				String ownName = "XX融资公司";
				if (oInfos != null && oInfos.size() > 0) {
					ownName = oInfos.get(0).getOwnName();
				}
				return_model.put("owninfo", ownName);
			}
		}
		return return_model;
	}


	@Override
	public Map<String, Object> adjustCalculateOld(Map<String, String> modelData) throws Exception {
		Map<String, Object> return_model = new HashMap<String, Object>();// 构建返回数据
		AdjustBean adb = new AdjustBean();
		this.tableService.copyAndOverrideExistedValueFromStringMap(modelData, adb, null, "fund_rent_adjust");
		String saveType = modelData.get("fund_rent_adjust.adjustsavetype");
		Hashtable ht = new Hashtable();
		// adb.setAdjustType(modelData.get("fund_rent_adjust.adjusttype"));//租金计划变更
		// adb.setStartList(Integer.parseInt(modelData.get("fund_rent_adjust.startlist")));
		// adb.setAdjustList(Integer.parseInt(modelData.get("fund_rent_adjust.adjustlist")));
		// adb.setPaydayAdjust(modelData.get("fund_rent_adjust.paydayadjust"));
		// adb.setYearRate(Double.parseDouble(modelData.get("fund_rent_adjust.yearrate")));
		adb.setContractId(modelData.get("fund_rent_adjust.contract"));
		adb.setPk_clum_v1(modelData.get("fund_rent_adjust.contractid"));
		adb.setMeasureId(modelData.get("fund_rent_adjust.docid"));
		adb.setOnHireId("");
		adb.setCreator("");
		
		//提前结清比例(百分比)%
		adb.setAdvance_rate( new BigDecimal( MoneyUtils.getZeroStr(modelData.get("fund_rent_adjust.advancerate")) ) );
		
		RentChargeDo rcd = new RentChargeDo();
		if (saveType.equals("reckon")) {// 测算
			ht = rcd.rentChargeCal(adb, "cont_process", null);
		} else if (saveType.equals("terminate")) {// 中途终止
			
			//这里应该将合同终止下的adjustList设置为该合同对应租金计划的最大一期
			//adb.setAdjustList(18);
			
			// 缓存变更前的数据
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("contractId", adb.getContractId());
			propertiesMap.put("docId", adb.getMeasureId());
			propertiesMap.put("rentList", adb.getAdjustList());
			List<ContractFundRentPlanTemp> planTemp = this.tableService.findEntityByProperties(ContractFundRentPlanTemp.class, propertiesMap);
//			String planDate = planTemp.get(0).getPlanDate();
			ht = rcd.rentChargeCal(adb, "cont_process", null);
			
			// 测算完成处理中途终止的特殊性代码
			// 1修改最后一期的利息为商定利息
			// planTemp=this.tableService.findEntityByProperties(ContractFundRentPlanTemp.class,
			// propertiesMap);
			// if(planTemp!=null&&planTemp.size()>0){
			// ContractFundRentPlanTemp plan=planTemp.get(0);
			// if(plan.getPlanDate().equals(planDate)){
			// plan.setInterest(plan.getInterest()+adb.getAgreedInterest());
			// }else{
			// plan.setInterest(adb.getAgreedInterest());
			// }
			// plan.setRent(plan.getInterest()+plan.getCorpus());
			// plan.setCorpusBusiness(plan.getCorpus());
			// plan.setInterestBusiness(plan.getInterest());
			// }
		} else if (saveType.equals("adjust")) {// 调整
			// 从JSON中提取租金计划
			ObjectMapper jsonMapper = new ObjectMapper();
			String fundRentPlan = modelData.get("fund_rent_adjust.jsonfundrentplanstr");
			Map[] newSetMaps = jsonMapper.readValue(fundRentPlan, Map[].class);
			String obj[] = new String[(newSetMaps.length - adb.getStartList() + 1)];
			for (int j = 0; j < obj.length; j++) {
				obj[j] = newSetMaps[j + adb.getStartList() - 1].get("rentadjust") == null ? "" : newSetMaps[j + adb.getStartList() - 1].get("rentadjust").toString();
			}
			ht = rcd.rentChargeCal(adb, "cont_process", obj);
		}
		if (ht.get("isSucess").equals("false")) {
			throw new LeasingException(ht.get("error").toString());
		} else {
			return_model = selectConditionDataFromTemp(adb.getContractId(), adb.getMeasureId());
			return_model.put("adjust", "adjust");// 标记这个是变更
		}
		return return_model;
	}

	@Override
	public Map<String, Object> updateCalculateOld(Map<String, String> modelData) throws Exception {
		Map<String, Object> return_model = new HashMap<String, Object>();// 构建返回数据
		String fundRentPlan = modelData.get("fundrentplan");
		String contractId = modelData.get("contractid");
		String docId = modelData.get("docid");
		// 读取Json数据
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("contractId", contractId);
		propertiesMap.put("docId", docId);
		List<ContractFundRentPlanTemp> fundRentPlanTemps = new ArrayList<ContractFundRentPlanTemp>();
		// 从JSON中提取租金计划
		ObjectMapper jsonMapper = new ObjectMapper();
		Map[] newSetMaps = jsonMapper.readValue(fundRentPlan, Map[].class);
		for (int j = 0; j < newSetMaps.length; j++) {
			ContractFundRentPlanTemp temp = new ContractFundRentPlanTemp();
			Map map = newSetMaps[j];
			this.tableService.copyAndOverrideExistedValueFromStringMap(map, temp, null);
			fundRentPlanTemps.add(temp);
		}
		Collections.sort(fundRentPlanTemps);// 排序
		com.tenwa.leasing.bean.FundRentPlanBean frpf = new com.tenwa.leasing.bean.FundRentPlanBean();
		List planDate_list = new ArrayList(); // 租金计划日期
		List rent_list = new ArrayList(); // 租金列表
		List corpus_list = new ArrayList(); // 本金列表
		List corpusOverage_list = new ArrayList(); // 本金余额列表
		List interest_list = new ArrayList(); // 利息列表
		List rent_adjust_list = new ArrayList(); // 利息列表
		List year_rate_list = new ArrayList();// 年利率
		List column_1 = new ArrayList();//
		List column_2 = new ArrayList();//
		TabCalBean tcb = new TbBeanTools().getTabInfo("cont_process");// new
																		// TabCalBean("contract_condition_temp",
		tcb.setCalType("cont_process");
		tcb.setContOrProjCValue(contractId);
		tcb.setDocIdCoulValue(docId);
		for (int i = 0; i < fundRentPlanTemps.size(); i++) {
			rent_list.add(fundRentPlanTemps.get(i).getRent() == null ? "0" : fundRentPlanTemps.get(i).getRent());
			planDate_list.add(fundRentPlanTemps.get(i).getPlanDate());
			rent_adjust_list.add(fundRentPlanTemps.get(i).getRentAdjust() == null ? "" : fundRentPlanTemps.get(i).getRentAdjust());
			corpus_list.add(fundRentPlanTemps.get(i).getCorpus() == null ? "0" : fundRentPlanTemps.get(i).getCorpus());
			interest_list.add(fundRentPlanTemps.get(i).getInterest() == null ? "0" : fundRentPlanTemps.get(i).getInterest());
			column_1.add(fundRentPlanTemps.get(i).getCorpusBusiness() == null ? "0" : fundRentPlanTemps.get(i).getCorpusBusiness());
			column_2.add(fundRentPlanTemps.get(i).getInterestBusiness() == null ? "0" : fundRentPlanTemps.get(i).getInterestBusiness());
			year_rate_list.add(fundRentPlanTemps.get(i).getYearRate() == null ? "0" : fundRentPlanTemps.get(i).getYearRate());
			corpusOverage_list.add(fundRentPlanTemps.get(i).getCorpusOverage() == null ? "0" : fundRentPlanTemps.get(i).getCorpusOverage());
		}
		frpf.setRent_list(rent_list);
		frpf.setPlanDate_list(planDate_list);
		frpf.setRent_adjust_list(rent_adjust_list);
		frpf.setCorpus_list(corpus_list);
		frpf.setInterest_list(interest_list);
		frpf.setColumn_1(column_1);
		frpf.setColumn_2(column_2);
		frpf.setYear_rate_list(year_rate_list);
		frpf.setCorpusOverage_list(corpusOverage_list);
		RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
		rpccdi.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");// 删除
		rpccdi.addRentPlan(tcb.getRentPlan_tb(), frpf, tcb, "1", "2");// 添加
		// List<ContractFundRentPlanTemp>
		// rentPlanTemps=this.tableService.findEntityByProperties(ContractFundRentPlanTemp.class,
		// propertiesMap);
		// // Map<String, ContractFundRentPlanTemp> mapRentPlanTempData=new
		// LinkedHashMap<String, ContractFundRentPlanTemp>();
		// // for (ContractFundRentPlanTemp contractFundRentPlanTemp :
		// rentPlanTemps) {//构建出数据库中现有的temp表中的数据的map对象
		// // mapRentPlanTempData.put(contractFundRentPlanTemp.getId(),
		// contractFundRentPlanTemp);
		// // }
		// Map<String, ContractFundRentPlanTemp> mapRentPlanJsonData=new
		// LinkedHashMap<String, ContractFundRentPlanTemp>();
		// List<ContractFundRentPlanTemp> newRentPlan=new
		// ArrayList<ContractFundRentPlanTemp>();
		// ObjectMapper jsonMapper = new ObjectMapper();
		// Map[] newSetMaps = jsonMapper.readValue(fundRentPlan, Map[].class);
		// for (int j = 0; j < newSetMaps.length; j++) {//构建出json中的map对象
		// String key=newSetMaps[j].get("id").toString();
		// ContractFundRentPlanTemp contractFundRentPlanTemp=new
		// ContractFundRentPlanTemp();
		// if(StringUtil.nullToString(key).isEmpty()){
		// key=UUIDUtil.getUUID();
		// contractFundRentPlanTemp.setId(key);
		// // }else{
		// // contractFundRentPlanTemp=mapRentPlanTempData.get(key);
		// }
		// this.tableService.copyAndOverrideExistedValueFromStringMap(newSetMaps[j],
		// contractFundRentPlanTemp, null);
		// mapRentPlanJsonData.put(key, contractFundRentPlanTemp);
		// newRentPlan.add(contractFundRentPlanTemp);
		// }
		// // //取交集 交集中的数据 做更新
		// // Set<String> a=new HashSet<String>(mapRentPlanTempData.keySet());
		// // Set<String> b=new HashSet<String>(mapRentPlanJsonData.keySet());
		// // a.retainAll(b);
		// // for (String keyStr : a) {//保存交集
		// // newRentPlan.add(mapRentPlanJsonData.get(keyStr));
		// // }
		// // //取差集 mapRentPlanTempData 对 mapRentPlanJsonData的差集是要remove的反之则是新增
		// // a=new HashSet<String>(mapRentPlanTempData.keySet());
		// // a.remove(b);
		// // for (String keyStr : a) {//移除掉b-a的差集
		// // this.tableService.removeEntity(mapRentPlanTempData.get(keyStr));
		// // }
		// // a=new HashSet<String>(mapRentPlanTempData.keySet());
		// // b.remove(a);
		// // for (String keyStr : b) {//添加b-a的差集到list中
		// // ContractFundRentPlanTemp
		// contractFundRentPlanTemp=mapRentPlanJsonData.get(keyStr);
		// // contractFundRentPlanTemp.setId(null);
		// // newRentPlan.add(contractFundRentPlanTemp);
		// // }
		// //排序更新list中的rent_list
		// Collections.sort(newRentPlan, new
		// Comparator<ContractFundRentPlanTemp>() {//按照日期升序排列
		// @Override
		// public int compare(ContractFundRentPlanTemp o1,
		// ContractFundRentPlanTemp o2) {
		// return o1.getPlanDate().compareTo(o2.getPlanDate());
		// }
		// });
		// for (int i = 0; i < newRentPlan.size(); i++) {
		// newRentPlan.get(i).setRentList(i+1);
		// }
		// this.tableService.removeAllEntites(rentPlanTemps);
		// this.tableService.saveOrUpdateAllEntities(newRentPlan);
		RentPlanModDo rpmd = new RentPlanModDo();
		Hashtable ht = rpmd.updatePlan(contractId, docId, "", "cont_process");
		if (ht.get("isSucess").equals("false")) {
			throw new LeasingException(ht.get("error").toString());
		} else {
			return_model = selectConditionDataFromTemp(contractId, docId);
			return_model.put("adjust", "update");// 标记这个是修改
		}
		return return_model;
	}

	public Map<String, Object> resetConditionData(String contractId, String docId) throws Exception {
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contractId);
		contractApprovalStartAction.saveConditionDataToTemp(contractInfo, docId, tableService);
		Map<String, Object> return_model = selectConditionDataFromTemp(contractInfo.getContractId(), docId);// 构建返回数据
		return_model.put("adjust", "adjust");// 标记这个是变更
		return return_model;
	}

	/**
	 * 返回临时表中的数据
	 * 
	 * @param contractId
	 *            合同号(不是合同表中的主键id 而是 contract_id字段的值)
	 * @param docId
	 *            测算的doc_id
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectConditionDataFromTemp(String contractId, String docId) throws Exception {
		Map<String, Object> return_model = new HashMap<String, Object>();// 构建返回数据
		// List<Condition> ccts;
		// List<RentPlan> cfdrpts;
		// List<RentPlan> cfarpts;
		// List<CashDetail> ccdt;
		// List<CashDetail> cfcdt;
		List ccts;
		List cfdrpts;
		List cfarpts;
		List ccdt;
		List cfcdt;
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("contractId", contractId);
		propertiesMap.put("docId", docId);
		ccts = this.tableService.findEntityByProperties(ContractConditionTemp.class, propertiesMap);
		cfdrpts = this.tableService.findEntityByProperties(ContractFundRentPlanTemp.class, propertiesMap);
		cfarpts = this.tableService.findEntityByProperties(ContractFinaRentPlanTemp.class, propertiesMap);
		ccdt = this.tableService.findEntityByProperties(ContractCashDetailTemp.class, propertiesMap);
		cfcdt = this.tableService.findEntityByProperties(ContractFinaCashDetailTemp.class, propertiesMap);
		if (cfdrpts.size() > 0 ) {//&& ccdt.size() > 0
			Collections.sort(cfdrpts);
			Collections.sort(cfarpts);
			Collections.sort(ccdt);
			Collections.sort(cfcdt);
			return_model.put("fundrentplan", cfdrpts);
			return_model.put("finarentplan", cfarpts);
			return_model.put("fundcashdetail", ccdt);
			return_model.put("finacashdetail", cfcdt);
			return_model.put("rentcalculaters", "yes");
			return_model.put("irr", ((Condition) ccts.get(0)).getIrr());
			return_model.put("planIrr", ((Condition) ccts.get(0)).getPlanIrr());
			return_model.put("enddate", ((RentPlan) cfdrpts.get(cfdrpts.size() - 1)).getPlanDate());
			return_model.put("yearrate", ((Condition) ccts.get(0)).getYearRate());
			return_model.put("incomenumber", ((Condition) ccts.get(0)).getIncomeNumber());
			return_model.put("leaseterm", ((Condition) ccts.get(0)).getLeaseTerm());
		}
		return return_model;
	}

}
