Grid = function(config) {
	this.renderID = config.renderID;
	this.id = config.id || '_Grid';
	this.width = config.width || (document.documentElement || document.body).clientWidth;
	this.height = config.height || (document.documentElement || document.body).clientHeight;
	
	this.columns = config.columns; //字段[{"field":"id","title":"id","attribute":null,"type":"hidden","columnsStyle":null,"columnValidation":null,"sort":0},{"field":"customerInfo","title":"客户名称","attribute":null,"type":null,"columnsStyle":null,"columnValidation":null,"sort":1}]
	this.values = config.values; //值[{id:'id字段', name="name值", org={id="id", name="name",orgname='name'}}, {id:'id字段', name="name值", org={id="id", name="name",orgname='name'}}]
	this.totalCount = config.totalCount || 1;
	
	this.rownumbers = config.rownumbers || false; //true， false 显示行数，默认为false，
	this.selecter = config.selecter || 'none'; //'none', 'checkbox', 'radio'悬着一个，默认是none
	this.pagination = config.pagination || false; //true, false 显示分页
	this.pageList = config.pageList || [10, 20, 30]; //分页属性，必须是pageSize的倍数
	this.pageSize = config.pageSize || this.pageList[0]; //初始化每页大小
	this.totalCount = config.totalCount || 1;
	this.pageNumber = 1;
	
	this.url = config.url || null;//返回格式{totalCount : xxx, datas : [{},{}]};
	this.queryParams = config.queryParams || null;

	this.tools = config.tools || [];
	this.singleSelect = config.singleSelect || false; //ture, false 是否只能选择一行，selecter为radio时候必须是一行
	
	this.trClass = config.trClass || [ 2, 'trodd', 'trenen' ]; //行样式，默认为空
	this.tdClass = config.tdClass || ''; //列的样式
	this.tableClass = config.tableClass || ''; //表格样式， 默认为空
	this.paginationSystem = null;
	(function(config){
		Grid.prototype.createTable(config);
		
		if(config.url){
			var object = {page : config.pageNumber, rows : config.pageSize};
			jQuery.post(config.url, object, function(data) {
				config.values = data.rows;
				config.totalCount = data.total;
				Grid.innerFn.setTbodyContend(config);
				config.paginationSystem.totalCount = config.totalCount;
				console.info(config.paginationSystem);
				config.paginationSystem.reloadPageSystem();
				config.paginationSystem.callBack = function(){
				};
				console.info(config.paginationSystem);
			}, 'json');
		} else if(config.values){
			Grid.innerFn.setTbodyContend(config);
		} else{
			alert("请确认url或values是否填写！");
		};
	})(this);

};

Grid.prototype.fn = function() {
};
Grid.innerFn = Grid.prototype.fn.prototype;

Grid.prototype.createTable = function(config) {
	var d1 = new Date();
	var tableClass = 'class=' + config.tableClass;
	var time1 = d1.getTime();
	var headArray = [];
	var renderDIV = document.getElementById(config.renderID);
	var toolDiv = renderDIV.appendChild(document.createElement("div"));
	var renderID = config.renderID;
	var gridTitle = config.columns;
	var gridValue = config.values;
	var pageAndSize = [];
	
	if(config.pagination){//添加分页
		var paginationDiv = toolDiv.appendChild(document.createElement("div"));
		paginationDiv.setAttribute("id", renderID + "_pagination");
		//document.getElementById)
		
		 psys = new Grid.innerFn.PageSystem ({
			 totalCount : config.totalCount,
			 renderID : renderID + "_pagination",
			 pageSize : config.pageSize,
		 	 pageList : config.pageList,
			 callBack : function(page, pageSize){
				 pageAndSize = [page, pageSize];
				 console.info("pageAndSize = " + pageAndSize);
				 
				 if(config.url){
						var object = {page : config.pageNumber, rows : config.pageSize};
						jQuery.post(config.url, object, function(data) {
							config.values = data.rows;
							config.totalCount = data.total;
							
							Grid.innerFn.setTbodyContend(config);
						}, 'json');
					} else if(config.values){
						/* @未处理
						 * *****如果定义了分页，则需要将本地数据做分页处理****
						 */
						Grid.prototype.createTable(config);
					} else{
						alert("请确认url或values是否填写！");
					};
			 }
		 }); 
		 config.paginationSystem = psys.init();
		 
		 pageAndSize = psys.getPageAndSize();
		 console.info("pageAndSize = " + pageAndSize);
	}
	
	

	//head
	var table = [ '<table id="' + config.id + '" ' + tableClass + ' cellspacing="0" cellpadding="0">' ];
	var tableHead = [ '<thead></tr>' ];
	var tableValue = [];
	if (config.singleSelect === true || config.selecter === 'radio') {//添加单选框
		tableHead.push('<td>选择</td>');
		headArray.push(config.selecter);
	} else if (config.selecter === 'checkbox') {//添加多选框_Grid_checkAll _Grid_checkAll
		tableHead.push('<td><input id="' + config.id + '_checkAll" type="' + config.selecter + '" ></td>');
		headArray.push('checkbox');
	} else if (config.selecter === 'none') {
	} else {
		alert("请选择正确的selecter选项:1、none，2、checkbox，3、radio");
		return;
	}
	config.rownumbers === true ? tableHead.push('<td>序号</td>') : tableHead.push('<td style="display:none;">序号</td>');
	headArray.push('rownumbers');
	for ( var i in gridTitle) {
		tableHead.push('<td>' + gridTitle[i].title + '</td>');
	}
	tableHead.push('</tr></thead>');
	headArray = headArray.concat(Grid.innerFn.getHeadArray(gridTitle));

	//body
	tableValue.push('<tbody>');
	
	//Grid.innerFn.setTbodyContend(gridValue, gridTitle, config, tableValue);
	/*var tdClass = config.tdClass;

	for ( var j in gridValue) {//添加行
		//有待修改，传的参数格式是 [2, troo, tree],第一位代表有隔几行显示不同class，后边依次为每行的颜色class
		var trClass = (j % 2 == 0) ? 'class=' + config.trClass[1] : 'class=' + config.trClass[2];
		tableValue.push('<tr ' + trClass + '>');
		(config.selecter === 'checkbox' || config.selecter === 'radio') && tableValue.push('<td><input type="' + config.selecter + '"></td>');
		config.rownumbers ? tableValue.push('<td>' + (parseInt(j) + 1) + '</td>') : tableValue.push('<td style="display:none;">' + (parseInt(j) + 1) + '</td>');
		Grid.innerFn.setTableValueRow(tableValue, gridTitle, gridValue[j], tdClass);
		tableValue.push('</tr>');
	}*/
	tableValue.push('</tbody>');
	table = table.concat(tableHead, tableValue);
	table.push('</table>');
	var tableDiv = renderDIV.appendChild(document.createElement("div"));
	tableDiv.setAttribute("id",renderID + "_table");
	tableDiv.innerHTML = table.join('');

	if (config.tools.length > 0) {//添加工具栏
		var selectRows = [];
		var selectType = config.selecter;
		var oneRow = config.singleSelect;
		var tableElement = document.getElementById(config.id);
		var checkAllID = config.id + '_checkAll';
		Grid.innerFn.addEvent(tableElement, 'click', function(e) {//添加点击事件，返回所点击的行
			var src = headTD = Grid.innerFn.getEventElement(e);
			Grid.innerFn.delSpaceElement(src);
			var isNotTrElement = true;

			while (isNotTrElement) {//向上循环得出tr标签内容

				if (src.tagName == 'TR') {

					if (src.parentNode.tagName == 'THEAD') {//点击标题
						if (headTD.tagName == 'INPUT') {
							//Grid.innerFn.setChecked(headTD);
							var allBodyTrTarget = tableElement.getElementsByTagName('TBODY')[0].getElementsByTagName('TR');
							

							var checkAllBox = document.getElementById(checkAllID);

							if (checkAllBox.checked) {

								for ( var i = 0; i < allBodyTrTarget.length; i++) {
									var theadRowJson = {};
									if (i == 0) {
										selectRows = [];
									}
									var tds = allBodyTrTarget[i].childNodes;
									for ( var j = 0; j < tds.length; j++){
										theadRowJson[headArray[j]] = tds[j].innerHTML;
									}
									selectRows.push(theadRowJson);
								}
							} else {
								selectRows = [];
							}
							Grid.innerFn.selectAll(checkAllBox, tableElement);
						}
						return;//doSomething;
					}

					isNotTrElement = false;
					Grid.innerFn.stopBubble(e);
					var rowJson = {};

					var tds = src.childNodes;
					for ( var m = 0; m < tds.length; m++) {
						rowJson[headArray[m]] = tds[m].innerHTML;
					}
					var checkElements = tableElement.getElementsByTagName('input');

					if (oneRow == true) {//单选
						if (selectType == "radio" || selectType == "checkbox") {
							for ( var p = 0; p < checkElements.length; p++) {
								checkElements[p].checked = false;
							}
							src.getElementsByTagName('input')[0].checked = true;
						}
						selectRows.splice(0, selectRows.length, rowJson);
					} else {
						if (selectType == 'checkbox') {
							Grid.innerFn.toggleChecked(src, selectRows, rowJson);
						} else {
							selectRows.push(rowJson);
						}
					}
				} else if (src.tagName == 'TABLE') {
					isNotTrElement = false;
					Grid.innerFn.stopBubble(e);
					//alert("请检查表格是否错误!");
				} else {
					src = src.parentNode;
				}
			}
		});
		
		toolDiv.setAttribute("id", renderID + '_tools');
		var toolButtons = toolDiv.appendChild(document.createElement("div"));
		for ( var n = 0; n < config.tools.length; n++) {//给tools添加标题和回调函数
			var buttonDiv = toolButtons.appendChild(document.createElement("button"));
			buttonDiv.innerHTML = config.tools[n].title;
			var t = config.tools[n];
			Grid.innerFn.addEvent(buttonDiv, 'click', function(e) {
				Grid.innerFn.handlerCallBack(selectRows, t.handler);
				Grid.innerFn.stopBubble(e);
			});
		}

	}
	

	var d2 = new Date();
	var time2 = d2.getTime();
	//console.info(time2 - time1);

};

Grid.innerFn.setTbodyContend = function(config){
	var gridTitle = config.columns;
	var gridValue = config.values;
	var tdClass = config.tdClass;
	var tableValue = []; 

	
	for ( var j in gridValue) {//添加行
		
	
		
		
		//有待修改，传的参数格式是 [2, troo, tree],第一位代表有隔几行显示不同class，后边依次为每行的颜色class
		var trClass = (j % 2 == 0) ? 'class=' + config.trClass[1] : 'class=' + config.trClass[2];
		tableValue.push('<tr ' + trClass + '>');
		(config.selecter === 'checkbox' || config.selecter === 'radio') && tableValue.push('<td><input type="' + config.selecter + '"></td>');
		config.rownumbers ? tableValue.push('<td>' + (parseInt(j) + 1) + '</td>') : tableValue.push('<td style="display:none;">' + (parseInt(j) + 1) + '</td>');
		Grid.innerFn.setTableValueRow(tableValue, gridTitle, gridValue[j], tdClass);
		tableValue.push('</tr>');
	};
	document.getElementById(config.renderID + '_table').getElementsByTagName("TBODY")[0].innerHTML = tableValue.join("");
	
};

Grid.innerFn.setTableValueRow = function(rowValueArray, gridTitle, gridValueRow, tdClass) {//添加某一行
	for ( var j in gridTitle) {
		if(gridTitle[j].handler){
			var s = gridTitle[j]['handler'];
			gridValueRow[gridTitle[j]['field']] = s(gridValueRow);
			//gridValueRow.name = "fuck";//;
		}
		
		rowValueArray.push('<td ' + tdClass + '>' + gridValueRow[gridTitle[j]['field']] + '</td>');
	}
};

Grid.innerFn.delSpaceElement = function(elem) {
	var elem_child = elem.childNodes;// 得到参数元素的所有子元素
	for ( var i = 0; i < elem_child.length; i++) { // 遍历子元素
		if (elem_child.nodeName == "#text" && !/\S/.test(elem_child.nodeValue)) {
			elem.removeChild(elem_child);
		}
		;
	}
	;
};
Grid.innerFn.getHeadArray = function(gridTitle) {
	var arr = [];
	for ( var i = 0; i < gridTitle.length; i++) {
		arr.push(gridTitle[i].field);
	}
	return arr;
};

Grid.prototype.changeElement = function(element, options, callback) {
	if (1 == arguments.length) {

	} else if (3 == arguments.length) {
		callback(element);
	} else {
		alert("请选择合适的参数，参数1：需要操作的Element对象，参数2：需要的参数， 参数3：匿名回调函数");
	}
};
Grid.innerFn.changeElementBackGround = function() {
	alert(1);
};
Grid.innerFn.handlerCallBack = function(data, callback) {
	callback(data);
};
Grid.innerFn.selectAll = function(checkAllBox, element) {
	var checkBox = element.getElementsByTagName("input");
	//console.info(checkBox);
	if (checkAllBox.checked) {
		for ( var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = true;
		}
		;
	} else {
		for ( var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = false;
		}
		;
	}
	;
};

Grid.innerFn.toggleChecked = function(src, selectRows, rowJson) {
	for ( var o = 0; o < selectRows.length; o++) {
		if (selectRows[o].rownumbers == rowJson.rownumbers) {
			// console.info(src.getElementsByTagName('input')[0].checked);
			src.getElementsByTagName('input')[0].checked = false;
			selectRows.splice(o, 1);
			return;
		}
	}
	selectRows.push(rowJson);
	src.getElementsByTagName('input')[0].checked = true;
};

