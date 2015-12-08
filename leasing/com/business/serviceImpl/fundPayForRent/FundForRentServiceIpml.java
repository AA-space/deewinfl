package com.business.serviceImpl.fundPayForRent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.contract.fund.ContractFundFundPayCollect;
import com.business.entity.contract.fund.ContractFundFundPayForRent;
import com.business.entity.cust.CustInfo;
import com.business.service.TableService;
import com.business.service.fundPayForRent.FundForRentService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
@Service(value="fundForRentService")
public class FundForRentServiceIpml extends AbstractBaseServiceImpl implements FundForRentService {

	@Resource
    private BaseDao baseDao;
	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	@Override
	public void submitFundForRent(Map<String, String> model) throws Exception {
		//导出数据参数
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("ids",(String) model.get("ids"));
		JSONArray exportdata=this.tableService.getJsonArrayData("eleasing/jsp/fund_exprot_for_rent/paymentdownsubmit.xml", queryMainObjectMap);
		User uu=SecurityUtil.getPrincipal();
		String curdate=DateUtil.getSystemDate();
		List<ContractFundFundPayForRent> infos=new ArrayList<ContractFundFundPayForRent>();//(List<ContractFundFundPayForRent>) this.tableService.getEntitiesByJSONArrayString(ContractFundFundPayForRent.class, exportdata.toString(), dictDataClassMapping, "");
		for (int i = 0; i < exportdata.length(); i++) {
			JSONObject jsonObj = exportdata.getJSONObject(i);
			ContractFundFundPayForRent cp=new ContractFundFundPayForRent();
			cp.setClientAccnumber(jsonObj.getString("clientaccnumber"));
			cp.setClientAccount(jsonObj.getString("clientaccount"));
			cp.setClientBank(jsonObj.getString("clientbank"));
			cp.setPlanMoney(new BigDecimal(jsonObj.getString("planmoney")));
			cp.setCreditMoney(new BigDecimal(jsonObj.getString("creditmoney")));
			cp.setEquipcount(jsonObj.getInt("equipcount"));
			cp.setPlanDate(jsonObj.getString("plandate"));
			cp.setAllcustname(jsonObj.getString("custname"));
			cp.setAllcontractnum(jsonObj.getString("contracnum"));
			cp.setCreateDate(curdate);
			cp.setCreator(uu);
			//经销商
			CustInfo cd=this.tableService.findEntityByID(CustInfo.class, jsonObj.getString("custid"));
			cp.setCustId(cd);
			
			infos.add(cp);
		}
		this.tableService.saveOrUpdateAllEntities(infos);
		
		String[] idarr= model.get("ids").replaceAll("'", "").split(",");
		List<ContractFundFundPayCollect> listinfos =this.tableService.findEntityByIDArray(ContractFundFundPayCollect.class, idarr);
		for (ContractFundFundPayCollect cp:listinfos){
			cp.setExportFlag(1);
		}
		this.tableService.saveOrUpdateAllEntities(listinfos);
	}
	
	@Override
	public void submitFundForRentManager(Map<String, String> model) throws Exception {
		ContractFundFundPayForRent cp=this.tableService.findEntityByID(ContractFundFundPayForRent.class, model.get("id"));
		cp.setDeduMoney(new BigDecimal(model.get("dedu_money")));
		cp.setInvalid("已提交");
		this.tableService.saveOrUpdateEntity(cp);
	}
	
	@Override
	public void updateFundForRentManager(Map<String, String> model) throws Exception {
		String[] cfid=model.get("ids").split(",");
		List<ContractFundFundPayForRent> cplist=this.tableService.findEntityByIDArray(ContractFundFundPayForRent.class, cfid);
		for(ContractFundFundPayForRent cp:cplist){
			cp.setInvalid("未提交");
			cp.setFpnote("租后经理复核退回！！！");
		}
		this.tableService.saveOrUpdateAllEntities(cplist);;
	}
}
