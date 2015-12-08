(function() {
	miniui_ext = {
		//获取mini对象
		get : function(id){
			return mini.get(id);
		},
		//combobox懒加载
		onbeforeshowpopup : function(e){
			var cb=e.sender;
			var url = cb._url ||getRootPath()+'/table/getTableData.action?tracywindyRandom=1&decorate=none';//url 
		    if (url && !cb._loaded) {
		        var xmlFileName = cb._xmlFileName ||'/combos/comboDict.xml';//xmlFileName
		        var params = cb._params || '' ;//params参数
		        /*var str = mini.encode(params);//json对象转换字符串
		        var temp = str.substr(1,str.length-2);//去掉{}
		        temp = temp.replace(/:/ig, "=");//:代替=
		        temp = temp.replace(/,/ig, "&");//,代替&
		        temp = temp.replace(/"/ig, "");//,代替&
		        if("" != temp){
		        	temp="&" +temp;
		        	temp=escape(encodeURIComponent(temp));
		        }*/
		        //需要把key的""去掉
		        var temp="";
		        if('object' == typeof(params))
				{
				   for(var p in params)
				   {
					   temp+=("&"+p+"="+escape(encodeURIComponent(params[p]))); 
				   }
				}
		        
		        var pageSize = cb._pageSize ||  10;//显示行数
		    	if(url.indexOf("&") == -1){
		    		cb.setUrl(url+"?xmlFileName="+xmlFileName+temp+"&pageSize="+pageSize);
		    	}else{
		    		cb.setUrl(url+"&xmlFileName="+xmlFileName+temp+"&pageSize="+pageSize);
		    	}
		        cb._loaded = true;
		    }
		},
		//根据表单ID获取combobox Text值、传后台 以raw_为前缀
		gettextsbyfromid : function(formid,parentid){
			var form = new mini.Form(formid);
			var o = form.getData(); 
			var fields = form.getFields();
			for(var index =0;index<fields.length;index++){
				 //判断是否是下拉框控件，是则同时把text属性传入后台
				if(fields[index].uiCls == "mini-combobox"){
					 o["raw_"+fields[index].id]=fields[index].text;
				}
			}
			parent.document.getElementById(parentid).value=mini.encode(o);
		},
		//表单验证
		fromvalidation : function(formid){
			var form = new mini.Form(formid);
			form.validate();
			var o = form.getData(); 
			var fields = form.getFields();
			for(var index =0;index<fields.length;index++){
				 //fields[index].validate();//验证表单
				 //验证没通过、弹出验证错误信息
				 if(fields[index].isValid() == false){
					 mini.alert(fields[index].errorText);
					 return false;
				 }
			}
			return true;
		},
		//多行验证、grid编辑
		gridvalidation : function(gridid){
			var grid = mini.get(gridid);
        	grid.validate();
        	if (grid.isValid() == false) {
                var error = grid.getCellErrors()[0];
                mini.alert(error.column.errorText,"提示：",function(data){
                	grid.beginEditCell(error.record, error.column);
                });
   			 	return false;
            }
        	return true;
		},
		//格式化日期
		onDateRenderer : function(e){
			var value = e.value;
		    if (value) return mini.formatDate(mini.parseDate(value), 'yyyy-MM-dd HH:mm:ss');
		    return "";
		},
		//初始化combobox加载数据 以 raw_为前缀
		//param 1 :表单ID
		//param 2 :数据（json对象）
		initcomboboxloaddata : function(formid,data){
			 var form = new mini.Form(formid);
			 var o = form.getData(); 
			 var fields = form.getFields();
			 for(var index =0;index<fields.length;index++){
				 //判断是否是下拉框控件，是则同时把text属性设置combobox
				 if(fields[index].uiCls == "mini-combobox"){
					var temp = "raw_"+fields[index].name;
					fields[index].setText(data[temp]);
				 }
			 }
		},
		//表单只读
		initformenabled : function(formid){
			 var form = new mini.Form(formid);
			 form.setEnabled(false);
		},
		//回车查询
		addOnEnter : function(divID){
	        var input=$('#'+divID+' input');
	        for (var i=0;i<input.length;i++){
	           var inputobj = input[i];
	           inputobj.setAttribute("onEnter","search");
	        }
	    },
	    //初始化验证
	    //param 1 : 表单ID
	    //param 2 : 属性字符串 -- args1,args2,args3...
	    //param 3 : isRequired 是否验证 取值false||true  默认true 
	    initrequired : function(formid,data,isRequired){
		   	 var form = new mini.Form(formid);
			 var o = form.getData(); 
			 var fields = form.getFields();
			 var strs = data.split(",");
			 for(var i =0;i<fields.length;i++){
				 for(var j =0;j<strs.length;j++){
					 if(fields[i].name == strs[j]){
						 fields[i].setRequired(isRequired ==false ? isRequired :true);
					 }
				 }
			 }
		}
	};
})();
function getRootPath() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	return (prePath + postPath);
}
