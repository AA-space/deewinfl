package com.business.controller.check;

import static java.lang.String.format;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.invoice.vat.TaxFundReceiptInfo;
import com.business.entity.invoice.vat.TaxRentInfo;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.JbpmService;
import com.business.service.check.CheckStartingWorkFlowServer;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.WebUtil;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-5-21 下午3:21:31 类说明
 */
@Controller(value = "checkStartingWorkFlowController")
@RequestMapping(value = "/**/leasing")
public class CheckStartingWorkFlowController extends BaseController {
	@Resource(name = "checkStartingWorkFlowService")
	private CheckStartingWorkFlowServer checkStartingWorkFlowService;
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name="jbpmService")
	private JbpmService jbpmService ;
	
	static final int BATCH_SIZE = 999;// 批量更新大小

	@RequestMapping(value = "/checkRentstatusInfo.action")
	@ResponseBody
	public String checkRentstatusInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User modificator =SecurityUtil.getPrincipal();
		String modifyDate = DateUtil.getSystemDateTime();
		String cffcid=request.getParameter("cffcid");//contract_fund_fund_charge 表的主键id
		String[] cffcidarr=cffcid.split(",");
		List<TaxRentInfo> trilist=new ArrayList<TaxRentInfo>();
		for(String cid:cffcidarr){
			TaxRentInfo ti=this.baseService.findEntityByID(TaxRentInfo.class, cid);
			if(ti!=null){
				ti.setInvoiceStatus(2);
				ti.setModificator(modificator);
				ti.setModifyDate(modifyDate);
				trilist.add(ti);
			}else{
				return "no";
			}
		}
		if (trilist.size()> 0){
			this.baseService.saveOrUpdateAllEntities(trilist);
			return "yes";
		}else{
			return "no";
		}
		
	}
	@RequestMapping(value = "/checkVtatusInfo.action")
	@ResponseBody
	public String checkVtatusInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User modificator =SecurityUtil.getPrincipal();
		String modifyDate = DateUtil.getSystemDateTime();
		String cffcid=request.getParameter("cffcid");//contract_fund_fund_charge 表的主键id
		String[] cffcidarr=cffcid.split(",");
		List<TaxFundReceiptInfo> trilist=new ArrayList<TaxFundReceiptInfo>();
		for(String cid:cffcidarr){
			TaxFundReceiptInfo ti=this.baseService.findEntityByID(TaxFundReceiptInfo.class, cid);
			if(ti!=null){
				ti.setInvoiceStatus(4);
				ti.setModificator(modificator);
				ti.setModifyDate(modifyDate);
				trilist.add(ti);
			}else{
				return "no";
			}
		}
		if (trilist.size()> 0){
			this.baseService.saveOrUpdateAllEntities(trilist);
			return "yes";
		}else{
			return "no";
		}
	}
	@RequestMapping(value = "/checkCardStatusInfo.action")
	@ResponseBody
	public String checkCardStatusInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] jsonArr = request.getParameterValues("edata[]"); 
		if (jsonArr.length ==0){
			return "no";
		}else{
			System.out.println("temp:"+Arrays.toString(jsonArr));
			String conditons =null;
			JSONArray jSONArray=new JSONArray(Arrays.toString(jsonArr));
			JdbcTemplate jdbcTemplate = (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate");
			for (int i=0; i<jSONArray.length(); i++)
			{
				JSONObject jsonObject= jSONArray.getJSONObject(i);
				conditons=jsonObject.get("contract_flag"+(i+1)).toString();
				System.out.println("conditons:"+conditons);
				String hsql= "select * from contract_fund_rent_plan where card_export_status not in ('2','0')"+ conditons;
				System.out.println("hsql:"+hsql);
				List<Map<String, Object>> mapList = jdbcTemplate.queryForList(hsql);
				if(mapList.size() > 0 ){
					String simple[] = conditons.split("'");
					String contractid = simple[1];
					ContractInfo contractInfo =this.baseService.findEntityByID(ContractInfo.class,contractid);
					String rentlistLen = conditons.substring(conditons.lastIndexOf("="),conditons.length());
					rentlistLen= rentlistLen.replace("=", "");
//					System.out.println(contractid);
//					System.out.println(Arrays.toString(simple));
//					System.out.println("rentlistLen:"+rentlistLen);
					throw new BusinessException("提示: 请检查,您操作的【本次回笼租金明细】 中"+contractInfo.getContractNumber()
							+"第"+rentlistLen
							+"期正在卡扣,请等卡扣完毕后操作该合同业务员注意不要多核销金额!") ;
					//return "statusFail";
				}
			}
			for (int i=0; i<jSONArray.length(); i++)
			{
				JSONObject jsonObject= jSONArray.getJSONObject(i);
				conditons=jsonObject.get("contract_flag"+(i+1)).toString();
				String sql ="update contract_fund_rent_plan set  card_export_status='2' where  1=1 "+ conditons;
				this.baseService.updateBySql(sql);
				System.out.println("sql:"+sql);
			}
			return "yes";
		}
	}
		@RequestMapping(value = "/checkPenaltyInfo.action")
		@ResponseBody
		public String checkPenaltyInfo(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		String contract_id = request.getParameter("contract_id");
		String rentlist = request.getParameter("rentlist");
		contract_id = URLDecoder.decode(contract_id, "UTF-8");
		boolean ispenaltycancel =false;
		System.out.println("#########################");
		System.out.println("contract_id"+contract_id);
		System.out.println("#########################");
		if ( null!= contract_id && rentlist !=null)
		{
			String sql = "update contract_fund_rent_income inc "
					+ "set inc.penalty_adjust='0' where   inc.plan_list= '"+rentlist+"' and  inc.contract_id in ("+contract_id+")";
			System.out.println(sql);
			System.out.println("#########################");
			this.baseService.updateBySql(sql);
			ispenaltycancel =true;
		}
		System.out.println("ispenaltycancel"+ispenaltycancel);
		if(ispenaltycancel)
			return "yes";
		else 
			return "no";
	}
	
	@RequestMapping(value = "/checkDealerInfo.action")
	@ResponseBody
	public String checkDealerInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try{
			String dealer_id= request.getParameter("dealer_id");
			String olddealer_id=request.getParameter("olddealer_id");
			System.out.println("##############");
			System.out.println("dealer_id:"+dealer_id);
			System.out.println("##############");
			System.out.println("olddealer_id:"+olddealer_id);
			String sql ="update cust_info_company com set com.dealer_company=? where com.dealer_company=?";
			String sql2 ="update cust_info_person per set per.dealer_company=? where per.dealer_company=?";
			String sql3 ="update proj_info p set p.cust_dealer=? where p.cust_dealer=?";
			String sql4 ="update contract_info i set i.cust_dealer=? where i.cust_dealer=?";
			this.baseService.updateBySql(sql, dealer_id,olddealer_id);
			this.baseService.updateBySql(sql2, dealer_id,olddealer_id);
			this.baseService.updateBySql(sql3, dealer_id,olddealer_id);
			this.baseService.updateBySql(sql4, dealer_id,olddealer_id);
			return "yes";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "no";
		}
	}
	@RequestMapping(value = "/checkDealerCompayInfo.action")
	@ResponseBody
	public String checkDealerCompayInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		 try{
			  
			String dealerid= request.getParameter("dealerid");
			String custid=request.getParameter("custid");
			System.out.println("##############");
			System.out.println("dealerid:"+dealerid);
			System.out.println("##############");
			System.out.println("custid:"+custid);
			if( custid ==null || custid.length()==0)
			{
				return "custidIsNull";
			}else
			{
				String sql ="update cust_info_company com set com.dealer_company=? where com.cust_id=?";
				String sql2 ="update proj_info p set p.cust_dealer=? where p.cust_id=?";
				String sql3 ="update contract_info i set i.cust_dealer=? where i.cust_id=?";
				this.baseService.updateBySql(sql,dealerid,custid);
				this.baseService.updateBySql(sql2,dealerid,custid);
				this.baseService.updateBySql(sql3,dealerid,custid);
				System.out.println("sql:"+sql);
				System.out.println("sql2:"+sql2);
				System.out.println("sql3:"+sql3);
				return "yes";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "no";
		}
	}
	@RequestMapping(value = "/checkDealerPersonInfo.action")
	@ResponseBody
	public String checkDealerPersonInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		 try{
			  
			String dealerid= request.getParameter("dealerid");
			String custid=request.getParameter("custid");
			System.out.println("##############");
			System.out.println("dealerid:"+dealerid);
			System.out.println("##############");
			System.out.println("custid:"+custid);
			if( custid ==null || custid.length()==0 )
			{
				return "custidIsNull";
			}else
			{
				String sql ="update cust_info_person com set com.dealer_company=? where com.cust_id=?";
				String sql2 ="update proj_info p set p.cust_dealer=? where p.cust_id=?";
				String sql3 ="update contract_info i set i.cust_dealer=? where i.cust_id=?";
				this.baseService.updateBySql(sql,dealerid,custid);
				this.baseService.updateBySql(sql2,dealerid,custid);
				this.baseService.updateBySql(sql3,dealerid,custid);
				System.out.println("sql:"+sql);
				System.out.println("sql2:"+sql2);
				System.out.println("sql3:"+sql3);
				return "yes";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "no";
		}
	}
	@RequestMapping(value = "/checkMessageInfo.action")
	@ResponseBody
	public String checkMessageInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String hsql = "from BaseMessage where sendDate >= ? and sendDate <= ?";
		if (startdate != null && enddate != null) {
			List<BaseMessage> baseMessage = this.baseService.findResultsByHSQL(
					hsql, startdate, enddate);
			if ( baseMessage.size() == 0 )
			{
				throw new BusinessException("输入的时间段消息为0条,删除失败!");
			}
			int size = 0;
			if (null != baseMessage
					&& (size = baseMessage.size()) <= BATCH_SIZE) {
				batchUpdateBaseMsg(baseMessage);
				return "yes";
			}
			boolean eq;
			for (int j = 0, x = (eq = size % BATCH_SIZE == 0) ? size
					/ BATCH_SIZE : size / BATCH_SIZE + 1; j < x; ++j) {
				if (!eq && j == x - 1) {
					batchUpdateBaseMsg(baseMessage.subList(size - (j - 1)
							* BATCH_SIZE - 1, size));
					break;
				}
				batchUpdateBaseMsg(baseMessage.subList(j * BATCH_SIZE, (j + 1)
						* BATCH_SIZE - 1));
			}
			return "yes";
		}
		return "no";

	}

	private void batchUpdateBaseMsg(List<BaseMessage> baseMsgs)
			throws Exception {
		StringBuilder sql = new StringBuilder("delete from %s where MSG_ID in(");
		for (int i = 0, j = baseMsgs.size(); i < j; i++) {
			if (i > 0)
				sql.append(",");
			sql.append("'").append(baseMsgs.get(i).getId()).append("'");
		}
		sql.append(")");
		baseService.updateBySql(format(sql.toString(), "Base_Message_TO_User"));

		baseService
				.updateBySql(format(sql.toString(), "Base_Message_TO_Group"));

		baseService.removeAllEntites(baseMsgs);
	}

	@RequestMapping(value = "/checkBathInfo.action")
	@ResponseBody
	public String checkBathInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String fieldname = request.getParameter("fieldname");
		// System.out.println(fieldname);
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("username", fieldname);
		List<User> users = this.baseService.findEntityByProperties(User.class,
				propertiesMap);
		if (users != null && users.size() > 0) {
			User us = users.get(0);
			String sql = "update BASE_MESSAGE_TO_USER BMT "
					+ " set BMT.Read_Status='0' where " + " BMT.READ_USER = ? ";
			this.baseService.updateBySql(sql, us.getId());
			return "yes";
		}
		return "输入需要批量标记的登陆编码有误!";

	}

	@RequestMapping(value = "/checkContractChargeInfo.action")
	@ResponseBody
	public String checkContractChargeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String contract_id = request.getParameter("contract_id");
		String sql = "select info.contract_id from gps_info info "
				+ " where info.contract_id = ? ";
		int connum = this.baseService.queryListBySql(sql, contract_id).size();// gps_info
		if (connum > 0)
			return "gps已确认,不允许在做合同变更!";

		String sql2 = "select charge.contract_id from contract_fund_fund_charge charge "
				+ " where charge.contract_id = ? ";
		int connum2 = this.baseService.queryListBySql(sql2, contract_id).size();// contract_fund_fund_charge
		if (connum2 > 0)
			return "首付已收,不允许在做合同变更!";

		String sql3 = "select rentpln.contract_id from contract_fund_rent_plan rentpln "
				+ " where rentpln.contract_id = ? ";
		int connum3 = this.baseService.queryListBySql(sql3, contract_id).size();// contract_fund_rent_plan
		if (connum3 > 0)
			return "已做合同起租,不允许在做合同变更!";

		else
			return "no";

	}

	@RequestMapping(value = "/checkProjCancel.action")
	@ResponseBody
	public String checkProjCancel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String proj_id = request.getParameter("proj_id");
		ProjInfo projinfo = this.baseService.findEntityByID(ProjInfo.class,
				proj_id);
		String sql = "select info.key_two_ from t_jbpm_workflow_info info "
				+ " where info.key_two_ = ? "
				+ " and info.workflow_display_name_ ='合同审批流程' ";
		int connum = this.baseService.queryListBySql(sql,
				projinfo.getProjectName()).size();
		if (connum > 0) {
			return "yes";
		}
		return "no";
	}
	@RequestMapping(value = "/checkFinish.action")
	@ResponseBody
	public String checkFinish(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 String contract_id = request.getParameter("contract_id");
		 String hql="from ContractInfo where contract_status=? and id=?";
		 List<ContractInfo>  contractInfolist = this.baseService.findResultsByHSQL(hql, "201",contract_id);
		 if ( !contractInfolist.isEmpty() && contractInfolist.size()> 0)
		 {
			 return "yes";
		 }
		 return "no";
	}
	
	@RequestMapping(value = "/updateProjCancel.action")
	@ResponseBody
	public String updateProjCancel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String proj_id = request.getParameter("proj_id");
		ProjInfo projinfo = this.baseService.findEntityByID(ProjInfo.class,
				proj_id);
		//初评会否决
		DictionaryData repeal=this.baseService.findEntityByID(DictionaryData.class,"repeal_type2");
		projinfo.setRepealDate(DateUtil.getSystemDate());
		projinfo.setRepealReasonType(repeal);
		projinfo.setRepealReason("信审通过三个月合同审批未提交系统撤销该项目");
		projinfo.setProjStatus(AppStaticUtil.PROJ_CANCEL);
		User currentUser = SecurityUtil.getPrincipal(); 
		projinfo.setModificator(currentUser);
		projinfo.setModifyDate(DateUtil.getSystemDate());
		this.baseService.saveOrUpdateEntity(projinfo);
		return null;
	}

	@RequestMapping(value = "/updateContractCancel.action")
	@ResponseBody
	public String updateContractCancel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		JSONArray jsonArr = new JSONArray(model.get("datas"));
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			String proj_id=jsonObj.getString("proj_id");
			ProjInfo projinfo = this.baseService.findEntityByID(ProjInfo.class,proj_id);
			//初评会否决
			DictionaryData repeal=this.baseService.findEntityByID(DictionaryData.class,"repeal_type2");
			projinfo.setRepealDate(DateUtil.getSystemDate());
			projinfo.setRepealReasonType(repeal);
			projinfo.setRepealReason("信审通过三个月合同审批未提交系统撤销该项目");
			projinfo.setProjStatus(AppStaticUtil.PROJ_CANCEL);
			User currentUser = SecurityUtil.getPrincipal(); 
			projinfo.setModificator(currentUser);
			projinfo.setModifyDate(DateUtil.getSystemDate());
			this.baseService.saveOrUpdateEntity(projinfo);
			String proj_status=jsonObj.getString("proj_status");
			
			if("合同审批中".equals(proj_status)){//合同审批中直接删除流程实例
				String dbid=jsonObj.getString("dbid");
				this.jbpmService.removeProcessInstance(request, dbid);
			}else{//合同审批结束修改为合同撤销状态
				for(ContractInfo ci:projinfo.getContractInfos()){
					ci.setRepealDate(DateUtil.getSystemDate());
					ci.setRepealReason("信审通过三个月合同起租未提交系统撤销该项目");
					ci.setRepealReasonType(repeal);
					ci.setContractStatus(AppStaticUtil.CONTRACT_CANCEL);
					ci.setModificator(currentUser);
					ci.setModifyDate(DateUtil.getSystemDate());
					this.baseService.saveOrUpdateEntity(ci);
				}
			}
			//发送站内信消息
			if(projinfo.getProjRegistrar()!=null){
				User user = (User) SecurityUtil.getPrincipal();
				BaseMessage baseMessage = new BaseMessage();
				BaseMessageToUser toUser = new BaseMessageToUser();
				baseMessage.setMsgTitle(projinfo.getProjectName()+"项目撤销");
				baseMessage.setMsgType(this.baseService.findEntityByID(DictionaryData.class, "msgtype.1"));
				baseMessage.setSendDate(DateUtil.getSystemDate());
				baseMessage.setFromUser(user);
				baseMessage.setCreateDate(DateUtil.getSystemDateTime());
				baseMessage.setCreator(user);
				String text="承租客户为:"+projinfo.getCustId().getCustName()+",项目编号为:"+projinfo.getProjId()+"信审通过三个月合同起租未提交系统撤销该项目";
				baseMessage.setMsgText(text);
				this.baseService.saveEntity(baseMessage);
				
				BaseMessageToUser baseMessageToUser = new BaseMessageToUser();
				baseMessageToUser.setMsgID(baseMessage);
				baseMessageToUser.setReadStatus("1");
				baseMessageToUser.setReadUser(projinfo.getProjRegistrar());
				baseMessageToUser.setCreateDate(DateUtil.getSystemDateTime());
				baseMessageToUser.setCreator(user);
				this.baseService.saveOrUpdateEntity(baseMessageToUser);
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/checkfundOnhire.action")
	@ResponseBody
	public String checkfundOnhire(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String contract_id = request.getParameter("contract_id");
		Map<String, Object> mappro = new HashMap<String, Object>();
		mappro.put("contractId.id", contract_id);
		mappro.put("payType.id", "pay_type_in");
		BigDecimal incometotalmoney = BigDecimal.ZERO;
		BigDecimal totalplanmoney = BigDecimal.ZERO;
		if (contract_id != null) {
			List<ContractFundFundCharge> contractfundfundcharge = this.baseService
					.findEntityByProperties(ContractFundFundCharge.class,mappro);
				if (contractfundfundcharge.size() == 0){
					throw new BusinessException("首付未收");
				}
				// 足额判断
			   for (int i = 0; i < contractfundfundcharge.size(); i++) {
				   incometotalmoney = incometotalmoney.add(
				   contractfundfundcharge.get(i).getFactMoney()).setScale(2); 
			   }
			   List<ContractFundFundPlan> contractFundFundPlans =this.baseService.findEntityByProperties(ContractFundFundPlan.class,mappro); 
			   for (int j = 0; j < contractFundFundPlans.size(); j++ ) {
				   totalplanmoney = totalplanmoney.add(
				   contractFundFundPlans.get(j).getPlanMoney()).setScale(2); 
			   }
			   if (incometotalmoney.compareTo(totalplanmoney) != 0 ){ 
				   throw new BusinessException(incometotalmoney+"首付未足额收取" +totalplanmoney);
			   }
			  return "1";
		}
		return "";
	}

	@RequestMapping(value = "/getWorkFlowstatus.action")
	@ResponseBody
	public Map<String, String> getWorkFlowstatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String seriesNumber = request.getParameter("seriesNumber");
		Map<String, String> status = null;// this.checkStartingWorkFlowService.getWorkFlowStatus(seriesNumber);
		return status;
	}

	@RequestMapping(value = "/checkWorkFlow.action")
	@ResponseBody
	public Map<String, String> checkWorkFlow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkWorkFlow(request);
		return status;
	}

	@RequestMapping(value = "/checkContractStart.action")
	@ResponseBody
	public Map<String, String> checkContractStart(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkContractStart(request);
		return status;
	}

	@RequestMapping(value = "/checkContractOnhireStart.action")
	@ResponseBody
	public Map<String, String> checkContractOnhireStart(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkContractOnhireStart(request);
		return status;
	}

	@RequestMapping(value = "/checkEquip.action")
	@ResponseBody
	public Map<String, String> checkEquip(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkEquip(request);
		return status;
	}

	@RequestMapping(value = "/checkRent.action")
	@ResponseBody
	public Map<String, String> checkRent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkRent(request);
		return status;
	}

	@RequestMapping(value = "/checkCharge.action")
	@ResponseBody
	public Map<String, String> checkCharge(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> status = this.checkStartingWorkFlowService
				.checkCharge(request);
		return status;
	}

}
