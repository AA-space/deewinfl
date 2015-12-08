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
    
    <div class="mini-panel" title="项目基本信息" showCollapseButton="true" style="width: 100%;">
		<table class="fillTable" cellspacing="0" cellpadding="0">
        
          <tr class="tr-project-info tr-even">
             <td class="td-content-title">项目编号：</td><td class="td-content"><input name="proj_info.projid" id ="project_id"  class="mini-textbox" readOnly type="text" value="${requestScope['proj_info.projid']}"></td>
             <td class="td-content-title">项目日期：</td><td class="td-content">
             <input id="id_projdate" name="proj_info.projdate" class="mini-datepicker" allowInput="false"/>
             </td>
         </tr>
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:50%" name="proj_info.projectname" id="project_name"  require="true" label="项目名称" class="mini-textbox"  type="text" value="${requestScope['proj_info.projectname']}"  onclick="createProjectName();" ><font style="width:130px;color:red;">（系统自动生成）* </font></td>
          </tr>
         <tr class="tr-project-info tr-even">
             <td class="td-content-title">活动类型：</td>
             <td class="td-content">
             <input name="proj_info.projtype" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'proj_type'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
            
             <td class="td-content-title">项目规模：</td>
             <td class="td-content">
             <input name="proj_info.projscale" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'proj_scale'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
             
          </tr>
          <tr class="tr-project-info tr-odd">  
             <td class="td-content-title">项目来源：</td>
             <td class="td-content">
             <input name="proj_info.projsource" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'proj_source'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
             <td class="td-content-title">内部行业：</td>
             <td class="td-content">
             <input name="custkind" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'cust_kind'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
             
          </tr>
          
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">固定资产：</td>
             <td class="td-content">
             <input name="proj_info.leastype" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'leas_type'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
             <td class="td-content-title">租赁形式：</td>
             <td class="td-content">
             <input name="proj_info.leasform" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'leas_form'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
         </tr>  
           <tr class="tr-project-info tr-even">   
             <td class="td-content-title">承租单位：</td><td class="td-content">
             <input id="cust_name" name="proj_info.custname" class="mini-textbox" readOnly require="true" label="承租单位"  type="text" value="${requestScope['proj_info.custname'] }" >
               <a href="javascript:void(0);">
               <img alt="客户信息" src="${pageContext.request.contextPath}/menuIcons/department.png" 
               onclick="showEwlpCustInfo('${requestScope['proj_info.custid'] }')"/></a>
              </td>
              <td class="td-content-title">客户编号：</td>
             <td class="td-content">
              <input name="proj_info.custnumber" class="mini-textbox" readOnly  type="text"  value="${requestScope['proj_info.custnumber'] }"/>
              <input name="proj_info.cust_type" id="proj_info.cust_type" class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.cust_type'] }"/>
              <input name="proj_info.business_type"  id="id_business_type"   class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['proj_info.business_type'] }"/>
             
             </td>
         </tr>
         <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_dept"></div></td>
             <td class="td-content-title">经办人(录入人员)：</td>
             <td class="td-content">
             <input name="proj_info.leasform" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_xmlFileName:'/eleasing/workflow/proj_approval/creator_combox.xml',_params:{pid:'leas_form'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
         
         </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">项目经理：</td><td class="td-content">
             <input name="proj_info.projmanage" class="mini-combobox baseinfoinput" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_xmlFileName:'/eleasing/workflow/proj_approval/creator_combox.xml',_params:{pid:'leas_form'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
			 </td>
             <td class="td-content-title">项目协办：</td><td class="td-content">
             <input name="proj_info.projassist" class="mini-combobox" textField="name"  required="true"
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_xmlFileName:'/eleasing/workflow/proj_approval/creator_combox.xml',_params:{pid:'leas_form'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
			 />
             </td>
          </tr>
     
         
</table>
<script language="javascript">
//生成项目名称
function createProjectName() {
	var project_name =jQuery('#project_name').val();
	//var dept_name = getTracywindyObject('id_combo_creatordept').getRawValue();
	var proj_id=$("#project_id").val();
	var cust_name=$("#cust_name").val();
	if (project_name == '') {
		project_name = proj_id+"-"+cust_name + '项目'+$("#id_business_type").val();
	}else{
        var srefix=project_name.substring(project_name.length-2);
        var stype=$("#id_business_type").val();
        if(srefix!=stype){
        	project_name=project_name+stype;
        }
	}
	jQuery('#project_name').val(project_name);
	jQuery('#project_name').removeAttr('readOnly');
}
            function onbeforeshowpopup(e) {
        	    miniui_ext.onbeforeshowpopup(e);
            }
        
		    function showEwlpCustInfo(cust_id){
		    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
		    	var params = {cust_id:cust_id,read_only:'false'};
			    openFullScreenWindow(URL,params);
		    }
</script>

