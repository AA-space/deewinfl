<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		  fillHiddenVal();
		   if(!saveDocReport()){
			alert("保存考察报告出现异常!");
			return false;
		   }
			return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		if(String(rs)!=""){
			alert(rs);
			checkContractId=false;
		}else{
			checkContractId=true;
		}
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ 
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
	
		return workflowSaveCallBack();
	}
	
	//经销商授信额度调减通知函模板
  /*  function createTemFile1(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo8',returnType:'list',modelname:'overduenotice'});
    }
  //经销商授信额度调增通知函模板
    function createTemFile2(){
     var url="/leasing/template/createFileByTemplateClass.action";
     var filename='table_projcreditreport';
     attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo9',returnType:'list',modelname:'overduenotice'});
 }
    //融资租赁业务合作协议(经销商适用)模板
    function createTemFile3(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.89',returnType:'list',modelname:'overduenotice'});
    }
  //最高额保证担保函（经销商适用）模板
    function createTemFile4(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.78',returnType:'list',modelname:'overduenotice'});
    }
  //最高额保证担保函(经销商自然人股东适用)模板
    function createTemFile5(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.77',returnType:'list',modelname:'overduenotice'});
    }
   //法定代表人证明书模板
 function createTemFile6(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.79',returnType:'list',modelname:'overduenotice'});
    }
   //股东会成员签章样本模板
 function createTemFile7(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.80',returnType:'list',modelname:'overduenotice'});
    }
   //股东会决议模板
function createTemFile8(){
        var url="/leasing/template/createFileByTemplateClass.action";
        var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.81',returnType:'list',modelname:'overduenotice'});
    }
*/
</script>
<!--多行控件  -->
<input type="hidden" name="json_word_list_str" id="id_json_word_list_str"  value='${empty json_word_list_str ? "[]" : json_word_list_str }'>
<input type="hidden" name="json_word_list_dealer" id="id_json_word_list_dealer"  value='${empty json_word_list_dealer ? "[]" : json_word_list_dealer }'>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入项目基本信息 -->
		   <jsp:include page="credit_other_info.jsp"></jsp:include>
		 </td>
	</tr>
	<tr>
		<td><!--通知函模板列表--> <jsp:include
			page="word_base_info.jsp"></jsp:include></td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div> 通知函清单</td>
	</tr>
	<tr>
		<td ><!-- 通知函模板列表 -->
		<div id="id_table_word_list_container"	style="overflow: hidden;">
		</div> 
	</tr>
	<tr>
		<td ><!-- 额度调事通知函-->
		<jsp:include page="dealer_limit_evaluate.jsp"></jsp:include></td>
	</tr>
	
	</table>
</div>

<jsp:include page="word_list_info.jsp"></jsp:include></td>
<script>
	//隐藏域在提交或保存前的赋值
		function fillHiddenVal() {
			//保存生成文件
			
			
			var contractEquip = getTracywindyObject('table_id_table_word_list_container');//合同清单
			jQuery('#id_json_word_list_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));	
	}
</script>