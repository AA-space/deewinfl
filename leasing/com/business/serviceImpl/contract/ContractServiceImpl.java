/**
 * 项目名称：    系统名称
 * 包名：              com.business.serviceImpl.cust
 * 文件名：         CustServiceImpl.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-18-下午12:30:07
 * Copyright：2013XX公司-版权所有
 **/

package com.business.serviceImpl.contract;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.doc.ContractDocBorrowInfo;
import com.business.entity.contract.doc.ContractDocSendInfo;
import com.business.service.TableService;
import com.business.service.contract.ContractServer;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kernal.utils.DateUtil;


/**
 * @author Jason
 * @date 2013-5-21
 * @info 
 */
@Service(value = "contractServer")
public class ContractServiceImpl extends AbstractBaseServiceImpl implements ContractServer {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	@Resource(name="tableService")
	private TableService tableService;

	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public String saveDocSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = null;
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
		}

		List<ContractDocSendInfo> list = Lists.newArrayList();
		
		String json_contract_doc_send_info_str = request.getParameter("json_contract_doc_send_info_str");
		JSONArray jsonArray = new JSONArray(json_contract_doc_send_info_str);
		
		String contractid = request.getParameter("contract_id");
		ContractInfo ci = this.tableService.findEntityByID(ContractInfo.class, contractid);
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractID", ci);
		List<ContractDocSendInfo> condoclist=this.tableService.findEntityByProperties(ContractDocSendInfo.class, propertiesMap);
		System.out.println(condoclist.size()+"条");
		/*this.tableService.removeAllEntites(condoclist);
		this.tableService.updateFlush();*/
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
			 if(jsonObject.optString("id")==null||jsonObject.optString("id").equals("")){//走新增
				 ContractDocSendInfo si = new ContractDocSendInfo();
				    si.setContractDate(jsonObject.optString("contractdate"));
					si.setContractA(jsonObject.optString("contracta"));
					si.setContractB(jsonObject.optString("contractb"));
					//System.out.println(jsonObject.optString("contractid"));
					
					si.setContractID(ci);
					si.setContractPerson(jsonObject.optString("contractperson"));
					
					
					//DictionaryData dict = (DictionaryData) this.tableService.findEntityByID(DictionaryData.class, jsonObject.optString("docname"));
					si.setDocName(jsonObject.optString("rowvalue_doc"));
					//si.setDocName(dict);
					si.setEquipInfo(jsonObject.optString("equipinfo"));
					si.setSendNo(jsonObject.optString("sendno"));
					si.setSendPart(jsonObject.optInt("sendpart"));
					si.setDocPart(jsonObject.optInt("docpart"));
					if ( jsonObject.has("maincount") && jsonObject.has("gcount") && jsonObject.has("sdy") )
					{
						si.setMaincount(jsonObject.optString("maincount"));
						si.setGcount(jsonObject.optString("gcount"));
						si.setSdy(jsonObject.optString("sdy"));
					}
					//String s = jsonObject.getString("id") ;
					
					if(StringUtils.isNotEmpty(jsonObject.optString("docnumber"))){
						si.setDocNumber(jsonObject.optString("docnumber"));
					}
					
					if(StringUtils.isNotEmpty(jsonObject.optString("id"))){
						si.setId(jsonObject.optString("id"));
						si.setModificator(user);
						si.setModifyDate(DateUtil.getSystemDate());
					}
					si.setCreateDate(DateUtil.getSystemDate());
					si.setCreator(user);
					list.add(si);
			 }else{//走修改
				 if(condoclist.size()>0){
					String maincount= jsonObject.has("maincount")?jsonObject.optString("maincount"):"";
					String gcount= jsonObject.has("gcount")?jsonObject.optString("gcount"):"";
					String sdy= jsonObject.has("sdy")?jsonObject.optString("sdy"):"";
					String sendno= jsonObject.has("sendno")?jsonObject.optString("sendno"):"";
					String sendpart= jsonObject.has("sendpart")?jsonObject.optString("sendpart"):"";
					String docpart= jsonObject.has("docpart")?jsonObject.optString("docpart"):"";
					String docnumber= jsonObject.has("docnumber")?jsonObject.optString("docnumber"):"";
					String docname= jsonObject.has("rowvalue_doc")?jsonObject.optString("rowvalue_doc"):"";
					String contractperson= jsonObject.has("contractperson")?jsonObject.optString("contractperson"):"";
					String contracta= jsonObject.has("contracta")?jsonObject.optString("contracta"):"";
					String contractb= jsonObject.has("contractb")?jsonObject.optString("contractb"):"";
					String sql="update Contract_Doc_Send_Info set maincount=?,gcount=?,sdy=?,doc_part=?,send_part=?"
							+ ",send_no=?,doc_number=?,contract_person=?,contract_a=?,contract_b=?,modify_date=?,modificator_=?"
							+ "  where contract_id=? and doc_name=?";
					System.out.println(maincount+gcount+sdy+docpart+sendpart+sendno+docnumber+contractperson
							+contracta+contractb+DateUtil.getSystemDate()+ci.getId()+docname);
					this.tableService.updateBySql(sql, maincount,gcount,sdy,docpart,sendpart,sendno,docnumber,contractperson
							,contracta,contractb,DateUtil.getSystemDate(),user.getId(),ci.getId(),docname);
					
				 }
			 }
			
		}
		
		if(list.size()==0){
			System.out.println("合同登记修改操作...");
		}else{
			this.tableService.saveAllEntities(list);
			System.out.println("合同登记新增操作...");
		}
		
		return "success";
	}

	@Override
	public String getCurrentPlanList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String contract_id= request.getParameter("contract_id");
		String equipAmt= request.getParameter("equipAmt");
		
		Map<String,String> properMap = Maps.newHashMap();
		properMap.put("contract_id", contract_id);
		properMap.put("equipAmt", equipAmt);
		
		String json_ontract_doc_send_info = this.tableService.getJsonArrayData("\\eleasing\\workflow\\contract\\doc_send_info.xml", properMap).toString();
		
		return json_ontract_doc_send_info;
	}

	@Override
	public String saveDocReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String idsStr = request.getParameter("ids");
		String[] ids = idsStr.split(",");
		String returnDate = request.getParameter("returndate");
		String returnUser = request.getParameter("returnuser");
		List<ContractDocBorrowInfo> docBorrowInfoList = this.tableService.findEntityByIDArray(ContractDocBorrowInfo.class, ids);
		
		Iterator<ContractDocBorrowInfo> it = docBorrowInfoList.iterator();
		while (it.hasNext()) {
			ContractDocBorrowInfo contractDocBorrowInfo = (ContractDocBorrowInfo) it.next();
			contractDocBorrowInfo.setReturnDate(returnDate);
			User u = this.baseDao.findEntityByID(User.class, returnUser);
			contractDocBorrowInfo.setReturnUser(u);
		}
		
		this.tableService.updateAllEntities(docBorrowInfoList);
		return "success";
	}
	

}
