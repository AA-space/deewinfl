<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板管理</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
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
    function importExcelFormCallBack(message){
        alert(message);
    	window.location.reload();
    }
    function downloadFile(Id)
    {
      attachmentDown({url:"/leasing/template/downLoadAttachById.action?id="+Id});
    } 
    function downloadFileTemplateById(Id,fileType)
       {
        if(null==window.attachmentFileUploadloadMask)
       {
          attachmentFileUploadloadMask = new tracywindyLoadMask(document.body,"操作进行中 请稍等...");
          createAttachmentFileContainers();
      }
         attachmentFileUploadloadMask.show();
       var newAction = getRootPath()+"/leasing/template/downLoadTemplateAttach.action?browserType="+SysBrowser.getBrowser().toLowerCase();
         newAction+="&id="+Id+"&FileType="+fileType;
         uploadAttachmentFileFormSubmit(newAction);
        attachmentFileUploadloadMask.hide();
    } 
    function deleteFileAttache(id,url){
        var params={};
        params["currentId"]=id;
    	if(!window.currentDeleteFileLoadMask)
    	{
    	window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"文件正在删除 请稍等...");
    	} 
    	window.currentDeleteFileLoadMask.show();
    	ajaxRequest({
    		url:getRootPath()+url,
    		success:function(res){
    		    window.location.reload();
    		 },
    		failure:function(res){},
    		params:params 
    	});
    }
    function showDownLoadfile(value,tableObj,columnName,columnIndex,rowData){
        var base = "<a href='#' onclick='downloadFileTemplateById(\""+rowData.id+"\",\"{3}\")'>{1}</a>{2}";
        var separator = "&nbsp;&nbsp;";
        var updateFlag=value;
        var updateClickFunc="other";
        var field;
        if(rowData.templatepath.length<2){
        	field="没有模板";
         }else{
            field= base.replace("{1}","模板").replace("{3}","flt").replace("{2}",separator);
        }
        if(rowData.souretemplatepath.length<2){
        	field=field+separator+"没有源文件";
         }else{
        	 field=field+base.replace("{1}","源文件").replace("{3}","source").replace("{2}",separator);
        }
        return field;
      }
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 resetFormCallback:function(table,$form,operFlag){
   	   		 if("add" == operFlag){
   	   		 var status = getTracywindyObject("id_combo_id_status");
   	   	         status.setValue("0");
   	   	     }
   	   	     if("update" == operFlag){
   	   	  	 }
   	     },   
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   	   		 var rowData = table.getRowDataAt(rowIndex);
   	   	     var wordindustry = getTracywindyObject("id_combo_wordtempletypefirst");
   	       	 wordindustry.setValue(rowData["oneclassifycode"]);
   	         var wordindustry1 = getTracywindyObject("id_combo_id_two_classify");
	       	 wordindustry1.value  = (rowData["twoclassifycode"]);
	       	 wordindustry1.setParams({
	       		cur_code:rowData["twoclassifycode"]
		     });
	       	 wordindustry1.reload();
	         var wordindustry = getTracywindyObject("id_combo_id_three_classify");
	         wordindustry.value  = (rowData["threeclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["threeclassifycode"]
		     });
	       	 wordindustry.reload();
	       	 
   	         var wordindustry = getTracywindyObject("id_combo_id_four_classify");
   	         wordindustry.value  = (rowData["fourclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["fourclassifycode"]
		     });
	       	 wordindustry.reload(); 
   	       	 
	         var wordindustry = getTracywindyObject("id_combo_id_five_classify");
	         wordindustry.value  = (rowData["fiveclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["fiveclassifycode"]
		     });
	       	 wordindustry.reload(); 

	       	 var wordindustry = getTracywindyObject("id_combo_id_six_classify");
	         wordindustry.value  = (rowData["sixclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["sixclassifycode"]
		     });
	       	 wordindustry.reload(); 

	    	 var wordindustry = getTracywindyObject("id_combo_id_seven_classify");
	         wordindustry.value  = (rowData["sevenclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["sevenclassifycode"]
		     });
	       	 wordindustry.reload(); 

	    	 var wordindustry = getTracywindyObject("id_combo_id_eight_classify");
	         wordindustry.value  = (rowData["eightclassifycode"]);
	       	 wordindustry.setParams({
	       		cur_code:rowData["eightclassifycode"]
		     });
	       	 wordindustry.reload(); 
	       	 
	       	 var status = getTracywindyObject("id_combo_id_status");
	   	         status.setValue(rowData["status"]);
    	 },
   		 tableComment:'[模板清单]',
   		 constantFlagTable:'FileTemplate',
   		 tools:[
   		        {html:'<font color="red">上传模板</font>',handler:function(table){loadftl(table)},iconCls:'icon-update'},
   		        {html:'<font color="red">上传模板原文件</font>',handler:function(table){loadftlsource(table)},iconCls:'icon-update'},
   		        {html:'<font color="red">配置</font>',handler:function(table){configWord(table)},iconCls:'icon-update'}
      	   		 ],
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         prefixMVC:'leasing/template',
         suffixMVC:'.action',
         title:'模板清单',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/template_word/filetemplate_info.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:false,
         isAutoBreakContent:true,
         isRank:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'一级分类',name:'oneclassify',queryConfig:{}},
		            {header:'二级分类',name:'twoclassify',queryConfig:{}},
		            {header:'三级分类',name:'threeclassify',queryConfig:{}},
		            {header:'四级分类',name:'fourclassify',queryConfig:{}},
		            {header:'五级分类',name:'fiveclassify',queryConfig:{isNewLine:true}},
		            {header:'六级分类',name:'sixclassify',queryConfig:{}},
		            {header:'七级分类',name:'sevenclassify',queryConfig:{}},
		            {header:'八级分类',name:'eightclassify',queryConfig:{}},
		            {header:'模板编号',name:'templateno'},
		            {header:'显示名称',name:'templateshowname'},
		            {header:'模板名称',name:'templatename',queryConfig:{isNewLine:true}},
		            {header:'原文件',name:'templatename',renderer:showDownLoadfile}
	        ]
   	 });
 });
  jQuery(function(){
		dict('id_one_classify','oneclassify','wordtempletypefirst','${requestScope["oneclassify"]}',null,'');
		var twoclassify = new tracywindyComboBox({
		    width:200,
		    id:'id_combo_id_two_classify',
		    renderTo:'id_two_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'twoClassify',
		    displayField:'name',
		    valueField:'value'
		});
		var threethClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_three_classify',
		    id:'id_combo_id_three_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'threethClassify',
		    displayField:'name',
		    valueField:'value'
		});
		var fourClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_four_classify',
		    id:'id_combo_id_four_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'fourClassify',
		    displayField:'name',
		    valueField:'value'
		});
		var fiveClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_five_classify',
		    id:'id_combo_id_five_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'fiveClassify',
		    displayField:'name',
		    valueField:'value'
		});
		var sixClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_six_classify',
		    id:'id_combo_id_six_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'sixClassify',
		    displayField:'name',
		    valueField:'value'
		});

		var sevenClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_seven_classify',
		    id:'id_combo_id_seven_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'sevenClassify',
		    displayField:'name',
		    valueField:'value'
		});

		var eightClassify = new tracywindyComboBox({
		    width:200,
		    renderTo:'id_eight_classify',
		    id:'id_combo_id_eight_classify',
		    xmlFileName:'\\eleasing\\jsp\\template_word\\TemplateClassSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    isContainEmpty:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'eightClassify',
		    displayField:'name',
		    valueField:'value'
		});
		dictYesOrNoByCode('id_status','status','0',null,null,'label="是否草稿"');//是否草稿
		//dict('id_two_classify','twoclassify','wordtempletypetwo','${requestScope["twoclassify"]}',null,'');
		//dict('id_three_classify','threeclassify','wordtempletypethree','${requestScope["threeclassify"]}',null,'');
		//dict('id_four_classify','fourclassify','wordtempletypefour','${requestScope["fourclassify"]}',null,'');
		//dict('id_five_classify','fiveclassify','wordtempletypefive','${requestScope["fiveclassify"]}',null,'');
	});
</script>
</head>  
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="WORD模板息管理" style="display:none;width:500px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr><td class="input_label_desc">模板名称:  </td>  <td class="input_value"><input name="templatename" require="true" label="模板名称"   type="text" /><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">一分类:</td>  <td  class="td-content"><div class="leftComboContainer"     id="id_one_classify" style="display:inline-block"  ></div><span   class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">二级分类:</td>  <td class="td-content" ><div class="leftComboContainer"  id="id_two_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            <tr><td class="input_label_desc">三级分类:</td>  <td  class="td-content"><div class="leftComboContainer"   id="id_three_classify" style="display:inline-block"  ></div><span   class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">四级分类:</td>  <td class="td-content" ><div class="leftComboContainer"   id="id_four_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            <tr><td class="input_label_desc">五级分类:</td>  <td class="td-content" ><div class="leftComboContainer"   id="id_five_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            <tr><td class="input_label_desc">六级分类:</td>  <td class="td-content" ><div class="leftComboContainer"   id="id_six_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            <tr><td class="input_label_desc">七级分类:</td>  <td class="td-content" ><div class="leftComboContainer"   id="id_seven_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            <tr><td class="input_label_desc">八级分类:</td>  <td class="td-content" ><div class="leftComboContainer"   id="id_eight_classify" style="display:inline-block"  ></div><span   class="content-required">*<span></tr>
			            
			            <tr><td class="input_label_desc">显示名称:</td>  <td class="input_value"><input name="templateshowname" require="true" label="显示名称"   type="text" /><span class="content-required">*</span></td></tr>     
			            <td class="input_label_desc">是否启用:  </td>  
			            	<td class="td-content">
			            		<div style="display:inline-block" class="leftComboContainer" id="id_status"></div>
			            	</td>    
			            <tr class="content-separator">
				            <td colspan='2'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
	<div id="id_wordConfigdetailInfoWindowContainer"  closed="true" modal="true" title="模板数据配置" style="display:none;width:600px;padding-top:20px;">
	        <center>
		        <form id="d_wordConfigdetailForm">
			        <table style="width:100%" >
			              <tr>
			                 <td>
			                 <fieldset>
                              <legend>数据配置</legend>
			                 <table style="width:100%">
			                 <tr>
			                 <td style="width:30%" style="padding:5px">
			                      <SELECT NAME="WordData" id="id_WordData"  SIZE="16" style="width:100%;OVERFLOW: auto">
			                      
			                      </SELECT>
			                      </br>
			                 </td>
			                 <td rowspan="2" style="border:1px #000000 solid; border-top:0;border-bottom:0; border-right:0;padding:5px" > 
			                      <div style="display:none">
			                            <input name="wordConfig" id="id_wordConfig" value="">
			                            <input name="wordConfigjson" id="id_wordConfigjson" value="">
			                      </div>
			                      <table style="width:100%;" id="formDataConfig">
			                          <tr><td>关键字</td><td>
			                          <input style="width:100%" name="wordid" id="id_wordid"  type="hidden" value="" >
			                          <input style="width:100%" name="wordkey" id="id_wordkey" class="td-content-input"  type="text" value="" >
			                          </td></tr>
			                          <tr><td>数据类型</td><td id="id_keytype">
			                          <input type="radio" name="keytype" value="STRING" checked="checked" />字段 
			                          <input type="radio" name="keytype" value="LIST" />列表
			                          <input type="radio" name="keytype" value="TABLE" />表格
			                          </td></tr>
			                          <tr><td>数据来源</td><td id="id_datasource">
			                          <input type="radio" name="datasource" value="database" checked="checked" />数据库 
			                          <input type="radio" name="datasource" value="page" />页面
			                          </td></tr>
			                          <tr><td>多行控件名</td><td>
			                            <input style="width:100%" name="multiwordfield" id="id_multiwordfield" class="td-content-input"  type="text" value="" >
			                          </td></tr>
			                          <tr><td>数据列名</td><td>
			                          <input style="width:100%" name="wordfield" id="id_wordfield" class="td-content-input"  type="text" value="" >
			                          </td></tr>
			                          <tr><td>数据SQL</td><td>
			                          <textarea rows="5"  
			                                    style="width: 98%" name="datasql" id="id_datasql"></textarea>
			                          </td></tr>
			                          <tr><td>说明</td><td>
			                          <input style="width:100%" name="wordmemo" id="id_wordmemo" class="td-content-input"  type="text" value="" >
			                          </td></tr>
			                      </table>
			                 </td>
			                 </tr>
			                 <tr>
			                 <td style="heigth:100px">
			                      <a  style="margin-top:10px " href="javascript:void(0);" class="btn btn-primary"onclick='OP_AddWordDataConfig();'><span>新增</span></a>
						          <a  style="margin-top:10px " href="javascript:void(0);" class="btn btn-primary"onclick='OP_CopyWordDataConfig();'><span>复制</span></a>
						          <a  style="margin-top:10px " href="javascript:void(0);" class="btn btn-primary" onclick='OP_DeleteWordDataConfig()'><span>删除</span></a>
			                 </td>
			                 </tr>
			                 </table>
			                  </fieldset>
			                 </td>
			              </tr>
			              <tr class="content-separator">
				            <td colspan='2'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='OP_SubmitWordDataConfig();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_wordConfigdetailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
</body>
</html>
<script type="text/javascript" >
//加载word模板配置数据
function configWordData(id){
  if(!window.currentDeleteFileLoadMask)
	 {
	 window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"正在加载数据 请稍等...");
  } 
  window.currentDeleteFileLoadMask.show();
  var url="/leasing/template/loadFileTemplateDataConfig.action";
  var params={};
      params["id"]=id;
	  ajaxRequest({
	  	  		url:getRootPath()+url,
	  	  		success:function(res){
		           window.currentDeleteFileLoadMask.hide();
	  	           var json=res.responseText;
	  	        	 $("#id_wordConfigjson").val(json);   
	  	             var $window = $("#id_wordConfigdetailInfoWindowContainer");
	  	   	         initWordDataConfig()
	  	   	         $("#id_wordConfig").val(id);
	  	   	         $window.show();
	  	   	         $window.window({
	  	       	               top:20,
	  	       	               autoScroll:true
	  	       	     });
	  	   	         $window.window('open'); 
	  	  		 },
	  	  		failure:function(res){},
	  	  		params:params 
	  	  	});
	
}
//初始化模板数据配置
function initWordDataConfig(){
	var configDataStr=$("#id_wordConfigjson").val();
	var configData;
	if(configDataStr==""){
		configData=[];
    }else{
      configData=eval("("+configDataStr+")");
    }
	$("#id_WordData option").remove();  
	if(configData.length>0){
		for(var i=0;i<configData.length;i++){
		  $("#id_WordData").append("<option value='"+(i+1)+"' >"+configData[i].wordkey+"</option>");
		}
	}
	$("#id_WordData").click(function(){
		var configDataStr=$("#id_wordConfigjson").val();
		var configData;
		if(configDataStr==""){
			configData=[];
	    }else{
	      configData=eval("("+configDataStr+")");
	    }
		OP_initOptinsData( configData[this.value-1]);
		OP_AddFunction(this.value);} ); 
}
//新增操作
function OP_AddWordDataConfig(){
	var configDataStr=$("#id_wordConfigjson").val();
	var configData;
	if(configDataStr==""){
		configData=[];
    }else{
      configData=eval("("+configDataStr+")");
    }
    var word={};
    word.id="";
    word.wordconfig=$("#id_wordConfig").val();
    word.wordkey="关键字";
    word.keytype="STRING";
    word.wordfield="";
    word.datasql="";
    word.wordmemo="";
    word.opertype="new";
    word.datasource="database";
    word.multiwordfield="";
    configData.push(word);
    OP_initOptinsData(word);
    $("#id_WordData").append("<option value='"+configData.length+"' selected='true'>关键字</option>");
    $("#id_wordConfigjson").val(JsonUtil.encode(configData));
    OP_AddFunction(configData.length);
}
//复制操作
function OP_CopyWordDataConfig(){
	var configDataStr=$("#id_wordConfigjson").val();
	var configData;
	if(configDataStr==""){
		configData=[];
    }else{
      configData=eval("("+configDataStr+")");
    }
	 var cindex=$("#id_WordData").get(0).selectedIndex;
	 if(cindex<0){
		 jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>请选择要复制的数据！</div>",'error')
         return false;
	}
	 var cvalue= $("#id_WordData").get(0).options[cindex].value;
	 var cdata=configData[cvalue-1];
	    var word={};
	    word.id="";
	    word.wordconfig=$("#id_wordConfig").val();
	    word.wordkey=cdata["wordkey"]+"关键字";
	    word.keytype=cdata["keytype"];
	    word.wordfield=cdata["wordfield"];
	    word.datasql=cdata["datasql"];
	    word.wordmemo=cdata["wordmemo"];
	    word.opertype="new";
	    word.datasource=cdata["datasource"];
	    word.multiwordfield=cdata["multiwordfield"];
	    configData.push(word);
	    OP_initOptinsData(word);
	    $("#id_WordData").append("<option value='"+configData.length+"' selected='true'>"+word.wordkey+"</option>");
	    $("#id_wordConfigjson").val(JsonUtil.encode(configData));
	    OP_AddFunction(configData.length);
}
//删除操作
function OP_DeleteWordDataConfig(){
	var configDataStr=$("#id_wordConfigjson").val();
	var configData;
	if(configDataStr==""){
		configData=[];
    }else{
      configData=eval("("+configDataStr+")");
    }
    var cindex=$("#id_WordData").get(0).selectedIndex;
	if(cindex<0){
		jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>请先选择数据再删除！</div>",'error');
        return false;
	    };
    var cvalue= $("#id_WordData").get(0).options[cindex].value;
    $("#id_WordData").get(0).options.remove(cindex);
    configData[cvalue-1].opertype="delete";
    $("#id_wordConfigjson").val(JsonUtil.encode(configData));
}
//提交保存到数据库中
function OP_SubmitWordDataConfig(){
	var configDataStr=$("#id_wordConfigjson").val();
	var configData;
	if(configDataStr==""){
		configData=[];
    }else{
      configData=eval("("+configDataStr+")");
    }
    if(configData.length<=0){
    	jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>请配置数据！</div>",'error');
        return false;
     }else{
       var cdata=[];
       //过滤新建又被删除的数据
      for(var i=0;i<configData.length;i++){
         if(configData[i].opertype=="delete"){

         }else{
        	 cdata.push(configData[i]);
           }
       }
      $("#id_wordConfigjson").val(JsonUtil.encode(cdata));
      if(!window.currentDeleteFileLoadMask)
  	{
  	window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"正在保存数据 请稍等...");
  	} 
  	window.currentDeleteFileLoadMask.show();
  	var url="/leasing/template/addFileTemplateDataConfig.action"
    var params={};
    params["jsonData"]=JsonUtil.encode(cdata);
    params["id"]=$("#id_wordConfig").val();
  	ajaxRequest({
  		url:getRootPath()+url,
  		success:function(res){
  		window.currentDeleteFileLoadMask.hide();
        alert(res.responseText);
  		jQuery("#id_wordConfigdetailInfoWindowContainer").window("close");
  		 },
  		failure:function(res){},
  		params:params 
  	});
    }
}
//增加域操作的函数
function OP_AddFunction(index){
	$("#formDataConfig input").unbind("keyup");
	$("#formDataConfig textarea").unbind("keyup"); 
	$("#formDataConfig input:radio").unbind("click");  
	$("#formDataConfig input").keyup(function(event) {
    var cindex=index;
    setConfigData(cindex,event.target.name,this.value);		  
    }); 
	$("#formDataConfig textarea").keyup(function(event) {
	    var cindex=index;		  
	    setConfigData(cindex,event.target.name,this.value);		  
	    }); 
    $("#formDataConfig input:radio").click(function(event) {
    	 var cindex=index;		  
 	    setConfigData(cindex,event.target.name,this.value);		 
	 }); 
}
//初始化选中右边的数据
function OP_initOptinsData(cdata){
	$("#id_wordid").val(cdata["id"]);
	$("#id_wordkey").val(cdata["wordkey"]);
	$("#id_wordfield").val(cdata["wordfield"]);
	$("#id_datasql").val(cdata["datasql"]);
	$("#id_multiwordfield").val(cdata["multiwordfield"]);
	var input = $("#id_keytype").find("input:radio");
	 input.each(function(){
	 if($(this).val()==cdata["keytype"]){
	 $(this).attr("checked",true);
	 }
	 });
	 input = $("#id_datasource").find("input:radio");
	 input.each(function(){
	 if($(this).val()==cdata["datasource"]){
	 $(this).attr("checked",true);
	 }
	 });
    $("#id_wordmemo").val(cdata["wordmemo"]);
    //keytype
}
//同步更新数据
function setConfigData(index,field,value){
  var configDataStr=$("#id_wordConfigjson").val();
	  configData=eval("("+configDataStr+")");
  var cdata=configData[index-1];
      if(field=="wordid"){field="id";}
	  cdata[field]=value;
	  $("#id_wordConfigjson").val(JsonUtil.encode(configData));
     if(field=="wordkey"){
         var t="#id_WordData option[value='"+index+"']";
         var options=$("#id_WordData option");
         for(var i=0;i<options.length;i++){
           if(options[i].value==index){options[i].text=value;}}
      }
}
function loadftl(table){
	var doc_id=getSelectRowId(table);
	if(doc_id==""){return false;}
	var url="";
	url="/leasing/template/uploadingFileTemplateFtl.action";
	attachmentUp({url:url,title:"上传模板",parames:{id:doc_id,modename:"模板管理"}});
}
function deletefit(table){
	var doc_id=getSelectRowId(table);
	if(doc_id==""){return false;}
	var url="";
	 url="/leasing/word/deletefile.action";
	 deleteFileAttache(doc_id,url);
}
function loadftlsource(table){
	var doc_id=getSelectRowId(table);
	if(doc_id==""){return false;}
	var url="";
	url="/leasing/template/uploadingFileTemplateFtlSource.action";
	attachmentUp({url:url,title:"上传模板源文件",parames:{id:doc_id,modename:"模板管理"}});
}
function deleteword(table){
	var doc_id=getSelectRowId(table);
	if(doc_id==""){return false;}
	var url="";
	url="/leasing/word/deleteSourcefile.action";
	deleteFileAttache(doc_id,url);
}
function configWord(table){
	var doc_id=getSelectRowId(table);
	if(doc_id==""){return false;}
	configWordData(doc_id)
}
function getSelectRowId(tabled){
	
	var selectDatas = tabled.getCheckedRowDatas();
	if (0 == selectDatas.length) {
		alert("请选择需要操作模板！");
		return "";
	}
    return selectDatas[0].id
}
</script>