package com.business.serviceImpl.Invoice;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.invoice.vat.TaxFundInfo;
import com.business.entity.invoice.vat.TaxRentHcInfo;
import com.business.entity.invoice.vat.TaxRentInfo;
import com.business.entity.invoice.vat.TaxRentUploadInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.Invoice.TaxRentService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.FileUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.UUIDUtil;
@Service(value="taxRentService")
public class TaxRentServiceIpml extends AbstractBaseServiceImpl implements TaxRentService {
	
	@Resource(name="fileTemplateService")
	private FileTemplateService  templateService;
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource
    private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	private String contractWordDir=ResourceUtil.getWordFilesRelativeStorePath();
	/** ( 本金一次性开具)
	 * 
	 */
	@Override
	public void submitRentCorpusOnce(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		System.out.println(idsArray[0]+"=====");
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (Object id : idsArray) {
//			1.处理租金的开票信息
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			sql = "select id from tax_rent_info where tax_type='plan' and rent_type='corpus' and contract_id=?";
			
			results = this.baseDao.queryListBySql(sql, id).size();
			if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
				sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where contract_id=?";
				this.baseDao.updateBySql(sql, user.getId(),createDate,id);
			}else{
			
				sql = "INSERT INTO TAX_RENT_INFO(ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
					"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
					"SELECT LOWER(SYS_GUID()),A.ID,A.CONTRACT_ID,A.RENT_LIST,A.PLAN_DATE,A.RENT,A.CORPUS,INTEREST,0,A.CORPUS," +
					"'plan',B.RENTINVOICETYPE,'corpus',1,?,'invoice',?,? FROM " +
					"CONTRACT_FUND_RENT_PLAN A " +
					"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
					"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
					"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
					"WHERE A.CONTRACT_ID=?";
			this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate,id);
			}
//			2.处理全金一次性开票时的首付款信息，首付款跟本金和进行绑定操作
			
			List<ContractFundFundPlan> planList = new ArrayList<ContractFundFundPlan>();
			String hsql = "from ContractFundFundPlan where contractId.id=? and feeType.id=? and invalid=?";
			planList = this.baseDao.findResultsByHSQL(hsql, id,"feetype5","0");
			System.out.println("planList="+planList.size());
			List<TaxFundInfo> list = new ArrayList<TaxFundInfo>();
			for (int j = 0; j < planList.size(); j++) {
				ContractFundFundPlan contractFundFundPlan = new ContractFundFundPlan();
				TaxFundInfo info = new TaxFundInfo();
				contractFundFundPlan = planList.get(j);
				Map<String,Object> propertiesMap2 = new HashMap<String, Object>();
				propertiesMap2.put("cffpId", contractFundFundPlan);
				List<TaxFundInfo> infoList = this.baseDao.findEntityByProperties(TaxFundInfo.class, propertiesMap2);
				System.out.println("==infoList=="+infoList.size());
				if (infoList.size()==0){
				info.setCffpId(contractFundFundPlan);
				info.setInvoiceStatus(1);
				info.setPlanMoney(contractFundFundPlan.getPlanMoney());
				info.setPlanDate(contractFundFundPlan.getPlanDate());
				info.setPayObj(contractFundFundPlan.getPayObj());
				info.setPayType(contractFundFundPlan.getPayType());
				info.setOutNo(serialNumber);
				info.setCreator(user);
				info.setCreateDate(createDate);
				}else{
				info = 	infoList.get(0);
				info.setInvoiceStatus(1);
				}
				list.add(info);
				
			}
			this.baseDao.saveOrUpdateAllEntities(list);
			
		}
	}
	/** (non-Javadoc) 租金计划生成开票清单 提交
	 * @see com.business.service.Invoice.TaxRentService#submitRentPlan(java.util.Map)
	 */
	@Override
	public void submitRentPlan(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]+"=====");
		System.out.println(typeArray[0]+"=====");
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			sql = "select id from tax_rent_info where tax_type = 'plan' and cfrp_id=? and rent_type=? ";
			
			results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
			if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
				sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and cfrp_id=? and rent_type=?";
				this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i],typeArray[i]);
			}else{
				if(null!=typeArray[i]&&!"".equals(typeArray[i])){
					sql = "INSERT INTO TAX_RENT_INFO(ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
					"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
					"SELECT LOWER(SYS_GUID()),A.ID,A.CONTRACT_ID,A.RENT_LIST,A.PLAN_DATE,A.RENT,A.CORPUS,A.INTEREST,0,A."+typeArray[i]+", "+
					"'plan',B.RENTINVOICETYPE,'"+typeArray[i]+"',1,?,'invoice',?,? FROM " +
					"CONTRACT_FUND_RENT_PLAN A " +
					"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
					"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
					"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
					"WHERE A.ID=?";
				
				this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate,idsArray[i]);
			}
			}		
		}
	}
	/* (non-Javadoc) 租金计划生成开票清单（收据） 提交
	 * @see com.business.service.Invoice.TaxRentService#submitRentPlan(java.util.Map)
	 */
	@Override
	public void submitRentPlanReceipt(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]+"=====");
		System.out.println(typeArray[0]+"=====");
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			if("0".equals(typeArray[i])){//本金收据一次性开具
				sql = "select id from tax_rent_info where tax_type = 'plan' and contract_id=? and rent_type=? ";
				results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
				if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
					sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and contract_id=? and rent_type=?";
				}else{
					if(null!=typeArray[i]&&!"".equals(typeArray[i])){
						sql = "INSERT INTO TAX_RENT_INFO(ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
						"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
						"SELECT LOWER(SYS_GUID()),A.ID,A.CONTRACT_ID,A.RENT_LIST,A.PLAN_DATE,A.RENT,A.CORPUS,A.INTEREST,0,A.CORPUS, "+
						"'plan',B.RENTINVOICETYPE,'corpus',1,?,'receipt',?,? FROM " +
						"CONTRACT_FUND_RENT_PLAN A " +
						"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
						"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
						"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
						"WHERE A.CONTRACT_ID=?";
					}
				}		
				System.out.println("sql=="+sql);
				this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate, idsArray[i]);
			}else{//每期单独开本金收据
				sql = "select id from tax_rent_info where tax_type = 'plan' and cfrp_id=? and rent_type=? ";
				results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
				if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
					sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and cfrp_id=? and rent_type=?";
				}else{
					if(null!=typeArray[i]&&!"".equals(typeArray[i])){
						sql = "INSERT INTO TAX_RENT_INFO(ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
						"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
						"SELECT LOWER(SYS_GUID()),A.ID,A.CONTRACT_ID,A.RENT_LIST,A.PLAN_DATE,A.RENT,A.CORPUS,A.INTEREST,0,A.corpus, "+
						"'plan',B.RENTINVOICETYPE,'corpus',1,?,'receipt',?,? FROM " +
						"CONTRACT_FUND_RENT_PLAN A " +
						"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
						"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
						"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
						"WHERE A.ID=?";
					}
				}
				System.out.println("sql=="+sql);
				this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate, idsArray[i]);
				
			}
		}
	}
	/* (non-Javadoc) 租金计划确认 退回
	 * @see com.business.service.Invoice.TaxRentService#backRentPlan(java.util.Map)
	 */
	@Override
	public void backRentPlan(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]+"=====");
		System.out.println(typeArray[0]+"=====");
		String sql ="";
		String sql2 = "";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			if("0".equals(typeArray[i])){//0表示本金一次性开具，要批量更新该合同编号下面的所有计划
				sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and rent_type='corpus' and contract_id=?";
				//处理本金一次性开具中的的首付款退回问题
				/* 增加invalid='0'的判断 资金计划为不作废的   
				 * @author Rovine
                 * @date 2013-12-14
				 */
				sql2 = "update tax_fund_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where cffp_id in " +
						"(select id from contract_fund_fund_plan where contract_id=? and fee_type='feetype5'and invalid='0')";
				this.baseDao.updateBySql(sql2, user.getId(),createDate,idsArray[i]);
			}else{
				sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			}
			this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i]);
		}
	}
	/* (non-Javadoc) 租金计划确认（收据） 退回
	 * @see com.business.service.Invoice.TaxRentService#backRentPlan(java.util.Map)
	 */
	@Override
	public void backRentPlanReceipt(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		String sql ="";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			if("0".equals(typeArray[i])){//0表示本金一次性开具，要批量更新该合同编号下面的所有计划
				sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and rent_type='corpus' and contract_id=?";
			}else{
				sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			}
			
			this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i]);
		}
	}
	/* (non-Javadoc) 租金计划导出更新状态
	 * @see com.business.service.Invoice.TaxRentService#backRentPlan(java.util.Map)
	 */
	@Override
	public void updateRentPlanStatus(Map<String, String> model) throws Exception {
		List<String> lists = new ArrayList<String>();
		String[] idsArray = model.get("ids").split(",");
		for (String ids : idsArray) {
			lists.add(ids.substring(1, ids.length()-1));
		}
		String[] typeArray = model.get("typnames").split(",");
		String sql ="";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<lists.size();i++) {
			if("0".equals(typeArray[i])){//0表示本金一次性开具，要批量更新该合同编号下面的所有计划
				sql = "update  tax_rent_info set invoice_status=2,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'plan' and rent_type='corpus' and contract_id=?";
			}else{
				sql = "update  tax_rent_info set invoice_status=2,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			}
			
			this.baseDao.updateBySql(sql, user.getId(),createDate,lists.get(i));
		}
	}
	
	/* (non-Javadoc)租金实收 生成开票清单
	 * @see com.business.service.Invoice.TaxRentService#submitRentIncome(java.util.Map)
	 */
	@Override
	public void submitRentIncome(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]+"");
		System.out.println(typeArray[0]+"=====");
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			sql = "select id from tax_rent_info where tax_type = 'income' and cfri_id=? and rent_type=? ";
			results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
			if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
				sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'income' and cfri_id=? and rent_type=? ";
				this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i],typeArray[i]);
			}else{
				if(null!=typeArray[i]&&!"".equals(typeArray[i])){
					sql = "INSERT INTO TAX_RENT_INFO(ID,CFRI_ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
					"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
					"SELECT LOWER(SYS_GUID()),A.ID,A.PLAN_ID,A.CONTRACT_ID,A.PLAN_LIST,A.HIRE_DATE,A.RENT,A.CORPUS,A.INTEREST,A.PENALTY,A."+typeArray[i]+"," +
					"'income',B.RENTINVOICETYPE,'"+typeArray[i]+"',1,?,'invoice',?,? FROM " +
					"CONTRACT_FUND_RENT_INCOME A " +
					"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
					"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
					"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
					"WHERE A.ID=?";
					System.out.println("sql="+sql);
				this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate,idsArray[i]);
				}	
			}
		}
	}
	/* (non-Javadoc)租金实收 生成开票清单（收据）
	 * @see com.business.service.Invoice.TaxRentService#submitRentIncome(java.util.Map)
	 */
	@Override
	public void submitRentIncomeReceipt(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]+"");
		System.out.println(typeArray[0]+"=====");
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			sql = "select id from tax_rent_info where tax_type = 'income' and cfri_id=? and rent_type=? ";
			results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
			if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
				sql = "update  tax_rent_info set invoice_status=1,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'income' and cfri_id=? and rent_type=? ";
				this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i],typeArray[i]);
			}else{
				if(null!=typeArray[i]&&!"".equals(typeArray[i])){
					sql = "INSERT INTO TAX_RENT_INFO(ID,CFRI_ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
					"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
					"SELECT LOWER(SYS_GUID()),A.ID,A.PLAN_ID,A.CONTRACT_ID,A.PLAN_LIST,A.HIRE_DATE,A.RENT,A.CORPUS,A.INTEREST,A.PENALTY,A.CORPUS," +
					"'income',B.RENTINVOICETYPE,'corpus',1,?,'receipt',?,? FROM " +
					"CONTRACT_FUND_RENT_INCOME A " +
					"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
					"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
					"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
					"WHERE A.ID=?";
					System.out.println("sql="+sql);
					this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate,idsArray[i]);
				}	
			}
		}
	}
	/* (non-Javadoc)租金实收  不生成开票清单
	 * @see com.business.service.Invoice.TaxRentService#removeRentIncome(java.util.Map)
	 */
	@Override
	public void removeRentIncome(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] typeArray = model.get("typnames").split(",");
		System.out.println(idsArray[0]);
		System.out.println(typeArray[0]);
		String sql ="";
		int results = 0;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			String serialNumber = WorkflowUtil.getRentInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
			sql = "select id from tax_rent_info where tax_type = 'income' and cfri_id=? and rent_type=? ";
			
			results = this.baseDao.queryListBySql(sql, idsArray[i],typeArray[i]).size();
			if(results>0){//结果大于0，表中已存在，只更新状态。说明是已退回的数据
				sql = "update  tax_rent_info set invoice_status=0,MODIFICATOR_=?,MODIFY_DATE=? where tax_type = 'income' and cfri_id=? and rent_type=?";
				this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i],typeArray[i]);
			}else{
				if(null!=typeArray[i]&&!"".equals(typeArray[i])){
					sql = "INSERT INTO TAX_RENT_INFO(ID,CFRI_ID,CFRP_ID,CONTRACT_ID,RENT_LIST,PLAN_DATE,RENT,CORPUS,INTEREST,PENALTY,INVOICE_MONEY," +
					"TAX_TYPE,RENT_INVOICE_TYPE,RENT_TYPE,INVOICE_STATUS,OUT_NO,OPERATE_TYPE,CREATOR_,CREATE_DATE) " +
					"SELECT LOWER(SYS_GUID()),A.ID,A.PLAN_ID,A.CONTRACT_ID,A.PLAN_LIST,A.HIRE_DATE,A.RENT,A.CORPUS,A.INTEREST,A.PENALTY,A."+typeArray[i]+"," +
					"'income',B.RENTINVOICETYPE,'"+typeArray[i]+"',0,?,'invoice',?,? FROM " +
					"CONTRACT_FUND_RENT_INCOME A " +
					"LEFT JOIN CONTRACT_INVOICE_TYPE B ON A.CONTRACT_ID=B.CONTRACT_ID " +
					"LEFT JOIN CONTRACT_INFO CI ON CI.ID=A.CONTRACT_ID " +
					"LEFT JOIN CUST_INFO_COMPANY CIC ON CIC.CUST_ID = CI.CUST_ID " +
					"WHERE A.ID=?";
					System.out.println("sql="+sql);
				this.baseDao.updateBySql(sql, serialNumber,user.getId(),createDate,idsArray[i]);
				}	
			}
		}
	}

	/* (non-Javadoc) 租金实收确认 退回
	 * @see com.business.service.Invoice.TaxRentService#backRentIncome(java.util.Map)
	 */
	@Override
	public void backRentIncome(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		System.out.println(idsArray[0]+"=====");
		String sql ="";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
				sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i]);
		}
	}
	/* (non-Javadoc) 租金实收确认（收据） 退回
	 * @see com.business.service.Invoice.TaxRentService#backRentIncome(java.util.Map)
	 */
	@Override
	public void backRentIncomeReceipt(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		System.out.println(idsArray[0]+"=====");
		String sql ="";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			sql = "update  tax_rent_info set invoice_status=3,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i]);
		}
	}
	
	/* (non-Javadoc) 租金实收确认（收据）确认，修改状态为已确认
	 * @see com.business.service.Invoice.TaxRentService#backRentIncome(java.util.Map)
	 */
	@Override
	public void confirmRentIncomeReceipt(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String sql ="";
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i = 0 ;i<idsArray.length;i++) {
			sql = "update  tax_rent_info set invoice_status=4,MODIFICATOR_=?,MODIFY_DATE=? where id=?";
			this.baseDao.updateBySql(sql, user.getId(),createDate,idsArray[i]);
		}
	}
	
	/* (non-Javadoc) 租金实收导出更新状态
	 * @see com.business.service.Invoice.TaxRentService#backRentIncome(java.util.Map)
	 */
	@Override
	public void updateRentIncomestatus(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		User user = (User) SecurityUtil.getPrincipal();
		String date=DateUtil.getSystemDateTime();
		List<TaxRentInfo>  taxlist=new ArrayList<TaxRentInfo>();
		for (String id : idsArray) {
			String uid=id.replaceAll("\'", "").replaceAll("\"", "");
			TaxRentInfo tax=this.tableService.findEntityByID(TaxRentInfo.class,uid);
			tax.setInvoiceStatus(2);
			tax.setModificator(user);
			tax.setModifyDate(date);
			taxlist.add(tax);
		}
		this.tableService.saveAllEntities(taxlist);
	}
	
	/* (non-Javadoc)租金发票红冲
	 * @see com.business.service.Invoice.TaxRentService#addTaxRentHcInfoInvoice(java.util.Map)
	 */
	@Override
	public void addTaxRentHcInfoInvoice(Map<String, String> model) throws Exception{
		if(!model.isEmpty()){
			//id_invoiceno 发票号
			//id_taxtype 费用类型
			///id_taxtmoney 金额
			//id_invoicehcno 专用发票红冲通知单号
			//id_invoicehcdate 红冲日期
			//上传编号
			String id               =  model.get("id");
			//發票紅沖通知單號
			String id_invoicehcno   =  model.get("id_invoicehcno");
			//紅沖日期
			String id_invoicehcdate =  model.get("id_invoicehcdate");
			if(null != id && !"".equals(id)){
				TaxRentHcInfo taxrenthcinfo = new TaxRentHcInfo();
				taxrenthcinfo.setCreateDate(DateUtil.getSystemDate());
				User user = (User) SecurityUtil.getPrincipal();
				taxrenthcinfo.setCreator(user);
				taxrenthcinfo.setInvoiceHcDate(id_invoicehcdate);
				taxrenthcinfo.setInvoiceHcNo(id_invoicehcno);
				taxrenthcinfo.setModifyDate(DateUtil.getSystemDate());
				taxrenthcinfo.setModificator(user);
				TaxRentUploadInfo taxrentuploadinfo = this.baseDao.findEntityByID(TaxRentUploadInfo.class, id);
				String hsql = " update TaxRentUploadInfo trui set trui.hcStatus=? where 1=1 and trui.id=?";
				//红冲状态1 代表已经红冲 2代表红冲发票
				this.baseDao.updateByHSQL(hsql, "1",id);
				taxrenthcinfo.setTaxRentUpId(taxrentuploadinfo);
				//红冲表增加一条记录
				this.baseDao.saveEntity(taxrenthcinfo);
		
				TaxRentUploadInfo taxrentuploadinfo2 = new TaxRentUploadInfo();
				taxrentuploadinfo2 = this.baseDao.copyAndOverrideExistedValueFromObject(taxrentuploadinfo, taxrentuploadinfo2);
				//资金发票信息 加入一条一模一样的数据 发票状态改为 已红冲  金额变成负数
				taxrentuploadinfo2.setId(UUIDUtil.getUUID());
				taxrentuploadinfo2.setHcStatus("2");
				if(taxrentuploadinfo2.getTaxMoney()!=null){
			         BigDecimal b1 = new BigDecimal(-1);
			         taxrentuploadinfo2.setInvoiceMoney(b1.multiply(taxrentuploadinfo2.getInvoiceMoney()));
				}
				this.baseDao.saveEntity(taxrentuploadinfo2);
			}
		}
	}
	@Override
	public String updateExpTaxRentInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String returnType=model.get("returnType");
		BaseFile bf=this.templateService.createFileByTemplateClass(model);
		if(returnType.equalsIgnoreCase("file")){
			this.templateService.addlogFileOper(bf, "下载");
			String browserType = model.get("browserType");
			String fileTitleName=bf.getFileName();
			if("firefox".equals(browserType))
			   {
				  fileTitleName = new String(fileTitleName.getBytes("GB2312"),"ISO-8859-1");
			   }
			   else if("chrome".equals(browserType))
			   {
				   fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
			   }
			   else if("safari".equals(browserType))
			   {
				   fileTitleName = new String(fileTitleName.getBytes("UTF-8"),"ISO-8859-1");
			   }
			   else 
			   {
				   fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
			   }
			   String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath())+this.contractWordDir;
			   String downloadedFileFullPath=uploadDirPath+"/"+bf.getFileRealAddress();
			   downloadedFileFullPath=FileUtil.getFilePathString(downloadedFileFullPath);
			   response.reset();
			   response.setHeader("Content-disposition","attachment; filename="+fileTitleName);
			   response.setContentType("text/html; charset=UTF-8");
			   OutputStream      out  = response.getOutputStream();
			   ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
			}else{
		      List temp=new ArrayList();
		      temp.add(bf);
		      Map<String,String> fieldClassMapping=new HashMap<String,String>();
		      fieldClassMapping.put("DictionaryData", "code");
			  fieldClassMapping.put("FileTemplate", "id");
		    return this.baseService.getCollectionEntitiesPropertiesToJsonArrayString(temp, fieldClassMapping);
		}
		return null;
	}
}
