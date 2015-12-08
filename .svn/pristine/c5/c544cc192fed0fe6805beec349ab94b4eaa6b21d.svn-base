<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>项目信审 - 自然人（考察报告） - 资产信息</title>
<%@include file="/base/mini.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/miniui_ext.js"></script>
</head>
<body>
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="add">增加</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="remove">删除</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-save"  plain="true" onclick="save">保存</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div class="mini-fit" id="_fit">
        <div id="relategrid" class="mini-datagrid" style="width:100%;height:100%;" dataField="datas" contextMenu="#gridMenu"
            url=""  
            sizeList="[5,10,20,50]" pageSize="10"  idField="id"
	        allowResize="true" showColumnsMenu="true"
	        allowCellEdit="true" allowCellSelect="true" multiSelect="true"
	        allowCellValid="true"
        >
            <div property="columns">
                <!-- <div type="indexcolumn" ></div> -->
                <div type="checkcolumn"></div>
<!--                 <div field="id"  headerAlign="center" >id</div>  -->
                <div field="personname" width="200" headerAlign="center" >资产名称</div>                            
                <div field="idcardno" width="200" align="center" headerAlign="center">
                	发票号
                	<input property="editor" class="mini-textbox" style="width:100%;" minHeight="80"/>
                </div>
                <div field="birthdate" width="100" headerAlign="center" dateFormat="yyyy-MM-dd">
                	证明类型
                	<input property="editor" class="mini-datepicker" style="width:100%;" allowInput="false"/>
                </div>                                    
                <div type="comboboxcolumn" autoShowPopup="true" field="sex" width="50" headerAlign="center">购买年限
                	<input property="editor" class="mini-combobox" style="width:100%;"  data="[{ id: 0, text: '男' }, { id: 1, text: '女'}]" />
                </div>
                <div type="comboboxcolumn" autoShowPopup="true" field="relationship" width="150" headerAlign="center">金额
                	<input property="editor" class="mini-combobox" style="width:100%;"  data="[{ id: 0, text: '配偶' }, { id: 1, text: '兄弟'}]" />
                </div>
                <div type="comboboxcolumn" autoShowPopup="true" field="mainpersonflag" headerAlign="center">负债情况
                	<input property="editor" class="mini-combobox" style="width:100%;"  data="[{ id: 0, text: '是' }, { id: 1, text: '否'}]" />
                </div>
                <div field="mobilenumber" width="150"  headerAlign="center" >陪同客户打印
                	<input property="editor" class="mini-textbox" style="width:100%;"/>
                </div>
                <div field="domicileplace" width="200"  headerAlign="center" >备注
                	<input property="editor" class="mini-textarea" style="width:100%;" minHeight="80"/>
                </div>
            </div>
        </div> 
        
    </div>
    <!--grid 操作按钮和事件js  -->
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("relategrid");
        grid.load();//加载数据
        grid.frozenColumns(0, 1);//锁定列
        //添加操作
        function add(e){
<%--         	var newRow = { name: "New Row", personname:"<%=custname%>",custid:"<%=custid%>",creatorname:'${sessionScope.loginUser.realname}',createdatename:new Date()}; --%>
            //添加至第一行
        	grid.addRow(newRow, 0);
            //编辑行
            grid.beginEditCell(newRow, "custname");
        }
        //删除
		function remove(e) 
		{
        	//获取选中行
			var rows = grid.getSelecteds();
		    if (rows.length > 0) {
		    	mini.confirm("确定删除选中记录？","提示：",function(data){
		        	if("ok" == data){
			        	grid.loading("操作中，请稍后......");
			        	var json = mini.encode(rows);
			            $.ajax({
			                url: "<%=request.getContextPath() %>/acl/removeCustRelatedPerson.acl",
			                data: {data : json}  ,
			                success: function (text) {
			                	grid.reload();
			                },
			                error: function () {
			                }
			            });
		        	}
		        });
		    } else {
		        alert("请选中一条记录");
		    }
		}
        //保存
        
        function save(e){
        	//获取grid增删改数据
        	var data = grid.getChanges(null);
            grid.loading("保存中，请稍后......");
            var json = mini.encode(data);
            var url="<%=request.getContextPath() %>/acl/addCustRelatedPerson.acl";
            $.ajax({
                url: url,
                data: {data : json},
                type: "post",
                success: function (text) {
                    grid.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        //返回grid是否改变
		function gridischange(){
			return grid.isChanged(); 
		}
    </script>
</body>
</html>