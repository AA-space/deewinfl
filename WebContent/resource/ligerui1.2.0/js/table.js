(function($) {
    $.JasonTable = function(elm, options) {
        this.openWidth = $(window).width(), this.openHeight = $(window).height(), this.$elm = elm;
        this.opts = $.extend({}, $.fn.jasonTable.defaults, options);
        this.grid = null;
        this.form = null;
        this.search_form = null;
        var $jasonTable = this;

        if (this.opts.productData && this.opts.productData != '') {
            this.init();
        } else if (this.opts.jsonType && this.opts.jsonType != '') {
            var param = {
                jsonStringName : this.opts.jsonType
            };
            $.post("commController.action?getJsonString", param, function(data) {
                var column = data.grid;
                var ajaxParam = {};
                ajaxParam.column = [];
                ajaxParam.objectType = data.attribute.objectType;

                for (var key in column) {
                    ajaxParam.column.push(column[key]['name']);
                }
                // JSON.stringify(ajaxParam);
                //var listURL = 'commController.action?findFuzzy';
               // data.attribute.url = url;
                data.attribute.params = ajaxParam;
                $jasonTable.opts.productData = data;
                $jasonTable.opts.ADD_URL =  $jasonTable.opts.ADD_URL ||  data.attribute.addURL;
                $jasonTable.opts.DEL_URL =  $jasonTable.opts.DEL_URL ||  data.attribute.delURL;
                $jasonTable.opts.LIST_URL =  $jasonTable.opts.LIST_URL ||  data.attribute.listURL;
                $jasonTable.opts.objectType =  $jasonTable.opts.objectType ||  data.attribute.objectType;
                
                
                var s = $jasonTable;
                $jasonTable.init();
            }, "json");
        } else {
            alert("请传入jsonData或jsonType!");
            return;
        }
    }
    $.JasonTable.prototype = {
        init : function() {
            if (this.opts.init == 'form') {
                this.createForm(this.opts.formData);
            } else {
                this.createGrid();
            }
        },
        reset : function() {
        },
        createGrid : function() {
            var $table = this;
            var o = this.opts.productData;
            var attribute = this.opts.productData.attribute;
            var opts = this.opts;
            var out = [];
            out.push('<div>');
            out.push('  <div class="search" style=" width:100%;display:none">');
            out.push('      <div class="searchtitle">');
            out.push('          <span>搜索</span><img src="../icons/searchtool.gif" />');
            out.push('          <div class="togglebtn"></div> ');
            out.push('      </div>');
            out.push('      <div class="navline" style="margin-bottom:4px; margin-top:4px;"></div>');
            out.push('      <div class="searchbox">');
            out.push('          <form></form>');
            out.push('      <div class="l-dialog-buttons">');
            out.push('          <div class="l-dialog-btn"><div class="l-dialog-btn-l"></div><div class="l-dialog-btn-r"></div><div class="l-dialog-btn-inner">查询</div></div>');
            out.push('          <div class="l-dialog-btn"><div class="l-dialog-btn-l"></div><div class="l-dialog-btn-r"></div><div class="l-dialog-btn-inner">清除</div></div>');
            // out.push(' <input class="l-dialog-btn" type="button" value="确定"
			// />');
            // out.push(' <input class="l-dialog-btn" type="button" value="清除"
			// />');
            out.push('      </div>');
            out.push('      </div>');
            out.push('  </div>');
            out.push('  <div class="listgrid"></div> ');
            out.push('</div>');
            var listPanle = $(out.join(''));
            var searchform = $("form:first", listPanle);
            var search = $(".search:first", listPanle);

            // searchform.wrap('<div style="border: 1px solid #e0e0e0;"></div>')
            // search.hide();
            var searchQuick = [], searchTable = [], toolBar = [];

            var toolBarTem = [{
                    text : '添加',
                    click : grid_add,
                    img : "../icons/page_add.png"
                }, {
                    text : '修改',
                    click : grid_edit,
                    img : "../icons/edit.gif"
                }, {
                    text : '删除',
                    click : grid_delete,
                    img : "../icons/delete.png"
                }, {
                    text : '复制',
                    click : grid_copy,
                    img : "../icons/copy.png"
                }];
            if(!opts.toolBar){
                toolBar = null;
            } else{
               for(var i=0,j=opts.toolBar.length; i<j; i++){
                   switch(opts.toolBar[i]){
                       case '添加':
                        toolBar.push(toolBarTem[0]);
                       break;
                       case '修改':
                       toolBar.push(toolBarTem[1]);
                       break;
                       case '删除':
                       toolBar.push(toolBarTem[2]);
                       break;
                       case '复制':
                    	   toolBar.push(toolBarTem[3]);
                    	   break;
                      default:
                    	  if(typeof opts.toolBar[i] == 'object')
                    	  toolBar.push(opts.toolBar[i]);
                      opts.toolBar[i];
                      break;
                       
                   }
               };
            }

            if (o.search && o.search.length > 0) {

                for (var i = 0; i < o.search.length; i++) {
                    if (o.search[i].search_quick) {
                        searchQuick.push(o.search[i]);
                    }
                    if (o.search[i].search_table) {
                        searchTable.push(o.search[i]);
                    }
                };
            }

            if (searchTable.length > 0) {// 表格搜索
            	toolBar = toolBar || [];
                toolBar.push({
                    text : '高级查询',
                    click : grid_search,
                    right : true,
                    icon : 'search2'
                });

                var $searchform = searchform.ligerForm({
                    fields : searchTable
                });
            }
            if (searchQuick.length > 0) {// 快速搜索
                // searchform
                var options = '';
                for (var i = 0; i < searchQuick.length; i++) {
                    options += '<option value="' + searchQuick[i].name + '">' + searchQuick[i].display + '</option>';
                };
                toolBar = toolBar || [];
                toolBar.push({
                    text : '快速查询',
                    click : search_quick,
                    icon : 'search2',
                    right : true,
                    render : '<select name="id">' + options + '</select> <input type="text" name="value"/><button name="button">查询</button>'
                })
            }

            var gridToolBar = null;
            if(toolBar){
            	gridToolBar = {items : toolBar};
            }
            if(opts.LIST_URL == null){
            	alert('请定义查询LIST_URL地址');
            	return;
            }
            var param = o.attribute.params;
            if(opts.listParam != null){
            	$.extend(param, opts.listParam);
            }
            var gridOptions = $.extend(true, {
                columns : o.grid,
                toolbar : gridToolBar,
                // data : $.extend(true, {}, AllProductData),
                url : opts.LIST_URL,
                params : param,
                width : '99%',
                height : '99%',
                checkbox : false,
                enabledSort : false
            }, this.opts.gridOption);

            var listgrid = $(".listgrid:first", listPanle).ligerGrid(gridOptions);

            // 高级搜索 按钮绑定
            
            if(searchTable.length > 0){
                var okButton = $(".l-dialog-btn-inner:contains('查询')", listPanle);
                var clearButton = $(".l-dialog-btn-inner:contains('清除')", listPanle);
                okButton.bind('click', function() {
                    var search_data = $searchform.getValues();
                    var condition = $.toJSON(search_data);
                    listgrid.setParm('condition', condition);
                    listgrid.changePage('first');
                    listgrid.reload();
                });
                clearButton.bind('click', function() {
                    $searchform.clearData();
                });
            }
            /*
			 * lab.appendSearchButtons(searchform, listgrid, false, function() {
			 * listgrid.options.data = $.extend(true, {}, AllProductData); });
			 */

            // 附加到dom上
            this.$elm.append(listPanle);
            // 将grid传递到公共变量
            this.grid = listgrid;
            
            function grid_add() {
                if ($table.opts.gridAdd && typeof $table.opts.gridAdd == 'function') {
                    // 对grid_add的调用替换到自定义。
                    $table.opts.gridAdd.call(grid_add, listgrid, $table);
                } else {
                    $table.createForm();
                }
            }

            function grid_edit() {
                var selected = listgrid.getSelected();
                if ($table.opts.gridEdit && typeof $table.opts.gridEdit == 'function') {
                    $table.opts.gridEdit.call(grid_edit, listgrid, $table)
                } else {
                    if (!selected) {
                        lab.tip('请选择行');
                        return;
                    }
                    $table.createForm(selected);
                }
            }

            function grid_delete() {
                if ($table.opts.gridDel && typeof $table.opts.gridDele == 'function') {
                    $table.opts.gridDel.call(grid_delete, listgrid, $table);
                } else {
                    var selectedRows = listgrid.getSelectedRows();
                    if (selectedRows.length == 0) {
                        $.ligerDialog.warn('请选择删除的行!');
                        return;
                    }
                    $.ligerDialog.confirm('确定删除吗?', function(yes) {
                        if (yes) {
                            var ids = [];
                            for (var i = 0; i < selectedRows.length; i++) {
                                ids.push(selectedRows[i].id);
                            }
                            var attribute = $table.opts.productData.attribute;
                            
                            var objectType = $table.opts.objectType;
                         
                            var url = $table.opts.DEL_URL;
                            var deleteParam = {
                                objectType : objectType,
                                ids : ids.join(";")
                            }
                            $.post(url, deleteParam, function(msg) {
                                lab.tip(msg.msg);
                                listgrid.reload();
                                listgrid.deleteSelectedRow();
                            });
                        }
                    });

                }
            }

            function grid_copy() {
            	 if ($table.opts.gridCopy && typeof $table.opts.gridCopy == 'function') {
                     $table.opts.gridCopy.call(grid_copy, listgrid, $table);
                 } else {
                     var selectedRows = listgrid.getSelectedRows();
                     if (selectedRows.length == 0) {
                         $.ligerDialog.warn('请选择复制的行!');
                         return;
                     }
                     var ids = [];
                     for (var i = 0; i < selectedRows.length; i++) {
                         var _row = $.extend(true,{},  selectedRows[i]);
                         if(_row.id != null){//删除ID
                        	 delete _row.id;
                         }
                         //删除系统参数
                         delete _row.__id;
                         delete _row.__index;
                         delete _row.__nextid;
                         delete _row.__previd;
                         delete _row.__recordid;
                         delete _row.__status;
                         
                         var objectType = opts.objectType;
                         var listUrl = opts.ADD_URL;
                         var url = listUrl + '&objectType=' + objectType;
                         var simpleObjectType = objectType.substr(objectType.lastIndexOf('.') + 1);
                         var values = $.toJSON(_row);
                             // 将按钮设置为不可用；
                         var formData = simpleObjectType + '=' + values;
                         $.post(url, formData, function(msg) {//！复制多项的时候，会刷新N次，待有时间在解决
                             lab.tip(msg.msg);
                             listgrid.reload();
                         });
                     }
                 }
            }
            function grid_search() {
                // listgrid.options.data = $.extend(true, {}, AllProductData);
                // listgrid.showFilter();
                search.toggle(300, function(){
                    listgrid.reRender();
                });
            }


            function search_quick(item, selectVal, inputVal) {
                // listgrid.options.data = $.extend(true, {}, AllProductData);
                // listgrid.showFilter();
                var condition = '{' + selectVal + ':' + inputVal +'}';
                listgrid.setParm('condition', condition);
                listgrid.changePage('first');
                listgrid.reload();
            }

            function search_() {
                alert(123);
            }

        },
        createForm : function(data) {
            var formFields = this.opts.productData.form, attribute = this.opts.productData.attribute, form, opts = this.opts, listgrid = this.grid;
            if (this.opts.formRenderID != '' && typeof this.opts.formRenderID == 'string') {
                form = $('#' + this.opts.formRenderID)
            } else {
                form = $('<div></div>');
            }
            var formOptions = $.extend(true, {
                fields : formFields
            }, this.opts.formOption);
            var openForm = form.ligerForm(formOptions);
            switch(this.opts.formMethod) {
                case 'plane':
                    this.$elm.append(form);
                    break;
                case 'dialog':
                default:
                    var dialogOptions = $.extend(true, {
                        title : '预览 明细 界面',
                        target : form,
                        width : this.openWidth - 100,
                        //height : this.openHeight - 20,
                        isResize : true,
                        onClose : function() {
                            var dialog = this;
                            dialog.openForm.destroy();
                        },
                        buttons : [{
                            text : '关闭',
                            onclick : function(item, dialog) {
                                dialog.close();
                            },
                        }, {
                            text : '保存',
                            onclick : function(item, dialog) {
                                var validate = $(openForm.element).Validform({
                                    tiptype : 3
                                });
                                if (!validate.check(false)) {
                                    return;
                                } else {
                                    var objectType = opts.objectType;
                                    var listUrl = opts.ADD_URL;
                                    var url = listUrl + '&objectType=' + objectType;
                                    var simpleObjectType = objectType.substr(objectType.lastIndexOf('.') + 1);
                                    var values = $.toJSON(openForm.getValues());
                                    if (values == '{}') {
                                        lab.tip("保存对象为空，未保存");
                                    } else {
                                        // 将按钮设置为不可用；
                                        item.onclick = '';
                                        //var formData = simpleObjectType + '=' + values;
                                        var formData = {};
                                        formData[simpleObjectType] = values;
                                        
                                        if(opts.addParam != null){
                                        	$.extend(formData, opts.addParam);
                                        }
                                        
                                        $.post(url, formData, function(msg) {
                                            lab.tip(msg.msg);
                                            listgrid.reload();
                                            dialog.close();
                                        });
                                    }
                                };
                            },
                        }]
                    }, this.opts.formDialogOption);
                    var dialog = $.ligerDialog.open(dialogOptions);
                    dialog.openForm = openForm;
                    break;
            }
            var fromData = data || this.opts.formData;
            openForm.setValues(fromData);
            this.form = openForm;

        },
        getGrid : function() {
            return this.grid;
        },
        getForm : function() {
            return this.form;
        },

        destroy : function() {
            if (this.grid) {
                this.grid.destory();
            }
            if (this.form) {
                this.form.destory();
            }
        },
        dictdatas : {}
    }

    $.fn.jasonTable = function(options) {
        var opts = $.extend({}, $.fn.jasonTable.defaults, options);
        return new $.JasonTable(this, opts);
    }
    // default settings
    $.fn.jasonTable.defaults = {
        PACKAGE_NAME : null,//'com.business.entity.',
        ADD_URL : null,//'commController.action?saveOrUpdata',
        DEL_URL : null,//'commController.action?removeByIDs',
        LIST_URL : null,//'framework/commController.action?findFuzzy',
        objectType : null,//实体类型
        listParam : null,
        addParam : null,
        delParam : null,
        
        jsonType : '',
        productData : '',
        toolBar : null,//['添加', '删除', '修改', '复制'],//null, [] ['添加'|'删除'|'修改'],[{ text : '添加',click : grid_add, img : "xx.png,right:true,render:<div/>"}]；null代表没有,如果需要添加查询，则会自动添加
        gridOption : {},
        formOption : {},
        formData : null,
        formDialogOption : {},
        formRenderID : '',
        init : 'grid', // [from,grid]
        formMethod : 'window', // 展示方式:window， 弹窗，normal 正常展示
        dict : 'cache', // ['cache',['actual']];表单dict属性；catch一次性加载缓存，actual实时的
        gridAdd : null, // 工具添加回调函数
        gridEdit : null, // 工具编辑回调函数
        gridDel : null, // 工具删除回调
        gridCopy : null, // 复制回调

    };
    // form表单数据源扩展
    $.ligerDefaults.Form.ElementDataBuilder = function(g, column) {
        switch (column.type) {
            case 'multiselect':
            case 'select':
                switch (column.datasource) {
                    case 'dictdata':
                        if (column.datasource) {
                            var dictparamJson = $.evalJSON(column.datasourcevalue);
                            var dictparam = dictparamJson.dictdatapid;
                            var returnOption = {};
                            if (dictparamJson.ismultiselect && dictparamJson.ismultiselect == 'on') {
                                returnOption.isMultiSelect = true;
                                returnOption.isShowCheckBox = true;
                            }
                            if (dictparamJson.ismultiselect && dictparamJson.hasblank == 'on') {
                                // 留空白
                            }
                            returnOption.textField = 'name';
                            returnOption.valueField = 'id';
                            returnOption.url = 'commController.action?findByColumn&objectType=com.business.entity.DictionaryData&columnName=belongDictionary&columnValue=' + dictparam;

                            return returnOption;
                        }
                        break;
                    case 'custSelect':
                    	if (column.datasource) {
                    		var custSelectParamJson = $.evalJSON(column.datasourcevalue);
                    		var custSelectUrl = custSelectParamJson.custSelectUrl;
                    		var textField = custSelectParamJson.textField || 'text';
                    		var valueField = custSelectParamJson.valueField || 'id';
                    		var autocomplete = custSelectParamJson.autocomplete;
                    		var returnOption = {};
							if(autocomplete && autocomplete == 'on'){
								returnOption.autocomplete = true;
							}
                    		
                    		returnOption.textField = textField;
                    		returnOption.valueField = valueField;
                    		returnOption.url = custSelectUrl;
                    		
                    		return returnOption;
                    	}
                    	break;
                    case 'fixSelect':
                    	if (column.datasource) {
                    		var custSelectParamJson = $.evalJSON(column.datasourcevalue);
                    		var fixSelectColumn = custSelectParamJson.fixSelectColumn || [];
                    		//fixSelectColumn是字符串，解析成数组
                    		fixSelectColumn = eval(fixSelectColumn);
                    		var returnOption = {};
                    		returnOption.textField = 'title';
                    		returnOption.valueField = 'value';
                    		returnOption.data = fixSelectColumn;
                    		
                    		return returnOption;
                    	}
                    	break;
                    case 'cascadeSelect'://级联下拉
                        if (column.datasource) {
                        	var selectParamJson = $.evalJSON(column.datasourcevalue);
                    		var cascadeUrl = selectParamJson.cascadeUrl;
                    		var keyName = selectParamJson.keyName;
                    		var columnName = selectParamJson.columnName;
                    		var textField = selectParamJson.textField || 'text';
                    		var valueField = selectParamJson.valueField || 'id';
                    		var keyTargetID = g.id + '_' + keyName;
                    		var currentTargetID = g.id + '_' + column.name;
                    		var keyTarget = g.targets[keyTargetID];
                    		
                    		var returnOption = {};
                    		returnOption.textField = textField;
                    		returnOption.valueField = valueField;
                    		if(keyTarget.type == 'ComboBox'){
                    			if(keyTarget.data == null && keyTarget.options.url != null){//判断如果是ajax获取值，则等ajax返回再设值
                    				keyTarget.bind('success', function(){
	                    				var isBindSelected = keyTarget.hasBind('selected');
		                    			if(!isBindSelected){
		                    				keyTarget.bind('selected', function(value){
	        	                    			setCascadeTarget(value);
		                    				});
	                    				}
	                        		});
                    			} else{
                    				keyTarget.bind('selected', function(value){
    	                    			setCascadeTarget(value);
                    				});
                    			}
                    		} else{
                    			keyTarget.bind('changeValue', function(value){
                    				setCascadeTarget(value);
                    			});
                    		}
                    		 function setCascadeTarget(value){
                    			var currentTarget = g.targets[currentTargetID];
                    			var param = {};
                    			if(columnName){
                    				param[columnName] = value;
                    			} else{
                    				param.id = value;
                    			}
                    			currentTarget.set('parms', param);
                    			currentTarget.set('url', cascadeUrl);
                    		}
                    		
                    		returnOption.onBeforeOpen  = function(){
                    			var keyValue = g.getValues(keyName);
                    			var value = keyValue[keyName];
                    			var labelName = g.getLabel(keyName);
                    			if(value == null || value == ''){
                    				alert("级联下拉，请先填写/选择【"+labelName+"】字段内容");
                    				return false;
                    			}
                    		};
                    		return returnOption;
                        }
                        break;

                    default:
                        break;
                }

                break;
            case 'text':

                break;
            default:
                return {};
        };
    };
})(jQuery)
