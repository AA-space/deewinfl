<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script type="text/javascript">
    //新增担保人 后保存参数
	var onSelectDatas;
	function getSelectDatas($me,currentTable){
		lazyLoadedObj["attachment"] = false;
		var attachmentTable = getTracywindyObject("id_customworkflowattachment");
		if(attachmentTable){
			attachmentTable.setParams({
				onSelectDatas:JsonUtil.encode(currentTable.getRowsData())
			});
			attachmentTable.reload();
		}
	}
	function customWorkflowAttachment(Param_onSelectDatas,Param_custname,Param_custnumber,Param_custclass){
		//流水号
		var identifierOne = "${projApproveProcessInstanceDBID}"||"${currentProcessInstanceDBID}";
		//控制附件编辑权限
		var currentIsReadOnly = window.isCompletedTask||window.assignAttachmentIsReadOnly||false;
		//得到流程名称
		var currentWorkFlowDisplayName = "${currentWorkFlowDisplayName}";
		//得到节点名称
		
		var currentTaskActivityName = "${currentTaskActivityName}";
		//console.info("流程名称："+currentWorkFlowDisplayName);
		//console.info("步骤名称："+currentTaskActivityName);
		if(currentWorkFlowDisplayName == "项目立项流程" && currentTaskActivityName == "01经销商发起"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "立项变更流程" && currentTaskActivityName == "01经销商发起"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "项目资料补齐" && currentTaskActivityName == "01信用分析师补充资料"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "项目信审流程" && currentTaskActivityName == "01信用分析师发起"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "项目信审流程" && currentTaskActivityName == "02信用分析师2"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "合同审批流程" && currentTaskActivityName == "01发起"){
			currentIsReadOnly = false;
		}else if(currentWorkFlowDisplayName == "起租后合同变更" && currentTaskActivityName == "01发起"){
			currentIsReadOnly = false;
		}else{
			currentIsReadOnly = true;
		}
		currentIsReadOnly = currentIsReadOnly||window.isCompletedTask;
		
		tracywindyAttachmentFileUpload({
			isReadOnly:currentIsReadOnly,
			unionKey:'assuror',
            renderTo:'id_workflowAttachmentContainer',
            module:'WorkflowAttchmentFiles',
            id:'id_customworkflowattachment',
            params:{
			 onSelectDatas:Param_onSelectDatas,
			 custname:Param_custname,
			 custnumber:Param_custnumber,
			 assignAttachmentKeyOne:identifierOne,
			 custclass:Param_custclass
		    },
		    batchDownloadAttachmentFileTitle:window.assignBatchDownloadAttachmentFileTitle||"${requestScope['proj_info.custname']}",
            columns:[
					{name:'id',header:'uuid', hidden:true},
					{name:'uploadtype',header:'分类',hidden:false,width:80},
                	{name:'bondsman',header:'客户/担保人',width:80,hidden:false},
    			  	{name:'assuror',header:'客户id/担保人id',hidden:true},
    			  	{name:'type',header:'资料类别',width:60,hidden:false},
    			  	{name:'attachmentFileDictFileName',header:'资料名称',width:180},
    			  	{name:'character',header:'性质',hidden:false,width:26},
    			  	{name:'gradelevel',header:'等级',hidden:false,width:30},
    			  	{name:'description',header:'附件说明',hidden:false,width:300},
					{name:'attachmentFileDictId',header:'文件编号',hidden:true},
					{name:'attachmentFileUploadInfoId',header:'文件上传编号',hidden:true},
					{name:'attachmentFileUploadInfoDetailIds',header:'上传明细文件编号',hidden:true},
					{name:'attachmentFileUploadInfoDetailChineseFileNames',header:'上传明细文件显示名称',hidden:true},
					{name:'attachmentFileUploadInfoDetailEncodeFileNames',header:'上传明细文件加密名称',hidden:true},
					{name:'attachmentFileUploadInfoDetailFileSizes',header:'上传明细文件文件大小', hidden:true},
					{name:'attachmentFileUploadInfoDetailUploadTimes',header:'上传明细文件上传日期',hidden:true},
					{name:'attachmentFileUploadInfoDetailRemarks',header:'上传明细文件文件说明',hidden:true},
					{name:'operOne',header:'上载',align:'center',width:60,renderer:
						function(value,tableObj,columnName,columnIndex,rowData){
					       var oper = "<a href='javascript:void(0);' onclick='addUploadFile(\""+tableObj.id+"\","+rowData.rowIndex+",\"add\");'>附件上传</a>";
					        if(!identifierOne){
					       	 oper = "<font color='red'>关键字为空</br>不能上载文件</font>";
					        }
					       return oper;
					    }
					},{
					  name:'operTwo',
					  header:'上载文件清单'
					}
            ],
            checkAttachmentInfoFuncCallback:function(attachmentFileDictFileName,fileListUUIDStr,attachmentRowData,attachmentTable){
		        if(!fileListUUIDStr)
		        {
			        alert(attachmentRowData["bondsman"]+" < "+attachmentFileDictFileName+" > 必需上传附件");
		            return false;
		        }
	            return true;
	        },
			callBack:function(){
		         var fileDetailWidth = this.width -this.rankSize - this.checkSize - 868;
		         if(currentIsReadOnly){
		        	  fileDetailWidth+=80;
		     		  this.setColumnHidden(true,'operOne');
		         }
		         this.setColumnWidth(fileDetailWidth,'operTwo');
		         globalAttachmentUploadOperCallBack('operTwo',this,currentIsReadOnly);
		   },
            attachmentFileDictListImplBeanName:'projAttachmentFileList',
            attachmentType:window.assignAttachmentTypeIds||'${currentTaskActivityDetailInfo.attachmentTypeIds}',
            identifierOne:identifierOne,
            identifierTwo:window.assignAttachmentKeyTwo||jQuery("#id_currentHistoryTaskInfo_keyOne").val(),
            identifierThree:window.assignAttachmentKeyThree||jQuery("#id_currentHistoryTaskInfo_keyTwo").val(),
            identifierFour:window.assignAttachmentKeyFour||jQuery("#id_currentHistoryTaskInfo_keyThree").val(),
            identifierFive:window.assignAttachmentKeyFive||jQuery("#id_currentHistoryTaskInfo_keyFour").val(),
            identifierSix:window.assignAttachmentKeySix||jQuery("#id_currentHistoryTaskInfo_keyFive").val(),
            identifierSeven:window.assignAttachmentKeySeven||jQuery("#id_currentHistoryTaskInfo_keySix").val(),
            identifierEight:window.assignAttachmentKeyEight||jQuery("#id_currentHistoryTaskInfo_keySeven").val(),
            identifierNine:window.assignAttachmentKeyNine||jQuery("#id_currentHistoryTaskInfo_keyEight").val(),
            identifierTen:window.assignAttachmentKeyTen||jQuery("#id_currentHistoryTaskInfo_keyNine").val(),
            width:all_width-13,
            height:all_height-containerWidthAdd-132,
            border:true,
            displayToggleContainer:"id_toggle_tabs_attachment"
            
		});
	}	
    </script>