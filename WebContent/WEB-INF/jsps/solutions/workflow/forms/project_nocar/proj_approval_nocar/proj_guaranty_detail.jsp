<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="boot.jsp"></jsp:include>
<title>抵押信息管理</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	//String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
</head>
<body>
    <div id="projGuarForm1" class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addGuarantyRow">增加</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeGuarantyRow">删除</a>
	             </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">  
        
        <div id="guarantydeatil" class="mini-datagrid" style="width:100%;height:100%;" 
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
                <div field="eqipname" vtype="required"  width="120" headerAlign="center" allowSort="true">抵押物名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                
                <div field="guarantor"  displayField="guarantorname" vtype="required" headerAlign="center" >
                                                  抵押人
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="guarantorname" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval_nocar/SimpleCustSelect.xml',_params:{cust_type:'cust_type.guarantor',displayname:'guarantor'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>  
                
                <div  field="equipinvoice" width="100" allowSort="true"  align="center" headerAlign="center">发票号
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                
                <div field="totalprice" width="120" headerAlign="center" allowSort="true">发票金额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="presentvalue" width="120" headerAlign="center" allowSort="true">现值
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div> 
        
    </div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("guarantydeatil");
var temp = parent.document.getElementById("id_json_proj_guaranty_detail_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";

grid.setData(mini.decode(temp));
//调用返回到主页面
function returnTab(){
	return grid;
}
function addGuarantyRow() {
    var newRow = { name: "New Row"};
    grid.addRow(newRow, 0);
    grid.beginEditCell(newRow, "custname");
}
function removeGuarantyRow() {
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
    	grid.removeRows(rows, true);
    }
}

//控制只读页面
if(isViewHistoryTask=="true"){
grid.disable();
$("#projGuarForm1").hide();
}
</script>
</html>

