<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="收入来源" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addRevenueRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeRevenueRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="revenuegrid" class="mini-datagrid" style="width:100%;height:300px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
        <div property="columns">
        	<div type="checkcolumn"></div>
            <div type="indexcolumn" headerAlign="center">序号</div>
            <div field="b1" headerAlign="center" >
            	来源
            	<input property="editor" class="mini-textbox" />
            </div>                                    
            <div field="b2"  headerAlign="center">金额
            	<input property="editor" class="mini-textbox" />
            </div>
            <div field="b3" headerAlign="center">备注
            	<input property="editor" class="mini-textbox" />
            </div>
        </div>
    </div> 
</div>
<input type="hidden" id="id_json_revenuegrid" name="json_revenuegrid" value='${empty json_revenuegrid ? "[]" : json_revenuegrid }'></input>

<script>
	function addRevenueRow() {
		var revenuegrid = $mini("revenuegrid");
	    var newRow = {};
	    revenuegrid.addRow(newRow, 0);
	    revenuegrid.beginEditCell(newRow);
	}
	function removeRevenueRow() {
		var revenuegrid = $mini("revenuegrid");
	    var rows = revenuegrid.getSelecteds();
	    if (rows.length > 0) {
	    	revenuegrid.removeRows(rows, true);
	    }
	}
</script>
