package com.business.serviceImpl.Invoice;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.invoice.vat.TaxVatInfo;
import com.business.service.Invoice.TaxVatService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
@Service(value="taxVatService")
public class TaxVatServiceIpml extends AbstractBaseServiceImpl implements TaxVatService {

	@Resource
    private BaseDao baseDao;
	public User user ;
	
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	
	/* (non-Javadoc) 新建合同未采购清》进项发票
	 * @see com.business.service.Invoice.TaxVatService#addTaxVatInfo(java.util.Map)
	 */
	@Override
	public void addTaxVatInfo(Map<String, String> model) throws Exception {
		TaxVatInfo info = new TaxVatInfo();
		ContractInfo contractInfo = new ContractInfo();
		contractInfo.setId(model.get("id"));
		model.remove("contractid");
		model.remove("id");
		this.copyAndOverrideExistedValueFromStringMap(model,info,null);
		info.setContractId(contractInfo);
		info.setInvoiceStatus(0);//发票初始状态赋值0
		this.saveEntity(info);	
	}
	
	/* (non-Javadoc) 修改进项发票
	 * @see com.business.service.Invoice.TaxVatService#updateTaxVatInfo(java.util.Map)
	 */
	@Override
	public void updateTaxVatInfo(Map<String, String> model) throws Exception {
		TaxVatInfo info = new TaxVatInfo();
		info= this.baseDao.findEntityByID(TaxVatInfo.class, model.get("id"));
		model.remove("contractid");
		this.copyAndOverrideExistedValueFromStringMap(model,info,null);
		this.updateEntity(info);	
	}
	
	/* (non-Javadoc)进项发票登记》提交
	 * @see com.business.service.Invoice.TaxVatService#submitTaxVatInfo(java.util.Map)
	 */
	@Override
	public void submitTaxVatInfo(Map<String, String> model) throws Exception {
		String[] idsArray = model.get("ids").split(",");
		User user = (User) SecurityUtil.getPrincipal();
		String  hsql = "update TaxVatInfo set invoiceStatus = '1',modificator=?,modifyDate=? where id =?"; 
		for (String id : idsArray) {
			this.baseDao.updateByHSQL(hsql,user,DateUtil.getSystemDateTime(), id);
		}
	}
	/* (non-Javadoc)进项发票确认
	 * @see com.business.service.Invoice.TaxVatService#confirmTaxVatInfo(java.util.Map)
	 */
	@Override
	public void confirmTaxVatInfo(Map<String, String> model) throws Exception {
		User user = (User) SecurityUtil.getPrincipal();
		String[] idsArray = model.get("ids").split(",");
		String  hsql = "update TaxVatInfo set invoiceStatus = '2',modificator=?,modifyDate='"+ DateUtil.getSystemDateTime()+"'  where id =?"; 
		for (String id : idsArray) {
			this.baseDao.updateByHSQL(hsql,user, id);
		}
	}
	/* (non-Javadoc)进项发票退回
	 * @see com.business.service.Invoice.TaxVatService#backTaxVatInfo(java.util.Map)
	 */
	@Override
	public void backTaxVatInfo(Map<String, String> model) throws Exception {
		User user = (User) SecurityUtil.getPrincipal();
		String[] idsArray = model.get("ids").split(",");
		String  hsql = "update TaxVatInfo set invoiceStatus = '3',modificator=?,modifyDate='"+ DateUtil.getSystemDateTime()+"'  where id =?"; 
		for (String id : idsArray) {
			System.out.println("222"+hsql);
			this.baseDao.updateByHSQL(hsql, id);
		}
	}
	

}
