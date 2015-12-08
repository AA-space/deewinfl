<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <input name="proj_info.custid" id="proj_info.custid" type="hidden"  value="${requestScope['proj_info.custid'] }"/>
    <input name="proj_info.businesstype" id="proj_info.businesstype" type="hidden" value="${requestScope['proj_info.businesstype'] }"></input><%---业务类型 --%>
    <input name="proj_info.businessmode" id="proj_info.businessmode" type="hidden" value="bussiness_mode_cust"></input><%---业务模式--%>
    <input name="proj_info.startdate" id="proj_info.startdate" type="hidden"  value="${requestScope['proj_info.startdate'] }"/>
    <input name="proj_info.enddate" id="proj_info.enddate" type="hidden"  value="${requestScope['proj_info.enddate'] }"/>
    <input name="proj_info.projstatus" id="proj_info.projstatus" type="hidden"  value="${requestScope['proj_info.projstatus'] }"/>
     <input name="proj_info.custdealer" id="proj_info.custdealer" type="hidden" value="${requestScope['proj_info.custdealer'] }"/>
    <table cellspacing="0" cellpadding="0"  id="nocar_base_info">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>项目基本信息</td>
          </tr>
          <tr class="tr-project-info tr-even">
             <td class="td-content-title">项目编号：</td><td class="td-content"><input name="proj_info.projid" id ="project_id"  class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['proj_info.projid']}"></td>
             <td class="td-content-title">项目日期：</td><td class="td-content"><input name="proj_info.projdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_info.projdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="项目日期" /><font class="required-content">*</font></td>
         </tr> 
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:60%" name="proj_info.projectname" id="project_name"  require="true" label="项目名称"' class="td-content-input"  type="text" value="${requestScope['proj_info.projectname']}"  onclick="createProjectName();" ><font class="required-content" style="width:150px;">（系统自动生成）* </font></td>
          </tr>
          <tr class="tr-project-info tr-even">   
            <td class="td-content-title">客户编号：</td><td class="td-content">
             <input name="proj_info.custnumber" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['proj_info.custnumber'] }">
              <input name="proj_info.cust_type" class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.cust_type'] }">
              <input name="proj_info.business_type"  id="id_business_type"   class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.business_type'] }">
             <font class="required-content">*</font></td>
            <td class="td-content-title">承租单位：</td><td class="td-content"><input id="cust_name" name="proj_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="承租单位"  type="text" value="${requestScope['proj_info.custname'] }" >
              <font class="required-content">*</font>
                <a href="javascript:void(0);">
               <img alt="客户信息" src="${pageContext.request.contextPath}/menuIcons/department.png" 
               onclick="showEwlpCustInfo('${requestScope['proj_info.custid'] }')"/></a>
               </td>
         </tr>
           <tr class="tr-project-info tr-odd">
             <td class="td-content-title">活动类型：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_type"></div></td>
             <td class="td-content-title">项目规模：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_scale"></div></td>
          </tr>
          <tr class="tr-project-info tr-even">  
             <td class="td-content-title">项目来源：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_source"></div></td>
             <td class="td-content-title">是否第三方代付：</td><td class="td-content"><div class="leftComboContainer" id="id_cust_kind"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">资产分类：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_type"></div></td>
             <td class="td-content-title">租赁形式：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_form"></div><font class="required-content">*</font></td>
         </tr>  
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_dept"></div><font class="required-content">*</font></td>
             <td class="td-content-title">录入人员：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_registrar"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">客户经理：</td><td class="td-content" colspan="3">
             <div class="leftComboContainer" class="leftComboContainer" id="id_proj_manage"></div><font class="required-content">*</font></td>
             <%--
             <td class="td-content-title">客户助理：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_assist"></div><font class="required-content">*</font></td>
              --%>
          </tr>
        </table>
        <script language="javascript">
		    function showEwlpCustInfo(cust_id){
		    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
		    	var params = {cust_id:cust_id};
			    openFullScreenWindow(URL,params);
		        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
		    }
		    //######项目上基本信息#########
		    jQuery("#nocar_base_info").css("width",formWidth+"px");
	        jQuery(function(){
	        	jQuery("#id_loadMaskContainer").show();
				//dict(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width)
			    dict('id_proj_type','proj_info.projtype','proj_type','${requestScope["proj_info.projtype"]}',null);
			    dict('id_proj_scale','proj_info.projscale','proj_scale','${requestScope["proj_info.projscale"]}',null,'require="true" label="项目规模"');
			    dict('id_proj_source','proj_info.projsource','proj_source','${requestScope["proj_info.projsource"]}',null,'require="true" label="项目来源"');
			    dictYesOrNoByCode('id_cust_kind','proj_info.isthirdpay','${empty requestScope["proj_info.isthirdpay"] ? "0" : requestScope["proj_info.isthirdpay"] }','',true,' require="true" label="是否第三方代付"');
			    dict('id_leas_type','proj_info.leastype','leas_type','${requestScope["proj_info.leastype"]}',null,'require="true" label="资产分类"');
			    dict('id_leas_form','proj_info.leasform','leas_form','${requestScope["proj_info.leasform"]}',null,'require="true" label="租赁形式"');
			    //########公共下拉############
			    //当前用户选择当前部门 2013-8-16 edit by jason
			    //commonSelect('id_proj_dept',"(select ID_,NAME_ from t_depts where id_ in(${sessionScope['userDeptListSqlStr']}))",'id_','name_','proj_info.projdept','${empty requestScope["proj_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["proj_info.projdept"] }',null,' require="true" label="出单部门"');
			    commonSelect('id_proj_dept','t_depts','id_','name_','proj_info.projdept','${empty requestScope["proj_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["proj_info.projdept"] }',null,' require="true" label="出单部门"');
			    commonSelect('id_proj_registrar','t_users','id_','realname_','proj_info.projregistrar','${empty requestScope["proj_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["proj_info.projregistrar"]}',null,' require="true" label="录入人员"');
			    commonSelect('id_proj_manage','t_users','id_','realname_','proj_info.projmanage','${empty requestScope["proj_info.projmanage"] ? sessionScope.loginUser.id : requestScope["proj_info.projmanage"]}',null, ' require="true" label="客户经理"');
			    commonSelect('id_proj_assist','t_users','id_','realname_','proj_info.projassist','${empty requestScope["proj_info.projassist"] ? sessionScope.loginUser.id : requestScope["proj_info.projassist"]}',null,' require="true" label="客户助理"');
			    jQuery("#id_loadMaskContainer").hide();
		     });
           </script>
        