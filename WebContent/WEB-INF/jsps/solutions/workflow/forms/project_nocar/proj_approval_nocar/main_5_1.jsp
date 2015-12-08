<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="boot.jsp"></jsp:include>
<title>商务条件</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
<style>
	.td-content-title{
		width:140px;
	}
</style>
</head>
<body>
    <div class="fillTableContainer">
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan=4>
					<!-- 插入项目基本信息 --> <jsp:include page="condition_frame_5_1.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td colspan=4>
					<div class="mini-panel" title="租金计划" showCollapseButton="true" style="width: 100%;">
					  	 <div id="tabDeatils" class="mini-tabs" activeIndex="0" style="width: 100%;height:300px;" bodyStyle="padding:0;border:0;">
							 <div title="租金计划" name="" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project/proj_approval/fun_rent_plan_frame.bi">
								
							 </div>
							 <div title="现金流" name="" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project/proj_approval/fund_cash_plan_frame.bi">
								
							 </div>
							 <div title="资金收付计划" name="" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project/proj_approval/fund_fund_plan.bi">
							 </div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
mini.parse();
var form = new mini.Form("businessconditionForm");
function onbeforeshowpopup(e) {	
	miniui_ext.onbeforeshowpopup(e);
}
function changefirstpaymentratio(e){
	var equipamt = getNumber("equipamt");//设备款
	var firstpayment = getNumber("firstpayment");//首付款
	var firstpaymentratio = mini.get("firstpaymentratio");//首付比例
	if("" == equipamt || "" == firstpayment) return;
	var firstpaymentratiovalue = decimal(firstpayment/equipamt*100, 6);
	firstpaymentratio.setValue(firstpaymentratiovalue);
}
//获取对象的数值
function getNumber(id){
    var value = mini.get(id).getValue();
    try {
    	value = (value+'').replace(/,/g,'');
    	value = value == '' ? '0' : value;
    	value = parseFloat(value);
    } catch(e) {
    	value = 0;
    }
    return value;
}
function decimalReal(num,v)
{
   var dight  =(num*Math.pow(10,v)/Math.pow(10,v)).toFixed(v);  
   return parseFloat(dight);
} 
//四舍五入
function decimal(num,v)
{	//num表示要四舍五入的数,v表示要保留的小数位数。
	if(0 == v)
	{
		return decimalReal(decimalReal(num,2),0);
	}
    return decimalReal(num,v);		
}
function $minigetvalue(id){
	return mini.get(id).getValue();
}

//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
var temp = parent.document.getElementById("id_json_business_condition_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
//form.setData(mini.decode(temp));
//miniui_ext.initcomboboxloaddata("businessconditionForm",mini.decode(temp));
//调用返回到主页面
function returnTab(){
	miniui_ext.gettextsbyfromid(form.el.id,"id_json_business_condition_str");
	return form;
}
//控制只读页面
if (isViewHistoryTask == "true") {
	miniui_ext.initformenabled("businessconditionForm");
}
</script>
</html>

