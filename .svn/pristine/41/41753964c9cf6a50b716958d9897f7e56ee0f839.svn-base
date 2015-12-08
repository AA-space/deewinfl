package com.business.controller.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.business.controller.BaseController;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.invoice.ProjInvoiceType;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "ContractStartFlowCheckControllers")
@RequestMapping(value = "/**/leasing")
public class ContractStartFlowCheckController extends BaseController {
	@Resource(name = "baseService")
	private BaseService baseService;
	@ResponseBody
	@RequestMapping(value = "/contractStartFlowCheck.acl")
	public String contractStartFlowCheck(HttpServletRequest request,HttpServletResponse response)  throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String proj_id=modelData.get("projID");
		String HQL="from ProjInvoiceType a where a.projId.projId=?";
		List<String>message=new ArrayList<String>();
		List<ProjInvoiceType> projInvoiceTypes=this.baseService.findResultsByHSQL(HQL, proj_id);
		if(projInvoiceTypes.size()<=0){
			message.add("开票信息");
		}else{
			ProjInvoiceType pt=projInvoiceTypes.get(0);
			if(null==pt.getRentInvoiceType()){
				message.add("租金发票类型");
			}
			if(null==pt.getIsInvoiceRentSplit()||"".equals(pt.getIsInvoiceRentSplit())){
				message.add("租金发票本利金是否拆分");
			}
			if(null==pt.getBoolInvoice()||"".equals(pt.getBoolInvoice())){
				message.add("发票为放款先决条件");
			}
		}
		HQL="from ProjEquip p where p.projId.projId=?";
		List<ProjEquip> projEquips=this.baseService.findResultsByHSQL(HQL, proj_id);
		if(projEquips.size()>0){
			for(ProjEquip pe : projEquips){
				//车辆合同小号，车架号，购置税，保费，其他融资额
				String equipClass = pe.getEquipClass().getCode();
				if(!"equip_class_2".equals(equipClass)){
					if(null==pe.getEquipContractNum()||"".equals(pe.getEquipContractNum().toString().toString())){
						if(!message.contains("车辆合同小号")){
							message.add("车辆合同小号");
						}
					}
					if(null==pe.getChassisNum()||"".equals(pe.getChassisNum().toString().toString())){
						if(!message.contains("车架号")){
							message.add("车架号");
						}
					}
				}
				
				if(null==pe.getPurchaseTax()){
					if(!message.contains("购置税")){
						message.add("购置税");
					}
				}
				if(null==pe.getInsureMoney()){
					if(!message.contains("保费")){
						message.add("保费");
					}
				}
				if(null==pe.getLeasingMoney()){
					if(!message.contains("其他融资额")){
						message.add("其他融资额");
					}
				}
			}
		}else{
			message.add("租赁物件");
		}
		if(message.size()>0){
			return message.toString();
		}else{
			return "";
			}
	}
}
