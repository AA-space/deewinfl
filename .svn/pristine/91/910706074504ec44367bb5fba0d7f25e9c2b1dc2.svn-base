<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="银行资信情况" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addEbankcreditinfoRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeEbankcreditinfoRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="ebankcreditgrid" class="mini-datagrid" style="width:100%;height:250px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="custinfo"  width="120" headerAlign="center" allowSort="true">贷款银行
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="TDictsDatasByAssureMethod" width="150"  align="center" headerAlign="center">贷款余额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="TDictsDatasByAssureRelation" width="100" allowSort="true"  align="center" headerAlign="center">逾期金额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">承兑余额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">担保余额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">涉诉情况
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div> 
        
    </div>
    <input type="hidden" id="id_json_ebankcreditgrid" name="json_ebankcreditgrid" value='${empty json_ebankcreditgrid ? "[]" : json_ebankcreditgrid }'></input>
    
</body>
<script>
	function addEbankcreditinfoRow() {
		var assetinfogrid = $mini("ebankcreditgrid");
	    var newRow = {};
	    assetinfogrid.addRow(newRow, 0);
	    assetinfogrid.beginEditCell(newRow);
	}
	function removeEbankcreditinfoRow() {
		var assetinfogrid = $mini("ebankcreditgrid");
	    var rows = assetinfogrid.getSelecteds();
	    if (rows.length > 0) {
	    	assetinfogrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
</script>
</html>

