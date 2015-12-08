define(function(require , exports , module) {
	//add prototype method named trim for String
	var apUtil = require("js/apcomponent/aputil/aputil.js");
	var ApTableBase = {
		tableAddOper    : function(miniTable,columnsConfig,rowData,config){
			miniTable.editFormItemOperFlag = "add";
			if(true  == config.isRowEditing){
				/*
				 * editor:{ width:'100%', type:'TextBox', onenter:function(){
				 * mini.get("test").commitEdit(); } }
				 */
	            miniTable.addRow(rowData, 0);
	            miniTable.commitEdit();
	            miniTable.beginEditRow(rowData);
			}else{
				var columnsEditFormWindow  = this.initColumnsEditFormWindowPanel(miniTable,columnsConfig,config);
				var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
				var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
				var editFormItemOperFlagId     = editFormPopupWindowFormId+"_editFormItemOperFlag" ;
				jQuery("#"+editFormItemOperFlagId).val("add");
				columnsEditFormWindow.showAtPos('center',config.top||150);
				this.lazyRenderCombobox(config.comboRenders);
			}
		},
		tableEditOper : function(miniTable,columnsConfig,selectedRowData,config){
			var selectedDataSize = this.tableSelectedDataSize(miniTable);
			miniTable.editFormItemOperFlag = "edit";
			if(0 == selectedDataSize){
				mini.alert("请选择需要修改的数据！");
				return ;
			}
			if(1 < selectedDataSize ){
				mini.alert("只能选择单条数据进行修改操作！");
				return ;
			}
			if(true  == config.isRowEditing){
		        miniTable.commitEdit();
		        miniTable.beginEditRow(selectedRowData);
			}else{
				var columnsEditFormWindow  = this.initColumnsEditFormWindowPanel(miniTable,columnsConfig,config);
				var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
				var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
				var editFormItemOperFlagId     = editFormPopupWindowFormId+"_editFormItemOperFlag" ;
				jQuery("#"+editFormItemOperFlagId).val("edit");
				var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
				var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
				var miniForm = new mini.Form("#"+editFormPopupWindowFormId);
				miniForm.setData(selectedRowData);
				columnsEditFormWindow.showAtPos('center',config.top||150);
				this.lazyRenderCombobox(config.comboRenders);
			}
		},
		lazyRenderCombobox:function(comboRenders){
			//渲染combobox
			var timeOutFunc  = (function(comboRenders){
				return function(){
					for(var renderTo in comboRenders){
						var url = comboRenders[renderTo];
						mini.get(renderTo).load(url);
					}
				};
			})(comboRenders);
			setTimeout(timeOutFunc,100);
		},
		tableRemoveOper : function(miniTable,columnsConfig,selectedRowDatas,config){
			var selectedDataSize = this.tableSelectedDataSize(miniTable);
			var me = this;
			mini.confirm("确认删除选中数据行么？","确认操作",function(buttonText){
				if("ok" == buttonText){
					if(0 == selectedDataSize){
						mini.alert("请选择需要删除的数据行！");
						return ;
					}
					if("true" == (config.remoteOper+"")){
						var removedRows     = selectedRowDatas;
						var removedIds      = [];
						for(var a =0 ; a < removedRows.length;a++){
							var removedRow = removedRows[a];
							removedIds.push(removedRow["id"]);
						}
						var ajaxData  = {};
						ajaxData["id"] = removedIds.join(",");
						me.tableRemoteOper("remove", ajaxData, miniTable, config);
					}
					else{
						miniTable.removeRows(selectedRowDatas,false);
					}
				}
			});
		},
		tableCopyOper   : function(miniTable,columnsConfig,selectedRowDatas,config){
			if("true" == (config.remoteOper+"")){
                var selectedDataSize = this.tableSelectedDataSize(miniTable);
    			miniTable.editFormItemOperFlag = "copy";
    			if(0 == selectedDataSize){
    				mini.alert("请选择需要复制的数据！");
    				return ;
    			}
    			if(1 < selectedDataSize ){
    				mini.alert("只能选择单条数据进行复制操作！");
    				return ;
    			}
				var columnsEditFormWindow  = this.initColumnsEditFormWindowPanel(miniTable,columnsConfig,config);
				var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
				var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
				var editFormItemOperFlagId     = editFormPopupWindowFormId+"_editFormItemOperFlag" ;
				jQuery("#"+editFormItemOperFlagId).val("copy");
				var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
				var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
				var miniForm = new mini.Form("#"+editFormPopupWindowFormId);
				var currentCopyData = mini.clone(selectedRowDatas[0]);
				delete currentCopyData["id"];
				miniForm.setData(currentCopyData);
				columnsEditFormWindow.showAtPos('center',config.top||150);
				this.lazyRenderCombobox(config.comboRenders);
			}else{
				this.initCopyCountPopupWindow(miniTable,config);
			}
		},
		initCopyCountPopupWindow : function(miniTable,config){
			var selectedDataSize = this.tableSelectedDataSize(miniTable);
			if(0 == selectedDataSize){
				mini.alert("请选择需要复制的数据行！");
				return ;
			}
			var copyCountPopupWindowId = config.id + "_copyCountPopupWindow";
			var copyCountInputId       = copyCountPopupWindowId+"_input";
			var copyCountButtonOperConfirmId  = copyCountPopupWindowId+"_buttonConfirm";
			if(0 == jQuery("#"+copyCountPopupWindowId).length ){
				var copyCountPopupWindowWidth  = 300;
				var copyCountPopupWindowHeight = 120;
				var htmlArr = [];
				htmlArr.push("<div  title='复制' width='"+copyCountPopupWindowWidth+"' height='"+copyCountPopupWindowHeight+"' iconCls='icon-save' class='mini-window' id='"+copyCountPopupWindowId+"'>");
				htmlArr.push("<div class='aptable-copy-popup-window'><label for='"+copyCountInputId+"$text'>复制次数：</label>");
				htmlArr.push("<input required='true' vtype='int' id='"+copyCountInputId+"' class='mini-textbox' value='1'/>");
				htmlArr.push("&nbsp;&nbsp;<span id='"+copyCountButtonOperConfirmId+"'><a class='mini-button' >确定</a></span></div>");
				htmlArr.push("</div>");
				var $copyCountPopupWindow = jQuery(htmlArr.join(""));
				jQuery(document.body).append($copyCountPopupWindow);
				jQuery("#"+copyCountButtonOperConfirmId).bind("click",function(e){
					e.stopPropagation();
					var miniCopyInput = mini.get(copyCountInputId);
					if(!miniCopyInput.validate()){
						return false;
					}
					var copyCount = parseInt(miniCopyInput.getValue());
					var idFieldName   = "id";
					
					var exceptionFieldNames = [];
					exceptionFieldNames.push(idFieldName);
					exceptionFieldNames.push("_id");
					exceptionFieldNames.push("_uid");
					exceptionFieldNames.push("_state");
					if(config.idField){
					  exceptionFieldNames.push(config.idField);
					}
					var selectedRowDatas  = miniTable.getSelecteds();
					var newRowDatas       = [];

					miniTable.addRows(newRowDatas);
					for(var i = 0;i< copyCount ;i++){
						for(var j = 0; j< selectedRowDatas.length ; j++){
							var newRowData      = {};
							var selectedRowData = selectedRowDatas[j];
							mini.copyTo(newRowData,selectedRowData);
							 
							for(var k = 0 ; k < exceptionFieldNames.length ; k++ ){
								try{delete newRowData[exceptionFieldNames[k]];}catch(e){}
							};
							newRowDatas.push(newRowData);
						}
					}
					miniTable.addRows(newRowDatas,0);
					mini.get(copyCountPopupWindowId).hide();
				});
				mini.parse($copyCountPopupWindow[0]);
			}
			var miniCopyInput = mini.get(copyCountInputId);
			miniCopyInput.setValue("1");
			mini.get(copyCountPopupWindowId).show();
		},
		initColumnsElements            : function(renderType,columnsConfig,config,miniTable,isDestroy){
			var isQueryArea    = ("query" == renderType);
			//initInfo
			var columnsMapping             = this.getColumnsEditFormMapping(columnsConfig,config);
			//miniTable.columnsMapping       = columnsMapping;
			var columnsEditFormMapping     = columnsMapping["columnsEditFormMapping"];
			var fillEditFormMapping        = isQueryArea ? columnsMapping["queryAreafillEditFormMapping"] : columnsMapping["fillEditFormMapping"];
			var columnsKey                 = columnsMapping["columnsKey"];
			
		    var htmlArray  = [];
		    var otherAttributes            = "";
			
			var labelMaxWidth              = 0;
			var editorMaxWidth             = 0;
			var cascaseParamSuffix         = config.cascaseParamSuffix||"Cascade";
			var comboRenders               = {};
			if(!isQueryArea){
				config.comboRenders            = comboRenders;
			}
			var columnsLen                 = columnsKey.length;
			var i                = -1;
			//var globalTrSuffix   = "";   
			for(var iii = 0 ;iii < columnsLen ; iii++){
				var columnKey         = columnsKey[iii];
				var columnConfig      = columnsEditFormMapping[columnKey];
				var header            = columnConfig["header"];
				var formEditorConfig  = isQueryArea ? columnConfig["queryConfig"] : columnConfig["formEditorConfig"];
				if(!formEditorConfig)continue;
				i++;
				var editFormItemId    = formEditorConfig["id"]; 
				var labelWidth        = formEditorConfig["labelWidth"]||60;
				labelMaxWidth         = Math.max(labelMaxWidth,labelWidth);
				var editorWidth       = formEditorConfig["width"]||150;
				editorMaxWidth        = Math.max(editorMaxWidth,editorWidth);
				var formEditType      = formEditorConfig["type"]||"text";
				var isDateRange = (isQueryArea && ("date" == formEditType) && (formEditorConfig["range"]));
				/**
				 * panxf
				 */
				var isNumberRange = (isQueryArea && ("number" == formEditType||"int" == formEditType) && (formEditorConfig["range"]));
				var isDoubleRange = (isQueryArea && ("float" == formEditType||"double" == formEditType) && (formEditorConfig["range"]));
				/**
				 * end
				 */
				otherAttributes       = (formEditorConfig["otherAttributes"]||"").replace(/"/g,"'");
				for(var p in formEditorConfig){
					
					var currentValueObj = formEditorConfig[p];
					var attrVal  = currentValueObj||"";
					
					if(("type" == p) || ("url" == p) || ('object' == typeof(currentValueObj)) ){
						continue;
					}
					var attrName = p;
					attrName = ( "defaultValue" == attrName ) ?  "value" : attrName;
					attrName = ( "readOnly"     == attrName ) ?  "readonly" : attrName;
					if("readonly" == attrName){
						attrName = "enabled";
						attrVal  = !attrVal;
					}
					if(isDateRange && (("id" == p) || ("name" == p) || ("value" == p) || ("defaultValue" == p))){
						//attrVal += "End";
						continue;
					}
					/**
					 * panxf
					 */
					if(isNumberRange && (("id" == p) || ("name" == p) || ("value" == p) || ("defaultValue" == p))){
						//attrVal += "End";
						continue;
					}
					
					if(isDoubleRange && (("id" == p) || ("name" == p) || ("value" == p) || ("defaultValue" == p))){
						//attrVal += "End";
						continue;
					}
					/**
					 * end
					 */
					otherAttributes+=(" "+attrName+"='"+attrVal+"' ");
				}
				
				if(isDestroy){
					try{mini.get(editFormItemId).destroy();}catch(e){};
				}
				var miniClassName    = "item-hidden";
				switch(formEditType){
				   case "text":{
					   miniClassName = "mini-textbox";
					   break;
				   }
				   case "number":
				   case "int":{
					   formEditorConfig["vtype"] = formEditorConfig["vtype"]||"int";
					   miniClassName = "mini-spinner";
					   break;
				   }
				   case "float":
				   case "double":{
					   formEditorConfig["vtype"] = formEditorConfig["vtype"]||"float";
					   miniClassName = "mini-textbox";
					   break;
				   }
				   case "date":{
					   formEditorConfig["vtype"] = formEditorConfig["vtype"]||"date";
					   miniClassName = "mini-datepicker";
					   break;
				   }
				   case "combobox":{
					   var data          = formEditorConfig["data"];
					   var cascadeConfig = formEditorConfig["cascade"];
					   if(!data){
						   var url    = formEditorConfig["url"];
						   var params = formEditorConfig["params"]||{};
						   if(cascadeConfig){
							   var parentFieldNamesArr   = cascadeConfig["parentFieldNames"]||[];
							   for(var ii =0;ii < parentFieldNamesArr.length ; ii++){
								   var  parentFieldName  =  parentFieldNamesArr[ii];
								   switch( miniTable.editFormItemOperFlag ){
								      case "add":{
								    	  var  parentFormEditorConfig  = columnsEditFormMapping[parentFieldName][isQueryArea ? "queryConfig" : "formEditorConfig"];
								    	  params[ parentFieldName+cascaseParamSuffix ]    = parentFormEditorConfig["defaultValue"]||"";
								    	  break;
								      }
								      case "edit":{
								    	  var selectedData            = miniTable.getSelected();
								    	  params[ parentFieldName+cascaseParamSuffix ]   = selectedData[parentFieldName];
								    	  break;
								      }
								      default:{
								    	  var  parentFormEditorConfig  = columnsEditFormMapping[parentFieldName][isQueryArea ? "queryConfig" : "formEditorConfig"];
								    	  params[ parentFieldName+cascaseParamSuffix ]    = parentFormEditorConfig["defaultValue"]||"";
								    	  break;
								      }
								   }
							   }
						   }
						   url        = apUtil.getParamsUrl(url, params);
						   if(!isQueryArea){
					           comboRenders[editFormItemId] = url;
						   }else{
							   otherAttributes+=(" url='"+url+"' ");
						   }
					       //级联选择
						   var comboSelectFuncName  = editFormItemId+"_combo_select_func";
						   window[comboSelectFuncName] = (function(columnKey,fillEditFormMapping,columnsEditFormMapping,cascadeConfig,me){
							   return function(miniComboBox){
								   var  delimiter               = miniComboBox.delimiter;
								   var  textFieldName           = miniComboBox.getTextField();
								   var  selectedText            = miniComboBox.getText();
								   var  selectedValue           = miniComboBox.getFormValue();
	 							   var  filledColumnFieldNames  = fillEditFormMapping[columnKey];
								   if(filledColumnFieldNames){
									   var selectedComboDatas    = miniComboBox.getSelecteds();
									  
									   for(var k = 0;k < filledColumnFieldNames.length ; k++){
										   var filledColumnFieldNameConfig      = filledColumnFieldNames[k];
										   var filledFormFieldId          = filledColumnFieldNameConfig["id"];
										   var fillProperty             = filledColumnFieldNameConfig["fillProperty"].replace("{textField}",textFieldName);
										   var filledValues               = new Array();
										   
										   for(var kk =0 ; kk < selectedComboDatas.length ; kk++){
											   var selectedComboData = selectedComboDatas[kk];
											   filledValues.push(selectedComboData[fillProperty]||"");
										   }
										   mini.get(filledFormFieldId).setValue(filledValues.join(delimiter));
									   }
										 
								   }
								   //级联处理
				 	   			   if(cascadeConfig){
				 	   				   var childrenFieldNamesArr = cascadeConfig["childrenFieldNames"]||[];
				 	   				   for(var ii = 0 ; ii <childrenFieldNamesArr.length ; ii++){
				 	   					   var childrenFieldName = childrenFieldNamesArr[ii];
				 	   					   var childrenFormEditorConfig  = columnsEditFormMapping[childrenFieldName][ isQueryArea ? "queryConfig" : "formEditorConfig"];
				 	   					   var childrenComboId = childrenFormEditorConfig["id"];
				 	   					   var childrenCombo   = mini.get(childrenComboId);
				 	   					   childrenCombo.setValue("");
				 	   					   var newUrl   = childrenFormEditorConfig["url"];
				 	   					   var oldUrl   = childrenCombo.getUrl();
				 	   					   var cascadeParams = apUtil.getJsonParamsByUrl(oldUrl);
				 	   					   cascadeParams[ "displayValue_"+columnKey+cascaseParamSuffix ]  = selectedText;
				 	   					   cascadeParams[ "rawValue_"+columnKey+cascaseParamSuffix ]      = selectedText;
				 	   					   cascadeParams[ columnKey+cascaseParamSuffix ]                  = selectedValue;
				 	   					   var url   = apUtil.getParamsUrl(newUrl, cascadeParams);
				 	   					   childrenCombo.load(url);
				 	   				   }
					 	   			   var clearFieldNamesArr = cascadeConfig["clearFieldNames"]||[];
				 	   				   for(var ii = 0 ; ii <clearFieldNamesArr.length ; ii++){
				 	   					   var clearFieldName = clearFieldNamesArr[ii];
				 	   					   var clearFormEditorConfig  = columnsEditFormMapping[clearFieldName][ isQueryArea ? "queryConfig" : "formEditorConfig"];
				 	   					   var clearComboId = clearFormEditorConfig["id"];
				 	   					   var clearCombo   = mini.get(clearComboId);
				 	   					   clearCombo.setValue("");
				 	   				   }
				 	   			   }
							   };
						   })(columnKey,fillEditFormMapping,columnsEditFormMapping,cascadeConfig,this);
						   //级联操作
						   var onvaluechanged = formEditorConfig["onvaluechanged"]||("window."+comboSelectFuncName+"(this)");
						   otherAttributes+=(" onvaluechanged='"+onvaluechanged+"' ");
					   }else{
						   var encodeData = mini.encode(data);
						   otherAttributes+=(" data='"+encodeData+"' ");
					   }
					   miniClassName = "mini-combobox";//"aptable-lazy-combobox";
					   break; 
				   }
				   default:{
					   miniClassName = "item-hidden";
					   break;
				   }
				}
				var labelOtherAttributes = "";
				var fieldVisible =  ( 'undefined' != typeof(formEditorConfig["fieldVisible"])) ? formEditorConfig["fieldVisible"] : columnConfig["visible"]; 
				if(!fieldVisible){
					labelOtherAttributes  = " style='display:none;'  ";
					otherAttributes      += " type='hidden'  ";
					miniClassName        += " item-hidden ";
				}
				var newLine       =  formEditorConfig["newLine"]||false;
				var tdColspan     =  formEditorConfig["colspan"]||"1";
				var separator     =  formEditorConfig["separator"];
				var itemHtmlPrefix = "";
				var itemHtmlSuffix = "";
				var separatorHtml = "";
				if(newLine){
					if(separator){
						separatorHtml = "<tr><td class='td-label' colspan='"+(separator["colspan"]||1)+"'>"+(separator["html"]||"<hr/>")+"</td></tr>";
					}
					if(0 < i){
						itemHtmlPrefix+="</tr>";
						itemHtmlPrefix+="{separatorHtml}";
						itemHtmlPrefix+="<tr>";
					}else{
						itemHtmlPrefix+="{separatorHtml}";
					}
				}
				itemHtmlPrefix = itemHtmlPrefix.replace("{separatorHtml}",separatorHtml);
				if(0 == i){
					itemHtmlPrefix+="<tr>";
				}
				if( (columnsLen - 1 ) == i){
					globalTrSuffix="";
					if(!isQueryArea){
						itemHtmlSuffix+="</tr>";
					}
				}
				var tdDisplayClass = "";
				if(!fieldVisible){
					tdDisplayClass = " item-hidden";
				}
				var editFormItemLabelHtml   = itemHtmlPrefix+"<td class='td-label"+tdDisplayClass+"' ><label  {labelOtherAttributes} width='{labelWidth}' >{labelHeader}：</label></td>";
				htmlArray.push(editFormItemLabelHtml.replace("{labelWidth}",labelWidth).replace("{labelHeader}",header).replace("{labelOtherAttributes}",labelOtherAttributes));
				var tdPrefixContent = "";
				if(isDateRange||isNumberRange||isDoubleRange){//修改 panxf
					var startOtherAttributes = otherAttributes;
					var dateConfigId    = formEditorConfig["id"];
					var dateConfigName  = formEditorConfig["name"];
					var startDefaultValue = formEditorConfig["startDefaultValue"]||formEditorConfig["startValue"]||"";
					var endDefaultValue   = formEditorConfig["endDefaultValue"]||formEditorConfig["endValue"]||"";
					startOtherAttributes += " id='"+dateConfigId+"Start"+"' ";
					startOtherAttributes += " name='"+dateConfigName+"Start"+"' ";
					startOtherAttributes += " value='"+startDefaultValue+"' ";
					otherAttributes += " id='"+dateConfigId+"End"+"' ";
					otherAttributes += " name='"+dateConfigName+"End"+"' ";
					otherAttributes += " value='"+endDefaultValue+"' ";
					var startEditFormItemContentHtml = "<td class='td-input"+tdDisplayClass+"' colspan='1'><div><input class='{miniClassName}' {otherAttributes} /></div></td>";
					var endEditFormItemLabelHtml     = "<td class='td-label"+tdDisplayClass+"'><label  width='{labelWidth}'  {labelOtherAttributes} >{labelHeader}</label></td>";
					htmlArray.push(startEditFormItemContentHtml.replace("{miniClassName}",miniClassName).replace("{otherAttributes}",startOtherAttributes));
					//tdPrefixContent = "<td class='td-label' >&nbsp;到&nbsp;</td>";
					tdColspan = (0 == (parseInt(tdColspan) - 1 )) ? 1 : ( parseInt(tdColspan) - 1);
					htmlArray.push(endEditFormItemLabelHtml.replace("{labelWidth}",labelWidth).replace("{labelHeader}","&nbsp;到&nbsp;").replace("{labelOtherAttributes}",labelOtherAttributes));
				}
				
				/**
				 * panxf
				 *//*
				if(isNumberRange){
					var startOtherAttributes = otherAttributes;
					var numberConfigId    = formEditorConfig["id"];
					var numberConfigName  = formEditorConfig["name"];
					var startDefaultValue = formEditorConfig["startDefaultValue"]||formEditorConfig["startValue"]||"";
					var endDefaultValue   = formEditorConfig["endDefaultValue"]||formEditorConfig["endValue"]||"";
					startOtherAttributes += " id='"+numberConfigId+"Start"+"' ";
					startOtherAttributes += " name='"+numberConfigName+"Start"+"' ";
					startOtherAttributes += " value='"+startDefaultValue+"' ";
					otherAttributes += " id='"+numberConfigId+"End"+"' ";
					otherAttributes += " name='"+numberConfigName+"End"+"' ";
					otherAttributes += " value='"+endDefaultValue+"' ";
					var startEditFormItemContentHtml = "<td class='td-input"+tdDisplayClass+"' colspan='1'><div><input class='{miniClassName}' {otherAttributes} /></div></td>";
					var endEditFormItemLabelHtml     = "<td class='td-label"+tdDisplayClass+"'><label  width='{labelWidth}'  {labelOtherAttributes} >{labelHeader}</label></td>";
					htmlArray.push(startEditFormItemContentHtml.replace("{miniClassName}",miniClassName).replace("{otherAttributes}",startOtherAttributes));
					//tdPrefixContent = "<td class='td-label' >&nbsp;到&nbsp;</td>";
					tdColspan = (0 == (parseInt(tdColspan) - 1 )) ? 1 : ( parseInt(tdColspan) - 1);
					htmlArray.push(endEditFormItemLabelHtml.replace("{labelWidth}",labelWidth).replace("{labelHeader}","&nbsp;到&nbsp;").replace("{labelOtherAttributes}",labelOtherAttributes));
				}
				*//**
				 * end
				 */
				var editFormItemContentHtml = "<td class='td-input"+tdDisplayClass+"' colspan='"+tdColspan+"'><div>"+tdPrefixContent+"<input class='{miniClassName}' {otherAttributes} /></div></td>"+itemHtmlSuffix;
				htmlArray.push(editFormItemContentHtml.replace("{miniClassName}",miniClassName).replace("{otherAttributes}",otherAttributes));
			}
			//htmlArray.push(globalTrSuffix);
			return {
				htmlArr:htmlArray,
				labelMaxWidth:labelMaxWidth,
				editorMaxWidth:editorMaxWidth
			};
		},
		getQueryAreaParams : function(miniTableId, isClear) {
			var queryAreaContainerId = "id_queryAreaContainerId_"+miniTableId;
		    var queryAreaDivDom = mini.byId(queryAreaContainerId);
		    var itemIdPrefix   = (miniTableId + "_queryArea_");
		    var params = {};
		    apUtil.recusionAllChildrenNodesParams(queryAreaDivDom, params, isClear);
		    var rp = new RegExp("^" + itemIdPrefix);
		    for (var p in params) {
		        if (!p) continue;
		        if (rp.test(p)) {
		            var key = p.substring(itemIdPrefix.length, p.length);
		            var value = params[p];
		            params[key] = value;
		            delete params[p];
		        }
		    }
		    return params;
		},
		getColumnsQueryAreaHtmlObj:function(columnsConfig,config,miniTable,isDestroy){
			var htmlObj  = this.initColumnsElements('query',columnsConfig,config,miniTable,isDestroy);
			return htmlObj;
		},
		initColumnsEditFormWindowPanel : function(miniTable,columnsConfig,config){
			mini.mask({
				el:document.body,
				cls: 'mini-mask-loading',
				html:'数据加载中 请稍等...'
			});
			if(!miniTable.columnsConfig){
				miniTable.columnsConfig = columnsConfig;
			}
			//assign window's width
			var editFormPopupWindowWidth   = config.editFormPopupWindowWidth||0;
			var editFormPopupWindowHeight  = config.editFormPopupWindowHeigh;
			var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
			var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
			var $editFormPopupWindow       = jQuery("#"+editFormPopupWindowId);
			var isDestroy                  = (0 < $editFormPopupWindow.length);
			var editFormWindowPanelHtmlArr = [];
			var editFormItemOperFlagId     = editFormPopupWindowFormId+"_editFormItemOperFlag" ;
			var editRemoteOperFlagId       = editFormPopupWindowFormId+"_editRemoteOperFlag" ;
			editFormWindowPanelHtmlArr.push("<div title='新增 / 修改 数据记录'  allowResize='true' showMaxButton='true' showFooter='true'  iconCls='icon-save' id='"+editFormPopupWindowId+"' class='mini-window aptable-edit-form-popup-window' modal='true' >");
			editFormWindowPanelHtmlArr.push("<form id='"+editFormPopupWindowFormId+"' class='mini-form' >" +
					"<input type='hidden' id='"+editFormItemOperFlagId+"'/>" +
					"<input type='hidden' id='"+editRemoteOperFlagId+"'/>" +
							"<table><tbody>");
			var htmlObj  = this.initColumnsElements('form',columnsConfig,config,miniTable,isDestroy);
			
			var labelMaxWidth  = htmlObj["labelMaxWidth"];
			var editorMaxWidth = htmlObj["editorMaxWidth"];
			var htmlArr        = htmlObj["htmlArr"];
			
			for(var bb =0 ;bb < htmlArr.length ; bb++){
				editFormWindowPanelHtmlArr.push(htmlArr[bb]);
			}
			var editFormPopupWindowFormConfirmButtonId = editFormPopupWindowFormId+"_confirmButton";
			var editFormPopupWindowFormCancelButtonId = editFormPopupWindowFormId+"_cancelButton";
			editFormWindowPanelHtmlArr.push("</tbody></table></form>" );
			editFormWindowPanelHtmlArr.push("<div property='footer' class='oper-footer'>");
			editFormWindowPanelHtmlArr.push("<span id='"+editFormPopupWindowFormConfirmButtonId+"'><a  class='mini-button'>确定</a></span>");
			editFormWindowPanelHtmlArr.push("&nbsp;&nbsp;<span id='"+editFormPopupWindowFormCancelButtonId+"'><a  class='mini-button'>取消</a></span>");
			editFormWindowPanelHtmlArr.push("</div></div>");
			if(isDestroy){
				try{mini.get(editFormPopupWindowId).destroy();}catch(e){};
			}
			jQuery(document.body).append(jQuery(editFormWindowPanelHtmlArr.join("")));
			jQuery("#"+editFormPopupWindowId).css({
				width : Math.max(editFormPopupWindowWidth,(labelMaxWidth+editorMaxWidth + 200))+"px",
				height: editFormPopupWindowHeight ? ( editFormPopupWindowHeight + "px" ) : "auto"
			});
			jQuery("#"+editFormPopupWindowFormCancelButtonId).bind("click",function(e){
				e.stopPropagation();
				mini.get(editFormPopupWindowId).hide();
			});
			var editFormItemOperFlagId     = editFormPopupWindowFormId+"_editFormItemOperFlag" ;
            jQuery("#"+editRemoteOperFlagId).val((config.remoteOper||false)+"");
            
            var me = this;
			jQuery("#"+editFormPopupWindowFormConfirmButtonId).bind("click",function(e){
				e.stopPropagation();
				var editFormItemOperFlag = jQuery("#"+editFormItemOperFlagId).val();
				var operText             = ("add" == editFormItemOperFlag) ? "新增" : (("edit" == editFormItemOperFlag) ? "修改" : "复制" );
				mini.confirm("确认数据的"+operText+"操作么？","确认操作",function(buttonText){
					if("ok" == buttonText){
						var miniForm = new mini.Form("#"+editFormPopupWindowFormId);
						switch(editFormItemOperFlag){
							case "add":
							case "edit":
							case "copy":{
								var rowData  = miniForm.getData(true);
								if(miniForm.validate()){
									if("true" == (config.remoteOper+""))
									{
									   me.tableRemoteOper(editFormItemOperFlag, rowData, miniTable, config);
									}
									else{
										switch(editFormItemOperFlag){
											case "add":{
												miniTable.addRow(rowData,0);
												break;
											}
											case "edit":{
												var row     = miniTable.getSelected();
												miniTable.updateRow(row,rowData);
												break;
											}
										}
									}
									mini.get(editFormPopupWindowId).hide();
								}
								break;
							}
						}
					}
				});
			});
			mini.parse(editFormPopupWindowId);
			setTimeout(function(){mini.unmask(document.body);},200);
			return mini.get(editFormPopupWindowId);
		},
		tableRemoteOper : function(editFormItemOperFlag,ajaxData,miniTable,config){
			mini.mask({
				el:document.body,
				cls: 'mini-mask-loading',
				html:'数据操作中 请稍等...'
			});
			
			ajaxData["entityClassName"]             = config["entityClassName"]||"";
			ajaxData["entityBeanCallBackClassName"] = config["entityBeanCallBackClassName"]||"";
			
			var operText             = ("add" == editFormItemOperFlag) ? "新增" : (("edit" == editFormItemOperFlag) ? "修改" : (("copy" == editFormItemOperFlag) ? "复制" : "删除") );
			jQuery.ajax({
				url:config[editFormItemOperFlag+"RemoteOperUrl"]||(window.globalWebRoot + '/table/'+editFormItemOperFlag+'RemoteOper.action'),
				async:true,
				type:'POST',
				contentType:'application/x-www-form-urlencoded',
				timeout:30*1000,
				data    : ajaxData,
				dataType: 'json',
				error:function(res,errInfo,e){},
				success:function(resultJson){
					var returnState = resultJson.returnType;
					switch(returnState){
						case "SUCCESS":{
							miniTable.reload();
							mini.unmask(document.body);
							mini.alert(operText+" 成功！");
							break;
						}
						case "FAILURE":{
							mini.unmask(document.body);
							mini.alert(operText+" 失败！");
							break;
						}
					}
				}
			});
		},
		tableSelectedDataSize : function(miniTable){
			return miniTable.getSelecteds().length; 
		},
		getColumnsEditFormMapping : function(columnsConfig,config){
			var columnsEditFormMapping   = {};
			var fillEditFormMapping    = {};
			var parentsEditFormMapping   = {};
			var childrenEditFormMapping  = {};
			//queryarea config
			var queryAreaFillEditFormMapping = {};
			var queryAreaParentsEditFormMapping = {};
			var queryAreaChildrenEditFormMapping = {};
			//summary
			var summaryColumnNames   = [];
			var summaryColumnNameFieldMappings   = {};
			//export
			var exportColumns        = [];
			var exportComplexHeaders = [];
		
			
			var columnsKey               = [];
			var columns                  = columnsConfig;
			this.recursionColumnsEditFormMapping(columnsEditFormMapping,
					fillEditFormMapping,parentsEditFormMapping,childrenEditFormMapping, 
					queryAreaFillEditFormMapping,queryAreaParentsEditFormMapping,queryAreaChildrenEditFormMapping,
					summaryColumnNames,summaryColumnNameFieldMappings,exportColumns,exportComplexHeaders,columnsKey, columns,config);
			return {
					    columnsEditFormMapping:columnsEditFormMapping,
					    fillEditFormMapping:fillEditFormMapping,
					    parentsEditFormMapping:parentsEditFormMapping,
					    childrenEditFormMapping:childrenEditFormMapping,
					    queryAreaFillEditFormMapping:queryAreaFillEditFormMapping,
					    queryAreaParentsEditFormMapping:queryAreaParentsEditFormMapping,
					    queryAreaChildrenEditFormMapping:queryAreaChildrenEditFormMapping,
					    summaryColumnNames:summaryColumnNames,
					    summaryColumnNameFieldMappings:summaryColumnNameFieldMappings,
					    exportColumns:exportColumns,
					    exportComplexHeaders:exportComplexHeaders,
					    columnsKey:columnsKey
		           };
		},
		exportExcel: function(miniTable,columnsConfig,config){
			var columnsEditFormMapping = this.getColumnsEditFormMapping(columnsConfig,config);
			var exportExcelFormId = "id_exportApTableExcelForm";
			var $form = jQuery("#"+exportExcelFormId);
			if(0 < $form.length){
				document.body.removeChild($form[0]);
			}
			
			var exportExcelUrl = config.exportExcelUrl||(window.globalWebRoot + '/table/getExcelExportData.action');
			var tempInnerHtml = "<form action='"+exportExcelUrl+"' id='"+exportExcelFormId+"' method='POST'>";
			
			var complexHeadersStr = mini.encode(config.exportComplexHeaders||columnsEditFormMapping["exportComplexHeaders"]).replace(/'/gi, '&#39;');
			tempInnerHtml += "<input type='hidden' name='complexHeadersStr' value='" + complexHeadersStr + "'/>";
		    
			var columnsStr = mini.encode(columnsEditFormMapping["exportColumns"]).replace(/'/gi, '&#39;');
		    tempInnerHtml += "<input type='hidden' name='columnsStr' value='" + columnsStr + "'/>";
		    if (config.data) {
		        var datasStr = JsonUtil.encode(miniTable.getData()).replace(/'/gi, '&#39;');
		        tempInnerHtml += "<input type='hidden' name='datasStr' value='" + datasStr + "'/>";
		    }
		    var params  = miniTable.getParams();
		    params['excelTitleName'] = config.title||"export";
		    
		    for (var p in params) {
		        var tempStr = params[p];
		        if (Object.prototype.toString.call(params[p]) == '[object String]') {
		            tempStr = params[p].replace(/'/gi, '&#39;');
		        }
		        tempInnerHtml += "<input type='hidden' name='" + p + "' value='" + tempStr + "'/>";
		    }
		    tempInnerHtml += "<input type='hidden' name='exportExcelVersion' value='" + config.exportExcelVersion||"2007" + "'/>";
		    tempInnerHtml += "<input type='hidden' name='loadMode' value='" + (config.data ? "data" : "ajax") + "'/>";
		    tempInnerHtml += "<input type='hidden' name='isExportTitle' value='" + ((false == config.isExportTitle) ? false : true) + "'/>";
		    tempInnerHtml += "<input type='hidden' name='isTableExportExcel' value='true'/>";
		    tempInnerHtml += "<input type='hidden' name='BrowserType' value='" + apUtil.getBrowser().toLowerCase() + "'/>";
		    tempInnerHtml += "<input type='hidden' name='forceExportExcelIndexs' value='" + "" + "'/>";
		    tempInnerHtml += "</form>";
		    
		    $form = jQuery(tempInnerHtml);
		    jQuery(document.body).append($form);
		    $form.submit();
		    
			// 为了防止普通浏览器进行表单提交和产生页面导航（防止默认提交）返回false
			return false;

		},
		recursionColumnsEditFormMapping : function(columnsEditFormMapping,fillEditFormMapping,parentsEditFormMapping,childrenEditFormMapping,queryAreaFillEditFormMapping,queryAreaParentsEditFormMapping,queryAreaChildrenEditFormMapping,summaryColumnNames,summaryColumnNameFieldMappings,exportColumns,exportComplexHeaders,columnsKey,columns,config){
			var editFormPopupWindowId      = config.id + "_editFormPopupWindow";
			var editFormPopupWindowFormId  = editFormPopupWindowId+"_form";
			for(var i = 0;i < columns.length ; i++){
				var column  = columns[i];
				var type    = column.type;
				var header  = column.header;
				if( ("indexcolumn" == type) || ("checkcolumn" == type)){
					continue;
				}
				var recursionColumns = column.columns;
				if( recursionColumns && (0 < recursionColumns.length)){
					var rowIndex = parseInt(column["_level"]);
					var rowComplexHeaders  = exportComplexHeaders[rowIndex];
					if("undefined" == typeof(rowComplexHeaders)){
						rowComplexHeaders = [];
						exportComplexHeaders.push(rowComplexHeaders);
					}
					var rowComplexHeadConfig = {
							header:header,
							headerAlign:column.headerAlign
						};
					var exportConfig = column.exportConfig||{};
					var startColNum  = exportConfig["startColNum"];
					if(startColNum){
						rowComplexHeadConfig["startColNum"] = startColNum;
					}
					rowComplexHeadConfig["colspan"] = exportConfig["colspan"]||"1";
					rowComplexHeadConfig["rowspan"] = exportConfig["rowspan"]||"1";
					
					rowComplexHeaders.push(rowComplexHeadConfig);
					this.recursionColumnsEditFormMapping(columnsEditFormMapping,fillEditFormMapping,parentsEditFormMapping,childrenEditFormMapping,queryAreaFillEditFormMapping,queryAreaParentsEditFormMapping,queryAreaChildrenEditFormMapping,summaryColumnNames,summaryColumnNameFieldMappings,exportColumns,exportComplexHeaders,columnsKey,recursionColumns,config);
				}else{
					var key        = column["field"];
					var columnName = column["name"]||key;
					column["name"] = columnName;
					var name       = key;//column["name"]||key;
					var visible    = (("false" == column["visible"])|| (false == column["visible"])) ? false : true;
					if(visible){
						exportColumns.push({
							header:header,
							name:key,
							mapping:key,
							hidden:!visible
						});
					}
					columnsKey.push(key);
				    var valueObj = {};
				    valueObj["header"]           = header;
				    valueObj["visible"]          = visible;
				    valueObj["name"]             = name;
				    valueObj["field"]            = key;
					/***form editor start***/
					var formEditorConfig         = column["formEditorConfig"]||{};
					if(formEditorConfig){
					    //元素唯一标示
					    var itemId                   = /*formEditorConfig["id"]||*/(editFormPopupWindowFormId+"_"+key);
					    //只针对combobox 级联反选赋值
					    var fillFromFieldName =  formEditorConfig["fillFromFieldName"];
					    var fillProperty      =  formEditorConfig["fillProperty"]||"{textField}";
					    var fieldVisible      =  formEditorConfig["fieldVisible"];
					    if(fillFromFieldName){
					    	var fillFormFieldNames = fillEditFormMapping[fillFromFieldName];
					    	if(!fillFormFieldNames){
					    		fillFormFieldNames = [];
					    		fillEditFormMapping[fillFromFieldName] = fillFormFieldNames;
					    	}
					    	fillFormFieldNames.push({
					    		id             : itemId,
					    		fillProperty   : fillProperty,
					    		fieldVisible   : fieldVisible
					    	});
					    }
					    //editor config
					    formEditorConfig["id"]       = itemId;
					    formEditorConfig["name"]     = name;
					    formEditorConfig["dataField"]= "datas";
					    formEditorConfig["url"]      = formEditorConfig["url"]||(window.globalWebRoot+'/table/getTableData.action');
					    valueObj["formEditorConfig"] = formEditorConfig;
					}
				    /***form editor finish***/
				    /***query area editor start***/
				    var queryConfig = column["queryConfig"];
				    if(queryConfig){
					    //元素唯一标示
					    var itemId                       = (config.id + "_queryArea_"+key);
					    //只针对combobox 级联反选赋值
					    var queryAreaFillFromFieldName   =  queryConfig["fillFromFieldName"];
					    var queryAreaFillProperty        =  queryConfig["fillProperty"]||"{textField}";
					    var queryAreaFieldVisible        =  true;//queryConfig["fieldVisible"];
					    if(queryAreaFillFromFieldName){
					    	var queryAreaFillFormFieldNames = queryAreaFillEditFormMapping[queryAreaFillFromFieldName];
					    	if(!queryAreaFillFormFieldNames){
					    		queryAreaFillFormFieldNames = [];
					    		queryAreaFillEditFormMapping[queryAreaFillFromFieldName] = queryAreaFillFormFieldNames;
					    	}
					    	queryAreaFillFormFieldNames.push({
					    		id             : itemId,
					    		fillProperty   : queryAreaFillProperty,
					    		fieldVisible   : queryAreaFieldVisible
					    	});
					    }
					    //query config
					    queryConfig["id"]               = itemId;
					    queryConfig["name"]             = itemId;
					    queryConfig["newLine"]          = queryConfig["newLine"]||false;
					    queryConfig["dataField"]        = "datas";
					    queryConfig["url"]              = queryConfig["url"]||(window.globalWebRoot+'/table/getTableData.action');
					    valueObj["queryConfig"]         = queryConfig;
				    }
				    /***query area editor finish***/
				    //summary
					if(true == column["summary"]){
						summaryColumnNames.push(columnName);
						summaryColumnNameFieldMappings[key] = columnName;
					}
				    columnsEditFormMapping[key] = valueObj;
				}
			}
		},
		//折叠显示区域
		fieldsetToggleClick : function (e,callBack){
			apUtil.fieldsetToggle(e.target,callBack);
		}
	};
	return ApTableBase;
});