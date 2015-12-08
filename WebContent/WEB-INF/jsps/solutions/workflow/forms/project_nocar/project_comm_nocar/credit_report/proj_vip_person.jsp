<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="承租企业重要个人基本信息" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addVipinfoRow">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeVipinfoRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="vippersongrid" class="mini-datagrid" style="width:100%;height:250px;" dataField="datas" contextMenu="#gridMenu"
        url=""  
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
     allowResize="true" showColumnsMenu="true"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     allowCellValid="true"
    >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="custinfo"  width="120" headerAlign="center" allowSort="true">姓名
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="TDictsDatasByAssureMethod" width="150"  align="center" headerAlign="center">证件类型
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="TDictsDatasByAssureRelation" width="100" allowSort="true"  align="center" headerAlign="center">证件号码
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">性别
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">出生年月
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">关系
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">职务
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">是否主联系人
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">户口所在地
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">常住地址
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">邮寄地址
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">Email
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">邮编
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">手  机
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">固定电话
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">其他备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">登记人
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">登记时间
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">修改人
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">修改时间
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
            </div>
        </div> 
        
    </div>
    <input type="hidden" id="id_json_vippersongrid" name="json_vippersongrid" value='${empty json_vippersongrid ? "[]" : json_vippersongrid }'></input>
</body>
<script>
	function addVipinfoRow() {
		var assetinfogrid = $mini("vippersongrid");
	    var newRow = {};
	    assetinfogrid.addRow(newRow, 0);
	    assetinfogrid.beginEditCell(newRow);
	}
	function removeVipinfoRow() {
		var assetinfogrid = $mini("vippersongrid");
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

