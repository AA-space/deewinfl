<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>		
  <!-- 弹出意见框开始 -->
  <div id="id_adviseContainerWindow" buttons="#id_adviseButtons" closed="true" modal="true" title="意见表单" style="display:none;width:350px;text-align:center">
	<table style="width:96%" style="margin:auto;padding:auto;">
	   <tr class="tr-odd">
			<td style="width:100px;">当前时间：</td>
			<td><div id="id_currentSystemTime"></div></td>
	   </tr>
	   <tr class="tr-even" style="width:100px;">
			<td style="padding-top:10px;">常用意见：</td>
			<td style="padding-top:10px;"><div id="id_selectAdvise"></div></td>
	   </tr>
	   <tr class="tr-odd">
			<td  style="width:100px;">&nbsp;</td>
			<td style="text-align:left;"><textarea id="text_selectedAdvise" style="width:196px;height:150px;overflow:auto;border:1px solid #DDD;"></textarea></td>
	   </tr>
	</table>
  </div>	   
   <div style="padding-top:15px;text-align:center;display:none;" id="id_adviseButtons"> 
	  <input class="btn btn-primary" type="button" value="确定" onclick='fillCurrentCommonAdvise();jQuery("#id_adviseContainerWindow").dialog("close");' style="cursor:pointer;width:60px;"/>
	<input class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_adviseContainerWindow").dialog("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
  </div>
  <textarea id='id_processedAdviseTxt' style="display:none;">${currentJBPMWorkflowHistoryInfoUser.processedAdvise}</textarea>
  <textarea id='id_assignedAdviseTxt' style="display:none;">${currentJBPMWorkflowHistoryInfoUser.assignedAdvise}</textarea>
  <script type="text/javascript">
	 var currentSavedAdvise = (jQuery("#id_processedAdviseTxt").val()||jQuery("#id_assignedAdviseTxt").val());
  </script>
  <script type="text/javascript">
	//添加意见
	  function addCommonAdivse(hidden_text_choseAdviseValue)
	  {
		  	var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
		  	hidden_text_choseAdvise.value = hidden_text_choseAdviseValue;
		  	var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
		      var insertHtml ='<div id="id_currentTaskFilledAdvise_1" style="border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;">';
		  	insertHtml+='	<span style="width:200px;height:100%;padding-top:5px;font-size:12px;">【步骤】<font color="red" style="font-weight:BOLD;">当前处理</font></span>';
		  	insertHtml+='	<span style="width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;">【填写时间】'+ getCurDateTime()+'</span>';
		  	insertHtml+='	<span style="width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;">';
		  	if(!isCompletedTask){
			  	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;" onclick="showModalCommonAdivseWindow();"><img align="absmiddle" src="${pageContext.request.contextPath}/menuIcons/pencil.png" border="0"/>&nbsp;编辑</a>';
			  	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;margin-left:20px;" onclick="delCommonAdivse();"><img align="absmiddle" src="${pageContext.request.contextPath}/menuIcons/no.png" border="0"/>&nbsp;删除</a></span>';
		  	}
		  	insertHtml+='</div>';
		  	insertHtml+='<div id="id_currentTaskFilledAdvise_2" style="border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;">';
		  	insertHtml+='	<span style="height:100%;padding-top:5px;font-size:12px;">'+hidden_text_choseAdvise.value+'</span>';
		  	insertHtml+='</div>';
	       workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);
	  }
	  //通用意见弹出窗口
	  function showModalCommonAdivseWindow()
	  {
		  loadWorkflowChoseAdvise(function(combo){
		      var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
			  document.getElementById("id_currentSystemTime").innerHTML= getCurDateTime();
			  document.getElementById('text_selectedAdvise').value = hidden_text_choseAdvise.value;
			  combo.setRawValue(hidden_text_choseAdvise.value);
	      });
		  jQuery("#id_adviseContainerWindow").show();
		  jQuery("#id_adviseContainerWindow").dialog({top:100});
		  jQuery("#id_adviseContainerWindow").dialog("open");
	  }
	  function fillCurrentCommonAdvise(){
	      
	  	var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
	   	hidden_text_choseAdvise.value = document.getElementById('text_selectedAdvise').value;
		    var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
		    var currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');
		    if(currentTaskFilledAdvise_1)
		    {
		    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);
		    	var currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');
		    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);
			}
	      var insertHtml ='<div id="id_currentTaskFilledAdvise_1" style="border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;">';
	      	insertHtml+='	<span style="width:200px;height:100%;padding-top:5px;font-size:12px;">【步骤】<font color="red" style="font-weight:BOLD;">当前处理</font></span>';
	      	insertHtml+='	<span style="width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;">【填写时间】'+ getCurDateTime()+'</span>';
	      	insertHtml+='	<span style="width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;">';
	      	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;" onclick="showModalCommonAdivseWindow();"><img align="absmiddle" src="${pageContext.request.contextPath}/menuIcons/pencil.png" border="0"/>&nbsp;编辑</a>';
	      	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;margin-left:20px;" onclick="delCommonAdivse();"><img align="absmiddle" src="${pageContext.request.contextPath}/menuIcons/no.png" border="0"/>&nbsp;删除</a></span>';
	      	insertHtml+='</div>';
	      	insertHtml+='<div id="id_currentTaskFilledAdvise_2" style="border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;">';
	      	insertHtml+='	<span style="height:100%;padding-top:5px;font-size:12px;">'+hidden_text_choseAdvise.value+'</span>';
	      	insertHtml+='</div>';
	      workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);
	  }
	  function delCommonAdivse()
	  {
	  	var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
	  	var currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');
		    if(currentTaskFilledAdvise_1)
		    {
		    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);
		    	var currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');
		    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);
			}
		    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
		    hidden_text_choseAdvise.value="";
	  }
	  //判断已经保存过了意见
	  if(currentSavedAdvise && !isCompletedTask)
	  {
		  var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
		  hidden_text_choseAdvise.value=currentSavedAdvise;
	  	  //addCommonAdivse(currentSavedAdvise);
	  }

	//加载通用意见
	 function loadWorkflowChoseAdvise(loadComplete)
	 {
	    var infoFlag = "choseAdvise";
		if(lazyLoadedObj[infoFlag]){
			return true;
		}
		new tracywindyComboBox({
	          renderTo:'id_selectAdvise',
	          id:'id_selectAdvise_combo',
	          width:200,
		      xmlFileName:'\\combos\\comboDict.xml',
		      loadMode:'ajax',
		      readOnly:true,
		      displayField:'name',
		      valueField:'code',
		      isForceModify:true,
		      params:{
	            pid:'JbpmCommonAdvise'
		      },
		      loadComplete:loadComplete?loadComplete:function(combo){},
		      onSelect:function(combo){
			    var selectedAdviseValue = combo.getRawValue();
		        	document.getElementById('text_selectedAdvise').value = selectedAdviseValue;
		      	    document.getElementById('id_hidden_text_choseAdvise').value = selectedAdviseValue;
			     }
		});
		lazyLoadedObj[infoFlag] = true;
   }
  </script>     	 
<!-- 弹出意见框结束-->