<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="与本融资企业的相关交易情况" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addGuaranteeinfoRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeGuaranteeinfoRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="localcorporationgrid" class="mini-datagrid" style="width:100%;height:250px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="custinfo"  width="120" headerAlign="center" allowSort="true">承租人
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="TDictsDatasByAssureMethod" width="150"  align="center" headerAlign="center">借款机构
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="TDictsDatasByAssureRelation" width="100" allowSort="true"  align="center" headerAlign="center">模式/金额/月还款
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">余额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">最后还款时间
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">担保人
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">融资总期数
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">已付期数
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">到期期数
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">逾期期数
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">风险净额
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div> 
        
    </div>
     <input type="hidden" id="id_json_localcorporationgrid" name="json_localcorporationgrid" value='${empty json_localcorporationgrid ? "[]" : json_localcorporationgrid }'></input>
</body>
<script>
	function addGuaranteeinfoRow() {
		var assetinfogrid = $mini("localcorporationgrid");
	    var newRow = {};
	    assetinfogrid.addRow(newRow, 0);
	    assetinfogrid.beginEditCell(newRow);
	}
	function removeGuaranteeinfoRow() {
		var assetinfogrid = $mini("localcorporationgrid");
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

