<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商额度管理</title>
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
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		
   		 tableComment:'[经销商额度管理]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'经销商额度管理',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/own_manage/owninfo.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         tools:[{
			html : '<font color="red">生成通知函</font>',
			handler : function(table) {
				var projIDValue = table.getCheckedRowDatas();
				if (0 == projIDValue.length) {
					alert("请选择需要生成的通知函！");
					return false;
				}
			},
			iconCls :'icon-update'
         }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'经销商名称',name:'column1'},
		            {header:'当前授信额度',name:'column2'},
		            {header:'当前授信开始日期',name:'column3'},
		            {header:'当前授信结束日期',name:'column4'},
		            {header:'通知函',name:'column5'}
	        ]
         
   	 });
   	 
   });
	 jQuery(function(){
	    	dict('id_condition_dealer','column1','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
	    	dict('id_credit_limit','column9','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
	    	dict('id_adjust_mode','column6','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
		    });
	 
	</script>
 
</head>
<body>
	<%---展示 经销商额度管理信息--%>
    <div id="id_tableContainer"></div>
	<%---添加 经销商额度管理--%>
	<div id="id_detailInfoWindowContainer"  title="经销商额度管理" style="display:none;width:800px;height:400px">
        <center>
	        <form id="id_detailInfoForm">
		        <table style="width:90%">
		         
		            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
		            <tr>
		           <td class="input_label_desc" align="left">经销商名称:  </td>  
		            	<td class="td-content">
		            		<div class="leftComboContainer" id="id_condition_dealer" readonly="readonly"></div>	
		            	</td>
		            	<td class="input_label_desc" align="left">当前授信额度:  </td>
		            	<td class="td-content">
		            	<input   type="text"  name="column2"  class="td-content-input" readonly="readonly">	  
		            	</td>
		            </tr>
		            <tr>
		            	<td class="input_label_desc" align="left">当前授信开始日期:  </td>  
		            	<td class="td-content">
		            		<input class="Wdate td-content-input" readonly name="column3"  type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
		            	</td>
		            	<td class="input_label_desc" align="left">当前授信结束日期:  </td>  
		            	<td class="td-content">
					      <input class="Wdate td-content-input" readonly name="column4" type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
		               </td>
		            </tr>
		            <tr>
		            <td class="input_label_desc" align="left">授信金额额度调整为:  </td>  
		            	<td class="td-content">
		            	<input   type="text"  name="column5"  class="td-content-input" datatype="Number" require="true"  label="授信金额额度调整为"><span class="content-required">*</span>	  
		            	</td>
		            	<td class="input_label_desc" align="left">调整方式:  </td>
		            	<td class="td-content">
		            		<div class="leftComboContainer" id="id_adjust_mode"></div>	
		            	</td>
		            </tr>
		            <tr>
		            	<td class="input_label_desc" align="left">调整原因:</td>
					<td class="td-content" colspan="4">
					<textarea rows="5" cols="30" 
						style="width:98.9%;float:left;" name="tablename.column7" maxB="300">${requestScope['proj_other_info.projsurvey'] }</textarea>
					</td>
		            </tr>
		            <tr>
		            <td class="input_label_desc" align="left">调整日期:  </td>  
		            	<td class="td-content">
		            		<input class="Wdate td-content-input" readonly name="column8" type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
		            	</td>
		            	<td class="input_label_desc" align="left">通知函: </td>  
		            	<td class="td-content">
							<div id="id_credit_limit" class="leftComboContainer"></div>		            	
		            	</td>
		            </tr>
		            <tr class="content-separator">
		              <td colspan='4'><table cellspacing="0" cellpadding="0" border="1">
		                <col width="72" span="8">
		                <tr>
		                  <td rowspan="2" width="72">类别</td>
		                  <td rowspan="2" width="72">评价指标</td>
		                  <td colspan="2" rowspan="2" width="144">指标说明</td>
		                  <td rowspan="2" width="72">权重</td>
		                  <td colspan="3" width="216">评价标准</td>
	                    </tr>
		                <tr>
		                  <td width="72">优秀</td>
		                  <td width="72">较好</td>
		                  <td width="72">一般</td>
	                    </tr>
		                <tr>
		                  <td>1.0 产品需求持续性</td>
		                  <td>1.1 价格走势</td>
		                  <td colspan="2">价格走势与需求量走势基本保持相反方向</td>
		                  <td>70%</td>
		                  <td width="72">
		                    <input type="radio" name="radio" id="radio" value="radio">
	                      上升</td>
		                  <td width="72"><input type="radio" name="radio" id="radio2" value="radio">
	                      平稳</td>
		                  <td width="72"><input type="radio" name="radio" id="radio3" value="radio">
	                      下降</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>1.2 需求方规模</td>
		                  <td colspan="2" width="144">需求方企业规模越大、偿还货款可能性越大</td>
		                  <td>20%</td>
		                  <td width="72"><input type="radio" name="radio1" id="radio4" value="radio">
	                      国企</td>
		                  <td width="72"><input type="radio" name="radio1" id="radio5" value="radio">
	                      大民营企业</td>
		                  <td width="72"><input type="radio" name="radio1" id="radio6" value="radio">
	                      小规模企业</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>1.3 销售去向</td>
		                  <td colspan="2" width="144">产品销售去向越分散，风险可能越小</td>
		                  <td>10%</td>
		                  <td width="72"><input type="radio" name="radio2" id="radio7" value="radio">
	                      极度分散</td>
		                  <td width="72"><input type="radio" name="radio2" id="radio8" value="radio">
	                      少数几家</td>
		                  <td width="72"><input type="radio" name="radio2" id="radio9" value="radio">
	                      唯一</td>
	                    </tr>
		                <tr>
		                  <td>2.0 项目经营稳定性</td>
		                  <td>2.1 运量</td>
		                  <td colspan="2" width="144">运量明确可以保证承租人的总体收入稳定<br>
		                    车辆需求是否过剩</td>
		                  <td>70%</td>
		                  <td width="72"><input type="radio" name="radio3" id="radio10" value="radio">
	                      运量明确</td>
		                  <td width="72"><input type="radio" name="radio3" id="radio11" value="radio">
	                      按甲方随意安排</td>
		                  <td width="72"><input type="radio" name="radio3" id="radio12" value="radio">
	                      模糊不清</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>2.2 承包期限</td>
		                  <td colspan="2">承包期限是否覆盖融资期限决定承租人还款稳定性</td>
		                  <td>20%</td>
		                  <td width="72"><input type="radio" name="radio4" id="radio13" value="radio">
	                      完全覆盖</td>
		                  <td width="72"><input type="radio" name="radio4" id="radio14" value="radio">
	                      基本覆盖</td>
		                  <td width="72"><input type="radio" name="radio4" id="radio15" value="radio">
	                      不足覆盖</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>2.3 运价</td>
		                  <td colspan="2">运价明确可以保证承租人收入稳定、利润稳定</td>
		                  <td>10%</td>
		                  <td width="72"><input type="radio" name="radio5" id="radio16" value="radio">
	                      价格明确</td>
		                  <td width="72"><input type="radio" name="radio5" id="radio17" value="radio">
	                      随市场价格波动</td>
		                  <td width="72"><input type="radio" name="radio5" id="radio18" value="radio">
	                      模糊不清</td>
	                    </tr>
		                <tr>
		                  <td>3.0 项目结算可靠性</td>
		                  <td>3.1 项目开发方</td>
		                  <td colspan="2">开发方规模越大，对承租人资金支付能力越强</td>
		                  <td>70%</td>
		                  <td width="72"><input type="radio" name="radio6" id="radio19" value="radio">
	                      国企</td>
		                  <td width="72"><input type="radio" name="radio6" id="radio20" value="radio">
	                      大民营企业</td>
		                  <td width="72"><input type="radio" name="radio6" id="radio21" value="radio">
	                      小规模企业</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>3.2 结算方式</td>
		                  <td colspan="2" width="144">结算方式决定了承租人收入的时间<br>
		                    是否与还租时间匹配</td>
		                  <td>20%</td>
		                  <td width="72"><input type="radio" name="radio7" id="radio22" value="radio">
	                      按天结算</td>
		                  <td width="72"><input type="radio" name="radio7" id="radio23" value="radio">
	                      按月结算</td>
		                  <td width="72"><input type="radio" name="radio7" id="radio24" value="radio">
	                      不明确</td>
	                    </tr>
		                <tr>
		                  <td></td>
		                  <td>3.3 偿还租金比例</td>
		                  <td colspan="2" width="144">预测每月净利润/月租金<br>
		                    通过对账单收入或项目情况预算每月净利润</td>
		                  <td>10%</td>
		                  <td width="72"><input type="radio" name="radio8" id="radio25" value="radio">
	                      ≥2</td>
		                  <td width="72"><input type="radio" name="radio8" id="radio26" value="radio">
	                      (1,2)</td>
		                  <td width="72"><input type="radio" name="radio8" id="radio27" value="radio">
	                      ≤1</td>
	                    </tr>
	                  </table></td>
	              </tr>
		            <tr class="content-separator">
			            <td colspan='4'>
			                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
					         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			            </td>
		            </tr>
		        </table>
	        </form>
        </center>
	</div>
</body>
</html>