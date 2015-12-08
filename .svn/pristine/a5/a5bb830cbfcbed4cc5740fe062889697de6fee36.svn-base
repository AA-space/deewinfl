<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   html,body{
	     overflow:hidden;
	   }
	   .tr_td_dashed{
	   	 border:#DDD 1px dotted;
	   }
	   input[type="text"]{
	   	 border:silver 1px solid;
	   }
	   input[type="checkbox"]{
	   	 vertical-align:middle;
	   	 display:inline-block;
	   }
</style>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险清单 - 保险明细</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
	
</head>
<body >
<div style="margin-left: 10px; margin-top: 10px; height: 30px; width: 80%">
		<div id="title" class="x-panel-table-div-title" style="width: 80px; text-align: center">保险信息</div>
	</div>
	<script type='text/javascript'>
	var currentClienthHeight = document.documentElement.clientHeight;
	var heightAdd = 50;
	jQuery(function(){
	    jQuery("#mianbody").css({height:currentClienthHeight-heightAdd});
	    jQuery("#id_custForm").css({height:currentClienthHeight-heightAdd-50});
	});
	</script>
	<div id="mianbody" style="border-style: solid; margin: 0 10px 10px 10px; border-color: #DDDDDD; border-width: 2px; width: 97%; text-align: center">
		<div id="id_custForm" style="overflow: auto; margin: 10px 10px 10px 10px; border-style: solid; border-color: #DDDDDD; border-width: 2px; width: 98.2%; ">
<script language="javascript">
var insurid="<%= request.getParameter("insurid")%>";
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
    function initCustInfo(cust_id){
        var param={};
        param.insurid=insurid;
        param.xmlFileName='/eleasing/jsp/insure_manage/insurance_info.xml';
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
			   
    		 var scustinfo=res.responseText;
	   		    
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    // var $form=$("#id_custForm form");
	   			$("span").each(function(i, v){
	   		    	 var $v = $(v);
	   		    	var name = $v.attr("name");
		   		    if(name && ("undefined"!=typeof(currentRowData[name.toLowerCase()]))){
		   		    	$v.html(currentRowData[name.toLowerCase()]);
		   		    }
	   		     })
	   		 currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
 }	
    
    $(function(){
    	$(":input").each(function(index,input){
    		$(input).css('border','none');
    		$(input).css('background','none');
    	});
    })
   </script>
 <form>
    <table style="width:100%" class="fillTable">
			            <tr style="display:none"><td><span name="id" type="hidden" value=""/></td></tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">车架号</td>
			            	<td class="td-content">
			            	<span name="chassisno"></span>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content">
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">合同编号:  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<span name="contractidshow" />
			            	</td>
			            	<td class="td-content-title">客户名:  </td>  
			            	<td class="td-content">
			            		<span name="custname" /></span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">投保人全称：</td>
			            	<td class="td-content">
			            		<span name="insuredA" /></span>
			            	</td>
			            	<td class="td-content-title">投保人证件类型：</td>
			            	<td class="td-content">
			            	<span name="insuredacardtypename"></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">投保人证件号</td>
			            	<td class="td-content">
			            		<span name="insuredACardNo"></span>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content"></td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">被保险人全称：</td>
			            	<td class="td-content">
			            		<span name="insuredb" ></span>
			            	</td>
			            	<td class="td-content-title">被保险人证件类型：</td>
			            	<td class="td-content">
			            	<span name="insuredbcardtypename"></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">被保险人证件号</td>
			            	<td class="td-content">
			            		<span name="insuredbCardNo"></span>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content"></td>
			            </tr>
			            
			            <tr class="tr-odd">
			            	<td class="td-content-title">行驶证车主：</td>
			            	<td class="td-content">
			            		<span name="diverhost" ></span>
			            	</td>
			            	<td class="td-content-title">品牌型号：</td>
			            	<td class="td-content">
			            		<span name="brands" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">性质</td>
			            	<td class="td-content">
			            		<span name="property"></span>
			            	</td>
			            	<td class="td-content-title">车牌号（旧车）</td>
			            	<td class="td-content">
			            		<span name="oldCarNo" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">初次登记日期</td>
			            	<td class="td-content">
			            		<span name="firstRegDate" ></span>
			            	</td>
			            	<td class="td-content-title">核定载客/整备质量</td>
			            	<td class="td-content">
			            		<span name="capacityAndQuality" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">车辆类型</td>
			            	<td class="td-content">
			            		<span name="carType" ></span>
			            	</td>
			            	<td class="td-content-title">车辆/挂车购置价格</td>
			            	<td class="td-content">
			            		<span name="carPrice" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">整车合计价格</td>
			            	<td class="td-content">
			            		<span name="carPriceTotal" ></span>
			            	</td>
			            	<td class="td-content-title">发动机号</td>
			            	<td class="td-content">
			            		<span name="EngineNo" ></span>
			            	</td>
			            </tr>
			            
			            <tr class="tr-even">
			            	<td class="td-content-title">投保结束日期</td>
			            	<td class="td-content">
			            		<span name="beginDate" ></span>
			            	</td>
			            	<td class="td-content-title">投保结束日期</td>
			            	<td class="td-content">
			            		<span name="endDate" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">第一受益人</td>
			            	<td class="td-content">
			            		<span name="firstBeneficiary" ></span>
			            	</td>
			            	<td class="td-content-title">第二受益人</td>
			            	<td class="td-content">
			            		<span name="secondBeneficiary" ></span>
			            	</td>
			            </tr>
			             <tr class="tr-even">
			            	<td class="td-content-title">保险模式</td>
			            	<td class="td-content">
			            		<div>
			            		<span>
			            		<span name="insurtypeinfoname" ></span>
			            		</span>
			            		</div>
			            		<div>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content">
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">保险公司</td>
			            	<td colspan="3" align="left">
			            		
			            		<span>
      							保险公司名称:
			            		<span name="insuranceName" ></span>
			            		</span>
			            		
			            		</div>
			            		<div>
			            		<span>
      							联系方式:
			            		<span name="insuranceCommunication" ></span>
			            		</span>
			            		</div>
			            		<div>
			            		<span>
      							折扣:
			            		<span name="insuranceRebate" ></span>
			            		</span>
			            		</div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">备注</td>
			            	<td class="td-content" colspan="3">
			            	<span name="iimemo" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">经销商</td>
			            	<td class="td-content">
			            	<span name="dealername"></span>
			            	</td>
			            	<td class="td-content-title">联系方式</td>
			            	<td class="td-content">
			            		<span name="communicationType" ></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">联系人</td>
			            	<td class="td-content">
			            		<span name="communicationPerson" ></span>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content">
			            	</td>
			            </tr>
			        </table>
			        <table style="width:100% ;" border="1" cellpadding="0" bordercolorlight="#999999"
						bordercolordark="#FFFFFF" cellspacing="0" line-height="0px"; class="fillTable">
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" colspan="3" class="tr_td_dashed"><b>必投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" style="width:20%" class="tr_td_dashed"><b>险种</b></td>
					    	<td  align="center" style="width:60%" class="tr_td_dashed" ><b>保险金额或责任限额（元）</b></td>
					    	<td  align="center" style="width:20%" class="tr_td_dashed"><b>保险费（元）</b></td>
					    </tr>
						<tr class="tr-project-info tr-even tr_td_dashed" >
							<td  style="width:20%" class="tr_td_dashed" rowspan="2">机动车损失保险及不计免赔特约：</td>  
							<td class="tr_td_dashed">
							<div style="float: left; margin-left: 10px;">
					              <font>
					        是否不计免赔特约：<span name="isinsurance1" ></span><br>      
					              
					        </div>
					        </td>
					        <td style="width:60%" align="center" class="tr_td_dashed">
					        	<span  name="insuranceMoney1"  ></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed" >
					     	<td align="center" class="tr_td_dashed">（保险金额按车辆购置发票金额）<span  name="insurance1"></span>万元</font></td>
					     	<td align="center" class="tr_td_dashed"><span  name="insurance1Money2"  ></span></td>
					     </tr>
					     
					    <tr class="tr-project-info tr-odd tr_td_dashed" >
					        <td style="width:20%" class="tr_td_dashed" rowspan="2">第三者责任保险及不计免赔特约：</td>  
							<td align="center" class="tr_td_dashed">
							<div style="float: left; margin-left: 10px;">
							是否不计免赔特约：<span name="isinsurance2"></span>
							
							</div>
							</td>
							<td style="width:60%" align="center" class="tr_td_dashed">
					        	<span  name="insuranceMoney2" ></span>
					        </td>
						 </tr>
						 <tr class="tr-project-info tr-odd tr_td_dashed" >
					     	<td align="center" class="tr_td_dashed"><div id="id_insurance2"></div></td>
					     	<td align="center" class="tr_td_dashed"><span  name="insurance2Money2"  ></span></td>
					     </tr>
						 <tr class="tr-project-info tr-even tr_td_dashed">
					        <td style="width:20%" class="tr_td_dashed" rowspan="2">全车盗抢损失险及不计免赔特约：</td>
					        <td style="width:60%" class="tr_td_dashed">
					        <div style="float: left; margin-left: 10px;">
					        <font>
					        是否不计免赔特约：<span name="isinsurance3"></span><br>
					             	
					        </font>
					        </div>
					        </td class="tr_td_dashed">
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insuranceMoney3" ></span>
					        </td>
					     </tr> 
					      <tr class="tr-project-info tr-even tr_td_dashed" >
					     	<td align="center" class="tr_td_dashed">（首次投保保险金额按车辆购置发票金额）<span name="insurance3"></span>万元</td>
					     	<td align="center" class="tr_td_dashed"><span  name="insurance3Money2"  ></span></td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">      
					        <td class="tr_td_dashed" style="width:20%" rowspan="3">车上人员责任险：</td>
					        <td class="tr_td_dashed" style="width:60%" >
					        <div style="float: left; margin-left: 10px;">
					     	是否不计免赔特约：<span name="isinsurance5"></span><br>
					        </div>     	
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center" colspan="2">
					        	<span  name="insurance5Money2" ></span>
					        </td>
					     </tr> 
					       <tr class="tr-project-info tr-odd tr_td_dashed">
					       	<td class="tr_td_dashed"><font>
					        	驾&nbsp;驶&nbsp;员<span name="insurance4"></span>人
					        	保额<span name="insurance41" ></span>元/人
					        </font></td>
					       	<td class="tr_td_dashed" rowspan="2"><span name="insuranceMoney4"></span></td>
					       </tr> 
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:60%" >
					        <font>
					        	核定乘客<span name="insurance42"></span>人
					        	保额<span name="insurance43"></span>元/人
					        </font>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even  tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:20%" rowspan="2">自燃险：</td>
					     	<td class="tr_td_dashed" style="width:60%" >
					     	<div style="float: left; margin-left: 10px;">
					     	是否不计免赔特约：<span name="isinsurance7" ></span><br>
					      	 
					      	 </div>
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insuranceMoney7" ></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed" >
					     	<td align="center" class="tr_td_dashed"><span name="insurance7" label="自燃险"  type="text" datatype="PMoney"  ></td>
					     	<td align="center" class="tr_td_dashed"><span  name="insurance7Money2"  ></span></td>
					     </tr>      
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:20%">交强险：</td>
					     	<td class="tr_td_dashed" style="width:60%" >
					      	 <span name="insurance8"></span>
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insuranceMoney8" ></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:20%">车船税：</td>
					     	<td class="tr_td_dashed" style="width:60%" >
					      	 <span name="insurance6" ></span>
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insuranceMoney6" ></span>
					        </td>
					     </tr>
					     <tr class="tr-even">
			            	<td class="td-content-title">合计不计免赔项</td>
			            	<td class="td-content">
			            		<span  name="comeNoAbatement" ></span>
			            	</td>
			            	<td class="td-content-title"></td>
			            </tr>  
			            
			             <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td class="tr_td_dashed"  align="center" colspan="4"><b>工程机械险</b></td>
					    </tr>
					    <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >工程机械设备综合保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					            <span  name="insuranceMoney20"></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加第三者责任保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					            <span  name="insuranceMoney21"></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加整机盗抢保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					            <span  name="insuranceMoney22"></span>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加自然损失保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					            <span  name="insuranceMoney23"></span>
					        </td>
					     </tr>
			            
					        <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td class="tr_td_dashed"  align="center" colspan="3"><b>选投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:20%">玻璃单独破碎险：</td>
					     	<td class="tr_td_dashed" style="width:60%" >
					      	 <span name="insurance9" ></span>
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insuranceMoney9"></span>
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" style="width:20%" rowspan="2">车上货物责任险：</td>
					     	<td class="tr_td_dashed" style="width:60%" >
					     	<div style="float: left; margin-left: 10px;">
					     	是否不计免赔特约：<span name="isinsurance11" ></span><br>
					     	
					     	</span>
					     	</div>
					        </td>
					        <td class="tr_td_dashed" style="width:20%" align="center">
					        	<span  name="insurance11Money2"  ></span>
					        </td>
					     </tr>
					       <tr class="tr-project-info tr-odd tr_td_dashed" >
					     	<td align="center" class="tr_td_dashed"><span name="insurance10"></td>
					     	<td align="center" class="tr_td_dashed"><span  name="insuranceMoney10" ></span></td>
					     </tr>      
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed" align="center"><b>合计</b></td>
					     	<td class="tr_td_dashed" ></td>
					        <td class="tr_td_dashed"   align="center">
					            <span  name="feetotal"  ></span>
					        </td>
					     </tr>  
	</table>
</form>
		</div>
		<div style="text-align: right; height: 30px; margin: 0px">
			<a style="margin-left: 20px; margin-right: 20px" href="javascript:void(0);" class="btn btn-primary" onclick='window.close()'><span>关闭</span></a>
		</div>
	</div>
</body>
<script>
initCustInfo(insurid);
</script>
</html>