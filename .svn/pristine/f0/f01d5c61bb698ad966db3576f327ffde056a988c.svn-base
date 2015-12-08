//全局常数
var COMM_TABLE_URL_ACTION = 'commController.action';
var COMM_TABLE_URL = 'commController/comm.action';
var TABLElIST_RETURN_ID = '';
var PACKAGE_NAME = 'com.business.entity.';

/**
 * 通用增加平面数据
 * @param table 表头字段
 * @param tableId 实体id
 * @param render 渲染地址
 */
function commTable(table, tableId, renderId, groupStyle) {// 增加通用单数据表
	
	 
	$('#' + renderId).append('<form id="' + tableId + '" class="form-horizontal well"></table>');
	$('#' + tableId).append('<div id="'+tableId+'commrow"  class="row"></div');
	$.each(table, function(i, v) {
		addTable(tableId, v, groupStyle);
	});
	
};

function addValidator(XMLValidatorString, inputId){
	var webRe = /^web*/i;
	var serverRe = /^server/i;
	var validatorStr = XMLValidatorString.split(";");
	jQuery.each(validatorStr, function(i, v){
		if(webRe.exec(v)){
			var webValidatorStr = v.substr(4).replace(/'/g, '"');
			jQuery.parseJSON(webValidatorStr);
			$('#' + inputId).attr(jQuery.parseJSON(webValidatorStr));
			if($('#' + inputId).attr("require") =='true'){
				var LabelItem = $('#' + inputId + 'Label');
				LabelItem.html("<span style='color:red'>*</span>" + LabelItem.text());
			}
		}
		if(serverRe.exec(v)){
			//do SomeThing，后台验证。
		}
	});
}




function addTable(tableId, v, groupStyle){
	
	var groupDivStyle = 'span4';
	if(groupStyle){groupDivStyle = groupStyle;};
	var innerInputId = getIdWipePoint(tableId + v.field);
	
	var divGroup = '<div class="'+groupDivStyle+'"><div id="' + innerInputId + 'ControlGruop" class="control-group"><label id="' + innerInputId + 'Label" style="width: 60px; margin: 2px 2px;" class="control-label" for="' + innerInputId + '">' + v.title
			+ '</label></div>';
	if (v.type) {
		addTableType(tableId, v, divGroup);
	} else {
		var inputType = '<input id="' + innerInputId + '" class="input-medium" type="text" name="' + v.field + '" placeholder="' + v.title + '" />';
		$('#' + tableId + 'commrow').append(divGroup);
		$('#' + innerInputId + 'ControlGruop').append(inputType);
		
	}
	if(v.columnValidation){
	addValidator(v.columnValidation, innerInputId);
	};
}
function addTableType(tableId, v, divGroup){
	var innerInputId = getIdWipePoint(tableId + v.field);
	switch (jQuery.trim(v.type).toLocaleLowerCase()) {

	case 'combox':
		var inputType = '<div class="input-append">' + '<input disabled="" class="input-small uneditable-input" id="' + innerInputId + 'name" type="text" name="' + v.field
				+ '" placeholder="' + v.title + '"/>' + '<input  id="' + innerInputId + '" type="hidden" name="' + v.field + '"/>' + '<button class="btn" onclick="commTree(\'' + innerInputId + '\',\'' + v.url + '\');" type="button">选框</button> </div>';

		$('#' + tableId + 'commrow').append(divGroup);
		$('#' + innerInputId + 'ControlGruop').append(inputType);
		break;
	case 'compare':
		var inputType = '<div class="inline">' + '<input id="' + innerInputId + 'Start" class="input-small uneditable-input"  type="text" name="' + v.field + '"/> - ' + '<input id="'
				+ innerInputId + 'End" class="input-small uneditable-input" type="text" name="' + v.field + '"/></div>';

		$('#' + tableId + 'commrow').append(divGroup);
		$('#' + innerInputId + 'ControlGruop').append(inputType);

		break;
		
	case 'set':
		$('#commTablebable').show();
		var setFeildId = tableId + v.field;
		addSetNav(v, setFeildId, 'commNav-tabs');
		break;
	case 'hidden':
		var inputType = '<input id="' + innerInputId + '" class="input-medium" type="hidden" name="' + v.field + '" placeholder="' + v.title + '" />';
		$('#' + tableId + 'commrow').append(inputType);
		break;
		
	case 'select':
		$('#' + tableId + 'commrow').append(divGroup);
		getSelectInputContent(innerInputId, v, v.attribute);
		
		break;
		
	case 'datatime':
		var inputType = '<input id="' + innerInputId + '" class="input-medium" type="text" name="' + v.field + '" placeholder="' + v.title + '">'
		+ '<img onclick="WdatePicker({el:'+innerInputId+'})" src="js/my97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">'
		+ '</div>';
		$('#' + tableId + 'commrow').append(divGroup);
		$('#' + innerInputId + 'ControlGruop').append(inputType);
		break;
		
	case 'checkbox':
		$('#' + tableId + 'commrow').append(divGroup);
		getCheckBoxInputContent(innerInputId, v, v.attribute);
		
		break;
		
	default:
		$('#' + tableId + 'commrow').append(divGroup);
	
		var inputType = '<input id="' + innerInputId + '" class="input-medium" type="text" name="' + v.field + '" placeholder="' + v.title + '" />';
		$('#' + innerInputId + 'ControlGruop').append(inputType);
		break;
	}

}

var resolvParameterString = function(parameter){
	var i = parameter.indexOf(":");
	return [parameter.substr(0,i), parameter.substr(i + 1)];
};

var getCheckBoxInputContent = function(innerInputId, v, selectType){
	var typeObject = resolvParameterString(selectType);
	switch (typeObject[0].toString().toLowerCase()) {
	case 'objectdata':
		var objectValue = typeObject[1].replace(/\[|\]|'/g, "").split(",");
		var selectValue = "";
		$('#' + innerInputId + 'ControlGruop').append('<div id='+innerInputId+'CheckBoxCtr class="controls">');
		jQuery.each(objectValue, function(i, s) {
			selectValue = '<label class="checkbox"  style="display: inline-block;"><input id=' + innerInputId + ' type="checkbox" class="input-medium"  name="' + v.field + '" value=' + s + '>' + s +'</label>' + selectValue;
		});
		$('#' + innerInputId + 'CheckBoxCtr').append(selectValue);
		break;
	
	case 'jsdata':
		var callFunction = typeObject[1].replace(/\[|\]/g, "").split(",").toString();
		var returnValue = console.info(eval(callFunction));
		('#' + innerInputId + 'ControlGruop').append(returnValue);
	case 'dictdata' :
		var dictPid = typeObject[1];
		
		getDictData(dictPid, function(r){
			var selectValue = "";
			jQuery.each(r, function(i, s) {
				console.info(v);
				selectValue ='<input id=' + innerInputId + ' type="checkbox" class="input-medium"  name="' + v.field + '" value="'+s.id+'">'+ v.name+'</input>' + selectValue;
			});
			
			
			('#' + innerInputId + 'ControlGruop').append(selectValue);
		});
		
		break;
	default:
		break;
	}
};

var getSelectInputContent = function(innerInputId, v, selectType) {
	var typeObject = resolvParameterString(selectType);
	switch (typeObject[0].toString().toLowerCase()) {
	case 'objectdata':
		var objectValue = typeObject[1].replace(/\[|\]|'/g, "").split(",");
		var selectValue = '<select id=' + innerInputId + ' class="input-medium"  name="' + v.field + '">';

		jQuery.each(objectValue, function(i, v) {
			selectValue = selectValue + '<option value="' + v + '">' + v + '</option>';
		});
		selectValue = selectValue + '</select>'
		$('#' + innerInputId + 'ControlGruop').append(selectValue);
		break;
	
	case 'jsdata':
		var callFunction = typeObject[1].replace(/\[|\]/g, "").split(",").toString();
		var returnValue = console.info(eval(callFunction));
		('#' + innerInputId + 'ControlGruop').append(returnValue);
	case 'dictdata' :
		var dictPid = typeObject[1];
		
		getDictData(dictPid, function(r){
			var selectValue = '<select id=' + innerInputId + ' class="input-medium"  name="' + v.field + '">';
			jQuery.each(r, function(i, v) {
				console.info(v);
				selectValue = selectValue + '<option value="' + v.id + '">' + v.name + '</option>';
			});
			
			selectValue = selectValue + '</select>'
			
			('#' + innerInputId + 'ControlGruop').append(selectValue);
		});
		
		break;
	default:
		break;
	}
};

var getDictData = function(columnValue, callback){
	$.getJSON(COMM_TABLE_URL_ACTION + '?findDictValue&columnValue='+ columnValue, function(r) {
		callback(r);
	});
};

/**
 * 去除id中的点
 * @param idStr
 * @returns
 */
function getIdWipePoint(idStr){
	return jQuery.trim(idStr.replace(/\./g, ''));
};

/**
 * @param type
 * @param xmlType
 * @returns {String}
 */
function openType(type, objectType, xmlType, tableId, objectId, objectTitle, groupStyle) {
	switch (type) {
	case 'openNewWindow':
		addOpenNewWindow(xmlType);
		break;
	case 'accordion':
		addOpenAccordion(objectType, objectId, xmlType, tableId, groupStyle);
		break;
	case 'model' :
		addOpenModel(objectType, objectId, xmlType, tableId, objectTitle);
		break;
	default:
		addOpenAccordion(xmlType);
	};
}
function addOpenModel(objectType, objectId, xmlType, tableId, objectTitle){
	addToolBarClickAction('toolBarAdd', 'openModelAdd(\'' + objectType + '\', \''+objectId+'\',\''+xmlType+'\',\''+tableId+'\',\''+objectTitle+'\')');
};

function openModelAdd(objectType, objectId, xmlType, tableId, objectTitle){
	commTableHead(objectType, xmlType, function(r) {//获得通用列表
		commTable(r, tableId, 'modal-body');
	});
	$('#myModalLabel').text(objectTitle);
	$('#commModel').modal({
		backdrop : false,
		keyboard : true,
		show : true
	});
};
function addOpenNewWindow(xmlType){
	addToolBarClickAction('toolBarAdd', 'openWindowAdd(\'' + xmlType + '\')');
}

function addOpenAccordion(objectType, objectId,xmlType,  tableId, groupStyle) {
	var accordId = tableId + 'accordion';
	var accordInnerId = accordId + 'Inner';
	
	addToolBarAccordionMethod('toolBarAdd', accordId);
	
	commTableHead(objectType, xmlType, function(r) {//获得通用列表
		addAccordionContent(r, tableId, accordId, accordInnerId, groupStyle);
	});
}

/**
 * 删除渲染的表格
 * @param render  渲染地址
 */
function removeCommTable(render) {
	$('#' + render).empty();
};

// 中间常量
var treeReturnName;
var treeReturnId;
var treeInputId;
/**
 * @字段类型为tree，添加tree，默认添加隐藏字段treeId,默认添加显示名称treeName treeId 为需要注入值的id treeUrl 为得到tree的Url
 */
function commTree(treeId, treeUrl) {
	$.getJSON(dataUrl + '?findclassname', function(r) {
		$('#myModalLabel').html(r.className);
	});

	$('#modal-body').append('<div id="commTree"></div>');
	$(function() {
		$('#commTree').tree({
			url : treeUrl,
			lines : true,
			onBeforeLoad : function(p) {
				if (p) {
					// $('#housetree').tree('options').url = p.attributes.url;
					// console.info("varlues = " + varlues.url );
				}
			},
			onClick : function(v) {
				treeInputId = treeId;
				treeReturnName = v.text;
				treeReturnId = v.id;
			}
		});
	});
	//
	// 弹框显示
	$('#commModel').modal({
		backdrop : true,
		keyboard : true,
		show : true
	});
}

// 弹框内容选择
function setInputValue() {
	// 类名
	if (treeInputId && treeReturnId) {
		$('#' + treeInputId).attr('value', treeReturnId);
		$('#' + treeInputId + 'name').attr('value', treeReturnName);
		$('#commModel').modal('hide');
		treeReturnName = null;
		treeReturnId = null;
		removecommModel();
	} else {
		alert("请选择内容");
	}
}
// 删除弹框内容
function removecommModel() {
	$('#modal-body').empty();
}

// 清除表单内容
function cleanQuery(tableListRenderId) {
	$('#' + tableListRenderId).form('clear');
};
// 将表单内容作为条件查询
function submitQuery(renderId, tableListRenderId) {
	var queryParams = $.serializeObject($('#' + renderId).form());
	$('#' + tableListRenderId).datagrid("load", queryParams);
};


/**
 * 获取表头
 * @param dataUrl 表头地址
 * @param callback 获取完成回调函数
 */
function commTableHead(objectType, xmlType, callback) {
	$.getJSON(COMM_TABLE_URL_ACTION + '?findFields' + objectType + xmlType, function(r) {
		callback(r);
	});
}

/**
 * 查询数据
 * @param dataUrl
 * @param xmlType
 * @param callback
 */
function commTableValue(objectType ,id ,callback) {
	$.getJSON(COMM_TABLE_URL_ACTION + '?findById'+objectType+'&id='+ id, function(r) {
		callback(r);
	});
}

/**
 * 给表单添加数据
 * @param r
 * @param renderId
 */
function addValues(r, renderId){
	var input = $('#' + renderId + ' input[name]');
	$.each(input, function(i, v){
		$('#'+ v.id).val(r.obj[v.name]);
	});
};




/**
 * 添加通用列表
 * @param url 
 * @param xmlType
 * @param columns
 */
function commTablePageList(objectType, xmlType, columns, renderId) {
	 var time =  new Date();
	 var time1 = time.getTime();
	$('#' + renderId).datagrid({
		url : COMM_TABLE_URL_ACTION + '?findFuzzy' + objectType + xmlType,
		iconCls : 'icon-edit',
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		idField : 'itemid',
		striped : 'true',
		border : false,
		columns : columns,

		onBeforeLoad : function() {
			$(this).datagrid('rejectChanges');
		},
		onClickRow : function(rowIndex, rowData) {
			console.info(rowIndex);
			console.info(rowData);
			
			//renderId + TABLElIST_RETURN_ID = rowIndex;
		/*	if (lastIndex != rowIndex) {
				areainfoTable('endEdit', lastIndex);
				areainfoTable('beginEdit', rowIndex);
			}
			lastIndex = rowIndex;*/
		}
	});
	
	var time2 = new Date();
	var time3 = time2.getTime();
	console.info("解析表单" + (time3 - time1));
}

/**
 * 将通用表头数据转换成列表表头数据
 * @param r
 * @returns
 */
function convertTableListHead(r){
	jQuery.each(r, function(i, v){
		if(v.type == 'hidden'){
			r[i].hidden = true;
		}
	});
	return [r];
}

/**
 * 获取后台输入的类型数据，用于获得基本的实体信息
 * @param commData
 * @param type
 * @returns {GetCommDataByType}
 */
function GetCommDataByType(commData, type) {
	this.tableId = commData[type].id;
	this.tableName = commData[type].name;
	this.modelType = commData[type].modelType;
	this.dataUrl = commData[type].dataUrl;
	this.typeModel = commData[type].typeModel;
	this.groupStyle = commData[type].groupStyle;
	this.getSimpleId = function(){
		var strs = this.tableId.split(".");
		return strs[strs.length-1];
	};
	this.getTableId = function() {
		return this.tableId;
	};
	this.getTableName = function() {
		return this.tableName;
	};
	this.getModelType = function() {
		return this.modelType;
	};
	this.getDataUrl = function() {
		return this.dataUrl;
	};
	this.getTypeModel = function(){
		return this.typeModel;
	};
	this.getGroupStyle = function(){
		return this.groupStyle;
	};
}
function getSimpleId(id){
	var strs = id.split(".");
	return strs[strs.length-1];
}

/**
 * 给模糊查询添加确定和清除按钮
 * @param renderId 渲染地址
 * @param tableListRenderId 表单ID
 */
function addFuzzyToolBar(renderId, tableRenderId, tableListRenderId){
	
	$('#' + renderId).append('<div style="text-align: right; margin: 0px 10px;">'
 					+ '<button id="clean-query"class="btn" style="margin: 0px 10px;" onclick="cleanQuery(\'' + tableRenderId + '\');">清空</button>'
					+ '<button id="submit-query" class="btn btn-primary" style="margin: 0px 10px;" onclick="submitQuery(\'' + tableRenderId + '\', \'' + tableListRenderId + '\');">查询</button>'
					+ '</div>');
}


function popUpWindow(URLStr,width, height)
{
	if(width==undefined && height==undefined)
    {
          event.srcElement.openwin = open(URLStr);
          event.srcElement.openwin.focus();
    }
	else
	{
	      	var left=(screen.width - width)/2;
	        var top=(screen.height - height)/2;
  
            event.srcElement.openwin = open(URLStr,"","width= "+width+ ",height="+height+",left="+left+",top="+top);
            event.srcElement.openwin.focus();
	}
}	

function openWindowAdd(xml){
	var win = addWin(COMM_TABLE_URL + '?' + xml.substring(1).replace("modelType", "type")+ '&addFlag=true');
}

/**
 * 弹出窗口
 * @param url
 * @param width
 * @param height
 */
function addWin(url, width, height) {
	var win;
	if (width == undefined && height == undefined) {
		win = window.open(url, '添加', 'width=' + screen.width + ',height=' + screen.height + ',top=0,left=0,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
	} else {
		var left = (screen.width - width) / 2;
		var top = (screen.height - height) / 2;
		win = window.open(URLStr, "", "width= " + width + ",height=" + height + ",left=" + left + ",top=" + top);
	}
	return win;
}

/**添加功能按钮
 * @param renderId
 * @param objectType
 * @param objectId
 */
function addSaveAndCloseButton(tableId, objectType, objectId){
	$('#' + tableId).before(
			'<div class="btn-group">'
			+'<div style="text-align: right; margin: 0px 10px;">'
 			+ '<button id="'+tableId+'SaveButton" class="btn" onclick="submitData(\'' + tableId + '\', \'' + objectType + '\', \'' + objectId + ' \');">保存</button>'
			+ '<button class="btn btn-primary" onclick="submitDataAndCloseWindow(\'' + tableId + '\', \'' + objectType + '\', \'' + objectId + ' \');">保存并关闭</button>'
			+ '<button class="btn btn-primary" onclick="closeOpenWindow();">关闭</button>'
			+ '</div></div>');
	
}

function closeOpenWindow(){
	window.close(); 
}


function submitData(renderId, objcetType, objectId) {
	 var fromValidator = Validator.Validate(document.getElementById(renderId),3,false);
	   console.info(fromValidator);
	   //if(!fromValidator) return;

  // 执行添加的所有验证
		var url = COMM_TABLE_URL_ACTION + '?saveOrUpdata' + objcetType;
		console.info("renderId" + renderId);
		var form = $('#' + renderId).form();
		var queryParams = $.serializeObject($('#' + renderId).form());
		var e = isEmptyObject(queryParams);
		console.info(e);
		if (!isEmptyObject(queryParams)) {
			var object = getSimpleId(objcetType) + '=' + $.toJSON(queryParams);

			jQuery.post(url, object, function(data) {
				if (data.success == true && data.msg) {
					$('#' + objectId).val(data.msg);
					$('#' + renderId + 'SaveButton').removeAttr('disabled');
				}
				console.info(data);
			}, 'json');
		} else {
			alert('还未填入数据');
			$('#' + renderId + 'SaveButton').removeAttr('disabled');
			return;
		}
}

function submitDataAndCloseWindow(renderId, objcetType){
	submitData(renderId, objcetType);
	closeOpenWindow();
}

/**
 * 添加有一对多的多
 * @param r
 * @param renderId
 * @param setId
 */
function addSetNav(r, setFeildId, setId) {
	$('#' + setId).append('<li><a onclick="switchTable(\''+ setFeildId + '\');" href="#' + setFeildId + '" data-toggle="tab">' + r.title + '</a></li>');
}    

function addSetContent(setFeildId){
	var url = 'commController/basedata/comm.action?xml=areainfo.xml&type=findpagelist,fuzzy,add';
	var content = createFrame(url);
	console.info(content);
	$('#commTab-content').append('<div class="tab-pane" id="'+setFeildId+'"></div>');
	$('#'+ setFeildId).append(content);
};


function addSetHead(){
	
}
function addSetValue(){
	
}
function hiddenToolBar(){
	$("#accordion").hide();
};

function addToolBarClickAction(renderId, clickFunction){
	$('#' + renderId).attr("onclick", clickFunction);
};

function showToolBar(){
	$("#accordion").show();
};

function switchTable(setFeildId){
	$('#commTablebable a[href="#' + setFeildId + '"]');
	var content = jQuery('#'+ setFeildId);
	if(!content[0])
		addSetContent(setFeildId);
	
}


function addToolBarAccordionMethod(toolBarId, renderId)
{

	$('#' + toolBarId).attr({
		'data-toggle' : "collapse",
		'data-parent' : "#accordion",
		'data-target' : '#' + renderId
	});
}


function addAccordionContent(r, tableId, accordId, accordInnerId, groupStyle){
	$('#accordion-group').append('<div id="'+accordId+'" class="accordion-body collapse"></div>');
	$('#'+ accordId).append('<div id="'+accordInnerId+'" class="accordion-inner"></div>');
	commTable(r, tableId, accordInnerId, groupStyle);
}
