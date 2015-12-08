if(!window.defaultInputWidth){
	window.defaultInputWidth = 165;
}
//发起流程公共JS，页面直接调用该方法
function startProcess(processDefinitionId,attachmentParams,winRef)//name=zhangsan&user=lisi或者{name:'zhangsan',user:'lisi'}
{
	window.rejectWindowDiv = window.document.getElementById('id_rejectWindowDiv');
	/*if (!window.rejectLoadMask)
	{
		try {
			window.rejectLoadMask = new window.tracywindyLoadMask(window.document.body, '');
		} 
		catch (e) {}
	}*/
	if(!window.rejectWindowDiv) 
	{
		window.rejectWindowDiv = window.document.createElement('div');
		window.rejectWindowDiv.id = 'id_rejectWindowDiv';
		window.rejectWindowDiv.style.position = 'absolute';
		window.rejectWindowDiv.style.top = '20%';
		window.rejectWindowDiv.style.left = '40%';
		window.rejectWindowDiv.style.lineHeight = '40px';
		window.rejectWindowDiv.style.border = '1px solid #DDD';
		window.rejectWindowDiv.style.width = '300px';
		window.rejectWindowDiv.style.padding = '10px';
		window.rejectWindowDiv.style.height = '200px';
		window.rejectWindowDiv.style.background = '#FFFFFF';
		window.rejectWindowDiv.style.zIndex = 10000;
		window.rejectWindowDiv.style.overflow = 'auto';
		window.rejectWindowDiv.style.display  =  'none';
		window.document.body.appendChild(window.rejectWindowDiv);
	}
	url = getRootPath()+"/jbpm/startDeployedProcess.action";
	var params = {};
	if(attachmentParams){
		if("object" == typeof(attachmentParams)){
			for(var p in attachmentParams){
				params[p] = attachmentParams[p];//escape(encodeURIComponent(attachmentParams[p]));
			}
		}
		else if("string" == typeof(attachmentParams)){
			var paramsArr = attachmentParams.split("&");
			for(var i=0;i<paramsArr.length;i++){
				var param = paramsArr[i];
				if(param){
					var keyValueArr =  param.split("=");
					var key = "";
					var value = "";
					var keyValueArrLen = keyValueArr.length;
					if(keyValueArrLen>=1){
						key = keyValueArr[0];
						if(key){
							key = key.trim();
						}
					}
					if(keyValueArrLen>=2){
						value = keyValueArr[1];
						if(value){
							if(processDefinitionId.indexOf("%")>-1){
								value = value.trim();
							}else{
								value = escape(encodeURIComponent(value)).trim();
							}
						}
					}
					if(key){
						params[key]=value;
					}
				}
			}
		}
	}
	if(processDefinitionId.indexOf("%")>-1){
		params["processDefinitionId"] =(processDefinitionId);
	}else{
		params["processDefinitionId"] = escape(encodeURIComponent(processDefinitionId));
	}
	openFullScreenWindow(url,params,winRef);
}
//流程页面折叠块
function toggleLeasingOperation(e)
{
    var currentOperationImgElement = e.srcElment||e.target||e.currentTarget;//window.event.srcElement;
    var trClassName = currentOperationImgElement.getAttribute("toggleClass");
    var isDisplay = currentOperationImgElement.className.indexOf("expanded")==-1;
    currentOperationImgElement.className = isDisplay?currentOperationImgElement.className.replace("collapsed","expanded"):currentOperationImgElement.className.replace("expanded","collapsed");
    currentOperationImgElement.title = isDisplay?"折叠":"显示";
    if(isDisplay)
    {
    	jQuery("."+trClassName).show();
    }
    else
    {
    	jQuery("."+trClassName).hide();
    }
    jQuery("#id_workflowAdviseContainer").css("overflow-x","hidden");
    jQuery("#id_workflowFormContainer").css("overflow-x","hidden");
}
/**  
 * 孙传良[注]
 * 同一页面同一code 不可重复使用  推荐使用dictOnSelect
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * code:数据字典父节点code
 * defaultValue:默认显示值的code
 * defaultRawValue:默认显示值
 * otherAttributes:其他的附加在输入域上的属性
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+code
 */
function dict(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width,readOnlyData,islazyLoad)
{
	if(!islazyLoad && islazyLoad==false){
		islazyLoad=false;
	}else{
		islazyLoad=true;
	}
	var defaultRawValue = defaultRawValue||"";
    var combo = new tracywindyComboBox({
       lazyLoad:islazyLoad,
       id:'id_combo_'+code,
       width:width?width:defaultInputWidth,
       renderTo:divContainerDivId,
       xmlFileName:'\\combos\\comboDict.xml',
       loadMode:'ajax',
       readOnly:true,
       otherAttributes:otherAttributes?otherAttributes:'',
       value:defaultValue,
       rawValue:defaultRawValue,
       name:fieldName,
       displayField:'name',
       valueField:'code',
       leftAdd:0,
       readOnlyData: readOnlyData || false,
       params:{
          pid:code
       }
    });
    return combo;
}
/**
 * 孙传良[注]
 * 推荐使用dictOnSelect
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * code:数据字典父节点code
 * defaultValue:默认显示值的code
 * defaultRawValue:默认显示值
 * otherAttributes:其他的附加在输入域上的属性
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+code+fieldName
 */
function dictSameCode(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width,readOnlyData)
{
	var defaultRawValue = defaultRawValue||"";
    var combo = new tracywindyComboBox({
       lazyLoad:true,
       id:'id_combo_'+code+fieldName,
       width:width?width:defaultInputWidth,
       renderTo:divContainerDivId,
       xmlFileName:'\\combos\\comboDict.xml',
       loadMode:'ajax',
       readOnly:true,
       otherAttributes:otherAttributes?otherAttributes:'',
       value:defaultValue,
       rawValue:defaultRawValue,
       name:fieldName,
       displayField:'name',
       valueField:'code',
       leftAdd:0,
       readOnlyData: readOnlyData || false,
       params:{
          pid:code
       }
    });
    return combo;
}
/**
 * 孙传良[注]
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * code:数据字典父节点code
 * defaultValue:默认显示值的code
 * selectFunc:下拉框发生select事件后需要触发的函数
 * otherAttributes:其他的附加在输入域上的属性
 * isContainEmpty:加载的下拉框是否有空选择项
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function dictOnSelect(divContainerDivId,fieldName,code,defaultValue,selectFunc,otherAttributes,isContainEmpty,width,isReadOnly,defaultRawValue,readOnlyData)
{
	var lazyLoad = false;
	if("undefined" != typeof(defaultRawValue)){
		lazyLoad = true;
	}else{
		defaultRawValue = "";
	}
    var combo = new tracywindyComboBox({
       lazyLoad:lazyLoad,
       rawValue:defaultRawValue,
       id:'id_combo_'+divContainerDivId,
       width:width?width:defaultInputWidth,
       renderTo:divContainerDivId,
       xmlFileName:'\\combos\\comboDict.xml',
       loadMode:'ajax',
       readOnly:isReadOnly,
       otherAttributes:otherAttributes?otherAttributes:'',
	   isContainEmpty:isContainEmpty?isContainEmpty:false,
       value:defaultValue,
       name:fieldName,
       displayField:'name',
       valueField:'code',
       leftAdd:0,
       params:{
          pid:code
       },
	   //下拉框只读
	   readOnlyData:readOnlyData||false,
	    onSelect:selectFunc?selectFunc:function(){}
    });
    return combo;
}
/**
 * 孙传良[注]
 * 推荐使用 dictYesOrNoByCode
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * defaultRawValue:默认显示值的
 * isContainEmpty:加载的下拉框是否有空选择项
 * width:输入框的宽度
 * selectFunc:下拉框发生select事件后需要触发的函数
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function dictYesOrNo(divContainerDivId,fieldName,defaultRawValue,isContainEmpty,width,selectFunc,otherAttributes)
{
	
	var defaultRawValue = defaultRawValue||"";
	var combo = new tracywindyComboBox({
		id:'id_combo_'+divContainerDivId,
		width:width?width:defaultInputWidth,
		renderTo:divContainerDivId,
		loadMode:'local',
	    datas:[{title:'是',name:'是'},{title:'否',name:'否'}],
	    readOnly:true,
	    dropListHeight:70,
	    topAdd:0,
        leftAdd:0,
        isContainEmpty:isContainEmpty?isContainEmpty:false,
		rawValue:defaultRawValue,
		otherAttributes:otherAttributes?otherAttributes:'',
		name:fieldName,
		displayField:'title',
		valueField:'name',
		onSelect:selectFunc||function(){},
		leftAdd:0
	});
	return combo;
}
/**
 * 孙传良[注]
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * defaultValue:默认显示值的
 * selectFunc:下拉框发生select事件后需要触发的函数
 * isContainEmpty:加载的下拉框是否有空选择项
 * otherAttributes:其他的附加在输入域上的属性
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function dictYesOrNoByCode(divContainerDivId,fieldName,defaultValue,selectFunc,isContainEmpty,otherAttributes,width,readOnly)
{
	var combo = new tracywindyComboBox({
		id:'id_combo_'+divContainerDivId,
		width:width?width:defaultInputWidth,
		renderTo:divContainerDivId,
		loadMode:'local',
	    datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
	    readOnly:true,
	    //dropListHeight:70,
	    topAdd:0,
        leftAdd:0,
        otherAttributes:otherAttributes?otherAttributes:'',
        isContainEmpty:isContainEmpty?isContainEmpty:false,
		value:defaultValue,
		name:fieldName,
		displayField:'title',
		valueField:'name',
		onSelect:selectFunc||function(){},
		leftAdd:0,
		readOnlyData : readOnly || false
	});
	return combo;
}
/**
 * 孙传良[注]
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * defaultValue:默认显示值的
 * selectFunc:下拉框发生select事件后需要触发的函数
 * isContainEmpty:加载的下拉框是否有空选择项
 * otherAttributes:其他的附加在输入域上的属性
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function dictHadOrNoByCode(divContainerDivId,fieldName,defaultValue,selectFunc,isContainEmpty,otherAttributes,width)
{
	var combo = new tracywindyComboBox({
		id:'id_combo_'+divContainerDivId,
		width:width?width:defaultInputWidth,
		renderTo:divContainerDivId,
		loadMode:'local',
	    datas:[{title:'有',name:'0'},{title:'无',name:'1'}],
	    readOnly:true,
	    //dropListHeight:70,
	    topAdd:0,
        leftAdd:0,
        otherAttributes:otherAttributes?otherAttributes:'',
        isContainEmpty:isContainEmpty?isContainEmpty:false,
		value:defaultValue,
		name:fieldName,
		displayField:'title',
		valueField:'name',
		onSelect:selectFunc||function(){},
		leftAdd:0
	});
	return combo;
}
/**
 * 孙传良[注]
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * fieldName:下拉框显示出来的输入域的域名
 * defaultValue:默认显示值的
 * selectFunc:下拉框发生select事件后需要触发的函数
 * isContainEmpty:加载的下拉框男女中有空选择项(默认没有)(传入false为无空选项)
 * otherAttributes:其他的附加在输入域上的属性
 * width:输入框的宽度
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function dictSexByCode(divContainerDivId,fieldName,defaultValue,selectFunc,isContainEmpty,otherAttributes,width)
{
	var combo = new tracywindyComboBox({
		id:'id_combo_'+divContainerDivId,
		width:width?width:defaultInputWidth,
		renderTo:divContainerDivId,
		loadMode:'local',
	    datas:[{title:'男',name:'1'},{title:'女',name:'0'}],
	    readOnly:true,
	    //dropListHeight:70,
	    topAdd:0,
        leftAdd:0,
        otherAttributes:otherAttributes?otherAttributes:'',
        isContainEmpty:isContainEmpty?isContainEmpty:false,
		value:defaultValue,
		name:fieldName,
		displayField:'title',
		valueField:'name',
		onSelect:selectFunc||function(){},
		leftAdd:0
	});
	return combo;
}
/**
 * 孙传良[注]
 * 推荐使用 commonSelectOverall
 * 基本通用的数据下拉检索函数,在无特殊业务逻辑下,需要构建下拉框选择数据推荐使用该函数
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * tableName:查询数据来自的表
 * valueColumnName:查询结果中的显示字段
 * displayColumnName:查询结果中隐式返回字段
 * fieldName:下拉框显示出来的输入域的域名
 * defaultValue:默认显示值(隐式返回字段值)
 * defaultRawValue:默认显示值
 * otherAttributes:其他的附加在输入域上的属性
 * islazyLoad:是否需要懒加载
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+fieldName
 */
function commonSelect(divContainerDivId,tableName,valueColumnName,displayColumnName,fieldName,defaultValue,defaultRawValue,otherAttributes,islazyLoad){
	if(!islazyLoad && islazyLoad==false){
		islazyLoad=false;
	}else{
		islazyLoad=true;
	}
	var combo_select = new tracywindyComboBox({
		lazyLoad:islazyLoad,
		id:'id_combo_'+fieldName,
		width:defaultInputWidth,
		renderTo:divContainerDivId,
		xmlFileName:'\\combos\\comboCommonSelect.xml',
		loadMode:'ajax',
		readOnly:false,
		otherAttributes:otherAttributes?otherAttributes:'',
		name:fieldName,
		value:defaultValue,
		rawValue:defaultRawValue,
		displayField:'name',
		valueField:'value',
		params:{
			 tableName:tableName,
			 displayColumnName:displayColumnName,
			 valueColumnName:valueColumnName
		 	}
		 });
		return combo_select;
 }
/**
 * 孙传良[注]
 * 基本通用的数据下拉检索函数,在无特殊业务逻辑下,需要构建下拉框选择数据推荐使用该函数
 * divContainerDivId:加载的下拉框需要显示到的层ID
 * tableName:查询数据来自的表
 * valueColumnName:查询结果中隐式返回字段
 * displayColumnName:查询结果中的显示字段
 * fieldName:下拉框显示出来的输入域的域名
 * defaultValue:默认显示值(隐式返回字段值)
 * defaultRawValue:默认显示值
 * otherAttributes:其他的附加在输入域上的属性
 * selectFunc:下拉框发生select事件后需要触发的函数
 * isContainEmpty:加载的下拉框是否有空选择项
 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 */
function commonSelectOverall(divContainerDivId,tableName,valueColumnName,displayColumnName,fieldName,defaultValue,defaultRawValue,otherAttributes,selectFunc,isContainEmpty){
	 var combo_select = new tracywindyComboBox({
			id:'id_combo_'+divContainerDivId,
			width:defaultInputWidth,
			renderTo:divContainerDivId,
			xmlFileName:'\\combos\\comboCommonSelect.xml',
			loadMode:'ajax',
			readOnly:false,
			otherAttributes:otherAttributes?otherAttributes:'',
			name:fieldName,
			value:defaultValue,
			rawValue:defaultRawValue,
			displayField:'name',
			valueField:'value',
			isContainEmpty:isContainEmpty?isContainEmpty:false,
			onSelect:selectFunc||function(combo){},
			params:{
				 tableName:tableName,
				 displayColumnName:displayColumnName,
				 valueColumnName:valueColumnName
			 	}
			 });
			return combo_select;
}
//计算日期差 暂时只支持  天 数
function datediff(Type,DateOne,DateTwo)   
{    
    var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));   
    var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);   
    var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));   
   
    var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));   
    var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);   
    var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));   
    if (Type=='day')
    {
	    var days=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);    
	    return days;
    }
    return 0;
} 
/**//**//**//**//**//**//**//**
 * 返回日期
 * @param d the delimiter
 * @param p the pattern of your date
 2006-06-25 由 www.ttkc.net 修改为根据用户指定的 style 来确定；
 */
String.prototype.toDate = function(style) {
  var y = this.substring(style.indexOf('y'),style.lastIndexOf('y')+1);//年
  var M = this.substring(style.indexOf('M'),style.lastIndexOf('M')+1);//月
  var d = this.substring(style.indexOf('d'),style.lastIndexOf('d')+1);//日
  var h = this.substring(style.indexOf('h'),style.lastIndexOf('h')+1);//时
  var m = this.substring(style.indexOf('m'),style.lastIndexOf('m')+1);//分
  var s = this.substring(style.indexOf('s'),style.lastIndexOf('s')+1);//秒

 if(s == null ||s == "" || isNaN(s)) {s = new Date().getSeconds();}
  if(m == null ||m == "" || isNaN(m)) {m = new Date().getMinutes();}
  if(h == null ||h == "" || isNaN(h)) {h = new Date().getHours();}
  if(d == null ||d == "" || isNaN(d)) {d = new Date().getDate();}
  if(M == null ||M == "" || isNaN(M)) {M = new Date().getMonth()+1;}
  if(y == null ||y == "" || isNaN(y)) {y = new Date().getFullYear();}
  var dt ;
  eval ("dt = new Date('"+ y+"', '"+(M-1)+"','"+ d+"','"+ h+"','"+ m+"','"+ s +"')");
  return dt;
};

/**//**//**//**//**//**//**//**
 * 格式化日期
 * @param   d the delimiter
 * @param   p the pattern of your date
 * @author  meizz
 */
Date.prototype.format = function(style) {
  var o = {
    "M+" : this.getMonth() + 1, //month
    "d+" : this.getDate(),      //day
    "h+" : this.getHours(),     //hour
    "m+" : this.getMinutes(),   //minute
    "s+" : this.getSeconds(),   //second
    "w+" : "天一二三四五六".charAt(this.getDay()),   //week
    "q+" : Math.floor((this.getMonth() + 3) / 3),  //quarter
    "S"  : this.getMilliseconds() //millisecond
  };
  if(/(y+)/.test(style)) {
    style = style.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(style)){
      style = style.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
    }
  }
  return style;
};
/**
 * 日期操作函数  孙传良 如 需要在 2013-01-01 上加40天 即为 calculateDate('5',40,'2013-01-01','yyyy-MM-dd')
 * @param type 需要计算的日期级别  1 为秒 ,2为分, 3为小时,4 为天, 5 为月 ,6为年
 * @param NumDay 计算的数值
 * @param vdate 原始日期
 * @param format 返回日期格式化 参数
 * @return
 */
function calculateDate(type,NumDay,vdate,format){
	if(type==null){type=1;}
	if(NumDay==null){format="0";}
	if(vdate==null){vdate=new Date();}
	if(format==null){format="yyyy-MM-dd";}
	var date=vdate.toDate(format);//new Date(vdate);
	type = parseInt(type); //类型 
	var lIntval = parseInt(NumDay);//间隔
	switch(type){
		case 6 ://年
		date.setYear(date.getYear() + lIntval);
		break;
		case 5 ://月
		date.setMonth(date.getMonth() + lIntval);
		break;
		case 4 ://天
		date.setDate(date.getDate() + lIntval);
		break;
		case 3 ://时
		date.setHours(date.getHours() + lIntval);
		break;
		case 2 ://分
		date.setMinutes(date.getMinutes() + lIntval);
		break;
		case 1 ://秒
		date.setSeconds(date.getSeconds() + lIntval);
		break;
		default:
	}
	return date.format(format);
}