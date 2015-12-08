<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="boot.jsp"></jsp:include>
<title>资金收付计划</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
</head>
<body>
    <div id="projEquipForm1" class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	            	<a class="mini-button" iconCls="icon-save" plain="true" onclick="upd">保存</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        
        <div id="equipdetail" class="mini-datagrid" style="width:100%;height:100%;" 
            idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
            sortMode="client"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="equipname" vtype="required"  width="150" headerAlign="center">合同号
                	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="model" width="150" renderer="onGenderRenderer" align="center" headerAlign="center">编号
                	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="equipnum" width="100"  align="center" headerAlign="center">计划收款日期
                	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                
                <div field="price" width="120" headerAlign="center">金额
                	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="total" width="120" headerAlign="center">款项名称
                	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
    		    <div field="brand" width="200" headerAlign="center">收付方向
    		    	<input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
    		    </div>
                <div field="custinfobyvndr" name="custinfobyvndr" displayField="custinfobyvndrname"  headerAlign="center" >
                                                   收付对象
   					<input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
                </div>
                <div field="brand" width="200" headerAlign="center">备注
    		    	<input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
    		    </div>
            </div>
        </div> 
        
    </div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("equipdetail");
//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
var temp = parent.document.getElementById("id_json_proj_equip_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";

grid.setData(mini.decode(temp));
//调用返回到主页面
function returnTab(){
	return grid;
}
function addRow() {
    var newRow = { name: "New Row"};
    grid.addRow(newRow, 0);
    grid.beginEditCell(newRow, "custname");
}
function removeRow() {
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
        grid.removeRows(rows, true);
    }
}

	
	function copyRow() {
		var row = grid.getSelected();
		if (row) {
			mini.prompt("复制的行数:", "请输入", function(action, value) {
				if (action == "ok") {
					//校验输入的数字
					var copyCountVal = value;
					var copyCount = -1;
					if (copyCountVal) {
						copyCountVal = copyCountVal.trim();
						copyCount = parseInt(copyCountVal);
						if (isNaN(copyCount)) {
							alert("复制条数必须是整数");
							return;
						} else {
							if (copyCount <= 0) {
								alert("复制条数必须大于等于1");
								return;
							}
						}
					}
					debugger;
					//复制数据
					var newRowDatas = new Array();
					var copyrow=row;
					copyrow.id="";
					for (var i=0;i<copyCount;i++){
					   newRowDatas.push(copyrow); 
					}
					grid.addRows(newRowDatas);
				}
			});
		} else {
			alert("请选择复制的行数据");
		}
	}
	//控制只读页面
	if (isViewHistoryTask == "true") {
		grid.disable();
		$("#projEquipForm1").hide();
	}
</script>
</html>

