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
					//width:globalClientWidth,
					//height:globalClientHeight,
					width:'100%',
				    height:'100%',
					renderTo:'tableContainerId',
					/*data:[{loginname:'test',gender:'sss'
					   },{loginname:'test2',gender:'sss2'}],*/
					pageSize:20,
					title:'测试',
					//showPager:true,
					//lazyLoad:true,
					xmlFileName:'test/test.xml',
					params:{loginname:'登录test'},
					multiSelect:true,//false为单选,
					columns:[{ type:'indexcolumn'},{
						   type:'checkcolumn'
					},{
						field:'loginname',
						name:'loginName',
						header:'登录名',
						headerAlign:'center',
						allowSort:true,
						width:100
					},{
					   header:'测试的地点',
					   headerAlign:'center',
					   columns:[{
							field:'gender',
							header:'性别',
							width:100,
							allowSort:true
						},{
							field:'gender',header:'性别',width:100,allowSort:true
						},{
							field:'gender',header:'性别',width:100,allowSort:true
						}]
					}],
					frozenStartColumn:0,
					frozenEndColumn:1
				});
			});
	   });
	</script>
</head>
<body style="padding:10px;">
    <div id="panelId" class="mini-panel" title="测试" iconCls="icon-save" style="width:1000px;height:600px;"
    showToolbar="false" showCloseButton="false" showFooter="false" showHeader="true" headerStyle="padding:0px;" bodyStyle="padding:0px;">
        <!--toolbar-->
        <div class="mini-toolbar" style="border-width:0px;border-bottom-width:1px;padding:5px;">
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
		<div class="mini-fit"  id="tableContainerId" style="border:0px;"></div>
 </div>
 <script type="text/javascript">mini.parse("panelId");</script>
</body>
</html>
