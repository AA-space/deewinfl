<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <script language="javascript">
    function showLawCustInfo(cust_id){
    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
    	var params = {cust_id:cust_id};
	    openFullScreenWindow(URL,params);
     }
    jQuery(function(){
    //######项目上基本信息#########  
        var temp=isViewHistoryTask;
        isViewHistoryTask=true;
    	dictYesOrNoByCode('id_is4s','dealer_approval_info.is4s','${requestScope["dealer_approval_info.is4s"]}');
    	isViewHistoryTask=temp;
       });
    </script>
    <table cellspacing="0" cellpadding="0"  id="proj_base_info">
          <tr >
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>经销商准入申请</td>
          </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">经销商名称：</td><td class="td-content">
              <input name="cust_info.id" type="hidden" value="${requestScope['cust_info.id'] }">
              <input  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
              <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${requestScope['cust_info.id'] }')"/></a>
             <font class="required-content">*</font></td>
             <td class="td-content-title">申请编号：</td><td class="td-content"><input name="dealer_approval_info.approvalnum" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.approvalnum'] }"><font class="required-content">*</font></td>
         </tr>
           <tr class="tr-project-info tr-odd">
             <td class="td-content-title">注册时间：</td><td class="td-content"><input name="dealer_approval_info.regdate" class="td-content-input td-content-readonly"  
             type="text" value="${requestScope['dealer_approval_info.regdate'] }"   readOnly require="true" label="注册时间" /><font class="required-content">*</font></td>
             <td class="td-content-title">注册资本：</td><td class="td-content"><input name="dealer_approval_info.regcapital" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.regcapital'] }"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-even">  
             <td class="td-content-title">实收资本：</td><td class="td-content"><input name="dealer_approval_info.incomeassets" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.incomeassets'] }"><font class="required-content">*</font></td>
             <td class="td-content-title">经销商区域：</td><td class="td-content"><input name="dealer_approval_info.ownerdistrict" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.ownerdistrict'] }"><font class="required-content">*</font></td>
         </tr>
		<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
			<div class="toggle-icon-expanded" title="折叠"
				toggleClass="tr-project-survey"></div>
			净资产</td>
		</tr>
		<tr class="tr-project-survey tr-even">
			<td class="td-content" colspan=6><textarea rows="5" cols="150"  label="净资产"
			class="td-content-input td-content-readonly"  readonly
				style="width: 98%;heigth:100px" name="dealer_approval_info.netassets">${requestScope['dealer_approval_info.netassets'] }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
			<div class="toggle-icon-expanded" title="折叠"
				toggleClass="tr-project-survey"></div>
			近三年销量</td>
		</tr>
		<tr class="tr-project-survey tr-even">
			<td class="td-content" colspan=6><textarea rows="5" cols="150"  label="近三年销量"
			class="td-content-input td-content-readonly"  readonly
				style="width: 98%;heigth:100px"  name="dealer_approval_info.threeyearsales">${requestScope['dealer_approval_info.threeyearsales'] }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
          <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">是否4S店：</td><td class="td-content"><div class="leftComboContainer" id="id_is4s"></div><font class="required-content">*</font></td>
             <td class="td-content-title">与陕汽合作时间：</td><td class="td-content"><input name="dealer_approval_info.cooperationdate" class="td-content-input td-content-readonly"  readonly  type="text"  value="${requestScope['dealer_approval_info.cooperationdate'] }"><font class="required-content">*</font></td>
         </tr>  
        </table>