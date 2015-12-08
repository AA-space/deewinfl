<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目变更</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	String custid=request.getParameter("custid");
	String custname=request.getParameter("custname");
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
    <!-- 高级查询部分 -->
    <div>
	    <fieldset id="fd2" class="hideFieldset">
	        <legend><label><input type="checkbox"  id="checkbox1" onclick="toggleFieldSet(this, 'fd2')" hideFocus/>查询条件</label></legend>
	        <div class="fieldset-body" id="form1">
	            <table class="miniext-form-table">
	                <tr>
	                    <td style="width:100px;">客户名称：</td>
	                    <td >
	                        <input name="custname" class="mini-textbox miniext-form-fit" />
	                    </td>
	                  
	                    <td style="width:100px;">项目编号：</td>
	                    <td >
	                        <input name="proj_id" class="mini-textbox miniext-form-fit"/>
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
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="createworkflow">项目变更</a>
	                <span class="separator"></span>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        
        <div id="custinfo" class="mini-datagrid" style="width:100%;height:100%;" 
            url="<%=prefix %>/eleasing/workflow/proj_list_info/proj_change_info_list.xml"  idField="id"
            sizeList="[5,10,20,50]" 
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="id"  width="120" headerAlign="center" visible="false" allowSort="true">id
                </div> 
                <div field="proj_id"  width="120" headerAlign="center" allowSort="true">项目编号
                </div>                            
                <div field="projname" width="100" renderer="onGenderRenderer" align="center" headerAlign="center">项目名称
                </div>
                <div field="statusname" width="120" headerAlign="center" allowSort="true">项目状态</div>
                <div field="custname" width="120" headerAlign="center" allowSort="true">客户名称</div>
                <div field="custclass" width="120" headerAlign="center" allowSort="true">客户类型</div>   
             </div>
        </div> 
        
    </div>
    <script type="text/javascript">
        function toggleFieldSet(ck, id) {
            var dom = document.getElementById(id);
            dom.className = !ck.checked ? "hideFieldset" : "";
            var _fit = mini.get("_fit");
            _fit.setHeight(window.document.body.clientHeight);
        }
    </script>
    <script type="text/javascript">
  
        miniui_ext.addOnEnter("form1");
        
        mini.parse();
        var grid = mini.get("custinfo");
        var form = new mini.Form("form1");
        
        //grid.load({"xmlFileName":"/eleasing/jsp/cust_info/cust_person/cust_person_list.xml"});
        grid.load();
        //grid.frozenColumns(0, 1);
        function search(e) {
            var data = form.getData(true,true);
            debugger;
 		    grid.load(data);
        }
        function reset(e) {
            form.clear();
 		    grid.load();
        }
        function createworkflow() {
        	var row = grid.getSelected();
        	if(row){
        		var attachmentParams = "proj_id="+row.id;
        		startProcess("项目变更非车业务-1",attachmentParams); 
        	}else{
        		mini.alert("请选中变更的项目！！！");
        	}
        	
        }
     
       
        function onbeforeshowpopup(e) {
    		var cb=e.sender;
    		alert(cb.getValue());alert(cb.getText());
    	    var url = cb._url;
    	    if (url && !cb._loaded) {
    	        cb.setUrl(url);
    	        cb._loaded = true;
    	    }
    	}

    </script>
</body>
</html>