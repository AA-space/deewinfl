var ChartToTableJson = function(jsonDataForChart) {

	// 将json结果转化成table的数据
	// 判断是否设置了seriesname
	for ( var int = 0; int < jsonDataForChart.dataset.length; int++) {

		if (!jsonDataForChart.dataset[int].seriesname) {
			jsonDataForChart.dataset[int].seriesname = "表" + (int + 1);
		}
	}
	// 判断是否设置了xaxisname
	if (!jsonDataForChart.chart.xaxisname) {
		jsonDataForChart.chart.xaxisname = "名称";
	}
	this.jsonDataForChart = jsonDataForChart;
	var dataSet = this.jsonDataForChart.dataset;
	var chartName = this.jsonDataForChart.chart.xaxisname;
	var category = this.jsonDataForChart.categories[0].category;
	var caption = this.jsonDataForChart.chart.caption;

	var tableData = new Array();
	var arr = [];
	var tableData = [];
	for ( var i = 0; i < dataSet.length; i++) {
		arr[i] = [];
		var data = dataSet[i].data;
		for ( var j = 0; j < data.length; j++) {
			tableData[j] = [];
			arr[i][j] = data[j];
		}
	}

	for ( var i = 0; i < arr.length; i++) {
		for ( var j = 0; j < arr[i].length; j++) {
			tableData[j][i] = arr[i][j];

		}
	}

	// 表头
	tableName = [ chartName ];
	for ( var int = 0; int < dataSet.length; int++) {
		tableName[int + 1] = dataSet[int].seriesname;
	}

	// 表内容
	dataTable = [];
	for ( var int1 = 0; int1 < tableData.length; int1++) {
		var dataCellForTable = {};
		dataCellForTable[tableName[0]] = category[int1].label;
		for ( var int2 = 0; int2 < tableData[0].length; int2++) {
			var t = tableName[int2 + 1];
			dataCellForTable[t] = tableData[int1][int2].value;
			;
		}
		dataTable.push(dataCellForTable);
	}

	// 如果没用定义横轴，则第二项的列名删除
	if ((typeof tableName[0]) == 'undefined') {
		tableName.splice(0, 1);
		tableName[0] = "名称";
	}

	// 列详细定义
	colModelTable = [];
	for ( var int3 = 0; int3 < tableName.length; int3++) {
		var colModelTableCell = {};
		colModelTableCell.name = tableName[int3];
		colModelTableCell.index = tableName[int3];
		colModelTableCell.width = 50;
		colModelTableCell.align = 'center';
		colModelTableCell.sortable = false;
		colModelTable.push(colModelTableCell);
	}

	this.nameTable = tableName;
	this.dataTable = dataTable;
	this.colModelTable = colModelTable;
	this.captionTable = caption + "-表格";
};
/**
 * 让datagrid支持外键查询结果
 */
$.extend($.fn.datagrid.defaults.view, {//让datagrid支持外键查询结果
	renderRow : function(target, fields, frozen, rowIndex, rowData) {
		var opts = $.data(target, 'datagrid').options;

		var cc = [];
		if (frozen && opts.rownumbers) {
			var rownumber = rowIndex + 1;
			if (opts.pagination) {
				rownumber += (opts.pageNumber - 1) * opts.pageSize;
			}
			cc.push('<td class="datagrid-td-rownumber"><div class="datagrid-cell-rownumber">' + rownumber + '</div></td>');
		}
		for ( var i = 0; i < fields.length; i++) {
			var field = fields[i];
			var col = $(target).datagrid('getColumnOption', field);
			if (col) {
				// start 处理多级数据
				var fieldSp = field.split(".");
				var dta = rowData[fieldSp[0]];
				if (dta == null) {
					dta = "";
				}
				for ( var j = 1; j < fieldSp.length; j++) {
					dta = dta[fieldSp[j]];
				}
				// end 处理多级数据
				// get the cell style attribute
				var styleValue = col.styler ? (col.styler(dta, rowData, rowIndex) || '') : '';
				var style = col.hidden ? 'style="display:none;' + styleValue + '"' : (styleValue ? 'style="' + styleValue + '"' : '');

				cc.push('<td field="' + field + '" ' + style + '>');

				if (col.checkbox) {
					var style = '';
				} else {
					var style = '';
					// var style = 'width:' + (col.boxWidth) + 'px;';
					style += 'text-align:' + (col.align || 'left') + ';';
					if (!opts.nowrap) {
						style += 'white-space:normal;height:auto;';
					} else if (opts.autoRowHeight) {
						style += 'height:auto;';
					}
				}

				cc.push('<div style="' + style + '" ');
				if (col.checkbox) {
					cc.push('class="datagrid-cell-check ');
				} else {
					cc.push('class="datagrid-cell ' + col.cellClass);
				}
				cc.push('">');

				if (col.checkbox) {
					cc.push('<input type="checkbox" name="' + field + '" value="' + (dta != undefined ? dta : '') + '"/>');
				} else if (col.formatter) {
					cc.push(col.formatter(dta, rowData, rowIndex));
				} else {
					cc.push(dta);
				}

				cc.push('</div>');
				cc.push('</td>');
			}
		}
		return cc.join('');
	}
});

/**
 * 动态增加edit属性
 */
$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item.field);
				e.editor = item.editor;
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param.field);
			e.editor = param.editor;
		}
	},
	removeEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item);
				e.editor = {};
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param);
			e.editor = {};
		}
	}
});
/**
 * 用法
 */
/*
datagrid.datagrid('addEditor', {
	field : 'password',
	editor : {
		type : 'validatebox',
		options : {
			required : true
		}
	}
});

sy.admin.user.datagrid.datagrid('removeEditor', 'password');
*/