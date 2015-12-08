<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <input name="proj_info.custid" id="proj_info.custid" type="hidden"  value="${requestScope['proj_info.custid'] }"/>
    <input name="proj_info.businesstype" id="proj_info.businesstype" type="hidden" value="${requestScope['proj_info.businesstype'] }"></input><%---业务类型 --%>
     <input name="proj_info.businessmode" id="proj_info.businessmode" type="hidden" value="${requestScope['proj_info.businessmode'] }"></input><%---业务模式 --%>
    <input name="proj_info.startdate" id="proj_info.startdate" type="hidden"  value="${requestScope['proj_info.startdate'] }"/>
    <input name="proj_info.enddate" id="proj_info.enddate" type="hidden"  value="${requestScope['proj_info.enddate'] }"/>
    <input name="proj_info.projstatus" id="proj_info.projstatus" type="hidden"  value="${requestScope['proj_info.projstatus'] }"/>
    <input name="proj_info.custdealer" id="proj_info.custdealer" type="hidden" value="${requestScope['proj_info.custdealer'] }"/>
     <script type="text/javascript">
     $(function(){
    	 dictYesOrNoByCode('id_proj_scale','proj_info.isregistration','${empty requestScope["proj_info.isregistration"] ? "0" : requestScope["proj_info.isregistration"] }',null,false,'require="true" label="是否上牌"',165,null,true,'否');
             if("${requestScope['proj_info.projdate']}"==""){
             	$("#id_projdate").val(getCurDate());
             }else{
             	$("#id_projdate").val("${requestScope['proj_info.projdate']}");
             }
    	}
     );
             </script>
    <table cellspacing="0" cellpadding="0"  id="proj_base_info">

         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>项目基本信息</td>
          </tr>
          <tr class="tr-project-info tr-even">
             <td class="td-content-title">项目编号：</td><td class="td-content"><input name="proj_info.projid" id ="project_id"  class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['proj_info.projid']}"></td>
             <td class="td-content-title">项目日期：</td><td class="td-content"><input id="id_projdate" name="proj_info.projdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_info.projdate']}" onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="项目日期" /><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:50%" name="proj_info.projectname" id="project_name"  require="true" label="项目名称" class="td-content-input"  type="text" value="${requestScope['proj_info.projectname']}"  onclick="createProjectName();" ><font class="required-content" style="width:130px">（系统自动生成）* </font></td>
          </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">客户编号：</td><td class="td-content">
             <input name="proj_info.custnumber" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['proj_info.custnumber'] }">
              <input name="proj_info.cust_type" id="proj_info.cust_type" class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.cust_type'] }">
              <input name="proj_info.business_type"  id="id_business_type"   class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.business_type'] }">
             <font class="required-content">*</font></td>
             <td class="td-content-title">承租单位：</td><td class="td-content"><input id="cust_name" name="proj_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="承租单位"  type="text" value="${requestScope['proj_info.custname'] }" >
              <font class="required-content">*</font>
               <a href="javascript:void(0);">
               <img alt="客户信息" src="${pageContext.request.contextPath}/menuIcons/department.png" 
               onclick="showEwlpCustInfo('${requestScope['proj_info.custid'] }')"/></a>
              </td>
         </tr>
         <%---
         <tr class="tr-project-info tr-odd" id="id_business_table">
             <td class="td-content-title">业务类别：</td><td class="td-content"><div class="leftComboContainer" id="id_businesstype"></div><font class="required-content">*</font></td>
             <td class="td-content-title">业务模式：</td><td class="td-content"><div class="leftComboContainer"  id="id_businessmode"></div><font class="required-content">*</font></td>
          </tr>
           --%>
           <tr class="tr-project-info tr-even">
             <td class="td-content-title">活动类型：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_type"></div></td>
          </tr>
          <tr class="tr-project-info tr-odd">  
             <td class="td-content-title">项目来源：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_source"></div><font class="required-content">*</font></td>
             <td class="td-content-title">是否第三方代付：</td><td class="td-content"><div class="leftComboContainer" id="id_cust_kind"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">资产分类：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_type"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租赁形式：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_form"></div><font class="required-content">*</font></td>
         </tr>  
          <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_dept"></div></td>
             <td class="td-content-title">录入人员：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_registrar"></div></td>
         </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title"  colspan="3">项目经理：</td><td class="td-content">
             <div class="leftComboContainer" id="id_proj_manage"></div></td>
             <%--
             <td class="td-content-title">客户助理：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_assist"></div></td>
           	--%>
          </tr>
          <tr class="tr-project-info tr-even">
                <td class="td-content-title">是否上牌：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_scale"></div><font class="required-content">*</font></td>
          </tr>
        </table> 
        <script language="javascript">
        jQuery("#id_business_table").hide();//不可见,不需要选择
		    function showEwlpCustInfo(cust_id){
		    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
		    	var params = {cust_id:cust_id,read_only:'false'};
			    openFullScreenWindow(URL,params);
		    }
		    jQuery("#proj_base_info").css("width",formWidth+"px");
		        jQuery(function(){
		        	
		        	jQuery("#id_loadMaskContainer").show();
					//(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width,readOnlyData,islazyLoad)
			        dict('id_proj_type','proj_info.projtype','proj_type','${requestScope["proj_info.projtype"]}','非关联',''); 
			        //dict('id_proj_scale','proj_info.projscale','proj_scale','${requestScope["proj_info.projscale"]}',null,'require="true" label="项目规模"');
			        dict('id_proj_source','proj_info.projsource','proj_source','${requestScope["proj_info.projsource"]}',null,'require="true" label="项目来源"');
			        dictYesOrNoByCode('id_cust_kind','proj_info.isthirdpay','${empty requestScope["proj_info.isthirdpay"] ? "0" : requestScope["proj_info.isthirdpay"] }','',true,' require="true" label="是否第三方代付"');
			        dict('id_leas_type','proj_info.leastype','leas_type','${empty requestScope["proj_info.leastype"] ? "lease_type28" : requestScope["proj_info.leastype"] }',null,'require="true" label="资产分类"');
			        dict('id_leas_form','proj_info.leasform','leas_form','${empty requestScope["proj_info.leasform"] ? "lease_form1" : requestScope["proj_info.leasform"]}',null,'require="true" label="租赁形式"');
			        //dict('id_businesstype','proj_info.businesstype','bussiness_type','${requestScope["proj_info.businesstype"]}','${requestScope["proj_info.businesstype"]}','',null,true);//,'require="true" label="业务类型"'
				    //dict('id_businessmode','proj_info.businessmode','bussiness_mode','${requestScope["proj_info.businessmode"]}','${requestScope["proj_info.businessmode"]}','',null,true);//,'require="true" label="业务模式"'
			        
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_creatordept',
						width : 167,
						renderTo : 'id_proj_dept',
						xmlFileName : '\\eleasing\\workflow\\public\\department_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="项目出单部门"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'proj_info.projdept',
						displayField : 'name',
						valueField : 'id',
						value:"${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].id : requestScope['proj_info.projdept'] }",
						rawValue:"${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].name : requestScope['rawValue_proj_info.projdept'] }",
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_registrar',
						width : 167,
						renderTo : 'id_proj_registrar',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="录入人员"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'proj_info.projregistrar',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["proj_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["proj_info.projregistrar"]}',
						rawValue:'${empty requestScope["proj_info.projregistrar"] ? sessionScope.loginUser.realname : requestScope["proj_info.projregistrar"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_proj_manage',
						width : 167,
						renderTo : 'id_proj_manage',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_project_manager.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="项目经理"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'proj_info.projmanage',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["proj_info.projmanage"] ? sessionScope.loginUser.id : requestScope["proj_info.projmanage"]}',
						rawValue:'${empty requestScope["proj_info.projmanage"] ? sessionScope.loginUser.realname : requestScope["proj_info.projmanage"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_proj_assist',
						width : 167,
						renderTo : 'id_proj_assist',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="客户经理"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'proj_info.projassist',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["proj_info.projassist"] ? sessionScope.loginUser.id : requestScope["proj_info.projassist"]}',
						rawValue:'${empty requestScope["proj_info.projassist"] ? sessionScope.loginUser.realname : requestScope["proj_info.projassist"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			       jQuery("#id_loadMaskContainer").hide();
			   });

       </script>
         
	    