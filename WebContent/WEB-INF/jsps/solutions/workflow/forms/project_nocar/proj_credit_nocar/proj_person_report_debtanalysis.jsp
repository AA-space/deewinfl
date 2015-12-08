<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="债务调查" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addDebtanalysisRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeDebtanalysisRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
     <div id="debtanalysisgrid" class="mini-datagrid" style="width:100%;height:300px;" datafield="" contextMenu="#gridMenu"
         url=""  
         sizeList="[5,10,20,50]" pageSize="10"  idfield=""
      allowResize="true" showColumnsMenu="true"
      allowCellEdit="true" allowCellSelect="true" multiSelect="true"
      allowCellValid="true"
     >
         <div property="columns">
             <div type="checkcolumn"></div>
             <div type="indexcolumn" headerAlign="center">序号</div>
             <div field="c1" headerAlign="center" >类型
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>                                    
             <div field="c2" headerAlign="center">贷款金额
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>
             <div field="c3"  headerAlign="center">贷款日期
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>
             <div field="c4"  headerAlign="center">贷款期限
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>
             <div field="c5"  headerAlign="center">每日支出
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>
             <div field="c6"  headerAlign="center">备注
             	<input property="editor" class="mini-textbox" style="width:100%;"/>
             </div>
         </div>
     </div> 
</div>
<input type="hidden" id="id_json_debtanalysisgrid" name="json_debtanalysisgrid" value='${empty json_debtanalysisgrid ? "[]" : json_debtanalysisgrid }'></input>

<script>
	function addDebtanalysisRow() {
		var debtanalysisgrid = $mini("debtanalysisgrid");
	    var newRow = {};
	    debtanalysisgrid.addRow(newRow, 0);
	    debtanalysisgrid.beginEditCell(newRow);
	}
	function removeDebtanalysisRow() {
		var debtanalysisgrid = $mini("debtanalysisgrid");
	    var rows = debtanalysisgrid.getSelecteds();
	    if (rows.length > 0) {
	    	debtanalysisgrid.removeRows(rows, true);
	    }
	}
</script>
