<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="boot.jsp"></jsp:include>
<title>租赁物件</title>
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
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addRow">增加</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeRow">删除</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="copyRow">复制</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        <div id="equipdetail" class="mini-datagrid" style="width:100%;height:100%;" 
            idField="id"
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
            sortMode="client"
            oncellcommitedit="OnCellCommitEdit"
            showReloadButton="false"
            showPager="false"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="eqipname" vtype="required"  width="150" headerAlign="center" allowSort="true">设备名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="model" width="150" renderer="onGenderRenderer" align="center" headerAlign="center">型号/规格
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="equipnum" width="100" allowSort="true"  align="center" headerAlign="center">数量
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                
                <div field="price" width="120" headerAlign="center" allowSort="true">单价
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="total" width="120" headerAlign="center" allowSort="true">总价
                </div>
    		    <div field="brand" width="200" headerAlign="center" allowSort="true">品牌
    		    <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
    		    </div>
                 <div field="vndr" name="custinfobyvndr" displayField="vndrname"  headerAlign="center" >
                                                    供应商
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="vndrname" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval_nocar/SimpleCustSelect.xml',_params:{cust_type:'cust_type.vndr',displayname:'vndr'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                 <div field="manufacturer"  displayField="manufacturername"  headerAlign="center" >
                                                   制造商
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="manufacturername" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval_nocar/SimpleCustSelect.xml',_params:{cust_type:'cust_type.manufacturer',displayname:'manufacturer'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                 <div field="devicetype"  displayField="devicetypename"  headerAlign="center" >
                                                   设备类型
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="devicetypename" valueField="value"
		   					 dataField="datas" data-options="{_params:{pid:'device_type',displayname:'devicetype'}}"
		   					onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                
                <div field="eqipid" width="120" headerAlign="center" allowSort="true">设备序列号
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="equipdeliveryplace" width="120" headerAlign="center" allowSort="true">交付地点
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="equipdeliverydate" width="100" allowSort="true" dateFormat="yyyy-MM-dd">交付时间
                <input property="editor" class="mini-datepicker" style="width:100%;"/>
                </div>
                <div field="equipplace" width="120" headerAlign="center" allowSort="true">设备设置地址
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cenote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("equipdetail");
//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
var temp = parent.document.getElementById("id_json_contract_equip_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
debugger;
grid.setData(mini.decode(temp));
var data=grid.getData();
//grid.setHeight(data.length*25+50);

//调用返回到主页面
function returnTab(){
	return grid;
}
function addRow() {
    var newRow = { name: "New Row"};
    grid.addRow(newRow, 0);
    grid.beginEditCell(newRow, "custname");
    debugger;
    mini.layout;
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
					grid.sortBy("eqipname","Asc");
				}
			});
		} else {
			alert("请选择复制的行数据");
		}
	}
	
	function OnCellCommitEdit(e) {
	    var grid = e.sender;
	    var record = e.record;
	    
	    var field = e.field, value = e.value;
	    //数量修改
	    if (field == "equipnum") {
	    	//总计=数量*单价
	    	var tem=parseFloat(value||0)*parseFloat(record.price||0);
	        grid.updateRow(record, { total:tem});
	    }
	    //利息修改
	    if (field == "price") {  
	    	//总计=数量*单价
	    	var tem=parseFloat(value||0)*parseFloat(record.equipnum||0);
	        grid.updateRow(record, { total:tem});
	    }
	}
	
	//控制只读页面
	if (isViewHistoryTask == "true") {
		grid.disable();
		$("#projEquipForm1").hide();
	}
</script>
</html>

