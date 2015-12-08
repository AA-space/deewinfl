/**
* jQuery ligerUI 1.1.9
* 
* http://ligerui.com
*  
* Author daomi 2012 [ gd_star@163.com ] 
* 
*/
(function ($)
{
    $.fn.ligerForm = function ()
    {
        return $.ligerui.run.call(this, "ligerForm", arguments);
    };

    $.ligerDefaults = $.ligerDefaults || {};
    $.ligerDefaults.Form = {
        //控件宽度
        inputWidth: 180,
        //标签宽度
        labelWidth: 120,
        //间隔宽度
        space: 40,
        //控件占td数量
        colspan : 1,
        //rowspan : 1,
        rightToken: '：',
        //标签对齐方式
        labelAlign: 'right',
        
        //控件对齐方式
        align: 'left',
        //字段
        fields: [],
        //创建的表单元素是否附加ID
        appendID: true,
        //生成表单元素ID的前缀
        prefixID: "",
        //json解析函数
        toJSON: $.ligerui.toJSON
    };

    $.ligerDefaults.Form_fields = {
        name: null,             //字段name
        type: null,             //表单类型
        editor: null,           //编辑器扩展类型
        label: null,            //Label
        newline: true,          //换行显示
        op: null,               //操作符 附加到input
        vt: null,               //值类型 附加到input
        attr: null             //属性列表 附加到input
    };

    $.ligerDefaults.Form_editor = {
        textFieldName: null    //文本框name 
    };

    //建立字段的数据展现方式
    $.ligerDefaults.Form.ElementDataBuilder = function(g,column){
    	return {};
    };
//@description 默认表单编辑器构造器扩展(如果创建的表单效果不满意 建议重载)
    //@param {jinput} 表单元素jQuery对象 比如input、select、textarea 
    $.ligerDefaults.Form.editorBulider = function (jinput)
    {
        //这里this就是form的ligerui对象
        var g = this, p = this.options;
        var options = {}, field = null, target = {};
		var column = g._field[jinput.attr('name')];
		
        var fieldIndex = jinput.attr("fieldindex"), ltype = jinput.attr("ltype");
        if (fieldIndex != null)
        {
            field = g.getField(fieldIndex); 
            if (field && g.editors && g.editors[field.type])
            { 
                g.editors[field.type].call(g, jinput, field);
                return;
            }
        }
        field = field || {};
        if (p.readonly) options.readonly = true;
        //ElementDataBuilder扩展
        $.extend(options, $.ligerDefaults.Form.ElementDataBuilder(g,column));
        options = $.extend({
            width: (field.width || p.inputWidth) - 2
        }, field.options, field.editor, options);
        if (ltype == "autocomplete")
            options.autocomplete = true;
        if (jinput.is("select"))
        {
            target = jinput.ligerComboBox(options);
        }
        else if (jinput.is(":password"))
        {
            target = jinput.ligerTextBox(options);
        }
        else if (jinput.is(":text"))
        { 
            switch (ltype)
            {
                case "select":
                case "combobox":
                case "autocomplete": 
                    target = jinput.ligerComboBox(options);
                    break;
                case "spinner":
                    target = jinput.ligerSpinner(options);
                    break;
                case "date":
                    target = jinput.ligerDateEditor(options);
                    break;
                case "popup":
                    target = jinput.ligerPopupEdit(options);
                    break;
                case "currency":
                    options.currency = true;
                case "float":
                case "number":
                    options.number = true;
                    target = jinput.ligerTextBox(options);
                    break;
                case "int":
                case "digits":
                    options.digits = true;
                default:
                    target = jinput.ligerTextBox(options);
                    break;
            }
        }
        else if (jinput.is(":hidden"))
        { 
          target = jinput;
        }
        else if (jinput.is(":radio"))
        {
            target = jinput.ligerRadio(options);
        }
        else if (jinput.is(":checkbox"))
        {
            target = jinput.ligerCheckBox(options);
        }
        else if (jinput.is(":button"))
        {
            target = jinput.ligerButton(options);
        }
        else if (jinput.is("textarea"))
        {
            target = jinput.addClass("l-textarea");
        }
		return target;
    }

    //表单组件
    $.ligerui.controls.Form = function (element, options)
    {
        $.ligerui.controls.Form.base.constructor.call(this, element, options);
    };

    $.ligerui.controls.Form.ligerExtend($.ligerui.core.UIComponent, {
        __getType: function ()
        {
            return 'Form';
        },
        __idPrev: function ()
        {
            return 'Form';
        },
        _init: function ()
        {
            $.ligerui.controls.Form.base._init.call(this);
        },
        _clearForm : function(){
        	var g = this, p = this.option;
        	var jform = $(this.element);
        	jform.html("");
        },
        
              getField: function (index)
        {
            var g = this, p = this.options;
            if (!p.fields) return null;
            return p.fields[index];
        },
        toConditions: function ()
        {
            return $.ligerui.getConditions(this.element);
        },
        //预处理字段 , 排序和分组
        _preSetFields: function (fields)
        {
            var g = this, p = this.options, lastVisitedGroup = null, lastVisitedGroupIcon = null;
            //分组： 先填充没有设置分组的字段，然后按照分组排序
            $(p.fields).each(function (i, field)
            {
                if (field.type == "hidden") return;
                if (field.newline == null) field.newline = true;
                if (lastVisitedGroup && !field.group)
                {
                    field.group = lastVisitedGroup;
                    field.groupicon = lastVisitedGroupIcon;
                }
                if (field.group)
                {
                    //trim
                    field.group = field.group.toString().replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
                    lastVisitedGroup = field.group;
                    lastVisitedGroupIcon = field.groupicon;
                }
            }); 
           
        },
        _setFields: function (fields)
        {
            var g = this, p = this.options;
            var jform = $(this.element);
            $(".l-form-container", jform).remove();
            //自动创建表单
            if (fields && fields.length)
            {
                g._preSetFields(fields);
                if (!jform.hasClass("l-form"))
                    jform.addClass("l-form");
                var out = ['<div class="l-form-container">'];
                var appendULStartTag = false, lastVisitedGroup = null;
                var groups = [];
                $(fields).each(function (index, field)
                {
                    if ($.inArray(field.group, groups) == -1)
                        groups.push(field.group);
                }); 
                $(groups).each(function (groupIndex, group)
                {
                    $(fields).each(function (i, field)
                    {
                        if (field.group != group) return;
                        var index = $.inArray(field, fields);
                        var name = field.name || field.id, newline = field.newline;
                        if (!name) return;
                        if (field.type == "hidden")
                        {
                            out.push('<input type="hidden" id="' + name + '" name="' + name + '" />');
                            return;
                        }
                        var toAppendGroupRow = field.group && field.group != lastVisitedGroup;
                        if (index == 0 || toAppendGroupRow) newline = true;
                        if (newline)
                        {
                            if (appendULStartTag)
                            {
                                out.push('</tr>');
                                appendULStartTag = false;
                            }
                            if (toAppendGroupRow)
                            {
                                out.push('<div class="l-group');
                                if (field.groupicon)
                                    out.push(' l-group-hasicon');
                                out.push('">');
                                if (field.groupicon)
                                    out.push('<img src="' + field.groupicon + '" />');
                                out.push('<span>' + field.group + '</span></div>');
                                lastVisitedGroup = field.group;
                            }
                            out.push('<tr>');
                            appendULStartTag = true;
                        }
                        out.push('<td class="l-fieldcontainer');
                        if (newline)
                        {
                            out.push(' l-fieldcontainer-first');
                        }
                        out.push('"');
                        out.push(' fieldindex=' + index);
                        out.push('><tr>');
                        //append label
                        out.push(g._buliderLabelContainer(field, index));
                        //append input 
                        out.push(g._buliderControlContainer(field, index));
                        //append space
                        out.push(g._buliderSpaceContainer(field, index));
                        out.push('</tr></li>');

                    });
                }); 
                if (appendULStartTag)
                {
                    out.push('</ul>');
                    appendULStartTag = false;
                }
                out.push('</div>');
                jform.append(out.join(''));

                $(".l-group .togglebtn", jform).remove(); 
                $(".l-group", jform).width(jform.width() * 0.95).append("<div class='togglebtn'></div>");
            }
            //生成ligerui表单样式
            $(".l-form-container", jform).find("input,select,textarea").each(function ()
            {
                p.editorBulider.call(g, $(this));
            });
            g.trigger('afterSetFields');
        },
        _render: function ()
        {
            var g = this, p = this.options;
            g._field = {};
            g.targets = {}; 
            g.tips = [];
            var jform = $(this.element);
            //自动创建表单
            if (p.fields && p.fields.length){
            	p.fieldsTem = [];
            	p.fieldsTem = p.fields.slice(0);
            	p.groups = [];
            	if (!jform.hasClass("l-form"))
                    jform.addClass("l-form");
            	var out = g._builderData(p.fields);
            	jform.append(out.join(''));
            }
            //生成ligerui表单样式
            $("input,select,textarea", jform).each(function ()
            {
                var target = p.editorBulider.call(g, $(this));
                var targetID = target['id'] || target.attr('id');
                g.targets[targetID] = target;
            });
            //显示提示
            if(g.tips.length > 0){
               for(var m = 0; m < g.tips.length; m ++){
                   console.info(g.tips[m]);
                   var id = g.tips[m].id;
                   var tip = g.tips[m].tip;
                   console.info(id);
                   console.info($('#' + id));
                   $('#' + g.tips[m].id).poshytip(g.tips[m].tip);
               } 
            }
        },
        _builderData : function(fields,_group_flag){
            var g = this, p = this.options;
            var out = [];
            var _fields = fields.slice(0);
            p.prefixID = p.prefixID == '' ? this.id + "_" : p.prefixID;
            //自动创建表单
			out.push('<table class="l-table-edit" cellspacing="0" cellpadding="0">');
			var appendULStartTag = false;
			for(var i = 0; i < _fields.length; i++){
				var field = _fields[i];
				var name = field.name || field.id;
				g.fieldTree = {}; 
				g.fieldTree[name] = field;
				if (!name)
					return;
				g._field[name] = field;
				if (field.type == "hidden") {
					out.push('<input type="hidden" id="' +p.prefixID + name + '" name="' + name);
					if(typeof field.value == 'string' || typeof field.value == 'number' || typeof field.value == 'boolean'){
						out.push('" value='+field.value+' />');
					} else{
						out.push('"/>');
					}
					p.fieldsTem.shift();
					continue;
				}
				
				var _inGroup = (p.groups.join(",") + ',').indexOf(field.group) == -1 ? false : true;
				if (field.group && field.group != '' && !_inGroup) {
					if(i == 0){
						var _group = '<div class="l-group';
						if (field.groupicon)
							_group += ' l-group-hasicon';
						_group += '">';
						if (field.groupicon)
							_group += '<img src="' + field.groupicon + '" />';
						_group += '<span>' + field.group + '</span></div>';
						out.unshift(_group);
					} else{
						if (appendULStartTag) {
							out.push('</tr>');
							appendULStartTag = false;
						}
						out.push("</table>");
						
						out.push(g._builderData(p.fieldsTem).join(''));
						return out;
					}
					p.groups.push(field.group);
				}
				
		
				var newLine = field.renderToNewLine || field.newline;
				if (newLine == null)
					newLine = true;
				if (field.merge)
					newLine = false;

				if (newLine) {
					if (appendULStartTag) {
						out.push('</tr>');
						appendULStartTag = false;
					}
					
					out.push('<tr>');
					appendULStartTag = true;
				}
				// append label
				out.push(g._buliderLabelContainer(field));
				// append input
				out.push(g._buliderControlContainer(field));
				// append space
				out.push(g._buliderSpaceContainer(field));
				p.fieldsTem.shift();
			}
			if (appendULStartTag) {
				out.push('</tr>');
				appendULStartTag = false;
			}
			out.push("</table>");
			return out;
        },
        // 标签部分
        _buliderLabelContainer: function (field, fieldIndex)
        {
            var g = this, p = this.options;
            var label = field.label || field.display;
            var labelWidth = field.labelWidth || field.labelwidth || p.labelWidth;
            var labelAlign = field.labelAlign || p.labelAlign;
            // var rowspan = field.rowspan || p.rowspan;
            if (label) label += p.rightToken;
            if(field.type == 'button'){
                return;
            }
            var out = [];
            out.push('<td class="l-table-edit-td l-table-edit-td-label" style="');
            if (labelWidth)
            {
                out.push('width:' + labelWidth + 'px;');
            }
            if (labelAlign)
            {
                out.push('text-align:' + labelAlign + ';');
            }
            out.push('">');
            if (label)
            {
                out.push(label);
            }
            out.push('</td>');
            return out.join('');
        },
        //控件部分
        _buliderControlContainer: function (field, fieldIndex)
        {
            var g = this, p = this.options;
            var width = field.width || p.inputWidth;
            var align = field.align || field.textAlign || field.textalign || p.align;
            var colspan = field.colspan || p.colspan;
            var out = [];
			out.push('<td class="l-table-edit-td l-table-edit-td-content" style="');
            if (width)
            {
                out.push('width:' + width + 'px;');
            }
            if (align)
            {
                out.push('text-align:' + align + ';');
            }
            if(colspan > 1){
            	colspan = (colspan -1) * 3 + 1;
            	out.push('" colspan="' + colspan);
            } 
            out.push('">');
            out.push(g._buliderControl(field,fieldIndex));
            out.push('</td>');
            return out.join('');
        },
        //间隔部分
        _buliderSpaceContainer: function (field)
        {
            var g = this, p = this.options;
            var spaceWidth = field.space || field.spaceWidth || p.space;
            var out = [];
            out.push('<td class="l-table-edit-td l-table-edit-td-space" style="');
            if (spaceWidth)
            {
                out.push('width:' + spaceWidth + 'px;');
            }
            out.push('">');
            out.push('</td>');
            return out.join('');
        },
        _buliderControl: function (field, fieldIndex)
        {
            var g = this, p = this.options;
            var width = field.width || p.inputWidth;
            var name = field.name || field.id;
            type = (field.type || "text").toLowerCase(),
            readonly = (field.readonly || (field.editor && field.editor.readonly)) ? true : false;
            var out = [];
            if (field.comboboxName && field.type == "select")
             {
				out.push('<input type="hidden" id="' + p.prefixID + name + '" name="' + name);
				if (typeof field.value == 'string' || typeof field.value == 'number' ||typeof field.value == 'boolean') {
					out.push(' " value="' + field.value + '" />');
				} else {
					out.push('"/>');
				}
			}
            if (field.textarea || field.type == "textarea")
            {
                out.push('<textarea ');
            }
            else if (field.type == "checkbox")
            {
                out.push('<input type="checkbox" ');
            }
            else if (field.type == "radio")
            {
                out.push('<input type="radio" ');
            }
            else if (field.type == "password")
            {
                out.push('<input type="password" ');
            }
            else if (field.type == "button")
            {
                out.push('<input type="button" value="'+ field.display +'"');
               
            }
            else
            {
                out.push('<input type="text" ');
            }
            if (field.cssClass)
            {
                out.push('class="' + field.cssClass + '" ');
            }
            if (field.type)
            {
                out.push('ltype="' + field.type + '" ');
            }
            if(field.tip){
                var id_ = p.prefixID  + name;
                tipObject = {};
                tipObject.id = id_;
                tipObject.tip = field.tip;
                g.tips.push(tipObject);
            }
/*
        	if(field.datasource == 'cascadeSelect'){
        		var paramJson = $.evalJSON(field.datasourcevalue);
				var selectType = paramJson.cascadeSelectType;
				var dataSource = paramJson.cascadeSelectDataSource;
				var selectid = paramJson.cascadeSelectid;
				var startValue = paramJson.cascadeSelectStartValue;
				var selectPid = paramJson.cascadeSelectPid;
				var cascade = selectType + '|' + selectid;
        		
        		out.push('cascadeSelect="'+cascade+'" ');
        	}*/

            if (field.attr)
            {
                for (var attrp in field.attr)
                {
                    out.push(attrp + '="' + field.attr[attrp] + '" ');
                }
            }
            
            if (field.comboboxName && field.type == "select")
            {
                out.push('name="' + field.comboboxName + '"');
                if (p.appendID)
                {
                    out.push(' id="' + p.prefixID + field.comboboxName + '" ');
                }
            }
            else
            {
                out.push('name="' + name + '"');
                if (p.appendID)
                {
                    out.push(' id="' +  p.prefixID  + name + '" ');
                }
            }
            //参数
            var fieldOptions = $.extend({
                width: width - 2
            }, field.options || {});
            out.push(" ligerui='" + p.toJSON(fieldOptions) + "' ");
            //验证参数
            if (field.validator && field.validator != "")
            {
                out.push(field.validator);
            }
            if (typeof field.value == 'string' || typeof field.value == 'number' ||typeof field.value == 'boolean') {
				out.push(' " value="' + field.value + '" />');
			}
            out.push(' />');
            return out.join('');
        },
        destroy : function(){
        	 var g = this, p = this.options;
              this.options = null;
              this._clearForm();
              for(var key in g.targets){
            	  $.ligerui.remove(key);
              }
              $.ligerui.remove(this);
        },
        submit : function(){
			//??        	 
        },
        
        //获取name对应的标签名称
        getLabel : function(name){
            var g = this, p = this.options;
            var label = null;
            for(var i = 0; i < p.fields.length; i++){
                if(p.fields[i].name == name){
                    label = p.fields[i].display;
                    break;
                }
            }
            return label;
        },
    //将data进行对象化，如果是a.b形式，提取所有a，b作为对象的一个属性如 c.id : 1, c.name : 2 -> c:{id :1, name:2};
		valueToJson : function(data){
			var _tem = {}
			for(var key in data){
				var pointIndex = key.indexOf(".");
				if(pointIndex != -1){
					var _temHead = key.substring(0, pointIndex);
					var _temBody = key.substring(pointIndex + 1, key.length);
					var _temValue = {};
					var _temData = {}
					_temValue[_temBody] = data[key];
					_temData[_temHead] = _temValue;
					_tem = $.extend(true, _tem, _temData);
				}
			}
			return $.extend(true,{}, data, _tem);
		},
        //保存值
        setValues : function(values){
        	var g = this, p = this.options;
        	g.valueToJson(values);
        	for(var key in values){
        		var a = key;
        		var targetName = this.id + '_' + key;
        		var target = this.targets[targetName];
        		if(target){
    				if(target.jquery ){//处理hidden
        				target.val(values[key]);
        			} else{
                         targetType = target.__getType();
        			     if(targetType == 'ComboBox'){
                            target.selectValue(values[key]); 
                         } 
	        			target.setValue(values[key]);
        			}
        		}
        		
        		
        	}
        	
        },
        //获取form表单的值
        getValues : function(names){
        	var g = this, p = this.options;
        	var _values = {};
        	if(typeof names == 'string'){//获取某一个name字段的值
        		var inputTarget = this.targets[this.id + '_'+ names];
        		if(inputTarget.jquery){
        			_values[names] = inputTarget.val();
        		}else if(inputTarget){
        			_values[names] = inputTarget.getValue();
        		}
        	} else if($.isArray(names)){//获取某些字段的值
        		for(var i=0;i<names.length;i++){
        			var inputTarget = this.targets[this.id + '_'+ names[i]];
        			if(inputTarget.jquery){
        				_values[names[i]] = inputTarget.val();
        			}else if(inputTarget){
        				_values[names[i]] = inputTarget.getValue();
        			}
        		}
        		
        	} else if(!names){//未填写name
        		for(var key in this.targets){
					if(key && key != 'undefined'){
        				var name = key.substr(this.id.length+1);
	        			var inputTarget = this.targets[key];
	        			var value;
	        			if(inputTarget.jquery ){//处理hidden
	        				value = inputTarget.val();
	        			} else{
	        				value = inputTarget.getValue() 
	        			}
	        			
	        			if(value!=""){
	        				_values[name] = value;
	        			}
        			}
        		}
        	}else{
        		//不支持的类型
        	}
        	return _values;
        },
        clearData : function(){
            var g = this, p = this.options;
            for(var key in this.targets){
                if(key && key != 'undefined'){
                    var name = key.substr(this.id.length+1);
                    var inputTarget = this.targets[key];
                    var value;
                    if(inputTarget.jquery ){//处理hidden
                        value = inputTarget.val('');
                    } else{
                        value = inputTarget.setValue('') 
                    }
                }
            }
        },
        setDisabled : function(names){
        	var g = this, p = this.options;
        	if(typeof names == 'string'){//获取某一个name字段的值
        		var inputTarget = this.targets[this.id + '_'+ names];
        		if(inputTarget.jquery){
        			inputTarget.setDisabled();
        		}
        	} else if($.isArray(names)){//获取某些字段的值
        		for(var i=0;i<names.length;i++){
        			var inputTarget = this.targets[this.id + '_'+ names[i]];
        			if(inputTarget.jquery){
        				inputTarget.setDisabled();
        			}
        		}
        		
        	} else if(!names){
        		for(var key in this.targets){
					if(key && key != 'undefined'){
        				var name = key.substr(this.id.length+1);
	        			var inputTarget = this.targets[key];
	        			if(!inputTarget.jquery ){//处理hidden
	        				inputTarget.setDisabled();
	        			}
        			}
        		}
        	}else{
        		//不支持的类型
        	}
        },
        setEnabled : function(names){
        	var g = this, p = this.options;
        	if(typeof names == 'string'){//获取某一个name字段的值
        		var inputTarget = this.targets[this.id + '_'+ names];
        		if(!inputTarget.jquery){
        			inputTarget.setEnabled();
        		}
        	} else if($.isArray(names)){//获取某些字段的值
        		for(var i=0;i<names.length;i++){
        			var inputTarget = this.targets[this.id + '_'+ names[i]];
        			if(!inputTarget.jquery){
        				inputTarget.setEnabled();
        			}
        		}
        		
        	} else if(!names){
        		for(var key in this.targets){
					if(key && key != 'undefined'){
        				var name = key.substr(this.id.length+1);
	        			var inputTarget = this.targets[key];
	        			if(!inputTarget.jquery){
	        				inputTarget.setEnabled();
	        			}
        			}
        		}
        	}else{
        		//不支持的类型
        	}
        }
        
    });
})(jQuery);