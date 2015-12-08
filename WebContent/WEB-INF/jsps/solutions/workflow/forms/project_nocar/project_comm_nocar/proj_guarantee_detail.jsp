<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>担保信息管理</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	//String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
</head>
<body>
    <div class="mini-toolbar miniext-toolbar-top">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addGuaranteeRow">增加</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeGuaranteeRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        
        <div id="guaranteedetail" class="mini-datagrid" style="width:100%;height:100%;" 
            url="<%=prefix %>/eleasing/jsp/cust_info/cust_account/cust_account_info.xml"  idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="custinfo"  width="120" headerAlign="center" allowSort="true">担保单位
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="TDictsDatasByAssureMethod" width="150"  align="center" headerAlign="center">担保类型
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="TDictsDatasByAssureRelation" width="100" allowSort="true"  align="center" headerAlign="center">关系
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                
                <div field="cgmnote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
            </div>
        </div> 
        
    </div>
</body>

</html>

