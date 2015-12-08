<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信审</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
%>
<%@include file="/base/mini.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
</head>
<body>
	<div>
	    <fieldset id="fd2" class="hideFieldset">
	        <legend><label><input type="checkbox"  id="checkbox1" onclick="toggleFieldSet(this, 'fd2')" hideFocus/>查询条件</label></legend>
	        <div class="fieldset-body" id="form1">
	            <table class="miniext-form-table">
	                <tr>
	                    <td style="width:100px;">项目号：</td>
	                    <td >
	                        <input name="proj_id" class="mini-textbox miniext-form-fit" />
	                    </td>
	                  
	                    <td style="width:100px;">项目名称：</td>
	                    <td >
	                        <input name="projname" class="mini-textbox miniext-form-fit"/>
	                    </td>
	                    
	                    <td class="querybtn">
	                    	<input class="mini-button" text="&nbsp;&nbsp;&nbsp;" tooltip="查询"
	                    	iconCls="icon-query" onclick="search"
	                        />
	                    </td>
	                </tr>      
	            </table>
	        </div>
	    </fieldset>
    </div>
	<!-- 列表可操作按钮 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" 
	                onclick="createworkflow"><span title="点击可发起项目信审流程">项目信审</span></a>
	            </td>
            </tr>
        </table>
    </div>
    <!-- 结束列表可操作按钮 -->
    
    <!--列表清单字段用 class= mini-datagrid 展示
            特殊字段：
             时间字段  dateFormat="yyyy-MM-dd hh:mm:ss"
    -->
    <div class="mini-fit" id="_fit">
        <div id="custinfo" class="mini-datagrid" style="width:100%;height:100%;" 
            url="<%=prefix %>/eleasing/workflow/proj_list_info/proj_change_info_list.xml"  idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
            maskOnLoad="false"
            dataField="datas" contextMenu="#gridMenu"
            allowAlternating="true"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="proj_id"  headerAlign="center" >项目号
                </div> 
                <div field="projname"  headerAlign="center" >项目名称
                </div> 
                <div field="statusname"  headerAlign="center" >项目状态
                </div>
                <div field="custname"  headerAlign="center" >客户名
                </div>
                <div field="leasform"  headerAlign="center" >租赁形式
                </div>
                <div field="enddate"  headerAlign="center" >立项结束时间
                </div>
                <div field="custclass"  headerAlign="center" >客户性质
                </div>  
                <div field="orgcodecardno"  headerAlign="center" >身份证/组织机构代码
                </div>
                <div field="taxlevel"  headerAlign="center" >纳税人类别
                </div>
                <div field="projmanage"  headerAlign="center" >项目经理
                </div>
                <div field="projassist"  headerAlign="center" >项目助理
                </div>
                <div field="projdept"  headerAlign="center" >项目出单部门
                </div>
                <div field="equipamt"  headerAlign="center" >设备款
                </div>
             </div>
        </div>
        
    </div>
    
    <!-- 操作事件js -->
    <script type="text/javascript">
        addOnEnter("form1");
        var form = new mini.Form("form1");
	    //为查询条件添加Enter查询事件
	    function addOnEnter(divID){
	        var input=$('#'+divID+' input');
	        for (var i=0;i<input.length;i++){
	           var inputobj = input[i];
	           inputobj.setAttribute("onEnter","search");
	        }
	    }
        
        mini.parse();
        var grid = mini.get("custinfo"); //获取 grid
        grid.load();
        function createworkflow() {
        	var row = grid.getSelected();
        	if(row){
        		var attachmentParams = "proj_id="+row.id;
        		startProcess("项目信审非车业务-1",attachmentParams); 
        	}else{
        		mini.alert("请选中相应的项目!");
        	}
        	
        }
        
        function search(e) 
        {
            var data = form.getData(true,true);
 		    grid.load(data);
        }
        function reset(e) 
        {
            form.clear();
 		    grid.load();
        }
      
        function onBeforeOpen(e) 
        {
            var menu = e.sender;
                    
            var row = grid.getSelected();
            var rowIndex = grid.indexOf(row);            
            if (!row) 
            {
                e.cancel = true;
                //阻止浏览器默认右键菜单
                e.htmlEvent.preventDefault();
                return;
            }
           
        }
        function onbeforeshowpopup(e)
        {
    		var cb=e.sender;
    		//alert(cb.getValue());alert(cb.getText());
    	    var url = cb._url;
    	    if (url && !cb._loaded)
    	    {
    	        cb.setUrl(url);
    	        cb._loaded = true;
    	    }
    	}

    </script>
    
    <!-- 布局必须的js -->
    <script type="text/javascript">
        function toggleFieldSet(ck, id) {
            var dom = document.getElementById(id);
            dom.className = !ck.checked ? "hideFieldset" : "";
            var _fit = mini.get("_fit");
            _fit.setHeight(window.document.body.clientHeight);
        }
    </script>
</body>
</html>