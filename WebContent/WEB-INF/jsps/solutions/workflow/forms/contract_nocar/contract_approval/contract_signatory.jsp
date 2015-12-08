<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="contract_signatory_grid1">
	<div class="mini-panel" title="出租方基本信息(甲方)" showCollapseButton="true" style="width: 100%;">
		<table class="fillTable" cellspacing="0" cellpadding="0">
	        <tr class="tr-lessor-info tr-even">
			    <td class="td-content-title" width="20%">出租人：</td>
			    <td class="td-content" width="30%"><input required="true"  name="contract_signatory.lessor" class="mini-textbox"  value="${requestScope['contract_signatory.lessor']}"></td>
			    <td class="td-content-title" width="20%">委托代理人：</td>
			    <td class="td-content" width="30%"><input required="true"  name="contract_signatory.leaseconsigner" class="mini-textbox" value="${requestScope['contract_signatory.leaseconsigner']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-odd">
			    <td class="td-content-title">注册地址：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseregisteraddr" class="mini-textbox"  value="${requestScope['contract_signatory.leaseregisteraddr']}"></td>
			    <td class="td-content-title">通讯地址：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseaddr" class="mini-textbox" value="${requestScope['contract_signatory.leaseaddr']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-even">
			    <td class="td-content-title">法定代表人：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseperson" class="mini-textbox"  value="${requestScope['contract_signatory.leaseperson']}"></td>
			    <td class="td-content-title">邮编：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leasepostcode" class="mini-textbox" value="${requestScope['contract_signatory.leasepostcode']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-odd">
			    <td class="td-content-title">联系人：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaselinkman" class="mini-textbox"  value="${requestScope['contract_signatory.leaselinkman']}"></td>
			    <td class="td-content-title">电话：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leasetel" class="mini-textbox" value="${requestScope['contract_signatory.leasetel']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-even">
			    <td class="td-content-title">传真：</td>
			    <td class="td-content"><input  name="contract_signatory.leasefax" class="mini-textbox"  value="${requestScope['contract_signatory.leasefax']}"></td>
			    <td class="td-content-title">电子邮件：</td>
			    <td class="td-content"><input  name="contract_signatory.leaseemail" class="mini-textbox" value="${requestScope['contract_signatory.leaseemail']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-odd">
			    <td class="td-content-title">开户账号：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseaccnumber" class="mini-textbox"  value="${requestScope['contract_signatory.leaseaccnumber']}"></td>
			    <td class="td-content-title">开户银行：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseaccbank" class="mini-textbox" value="${requestScope['contract_signatory.leaseaccbank']}"></td>
			</tr>
			<tr class="tr-lessor-info tr-even">
			    <td class="td-content-title">开户户名：</td>
			    <td class="td-content"><input required="true"  name="contract_signatory.leaseaccname" class="mini-textbox"  value="${requestScope['contract_signatory.leaseaccname']}"></td>
			    <td class="td-content-title"></td>
			    <td class="td-content"></td>
			</tr>
		</table>
	</div>
	<div class="mini-panel" title="承租方基本信息(乙方)" showCollapseButton="true" style="width: 100%;">
		<table class="fillTable" cellspacing="0" cellpadding="0" id="signatory2">
	        <tr class="tr-client-info tr-even">
				    <td class="td-content-title">承租人：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.client" class="mini-textbox"  value="${requestScope['contract_signatory.client']}"></td>
				    <td class="td-content-title">委托代理人：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientconsigner" class="mini-textbox" value="${requestScope['contract_signatory.clientconsigner']}"></td>
				</tr>
				<tr class="tr-client-info tr-odd">
				    <td class="td-content-title">通讯地址：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientaddress" class="mini-textbox"  value="${requestScope['contract_signatory.clientaddress']}"></td>
				    <td class="td-content-title">邮编：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientpostcode" class="mini-textbox" value="${requestScope['contract_signatory.clientpostcode']}"></td>
				</tr>
				<tr class="tr-client-info tr-even">
				    <td class="td-content-title">法定代表人：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientperson" class="mini-textbox"  value="${requestScope['contract_signatory.clientperson']}"></td>
				    <td class="td-content-title">联系人：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientlinkman" class="mini-textbox" value="${requestScope['contract_signatory.clientlinkman']}"></td>
				</tr>
				<tr class="tr-client-info tr-odd">
				    <td class="td-content-title">电话：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clienttel" class="mini-textbox"  value="${requestScope['contract_signatory.clienttel']}"></td>
				    <td class="td-content-title">传真：</td>
				    <td class="td-content"><input   name="contract_signatory.clientfax" class="mini-textbox" value="${requestScope['contract_signatory.clientfax']}"></td>
				</tr>
				<tr class="tr-client-info tr-even">
				    <td class="td-content-title">短信联系手机号：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientmobilenumber" class="mini-textbox"  value="${requestScope['contract_signatory.clientmobilenumber']}"></td>
				    <td class="td-content-title">电子邮件：</td>
				    <td class="td-content"><input   name="contract_signatory.clientemail" class="mini-textbox" value="${requestScope['contract_signatory.clientemail']}"></td>
				</tr>
				<tr class="tr-client-info tr-odd">
				    <td class="td-content-title">开户账号：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientaccnumber" class="mini-textbox"  value="${requestScope['contract_signatory.clientaccnumber']}"></td>
				    <td class="td-content-title">开户银行：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientaccbank" class="mini-textbox" value="${requestScope['contract_signatory.clientaccbank']}"></td>
				</tr>
				<tr class="tr-client-info tr-even">
				    <td class="td-content-title">开户户名：</td>
				    <td class="td-content"><input required="true"  name="contract_signatory.clientaccname" class="mini-textbox" value="${requestScope['contract_signatory.clientaccname']}"></td>
				    <td class="td-content-title"></td>
				    <td class="td-content"></td>
				</tr>
		</table>
	</div>
	<div class="mini-panel" title="卖方/供应商" showCollapseButton="true" style="width: 100%;">
	    <!-- 按钮操作 -->
	    <div id="contractSignatoryForm1"  class="mini-toolbar miniext-toolbar-top">
	        <table class="miniext-form-fit">
	            <tr>
		            <td>
		                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addsignatoryRow">增加</a>
		                <span class="separator"></span>
		                <a class="mini-button" iconCls="icon-edit" plain="true" onclick="updatesignatoryRow">修改</a>
		                <span class="separator"></span>
		                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removesignatoryRow">删除</a>
		            </td>
	            </tr>
	        </table>
	    </div>
	    <!--grid展示--撑满页面-->
	    <div id="signatorygrid" class="mini-datagrid" style="width:100%;height:300px;" datafield=""
	        sizeList="[5,10,20,50]" pageSize="10"  idfield=""
		     allowResize="true" showColumnsMenu="true"
		     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
		     allowCellValid="true"
	    >
	        <div property="columns">
	        	<div type="checkcolumn"></div>
	            <div type="indexcolumn" headerAlign="center">序号</div>
	            <div field="seller" align="center" headerAlign="center">供应商</div>
	            <div field="sellerlegalperson"  headerAlign="center">法定代表人</div>                                    
	            <div field="sellerlinkman"  headerAlign="center">联系人</div>
	            <div field="sellerregisteraddr"  headerAlign="center">注册地址</div>
	            <div field="selleraddr"  headerAlign="center">通讯地址</div>
	            <div field="sellerpostcode"  headerAlign="center">邮政编码</div>
	            <div field="sellertel"  headerAlign="center">电话</div>
	            <div field="sellerfax"  headerAlign="center">传真</div>
	            <div field="selleraccnumber"  headerAlign="center">开户账号</div>
	            <div field="selleraccbank"  headerAlign="center">开户银行</div>
	            <div field="selleraccname"  headerAlign="center">开户户名</div>
	        </div>
	    </div> 
	</div>
</div>

<script>                 
 	//mini.parse();
 	//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
 	//var temp = parent.document.getElementById("id_json_contract_supplier_str").value;  
 	//var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
 	//grid.setData(mini.decode(temp));
 	//调用返回到主页面
 	function returnTab(){
 		return grid;
 	}
 	function addsignatoryRow() {
 		var grid = mini.get("signatorygrid");
		mini.open({
    		ShowModal:false,
    		showCloseButton:true,
    		showMaxButton:true,
            url: getRootPath()+"/workflow/forms/contract_nocar/contract_approval/add_contract_signatory.bi?opertype=add",
            title: "增加", width: 800, height: 300,
            onload: function () {
            	
            },
            ondestroy: function (action) {
            	if("savesuccess" == action){
            		var iframe = this.getIFrameEl();
                    var data = iframe.contentWindow.getData();
            		data = mini.clone(data);
            		if (data) {
            			grid.addRow(data,0);
            		}
            	}
            }
        });
	}
 	function updatesignatoryRow() {
 		//获取选中行、并判断
 		var grid = mini.get("signatorygrid");
    	var row = grid.getSelected();
        if (row) {
        	mini.open({
        		ShowModal:false,
        		showCloseButton:true,
        		showMaxButton:true,
                url: getRootPath()+"/workflow/forms/contract_nocar/contract_approval/add_contract_signatory.bi?opertype=add",
                title: "修改", width: 800, height: 300,
                onload: function () {
                	var iframe = this.getIFrameEl();
                    iframe.contentWindow.SetData(row);
                },
                ondestroy: function (action) {
                	if("savesuccess" == action){
                		var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.getData();
                        data = mini.clone(data);
                		if (data) {
                			grid.addRow(data,grid.indexOf(row));
                			grid.removeRow(row);
                		}
                	}
                }
            });
        } else {
            alert("请选中一条记录");
        }
	}
	function removesignatoryRow() {
		var signatorygrid = $mini("signatorygrid");
	    var rows = signatorygrid.getSelecteds();
	    if (rows.length > 0) {
	    	signatorygrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
	
</script>