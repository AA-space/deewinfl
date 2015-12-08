package com.business.serviceImpl.penalty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentPenaltyPlanHis;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.service.TableService;
import com.business.service.penalty.PenaltyService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.PenaltyUtil;
import com.kernal.utils.DateUtil;
@Service(value="penaltyService")
public class PenaltyServiceImpl extends AbstractBaseServiceImpl implements PenaltyService{
	@Resource
	private BaseDao baseDao;
	
	@Resource(name="tableService")
	private TableService tableService;

	@Override
	public BaseDao getBussinessDao() throws Exception {
		
		return baseDao;
	}

	@Override
	/**
	 * 根据客户初始化客户下的所有合同的的租金计划的罚息
	 * 
	 */
	public void updatePeanltyByCustId(CustInfo cust) throws Exception {
		 String HSQL="from ContractInfo c where c.custId=? ";
	      List<ContractInfo> contracts=this.tableService.findResultsByHSQL(HSQL, cust);
	      for(ContractInfo contract: contracts){
	    	  this.updatePenaltyByContractid(contract);
	      }
		
	}

	@Override
	/**
	 * 初初始化合同下所的租金计划的罚息
	 * 
	 */
	public void updatePenalty() throws Exception {
		  String HSQL="from ContractInfo c ";
	      List<ContractInfo> contracts=this.tableService.findResultsByHSQL(HSQL);
	      for(ContractInfo contract: contracts){
	    	  this.updatePenaltyByContractid(contract);
	      }
	}

	@Override
	/**
	 * 根据合同计划更新合同下面的租金计划的罚息 
	 * 参数据，合同
	 * 
	 */
	public void updatePenaltyByContractid(ContractInfo contract) throws Exception {
		try {
			ContractCondition condition=contract.getContractCondition();
			String systemDate = DateUtil.getSystemDateTime();
			boolean isWithUser = true;
			User user = null;
			try {
				user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			} catch (Exception e) {
				isWithUser = false;
			}
			
			String cur_date=DateUtil.getSystemDate();
			int freeData=0;
			BigDecimal penaltyRate=new BigDecimal(0.00);
			try {
				if(null!=condition.getFreeDefaInterDay()&&condition.getFreeDefaInterDay()>0){
					freeData=condition.getFreeDefaInterDay();
				}
				if(null!=condition.getPenaRate() &&condition.getPenaRate().intValue()>0){
					 penaltyRate=condition.getPenaRate();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				penaltyRate=new BigDecimal(0.00);
			}
			if(penaltyRate.intValue()>0){
			BigDecimal overPenalty=new BigDecimal(0.00);
			BigDecimal incomePenalty=new BigDecimal(0.00);
			Set<ContractFundRentPlan> fundrentplan= contract.getContractFundRentPlans();
			String HSQL="FROM ContractFundRentPenaltyPlanHis CH WHERE CH.contractId=? and CH.rentList=? and CH.createDate>'"+cur_date+"'";
			if(null!=fundrentplan&&fundrentplan.size()>0){
				for(ContractFundRentPlan rent:fundrentplan){
					overPenalty=new BigDecimal(0.00);
					incomePenalty=new BigDecimal(0.00);
					List<BigDecimal> penalty=PenaltyUtil.getRentPenalty(rent, cur_date, penaltyRate, freeData,true);
					overPenalty=penalty.get(0);
					incomePenalty=penalty.get(1);
					if(overPenalty.intValue()>0){
						rent.setPenalty(overPenalty.add(incomePenalty).setScale(2, BigDecimal.ROUND_HALF_UP));
						rent.setPenaltyOverage(overPenalty);
						this.tableService.saveOrUpdateEntity(rent);
						ContractFundRentPenaltyPlanHis his=new ContractFundRentPenaltyPlanHis();
						his.setContractId(rent.getContractId());
						his.setRent(rent.getRent());
						his.setCorpus(rent.getCorpus());
						his.setInterest(rent.getInterest());
						his.setRentList(rent.getRentList());
						his.setPlanDate(rent.getPlanDate());
						his.setPenalty(rent.getPenalty());
						his.setPenaltyOverage(rent.getPenaltyOverage());
						if(isWithUser==true){
							his.setCreator(user);
							his.setCreateDate(systemDate);
						}
						List<ContractFundRentPenaltyPlanHis> listhis=this.tableService.findResultsByHSQL(HSQL, his.getContractId(),his.getRentList());
						this.tableService.removeAllEntites(listhis);
						this.tableService.saveOrUpdateEntity(his);
					}
				}
			}}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 根据经销商初始化经销商下的所有合同的的租金计划的罚息
	 * 
	 */
	public void updatePenaltyByDistributor(CustInfo cust) throws Exception {
	      String HSQL="from ContractInfo c where c.custDealer=? ";
	      List<ContractInfo> contracts=this.tableService.findResultsByHSQL(HSQL, cust);
	      for(ContractInfo contract: contracts){
	    	  this.updatePenaltyByContractid(contract);
	      }
		
	}


}
