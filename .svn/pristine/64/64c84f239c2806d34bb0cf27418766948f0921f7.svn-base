<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
<%@include file="/base/mini.jsp"%>
<script>
		jQuery(function(){
			seajs.use(["js/aptable/aptable.js"],function(ApTable){
				new ApTable({
					id:'test',
					width:globalClientWidth,
					height:globalClientHeight,
					toolbarEl:'toolbarElId',
					/*data:[{loginname:'test',gender:'sss'
					   },{loginname:'test2',gender:'sss2'}],*/
					pageSize:20,
					title:'测试',
					iconCls:'icon-node',
					lazyLoad:true,
					//showPager:true,
					xmlFileName:'test/table.xml',
					params:{loginname:'登录test'},
					multiSelect:true,//false为单选,
					columns:[
				    //数字列
				    { type:'indexcolumn'},
				    //选择列
				    {
						   type:'checkcolumn'
					},{
						field:'realname_',
						header:'真实姓名',
						width:100,
						allowSort:true
					},{
						 header:'测试的地点111',
						 headerAlign:'center',
						 columns:[{
							   header:'测试的地点',
							   headerAlign:'center',
							   columns:[{
									field:'username_',header:'登录名',width:100,allowSort:true
								},{
									field:'telephone_',header:'电话号码',width:100,allowSort:true
								},{
									field:'email_',header:'邮件地址',width:100,allowSort:true
								}]
						   }]
					}],
					frozenStartColumn:0,
					frozenEndColumn:2
				});
			});
		});
		function loadTableData(){
			mini.get("test").load();
		}
	</script>
</head>
<body>
        <!--  -->
        <div id="id_btnContainer">
              <a class="mini-button" iconCls="icon-load" onclick="javascript:loadTableData();">加载table的数据</a>
        </div>
        <script>mini.parse("id_btnContainer");</script>
        <!--toolbar-->
        <div id="toolbarElId" style="display:none">
		    <a class="mini-button" iconCls="icon-add">增加</a>
		    <a class="mini-button" iconCls="icon-edit">修改</a>
		    <a class="mini-button" iconCls="icon-remove">删除</a>
		    <span class="separator"></span>
		    <a class="mini-button" plain="true">增加</a>
		    <a class="mini-button" plain="true">修改</a>
		    <a class="mini-button" plain="true">删除</a>
		    <span class="separator"></span>
		    <input class="mini-textbox" />      
		    <a class="mini-button" plain="true">查询</a>
		</div>
</body>
</html>
