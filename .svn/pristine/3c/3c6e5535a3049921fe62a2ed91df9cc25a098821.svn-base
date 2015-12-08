package com.business.serviceImpl.Invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.invoice.vat.TaxFundHcInfo;
import com.business.entity.invoice.vat.TaxFundInfo;
import com.business.entity.invoice.vat.TaxFundUploadInfo;
import com.business.service.TableService;
import com.business.service.Invoice.TaxFundService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.UUIDUtil;
@Service(value="taxFundService")
public class TaxFundServiceIpml extends AbstractBaseServiceImpl implements TaxFundService {

	@Resource
    private BaseDao baseDao;
	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	
	@Override
	public void submitFundPlanInvoice(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		List<TaxFundInfo> list = new ArrayList<TaxFundInfo>();
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		Map<String,Object> propertiesMap = new HashMap<String, Object>();
		for (String id : idsArray) {
			String serialNumber = "PF"+WorkflowUtil.getFundInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate()); 
			ContractFundFundPlan contractFundFundPlan = new ContractFundFundPlan();
			TaxFundInfo info = new TaxFundInfo();
			contractFundFundPlan = this.tableService.findEntityByID(ContractFundFundPlan.class, id);
			propertiesMap.put("cffpId", contractFundFundPlan);
			List<TaxFundInfo> infoList = this.tableService.findEntityByProperties(TaxFundInfo.class, propertiesMap);
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
	/* (non-Javadoc)回退资金计划开票清单
	 * @see com.business.service.Invoice.TaxFundService#backFundPlanInvoice(java.util.Map)
	 */
	@Override
	public void backFundPlanInvoice(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		User user = (User) SecurityUtil.getPrincipal();
		String  hsql = "update TaxFundInfo set invoiceStatus = '3',modificator=?,modifyDate='"+ DateUtil.getSystemDateTime()+"'  where id =?"; 
		for (String id : idsArray) {
			this.baseDao.updateByHSQL(hsql,user, id);
		}
	}
	
	/* (non-Javadoc)资金开票状态更新
	 * @see com.business.service.Invoice.TaxFundService#backFundPlanInvoice(java.util.Map)
	 */
	@Override
	public void updateFundstatus(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		
		User user = (User) SecurityUtil.getPrincipal();
		String date=DateUtil.getSystemDateTime();
		//String  hsql = "update TaxFundInfo set invoiceStatus = '2',modificator=?,modifyDate='"+ DateUtil.getSystemDateTime()+"'  where id =?"; 
		List<TaxFundInfo>  taxlist=new ArrayList<TaxFundInfo>();
		for (String id : idsArray) {
			String uid=id.replaceAll("\'", "").replaceAll("\"", "");
			TaxFundInfo tax=this.tableService.findEntityByID(TaxFundInfo.class,uid);
			tax.setInvoiceStatus(2);
			tax.setModificator(user);
			tax.setModifyDate(date);
			taxlist.add(tax);
		}
		this.tableService.saveAllEntities(taxlist);
	}
	/* (non-Javadoc)提交资金计划开票清单
	 * @see com.business.service.Invoice.TaxFundService#backFundPlanInvoice(java.util.Map)
	 */
	@Override
	public void submitFundChargeInvoice(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] paymentidsArray = model.get("paymentids").split(",");
		List<TaxFundInfo> list = new ArrayList<TaxFundInfo>();
		User user = (User) SecurityUtil.getPrincipal();
		String serialNumber = "F"+WorkflowUtil.getFundInvoiceSerialNumber(model, this.baseDao.getHibernateTemplate(), this.baseDao.getJdbcTemplate());
		String createDate = DateUtil.getSystemDateTime();
		System.out.println("idsArray="+idsArray);
		System.out.println("paymentidsArray="+paymentidsArray);
		for (int i=0;i<idsArray.length;i++) {
			ContractFundFundPlan contractFundFundPlan = new ContractFundFundPlan();
			ContractFundFundCharge contractFundFundCharge = new ContractFundFundCharge();
			TaxFundInfo info = new TaxFundInfo();
			
			contractFundFundPlan = this.tableService.findEntityByID(ContractFundFundPlan.class, paymentidsArray[i]);
			contractFundFundCharge = this.tableService.findEntityByID(ContractFundFundCharge.class, idsArray[i]);
			info.setCffpId(contractFundFundPlan);
			info.setCffcId(contractFundFundCharge);
			info.setPlanMoney(contractFundFundPlan.getPlanMoney());
			info.setPlanDate(contractFundFundPlan.getPlanDate());
			info.setPayObj(contractFundFundPlan.getPayObj());
			info.setPayType(contractFundFundPlan.getPayType());
			info.setFactMoney(contractFundFundCharge.getFactMoney());
			info.setFactDate(contractFundFundCharge.getFactDate());
			info.setOutNo(serialNumber);
			info.setInvoiceStatus(1);
			info.setCreator(user);
			info.setCreateDate(createDate);
			list.add(info);
		}
			this.baseDao.saveAllEntities(list);
	}
	/* (non-Javadoc)不生成资金计划开票清单
	 * @see com.business.service.Invoice.TaxFundService#backFundPlanInvoice(java.util.Map)
	 */
	@Override
	public void removeFundChargeInvoice(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		String[] paymentidsArray = model.get("paymentids").split(",");
		System.out.println("taxidArray="+model.get("taxid").split(","));
		String[] taxidArray = model.get("taxid").split(",");
		List<TaxFundInfo> list = new ArrayList<TaxFundInfo>();
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (int i=0;i<idsArray.length;i++) {
			ContractFundFundPlan contractFundFundPlan = new ContractFundFundPlan();
			ContractFundFundCharge contractFundFundCharge = new ContractFundFundCharge();
			TaxFundInfo info = new TaxFundInfo();
			contractFundFundCharge.setId(idsArray[i]);
			contractFundFundPlan.setId(paymentidsArray[i]);
			info.setCffpId(contractFundFundPlan);
			info.setCffcId(contractFundFundCharge);
			info.setInvoiceStatus(0);
			info.setCreator(user);
			if (!"null".equals(taxidArray[i]))//SQL中对没有记录的赋了个'null'字符串值,由此判断是否插入还是更新
			{
			info.setId(taxidArray[i]);
			}
			info.setCreateDate(createDate);
			list.add(info);
		}
		this.baseDao.saveOrUpdateAllEntities(list);
	}
	/* (non-Javadoc)不生成资金计划开票清单
	 * @see com.business.service.Invoice.TaxFundService#backFundPlanInvoice(java.util.Map)
	 */
	@Override
	public void backFundChargeInvoice(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		User user = (User) SecurityUtil.getPrincipal();
		String  hsql = "update TaxFundInfo set invoiceStatus = '3',modificator=?,modifyDate='"+ DateUtil.getSystemDateTime()+"'  where id =?"; 
		for (String id : idsArray) {
			this.baseDao.updateByHSQL(hsql,user, id);
		}
	}
	@Override
	public void addTaxFundHcInfoInvoice(Map<String, String> model) throws Exception{
		if(!model.isEmpty()){
			//上传编号
			String id               =  model.get("id");
			//發票紅沖通知單號
			String id_invoicehcno   =  model.get("id_invoicehcno");
			//紅沖日期
			String id_invoicehcdate =  model.get("id_invoicehcdate");
			if(null != id && !"".equals(id)){
				TaxFundHcInfo taxfundhcinfo = new TaxFundHcInfo();
				taxfundhcinfo.setCreateDate(DateUtil.getSystemDate());
				User user = (User) SecurityUtil.getPrincipal();
				taxfundhcinfo.setCreator(user);
				taxfundhcinfo.setInvoiceHcDate(id_invoicehcdate);
				taxfundhcinfo.setInvoiceHcNo(id_invoicehcno);
				taxfundhcinfo.setModifyDate(DateUtil.getSystemDate());
				taxfundhcinfo.setModificator(user);
				TaxFundUploadInfo taxfunduploadinfo = this.baseDao.findEntityByID(TaxFundUploadInfo.class, id);
				String hsql = " update TaxFundUploadInfo tfui set tfui.hcStatus=? where 1=1 and tfui.id=?";
				//红冲状态1 代表已经红冲 2代表红冲发票
				this.baseDao.updateByHSQL(hsql, "1",id);
				taxfundhcinfo.setTaxFundUpId(taxfunduploadinfo);
				//红冲表增加一条记录
				this.baseDao.saveEntity(taxfundhcinfo);
		
				TaxFundUploadInfo taxfunduploadinfo2 = new TaxFundUploadInfo();
				taxfunduploadinfo2 = this.baseDao.copyAndOverrideExistedValueFromObject(taxfunduploadinfo, taxfunduploadinfo2);
				//资金发票信息 加入一条一模一样的数据 发票状态改为 已红冲  金额变成负数
				taxfunduploadinfo2.setId(UUIDUtil.getUUID());
				taxfunduploadinfo2.setHcStatus("2");
				if(taxfunduploadinfo2.getCorpusTaxMoney()!=null){
			         BigDecimal b1 = new BigDecimal(-1);
					taxfunduploadinfo2.setCorpusTaxMoney(b1.multiply(taxfunduploadinfo2.getCorpusTaxMoney()));
				}
				this.baseDao.saveEntity(taxfunduploadinfo2);
			}
		}
	}


	

}
