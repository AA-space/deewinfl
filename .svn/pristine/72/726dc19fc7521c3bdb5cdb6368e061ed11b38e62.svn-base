<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="资产信息" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div id="assetinfoform" class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addAssetinfoRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeAssetinfoRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="assetinfogrid" class="mini-datagrid" style="width:100%;height:300px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
        <div property="columns">
            <div type="checkcolumn"></div>
            <div type="indexcolumn" headerAlign="center">序号</div>
            <div field="a1"  headerAlign="center" >资产名称
            	<input property="editor" class="mini-textbox"  />
            </div>                            
            <div field="a2"  align="center" headerAlign="center">
            	发票号
            	<input property="editor" class="mini-textbox"  />
            </div>
            <div field="a3"  headerAlign="center">
            	证明类型
            	<input property="editor" class="mini-textbox"  />
            </div>                                    
            <div field="a4"  headerAlign="center">购买年限
            	<input property="editor" class="mini-textbox"  />
            </div>
            <div field="a5"  headerAlign="center">金额
            	<input property="editor" class="mini-textbox"  />
            </div>
            <div field="a6" headerAlign="center">负债情况
            	<input property="editor" class="mini-textbox"  />
            </div>
            <div field="a7"   headerAlign="center" >陪同客户打印
            	<input property="editor" class="mini-textbox" />
            </div>
            <div field="a8"   headerAlign="center" >备注
            	<input property="editor" class="mini-textarea"  />
            </div>
        </div>
    </div> 
</div>
<input type="hidden" id="id_json_assetinfogrid" name="json_assetinfogrid" value='${empty json_assetinfogrid ? "[]" : json_assetinfogrid }'></input>

<script>
	function addAssetinfoRow() {
		var assetinfogrid = $mini("assetinfogrid");
	    var newRow = {};
	    debugger;
	    assetinfogrid.addRow(newRow, 0);
	    assetinfogrid.beginEditCell(newRow);
	}
	function removeAssetinfoRow() {
		var assetinfogrid = $mini("assetinfogrid");
	    var rows = assetinfogrid.getSelecteds();
	    if (rows.length > 0) {
	    	assetinfogrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
</script>