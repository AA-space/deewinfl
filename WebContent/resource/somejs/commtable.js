Jason = {};
Jason.commTable = function(config) {
	this.COMM_TABLE_URL_ACTION = config.COMM_TABLE_URL_ACTION || 'commController.action';
	this.COMM_TABLE_URL = config.COMM_TABLE_URL || 'commController/comm.action';
	this.PACKAGE_NAME = config.PACKAGE_NAME || 'com.business.entity.';
	this.XMLName = config.XMLName || '';
	this.XMLType = config.XMLType || 'findPageList';
	this.tableType = config.tableType || [ 'findPageList' ];
	this.renderId = config.renderId;
	this.toolBar = config.toolBar || true;
	this.setMethod = config.setMethod || null;
	// 初始化
	(function(config) {
		if (config.renderId) {// 根据给定id生成内容通用内容
			var gId = config.GID();
			$('#' + config.renderId).append(
					'<div class="accordion" id="' + gId + 'accordion" style="display: none;">' + '<div id="' + gId + 'accordion-group" class="accordion-group">' + '<div id="' + gId
							+ 'accordion-heading" class="accordion-heading">' + '<button id="' + gId + 'toolBarAdd" class="btn btn-info" style="display: none;">添加</button>' + '<button id="' + gId
							+ 'toolBarDel" class="btn btn-danger" data-toggle="collapse" data-parent="#accordion" data-target="#collapseOne" style="display: none;">删除</button>' + '<button id="' + gId
							+ 'toolBarModifile" class="btn btn-danger" style="display: none;">修改</button>' + '<button id="' + gId
							+ 'toolBarQuery" class="btn btn-info" data-toggle="collapse" data-parent="#accordion" style="display: none;">查询选项</button>' + '</div>' + '<div id="' + gId
							+ 'collapseOne" class="accordion-body collapse">' + '<div class="accordion-inner"></div>' + '</div>' + '	</div>' + '</div>');
			$('#' + config.renderId).append(
					'<table id="' + gId + 'commTablePageList"></table>' + '<div id="' + gId + 'comm"></div>' + '<div id="' + gId + 'commAdd"></div>' + '<div id="' + gId + 'findById"></div>'
					// model
					+ '<div id="' + gId + 'commModel" style="display: none;">' + '<div id="' + gId + 'modal-body" class="modal-body"></div>' + '<div class="modal-footer">'
							+ '<button class="btn" data-dismiss="modal" aria-hidden="true" onclick="removecommModel(\'' + gId + '\');">关闭</button>' + '<button id="' + gId
							+ 'btn-primary-save" class="btn btn-primary" onclick="setInputValue();">保存</button>' + '</div></div>');

			$('#' + config.renderId).append(
					'<div id="' + gId + 'commTablebable" class="tabbable" style="display:none;">' + '<ul id="' + gId + 'commNav-tabs" class="nav nav-tabs"></ul>' + '<div id="' + gId
							+ 'commTab-content" class="tab-content"  style=""></div>' + '<hr></div>');

		} else {
			alert('请选择渲染ID');
		}

		var types = config.XMLType.toString();
		if (config.toolBar)
			config.showToolBar();
		$.getJSON(config.COMM_TABLE_URL + '?xml=' + config.XMLName + '&type=' + config.XMLType + '&r=' + Math.random(), function(r) {
			if (r.findPageList)
				config.addPageList(r.findPageList);
			if (r.fuzzy)
				config.addFuzzy(r.fuzzy);
			if (r.add)
				config.addAdd(r.add);
			if (r.modify)
				config.addModify(r.modify);
		});
	})(this);
};
Jason.commTable.comm_value = {};
Jason.commTable.prototype = {
	GID : function() {// 生成全局的ID
		return this.XMLName.split('.')[0] + '_';
	},
	createID : function(id) {// 根据表名生成各种id
		var tableName = this.getSimpleId(id);
		// 0为comm
		return {
			TID : tableName
		// tableID
		};
	},
	addPageList : function(f) {
		var xmlType = '&xml=' + this.XMLName + '&modelType=' + f.modelType;
		var objectType = '&objectType=' + f.id;
		this.commTableHead(objectType, xmlType, function(r, t) {// 获得通用列表
			t.commTablePageList(objectType, xmlType, t.convertTableListHead(r), t.GID());
		});

		for ( var i = 0 in this.XMLType) {
			this.XMLType[i] === 'del' && this.addDel(objectType);
		}
	},
	addFuzzy : function(fz) {
		var gid = this.GID();
		var XMLType = '&xml=' + this.XMLName + '&modelType=' + fz.modelType;
		var tableID = gid + this.createID(fz.id).TID + '_fz';
		var objectType = '&objectType=' + fz.id;
		var toolBarID = gid + 'toolBarQuery';
		var accordID = tableID + '_ac';
		var accordInnerID = tableID + '_in';
		$('#' + toolBarID).show();

		this.addToolBarAccordionMethod(toolBarID, accordID);

		this.commTableHead(objectType, XMLType, function(r, t) {
			t.addAccordionContent(r, tableID, accordID, accordInnerID);
			t.addFuzzyToolBar(accordInnerID, tableID, gid);
		});

	},
	addAdd : function(f) {
		var gid = this.GID();
		var XMLType = '&xml=' + this.XMLName + '&modelType=' + f.modelType;
		var tableID = gid + this.getSimpleId(f.id) + '_ad';
		var objectType = '&objectType=' + f.id;
		var objectID = tableID + '_id';
		var objectTitle = f.name;
		var typeModel = f.typeModel;
		var groupStyle = f.groupStyle;
		var toolBarID = gid + 'toolBarAdd';

		var flag = window.flag;
		var setMethod = null;
		if (this.setMethod) {
			var set = [];
			for ( var key in this.setMethod) {
				if (this.setMethod[key])
					set.push(key + ':' + this.setMethod[key]);
			}
			setMethod = set.toString();
		}

		if (flag == gid + '_addFlag') {
			this.commTableHead(objectType, XMLType, function(r, t) {
				t.commTable(r, tableID, gid + 'commAdd', groupStyle, window.setColumn, false);
				t.addSaveAndCloseButton(tableID, objectType, objectID);
			});
		} else {
			$('#' + toolBarID).show();
			// var openTypeStr = 'openNewWindow';
			this.openType(typeModel, objectType, XMLType, tableID, objectID, objectTitle, groupStyle, setMethod, 'add');
		}
	},
	addDel : function(objectType) {
		var toolBarID = this.GID() + 'toolBarDel';
		$('#' + toolBarID).show();
		$('#' + toolBarID).attr('onclick', 'delButton(\'' + this.GID() + '\, ' + this.COMM_TABLE_URL_ACTION + '\', ' + objectType + '\')');
	},
	addModify : function(f) {
		var gid = this.GID();
		var XMLType = '&xml=' + this.XMLName + '&modelType=' + f.modelType;
		var tableID = gid + this.getSimpleId(f.id) + '_ad';
		var objectType = '&objectType=' + f.id;
		var objectID = tableID + '_id';
		var objectTitle = f.name;
		var typeModel = f.typeModel;
		var groupStyle = f.groupStyle;
		var toolBarID = gid + 'toolBarModifile';

		var flag = window.flag;
		var setMethod = null;
		if (this.setMethod) {
			var set = [];
			for ( var key in this.setMethod) {
				if (this.setMethod[key])
					set.push(key + ':' + this.setMethod[key]);
			}
			setMethod = set.toString();
		}

		if (flag == gid + '_modifyFlag') {
			this.commTableValue(objectType, modifyid, function(v, t) {
				t.commTableHead(objectType, XMLType, function(r, t) {
					for ( var key in r) {
						// selfTree特殊处理
						var tempObj = deepCopy(v.obj);
						var keyValues = r[key].field.split('.');

						if (r[key].type === 'selfTree') {
							var parentColumn = paseTypeStringToJson(r[key].attribute).parentColumn;
							var index = paseTypeStringToJson(r[key].attribute).index;

							tempObj[keyValues[keyValues.length - 2]] = t.getSelfTreeeValue(index, v.obj[keyValues[keyValues.length - 2]], parentColumn);
						}
						var objectValue = t.getObjectValue(tempObj, keyValues);
						r[key].value = objectValue;
					}
					t.commTable(r, tableID, gid + 'commAdd', groupStyle, window.setColumn, true);
					t.addModifyButton(tableID, objectType, objectID);
				});

			});
		} else {
			$('#' + toolBarID).show();
			// var openTypeStr = 'openNewWindow';
			this.openType(typeModel, objectType, XMLType, tableID, objectID, objectTitle, groupStyle, setMethod, 'modify');
		}

		// this.addAdd(f);
	},

	getSelfTreeeValue : function(index, selfTreeValue, parentName) {
		return selfTreeValue == null ? null : this.converSelfTreeValueToArray(selfTreeValue, parentName)[index];
	},

	converSelfTreeValueToArray : function(selfTreeValue, parentName) {
		var selfTreeArray = [ selfTreeValue ];
		return this.selfTreeRecursion(selfTreeValue, parentName, selfTreeArray);
	},

	selfTreeRecursion : function(selfTreeValue, parentName, selfTreeArray) {
		if (selfTreeValue[parentName] != null) {
			selfTreeArray.push(selfTreeValue[parentName]);
			return this.selfTreeRecursion(selfTreeValue[parentName], parentName, selfTreeArray);
		} else if (selfTreeValue[parentName] == null) {
			return selfTreeArray.reverse();
		}
	},

	addModifyButton : function(tableID, objectType, objectID) {

		$('#' + tableID).before(
				'<div id=' + tableID + '_buttonGroupModify class="btn-group">' + '<div style="text-align: right; margin: 0px 10px;">' + '<button id="' + tableID
						+ 'SaveButton" class="btn" onclick="modifyData( \'' + tableID + '\');">修改</button>' + '<button class="btn btn-primary" onclick="closeOpenWindow();">关闭</button>'
						+ '</div></div>');

		this.addSaveAndCloseButton(tableID, objectType, objectID);
		$('#' + tableID + '_buttonGroupSave').hide();
	},

	getObjectValue : function(obj, keyValues) {
		var temp = obj[keyValues[0]];
		if (temp == null) {
			return null;
		} else if (typeof temp === 'object') {
			keyValues.shift();
			return this.getObjectValue(temp, keyValues);
		} else {
			return temp;
		}
	},

	commTable : function(table, tableId, renderId, groupStyle, setColumn, modify) {// 增加通用单数据表

		$('#' + renderId).append('<form id="' + tableId + '">');
		$('#' + tableId).append('<div id="' + tableId + 'commrow"  class="fillTableContainer"></div');
		$('#' + tableId + 'commrow').append('<table id=' + tableId + '_table  class="fillTable" cellspacing="0" cellpadding="0">');
		var trNum = 0;
		for ( var v in table) {
			if (table[v].type !== 'hidden') {
				if (trNum % 3 == 0) {
					var tr = null;
					trNum % 2 == 0 ? tr = '<tr class="tr-project-info tr-even">' : tr = '<tr class="tr-project-info tr-odd">';
					$('#' + tableId + '_table').append(tr);
				}
				trNum++;
			}
			;
			this.addTable(tableId, table[v], groupStyle, modify);
		}

		if (setColumn) {
			var columnJson = {};
			var setColumns = setColumn.split(",");
			for ( var i = 0; i < setColumns.length; i++) {
				var setValue = setColumns[i].split(":");
				columnJson[setValue[0]] = setValue[1];
			}

			var columnInputId = this.getIdWipePoint(tableId + '_' + columnJson.selfColumn + 'id');

			$('#' + columnInputId).attr("value", columnJson.selfColumnValue);
		}
		;

	},

	getValidator : function(XMLValidatorString) {
		var v = [ "", "" ];
		v[0] = XMLValidatorString.replace(/;/g, " ");
		v[1] = /require=\'true\'/i.exec(v[0]) && "<span style='color:red'>*</span>";
		return v;
	},

	addTable : function(tableId, v, groupStyle, modify) {

		var innerInputId = this.getIdWipePoint(tableId + '_' + v.field);
		var validatorValue = [ "", "" ];
		var inputType = null;
		if (v.columnValidation) {
			validatorValue = this.getValidator(v.columnValidation);
		}
		var divLabel = '<td class="td-content-title"><label id="' + innerInputId + 'Label" >' + validatorValue[1] + v.title + '<b>:</b></label></td>';
		if (v.type) {
			this.addTableType(tableId, v, divLabel, validatorValue, modify);
		} else {
			inputType = divLabel + '<td class="td-content"><input id="' + innerInputId + '"  type="text" ' + validatorValue[0] + ' name="' + v.field + '"  /></td>';

			$('#' + tableId + '_table tr:last').append(inputType);

			if (v.attribute) {
				var value = paseTypeStringToJson(v.attribute);
				$('#' + innerInputId).val(value.value);
			}
			;

			modify && this.addModifyType(innerInputId, v.value);
		}
		;
	},

	addModifyType : function(innerInputId, value) {
		var inputType = $('#' + innerInputId);
		inputType.attr('modifyInput', 'true').hide();

		if (value != null && inputType.attr('type') !== 'hidden') {
			inputType.after('<span modifySpan="true">' + value + '</span>');
		}
	},

	addTableType : function(tableId, v, divLabel, validatorValue, modify) {
		var innerInputId = this.getIdWipePoint(tableId + '_' + v.field);
		switch (jQuery.trim(v.type).toLocaleLowerCase()) {

		case 'combox':
			$('#' + tableId + '_table tr:last').append(divLabel);

			/*
			 * var inputType = '<div class="input-append">' + '<input disabled="" class="" id="' + innerInputId +
			 * 'name" type="text" name="' + v.field + '" placeholder="' + v.title + '"/>' + '<input id="' +
			 * innerInputId + '" type="hidden" name="' + v.field + '"/>' + '<button class="btn"
			 * onclick="commTree(\'' + innerInputId + '\',\'' + v.url + '\');" type="button">选框</button> </div>';
			 */
			var inputType = '<td class="td-content"><input id="' + innerInputId + '"  /></td>';
			$('#' + tableId + '_table tr:last').append(inputType);
			/*
			 * $('#' + tableId + '_table tr:last').append(divLabel); $('#' + innerInputId + 'Label').attr('for',
			 * innerInputId+ 'name'); $('#' + innerInputId + 'ControlGruop').append(inputType);
			 */
			break;

		case 'selftree':
			var a = v.field.split(".");
			a.pop();
			a.push('id');
			var idTemp = a.join(".");
			var inputID = this.getIdWipePoint(tableId + '_' + idTemp);
			var columnType = paseTypeStringToJson(v.attribute);
			divLabel = '<td class="td-content-title"><label id="' + innerInputId + '_' + columnType.index + 'Label" >' + validatorValue[1] + v.title + '</label></td>';
			$('#' + tableId + '_table tr:last').append(divLabel);
			v.attribute = v.attribute + ';name=' + v.title;
			// var inputType ='<td class="td-content"><div class="input-append"><input id="' + innerInputId + '"
			// /><button calss="btn">...</button><div></td>';

			var inputType = '<div class="input-append">' + ' <input class="span2" id="' + innerInputId + '_' + columnType.index + '" type="text" name="' + v.field + '"/>'
					+ '<button class="btn" type="button" onclick="selfTree(\'' + this.GID() + '\', \'' + innerInputId + '\',\'' + v.attribute + '\', \'' + this.COMM_TABLE_URL_ACTION + '\', \''
					+ inputID + '\');" >...</button>' + '</div>';

			$('#' + tableId + '_table tr:last').append(inputType);

			if (modify) {
				$('#' + innerInputId + '_' + columnType.index).nextAll([ type = 'button' ]).attr('modifyInput', 'true').hide();
				this.addModifyType(innerInputId + '_' + columnType.index, v.value);
			}

			break;
		case 'compare':
			var inputType = '<div class="inline">' + '<input id="' + innerInputId + 'Start" class="input-small uneditable-input"  type="text" name="' + v.field + '"/> - ' + '<input id="'
					+ innerInputId + 'End" class="input-small uneditable-input" type="text" name="' + v.field + '"/></div>';

			$('#' + tableId + '_table tr:last').append(divLabel);
			$('#' + innerInputId + 'ControlGruop').append(inputType);

			break;

		case 'set':
			$('#' + this.GID() + 'commTablebable').show();
			var setFeildId = tableId + v.field;

			this.addSetNav(v, setFeildId, this.GID() + 'commNav-tabs');
			break;
		case 'hidden':
			var inputType = '<input id="' + innerInputId + '" class="this.columnInputStyel" type="hidden" name="' + v.field + '"  />';
			$('#' + tableId + 'commrow').append(inputType);
			if (v.attribute) {
				var value = paseTypeStringToJson(v.attribute);
				if (value.value || value.value == 0) {
					$('#' + innerInputId).val(value.value);
				}

				if (value.cascade) {
					Jason.commTable.comm_value.cascadeValues = [ {
						cascadeID : innerInputId,
						cascadeName : value.cascade
					} ];
				}
			}
			;

			modify && this.addModifyType(innerInputId, v.value);

			break;

		case 'select':
			$('#' + tableId + '_table tr:last').append(divLabel);
			this.getSelectInputContent(innerInputId, v, v.attribute, tableId);
			modify && this.addModifyType(innerInputId, v.value);

			break;

		case 'datatime':
			var inputType = '<input id="' + innerInputId + '"  type="text" name="' + v.field + '" >' + '<img onclick="WdatePicker({el:' + innerInputId
					+ '})" src="js/my97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">' + '</div>';
			$('#' + tableId + '_table tr:last').append(divLabel);
			$('#' + innerInputId + 'ControlGruop').append(inputType);
			break;

		case 'checkbox':
			$('#' + tableId + '_table tr:last').append(divLabel);
			this.getCheckBoxInputContent(innerInputId, v, v.attribute, tableId);

			break;
		case 'textarea':
			$('#' + tableId + '_table tr:last').append(divLabel);
			var inputType = '<textarea id="' + innerInputId + '" class="this.columnInputStyel" type="text" name="' + v.field + '"  />';
			$('#' + innerInputId + 'ControlGruop').append(inputType);

			break;

		default:
			$('#' + tableId + '_table tr:last').append(divLabel);

			var inputType = '<input id="' + innerInputId + '" class="this.columnInputStyel" type="text" name="' + v.field + '"  />';
			$('#' + innerInputId + 'ControlGruop').append(inputType);
			break;
		}

	},

	modifySelfTree : function(inputID) {

	},

	resolvParameterString : function(parameter) {
		var i = parameter.indexOf(":");
		return [ parameter.substr(0, i), parameter.substr(i + 1) ];
	},

	getCheckBoxInputContent : function(innerInputId, v, selectType, tableId) {
		var typeObject = this.resolvParameterString(selectType);
		switch (typeObject[0].toString().toLowerCase()) {
		case 'objectdata':
			var objectValue = typeObject[1].replace(/\[|\]|'/g, "").split(",");
			var selectValue = "";
			jQuery.each(objectValue, function(i, s) {
				selectValue = '<label class="checkbox""><input id=' + innerInputId + ' type="checkbox" class="this.columnInputStyel"  name="' + v.field + '" value=' + s + '>' + s + '</label>'
						+ selectValue;
			});

			$('#' + tableId + '_table tr:last').append(selectValue);
			break;

		case 'jsdata':
			var callFunction = typeObject[1].replace(/\[|\]/g, "").split(",").toString();
			var returnValue = eval(callFunction);
			('#' + innerInputId + 'ControlGruop').append(returnValue);
			break;

		case 'dictdata':
			var dictPid = typeObject[1];
			var tempInput = '<td class="td-content"><div id=' + innerInputId + '_0></div></td>';
			$('#' + tableId + '_table tr:last').append(tempInput);
			this.getDictData(dictPid, function(r) {
				var selectValue = "";
				jQuery.each(r, function(i, s) {
					i++;
					selectValue = '<input id=' + innerInputId + '_' + i + ' type="checkbox" class=""  name="' + v.field + '" value="' + s.id + '">' + s.name + '</input>' + selectValue;
				});

				var s = $('#' + innerInputId + '_0').append(selectValue);
				// console.info(s);
			});

			break;
		default:
			break;
		}
		;
	},

	getSelectInputContent : function(innerInputId, v, selectType, tableId) {
		var typeObject = this.resolvParameterString(selectType);
		switch (typeObject[0].toString().toLowerCase()) {
		case 'objectdata':
			var objectValue = typeObject[1].replace(/\[|\]|'/g, "").split(",");
			var selectValue = '<select id=' + innerInputId + ' class="this.columnInputStyel"  name="' + v.field + '">';

			jQuery.each(objectValue, function(i, v) {
				selectValue = selectValue + '<option value="' + v + '">' + v + '</option>';
			});
			selectValue = selectValue + '</select>';
			$('#' + tableId + '_table tr:last').append(selectValue);
			break;

		case 'jsdata':
			var callFunction = typeObject[1].replace(/\[|\]/g, "").split(",").toString();
			var returnValue = eval(callFunction);
			$('#' + tableId + '_table tr:last').append(returnValue);
		case 'dictdata':
			var dictPid = typeObject[1];
			var selecter = '<td class="td-content"><select id=' + innerInputId + ' name="' + v.field + '"/></td>';
			$('#' + tableId + '_table tr:last').append(selecter);
			this.getDictData(dictPid, function(r) {
				selectValue = [];
				jQuery.each(r, function(i, s) {
					selectValue.push('<option value="' + s.id + '"><span style:" display:inline;">' + s.name + '</span></option>');
				});
				$('#' + innerInputId).append(selectValue.join(''));
			});

			break;
		default:
			break;
		}
		;
	},

	getDictData : function(columnValue, callback) {
		$.getJSON(this.COMM_TABLE_URL_ACTION + '?findDictValue&columnValue=' + columnValue, function(r) {
			callback(r);
		});
	},

	/**
	 * 去除id中的点
	 * 
	 * @param idStr
	 * @returns
	 */
	getIdWipePoint : function(idStr) {
		return jQuery.trim(idStr.replace(/\./g, ''));
	},

	/**
	 * @param type
	 * @param xmlType
	 * @returns {String}
	 */
	openType : function(type, objectType, xmlType, tableId, objectId, objectTitle, groupStyle, setMethod, method) {
		switch (type) {
		case 'openNewWindow':
			this.addOpenNewWindow(xmlType, setMethod, method);
			break;
		case 'accordion':
			this.addOpenAccordion(objectType, objectId, xmlType, tableId, groupStyle, setMethod);
			break;
		case 'model':
			this.addOpenModel(objectType, objectId, xmlType, tableId, objectTitle, setMethod);
			break;
		default:
			this.addOpenAccordion(xmlType);
		}
	},
	addOpenModel : function(objectType, objectId, xmlType, tableId, objectTitle) {
		this.addToolBarClickAction(this.GID() + 'toolBarAdd', 'openModelAdd(\'' + objectType + '\', \'' + objectId + '\',\'' + xmlType + '\',\'' + tableId + '\',\'' + objectTitle + '\')');
	},

	addOpenNewWindow : function(xmlType, setMethod, method) {
		var m = {
			'add' : 'toolBarAdd',
			'modify' : 'toolBarModifile'
		}[method] || 'toolBarAdd';
		this.addToolBarClickAction(this.GID() + m, 'openWindowAdd(\'' + this.GID() + '\',\'' + xmlType + '\', \'' + this.GID() + '_' + method + 'Flag\', \'' + setMethod + '\', \'' + method + '\')');
	},

	addOpenAccordion : function(objectType, objectId, xmlType, tableId, groupStyle) {
		var accordId = tableId + '_ac';
		var accordInnerId = accordId + '_in';

		addToolBarAccordionMethod('toolBarAdd', accordId);

		commTableHead(objectType, xmlType, function(r) {// 获得通用列表
			addAccordionContent(r, tableId, accordId, accordInnerId, groupStyle);
		});
	},

	/**
	 * 删除渲染的表格
	 * 
	 * @param render
	 *            渲染地址
	 */
	removeCommTable : function(render) {
		$('#' + render).empty();
	},

	/**
	 * @字段类型为tree，添加tree，默认添加隐藏字段treeId,默认添加显示名称treeName treeId 为需要注入值的id treeUrl 为得到tree的Url
	 */
	commTree : function(treeId, treeUrl) {
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
	},

	// 弹框内容选择

	// 删除弹框内容

	// 清除表单内容

	/**
	 * 获取表头
	 * 
	 * @param dataUrl
	 *            表头地址
	 * @param callback
	 *            获取完成回调函数
	 */
	commTableHead : function(objectType, xmlType, callback) {
		var t = this;
		$.getJSON(this.COMM_TABLE_URL_ACTION + '?findFields' + objectType + xmlType, function(r) {
			callback(r, t);
		});
	},

	/**
	 * 查询数据
	 * 
	 * @param dataUrl
	 * @param xmlType
	 * @param callback
	 */
	commTableValue : function(objectType, id, callback) {
		var t = this;
		$.getJSON(this.COMM_TABLE_URL_ACTION + '?findById' + objectType + '&id=' + id, function(r) {
			callback(r, t);
		});
	},

	/**
	 * 给表单添加数据
	 * 
	 * @param r
	 * @param renderId
	 */

	/**
	 * 添加通用列表
	 * 
	 * @param url
	 * @param xmlType
	 * @param columns
	 */
	commTablePageList : function(objectType, xmlType, columns, renderId) {
		var url = this.COMM_TABLE_URL_ACTION + '?findFuzzy' + objectType + xmlType;
		if (this.setMethod) {
			url = this.COMM_TABLE_URL_ACTION + '?findByColumn' + objectType + '&columnName=' + this.setMethod.selfColumn + '&columnValue=' + this.setMethod.selfColumnValue;
		}
		$('#' + renderId + 'commTablePageList').datagrid({
			url : url,
			iconCls : 'icon-edit',
			pagination : true,
			rownumbers : true,
			singleSelect : true,
			idField : 'id',
			striped : 'true',
			border : false,
			columns : columns,

			onBeforeLoad : function() {
				$(this).datagrid('rejectChanges');
			},
			onClickRow : function(rowIndex, rowData) {
				var idValue = Jason.commTable.comm_value[renderId + 'commTablePageList'] = rowData;
				var idIndex = Jason.commTable.comm_value[renderId + 'commTablePageListIndex'] = rowIndex;

			}
		});
	},

	/**
	 * 将通用表头数据转换成列表表头数据
	 * 
	 * @param r
	 * @returns
	 */
	convertTableListHead : function(r) {
		jQuery.each(r, function(i, v) {
			if (v.type == 'hidden') {
				r[i].hidden = true;
			}
		});
		return [ r ];
	},

	/**
	 * 获取后台输入的类型数据，用于获得基本的实体信息
	 * 
	 * @param commData
	 * @param type
	 * @returns {GetCommDataByType}
	 */
	GetCommDataByType : function(commData, type) {
		return {
			tableId : commData[type].id,
			tableName : commData[type].name,
			modelType : commData[type].modelType,
			dataUrl : commData[type].dataUrl,
			typeModel : commData[type].typeModel,
			groupStyle : commData[type].groupStyle
		};
	},
	getSimpleId : function(id) {
		var strs = id.split(".");
		return strs[strs.length - 1];
	},

	/**
	 * 给模糊查询添加确定和清除按钮
	 * 
	 * @param renderId
	 *            渲染地址
	 * @param tableListRenderId
	 *            表单ID
	 */
	addFuzzyToolBar : function(renderId, tableRenderId, tableListRenderId) {

		$('#' + renderId).append(
				'<div style="text-align: right; margin: 0px 10px;">' + '<button id="clean-query"class="btn" style="margin: 0px 10px;" onclick="cleanQuery(\'' + tableRenderId + '\');">清空</button>'
						+ '<button id="submit-query" class="btn btn-primary" style="margin: 0px 10px;" onclick="submitQuery(\'' + tableRenderId + '\', \'' + tableListRenderId + '\');">查询</button>'
						+ '</div>');
	},

	popUpWindow : function(URLStr, width, height) {
		if (width == undefined && height == undefined) {
			event.srcElement.openwin = open(URLStr);
			event.srcElement.openwin.focus();
		} else {
			var left = (screen.width - width) / 2;
			var top = (screen.height - height) / 2;

			event.srcElement.openwin = open(URLStr, "", "width= " + width + ",height=" + height + ",left=" + left + ",top=" + top);
			event.srcElement.openwin.focus();
		}
	},

	/**
	 * 弹出窗口
	 * 
	 * @param url
	 * @param width
	 * @param height
	 */

	/**
	 * 添加功能按钮
	 * 
	 * @param renderId
	 * @param objectType
	 * @param objectId
	 */
	addSaveAndCloseButton : function(tableId, objectType, objectId) {
		$('#' + tableId).before(
				'<div id=' + tableId + '_buttonGroupSave class="btn-group">' + '<div style="text-align: right; margin: 0px 10px;">' + '<button id="' + tableId
						+ 'SaveButton" class="btn" onclick="submitData(\'' + this.COMM_TABLE_URL_ACTION + '?saveOrUpdata' + objectType + '\', \'' + tableId + '\', \'' + objectId
						+ ' \');">保存</button>' + '<button class="btn btn-primary" onclick="submitDataAndCloseWindow(\'' + this.COMM_TABLE_URL_ACTION + '?saveOrUpdata' + objectType + '\', \''
						+ tableId + '\',  \'' + objectId + ' \');">保存并关闭</button>' + '<button class="btn btn-primary" onclick="closeOpenWindow();">关闭</button>' + '</div></div>');

	},

	/**
	 * 添加有一对多的多
	 * 
	 * @param r
	 * @param renderId
	 * @param setId
	 */
	addSetNav : function(r, setFeildId, setId) {
		var idValue = modifyid;
		xmlAndType = r.attribute;
		$('#' + this.GID() + 'commTab-content').append('<div class="tab-pane" id="' + setFeildId + '"></div>');
		$('#' + setId).append(
				'<li><a onclick="switchTable(\'' + setFeildId + '\', \'' + xmlAndType + '\', \'' + idValue + '\');" href="#' + setFeildId + '" data-toggle="tab">' + r.title + '</a></li>');
	},

	addSetHead : function() {
	},
	addSetValue : function() {

	},
	hiddenToolBar : function() {
		$("#accordion").hide();
	},

	addToolBarClickAction : function(renderId, clickFunction) {
		$('#' + renderId).attr("onclick", clickFunction);
	},

	showToolBar : function() {
		$('#' + this.GID() + 'accordion').show();
	},

	addToolBarAccordionMethod : function(toolBarId, renderId) {

		$('#' + toolBarId).attr({
			'data-toggle' : "collapse",
			'data-parent' : "#accordion",
			'data-target' : '#' + renderId
		});
	},

	addAccordionContent : function(r, tableId, accordId, accordInnerId, groupStyle) {
		$('#' + this.GID() + 'accordion-group').append('<div id="' + accordId + '" class="accordion-body collapse"></div>');
		$('#' + accordId).append('<div id="' + accordInnerId + '" class="accordion-inner"></div>');
		this.commTable(r, tableId, accordInnerId, groupStyle, false);
	},

	addValues : function(r, renderId) {
		var input = $('#' + renderId + ' input[name]');
		$.each(input, function(i, v) {
			$('#' + v.id).val(r.obj[v.name]);
		});
	}

};
// config = {XMLName : Custom.xml, XMLType : findPageList, pageType : ['findPageList', 'add', 'findFuzzy', 'delete']};

cleanQuery = function(tableListRenderId) {
	$('#' + tableListRenderId).form('clear');
};
// 将表单内容作为条件查询
submitQuery = function(renderId, tableListRenderId) {
	var queryParams = $.serializeObject($('#' + renderId).form());
	$('#' + tableListRenderId).datagrid("load", queryParams);
};

openWindowAdd = function(gid, xml, flag, setMethod, method) {
	var idValue = Jason.commTable.comm_value[gid + 'commTablePageList'];
	var modifyid = "";
	var m = '&method=' + method;
	if (method === 'modify' && idValue) {
		modifyid = '&modifyid=' + idValue.id;
	} else if (method === 'modify') {
		alert('请选择行');
		return;
	}
	var win = addWin('addTable.jsp?flag=' + flag + xml + setMethod + m + modifyid);
};

addWin = function(url, width, height) {
	var win;
	if (width == undefined && height == undefined) {
		win = window.open(url, '添加' + Math.random(), 'width=' + screen.width + ',height=' + screen.height
				+ ',top=0,left=0,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
	} else {
		var left = (screen.width - width) / 2;
		var top = (screen.height - height) / 2;
		win = window.open(URLStr, "添加", "width= " + width + ",height=" + height + ",left=" + left + ",top=" + top);
	}
	return win;
};

function openModelAdd(objectType, objectId, xmlType, tableId, objectTitle) {

	var t1 = new Jason.commTable({
		XMLName : 'Customer.xml',
		XMLType : 'add',
		renderId : 'modal-body'
	});
	/*
	 * commTableHead(objectType, xmlType, function(r) {// 获得通用列表 commTable(r, tableId, 'modal-body'); });
	 */
	$('#myModalLabel').text(objectTitle);
	$('#commModel').modal({
		backdrop : false,
		keyboard : true,
		show : true
	});
};

function closeOpenWindow() {
	window.close();
};

function deleteOneRow(gid, commURL, objectType) {
	var s = confirm("确定删除吗?");

	if (s) {

		var valueID = Jason.commTable.comm_value[gid + 'commTablePageListIndex'];
		var value = Jason.commTable.comm_value[gid + 'commTablePageList'].id;

		$('#' + gid + 'commTablePageList').datagrid('deleteRow', valueID);

		$.post(COMM_TABLE_URL_ACTION + "?remove&" + objectType, {
			id : value
		});

		delete Jason.commTable.comm_value[gid + 'commTablePageListIndex'];
		delete Jason.commTable.comm_value[gid + 'commTablePageList'];
	} else {
		return;
	}

};

function submitDataAndCloseWindow(url, renderId, objectId) {
	submitData(url, renderId, objectId);
	closeOpenWindow();
};

function submitData(url, renderId, objectId) {
	var fromValidator = Validator.Validate(document.getElementById(renderId), 3, false);
	// if(!fromValidator) return;

	// 执行添加的所有验证
	// var form = $('#' + renderId).form();
	// var queryParams = $.serializeObject($('#' + renderId).form());
	var queryParams = $('#' + renderId).tracywindySerializeFormToJsonObject();
	if (!jQuery.isEmptyObject(queryParams)) {
		var object = url.substr(/objectType/i, url.length).split('.').pop() + '=' + $.toJSON(queryParams);
		var cascadeType = [];
		if (Jason.commTable.comm_value.cascadeValues) {
			for ( var i = 0; i < Jason.commTable.comm_value.cascadeValues.length; i++) {
				cascadeType.push(Jason.commTable.comm_value.cascadeValues[i].cascadeName);
			}
			object = object + "&cascadeType=" + cascadeType;
		}
		jQuery.post(url, object, function(data) {
			if (data.success == true && data.obj) {
				$('#' + objectId).val(data.obj.id);

				if (Jason.commTable.comm_value.cascadeValues) {
					for ( var i = 0; i < Jason.commTable.comm_value.cascadeValues.length; i++) {
						var name = Jason.commTable.comm_value.cascadeValues[i].cascadeName;
						var cascadeID = Jason.commTable.comm_value.cascadeValues[i].cascadeID;
						var cascadeValue = data.obj[name];
						$('#' + cascadeID).val(cascadeValue);

					}
					// 用完清空
					delete Jason.commTable.comm_value.cascadeValues;
				}

				$('#' + renderId + 'SaveButton').removeAttr('disabled');
			}
		}, 'json');
	} else {
		alert('还未填入数据');
		$('#' + renderId + 'SaveButton').removeAttr('disabled');
		return;
	}
	;
};

function switchTable(setFeildId, xmlAndType, idValue) {
	// $('#'+this.GID()+'commTablebable a[href="#' + setFeildId + '"]');
	var content = jQuery('#' + setFeildId + ' > div');
	if (!content[0])
		addSetContent(setFeildId, xmlAndType, idValue);
};

function addSetContent(setFeildId, xmlAndType, idValue) {
	var attr = xmlAndType.split(';');
	var xml, type, relateColumn;
	for ( var s in attr) {
		var v = attr[s].split('=');
		switch (v[0]) {
		case 'xml':
			xml = v[1];
			break;
		case 'type':
			type = v[1];
			break;
		case 'relateColumn':
			relateColumn = v[1];
			break;
		default:
			alert("XML设置值错误");
		}

	}
	var t = new Jason.commTable({
		XMLName : xml,
		XMLType : type,
		renderId : setFeildId,
		setMethod : {
			parentXML : '',
			parentType : '',
			parentColumn : '',
			parentColumnValue : '',
			selfColumn : relateColumn,
			selfColumnValue : idValue
		}
	});

	// var content = createFrame(url);

	$('#' + setFeildId).append(content);
};

paseTypeStringToJson = function(typeString) {
	var jsonObject = {};
	var types = typeString.split(";");
	for ( var i = 0; i < types.length; i++) {
		var value = types[i].split("=");
		jsonObject[value[0]] = value[1];
	}

	return jsonObject;
};

// renderID为弹窗的全局id，treeId为当前选择项的inputid，inputID为隐藏的id项，url为action的通用url地址
selfTree = function(renderID, treeId, typeString, url, inputID) {
	var v = paseTypeStringToJson(typeString);
	var preObject = $('#' + treeId + '_' + (v.index - 1));

	var columnValue = (v.index == 0) ? v.value || 'NULL' : $('#' + inputID).val();
	if (v.index > 0 && (!preObject.val() || preObject.val() === "")) {
		alert('请选择 <' + $('#' + treeId + '_' + (v.index - 1) + 'Label').html() + '>');
		return;
	}
	var objectUrl = url + '?findByColumn&objectType=' + v.objectType + '&columnName=' + v.parentColumn + '&columnValue=' + columnValue;

	$('#' + renderID + 'modal-body').empty();
	$('#' + renderID + 'commModel').show().window({
		width : 600,
		height : 400,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false
	});

	$.getJSON(objectUrl, function(r) {
		var list = [ '<ol>' ];
		for ( var key in r) {
			list.push('<li onclick="selectValue(this,\'' + renderID + '\', \'' + treeId + '_' + v.index + '\', \'' + inputID + '\')"><span style="display: none;">' + r[key].id + '</span><span>'
					+ r[key].name + '</span></li>');
		}
		list.push('</ol>');
		$('#' + renderID + 'modal-body').append(list.join(''));
		$("li").mouseover(function() {
			// $("li").css("background-color","yellow");
		});

	});
};

selectValue = function(obj, renderID, treeID, inputID) {
	var v = jQuery(obj);
	var s = v.siblings();
	s.removeAttr("style");
	v.css({
		"background-color" : "yellow",
		"color" : "red"
	});
	// $('#' + inputID).val(obj.firstChild.innerHTML);

	$('#' + renderID + 'btn-primary-save').attr('onclick',
			'setInputValue(\'' + renderID + '\', \'' + treeID + '\', \'' + inputID + '\', \'' + v.children().last().text() + '\', \'' + v.children().first().text() + '\')');
};
removecommModel = function(id) {
	$('#' + id + 'commModel').window('close');
	$('#' + id + 'modal-body').empty();
	// $('#' + id + 'commModel').empty();
	$('#' + id + 'btn-primary-save').attr('onclick', 'setInputValue()');

};

modifyData = function(tableID) {
	$('#' + tableID + ' input[modifyInput="true"]').show();
	var s = $('#' + tableID + ' span[modifySpan="true"]').remove();

	$('#' + tableID + '_buttonGroupModify').empty();
	$('#' + tableID + '_buttonGroupSave').show();

};

setInputValue = function(renderID, nameID, inputID, name, value) {
	// 类名
	if (nameID && inputID && value) {
		$('#' + inputID).attr('value', value);
		$('#' + nameID).attr('value', name);
		removecommModel(renderID);
	} else {
		alert("请选择内容");
	}
	;
},

findByIdForModify = function(gid, addObjectType, idValue, tableID) {
	// this.commTableValue(objectType, id, function(r) {
	var idValue = Jason.commTable.comm_value[gid + 'commTablePageList'];
	var modify = '&modify=true';
	// this.addValues(idValue, tableID);
	// openWindowAdd(xml, flag, setMethod, modify);
	// });

	/*
	 * commTableValue(objectType, idValue, function(v){ commTable(table, tableId, renderId, groupStyle, setColumn, modify);
	 * 
	 * });
	 */
};
deepCopy = function(obj) {
	var o = obj.constructor === Array ? [] : {};
	for ( var i in obj) {
		if (obj.hasOwnProperty(i)) {
			o[i] = (typeof obj[i] === "object") && obj[i] != null ? deepCopy(obj[i]) : obj[i];
		}
	}
	return o;
};

delButton = function(gid, commURL, objectType) {
	deleteOneRow(gid, commURL, objectType);

};

tableGrid = function(conf) {
	this.url = conf.url;
	this.pagination = conf.pagination || true;
	this.rownumbers = conf.rownumbers || true;
	this.singleSelect = conf.singleSelect || true;
	this.idField = conf.idField || 'id';
	this.striped = conf.striped || true;
	this.border = conf.border || false;

	// this.columns = conf.columns;
	this.renderID = conf.renderID;
};

tableGrid.prototype = {
	paseData : function(callback) {
		var t = this;
		$.getJSON(this.url, function(r) {
			callback(r, t);
		});
	},
	getHead : function() {
		this.paseData(function(r, t) {
			t.createHead(r);
			// t.createBody()
		});

	},

	createHead : function(r) {
		var strBuffer = [];
		for ( var v in r) {
			strBuffer.push('<th>' + r[v].title + '</th>');
		}
		$('#' + this.renderID).append('<table id="tableID" class="table table-striped table-bordered table-condensed">');
		$('#tableID').append('<thead>');
		$('#tableID > thead').append('<tr>');
		$('#tableID > thead > tr').append(strBuffer.join(''));
	},
	createGrid : function(head, data) {

		var strBuffer = [];
		for ( var v in head) {
			strBuffer.push('<th>' + head[v].title + '</th>');
		}
		$('#' + this.renderID).append('<table id="tableID" class="table table-striped table-bordered table-condensed">');
		$('#tableID').append('<thead>');
		$('#tableID > thead').append('<tr>');
		$('#tableID > thead > tr').append(strBuffer.join(''));

		var dataBuffer = [];
		for ( var d in data) {
			dataBuffer.push('th' + data[d]['name']);
		}
		$('#tableID').append('<tbody>');
		$('#tableID > tbody').append('<tr>');
		$('#tableID > thead > tr').append(dataBuffer.join(''));
	}
};


/** *******************对象添加事件****************** */
Grid.innerFn.addEvent = function(obj, type, fun) {
	if (obj.addEventListener) {
		obj.addEventListener(type, fun);
		return true;
	} else if (obj.attachEvent) {
		return obj.attachEvent("on" + type, function() {// 函数的this指向obj
			fun.call(obj);
		});
	} else {
		return false;
	}
	;
};

/** *******************对象删除事件****************** */
Grid.innerFn.delEvent = function(obj, type, fun) {
	if (obj.addEventListener) {
		obj.removeEventListener(type, fun);
		return true;
	} else if (obj.attachEvent) {
		obj.detachEvent("on" + type, fun);
		return true;
	} else {
		return false;
	}
	;
};


/** *******************模拟触发调用****************** */
Grid.innerFn.exeEvent = function(domObj, eventName) {
	if (document.all && typeof (document.all) == "object") {// 判断是否是IE浏览器
		domObj.fireEvent('on' + eventName);
	} else {
		var event = document.createEvent("HTMLEvents");// 或document.createEvent("MouseEvents");
		event.initEvent(eventName, true, true);
		domObj.dispatchEvent(event);
	}
};

/** *******************获取事件对象与事件源****************** */
Grid.innerFn.getEventElement = function(e) {
	var evt = e || window.event;//获取事件对象  
	var src = evt.target || evt.srcElement;//获取事件源对象  
	return src;
};
/*********************停止冒泡事件*******************/
Grid.innerFn.stopBubble = function(e) {
	if (document.attachEvent) {//ie  
		window.event.cancelBubble = true;
	} else {
		e.stopPropagation();
	}
};

/*********************阻止事件的默认行为*******************/
Grid.innerFn.preventDefault = function(e) {
	if (document.attachEvent) {//ie  
		window.event.returnValue = false;
	} else {
		e.preventDefault();
	}
};

