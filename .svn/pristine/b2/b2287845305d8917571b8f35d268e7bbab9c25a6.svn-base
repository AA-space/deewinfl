<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
custom-label {
	
}

.custom-option {
	color: red;
	border: 1px;
	border-color: black;
}
</style>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Dark/css/ligerui-all.css" />
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Gray/css/all.css" /> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Silvery/css/style.css" /> --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/ligerui-icons.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/lab.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-darkgray/tip-darkgray.css" />


<script type="text/javascript" src="resource/jquery/jquery-1.8.2.js"></script>
<script type="text/javascript" src="resource/jquery/jqueryExtend.js"></script>
<script type="text/javascript" src="resource/jquery/jquery.json-2.4.min.js"></script>
<script src="resource/ligerui1.2.0/js/core/base.js" type="text/javascript"></script>
<!-- <script src="resource/ligerui1.2.0/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerToolBar.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerFilter.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerForm.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerTextBox.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerResizable.js" type="text/javascript"></script>
 -->


<script type="text/javascript" src="resource/poshyTip/jquery.poshytip.js"></script>

<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerAccordion.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerButton.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerCheckBox.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerComboBox.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerDateEditor.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerDialog.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerDrag.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerEasyTab.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerFilter.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerForm.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerGrid.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerLayout.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerMenu.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerMenuBar.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerMessageBox.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerRadio.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerResizable.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerSpinner.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerTab.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerTextBox.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerTip.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerToolBar.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerTree.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/plugins/ligerWindow.js"></script>



<!-- <script type="text/javascript" src="resource/ligerui1.2.0/js/ligerui.all.js"></script> -->
<script type="text/javascript" src="resource/ligerui1.2.0/js/lab.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/ligerGrid.showFilter.js"></script>
<script type="text/javascript" src="resource/somejs/tableGrid.js"></script>
<script type="text/javascript" src="resource/somejs/commtable.js"></script>
<script type="text/javascript" src="resource/somejs/PageSystem.js"></script>
<script type="text/javascript" src="resource/somejs/ComboBox.js"></script>
<!-- 验证框架 -->
<script type="text/javascript" src="resource/validator/validator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>

<script type="text/javascript" src="resource/somejs/tableData.js"></script>

<script type="text/javascript">
	var openTargets =[];
	var _attribute = null;
	var dataObjectName ='';
	$(function() {
		  $("attr").ligerForm();
		var datas = {rows:[]};
		var combox = $("#combox").ligerComboBox({
			url : 'commController.action?getAllEntityProperty',
			valueField : 'entityName',
			textField : 'showName',
			autocomplete: true,
			onSelected : function(r) {
				if(r){
					dataObjectName = r;
					var param = {
						objectType : r
					};
					window.grid.set('params', param);
					window.grid.set('url', 'commController.action?getColumnsProperty');
					existed.selectValue();
				}
			}
		});

 		var existed = $("#exist").ligerComboBox({
			url : 'commController.action?getExistedFile',
			autocomplete: true,
			onSelected : function(r) {
				if(r){
					dataObjectName = r;
					var param = {
						fileName : r
					};
					window.grid.set('params', param);
					window.grid.set('url', 'commController.action?getColumnsProperty');
					combox.selectValue("");
					
					$('#_file_Name').val(this.findTextByValue(r));
				}
			}
		});  
		
		window.grid = $("#maingrid").ligerGrid({
			columns : [{display : '基本信息',
						columns : [{display : '字段名', name : 'fieldName', align : 'left', width : 220, minWidth : 30, render:fieldNameRender}, 
						           {display : '表头显示名', name : 'showName', align : 'left', width : 110, minWidth : 30, editor : {type : 'text'}}]},
						           {display : '列表页设置', columns : [{display : '列表显示', name : 'inlist', width : 55, render : checkboxRender}, 
						                                          	   {display : '列表宽度', name : 'listwidth', align : 'right', width : 50, minWidth : 30, editor : {type : 'numberbox'}},
						                                          	   {display : '内容显示', name : 'render', align : 'right', width : 50, minWidth : 60, editor : {type : 'customselect', data :[{value : 'normal', text : '正常显示'}, {value : 'customRender', text : '自定义'}], ext : f_customselect}, render : columnSelectRender},
						                                          	   {display : '搜索显示', name : 'insearch', width : 55, render : checkboxRender}]},
						            {display : '表单页设置', columns : [{display : '表单显示', name : 'inform', width : 55, render : checkboxRender},
						                                           		{display : '标签宽度', name : 'labelwidth', align : 'right', width : 55, editor : {type : 'numberbox'}},
						                                           		{display : '控件类型', name : 'type', align : 'center', width : 80, minWidth : 30, editor : {type : 'select', data : fieldTypeData}, render : fieldTypeRender},
						                                           		{display : '数据源', name : 'datasource', width : 80, editor : {type : 'select', data : dataScouceData, ext : f_selectDepartment}, render : dataSourceRender},
						                                           		{display : '控件宽度', name : 'width', align : 'right', width : 55, editor : {type : 'numberbox'}},
						                                           		{display : '行占位', name : 'colspan', align : 'right', width : 55, editor : {type : 'numberbox'}},
						                                           		{display : '是否新行', name : 'newline', width : 55, render : checkboxRender},
																		{display : '数据验证', name : 'validate', width : 100, editor : {type : 'combobox', ext : validateExt},render : validateRender},
																		{display : '空白宽度', name : 'space', width : 100, editor : {type : 'text'}},
																		{display : '分组', name : 'group', width : 100, editor : {type : 'text'}}]},
																		//{display : '公共属性', columns : [{display : '是否为空', name : 'allownull', width : 55, render : checkboxRender}]}
																		],
						data : datas,
						tree : {columnName : 'fieldName', isExtend : function(row, p) {
		                    return false;//默认不展开，
	                    }}, 
	                    usePager : false,
	                    toolbar : createGridToolbar(),
	                    enabledEdit : true, 
	                    clickToEdit : true,
	                    fixedCellHeight : false,
	                    //inWindow : false,
	                    rownumbers : true,
	                    //width : '100%',
	                    height : '98%',
	                    //heightDiff : -14,
	                    //rowHeight : 24,
	                    allowHideColumn : false,
	                    enabledSort : false,
	                    columnParams : function(row) {
		                    return {objectType : row.fkEntityName};
	                    },
	                    onSuccess : function(data, g) {
		                    initDatas(data);
		                    //参数
		                    var combox = $.ligerui.get('combox');
		                    var fileName = '';
		                    var fileDescribe = '';
		                    var listURL = 'framework/commController.action?findFuzzy';
		                    var addURL = 'commController.action?saveOrUpdata';
		                    var delURL = 'commController.action?removeByIDs';
		                    var editURL = '';
		                    var objectType = combox.getValue();
		                    var objectName = combox.findTextByValue(objectType);
		                    
		                    if(_attribute != null){
		                    	if(_attribute.fileDescribe){
		                    		fileDescribe = _attribute.fileDescribe;
		                    	}
		                    	if(_attribute.fileName){
		                    		fileName = _attribute.fileName;
		                    	}
		                    	if(_attribute.listURL){
		                    		listURL = _attribute.listURL;
		                    	}
		                    	if(_attribute.addURL){
		                    		addURL = _attribute.addURL;
		                    	}
		                    	if(_attribute.delURL){
		                    		delURL = _attribute.delURL;
		                    	}
		                    	if(_attribute.editURL){
		                    		editURL = _attribute.editURL;
		                    	}
		                    	if(_attribute.objectType){
		                    		objectType = _attribute.objectType;
		                    	}
		                    }
		                    
		                   	document.getElementById("_file_Name").value = fileName;
		                   	document.getElementById("_file_describe").value = fileDescribe;
		                   	document.getElementById("_list_url").value = listURL;
		                   	document.getElementById("_del_url").value = delURL;
		                   	document.getElementById("_add_url").value = addURL;
		                   	document.getElementById("_edit_url").value = editURL;
		                   	document.getElementById("_object_type").value = objectType;
		                   	document.getElementById("_object_name").value = objectName;
		                   	
		                    ///console.info(_attribute);
		                    
		                    
	                    },
	                    onChildSuccess : function(data, rowdata) {
	                    	if(rowdata.children && rowdata.children.length > 0){
		                    	$.each(data, function(i,v){
		                    		$.each(rowdata.children, function(j, _rowdata){
			                    		if(v['fieldName'] == _rowdata['fieldName']){
			                    			data[i] = $.extend(true, v, _rowdata);
			                    		}
		                    		});
		                    		
		                    	});
	                    	}
	                    	initDatas(data);
	                    }
			});
    });

    $.extend($.ligerDefaults.Grid, {rowHeight : 24, fixedCellHeight : false, frozen : false, async : true, headerRowHeight : 30, allowUnSelectRow : true});
    //去掉  大于小于包括,并改变顺序
    $.ligerDefaults.Filter.operators['string'] = $.ligerDefaults.Filter.operators['text'] = ["like", "equal", "notequal", "startwith", "endwith"];

    //扩展一个 数字输入 的编辑器
    $.ligerDefaults.Grid.editors['numberbox'] = {create : function(container, editParm) {
	    var column = editParm.column;
	    var precision = column.editor.precision;
	    var input = $("<input type='text' style='text-align:right' class='l-text' style='width: 50px;'/>");
	    input.bind('keypress', function(e) {
		    var keyCode = window.event ? e.keyCode : e.which;
		    return keyCode >= 48 && keyCode <= 57 || keyCode == 46 || keyCode == 8;
	    });
	    input.bind('blur', function() {
		    var value = input.val();
		    input.val(parseFloat(value).toFixed(precision));
	    });
	    container.append(input);
	    return input;
    }, getValue : function(input, editParm) {
	    return parseFloat(input.val());
    }, setValue : function(input, value, editParm) {
	    var value = value || 0;
	    var column = editParm.column;
	    var precision = column.editor.precision;
	    input.val(value.toFixed(precision));
    }, resize : function(input, width, height, editParm) {
	    //input.width(width);
    	 input.width(width ).height(height );
    }};
    
    $.ligerDefaults.Grid.editors['string'] = $.ligerDefaults.Grid.editors['text'] = {create : function(container, editParm) {
	    var input = $("<input type='text' style='border:1px solid #d3d3d3;'/>");
	    container.append(input);
	    return input;
    }, getValue : function(input, editParm) {
	    return input.val();
    }, setValue : function(input, value, editParm) {
	    input.val(value);
    }, resize : function(input, width, height, editParm) {
	    //input.width(width).height(21);
	    input.width(width ).height(height );
    }};
    $.ligerDefaults.Grid.editors['select'] = {create : function(container, editParm) {
	    var column = editParm.column;
	    var input = $('<select></select>');
	    container.append(input);
	    var ext = column.editor.p || column.editor.ext;
	    var data = column.editor.data;
	    if (!data)
	    	input.append('<option value=""></option>');
		  //  return input;
	    $(data).each(function() {
		    input.append('<option value="' + this.value + '">' + (this.text || this.name) + '</option>');
	    });
	    if (ext) {
		    input.bind('click', function(event) {
			    event.stopPropagation();
			    var tmp = typeof (ext) == 'function' ? ext(editParm.record, editParm.rowindex, editParm.value, column) : ext;
			    input.val(editParm.value);
			    input.css('display', 'none');
		    });
	    }
	    return input;
    }, getValue : function(input, editParm) {
	    return input.val();
    }, setValue : function(input, value, editParm) {
	    if (value)
		    input.val(value);
    }, resize : function(input, width, height, editParm) {
	    //input.css({width : width, height : 24});
	    input.width(width ).height(height );
    }};
    $.ligerDefaults.Grid.editors['popupEdit'] = {create : function(container, editParm) {
	    var column = editParm.column;
	    var input = $('<input type="text" onbuttonclick="ext_click"/>');
	   
	    container.append(input);
	    var ext = column.editor.p || column.editor.ext;
	    var data = column.editor.data;
	    if (ext) {
	    	ext_click = ext;
	    }
	    return input;
    }, getValue : function(input, editParm) {
	    return input.val();
    }, setValue : function(input, value, editParm) {
	    if (value)
		    input.val(value);
    }, resize : function(input, width, height, editParm) {
	    //input.css({width : width, height : 24});
	    input.width(width ).height(height );
    }};
    
    $.ligerDefaults.Grid.editors['customselect'] = {create : function(container, editParm) {
	    var column = editParm.column;
	    var input = $('<input id="customselect_id" type="text">');
	    container.append(input);
	    var ext = column.editor.p || column.editor.ext;
	  /* /  var data = column.editor.data;
	    //if (!data)
		 //   return input;
	    $(data).each(function() {
		    input.append('<option value="' + this.value + '">' + (this.text || this.name) + '</option>');
	    }); */
	    if (ext) {
	    	 input.bind('click', function(event) {
				    event.stopPropagation();
				    event.preventDefault(); 
				    var tmp = typeof (ext) == 'function' ? ext(editParm.record, editParm.rowindex, editParm.value, column) : ext;
				    input.val(editParm.value);
				    input.css('display', 'none');
				    return false;
			    });
	    }
	    return input;
    }, getValue : function(input, editParm) {
	    return input.val();
    }, setValue : function(input, value, editParm) {
	    if (value)
		    input.val(value);
    }, resize : function(input, width, height, editParm) {
	    //input.css({width : width, height : 22});
	    input.width(width ).height(height );
    }};


    var dataSourceValidateTree = getTreeData(dataSourceValidate.rows);
    var dataScouceDataTree = getTreeData(dataScouceData);
    function getTreeData(data) {
	    var dataTree = {};
	    for ( var i = 0; i < data.length; i++) {
		    dataTree[data[i]['value']] = data[i];
	    }
	    return dataTree;
    };

    function dataSourceRender(rowdata, rowindex, value, column) {
	    if (typeof value == 'string') {
		    return dataScouceDataTree[value]['text'];
	    }
	    return "空";
    }
    function columnSelectRender(rowdata, rowindex, value, column){
    	if(value=='hide'){
    		return  '隐藏列';
    	}else if(value){
    		return "自定义";
    	} 
    	return "正常显示";
    }

    function initDatas(datas) {
    	var childredata = [];
    	var delIndex = [];
    	var dataFieldNames = {};
    	var attrIndex = null;
	    for ( var i = 0;i<datas.length;i++) {
	    	if(datas[i].fileName && datas[i].objectType ){//判断是不是属性字段
	    		_attribute = datas[i];
	    		attrIndex = i;
	    		continue;
	    	}
	    	
	    	if(datas[i]['property'] == 'collection'){continue;}
	    	
		    datas[i]['fkEntityName'] = datas[i]['fkEntityName'] || '';
		    datas[i]['property'] = datas[i]['property'] || '';
		    datas[i]['columnName'] = datas[i]['columnName'] || '';
		    datas[i]['fieldName'] = datas[i]['fieldName'] || '';
		    datas[i]['showName'] = datas[i]['showName'] || '';
		    //datas[i]['allownull'] = datas[i]['allownull'] || true;
			datas[i]['inlist'] = datas[i]['inlist'] || false;
		    datas[i]['listwidth'] = parseInt(datas[i]['listwidth']) || 180;
		    //datas[i]['render'] == datas[i]['render'] || null;
		    datas[i]['insearch'] = datas[i]['insearch'] || false;
		    datas[i]['inform'] = datas[i]['inform'] || false;
		    datas[i]['type'] = datas[i]['type'] || 'text';
		    datas[i]['datasource'] = datas[i]['datasource'] || 'empty';
		    datas[i]['datasourcevalue'] = datas[i]['datasourcevalue'] || null;
		    datas[i]['labelwidth'] = parseInt(datas[i]['labelwidth']) || 100;
		    datas[i]['validator'] = datas[i]['validator'] || "";
		    datas[i]['width'] = parseInt(datas[i]['width']) || 220;
		    datas[i]['space'] = parseInt(datas[i]['space']) || 20;
		    datas[i]['colspan'] = parseInt(datas[i]['colspan']) || 1;
		    //datas[i]['rowspan'] = datas[i]['rowspace'] || 1;
		    datas[i]['newline'] = datas[i]['newline'] || true;
		    datas[i]['group'] = datas[i]['group'] || '';
		    if (datas[i]['property'] == 'entity') {
			    datas[i]['children'] = [];
		    }
		    
		    if( datas[i]['insearch']){
		    	datas[i]['search_newline'] = datas[i]['search_newline'] || false;
		    	if(typeof datas[i]['search_newline'] == 'string'){
					datas[i]['search_newline']  == 'false' ?  datas[i]['search_newline'] = false : datas[i]['search_newline'] = true;
				}
		    	datas[i]['search_labelwidth'] = parseInt(datas[i]['search_labelwidth']);
		    	datas[i]['search_width'] = parseInt(datas[i]['search_width']);
		    	datas[i]['search_type'] = datas[i]['search_type'];
		    	datas[i]['search_quick'] = datas[i]['search_quick'];
		    	datas[i]['search_table'] = datas[i]['search_table'];
		    }
		    
		    
		    //处理从库里带回的布尔类型的

			if (typeof datas[i]['inlist'] == 'string') {
			    datas[i]['inlist'] == 'false' ? datas[i]['inlist'] = false : datas[i]['inlist'] = true;
		    }

		    if (typeof datas[i]['insearch'] == 'string') {
			    datas[i]['insearch'] == 'false' ? datas[i]['insearch'] = false : datas[i]['insearch'] = true;
		    } 

		    if (typeof datas[i]['inform'] == 'string') {
			    datas[i]['inform'] == 'false' ? datas[i]['inform'] = false : datas[i]['inform'] = true;
		    } 

		    if (typeof datas[i]['newline'] == 'string') {
			    datas[i]['newline'] == 'false' ? datas[i]['newline'] = false : datas[i]['newline'] = true;
		    }

		    //当columnName为点模式的时候，做处理
		    if (datas[i]['fieldName']) {
			    var columnStr = datas[i]['fieldName'];
			    if (columnStr.indexOf(".") != -1) {
				    childredata.push(datas[i]);
				    delIndex.push(i);
			    }
		    }
		    dataFieldNames[datas[i]['fieldName']] = datas[i];

	    }
	    delIndex.reverse();
	    for ( var j = 0; j < delIndex.length; j++) {
		    var dataFieldName = datas[delIndex[j]]['fieldName'].split(".")[0];
		    if (dataFieldNames[dataFieldName]) {
			    var childColumn = $.extend(true, {}, datas[delIndex[j]]);
			    childColumn.fieldName = childColumn.fieldName.substr(childColumn.fieldName.indexOf(".") + 1, childColumn.fieldName.length);

			    dataFieldNames[dataFieldName].children.push(childColumn);
			    datas.splice(delIndex[j], 1);
		    }

	    }
	    if(attrIndex != null){
	    	datas.splice(attrIndex, 1);
	    }
	    return datas;
    };

    function createGridToolbar(tName) {
	    var items = [];
	    items.push({text : '预览效果', click : preview, img : "resource/icons/application_view_list.png"});
	    items.push({text : '导出JSON', click : outjson, img : "resource/icons/printer_48.png"});
	    items.push({text : '上移', click : moveup, img : "resource/icons/sign_up.gif"});
	    items.push({text : '下移', click : movedown, img : "resource/icons/arrow_down.gif"});
	    items.push({text : '添加新行', click : addNewRow, img : "resource/icons/world.gif"});
	    items.push({text : '删除行', click : delRow, img : "resource/icons/world.gif"});
	    //items.push({ text: '自动翻译字段', click: translate, img: "resource/icons/world.gif" });
	    return {items : items};

	    function clear(o) {
		    if (openTargets.length > 0) {
			    for ( var i = 0; i < openTargets.length; i++) {
				    openTargets[i].destroy();
			    }
			    openTargets = [];
		    };
		    var managerid = [];
		    var managers = $.ligerui.find($.ligerui.controls.Input);
		    for ( var i = 0, l = managers.length; i < l; i++) {
			    managerid.push(managers[i].id);
			    if (exits(o, managers[i].id)) {
				    managers[i].destroy();
			    }

		    }
	    }

	    function exits(o, id) {
		    for ( var int = 0; int < o.length; int++) {
			    if (id == o[int]['name'])
				    return true;
		    }
		    return false;
	    }

	    function preview() {
		    var o = bulidData();
		    clear(o.form);

		    var out = [];
		    out.push('<div>');
		    out.push('  <div style=" width:98%">');
		    out.push('      <div class="searchtitle">');
		    out.push('          <span>搜索</span><img src="resource/icons/searchtool.gif" />');
		    out.push('          <div class="togglebtn"></div> ');
		    out.push('      </div>');
		    out.push('      <div class="navline" style="margin-bottom:4px; margin-top:4px;"></div>');
		    out.push('      <div class="searchbox">');
		    out.push('          <form></form>');
		    out.push('      <div class="l-clear"></div>');
		    out.push('      </div>');
		    out.push('  </div>');
		    out.push('  <div class="listgrid"></div> ');
		    out.push('</div>');
		    var listPanle = $(out.join(''));

		    var searchform = $("form:first", listPanle);
		    searchform.ligerForm({fields : o.search});

		    var AllProductData = {};
		    jQuery.post('', function(value) {

		    });

		    var listgrid = $(".listgrid:first", listPanle).ligerGrid({columns : o.grid, toolbar : listToolbar(), data : $.extend(true, {}, AllProductData), width : '100%', height : 400, checkbox : false});

		    //搜索 按钮
		    lab.appendSearchButtons(searchform, listgrid, false, function() {
			    listgrid.options.data = $.extend(true, {}, AllProductData);
		    });

		    $.ligerDialog.open({title : '预览 列表 界面', target : listPanle, width : 950, height : 530, isResize : true, isHidden : false,
		    //modal : false,
		    buttons : [{text : '关闭', onclick : function(item, dialog) {
			    dialog.close();
		    }}]});

		    function listToolbar() {
			    var items = [];
			    items.push({text : '增加', click : grid_add, img : "resource/icons/page_add.png"});
			    items.push({text : '修改', click : grid_edit, img : "resource/icons/edit.gif"});
			    items.push({text : '删除', click : grid_delete, img : "resource/icons/delete.png"});
			    items.push({text : '高级自定义查询', click : grid_search, icon : 'search2'});
			    return {items : items};

			    function grid_add() {
				    clear(o.form);
				    showDetail(o.form);
			    }

			    function grid_edit() {
				    clear(o.form);
				    var selected = listgrid.getSelected();
				    if (!selected) {
					    lab.tip('请选择行');
					    return;
				    }
				    showDetail(o.form, selected);
			    }

			    function grid_delete() {
				    listgrid.deleteSelectedRow();
			    }

			    function grid_search() {
				    listgrid.options.data = $.extend(true, {}, AllProductData);
				    listgrid.showFilter();
			    }
		    }
	    }
	    function showDetail(fields, data) {
		    var form = $('<form></form> ');
		    var openForm = form.ligerForm({fields : fields});

		    //openTargets.push(openForm);
		    $.ligerDialog.open({title : '预览 明细 界面', target : form, width : 850, height : 400, isResize : false, buttons : [{text : '关闭', onclick : function(item, dialog) {
			    dialog.close();
		    }}]});

		    //lab.loadForm(form, data);
	    }

	    function outjson() {
		    var d = bulidData();
		    var textarea = $("<textarea />").width(400).height(120);
		    textarea.val($.ligerui.toJSON(d));
		    $.ligerDialog.open({title : 'JSON', target : textarea.wrap('<div></div>').parent().css('margin', 10), width : 470, height : 200, isResize : true, buttons : [{text : '关闭', onclick : function(item, dialog) {
			    dialog.hide();
		    }}]});
	    }
	    function translate() {
		    var list = [];
		    for ( var i = 0, l = grid.rows.length; i < l; i++) {
			    var o = grid.rows[i];
			    list.push(o.name);
		    }
		    lab.ajax({loading : '正在翻译中...', url : root + "handle/translate.ashx", data : {data : list.join(',')}, success : function(results) {
			    for ( var i = 0, l = grid.rows.length; i < l; i++) {
				    grid.rows[i].display = results[i];
			    }
			    grid.reRender({column : grid.columns[1]});
		    }});
	    }
	    function moveup() {
		    var selected = grid.getSelected();
		    if (!selected)
			    return;
		    grid.up(selected);
	    }
	    function movedown() {
		    var selected = grid.getSelected();
		    if (!selected)
			    return;
		    grid.down(selected);
	    }
    }

    //获取 表单和表格 结构 所需要的数据
    function bulidData() {
	    var griddata = [], searchdata = [], formdata = [], allGriddata = [];
	    //将所有children数据全部提取，平面展现到griddata中
	    var allData = getAllRows(grid.rows);
	    var ss = {};
	    for ( var i = 0, l = allData.length; i < l; i++) {
		    var o = allData[i];
		    ss[o.fieldName] = 1;
		    if (o.inlist) {
			    var gridColumn = {display : o.showName, name : o.fieldName, width : o.listwidth};
			    if (o.render) {
				    if (o.render == 'hide') {
					    gridColumn['hide'] = true;
				    } else {
					    gridColumn['render'] = o.render;
				    }
			    }
			    griddata.push(gridColumn);
		    }
		    if (o.insearch) {
			    searchdata.push(getFieldData(o, true));
		    }
		    if (o.inform) {
			    formdata.push(getFieldData(o));
		    }
	    }
	   // console.info($.toJSON(ss));
	    return {grid : griddata, search : searchdata, form : formdata};

	    function getFieldData(o, search) {
		    if (o.type == "hidden") {
			    return {name : o.fieldName, type : o.type};
		    }
		    var field = {display : o.showName, name : o.fieldName};
		    if (!search) {
			    $.extend(field, {newline : o.newline, labelwidth : o.labelwidth, width : o.width, space : o.space, type : o.type, colspan : o.colspan, validator : o.validator, datasource : o.datasource});
			    if (o.datasourcevalue) {
				    field.datasourcevalue = o.datasourcevalue;
			    }
			    //field.validate = getValidate(o);
			    field.group = o.group;
			    field.groupicon = "resource/icons/communication.gif";
		    } else {
			    field.cssClass = "field";
			    field.search_newline = o.search_newline;
			    field.search_labelwidth = o.search_labelwidth;
			    field.search_width = o.search_width;
			    field.search_type = o.search_type;
			    field.search_quick = o.search_quick;
			    field.search_table = o.search_table;
		    }
		    return field;
	    }
	    /*  function getValidate(o) {
	        if (o.validate)
	    	    return o.validate;
	        if (!o.allownull)
	    	    return {required : true};
	        return null;
	     } */
    }

    function getAllRows(rows) {//将所有children数据平面显示到data中
	    var gridRows = [];
	    var rowItems = rows.slice(0);
	    for ( var i = 0; i < rowItems.length; i++) {
		    if (rowItems[i].__pid == -1) {
			    var name = rowItems[i].fieldName;
			    getChildrenRowsData(rowItems[i], name);
		    }
	    }
	    return gridRows;

	    function getChildrenRowsData(rowItem, name) {
		    if (rowItem.__hasChildren && rowItem.children.length > 0) {
			    for ( var i = 0; i < rowItem.children.length; i++) {
				    var fieldName = name + '.' + rowItem.children[i].fieldName;
				    getChildrenRowsData(rowItem.children[i], fieldName);
			    }
		    } else if (rowItem.property == 'collection') {
			    //do something;
		    }
		    rowItemClone = $.extend(true, {}, rowItem);

		    delete rowItemClone.__hasChildren;
		    delete rowItemClone.__id;
		    delete rowItemClone.__index;
		    delete rowItemClone.__level;
		    delete rowItemClone.__nextid;
		    delete rowItemClone.__pid;
		    delete rowItemClone.__previd;
		    delete rowItemClone.__recordid;
		    delete rowItemClone.__status;
		    rowItemClone.fieldName = name;
		    gridRows.push(rowItemClone);
	    }

    }

    //字段类型渲染器
    function fieldTypeRender(r, i, value) {
	    for ( var i = 0, l = fieldTypeData.length; i < l; i++) {
		    var o = fieldTypeData[i];
		    if (o.value == value)
			    return o.text || o.name;
	    }
	    return "文本框";
    }

    //显示字段渲染
    function fieldNameRender(rowdata, rowindex,value,column){
    	var fieldStr = '<span ';
    	switch (rowdata.property) {
        case 'identified':
        	fieldStr += 'title="主键" style="color:red;"' + '>'+ value ;
	        break;
        case 'column':
        	fieldStr += 'title="字段" style="color:#1d953f;"'+ '>'+ value;
	        break;
        case 'entity':
        	fieldStr += 'title="引用类型" style="color:#8552a1;"'+ '>'+ value;
	        break;
        case 'collection':
        	fieldStr += 'title="引用类型" style="color:#ea66a6;">['+ value + ']';
        	
	        break;

        default:
        	fieldStr +='>'+ value;
	        break;
        }
    	
    	fieldStr +=  '</span>';
    	if(rowdata.property == 'collection'){
    		//console.info(fieldStr);
    	}
    	return fieldStr;
    }
    //是否类型的模拟复选框的渲染函数
    function checkboxRender(rowdata, rowindex, value, column) {
	    var iconHtml = '<div class="chk-icon';
	    if (value && column.name != 'newline') {
		    iconHtml += " chk-icon-selected";
	    } else if (column.name == 'newline' && !rowdata.inform) {
		    iconHtml += " chk-icon-disabled";
	    } else if (column.name == 'newline' && rowdata.inform && rowdata.newline) {
		    iconHtml += " chk-icon-selected";
	    }
	    iconHtml += '"';
	    iconHtml += ' rowid = "' + rowdata['__id'] + '"';
	    iconHtml += ' gridid = "' + this.id + '"';
	    iconHtml += ' columnname = "' + column.name + '"';
	    iconHtml += '></div>';
	    //判断grid中不同显示方式
	    if (rowdata.__hasChildren && (column.name == 'inlist' || column.name == 'insearch' || column.name == 'search_newline')) {
		    iconHtml = '<div class="chk-icon chk-icon-disabled"></div>';
	    }
	    if (rowdata.__pid != -1 && (column.name == 'inform')) {
		    iconHtml = '<div class="chk-icon chk-icon-disabled"></div>';
		    rowdata.inform = false;
	    }
	    if (rowdata.__pid != -1 && (column.name == 'newline')) {
		    iconHtml = '<div class="chk-icon chk-icon-disabled"></div>';/* rowdata.inform=false; */
	    }
	    //当点击inform的时候
	    if (column.name == 'inform') {
		    var newlineDiv = $(window.grid.getCellObj(rowdata, window.grid.getColumn('newline')));
		    if (rowdata.inform) {
			    $('.chk-icon-disabled', newlineDiv).removeClass('chk-icon-disabled');
			    if (rowdata.newline) {
				    $('.chk-icon', newlineDiv).addClass('chk-icon-selected');
			    }
		    } else {
			    $('.chk-icon', newlineDiv).addClass('chk-icon-disabled').removeClass('chk-icon-selected');

		    }
	    }
	    return iconHtml;
    }
    //是否类型的模拟复选框的点击事件
    $("div.chk-icon").live('click', function() {
	            var grid = $.ligerui.get($(this).attr("gridid"));
	            if (grid) {
		            var rowdata = grid.getRow($(this).attr("rowid"));
		            var columnname = $(this).attr("columnname");
		            var checked = rowdata[columnname];
		            //如果点击了列表显示，则表单也显示
		            if (columnname == 'inlist' && !checked) {
			            grid.updateCell('inform', true, rowdata);
		            }
		            if (columnname == 'inform' && !checked) {
			            //grid.updateCell('newline', true, rowdata);
		            }

		            //如果点击了搜索框，则弹出搜索选项
		            if (columnname == 'insearch') {
			            var search_type_option = '';

			            var search_labelwidth = parseInt(rowdata.search_labelwidth) || 120;
			            var search_width = parseInt(rowdata.search_width) || 220;
			            var search_type = rowdata.search_type || 'text';
			            var search_quick = rowdata.search_quick || false;
			            var search_table = rowdata.search_table || false;

			            for ( var i = 0; i < fieldTypeData.length; i++) {
				            search_type_option += '<option value="'+fieldTypeData[i]['value']+'">' + fieldTypeData[i]['text'] + '</option>';
			            }
			            var searchArea = $("<div/>").width(400).height(160);
			            var searchHtml = '<table cellpadding="0" cellspacing="0" class="l-table-edit" >' + '<tr>' 
			            + '    <td align="right" class="l-table-edit-td">搜索是否显示</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '        <input type="checkbox" name="insearch" />' 
			            + '    </td>' 
			            + '</tr>' 
			            + '<tr>' 
			            + '    <td align="right" class="l-table-edit-td">快速搜索</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '        <input type="checkbox" name="search_quick" />' 
			            + '    </td>' 
			            + '</tr>' 
			            + '<tr>' 
			            + '    <td align="right" class="l-table-edit-td">表格搜索</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '        <input type="checkbox" name="search_table" />' 
			            + '    </td>' 
			            + '    <td align="right" class="l-table-edit-td">搜索是否新行</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '        <input type="checkbox" name="search_newline" />' 
			            + '    </td>' 
			            + '</tr>' 
			            + '<tr>'
			            + '    <td align="right" class="l-table-edit-td">标签宽度:</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '        <input name="search_labelwidth" type="text"  ligerui="{type:"numberbox"}" value="'+search_labelwidth+'" />' 
			            + '    </td><td align="left"></td>' + '</tr>' + '<tr>' + '    <td align="right" class="l-table-edit-td">搜素框宽度:</td>' 
			            + '    <td align="left" class="l-table-edit-td">'
			            + '        <input name="search_width" type="text"  ligerui="{type:"numberbox"}" value="'+search_width+'" />' 
			            + '    </td><td align="left"></td>' + '</tr>' + '<tr>' + '    <td align="right" class="l-table-edit-td" >搜索类型:</td>' 
			            + '    <td align="left" class="l-table-edit-td">' 
			            + '    <select name="search_type" ltype="select" value="'+search_type+'">'+ search_type_option + '    </select>' 
			            + '   </td>' + '</tr>' 
			            + '</table>';
			            searchArea.html(searchHtml);
			            if (rowdata.insearch) {
				            $('input[name="insearch"]', searchArea).attr("checked", true);
			            }
			            if (rowdata.search_newline) {
				            $('input[name="search_newline"]', searchArea).attr("checked", true);
			            }
			            if (rowdata.search_type) {
				            $('select[name="search_type"]', searchArea).attr("checked", rowdata.search_type);
			            }
			            if (rowdata.search_quick) {
				            $('input[name="search_quick"]', searchArea).attr("checked", true);
			            }
			            if (rowdata.search_table) {
				            $('input[name="search_table"]', searchArea).attr("checked", true);
			            }

			            // textarea.val($.ligerui.toJSON(d));
			            $.ligerDialog.open({title : '搜索选项', target : searchArea.wrap('<div></div>').parent().css('margin', 10), width : 470, height : 300, isResize : true, buttons : [{text : '保存', onclick : function(item, dialog) {
				            rowdata.insearch = $('input[name="insearch"]', searchArea).attr("checked");
				            if (rowdata.insearch) {
					            rowdata.insearch = true;
					            rowdata.search_newline = $('input[name="search_newline"]', searchArea).attr("checked");
					            rowdata.search_labelwidth = $('input[name="search_labelwidth"]', searchArea).val();
					            rowdata.search_width = $('input[name="search_width"]', searchArea).val();
					            rowdata.search_type = $('select[name="search_type"]', searchArea).val();
					            rowdata.search_quick = $('input[name="search_quick"]', searchArea).attr("checked");
					            rowdata.search_table = $('input[name="search_table"]', searchArea).attr("checked");

					            grid.updateCell(columnname, true, rowdata);
				            } else {
					            rowdata.insearch = false;
					            delete rowdata.search_newline;
					            delete rowdata.search_labelwidth;
					            delete rowdata.search_width;
					            delete rowdata.search_type;
					            delete rowdata.search_quick;
					            delete rowdata.search_table;
					            grid.updateCell(columnname, false, rowdata);
				            }
				            dialog.hide();
			            }}]});
			            return;
		            }
		            grid.updateCell(columnname, !checked, rowdata);
	            }
            });

    //搜索框 收缩/展开
    $(".searchtitle .togglebtn").live('click', function() {
	    if ($(this).hasClass("togglebtn-down"))
		    $(this).removeClass("togglebtn-down");
	    else
		    $(this).addClass("togglebtn-down");
	    var searchbox = $(this).parent().nextAll("div.searchbox:first");
	    searchbox.slideToggle('fast');
    });
    //保存
    function save() {
	    var o = bulidData();
	    var g = $.ligerui.get('combox');
	    o.attribute = {};
	    o.attribute.fileName = document.getElementById("_file_Name").value;
	    if (!o.attribute.fileName) {

		    alert("请填写名称,(英文字符)");
		    return;
	    } else {
		    if (!/^[A-Za-z]+$/g.test(o.attribute.fileName)) {
			    alert("名称仅限英文字符下横线和点");
			    return;
		    }
	    }

	    o.attribute.fileDescribe = document.getElementById("_file_describe").value;
	    o.attribute.objectType = g.getValue();
	    o.attribute.objectName = g.findTextByValue(g.getValue());
	    o.attribute.fileName = document.getElementById("_file_Name").value;
	    o.attribute.fileDescribe = document.getElementById("_file_describe").value;
	    o.attribute.listURL = document.getElementById("_list_url").value;
	    o.attribute.delURL = document.getElementById("_del_url").value;
	    o.attribute.addURL = document.getElementById("_add_url").value;
	    o.attribute.editURL = document.getElementById("_edit_url").value;
	    o.attribute.objectType = document.getElementById("_object_type").value;
	    o.attribute.objectName = document.getElementById("_object_name").value;

/* 	    if (!o.attribute.objectType) {
		    var exi = $("#exist").ligerComboBox();
		    for ( var i = 0; i < exi.data.length; i++) {
			    if (exi.data[i]['id'] == exi.getValue()) {
				    var attr = $.evalJSON(exi.data[i]['attribute']);
				    o.attribute.objectType = attr.objectType;
				    o.attribute.objectName = attr.objectName;
			    }
		    }
	    } */

	   // var s = $.toJSON(o);
	    //var s = JSON.stringify(o);

	    var param = {param : $.toJSON(o)};
	    $.post("commController.action?saveCommGrid", param, function(v) {
		    if (v == 'false') {
			    //var msg = $.ligerDialog.tip({title : '提示信息', content : '保存失败！！'});
			    lab.tip('保存失败！！');
			    //setTimeout('msg.close()', 3000);
		    } else if (v == 'true') {

			    // var msg = $.ligerDialog.tip({title : '提示信息', content : '保存成功'});
			    lab.tip('保存成功');
			    //	setTimeout('cosole.info('+msg+')', 1000);
		    }
	    });
    }
    function closeMsg(msg) {
	    msg.close();
    }
    function f_customselect(record, rowindex, value, column) {
	    var htmlStr = '<input type="radio" name="columntype" checked=true value="normal"/>正常显示&nbsp&nbsp<input type="radio" name="columntype" value="hide"/>隐藏列&nbsp&nbsp<input type="radio" name="columntype" value="cust"/>自定义<br/><div>自定义函数提供两个个变量,rowdata:为当前行数据，rowindex为当前行索引。例子如下<br/><span style="color:red;">function(rowdata, rowindex){return ""};</span></div><textarea/>';
	    var $custArea = $("<div/>").html(htmlStr);
	    var $textarea = $('textarea', $custArea).width(410).height(120);
	    var $input = $('input[name="columntype"]', $custArea).bind('change', function(event) {
		    event.stopPropagation();
		    if ($input.filter(':checked').val() == 'cust') {
			    $textarea.removeAttr("disabled", true);
			    $textarea.css("resize", 'both');
		    } else {
			    $textarea.attr("disabled", true).css("resize", 'none');
		    }
	    });
	    if (record.render) {
		    $textarea.html(record.render);
		    $('input[value="normal"]', $custArea).attr("checked", false);
		    $('input[value="hide"]', $custArea).attr("checked", false);
		    $('input[value="cust"]', $custArea).attr("checked", true);

	    }
	    var checkedVal = $input.filter(':checked').val();
	    if (checkedVal == 'normal' || checkedVal == 'hide') {
		    $textarea.attr("disabled", true).css("resize", 'none');
	    }

	    $.ligerDialog.open({title : '添加新行', target : $custArea.wrap('<div></div>').parent().css('margin', 10), width : 470, height : 300, isResize : true, buttons : [{text : '确定', onclick : function(item, dialog) {
		    if ($input.filter(':checked').val() == 'cust') {
			    $('#customselect_id').val($textarea.val());
		    } else if ($input.filter(':checked').val() == 'hide') {
			    $('#customselect_id').val('hide');
		    } else {
			    if (record.render) {
				    delete record.render;
			    }
		    }
		    dialog.hide();
	    }}]});

	    //openTargets.push(opencombox);
	    return false;
    }
    function f_selectDepartment(record, rowindex, value, column) {
	    var tempDiv = $('#temp');
	    if (tempDiv.has('#combox_temp').length == 0) {
		    tempDiv.html("");
		    tempDiv.append('<div><input id="combox_temp"></input><form></form></div>');
	    };
	    var opentarget = $('#temp div');
	    var opencombox = $('#temp input').ligerComboBox({valueField : 'value', textField : 'text', data : dataScouceData, onSelected : function(value, text) {
		    var fields = dataSourceForm[value] || [];
		    var form = opentarget.find('form');
		    form.html("");
		    form.removeAttr('ligeruiid');
		    var openForm = form.ligerForm({fields : fields});
		    openTargets.push(openForm);
		    dialog.openForm = openForm;
	    }});
	    var dialog = $.ligerDialog.open({title : '选择数据源方式', width : 700, height : 300, target : opentarget, buttons : [{text : '确定', onclick : f_selectDepartmentOK}, {text : '取消', onclick : f_selectDepartmentCancel}], onClose : function() {
		    var dialog = this;
	    	dialog.opencombox.destroy();
		    if (dialog.openForm)
			    dialog.openForm.destroy();
	    }});

	    opencombox.selectValue(record.datasource);

	    if (record.datasourcevalue) {
		    var data = $.evalJSON(record.datasourcevalue);
		    /* var mainform = dialog.openForm.element;
		    var prefix = dialog.openForm.id + '_';
		    lab.loadForm(mainform, data, prefix);
		     */
		    var mainform = dialog.openForm;
		    mainform.setValues(data);
	    }

	    dialog.opencombox = opencombox;
	    dialog.getRecord = function() {
		    return record;
	    };

	    //openTargets.push(opencombox);
	    return false;
    }
    function f_selectDepartmentOK(item, dialog) {
	    var combox = dialog.opencombox;
	    var form = dialog.openForm;
	    var datasourceObject = $(form.element).serializeObject();
	    var record = dialog.getRecord();
	    record.datasource = combox.selectedValue;
	    record.datasourcevalue = $.toJSON(datasourceObject);
	    dialog.close();
    }

    function f_selectDepartmentCancel(item, dialog) {
	    dialog.close();
    }
    
    function clearValidate(date){
    	//console.info(this);
    	//console.info(date);
    }

    function f_selectValidateOK(item, dialog) {
	    var validatorValue = "",validateContent = '',validateOption = '',selectValues = dialog.validatorGrid.getCheckedRows();
		//返显
		if(dialog.rowdata.record.validator){
			//console.info(dialog.rowdata.record.validator);
		}
	    
	    
	    
	    for ( var int = 0; int < selectValues.length; int++) {

		    var validateMethod = $("select[name='validateMethod']", dialog.element).val();
		    var spear = '|';
		    validateMethod == 'and' ? spear = ',' : spear = '|';
		    switch (selectValues[int]['value']) {
		    /* case 'Require':
		    	var requireValue = $("select[name='Require']", dialog.element).val();
		    	console.info(requireValue);
		    	validatorValue += ' Require="' + requireValue + '"';
		    	validatorName += selectValues[int]['text'] + ',';
		    	break; */
		    case 'Repeat':
			    var toValue = $("input[name='Repeat']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += ' recheck="' + toValue + '"';
			    break;
		    case 'Compare':
			    var toValue = $("input[name='Compare_operator']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += ' to="' + toValue + '"';
			    break;
		    case 'Range':
			    var min = $("input[name='Range_min']", dialog.element).val();
			    var max = $("input[name='Range_max']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += 'min="' + min + '"' + ' max="' + max + '"';
			    break;
		    case 'Limit':
			    var max = $("input[name='Limit']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += ' max="' + max + '"';
			    break;
		    case 'LimitB':
			    var max = $("input[name='LimitB']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += ' max="' + max + '"';
			    break;
		    case 'Custom':
			    var customValue = $("input[name='Custom']", dialog.element).val();
			    validateContent += selectValues[int]['value'] + spear;
			    validateOption += ' regexp="' + customValue + '"';
			    break;

		    default:
			    validateContent += selectValues[int]['value'] + spear;
			    break;
		    }
	    }
	    if (validateContent != '') {
		    validatorValue = 'dataType="' + validateContent.substr(0, validateContent.length - 1) + '"';
		    if (validateOption != '') {
			    validatorValue += validateOption;
		    }

		    var isRequireValue = $("select[name='ignore']", dialog.element).val();
		    var sucmsg = $("input[name='sucmsg']", dialog.element).val();
		    var errormsg = $("input[name='errormsg']", dialog.element).val();
		    var nullmsg = $("input[name='nullmsg']", dialog.element).val();

		    if (isRequireValue == "false" && validatorValue.indexOf('dataType') != -1) {
			    validatorValue += ' ignore="ignore"';
		    }
		    if (sucmsg && sucmsg != "" && validatorValue.indexOf('dataType') != -1) {
			    validatorValue += ' sucmsg="' + sucmsg + '"';
		    }
		    if (errormsg && errormsg != "" && validatorValue.indexOf('dataType') != -1) {
			    validatorValue += ' errormsg="' + errormsg + '"';
		    }
		    if (nullmsg && nullmsg != "" && validatorValue.indexOf('dataType') != -1 && isRequireValue != "false") {
			    validatorValue += ' nullmsg="' + nullmsg + '"';
		    }
		   /*  if (validatorValue && validatorValue != '' && validatorValue.indexOf('dataType') != -1) {
		    	console.info(validatorValue);
		    } */
	    }
		dialog.rowdata.record.validator = validatorValue.substring(0, validatorValue.length);
	    dialog.close();
    }

    function f_selectValidateCancel(item, dialog) {
	    dialog.close();
    }

    function validateDialogRender(value, index) {
	    switch (value.value) {
	    /* case 'Require':
	    	return '<select name="Require"><option value="true">是</option><option value="false">否</option></select>';
	    	break; */
	    case 'Repeat':
		    return '<input type="text" name="Repeat" style="width:220px;"></input>';
		    break;
	    case 'Compare':
		    return '<select name="Compare_operator"><option value="">等于</option><option value="NotEqual">不等于</option><option value="GreaterThan">大于</option><option value="GreaterThanEqual">大于等于</option><option value="LessThanEqual">小于等于</option><option value="LessThan">小于</option></select> <input type="text" name="Compare" style="width:150px;"></input>';
		    break;
	    case 'Limit':
		    return '<input type="text" title="一个中文算一位" name="Limit" style="width:220px;"></input>';
		    break;
	    case 'Custom':
		    return '<input type="text" name="Custom" style="width:220px;"></input>';
		    break;
	    case 'LimitB':
		    return '<input type="text" title="一个字节算一位" name="LimitB" style="width:220px;"></input>';
		    break;
	    case 'Range':
		    return '<input type="text" name="Range_min" style="width:100px;"></input> - <input type="text" name="Range_max" style="width:100px;"></input>';
		    break;

	    default:
		    return '<strong>' + value.value + '</strong>';
		    break;
	    }
    }

    function validateExt(rowdata) {
	    return {onBeforeOpen : function validateOnBeforeSelect() {
    		var validateValue = "";
    		if(rowdata.record.validator){
    			validateValue = rowdata.record.validator.replace(/\"/g,"");
    		}
    		///console.info(validateValue);
		    if ($("#tem_gird").length == 0) {
			    $("#temp").append('<div id="tem_target"><div></div><lable>验证方式：</label><select name="validateMethod"><option></option><option value="and">规则累加</option><option value="or">多选一</option></select><br><label>成功提示信息：</lable><input style="width:200px" name="sucmsg" type="text"></input><br><label>错误提示信息：</lable><input style="width:200px" name="errormsg" type="text"></input><br><label>空值提示信息：</lable><input style="width:200px" name="nullmsg" type="text"></input><br><lable>是否为必选项：</label><select name="ignore"><option></option><option value="true">是</option><option value="fasle">否</option></select><br><input type="button" value="清空" onclick="clearValidate(this);" ></input ><br></div>');
		    }
		    var validatorGrid = $("#tem_target :first").ligerGrid({columns : [{display : '验证名称', name : 'text', width : 150, align : 'left'}, {display : '验证值', name : 'value', width : 270, algin : 'center', render : validateDialogRender}], usePager : false, isScroll : false, checkbox : true, data : dataSourceValidate, selectRowButtonOnly : true
		    //width : '99%'
		    });
		    var opentarget = $('#tem_target');

		    var dialog = $.ligerDialog.open({title : '选择验证', width : 500, height : 300, target : opentarget, 
		    	buttons : [{text : '确定', onclick : f_selectValidateOK}, {text : '取消', onclick : f_selectValidateCancel}], 
		    	onClose : function() {
			    this.validatorGrid.destroy();
		    }});
			//反向引用，将rowdata的值指向dialog.rowdata；
		    dialog.validatorGrid = validatorGrid;
		    dialog.rowdata = rowdata;
		    return false;
	    }, render : function() {
		    if (rowdata.validator && rowdata.validator != '') {
			    var returnStr = "";
			    var validateVal = rowdata.validator.replace(new RegExp('"', "gm"), '');
			    var validateValueArray = validateVal.split(" ");
			    for ( var i = 0; i < validateValueArray.length; i++) {
				    if (validateValueArray[i].indexOf('dataType') != -1) {
					    var valStrArray = [];
					    var valStrs = validateValueArray[i].substr(validateValueArray[i].indexOf('dataType') + 9, validateValueArray[i].length - 1);
					    valStrs.indexOf('|') != -1 ? valStrArray = valStrs.split('|') : valStrArray = valStrs.split(',');
					    for ( var j = 0; j < valStrArray.length; j++) {
						    returnStr += dataSourceValidateTree[valStrArray[j]]['text'] + ',';
					    }
				    }
			    }
			    return returnStr.substring(0, returnStr.length - 1);
		    }
		    return "";
	    }/* function() {
	                if (rowdata.validator && rowdata.validator != '') {
	                    var returnStr = "";
	                    var validateVal = rowdata.validator.replace(new RegExp('"', "gm"), '');
	                    var validateValueArray = validateVal.split(" ");
	                    for ( var i = 0; i < validateValueArray.length; i++) {
	                        if (validateValueArray[i] && validateValueArray[i] != '') {
	    	                    if (validateValueArray[i].indexOf('Require') != -1) {
	    		                    returnStr += "必填项";
	    		                    var valStr = validateValueArray[i].substr(validateValueArray[i].indexOf('Require') + 8, validateValueArray[i].length - 1);
	    		                    if (valStr == 'true') {
	    			                    returnStr += "是,";
	    		                    } else {
	    			                    returnStr += "否,";
	    		                    }
	    	                    } else if (validateValueArray[i].indexOf('dataType') != -1) {
	    		                    var valStr = validateValueArray[i].substr(validateValueArray[i].indexOf('dataType') + 9, validateValueArray[i].length - 1);
	    		                    returnStr += dataSourceValidateTree[valStr]['text'] + ',';
	    	                    }
	                        }
	                    }
	                    return returnStr.substring(0, returnStr.length - 1);
	                }
	                return "";

	            } */};
    }

    function validateRender(rowdata, rowindex, value, column) {
    	//console.info(rowdata);
	    if (rowdata.validator && rowdata.validator != '') {
		    var returnStr = "";
		    var validateVal = rowdata.validator.replace(new RegExp('"', "gm"), '');
		    var validateValueArray = validateVal.split(" ");
		    for ( var i = 0; i < validateValueArray.length; i++) {
			    if (validateValueArray[i].indexOf('dataType') != -1) {
				    var valStrArray = [];
				    var valStrs = validateValueArray[i].substr(validateValueArray[i].indexOf('dataType') + 9, validateValueArray[i].length - 1);
				    valStrs.indexOf('|') != -1 ? valStrArray = valStrs.split('|') : valStrArray = valStrs.split(',');
				    for ( var j = 0; j < valStrArray.length; j++) {
					    returnStr += dataSourceValidateTree[valStrArray[j]]['text'] + ',';
				    }
			    }
		    }
		    return returnStr.substring(0, returnStr.length - 1);
	    }
	    return "";
    }

    function delRow(){
    	 var selectedRow = window.grid.getSelected();
    	 if(!selectedRow){
    		 alert("请选择删除的行");
    	 }
    	 window.grid.deleteSelectedRow();
    }
    function addNewRow() {
	    var selectedRow = window.grid.getSelected();
	    var rowParamDidv = $("<div/>").width(400).height(120);
	    var htmlStr = '<table cellpadding="0" cellspacing="0" class="l-table-edit" >' + '<tr>' + '    <td align="right" class="l-table-edit-td">字段名称:</td>' + '    <td align="left" class="l-table-edit-td">' + '        <input type="text" name="fieldName" />' + '    </td>' + '</tr>' + '<tr>' + '    <td align="right" class="l-table-edit-td">显示名称:</td>' + '    <td align="left" class="l-table-edit-td">' + '        <input type="text" name="showName"/>' + '    </td>' + '</tr>' + '<tr>' + '    <td align="right" class="l-table-edit-td">插入选择行之前:</td>' + '    <td align="left" class="l-table-edit-td">' + '        <input type="checkbox" name="beforeSelect"/>' + '    </td>' + '</tr>' + '</table>';
	    var $rowParamDidv = $(rowParamDidv).html(htmlStr);
	    $.ligerDialog.open({title : '添加新行', target : rowParamDidv.wrap('<div></div>').parent().css('margin', 10), width : 470, height : 220, isResize : true, buttons : [{text : '确定', onclick : function(item, dialog) {
		    var fieldName = $('input[name="fieldName"]', $rowParamDidv).val();
		    var showName = $('input[name="showName"]', $rowParamDidv).val();
		    var columnName = $('input[name="beforeSelect"]', $rowParamDidv).attr("checked") == 'checked';

		    if (!/^[A-Za-z_\.]+$/g.test(fieldName)) {
			    alert("名称必填且仅限英文字符下横线和点");
			    return;
		    }
		    if (columnName) {
			    if (!selectedRow) {
				    alert("1、可以关闭此框选择列表中的行\n2、可以去除'插入选择行之前:'勾选，插入到组后一行");
				    return;
			    }
		    }
		    var data = initDatas([{fieldName : fieldName, showName : showName}]);
		    var currentData = window.grid.getData();
		    for ( var key = 0; key < currentData.length; key++) {
			    if (fieldName == currentData[key]['fieldName']) {
				    alert("字段名称重复，请从新填写字段名称");
				    $('input[name="fieldName"]', $rowParamDidv).focus();
				    return;
			    }
		    }
		    window.grid.addRow(data[0], selectedRow, columnName);

		    dialog.hide();
	    }}]});

    }
    
    function showAttr(){
    	$('#attr').toggle();
    }
</script>


</head>
<body>

	<!-- *********************描述模块******************************** -->
	<!-- <form id="id">123</form> -->
	<div style="display: inline;">
		<table>
			<tr>
				<td>数据列表</td>
				<td><input id="combox" type="text" /></td>
				<td>现有回显</td>
				<td><input id="exist" type="text" /></td>
			</tr>
			<tr>
				<td>文件名</td>
				<td><input id="_file_Name" type="text"></input></td>
				<td>描述</td>
				<td><input id="_file_describe" type="text"></input></td>
			</tr>
		</table>
	</div>
	<button id="save" onclick="save()">保存</button>
	
	<button id="showAttr" onclick="showAttr();">显示高级配置</button>
	<div id="attr" style="display: none">
	<table>
		<tr>
			<td>列表URL</td>
			<td><input id="_list_url" type="text"/></td>
			<td>删除URL</td>
			<td><input id="_del_url" type="text"></input><br /></td>
			<td>添加URL</td>
			<td><input id="_add_url" type="text"/></td>
			<td> 修改URL</td>
			<td><input id="_edit_url" type="text"/></td>
			<td>对象类型</td>
			<td><input id="_object_type" type="text"/></td>
			<td>对象名称</td>
			<td><input id="_object_name" type="text"/></td>
		</tr>
	</table>
	</div>
	<!-- *********************业务模块******************************** -->

	<!-- *********************业务模块******************************** -->
	<div id="table"></div>
	<div id="temp"></div>
	<div id="boxDetial"></div>
	<div id="tt"></div>
	<form id="test"></form>
	<div class="l-clear"></div>
	<div id="maingrid"></div>
	<div></div>
	<!-- *********************业务模块******************************** -->



</body>

</html>