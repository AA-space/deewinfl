package com.business.serviceImpl.cardhire;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.business.entity.DictionaryData;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentInComeTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.rent.ContractCardRentIncome;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.cardhire.ContractCardHireService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.util.PenaltyUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.StringUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-9-10下午11:12:48
 * @info
 * @Copyright 
 * Tenwa
 */
@Service(value="cardHireService")
public class ContractCardHireServiceImpl implements ContractCardHireService {

	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="fileTemplateService")
	private FileTemplateService  templateService;
	
	
	@Override
	public  List<ContractCardRentIncome> initCardHire(List<ContractCardRentIncome> card,Map<String,String> model)  throws Exception {
		 
		List<ContractCardRentIncome> ccriList=new ArrayList<ContractCardRentIncome>();
		
		for (int j = 0; j < card.size(); j++) {
			ContractCardRentIncome ccri=card.get(j);
			String purpose=ccri.getTradePurpose();
			if(!"".equals(purpose)){
				String[]purposes=purpose.split("/");
				if(purposes.length>2){
				ContractInfo ci=new ContractInfo();
				Map<String,Object> propertiesMap=new HashMap<String, Object>();
				propertiesMap.put("contractId",purposes[0]);
				List<ContractInfo> ciList=this.tableService.findEntityByProperties(ContractInfo.class, propertiesMap);
				if(!ciList.isEmpty()){
					ci=ciList.get(0);
				}
				ccri.setContractId(ci);
				ccri.setRentList(Integer.valueOf(purposes[1].toString()));
				ccri.setIncomeDate(DateUtil.getSystemDate());
				ccri.setLastMoney(ccri.getIncomeMoney());
				if(StringUtil.nullToString(ccri.getTradingResults())!=""){
					if(model.containsKey(ccri.getTradingResults())){
						ccri.setIncomeStatus(Integer.valueOf(model.get(ccri.getTradingResults())).intValue());
					}else{
						ccri.setIncomeStatus(0);
					}
				}else{
				   ccri.setIncomeStatus(0);
				}
				}else{
					throw new BusinessException("交易用途不全");
				}
			}else{
				throw new BusinessException("交易用途不能为空");
			}
			ccriList.add(ccri);
		}
		return ccriList;
	}

	@Override
	public boolean saveCardHireFile(List<ContractCardRentIncome> incomeInfo)
			throws Exception {
		this.tableService.saveAllEntities(incomeInfo);
		return false;
	}

	@Override
	public String addCardHireToIncome(
			ContractCardRentIncome ccri,List<ContractFundRentInComeTemp> incomeList,String docId,BaseFile baseFile) throws Exception {
		 //结算方式都为电汇
		 DictionaryData dict=new DictionaryData();
		 dict=this.tableService.findEntityByID(DictionaryData.class, "PayFund6");
		//获得剩余金额
//		BigDecimal totalMoney=ccri.getLastMoney();
		BigDecimal totalMoney=ccri.getIncomeMoney();
		//获得被核销的合同租金计划
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", ccri.getContractId());
		propertiesMap.put("rentList", ccri.getRentList());
		List<ContractFundRentPlan> fundPlans=this.tableService.findEntityByProperties(ContractFundRentPlan.class, propertiesMap);
		Map<String, Object> propert=new HashMap<String, Object>();
		propert.put("contractId", ccri.getContractId());
		propert.put("planList", ccri.getRentList());
//		List<ContractFundRentInCome> fundincome=this.tableService.findEntityByProperties(ContractFundRentInCome.class, propert);
		
		//按照到账金额和类型精确匹配核销
		if(fundPlans.isEmpty()){
			return "卡扣合同["+ccri.getContractId().getContractId()+"]指定的第["+ ccri.getRentList()+"]未在系统上查询到对应的租金计划!";
		}else{
			if(fundPlans.size()>1){
				return "[严重错误]卡扣合同["+ccri.getContractId().getContractId()+"]指定的第["+ ccri.getRentList()+"]在系统上的租金计划超过一条记录,不符合租金计划规范!";
			}else{
				ContractFundRentPlan plan=fundPlans.get(0);
				String handle_date = ccri.getIncomeDate();
				String HQL = " from DictionaryData AS DD where DD.belongDictionary.code=? ";
				List<DictionaryData> listpayType = new ArrayList<DictionaryData>();

				// 查出资金状态
				listpayType = this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
				HashMap<String, DictionaryData> mapPayType = new HashMap<String, DictionaryData>();
				for (DictionaryData dd : listpayType) {
					mapPayType.put(dd.getCode(), dd);
				}

				ContractCondition planCondition = plan.getContractId().getContractCondition();
				BigDecimal penaRate = planCondition.getPenaRate() == null ?BigDecimal.ZERO:planCondition.getPenaRate();
				
				int freeD = 0;
				if(planCondition.getFreeDefaInterDay() != null){
					freeD = planCondition.getFreeDefaInterDay();
				}
				
				plan.initContractFundRentPlan(mapPayType, handle_date, penaRate, freeD);
				
				ContractFundRentInComeTemp income=new ContractFundRentInComeTemp();
				
			
				//设置本方银行账号
				DictionaryData tradeBankDict = this.tableService.findEntityByID(DictionaryData.class, ccri.getTradeBank());
				String ownNumber  =tradeBankDict.getDescription();
				
				income.setOwnNumber(ownNumber);
				income.setContractId(ccri.getContractId());//合同号
				income.setPlanId(plan);
				income.setPID(ccri.getId());
				income.setPlanList(plan.getRentList());
				income.setBalanceMode(dict);
				//核销日期取日期
				String inComeDate = ccri.getIncomeDate();
				if (ccri.getIncomeDate().length() > 10) {
					inComeDate.substring(0, 10);
				}
				income.setHireDate(inComeDate);
				income.setAccountingDate(inComeDate);
				income.setUpId(ccri.getUpLoadId());
				income.setDocId(docId);
				BigDecimal rent=plan.getRent()==null?BigDecimal.ZERO:plan.getRent();
				BigDecimal corpus=plan.getCorpus()==null?BigDecimal.ZERO:plan.getCorpus();
				BigDecimal interest=plan.getInterest()==null?BigDecimal.ZERO:plan.getInterest();
				BigDecimal cairate=corpus.divide(rent, 10, BigDecimal.ROUND_HALF_EVEN);
//				BigDecimal penalty=plan.getPenalty()==null?BigDecimal.ZERO:plan.getPenalty();
				//--------------------------------核销租金---------------------------------------------
				ContractFundRentInCome sjincome = null;
				BigDecimal jCorpus =BigDecimal.ZERO;
				BigDecimal jCorpus2 =BigDecimal.ZERO;
				String sql="from ContractCardRentIncome inc where inc.contractId=? and inc.rentList=? and inc.upLoadId=? and inc.incomeStatus=? and inc.moneyType=?";
				List<ContractCardRentIncome> contractCardRentIncomelist= this.tableService.findResultsByHSQL(sql,ccri.getContractId(),
						ccri.getRentList(),baseFile,0,"租金");
				
				String sql2="from ContractFundRentInCome inc where inc.contractId=? and inc.planList=?";
				List<ContractFundRentInCome> fundincome= this.tableService.findResultsByHSQL(sql2,ccri.getContractId(),ccri.getRentList());
				if("租金".equals(ccri.getMoneyType())){
					if ( contractCardRentIncomelist.size() >= 2 )//大于5万的单子
					{
						for (int n=0;n<contractCardRentIncomelist.size();n++){
							System.out.println("5万的单子循环次数:"+contractCardRentIncomelist.size()+"\t"+"uploadId:"+baseFile.getId()+"\t");
							BigDecimal caicorpus=totalMoney.multiply(cairate).setScale(2, BigDecimal.ROUND_HALF_EVEN);
							BigDecimal caiinterest=totalMoney.subtract(caicorpus).setScale(2, BigDecimal.ROUND_HALF_EVEN);
							income.setCorpus(caicorpus);
							income.setInterest(caiinterest);
							income.setPenalty(BigDecimal.ZERO);
							System.out.println("5万的回笼单子记录"+"contractId:"+ccri.getContractId().getId()+"\t"+"租金:"+ccri.getIncomeMoney()+"\t"+"期次:"+ccri.getRentList()+"\t"+"upload_id:"+baseFile.getId() );
							break;
						}
					}else{
					if(rent.compareTo(totalMoney)>=0){
						if(totalMoney.compareTo(corpus)>0){//判断计划本金和本次卡扣本金 totalMoney > corpus
								if ( fundincome.size() > 0 ){
									  for (int i =0; i< fundincome.size(); i++){
										  sjincome = fundincome.get(i);
										  jCorpus2 = sjincome.getCorpus().setScale(2);
										  jCorpus = jCorpus.add(jCorpus2);
									  }
								}
								BigDecimal	sy_corpus = corpus.subtract(jCorpus);
								if ( jCorpus.compareTo(BigDecimal.ZERO) == 0) //未核销一次租金
								{
									income.setCorpus(corpus);
									totalMoney=totalMoney.subtract(corpus);
								}else{
									income.setCorpus(sy_corpus);
									totalMoney=totalMoney.subtract(sy_corpus);
								}
								
							}else{
								if ( fundincome.size() > 0 ){
									  for (int i =0; i< fundincome.size(); i++){
										  sjincome = fundincome.get(i);
										  jCorpus2 = sjincome.getCorpus().setScale(2);
										  jCorpus = jCorpus.add(jCorpus2);
									  }
								}
								//BigDecimal conp = totalMoney.add( jCorpus );//多次核销   当期corpus 之和
								 
								BigDecimal sub = plan.getCorpus().subtract(jCorpus);//下面核销剩余本金
								if ( totalMoney.compareTo(sub) <= 0 ) //totalMoney <= sub (继续核销和刚好核销完)
								{
									income.setCorpus(totalMoney);
									totalMoney=totalMoney.subtract(totalMoney);
								}else{
									income.setCorpus(sub);
									totalMoney=totalMoney.subtract(sub);
								}
								 
						}
						if(totalMoney.compareTo(new BigDecimal(0.00) )>0 ){
						   if(totalMoney.compareTo(interest)>=0){
							   income.setInterest(interest);
							   totalMoney= totalMoney.subtract(interest);
						    }else{
							   income.setInterest(totalMoney);
							   totalMoney= totalMoney.subtract(totalMoney);
						   }}else{
						      income.setInterest(new BigDecimal(0.00));
						}
						income.setPenalty(BigDecimal.ZERO);//未核销罚息情况,设罚息为0
					}else{
						return "卡扣合同["+ccri.getContractId().getContractId()
								+"]指定的第["+ ccri.getRentList()+"]需要核销的["+ccri.getMoneyType()
								+"]计划金额为["+rent.setScale(2, BigDecimal.ROUND_HALF_UP)+"]与扣款剩余金额["+totalMoney.setScale(2, BigDecimal.ROUND_HALF_UP)+"]不匹配!";
					}
				  }
				}
				//--------------------------------核销罚息---------------------------------
				else if("罚息".equals(ccri.getMoneyType())){
					String sqlx =" select v.penalty from vi_contract_penalty v where v.contract_id= '"+ccri.getContractId().getId() +"'"+ "  and v.rent_list= " +ccri.getRentList();
					List<Map<String, Object>> list = this.tableService.queryListBySql(sqlx);
					BigDecimal pe =BigDecimal.ZERO;
					if ( list.size() > 0 )
					{
						for( Map<String,Object> map : list )
						{
							for( Map.Entry<String,Object> e : map.entrySet() )
							{
								pe = (BigDecimal)e.getValue();
								break;
							}
						}
					}
					BigDecimal penalty = pe==null?BigDecimal.ZERO:pe;//获取罚息
					if ( totalMoney.compareTo(penalty) < 0) //totalMoney < penalty
					{
						income.setPenalty(totalMoney);
						income.setCorpus(BigDecimal.ZERO);
						income.setInterest(BigDecimal.ZERO);
					}
					if(penalty.compareTo(totalMoney)==0) //totalMoney == penalty
					{
						income.setPenalty(penalty);
						income.setCorpus(BigDecimal.ZERO);
						income.setInterest(BigDecimal.ZERO);
					}
					/*else{
						return "卡扣合同["+ccri.getContractId().getContractId()
								+"]指定的第["+ ccri.getRentList()+"]需要核销的["+ccri.getMoneyType()
								+"]计划金额为["+penalty.setScale(2, BigDecimal.ROUND_HALF_UP)+"]与扣款剩余金额["+totalMoney.setScale(2, BigDecimal.ROUND_HALF_UP)+"]不匹配!";
					}*/
				}else{
					return "卡扣合同["+ccri.getContractId().getContractId()+"]指定的第["+ ccri.getRentList()+"]需要核销的["+ccri.getMoneyType()+"]费用类型不正确!";
				}
				income.setRent(income.getCorpus().add(income.getInterest()));
				if((null!=income.getRent()&&income.getRent().compareTo(new BigDecimal(0.00) )>0) || (null!=income.getPenalty()&&income.getPenalty().compareTo(new BigDecimal(0.00))>0)){
				    incomeList.add(income);
				}
			}
		}
//		//按照金自动想下核销的逻辑
//		for (ContractFundRentPlan plan : fundPlans) {
//			if(totalMoney.compareTo(BigDecimal.ZERO)<=0){
//				break;
//			}
//			ContractFundRentInComeTemp income=new ContractFundRentInComeTemp();
//			income.setContractId(ccri.getContractId());//合同号
//			income.setPlanId(plan);
//			income.setPID(ccri.getId());
//			income.setPlanList(plan.getRentList());
//			income.setBalanceMode(dict);
//			income.setHireDate(ccri.getIncomeDate());
//			income.setAccountingDate(ccri.getIncomeDate());
//			income.setUpId(ccri.getUpLoadId());
//			BigDecimal rent=plan.getRent()==null?BigDecimal.ZERO:plan.getRent();
//			BigDecimal corpus=plan.getCorpus()==null?BigDecimal.ZERO:plan.getCorpus();
//			BigDecimal interest=plan.getInterest()==null?BigDecimal.ZERO:plan.getInterest();
//			BigDecimal penalty=plan.getPenalty()==null?BigDecimal.ZERO:plan.getPenalty();
//			if(totalMoney.compareTo(penalty)>=0){
//				income.setPenalty(penalty);
//				totalMoney=totalMoney.subtract(penalty);
//			}else{
//				income.setPenalty(totalMoney);
//				totalMoney=BigDecimal.ZERO;
//			}
//			if(totalMoney.compareTo(rent)>=0){
//				income.setCorpus(corpus);
//				income.setInterest(interest);
//				totalMoney=totalMoney.subtract(rent);
//			}else{
//				if(totalMoney.compareTo(interest)>=0){
//					income.setInterest(interest);
//					totalMoney=totalMoney.subtract(interest);
//				}else{
//					income.setInterest(totalMoney);
//					totalMoney=BigDecimal.ZERO;
//				}
//				if(totalMoney.compareTo(corpus)>=0){
//					income.setCorpus(corpus);
//					totalMoney=totalMoney.subtract(interest);
//				}else{
//					income.setCorpus(totalMoney);
//					totalMoney=BigDecimal.ZERO;
//				}
//			}
//			income.setRent(income.getCorpus().add(income.getInterest()));
//			incomeList.add(income);
//		}
		return null;
	}

	@Override
	public String addCardHireToIncomeByList(
			List<ContractCardRentIncome> ccriList,List<ContractFundRentInComeTemp> cfrictList,String docId,BaseFile baseFile) throws Exception {
		for (ContractCardRentIncome ccri : ccriList) {
			 String msg=addCardHireToIncome(ccri,cfrictList,docId,baseFile);
			 if(msg!=null){
				 return msg;
			 }
		}
		return null;
	}

	@Override
	public String deleteCardHireToIncome(ContractFundRentInComeTemp cfrit)
			throws Exception {
		//得到该条记录的对应的来源数据
		String cardIncomeId=cfrit.getPID();
		ContractCardRentIncome ccri=this.tableService.findEntityByID(ContractCardRentIncome.class, cardIncomeId);
		//获得核销的金额
		BigDecimal rent=cfrit.getRent()==null?BigDecimal.ZERO:cfrit.getRent();
		BigDecimal penalty=cfrit.getPenalty()==null?BigDecimal.ZERO:cfrit.getPenalty();
		BigDecimal totalMoney=rent.add(penalty);
		//设置剩余金额
		ccri.setLastMoney(ccri.getLastMoney().add(totalMoney));
		if(ccri.getIncomeMoney().compareTo(ccri.getLastMoney())<0){
			throw new BusinessException(cfrit.getContractId().getContractId()+"合同的到账核销检测发现剩余金额超过到账金额");
		}
		//删除核销数据
		this.tableService.removeEntity(cfrit);
		//保存剩余金额
		this.tableService.saveEntity(ccri);
		return "";
	}

	@Override
	public String deleteCardHireToIncomeByList(
			List<ContractFundRentInComeTemp> cfritList) throws Exception {
		String rs="";
		for (ContractFundRentInComeTemp cfrit : cfritList) {
			rs+=deleteCardHireToIncome(cfrit)+"\n";
		}
		return rs;
	}

	@Override
	public void saveIncomeList(List<ContractFundRentInComeTemp> cfritList)
			throws Exception {
		for (ContractFundRentInComeTemp cfrit : cfritList) {
			//得到该条记录的对应的来源数据
			String cardIncomeId=cfrit.getPID();
			ContractCardRentIncome ccri=this.tableService.findEntityByID(ContractCardRentIncome.class, cardIncomeId);
			//获得核销的金额
			BigDecimal rent=cfrit.getRent()==null?BigDecimal.ZERO:cfrit.getRent();
			BigDecimal penalty=cfrit.getPenalty()==null?BigDecimal.ZERO:cfrit.getPenalty();
			BigDecimal totalMoney=rent.add(penalty);
			//设置剩余金额
			ccri.setLastMoney(ccri.getLastMoney().subtract(totalMoney));
			if(ccri.getIncomeMoney().compareTo(ccri.getLastMoney())<0){
				throw new BusinessException(cfrit.getContractId().getContractId()+"合同的到账核销检测发现剩余金额超过到账金额");
			}
			//保存剩余金额
			this.tableService.saveEntity(ccri);
		}
		this.tableService.saveAllEntities(cfritList);
	}
	@SuppressWarnings("unchecked")
	public String addUploadCardHire(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		try{
		    List ccri=new ArrayList();
		    ccri=(List)this.templateService.getEntitysFromExcel(request, response);
		    saveCardHireFile(ccri);//保存实体集合
		    String message="导入成功:导入"+ccri.size()+"条";
		    return message;
		}catch(BusinessException b){
			throw new BusinessException(  "上传出错"+b.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(  "上传出错"+e.getMessage());
			
		}
		
	}
	 public String addCardHireToIncome(Map<String,String> modelData)throws Exception{
		 try {
				
				String ids=modelData.get("ids");
				String fileid=modelData.get("fileid");
				String docId=modelData.get("docid");
				List<ContractFundRentInComeTemp> cfritList=new ArrayList<ContractFundRentInComeTemp>();
				String msg="";
				List<ContractCardRentIncome> ccriList=new ArrayList<ContractCardRentIncome>();
				BaseFile bf=null;
				if(ids==null||ids.isEmpty()||"".equals(ids)){
					 bf=this.tableService.findEntityByID(BaseFile.class, fileid);
					/*Map<String, Object> propertiesMap=new HashMap<String, Object>();
					propertiesMap.put("upLoadId", bf);
					propertiesMap.put("incomeStatus", 0);*/
					
					DetachedCriteria criteria = DetachedCriteria.forClass(ContractCardRentIncome.class);
					
					criteria.add(Restrictions.eq("upLoadId", bf));
					criteria.add(Restrictions.eq("incomeStatus", 0));
					criteria.add(Restrictions.gt("lastMoney", BigDecimal.ZERO));
					
					ccriList = this.tableService.getBussinessDao().getHibernateTemplate().findByCriteria(criteria);
					
					//ccriList=this.tableService.findEntityByProperties(ContractCardRentIncome.class, propertiesMap);
				}else{
					ids=ids.substring(0, ids.length()-1);
					ccriList=this.tableService.findEntityByIDArray(ContractCardRentIncome.class, ids.split(","));
				}
				//默认为导出日期，如果手工选定了日期，则改为手动日期
				String hire_date = modelData.get("hire_date");
				if (hire_date != null) {
					for (int i = 0; i < ccriList.size(); i++) {
						ContractCardRentIncome contractCardRentIncome = ccriList.get(i);
						contractCardRentIncome.setIncomeDate(hire_date);
						this.tableService.saveOrUpdateEntity(contractCardRentIncome);
					}
				}
				if(ccriList.isEmpty()){
					return  "没有找到要核销的数据!";
				}else{
					msg=addCardHireToIncomeByList(ccriList,cfritList,docId,this.tableService.findEntityByID(BaseFile.class, fileid));
					if(cfritList.isEmpty()){
						return msg;
						//return  "根据卡扣数据在数据库进行核销操作时,未能匹配出可以核销的数据!";
					}else{
						saveIncomeList(cfritList);
					}
				}
				if(msg!=null&&!"".equals(msg)){
					return "核销已经中断原因:\n"+msg;
				}else{
					return  "核销成功!";
				}
			} catch (BusinessException e) {
				e.printStackTrace();
				return  "核销时业务逻辑性错误\n"+e.getMessage();
			} catch (Exception e) {
				e.printStackTrace();
				return  "核销过程中遇到错误\n"+e.getMessage();
			}
		 
	 }
	 public String deleteCardHireToIncomeControl(Map<String,String> modelData)throws Exception{
		 try {
				
				String ids=modelData.get("ids");
				String fileid=modelData.get("fileid");
				String docId=modelData.get("docid");
				List<ContractFundRentInComeTemp> cfritList=new ArrayList<ContractFundRentInComeTemp>();
				if(ids==null||ids.isEmpty()||"".equals(ids)){
					BaseFile bf=this.tableService.findEntityByID(BaseFile.class, fileid);
					Map<String, Object> propertiesMap=new HashMap<String, Object>();
					propertiesMap.put("upId", bf);
					propertiesMap.put("docId", docId);
					cfritList=this.tableService.findEntityByProperties(ContractFundRentInComeTemp.class, propertiesMap);
				}else{
					ids=ids.substring(0, ids.length()-1);
					cfritList=this.tableService.findEntityByIDArray(ContractFundRentInComeTemp.class, ids.split(","));
				}
				if(cfritList.isEmpty()){
					return  "可能是传入参数错误,没有找到要删除的数据!";
				}else{
					deleteCardHireToIncomeByList(cfritList);
				}
				return  "删除核销成功!";
				
			} catch (BusinessException e) {
				return  "删除核销时业务逻辑性错误\n"+e.getMessage();
			} catch (Exception e) {
				return  "删除核销过程中遇到错误\n"+e.getMessage();
			}
	 }
}
