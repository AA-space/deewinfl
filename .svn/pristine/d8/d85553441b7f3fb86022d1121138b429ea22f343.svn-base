<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理</title>
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
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addRow">增加</a>
	                <span class="separator"></span>
	                
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" id="_fit">
        
        <div id="equipdetail" class="mini-datagrid" style="width:100%;height:100%;" 
            idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
            dataField="datas" contextMenu="#gridMenu"
            allowResize="true" pageSize="20" 
            allowCellEdit="true" allowCellSelect="true" 
            editNextOnEnterKey="true"  editNextRowCell="true"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div type="checkcolumn"></div>
                <div field="equipname"  width="120" headerAlign="center" allowSort="true">设备名称
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>                            
                <div field="model" width="150" renderer="onGenderRenderer" align="center" headerAlign="center">型号/规格
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                <div  field="equipnum" width="100" allowSort="true"  align="center" headerAlign="center">数量
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
                </div>
                
                <div field="price" width="120" headerAlign="center" allowSort="true">单价
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="total" width="120" headerAlign="center" allowSort="true">总价
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
    		    <div field="brand" width="200" headerAlign="center" allowSort="true">品牌
    		    <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
    		    </div>
                 <div field="custInfobyvndr" name="custinfobyvndr" displayField="custinfobyvndrname"  headerAlign="center" >
                                                    供应商
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="custinfobyvndrname" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval/SimpleCustSelect.xml',_params:{cust_type:'cust_type.vndr',displayname:'custinfobyvndr'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                 <div field="custInfobymanufacturer"  displayField="custinfobymanufacturername"  headerAlign="center" >
                                                   制造商
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="custinfobymanufacturername" valueField="id"
		   					 dataField="datas" data-options="{_xmlFileName:'/eleasing/workflow/proj_approval/SimpleCustSelect.xml',_params:{cust_type:'cust_type.manufacturer',displayname:'custinfobymanufacturer'}}"
		   					 onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                 <div field="TDictsDatas"  displayField="device_typename"  headerAlign="center" >
                                                   设备类型
		   					<input property="editor" class="mini-combobox" style="width:100%;" 
		   					 textField="device_typename" valueField="value"
		   					 dataField="datas" data-options="{_params:{pid:'device_type',displayname:'device_type'}}"
		   					onbeforeshowpopup="onbeforeshowpopup"  allowInput="false"
		   					/>
                </div>
                
                <div field="equipid" width="120" headerAlign="center" allowSort="true">设备序列号
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="equipdeliveryplace" width="120" headerAlign="center" allowSort="true">交付地点
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="equipdeliverydate" width="100" allowSort="true" dateFormat="yyyy-MM-dd">交付时间
                <input property="editor" class="mini-datepicker" style="width:100%;"/>
                </div>
                <div field="equipplace" width="120" headerAlign="center" allowSort="true">设备设置地址
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                <div field="cenote" width="120" headerAlign="center" allowSort="true">备注
                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="120" />
                </div>
                
            </div>
        </div> 
        
    </div>
</body>

</html>

