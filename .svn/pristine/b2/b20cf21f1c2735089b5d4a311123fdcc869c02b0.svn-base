<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="boot.jsp"></jsp:include>
<title>担保信息管理</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	//String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
</head>
<body>
    <div id="projGuaranteeForm1" class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addGuaranteeRow">增加</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeGuaranteeRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        
        <div id="guaranteedetail" class="mini-datagrid" style="width:100%;height:100%;" 
            idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
            sortMode="client"
            showReloadButton="false"
            showPager="false"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="assuror"  vtype="required" displayField="assurorname"  headerAlign="center" >
                                                   担保单位
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="assurorname" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval_nocar/SimpleCustSelect.xml',_params:{cust_type:'cust_type.assuror',displayname:'assuror'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>                            
                
                <div field="assuremethod"  displayField="assuremethodname"  headerAlign="center" >
                                                   担保类型
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="assuremethodname" valueField="value"
		   					 dataField="datas" data-options="{_params:{pid:'assure_method',displayname:'assuremethod'}}"
		   					onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                
                <div field="assurerelation"  displayField="assurerelationname"  headerAlign="center" >
                                                   关系
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="assurerelationname" valueField="value"
		   					 dataField="datas" data-options="{_params:{pid:'relation',displayname:'assurerelation'}}"
		   					onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                
                
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
            </div>
        </div> 
        
    </div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("guaranteedetail");
//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
var temp = parent.document.getElementById("id_json_contract_guarantee_detail_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";

grid.setData(mini.decode(temp));
//调用返回到主页面
function returnTab(){
	return grid;
}
function addGuaranteeRow() {
    var newRow = { name: "New Row"};
    grid.addRow(newRow, 0);
    grid.beginEditCell(newRow, "custname");
}
function removeGuaranteeRow() {
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
    	grid.removeRows(rows, true);
    }
}

//控制只读页面
if(isViewHistoryTask=="true"){
grid.disable();
$("#projGuaranteeForm1").hide();
}
</script>
</html>

