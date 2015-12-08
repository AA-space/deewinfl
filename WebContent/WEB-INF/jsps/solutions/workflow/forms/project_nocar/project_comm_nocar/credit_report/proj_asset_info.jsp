<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="资产信息" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addAssetRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeAssetRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="assetgrid" class="mini-datagrid" style="width:100%;height:250px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="custinfo"  width="120" headerAlign="center" allowSort="true">资产名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="TDictsDatasByAssureMethod" width="150"  align="center" headerAlign="center">发票号
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="TDictsDatasByAssureRelation" width="100" allowSort="true"  align="center" headerAlign="center">证明类型
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">购买年限
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">金额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">负债情况
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">陪同客户打印
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div> 
        
    </div>
    <input type="hidden" id="id_json_assetgrid" name="json_assetgrid" value='${empty json_assetgrid ? "[]" : json_assetgrid }'></input>
</body>
<script>
	function addAssetRow() {
		var assetgrid = $mini("assetgrid");
		debugger;
	    var newRow = {};
	    assetgrid.addRow(newRow, 0);
	    assetgrid.beginEditCell(newRow);
	}
	function removeAssetRow() {
		var assetgrid = $mini("assetgrid");
	    var rows = assetgrid.getSelecteds();
	    if (rows.length > 0) {
	    	assetgrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
</script>
</html>

