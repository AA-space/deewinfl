package com.business.serviceImpl.ebank;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankDataOperateLog;
import com.business.entity.base.BaseFile;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.ebank.EbankService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.service.vouchersFactory.EbankImportService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
import com.ctc.wstx.util.DataUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;
@Service(value="ebankService")
public class EbankServiceImpl extends AbstractBaseServiceImpl implements EbankService {
	
	
	@Resource(name="fileTemplateService")
	private FileTemplateService  templateService;

	@Resource(name="tableService")
	private TableService tableService;
	@Resource
	 private BaseDao baseDao;
	 private Logger logger=Logger.getLogger(EbankServiceImpl.class);
	@Override
	public BaseDao getBussinessDao() throws Exception {
		// TODO Auto-generated method stub
		return baseDao;
	}
	@Resource(name="ebankImportService")
	private EbankImportService ebankImportService;

	@Override
	public String addEbank(Map<String, String> model) throws Exception {
		// TODO Auto-generated method stub
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 String sn=model.get("sn");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("sn",sn );
		 List  listf=new ArrayList ();
		 listf= this.getBussinessDao().findEntityByProperties(FundEbankData.class, propertiesMap);
		 if(listf!=null&&listf.size()>0){
			 return "流水号重复";  
		 }else{	 
		   FundEbankData info = new FundEbankData();
		   this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		   info.setEbdataId(WorkflowUtil.getEbankNoInfoSerialNumber(null,this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate()));
		   if(info.getNoWithMoney()==null){
			   info.setNoWithMoney(new BigDecimal(0.00));
		   }
		   this.getBussinessDao().saveEntity(info);
		   
		   if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
		   }
		 }
       return null;
	}
	/**
	 * 添加操作记录到网银操作记录表FundEbankDataOperateLog
	 */
	@Override
	public String addEbankLog(Map<String, String> model) throws Exception {
		 User user    =  (User)SecurityUtil.getPrincipal();
		 FundEbankData info = new FundEbankData();
		 info=(FundEbankData)this.getBussinessDao().findEntityByID(FundEbankData.class, model.get("id"));
		 info.initFundEbank();
		 if(info!=null){
			 saveEbankLog(user,info,model);
		    if(logger.isInfoEnabled()){
			   logger.info("添加成功!");
		    }
		 }else{
			 return "添加失败!";
		 }
		 return null;
	}

	private void saveEbankLog(User user, FundEbankData info,Map<String, String> model) throws Exception {
		FundEbankDataOperateLog fdol = new FundEbankDataOperateLog();
		//更改经销商是生成红冲凭证
		String befor_cust_id = model.get("befor_cust_dealer");
		CustInfo cust = null;
		if(befor_cust_id!=""&&!"".equals(befor_cust_id)&&befor_cust_id!=null){
			cust = this.tableService.findEntityByID(CustInfo.class, befor_cust_id);
		}
		String befor_nowithmoney = model.get("befor_nowithmoney");
		String befor_fund_ebank_status = model.get("befor_fund_ebank_status");
		//保存记录到网银操作记录表
		   fdol.setEbankId(info);
		   fdol.setBeforEnabled(Integer.parseInt(befor_fund_ebank_status));
		   fdol.setBeforCustId(cust);
		   fdol.setBeforNoWithMoney(new BigDecimal(befor_nowithmoney));
		   fdol.setAfterCustId(info.getCustId());
		   fdol.setAfterEnabled(info.getEnabled());
		   fdol.setAfterNoWithMoney(info.getNoWithMoney());
		   fdol.setSn(info.getSn());
		   fdol.setSummary(info.getSummary());
		   fdol.setModificator(user);
		   fdol.setModifyDate(DateUtil.getSystemDate());
		   this.getBussinessDao().saveEntity(fdol);

		   
		  
			
		
		    /** 网银修改-凭证生成-开始*/
		     
		   //修改了客户，生成借客户A 到 客户B 的凭证，但不能使从未启用状态到启用状态
		   if (info.getEnabled() == 0  && Integer.parseInt(befor_fund_ebank_status) == 0) {
		   
			   if(cust != null && info.getCustId() != null &&  !cust.getId().equals(info.getCustId().getId())){
				   
				   //ebankImportService.changeCust(info, cust);
				   //生成之前经销商的红冲凭证
				   ebankImportService.createRedVoucher(info, cust);
				   
				   //生成新经销商的凭证
				   ebankImportService.createVoucher(info);
			   }
			   
			   //如果之前客户为空，则产生凭证
			   if(cust == null && info.getCustId() != null){
				   ebankImportService.createVoucher(info);
			   }
		   }
			 /** 网银修改-凭证生成-结束*/
		
	}
	@Override
	public String checkLoadEbank(String ebankInfo, Map<String, String> model)
			throws Exception {
		JSONArray jsonArray = new JSONArray(ebankInfo);
		JSONArray newjsonArray = new JSONArray();
		List<String> ebankList=new ArrayList<String>();
        String sns="";
        String sn ="";
        String samesns="";
        String temp="";
        String client="";
        String message="";
        String dealerstr="";
        String dealer="";
        String dealertemp="";
        String noindealerstr="";
        String bank="";
        String account="";
        String number="";
        String sbankmessage="";
        List<String> dealerArray=new ArrayList<String>();
        String requirestring="";
        //测查编号是否有重复
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			sn=(jsonObj.has("sn"))?jsonObj.get("sn").toString():"";
			dealer=(jsonObj.has("custid"))?jsonObj.getString("custid").trim():"";
			client=(jsonObj.has("clientname"))?jsonObj.getString("clientname").trim():"";
			bank=(jsonObj.has("ownbank"))?jsonObj.getString("ownbank").trim():"";
			account=(jsonObj.has("ownaccount"))?jsonObj.getString("ownaccount").trim():"";
			number=(jsonObj.has("ownaccnumber"))?jsonObj.getString("ownaccnumber").trim():"";
			temp="";
			if("".equalsIgnoreCase(sn)){temp=temp+",流程水号必填";}
			if("".equalsIgnoreCase(dealer) && "".equalsIgnoreCase(client)){temp=temp+",经销商和付款人必填其中一个";}
			if("".equalsIgnoreCase(bank)){temp=temp+",本方银行必填";}
			if("".equalsIgnoreCase(account)){temp=temp+",本方账户必填";}
			if("".equalsIgnoreCase(number)){temp=temp+",本方账号必填";}
			if(temp.length()>0){
				if(requirestring.length()>0){requirestring=requirestring+",";}
				requirestring=requirestring+"第"+(i+1)+"行"+temp;
			}
			dealerArray.add(dealer);
			temp="'"+sn+"'";
			dealertemp="'"+dealer+"'";
			if(sns.indexOf(temp)>=0){
				if(!samesns.equalsIgnoreCase("")){samesns=samesns+",";}
				samesns=samesns+temp;
			}
		    if (sns.equalsIgnoreCase("")){
		    	sns=temp;
		    	dealerstr=dealertemp;
		    }else{
		    	sns=sns+","+temp;
		    	dealerstr=dealerstr+","+dealertemp;
		     }
		   }
	    
		//测查编号是否已经导入数据库
		String HQL="from FundEbankData as fd where fd.sn in( "+sns+")";
		List<FundEbankData> FundList=new ArrayList<FundEbankData>();
		sns="";
		FundList=this.getBussinessDao().findResultsByHSQL(HQL);
		if (FundList.size()>0){
			for(int i=0;i<FundList.size();i++){
			 if (sns.equalsIgnoreCase("")){
				 sns=sns+"'"+FundList.get(i).getSn()+"'";
			    }else{
			    	sns=sns+",'"+FundList.get(i).getSn()+"'";}	
			 }
	    }
		
		/*
		//检查导入的经销商是否在系统中
	    HQL="from CustInfo as c where c.custName in("+dealerstr+") and c.custClass.id='CUST_INFO_DEALER'";
	    List<CustInfo> custList=new ArrayList<CustInfo>();
	    custList=(List<CustInfo>)this.getBussinessDao().findResultsByHSQL(HQL, null);
	    dealerstr="";
	    if(custList.size()>0){
	        for(int i=0;i<custList.size();i++){
	        	if("".equalsIgnoreCase(dealerstr)){
	        		dealerstr=custList.get(i).getCustName();
	        	}else{
	        		dealerstr=dealerstr+","+custList.get(i).getCustName();
	        	}
	        }	
	    }
	    dealerstr=","+dealerstr+",";
	    noindealerstr="";
	    for(int i=0;i<dealerArray.size();i++){
	       if(!"".equalsIgnoreCase(dealerArray.get(i))){
	          dealertemp=","+dealerArray.get(i)+",";
	          if(dealerstr.indexOf(dealertemp)<0){
	        	  if(noindealerstr.equalsIgnoreCase("")){
	        		  noindealerstr=dealerArray.get(i);
	        	  }else{
	        		  noindealerstr=noindealerstr+","+ dealerArray.get(i);
	        	  }
	          }
	       }
	    }
	    
	    
	    //检查本方的银行账户账号
	    
	    HQL="from OwnAccount as c ";
	    List<OwnAccount> accountList=new ArrayList<OwnAccount>();
	    accountList=(List<OwnAccount> )this.getBussinessDao().findResultsByHSQL(HQL, null);
	    String noinbank="";
	    boolean cflag=false;
	    for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			bank=(jsonObj.has("ownbank"))?jsonObj.getString("ownbank").trim():"";
			account=(jsonObj.has("ownaccount"))?jsonObj.getString("ownaccount").trim():"";
			number=(jsonObj.has("ownaccnumber"))?jsonObj.getString("ownaccnumber").trim():"";
			cflag=false;
		    for(OwnAccount oa :accountList){
		    	if(oa.getAccBank().equals(bank)&&oa.getAccName().equals(account)&&oa.getAccNumber().equals(number)){
		    		cflag=true;
		    	}
		    }
		    if(!cflag){
		    	noinbank=noinbank+",("+bank+","+account+","+number+")";
		    }
	    }*/
	    message=""; 
	    if(requirestring.length()>0){message=requirestring;}
		if(sns.length()>0){message=message+",流水号"+sns+"已经导入";}
		if(samesns.length()>0){message=message+",流程水号"+samesns+"重复";}
		//if(noindealerstr.length()>0){message=message+",经销商"+noindealerstr+"在系统中不存在";}
	//	if(noinbank.length()>0){message=message+",下列本方信息"+noinbank+"没有在系统中登记";}
		if(message.length()>0){message="导入失败:"+message;}
		return message;
	}

	@Override
	public String removeEbank(Map<String, String> model) throws Exception {
		 
		 String[] ids = model.get("ids").split(",");
		 System.out.println(ids);
		 
		 for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			FundEbankData fundEbankData=(FundEbankData)this.getBussinessDao().findEntityByID(FundEbankData.class, id);
			fundEbankData.initFundEbank();
			 BigDecimal mmoney=fundEbankData.getFactMoney().subtract(fundEbankData.getNoWithMoney());
			 if(fundEbankData.getMayOpeMoney().subtract(mmoney).intValue()==0){
			    this.getBussinessDao().removeEntity(fundEbankData);
			    if(logger.isInfoEnabled()){
				   logger.info("删除成功!");
			    }
			  }else{
				 throw new BusinessException("已经核销过租金不能删除");
			 }
			
		}
		return "ok";
	}

	@Override
	public String updateEbank(Map<String, String> model) throws Exception {
		// TODO Auto-generated method stub
		 User user    =  (User)SecurityUtil.getPrincipal();
		 String message = "";
		 FundEbankData info = new FundEbankData();
		 info=(FundEbankData)this.getBussinessDao().findEntityByID(FundEbankData.class, model.get("id"));
		 String ebankid=model.get("ebdataid");
		 String sn=model.get("sn");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("sn",sn );
		 List  listf=new ArrayList ();
		 listf= this.getBussinessDao().findEntityByProperties(FundEbankData.class, propertiesMap);
		 if(listf.size()>0){
			 FundEbankData temp=(FundEbankData)listf.get(0);
			 if(!temp.getEbdataId().equals(ebankid)){
				 message = "修改的流水号已经登记到系统中";
			 }
		 }
		 this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(model, info, null);
		 info.initFundEbank();
		 //核销过程中的金额
		 BigDecimal fundPMoney = info.getFundPMoney();
		 //已经核销金额
		 BigDecimal hadMoney = info.getHadMoney();
		// System.out.println("核销过程中的金额:"+fundPMoney+"是否大于0"+(fundPMoney.compareTo(BigDecimal.ZERO)>0) );
		 //System.out.println("已经核销金额:"+hadMoney+"是否大于0"+(hadMoney.compareTo(BigDecimal.ZERO)>0));
		 if(fundPMoney.compareTo(BigDecimal.ZERO)==0 || hadMoney.compareTo(BigDecimal.ZERO)==0){
			 if(info.getMayOpeMoney().compareTo(BigDecimal.ZERO)>0){
				 //保存网银操作记录
				 saveEbankLog(user,info,model);
			     this.getBussinessDao().updateEntity(info);
			     if(logger.isInfoEnabled()){
				 logger.info("修改成功!");
			      }

			     
			     
			  }else{
				  message =  "修改金额小于已经核销的金额";
			 }
	      }else{
	    	  message =  "该网银金额正在使用，不能修改";
	    	  throw new BusinessException(message);
	      }
		
		 
		 return message;
	}

	@Override
	public List<FundEbankData> uploadEbankFromFile(String ebankInfo, Map<String, String> model,BaseFile bf)
			throws Exception {
		// TODO Auto-generated method stub
		 ObjectMapper jsonMapper = new ObjectMapper(); 
		JSONArray jsonArray = new JSONArray(ebankInfo);
		List<String> ebankList=new ArrayList<String>();
		 HashMap<String,String>classFieldMapping=new  HashMap<String,String>();
		 classFieldMapping.put("CustInfo", "custName");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		
		 List<FundEbankData> fds=new ArrayList<FundEbankData>();
		 for(int i=0;i<jsonArray.length();i++){
			  JSONObject jsonObj = jsonArray.getJSONObject(i);
			  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			  FundEbankData fd=new FundEbankData();
			  this.getBussinessDao().copyAndOverrideExistedValueFromStringMap(newSetMaps[0], fd, classFieldMapping);
			
			  if (newSetMaps[0].containsKey("clientaccnumber")){
				  propertiesMap.clear();
			     String clientaccnumber=(String)newSetMaps[0].get("clientaccnumber");
			     propertiesMap.put("accNumber", clientaccnumber);
			     List<CustInfoAccount> custaccount=(List<CustInfoAccount>)this.getBussinessDao().findEntityByProperties(CustInfoAccount.class, propertiesMap);
			     if(custaccount.size()>0){
			    	 fd.setCustId(custaccount.get(0).getCustId());
			     }
			  }
			  if (newSetMaps[0].containsKey("custid")){
				     propertiesMap.clear();
				     String custname=(String)newSetMaps[0].get("custid");
				     propertiesMap.put("custName", custname);
				     List<CustInfo> cust=(List<CustInfo>)this.getBussinessDao().findEntityByProperties(CustInfo.class, propertiesMap);
				     if(cust.size()>0){
				    	 fd.setCustId(cust.get(0));
				     }
				  }
			  String EbankNumber=WorkflowUtil.getEbankNoInfoSerialNumber(null,this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate());
			  if(fd.getNoWithMoney()== null){
				  fd.setNoWithMoney(new BigDecimal(0.00));
			  }
			  fd.setEbdataId(EbankNumber);
			  fd.setUpLoadId(bf);
			  this.getBussinessDao().saveEntity(fd);
			  fds.add(fd);
		 }			
		return fds;
	}
	 public String insertEbankFromLoadFile(MultipartFile  multipartFile,Map<String,String> model)throws Exception  {
		    String message;
		    try{
		    BaseFile basefile=this.templateService.saveUpFiletoService(multipartFile, model);
	        String ebankInfo = this.tableService.importExcel(multipartFile, model); 
			       message=checkLoadEbank(ebankInfo, null);
			List<FundEbankData> fds=new ArrayList<FundEbankData>();
			if(message.length()==0){
				 fds=uploadEbankFromFile(ebankInfo,model,basefile);
				//加入导入信息
				message="导入成功:导入"+fds.size()+"条";
			}
			} catch (Exception e) {
				return  "网银上传出错\n"+e.getMessage();
			}
		 return message;
	 }
	 public String updateCancalEbank(Map<String,String> model)throws Exception{
		    String ids=model.get("ids");
			String[] idarray=ids.split(",");
			List<FundEbankData> fundEbankList;
			fundEbankList=(List<FundEbankData>)this.tableService.findEntityByIDArray(FundEbankData.class, idarray);
			for(FundEbankData fd:fundEbankList){
				FundEbankData ftemp=fd;
				ftemp.setEnabled(1);
				this.tableService.saveOrUpdateEntity(ftemp);
			}
		 return null;
	 }
	 public String updateCustEbankData(String ebankId, Integer ebank_flag)throws Exception{
		 String[] ebankIds = ebankId.split("%2C");
		 List<FundEbankData> ebankList  = new ArrayList<FundEbankData>();
		 for (int i = 0; i < ebankIds.length; i++) {
			 FundEbankData fundEbankData = this.tableService.findEntityByID(FundEbankData.class, ebankIds[i]);
			 
			 if (ebank_flag != null) {
				fundEbankData.setEnabled(ebank_flag);
				
				if (ebank_flag == 0 && fundEbankData.getCustId() == null) {//判断如果客户为空，保存到未启用网银中
					fundEbankData.setEnabled(1);
				} 
				
			} else {
				throw new BusinessException("不能更新，提交选项为空");
			}

			 this.tableService.updateEntity(fundEbankData);
			 /** 凭证生成-开始*/
			 //只有客户不为空，而且为启用状态
			 if(fundEbankData.getCustId() != null && ebank_flag != null && ebank_flag == 0){
				 ebankImportService.createVoucher(fundEbankData);
			 }
			 
			 
			if(ebank_flag == 92){ //如果是月底网银，则单独启用客户转换的凭证
				CustInfo unKnowCust = this.baseDao.findEntityByID(CustInfo.class, "010001351");
				
				if (fundEbankData.getCustId().getId().equals(unKnowCust.getId())) {
					throw new BusinessException("【未确认】客户不能直接提交到网银启用，请修改客户");
				}
				fundEbankData.setEnabled(0); //设置启用
				 ebankImportService.changeCust(fundEbankData, unKnowCust);//变更客户
			 }
			 
			 
			 if (ebank_flag == 91) {
				 ebankList.add(fundEbankData);
			}
			 
			 /** 凭证生成-结束*/
		}
		 
		 /**月底结账-凭证-开始*/
		 if (ebank_flag == 91 && ebankList.size() > 0) {
			 ebankImportService.monthEnd(ebankList);
			}
		 /**月底结账-凭证-结束*/
		 
		 String jsonResult = "";
		 Map<String,Object> returnMap=new HashMap<String, Object>();
		 ObjectMapper mapper = new ObjectMapper();
		 returnMap.put("enabled", ebank_flag);
		 jsonResult = mapper.writeValueAsString(returnMap);
		 
		 //throw new BusinessException("1");
		 return jsonResult.toLowerCase();
	 }
}
