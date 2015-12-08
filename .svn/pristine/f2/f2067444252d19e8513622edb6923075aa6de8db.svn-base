<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
   
    <!-- 隐藏域 -->
    <input name="contract_info.id" id="contract_info.id" type="hidden"  value="${requestScope['contract_info.id'] }"/>
    <input name="project_info.id" id="project_info.id" type="hidden"  value="${requestScope['project_info.id'] }"/>
    <input name="contract_info.contractid" id="contract_info.id" type="hidden"  value="${requestScope['contract_info.contractid'] }"/>
    <input name="contract_info.custid" id="contract_info.custid" type="hidden"  value="${requestScope['contract_info.custid'] }"/>
    <input name="contract_info.startdate" id="contract_info.startdate" type="hidden"  value="${requestScope['contract_info.startdate'] }"/>
    <input name="contract_info.enddate" id="contract_info.enddate" type="hidden"  value="${requestScope['contract_info.enddate'] }"/>
    <input name="contract_info.contractstatus" id="contract_info.contractstatus" type="hidden"  value="${requestScope['contract_info.contractstatus'] }"/>
    <input name="contract_info.custdealer" id="contract_info.custdealer" type="hidden" value="${requestScope['contract_info.custdealer'] }"/>
    <input name="contract_info.custdealername" id="contract_info.custdealername" type="hidden" value="${requestScope['contract_info.custdealername'] }"/>
    <input name="contract_info.projstatus" id="contract_info.projstatus" type="hidden" value="${requestScope['contract_info.projstatus'] }"/>
    <input name="cust_type" id="proj_info.cust_type" class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.cust_type'] }"> 
         <table id="contract_base_info" cellspacing="0" cellpadding="0">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-info"></div>合同基本信息</td>
          </tr>
          <tr class="tr-contractect-info tr-even">
             <td class="td-content-title">项目编号：</td><td class="td-content"><input name="contract_info.projid" id="projid" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.projid']}"></td>
             <td class="td-content-title">合同号：</td><td class="td-content"><input name="contract_info.contractnumber" id="contractid" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.contractnumber']}"  label="合同号" ><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">
             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:60%" name="contract_info.projectname" id="contractect_name" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.projectname']}"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">承租单位：</td><td class="td-content"><input name="contract_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="承租单位"  type="text" value="${requestScope['contract_info.custname'] }" >
             <font class="required-content">*</font>
             <a href="javascript:void(0);">
               <img alt="客户信息" src="${pageContext.request.contextPath}/menuIcons/department.png" 
               onclick="showEwlpCustInfo('${requestScope['contract_info.custid'] }')"/></a>
             </td>
             <td class="td-content-title">客户编号：</td><td class="td-content"><input name="contract_info.custnumber" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['contract_info.custnumber'] }"><font class="required-content">*</font></td>
         </tr>
           <tr class="tr-contractect-info tr-even">
             <td class="td-content-title">活动类型：</td><td class="td-content"><div class="leftComboContainer" id="id_contract_type"></div></td>
             <td class="td-content-title">经销商合作协议号：</td><td class="td-content">
             <input name="dealear_xiey" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealear_xiey'] }">
			</td>
          </tr>
          <tr class="tr-contractect-info tr-even">  
             <td class="td-content-title">项目来源：</td><td class="td-content"><div class="leftComboContainer" id="id_contract_source"></div></td>
             <td class="td-content-title">是否第三方代付：</td><td class="td-content"><div class="leftComboContainer" id="id_cust_kind"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">固定资产分类：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_type"></div></td>
             <td class="td-content-title">租赁形式：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_form"></div><font class="required-content">*</font></td>
         </tr>  
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><div class="leftComboContainer" id="id_contract_dept"></div><font class="required-content">*</font></td>
             <td class="td-content-title">录入人员：</td><td class="td-content"><div class="leftComboContainer" id="id_contract_registrar"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">项目经理：</td><td class="td-content" colspan="3"><div class="leftComboContainer" id="id_contract_manage"></div><font class="required-content">*</font></td>
             <%--
             <td class="td-content-title">客户助理：</td><td class="td-content"><div class="leftComboContainer" id="id_contract_assist"></div><font class="required-content">*</font></td>
           	 --%>
          </tr>
        </table>
        <script language="javascript">	
	        function showEwlpCustInfo(cust_id){
		    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
		    	var params = {cust_id:cust_id,read_only:'false'};
			    openFullScreenWindow(URL,params);
		    }
	        jQuery("#contract_base_info").css("width",formWidth+"px");
	        jQuery(function(){
	        	jQuery("#id_loadMaskContainer").show();
			    //######合同基本信息#########
				//dict(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width)
			    dict('id_contract_type','contract_info.projtype','proj_type','${requestScope["contract_info.projtype"]}','${requestScope["rawValue_contract_info.projtype"]}');
			    //dict('id_contract_scale','contract_info.projscale','proj_scale','${requestScope["contract_info.projscale"]}','${requestScope["rawValue_contract_info.projscale"]}');
			    dict('id_contract_source','contract_info.projsource','proj_source','${requestScope["contract_info.projsource"]}','${requestScope["rawValue_contract_info.projsource"]}');
			    
			    isViewHistoryTask = false;
			    dictYesOrNoByCode('id_cust_kind','proj_info.isthirdpay','${empty requestScope["proj_info.isthirdpay"] ? "0" : requestScope["proj_info.isthirdpay"] }','',true,' require="true" label="是否第三方代付"');
			    isViewHistoryTask = true;
			    
			    dict('id_leas_type','contract_info.leastype','leas_type','${requestScope["contract_info.leastype"]}','${requestScope["rawValue_contract_info.leastype"]}');
			    dict('id_leas_form','contract_info.leasform','leas_form','${requestScope["contract_info.leasform"]}','${requestScope["rawValue_contract_info.leasform"]}','require="true" label="租赁形式"');
			    //########公共下拉############
			    new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_creatordept',
						width : 167,
						renderTo : 'id_contract_dept',
						xmlFileName : '\\eleasing\\workflow\\public\\department_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="项目出单部门"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'contract_info.projdept',
						displayField : 'name',
						valueField : 'id',
						value:"${empty requestScope['contract_info.projdept'] ? sessionScope['loginUserDeptObj'].id : requestScope['contract_info.projdept'] }",
						rawValue:"${empty requestScope['contract_info.projdept'] ? sessionScope['loginUserDeptObj'].name : requestScope['rawValue_contract_info.projdept'] }",
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_registrar',
						width : 167,
						renderTo : 'id_contract_registrar',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="录入人员"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'contract_info.projregistrar',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["contract_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["contract_info.projregistrar"]}',
						rawValue:'${empty requestScope["contract_info.projregistrar"] ? sessionScope.loginUser.realname : requestScope["contract_info.projregistrar"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_proj_manage',
						width : 167,
						renderTo : 'id_contract_manage',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_project_manager.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="项目经理"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'contract_info.projmanage',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["contract_info.projmanage"] ? "" : requestScope["contract_info.projmanage"]}',
						rawValue:'${empty requestScope["contract_info.projmanage"] ? "" : requestScope["contract_info.projmanage"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});
			        /*
			        new tracywindyComboBox({
						lazyLoad:true,
						id : 'id_combo_proj_assist',
						width : 167,
						renderTo : 'id_contract_assist',
						xmlFileName : '\\eleasing\\workflow\\public\\creator_combox.xml',
						loadMode : 'ajax',
						readOnly : false,
						isAjaxLenovo : true,
						otherAttributes:'require="true"  label="客户经理"',
						topAdd : 0,
						leftAdd : 0,
						positionDropIconLeftAdd : -1,
						name : 'contract_info.projassist',
						displayField : 'name',
						valueField : 'id',
						value:'${empty requestScope["contract_info.projassist"] ? sessionScope.loginUser.id : requestScope["contract_info.projassist"]}',
						rawValue:'${empty requestScope["contract_info.projassist"] ? sessionScope.loginUser.realname : requestScope["contract_info.projassist"]}',
						params : {
							dealer_id:"${sessionScope['currentDealerCustInfoId']}"
						}
						
					});*/
			    
					/*
			    commonSelect('id_contract_dept','t_depts','id_','name_','contract_info.projdept','${empty requestScope["contract_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["contract_info.projdept"] }','${empty requestScope["rawValue_contract_info.projdept.name"] ? sessionScope["loginUserDeptObj"].name : requestScope["rawValue_contract_info.projdept.name"] }', 'require="true" label="出单部门"');
			    commonSelect('id_contract_registrar','t_users','id_','realname_','contract_info.projregistrar','${empty requestScope["contract_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["contract_info.projregistrar"]}','${empty requestScope["rawValue_contract_info.projregistrar.realname"] ? sessionScope.loginUser.realname : requestScope["rawValue_contract_info.projregistrar.realname"]}','require="true" label="录入人员"');

			    commonSelect('id_contract_manage','t_users','id_','realname_','contract_info.projmanage','${empty requestScope["contract_info.projmanage"] ? sessionScope.loginUser.id : requestScope["contract_info.projmanage"]}','${empty requestScope["rawValue_contract_info.projmanage"] ? sessionScope.loginUser.realname : requestScope["rawValue_contract_info.projmanage.realname"]}','require="true" label="客户经理"');
			    commonSelect('id_contract_assist','t_users','id_','realname_','contract_info.projassist','${empty requestScope["contract_info.projassist"] ? sessionScope.loginUser.id : requestScope["contract_info.projassist"]}','${empty requestScope["rawValue_contract_info.projassist"] ? sessionScope.loginUser.realname : requestScope["rawValue_contract_info.projassist.realname"]}','require="true" label="客户助理"');
                */
			    jQuery("#id_loadMaskContainer").hide();
		    });
	    </script>
        