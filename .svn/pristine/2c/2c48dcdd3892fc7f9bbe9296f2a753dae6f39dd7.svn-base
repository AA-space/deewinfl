package com.business.controller.GPSInterfacesInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.controller.BaseController;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.entity.contract.equip.gps.GPSInterfacesInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.utils.QueryUtil;


@Controller(value = "gpsInterfacesInfoController")
@RequestMapping(value = "/**/acl")
public class GpsInterfacesInfoController extends BaseController {
	private Logger logger = Logger.getLogger(GpsInterfacesInfoController.class);

	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/addGpsInterfacesInfo.acl")
	@ResponseBody
	public String addGpsInterfacesInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil
				.getRequestParameterMapByAjax(request);
		String message = "";
		GPSInterfacesInfo cInfo = new GPSInterfacesInfo();
		String chassisnum = model.get("chassisNum");
		String gpsUser = "";
		List<GPSInfo> gpsInfos = null;
		if(chassisnum!=""){
			gpsInfos = this.tableService.findResultsByHSQL("from GPSInfo gps where gps.equipID.chassisNum=?", chassisnum);
			try{
				gpsUser = gpsInfos.get(0).getEquipID().getContractId().getCustId().getCustName();
				}catch(Exception e){
					message = "该车架号没有对应的用户";
					throw new BusinessException("该车架号没有对应的用户");
				}
		}
		/*
		 * 未完成清单166条
		 * GPS导入的时候，添加系统客户，提示用户名称不存在，（陈谦），导入不成功，导入按车架号匹配，车架号，名称，时间，状态必填，其他不必填
		 */
		this.tableService.copyAndOverrideExistedValueFromStringMap(model,
				cInfo, null);
		cInfo.setGpsUser(gpsUser);
		this.tableService.saveEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("新增成功!");
		}
		return message;
	}

	@RequestMapping(value = "/updateGpsInterfacesInfo.acl")
	public String updateGpsInterfacesInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil
				.getRequestParameterMapByAjax(request);
		GPSInterfacesInfo cInfo = new GPSInterfacesInfo();
		this.tableService.copyAndOverrideExistedValueFromStringMap(model,
				cInfo, null);
		cInfo.setId(model.get("id"));
		String chassisnum = model.get("chassisNum");
		String gpsUser = "";
		List<GPSInfo> gpsInfos = null;
		String message = "";
		if(chassisnum!=""){
			gpsInfos = this.tableService.findResultsByHSQL("from GPSInfo gps where gps.equipID.chassisNum=?", chassisnum);
			try{
			gpsUser = gpsInfos.get(0).getEquipID().getContractId().getCustId().getCustName();
			}catch(Exception e){
				message = "该车架号没有对应的用户";
				throw new BusinessException("该车架号没有对应的用户");
			}
		}
		cInfo.setGpsUser(gpsUser);
		this.tableService.updateEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("修改成功!");
		}
		return message;
	}

	@RequestMapping(value = "/removeGpsInterfacesInfo.acl")
	public String removeGpsInterfacesInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil
				.getRequestParameterMapByAjax(request);
		GPSInterfacesInfo cInfo = new GPSInterfacesInfo();
		this.tableService.copyAndOverrideExistedValueFromStringMap(model,
				cInfo, null);
		cInfo.setId(model.get("id"));
		cInfo = (GPSInterfacesInfo) this.tableService.findEntityByID(
				GPSInterfacesInfo.class, model.get("id"));
		// Iterator<OwnAccount> set=ownInfo.getOwnAccounts().iterator();
		// while(set.hasNext()){
		// OwnAccount s =set.next();
		// this.baseService.removeEntity(s);
		// }
		// this.baseService.removeAllEntites(sInfo.getName());
		this.tableService.removeEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("删除成功!");
		}
		return null;
	}

	@RequestMapping(value = "/addGpsInterfacesInfoUpload.action")
	@ResponseBody
	public String insertGpsInterfacesInfoUpload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil
				.getRequestParameterMapNoAjax(request);

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest
				.getFile("tableImportExcel");
		String ebankInfo = this.tableService.importExcel(multipartFile,
				modelData);
		String message = getGPSuserinfo(ebankInfo);

		List<GPSInterfacesInfo> fds = new ArrayList<GPSInterfacesInfo>();
		if (message.length() == 0) {
			fds = uploadEbankFromFile(ebankInfo, null);
			// 加入导入信息
			message = "导入成功:导入" + fds.size() + "条";
		}
		System.out.println("插入条数" + fds.size());
		String ajaxCallBackScript = "<script type='text/javascript'>window.parent.importEbankCallBack(\""
				+ message + "\");</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}
    /*
     * 导入excel数据
     */
	public List<GPSInterfacesInfo> uploadEbankFromFile(String ebankInfo,
			Map<String, String> model) throws Exception {
		ObjectMapper jsonMapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray(ebankInfo);

		List<String> ebankList = new ArrayList<String>();
		HashMap<String, String> classFieldMapping = new HashMap<String, String>();
		classFieldMapping.put("CustInfo", "id");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("id", null);
		List<GPSInterfacesInfo> fds = new ArrayList<GPSInterfacesInfo>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Map[] newSetMaps = jsonMapper.readValue("[" + jsonObj.toString()
					+ "]", Map[].class);
			GPSInterfacesInfo fd = new GPSInterfacesInfo();
			System.out.println("newSetMaps=============" + newSetMaps[0]);
			this.tableService.copyAndOverrideExistedValueFromStringMap(
					newSetMaps[0], fd, classFieldMapping);
			this.tableService.saveEntity(fd);
			fds.add(fd);
		}
		return fds;
	}
    /*
     * 导入功能检查用户名是否存在
     */
	public String getGPSuserinfo(String gpsuser) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper jsonMapper = new ObjectMapper();
		JSONArray jsonArray = new JSONArray(gpsuser);
		String sms = "";
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Map[] newSetMaps = jsonMapper.readValue("[" + jsonObj.toString()
					+ "]", Map[].class);
			GPSInterfacesInfo fd = new GPSInterfacesInfo();
			System.out.println("get---newSetMaps=============" + newSetMaps[0]);
			// 测查编号是否已经导入数据库
			String HQL = "from GPSInfo as fd where fd.gpsUser in('"
					+ newSetMaps[0].get("gpsuser").toString() + "')";
			List<GPSInfo> FundList = new ArrayList<GPSInfo>();

			FundList =  tableService
					.findResultsByHSQL(HQL, null);
			if (FundList != null && FundList.size() > 0) {
				sms = "";
			} else {
				sms += "第" + (i+1) + "行的用户名称不存在，请核查！";
			}
		}
		return sms;
	}
	

}
