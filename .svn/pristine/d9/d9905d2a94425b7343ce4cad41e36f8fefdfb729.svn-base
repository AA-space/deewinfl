<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <input name="proj_info.custInfo" id="proj_info.custInfo" type="hidden"  value="${requestScope['proj_info.custInfo'] }"/>
    <input name="proj_info.projstatus" id="proj_info.projstatus" type="hidden"  value="${requestScope['proj_info.projstatus'] }"/>
    <input name="proj_info.custclass" id="proj_info.custclass" type="hidden"  value="${requestScope['proj_info.custclass'] }"/>
    
    <div id="form1">
    <div class="mini-panel" title="合同信息" showCollapseButton="true" style="width: 99%;">
	    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
	
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">项目编号：</td><td class="td-content"><input name="proj_info.projid" id ="project_id"  class="mini-textbox" readOnly type="text" value="${requestScope['proj_info.projid']}"></td>
	             <td class="td-content-title">项目日期：</td><td class="td-content">
	             <input id="id_projdate" name="proj_info.projdate" class="mini-datepicker" value="${requestScope['proj_info.projdate'] }"  required="true" allowInput="false"/>
	             <font class="required-tag">*</font>
	             </td>
	         </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:50%" name="proj_info.projectname" id="project_name"  required="true" label="项目名称" class="mini-textbox"  type="text" value="${requestScope['proj_info.projectname']}"  onclick="createProjectName();" >
	             <font class="required-tag">（系统自动生成）* </font></td>
	          </tr>
	          
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">客户编号：</td>
	             <td class="td-content">
	              <input name="proj_info.custnumber" class="mini-textbox" readOnly  type="text"  value="${requestScope['proj_info.custnumber'] }"/>
	              <font class="required-tag">*</font>
	             </td>
	                
	             <td class="td-content-title">承租单位：</td><td class="td-content">
	             <input id="cust_name" name="proj_info.custname" class="mini-textbox" readOnly require="true" label="承租单位"  type="text" value="${requestScope['proj_info.custname'] }" >
	             <font class="required-tag">*</font>
	               <a href="javascript:void(0);">
	               <img alt="客户信息" style="vertical-align:middle;" src="${pageContext.request.contextPath}/menuIcons/department.png" 
	               onclick="showEwlpCustInfo('${requestScope['proj_info.custid'] }')"
	               /></a>
	              </td>
	         </tr>
	          
	         <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">活动类型：</td>
	             <td class="td-content">
	             <input name="proj_info.projtype"   class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'proj_type'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projtype'] }" 
							   text="${requestScope['rawValue_proj_info.projtype'] }" 
							   onvaluechanged="comboboxChanged(e)"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projtype" name="rawValue_proj_info.projtype" value="${requestScope['rawValue_proj_info.projtype']}" class="mini-textbox" style="display:none"/>
	             </td>
	             
	             <td class="td-content-title">项目规模：</td>
	             <td class="td-content">
	             <input name="proj_info.projscale" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'proj_scale'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projscale'] }" 
							   text="${requestScope['rawValue_proj_info.projscale'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projscale" name="rawValue_proj_info.projscale" value="${requestScope['rawValue_proj_info.projscale']}" class="mini-textbox" style="display:none"/>
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">  
	             <td class="td-content-title">项目来源：</td>
	             <td class="td-content">
	             <input name="proj_info.projsource" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'proj_source'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
				               value="${requestScope['proj_info.projsource'] }" 
							   text="${requestScope['rawValue_proj_info.projsource'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projsource" name="rawValue_proj_info.projsource" value="${requestScope['rawValue_proj_info.projsource']}" class="mini-textbox" style="display:none"/>
	             </td>
	             <td class="td-content-title">内部行业：</td>
	             <td class="td-content">
	             <input name="proj_info.industrytype" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'cust_kind'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.industrytype'] }" 
							   text="${requestScope['rawValue_proj_info.industrytype'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.industrytype" name="rawValue_proj_info.industrytype"  value="${requestScope['rawValue_proj_info.industrytype']}" class="mini-textbox" style="display:none"/>
	             </td>
	             
	          </tr>
	          
	          <tr class="tr-project-info tr-odd">   
	             <td class="td-content-title">固定资产：</td>
	             <td class="td-content">
	             <input name="proj_info.leastype" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'leas_type'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							    value="${requestScope['proj_info.leastype'] }" 
							   text="${requestScope['rawValue_proj_info.leastype'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.leastype" name="rawValue_proj_info.leastype" value="${requestScope['rawValue_proj_info.leastype']}" class="mini-textbox" style="display:none"/>
	             </td>
	             <td class="td-content-title">租赁形式：</td>
	             <td class="td-content">
	             <input name="proj_info.leasform" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'leas_form'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.leasform'] }" 
							   text="${requestScope['rawValue_proj_info.leasform'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.leasform" name="rawValue_proj_info.leasform" value="${requestScope['rawValue_proj_info.leasform']}" class="mini-textbox" style="display:none"/>
	             </td>
	         </tr>  
	           
	         <tr class="tr-project-info tr-even">   
	             <td class="td-content-title">项目出单部门：</td>
	             <td class="td-content">
	             <input name="proj_info.projdept" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="id"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_xmlFileName:'/eleasing/workflow/public/department_combox.xml',_params:{pid:'leas_form',deptname:'子公司项目部'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projdept'] }" 
							   text="${requestScope['rawValue_proj_info.projdept'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projdept" name="rawValue_proj_info.projdept" value="${requestScope['rawValue_proj_info.projdept']}" class="mini-textbox" style="display:none"/>
	             </td>
	             <td class="td-content-title">经办人(录入人员)：</td>
	             <td class="td-content">
	             <input name="proj_info.projregistrar" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="id"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_xmlFileName:'/eleasing/workflow/public/creator_combox.xml',_params:{deptname:'子公司项目部'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projregistrar'] }" 
							   text="${requestScope['rawValue_proj_info.projregistrar'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projregistrar" name="rawValue_proj_info.projregistrar" value="${requestScope['rawValue_proj_info.projregistrar']}" class="mini-textbox" style="display:none"/>
	             </td>
	         
	         </tr>
	          <tr class="tr-project-info tr-odd">   
	             <td class="td-content-title">项目经理：</td><td class="td-content">
	             <input name="proj_info.projmanage" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="id"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_xmlFileName:'/eleasing/workflow/public/creator_combox.xml',_params:{deptname:'子公司项目部'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projmanage'] }" 
							   text="${requestScope['rawValue_proj_info.projmanage'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projmanage" name="rawValue_proj_info.projmanage" value="${requestScope['rawValue_proj_info.projmanage']}" class="mini-textbox" style="display:none"/>
				 </td>
				 <td class="td-content-title">项目协办：</td><td class="td-content">
	             <input name="proj_info.projassist" class="mini-combobox" textField="name"  required="true"
		                  	   valueField="id"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_xmlFileName:'/eleasing/workflow/public/creator_combox.xml',_params:{deptname:'子公司项目部'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info.projassist'] }" 
							   text="${requestScope['rawValue_proj_info.projassist'] }" 
							   onvaluechanged="comboboxChanged"
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.projassist" name="rawValue_proj_info.projassist" value="${requestScope['rawValue_proj_info.projassist']}" class="mini-textbox" style="display:none"/>
	             </td>
	          </tr>
	</table>
	</div>
</div>
<script language="javascript">

//控制只读页面
if(isViewHistoryTask){
mini.parse("form1");
var form = new mini.Form("form1");
var o = form.getData(); 
var fields = form.getFields();
for(var index =0;index<fields.length;index++){
	 //判断是否是下拉框控件，是则同时把text属性传入后台
	if(fields[index].uiCls == "mini-combobox" || fields[index].uiCls =="mini-datepicker"){
		fields[index].disable();
	}else{
		fields[index].allowInput=false;
	}
}
}
//生成项目名称
function createProjectName() {
	var project_name =mini.get("project_name").getValue();
	var proj_id=mini.get("project_id").getValue();
	var cust_name=mini.get("cust_name").getValue();
	if (project_name == '') {
		project_name = proj_id+"-"+cust_name + '项目';
	}
	mini.get("project_name").setValue(project_name);
	//jQuery('#project_name').removeAttr('readOnly');
}
 function onbeforeshowpopup(e) {
    miniui_ext.onbeforeshowpopup(e);
 }
 
 function comboboxChanged(e){
	 debugger;
	 var cbb=e.sender;
	 mini.get("rawValue_"+cbb.name).setValue(cbb.text);
 }
 
 function otherChanged(e){
	 //var cbb=e.sender;
	 mini.get("test").setValue("proj_scale1");
	 mini.get("test").setText("500万以下");
 }
 function showEwlpCustInfo(cust_id){
	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
	var params = {cust_id:cust_id,read_only:'false'};
	openFullScreenWindow(URL,params);
}
//点击客户打开详情
 function opencustdetail(id,name,custclass){
		/*
			title:'标题'
			showModal:'是否遮罩'
			showMaxButton:'是否显示最大化按钮'
			onload:页面打开时加载
			ondestroy:页面关闭时加载
		*/
		
	var url="";
		if(custclass=="CUST_INFO_COMPANY"){
			url=getRootPath()+"/leasing/cust_info/cust_company/cust_company_detail.bi?custid="+id+"&custname="+encodeURI(encodeURI(name));
		}else{
			url=getRootPath()+"/leasing/cust_info/cust_person/cust_person_detail.bi?opertype=upd&custid="+id+"&custname="+encodeURI(encodeURI(name));
		}
 	var win = mini.open({
         url: url,
         title: "编辑", width: 800, height: 500,
         showModal: false,
         showMaxButton: true,
         onload: function () {
             var iframe = this.getIFrameEl();
             var data = { action: "edit", id: id };
             iframe.contentWindow.SetData(data);
         },
         ondestroy: function (action) {
         }
     });
 	win.max();
}
</script>

