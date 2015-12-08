define(function(require , exports , module) {
	var apTableBase = require("js/apcomponent/aptablebase/aptablebase.js");
	require("css/apcomponent/aptable/{currentSkin}/aptable.css");
	var locale = require("js/apcomponent/aptable/locale/{currentLocale}.js");
	var exportExcelLabel       = locale.exportExcel;
	
    var ApTable = function(config){
    	//var me = this;
    	//extend mini functions 
    	var params    = config.params || {};
    	params['xmlFileName'] = config.xmlFileName;
    	//init default config
    	//config.idField          = config.idField || "id";
    	config.dataField        = "datas";
    	config.totalField       = "totalCount";
    	config.pageIndexField   = "pageIndex";
    	config.pageSizeField    = "limit";
    	config.sortFieldField   = "TableRemoteSortField";
    	config.sortOrderField   = "TableRemoteSortDir";
    	config.showPager        = config.showPager||false;
    	config.loadingMsg       = config.loadingMsg||"数据加载中 请稍后...";
        var currentObj = mini.byId(config.renderTo||document.body);
        var isLocal = false;
        if(config.data){
        	isLocal = true;
        	config.showPager = false;
        }else{
        	config.url = config.url||(window.globalWebRoot+'/table/getTableData.action');
        }
        //override this miniui's original methods
    	jQuery.extend(mini.DataGrid.prototype,{
            setParam:function(name, value) {
        	    this.setParams({
        	    	name:value
        	    });
        	},
            setParams:function(newParams){
            	var  currentParams = this._dataSource.loadParams||{};
            	for (var param in newParams) {
            		currentParams[param] = newParams[param];
          	    }
            },
            getParams:function(){
            	return this._dataSource.loadParams||{};
            },
            reload: function(success, error, complete) {
            	this.load(success, error, complete);
            },
            load:function(success, error, complete){
            	this.accept();
            	miniTable._dataSource.loadParams["start"] = 0;//panxf 
                miniTable._dataSource.loadParams["pageIndex"] = 0;
                this._dataSource.reload(success, error, complete);
            },
            /**
             * panxf
             */
            gotoPage:function(index,size){
            	this.accept ();
            	miniTable._dataSource.loadParams["pageIndex"]=index;
            	miniTable._dataSource.loadParams["start"] =index;
            	miniTable._dataSource.loadParams["limit"] =size;
            	miniTable._dataSource.loadParams["pageSize"]=size;
            	this._dataSource.reload();
            }
           /**
            * panxf end
            */
    	});
    	var $renderToContainer = jQuery(currentObj).attr({}).css({});
    	var panelTitle = config.title;
    	var panelContainerId  = "id_panelContainer_"+config.id;
    	var $panelContainer    = jQuery("<div class='aptable'></div>").addClass("mini-panel").attr({
    		id:panelContainerId,
    		title:panelTitle,
    		iconCls:config.iconCls,
    		showToolbar:config.showToolbar||false,
    		showCloseButton:config.showCloseButton||false,
    		showFooter:config.showFooter||false,
    		showHeader:panelTitle?true:false,
    		bodyStyle:config.bodyStyle||"padding:0px;"
    	}).css({
    		width :parseInt(config.width)+"px",
    		height:parseInt(config.height)+"px"
    	});
    	$renderToContainer.append($panelContainer);
    	//fit id 
    	 var tableContainerId  = "id_tableContainer_"+config.id;
    	//初始化columns
        var columnsConfig = config.columns;
    	var columnsMapping = apTableBase.getColumnsEditFormMapping(columnsConfig,config);
    	
    	var queryAreaHtmlObj = apTableBase.getColumnsQueryAreaHtmlObj(columnsConfig,config,null,false);
		var queryAreaItemHtmlArr        = queryAreaHtmlObj["htmlArr"];
		var queryAreaItemHtmlArrLen     = queryAreaItemHtmlArr.length;
    	if(0 < queryAreaItemHtmlArrLen ){
    		var initQueryButtonClass        = "expand-button"; 
    		var initQueryButtonTitle        = "隐藏查询条件";
    		var hiddenQueryArea             = config.hiddenQueryArea;
    		var fieldSetOtherClass          = "";
    		var otherStyle                  = "";
    		if(hiddenQueryArea){
    			initQueryButtonClass        = "collapse-button"; 
        		initQueryButtonTitle        = "显示查询条件";
        		fieldSetOtherClass          = "fieldset-hidden";
        		otherStyle                  = " style='display:none;' " ;
    		}
	    	//query area 
	    	var queryAreaContainerId = "id_queryAreaContainerId_"+config.id;
	    	var queryAreaHtmlArr = [];
	    	
	    	var queryAreaQueryToggleButtonId  = queryAreaContainerId+"_toggleBtn";
	    	queryAreaHtmlArr.push("<div id='"+queryAreaContainerId+"' class='aptable-queryarea-container'><fieldset class='"+fieldSetOtherClass+"'><legend><a id='"+queryAreaQueryToggleButtonId+"' href='javascript:void(0);' class='"+initQueryButtonClass+"' title='"+initQueryButtonTitle+"'></a>查询条件</legend><div class='aptable-queryarea-table-container' '"+otherStyle+"'><table><tbody>");
			
	    	for(var cc =0 ;cc < queryAreaItemHtmlArrLen;cc++){
				queryAreaHtmlArr.push(queryAreaItemHtmlArr[cc]);
			}
			var queryAreaQueryConfirmButtonId  = queryAreaContainerId+"_confirmBtn";
			var queryAreaQueryClearButtonId    = queryAreaContainerId+"_clearBtn";
			
			var queryButtonNewLine = config.queryButtonNewLine;
			if(queryButtonNewLine){
				queryAreaHtmlArr.push("</tr>");
				queryAreaHtmlArr.push("<tr>");
			}
			var queryButtonColSpan = config["queryButtonColSpan"]||1;
			queryAreaHtmlArr.push("<td class='td-label' colspan='"+queryButtonColSpan+"'><span id='"+queryAreaQueryConfirmButtonId+"'><a  class='mini-button query-button'>确定</a></span>");
			queryAreaHtmlArr.push("&nbsp;&nbsp;<span id='"+queryAreaQueryClearButtonId+"'><a  class='mini-button query-button'>清空</a></span></td>");
			queryAreaHtmlArr.push("</tr>");
			
			queryAreaHtmlArr.push("<tbody><table></div></fieldset></div>");
			
	    	$panelContainer.append(jQuery(queryAreaHtmlArr.join("")));
	    	mini.parse(mini.byId(queryAreaContainerId));
	    	jQuery("#"+queryAreaQueryToggleButtonId).bind('click',function(e){
				 e.stopPropagation();
				 apTableBase.fieldsetToggleClick(e,function(){
					 var miniTable = mini.get(tableContainerId);
					 miniTable.doLayout();
				 });
		    });
			jQuery("#"+queryAreaQueryConfirmButtonId).bind('click',function(e){
				 e.stopPropagation();
				 //初始化queryarea参数
			     var queryAreaParams = apTableBase.getQueryAreaParams(config.id, false);
			     var miniTable = mini.get(config.id);
			     miniTable.setParams(queryAreaParams);
			     miniTable.reload();
			});
			jQuery("#"+queryAreaQueryClearButtonId).bind('click',function(e){
				 e.stopPropagation();
				 //初始化queryarea参数
			     var queryAreaParams = apTableBase.getQueryAreaParams(config.id, true);
			     var miniTable = mini.get(config.id);
			     miniTable.setParams(queryAreaParams);
			     miniTable.reload();
			});
	    	//初始化queryarea参数
	    	var queryAreaParams = apTableBase.getQueryAreaParams(config.id, false);
	    	for(var qp in queryAreaParams){
	    		params[qp] = queryAreaParams[qp];
	    	}
        }
    	//toolbar 
    	var $toolbarContainer = null;
        var toolbarDom = config.toolbarEl;
        if(toolbarDom || config.tools){
        	toolbarDom = mini.byId(toolbarDom);
        	$toolbarContainer = (!toolbarDom ? jQuery("<div></div>") : jQuery(toolbarDom)).addClass("mini-toolbar").attr({
        	}).css({
        		display:'block',
        		borderWidth       : "0px",
        		borderBottomWidth : "1px"
        	});
        	$panelContainer.append($toolbarContainer);
        }
        //创建tools应用
        var createToolItemByConfig = function(me,tool){
        	 var html = tool.html;
	       	 var $toolItemParent = jQuery("<span></span>");
	    	 $toolbarContainer.append($toolItemParent);
	         var handler = tool.handler || function() {};
	         var clickHandler = (function(me,html, handler) {
	                return function(e) {
	                    handler(me.miniTable,html);
	                    e.stopPropagation();
	                };
	          })(me,html,handler);
	         $toolItemParent.bind("click",clickHandler);
	         var toolItemConfig = {};
	         
	         //if(tool.id)     {toolItemConfig["id"]      = tool.id;}
	         if(tool.iconCls){toolItemConfig["iconCls"] = tool.iconCls;}
	         if(tool.plain)  {toolItemConfig["plain"]   = tool.plain;}
	       
	         $toolItem = jQuery("<a href='javascript:void(0)'></a>").attr(toolItemConfig);
	         $toolItemParent.append($toolItem);
	         $toolItem.addClass("mini-button mini-button-plain").html(html);
	         var toolItemText = $toolItem.text();
	         var toolItemIdentifier = ( config.id + "_" + toolItemText );
	         $toolItem.attr({id : toolItemIdentifier});
	         $toolItemParent[0].setAttribute("remainClickFunction",clickHandler);
	         $toolItemParent.attr({toolItemIdentifier : toolItemIdentifier});
        };
        var tools = config.tools||[];
        for (var index = 0; index < tools.length; index++) {
            var tool = tools[index];
            var $toolItem = null;
            if (typeof(tool) == 'object') {
                  var html = tool.html;
                  var isHtml = tool.isHtml || false;
                  if (isHtml) {
                      $toolItem = jQuery(html);
                      $toolbarContainer.append($toolItem);
                      continue;
                  }else{
                	  createToolItemByConfig(this,tool);
	                 /*var events = jQuery._data($toolItemParent[0])['events'];
	                 if (events && events.click) {
	                     // jQuery 1.3.x
	                     $.each(events.click, function(key, func) {
	                         console.info(func);
	                     });
	                     // jQuery 1.4.x+
	                     $.each(events.click, function(key, handlerObject) {
	                    	 console.info(key);
	                    	 console.info(handlerObject);
	                         console.info(handlerObject.handler);
	                     });
	                 }*/
                  }
            } else if (typeof(tool) == 'string') {
            	if('globalQuery' == tool.trim()){
            		 var globalQueryTextId    = "id_globalQueryInput_"+config.id;
            		 var globalQueryParamName = config["globalQueryParamName"]||"globalQueryText";
            		 var clickFuncStr         = "javascript:{var miniTable = mini.get(\""+config.id+"\");miniTable.setParams({"+globalQueryParamName+":mini.get(\""+globalQueryTextId+"\").getValue()});miniTable.reload();}";
            		 $toolItem = jQuery("<input id='"+globalQueryTextId+"' class='mini-textbox' title='按回车键全局查询' onenter='"+clickFuncStr+"'/>");
                     $toolbarContainer.append($toolItem);
                     $toolItem = jQuery("<a style='margin-left:5px;' class='mini-button' width='80px' title='按回车键全局查询' onclick='"+clickFuncStr+"'>全局搜索</a>");
                     $toolbarContainer.append($toolItem);
                     continue;
            	}
            	var toolConfig = {
            		iconCls:"",
            		html:"",
            		isHtml:false,
            		plain:true
            	};
            	var isOperTool  = true;
            	var toolContent = tool.trim();
            	switch(toolContent){
            	  case 'add'   : {
            		  toolConfig.handler = function(miniTable,html){
            			  var rowData = {};
            			  apTableBase.tableAddOper(miniTable,columnsConfig,rowData,config);
            		  };
            		  break;
            	  }
            	  case 'edit': {
            		  toolConfig.handler = function(miniTable,html){
            			  var selectedRowData = miniTable.getSelected ();
            			  apTableBase.tableEditOper(miniTable,columnsConfig,selectedRowData,config);
            		  };
            		  
            	  break;}
            	  case 'remove': {
            		  toolConfig.handler = function(miniTable,html){
                		  var selectedRowDatas = miniTable.getSelecteds  ();
                		  apTableBase.tableRemoveOper(miniTable,columnsConfig,selectedRowDatas,config);
            		  };
            		  break;}
            	  case 'copy'  : {
            		  
            		  toolConfig.handler = function(miniTable,html){
            			  var selectedRowDatas = miniTable.getSelecteds  ();
                		  apTableBase.tableCopyOper(miniTable,columnsConfig,selectedRowDatas,config);
            		  };
            		  break;
            	  }
            	  case 'exportExcel':{
            		  toolConfig.handler = function(miniTable,html){
            			  apTableBase.exportExcel(miniTable,columnsConfig,config);
            		  };
            		  break;
            	  }
            	  default:{
            		//添加分隔符
            		isOperTool = false;
                  	$toolItem = jQuery("<span class='separator'></span>");
                  	$toolbarContainer.append($toolItem);
                  	break;
            	  }
            	}
            	if(isOperTool){
            		toolConfig["html"]    = locale[toolContent+"ButtonText"];
            		toolConfig["iconCls"] = "icon-"+toolContent;
            		createToolItemByConfig(this,toolConfig);
            	}
            }
        }
    	var $tableContainer   = jQuery("<div></div>").addClass("mini-fit").attr({id:tableContainerId}).css({});
    	$panelContainer.append($tableContainer);
    	mini.parse($panelContainer[0]);
    	/*var exportExcel = config.exportExcel||false;
    	var $excelTool = null;
    	if(exportExcel){
    	   $excelTool = jQuery("<span></span>").addClass("tools-export-excel").attr({title:exportExcelLabel}).css({});
    	   jQuery(mini.get(panelContainerId).getHeaderEl()).find("div.mini-panel-header-inner div.mini-tools").append($excelTool);
    	}*/
    	
    	//初始化table
    	var miniTable = new mini.DataGrid();
    	this.miniTable = miniTable;
    	config["width"]  ='100%';
    	config["height"] ='100%';
    	//求合计
    	var summaryColumnNames = columnsMapping["summaryColumnNames"];
    	var summaryColumnNamesLen  = summaryColumnNames.length;
    	showSummaryRow = (0 < summaryColumnNamesLen);
    	config["showSummaryRow"] = showSummaryRow;
    	var summaryColumnNameFieldMappings = columnsMapping["summaryColumnNameFieldMappings"];
       	var onDrawSummaryCellFunc  = (function(){
    		return function(e){
    	        var datas = e.data;
    	    	var datasLen = datas.length;
    	        var summaryFieldName = e.field;
    			var initOnDrawSummaryCellFunc = config["onDrawSummaryCell"];
    			if(initOnDrawSummaryCellFunc){
    				initOnDrawSummaryCellFunc(e);
    			}else{
    				var summaryColumnName = summaryColumnNameFieldMappings[summaryFieldName];
    				if(summaryColumnName){
    					if(0 < datasLen){
	        		        //计算合计
    						var sumValue = 0;
	        		        for (var iir = 0; iir < datasLen; iir++) {
	        		            var rowData = datas[iir];
	        		            var t = parseFloat(rowData[summaryFieldName]);
	        		            if (isNaN(t)) continue;
	        		            sumValue += t;
	        		        }
	        		        e.cellHtml = sumValue;
	    				}
    			  }else{
    				  e.cellHtml = "&nbsp;-&nbsp;";
    			  }
    		   }
    		};
    	})();
    	config["onDrawSummaryCell"] = onDrawSummaryCellFunc;
    	miniTable.render(tableContainer); 
        miniTable.set(config);
        miniTable._dataSource.loadParams = params;
        var tableContainer    = mini.byId(tableContainerId);
    	miniTable.render(tableContainer); 
    	/*var exportExcelHandler = (function(miniTable,columnsConfig,config){
    		return function(e){
    			e.stopPropagation();
    			apTableBase.exportExcel(miniTable,columnsConfig,config);
    		};
    	})(this.miniTable,columnsConfig,config);
    	if(exportExcel){
    		$excelTool.bind("click",exportExcelHandler);
    	}*/
    	//必须调用重新渲染filter列
    	if(config.showFilterRow){
    		miniTable._doUpdateFilterRow();
    	}
    	if((true != config.lazyLoad) && !isLocal){
    		miniTable.load();
    	}
    };	
  
	return ApTable;
});