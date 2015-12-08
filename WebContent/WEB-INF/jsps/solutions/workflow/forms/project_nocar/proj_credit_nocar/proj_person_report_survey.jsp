<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="债权调查" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addSurveyRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeSurveyRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="surveygrid" class="mini-datagrid" style="width:100%;height:300px;" datafield="" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idfield=""
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
        <div property="columns">
            <div type="checkcolumn"></div>
			<div type="indexcolumn" headerAlign="center">序号</div>
            <div field="d1" align="center" headerAlign="center">
                                        债券
            	<input property="editor" class="mini-textbox" style="width:100%;"/>
            </div>
            <div field="d2" headerAlign="center" >
            	内容
            	<input property="editor" class="mini-textbox" style="width:100%;"/>
            </div>                                    
            <div field="d3" headerAlign="center">金额
            	<input property="editor" class="mini-textbox" style="width:100%;"/>
            </div>
            <div field="d4" headerAlign="center">发生时间
            	<input property="editor" class="mini-textbox" style="width:100%;"/>
            </div>
            <div field="d5" headerAlign="center">备注
            	<input property="editor" class="mini-textbox" style="width:100%;"/>
            </div>
        </div>
    </div> 
</div>
<input type="hidden" id="id_json_surveygrid" name="json_surveygrid" value='${empty json_surveygrid ? "[]" : json_surveygrid }'></input>

<script>
	function addSurveyRow() {
		var surveygrid = $mini("surveygrid");
	    var newRow = {};
	    surveygrid.addRow(newRow, 0);
	    surveygrid.beginEditCell(newRow);
	}
	function removeSurveyRow() {
		var surveygrid = $mini("surveygrid");
	    var rows = surveygrid.getSelecteds();
	    if (rows.length > 0) {
	    	surveygrid.removeRows(rows, true);
	    }
	}
</script>