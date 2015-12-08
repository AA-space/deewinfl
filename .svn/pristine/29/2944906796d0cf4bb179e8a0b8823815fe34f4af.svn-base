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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商管理 - 经销商登记</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
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
<script language="javascript">
var cust_id="<%= request.getParameter("cust_id")%>";
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
    function initCustInfo(cust_id){
        var param={};
        param.CUST_ID=cust_id;
        param.xmlFileName='/eleasing/jsp/dealer_manage/dealer_info.xml';
        param.loginuser = "${sessionScope['login_userid']}";
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
			   
	   		    var scustinfo=res.responseText;
	   		    
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    // var $form=$("#id_custForm form");
	   		    //var $form=$("form");
	   		     //var arr=$form[0].elements;
	   		     
	   		     $("span").each(function(i, v){
	   		    	 var $v = $(v);
	   		    	var name = $v.attr("name");
		   		    if(name && ("undefined"!=typeof(currentRowData[name.toLowerCase()]))){
		   		    	$v.html(currentRowData[name.toLowerCase()]);
		   		    }
	   		     })
	   		     
	   	/* 	    jQuery.each(arr,function(k,v){
	   		     var name = v.name;
	   		     if(name && ("undefined"!=typeof(currentRowData[name.toLowerCase()]))){
	   		     v.value = currentRowData[name.toLowerCase()];
	   		   }
	   		   });  */
	   		 currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
			     alert(12);
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
    }	
   </script>
         <form>
           <table style="width:100%;height:100%" class="fillTable">
                     <tr style="display:none"><td><input name="id"  type="hidden" value=""/><input name="custid" id="custid" type="hidden" value=""/></td></tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title" style="width:15%">经销商名称:  </td>  
			            	<td class="td-content" style="width:35%">
			            		<span name="custname"></span>
			            	</td>
			            	<td class="td-content-title">合作经销商编号:  </td>  
			            	<td class="td-content">
			            	<span name="contractnum"></span>
			            	</td>  
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">是否二级经销商:  </td>  
			            	<td class="td-content">
			            	<span name="twolevelstatusname"></span>
			            	</td>      	
			            	<td class="td-content-title">所属一级经销商:  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<span name="onelevelname"></span>
			            	</td>
			            </tr>
			               <tr  class="tr-odd">
			            	<td class="td-content-title">合作状态:  </td>  
			            	<td class="td-content">
			            	<span name="dealerstatusname"></span>
			            	</td>      	
			            	<td class="td-content-title">组织结构代码(统一社会信用代码):  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<span name="orgcode"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">纳税人类别:  </td>  
			            	<td class="td-content">
			            	<span name="taxlevelname"></span>
			            	</td>
			            	<td class="td-content-title">客户规模:  </td>  
			            	<td class="td-content">
			            	<span name="custscalename"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">纳税人识别号/国税登记号:  </td>  
			            	<td class="td-content">
			            	    <span name="taxregcode"></span>
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            	<span name="taxphone"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">开户行:  </td>  
			            	<td class="td-content">
			            	<span name="taxbank"></span>
			            	</td>
			            	<td class="td-content-title">开户账号:  </td>  
			            	<td class="td-content">
			            	<span name="taxacc"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">货款卡号:  </td>  
			            	<td class="td-content">
			            	<span name="creditcard"></span>
			            	</td>
			            	<td class="td-content-title">企业性质:  </td>  
			            	<td class="td-content">
			            	<span name="ownershipname"></span>
			            	</td>
			            </tr>
			             <tr class="tr-even">
			            	<td class="td-content-title">省份:  </td>  
			            	<td class="td-content">
			            	<span name="provincename"></span>
			            	</td>
			            	<td class="td-content-title">城市:  </td>  
			            	<td class="td-content">
			            	<span name="cityname"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">区县:  </td>  
			            	<td class="td-content">
			            	<span name="countyname" ></span>
			            	</td>
			            	<td class="td-content-title">是否4S: </td>  
			            	<td class="td-content">
			            	<span name="is4sname"></span>
			            	</td>
			            </tr>
			            
			             <tr  class="tr-even">
			            	<td class="td-content-title">法人代表:  </td>  
			            	<td class="td-content">
			            	<span name="legalrepresentative"></span>
			            	</td>
			            	<td class="td-content-title">法人代表身份证:  </td>  
			            	<td class="td-content">
			            	<span name="idcardno"></span>
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title">手机:  </td>  
			            	<td class="td-content">
			            	<span name="mobilenumber"></span>
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            	<span name="phone"></span>
			            	</td>
			            </tr>
			             <tr  class="tr-even">
			            	<td class="td-content-title">公司邮寄地址:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="mailAdd"></span>
			            	</td>
			            </tr>
			            <tr   class="tr-odd">
			            	<td class="td-content-title">邮编:  </td>  
			            	<td class="td-content">
			            	<span name="postcode"></span>
			            	</td>
			            	<td class="td-content-title">公司网址:  </td>  
			            	<td class="td-content">
			            	<span name="website"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">公司地址: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="postaddr"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            <td class="td-content-title">传真:  </td>  
			            	<td class="td-content">
			            	<span name="faxnumber"></span>
			            	</td>
			            	<td class="td-content-title">登记注册号（营业执照号）: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="regnumber"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            <td class="td-content-title">注册时间 :  </td>  
			            	<td class="td-content">
			            	<span name="regdate"></span>
			            	</td>
			            	<td class="td-content-title">注册资本 :  </td>  
			            	<td class="td-content">
			            	<span name="regcapital"></span>
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title">注册地址 : </td>  
			            	<td class="td-content">
			            	<span name="regaddr"></span>
			            	</td>
			            	<td class="td-content-title">实收资本: </td>  
			            	<td class="td-content">
			            	<span name="incomeassets"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">经营范围（主营） : </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="bizscopeprimary"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">经营范围（兼营） : </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="bizscopesecondary"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">所属区域:  </td>  
			            	<td class="td-content">
			            	<span name="ownerdistrictname"></span>
			            	</td>
			            	<td class="td-content-title">办事处:  </td>  
			            	<td class="td-content">
			            	<span name="ownerofficename"></span>
			           </td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">近三年销量 : </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="threeyearsales"></span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">店面类型:  </td>  
			            	<td class="td-content">
			            	<span name="shoptypename"></span>
			            	</td>
			            	<td class="td-content-title">与陕汽合作开始时间:  </td>  
			            	<td class="td-content">
			            	<span name="cooperationdate"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title"> 目标销量: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="purposesales"></span>
			            	</td>
			            </tr>
			             <tr  class="tr-even">
			            	<td class="td-content-title"> 常住地址: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="oftenaddr"></span>
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title"> 净资产: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="oftenaddr"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title"> 股权结构: </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownershipstructure"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">自有车辆:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownervehicle"></span>
			            	</td>
			            </tr>
			             <tr   class="tr-even">
			            	<td class="td-content-title">房产:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownerestate"></span>
			            	</td>
			            </tr>
			             <tr   class="tr-odd">
			            	<td class="td-content-title">土地:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownerland"></span>
			            	</td>
			            </tr>
			             <tr   class="tr-even">
			            	<td class="td-content-title">其他:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownerother"></span>
			            	</td>
			            </tr>
			             <tr   class="tr-odd">
			            	<td class="td-content-title">资产估价（总）:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownershiptotal"></span>
			            	</td>
			            </tr>
			             <tr   class="tr-even">
			            	<td class="td-content-title">备注:  </td>  
			            	<td class="td-content" colspan="3">
			            	<span name="ownermemo"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            <td class="td-content-title">是否草稿: </td>  
			            	<td class="td-content">
			            	<span name="draftname"></span>
			            	</td>
			            	<td class="td-content-title">登记人部门:</td>  
			            	<td class="td-content">
			            	<span name="creatordeptname"></span>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            	<span name="creatorname"></span>
			            	</td>
			           	 <td class="td-content-title">登记时间: </td>  
			            	<td class="td-content">
			            	<span name="createdate"></span>
			            		<input name="invalid" id="invalid"  label="是否作废 " class="td-content-readonly" readonly="readonly"  type="hidden" />
			            		
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            <td class="td-content-title">修改人 :</td>  
			            	<td class="td-content">
			            	<span name="modificatorname"></span>
			            	</td>
			             <td class="td-content-title">修改时间:</td>  
			            	<td class="td-content">
			            	<span name="modifydate"></span>
			            	</td>
			            	
			           </tr>
			        </table>
			        </form>

</body>
<script>
initCustInfo(cust_id);
</script>
</html>