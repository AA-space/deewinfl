<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	mini.parse();
	var cust_id="<%= request.getParameter("cust_id")%>";
	var param5={};
	if(cust_id!="null" || cust_id=="")
	{
		param5.CUST_ID=cust_id;
		param5.radom=Math.random();
	}
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		var editWindow = mini.get("id_contractStatusInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable3){
			new ApTable3({
				renderTo:'id_tableContractStatusContainer',
                title:'法务合同状态调整',
                width:window.formWidth||parseInt("${param5.tableWidth}")||pageWidth,
                height:200,
                id:'id_contract_status_table_form',
                pageSize:10,
				showPager:true, 
				showFooter:false,
				showToolbar:false,
				hiddenQueryArea : true,
				editFormPopupWindowWidth:580,
				xmlFileName:'/eleasing/jsp/fund_overduerent/contractstatusadjustforupdate.xml',
			    params:param5,
				//multiSelect : true,//是否可以多选，true多选，false为单选,
			    tools : 
			    [ 
				   {
			     	html:"调整",
			    	plain:true,
			    	iconCls:"icon-edit",
			    	handler : function(miniTable, buttonText) {
			    		var editWindow = mini.get("id_contractStatusInfoWindowContainer");
			    		var selectedDataSize=miniTable.getSelecteds().length;
			    		if(0 == selectedDataSize){
							mini.alert("请选择需要修改的数据！");
							return ;
						}
						if(1 < selectedDataSize ){
							mini.alert("只能选择单条数据进行修改操作！");
							return ;
						}
			    		var selectedRowData = miniTable.getSelected ();
			    		var  form = new mini.Form("#id_detailInfoForm5");
			    		form.clear();
			    		//select();
			    		form.setData(selectedRowData);
			    		mini.get("id_contractstatus_custname").setValue(selectedRowData.custname);
			    		mini.get("id_contractStatus").setValue("LawStatuts."+selectedRowData.contractstatusvalue);
			    		var data=mini.get("id_contract_info4").getData();
			    		for(var i=0;i<data.length;i++){
			    			if(selectedRowData.contractid==data[i].contractid){
			    				mini.get("id_contract_info4").select(data[i]);
			    			}
			    		}
			    		/*  mini.get("id_contract_info4").set({
			    			readOnly:true
			    		}); */
						mini.get("id_contract_info4").disable(); 
			    		if(selectedRowData.isuse=="1"){
			    			mini.get("id_check_use").set({
			    				checked:false
			    			});
			    			mini.get("revokedate").disable();
	    		    	    mini.get("revokewhy").disable();
			    			
			    		}else if(selectedRowData.isuse=="0"){
			    			mini.get("id_check_use").set({
			    				checked:true
			    			});
			    			 mini.get("revokedate").enable();
		    		    	 mini.get("revokewhy").enable();
			    		}
			   			editWindow.show();
					}}],  
			     columns:[   
                     {type:'checkcolumn'},
                     {header:'id',field:'id',visible:false},
                     {header:'客户id',field:'custid',visible:false},
                     {header:'客户名称',field:'custname'},
  		             {header:'合同编号',field:'contractid'},
 		             {header:'合同号',field:'contractnumber'},
 		             {header:'法务合同状态',field:'contractstatus'},
 		             {header:'法务合同状态值',field:'contractstatusvalue',visible:false}
	  		   	 ]
			});
			
		});
		
	});
	function onClick5(e){
		var editWindow = mini.get("id_contractStatusInfoWindowContainer");
		var  form = new mini.Form("#id_detailInfoForm5");
		var button = e.sender;
		if(button.iconCls=="icon-ok"){
			form.validate();
		    if (form.isValid() == false)  return;
		    var id_contractStatus = mini.get("id_contractStatus");
		    id_contractStatus.setValue(id_contractStatus.getValue().replace("LawStatuts.",""));
			var data= form.getData();
			var json=mini.decode(data);
			var url="${pageContext.request.contextPath}/leasing/acl/updateContractStatusAdjust.acl";
	 	  	jQuery.ajax({
					url:url,
					data:{formData:encodeURI(mini.encode(json))
					//contracts:items
					},
					dataType:'json',
				    success: function(msg){
					      form.clear();
						  mini.get("id_contract_status_table_form").reload();  
					      editWindow.hide();
				    }
			    }
			);
		}else if(button.iconCls=="icon-close"){
		 	form.clear();
	    	editWindow.hide();
	    }
    }
</script>
<div id="id_tableContractStatusContainer"></div>
     <div id="id_contractStatusInfoWindowContainer" class="mini-window" title="风险调整" style="width:900px;padding-top:20px;" 
          showModal="true" allowResize="true" allowDrag="true">
         <center>
         	<div id="id_detailInfoForm5" class="form" >
		        <table style="width:90%">
		       		<tr style="display:none">
		       			<td><input  name="id" class="mini-hidden" /></td>
		       		</tr>
		            <tr>
		            	<td class="input_label_desc">客户名称:  </td>  
		            	<td class="td-content" >
							<input name="custid" id="id_adjust_custid" class="mini-hidden"/>
			            	<input name="custname" id="id_contractstatus_custname"  label="客户名称" required="true"  readonly="readonly"
			            	class="mini-textbox mini-form-input"  type="text" style="width:100%;"/>
		            	</td>	
		                <td class="input_label_desc">法务合同状态:  </td>  
		            	<td class="td-content">	
		            		<input class="mini-combobox mini-form-input" style="width:93%;" required="true" id="id_contractStatus" name="contractStatus" 
		            			url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\combos\\comboDict.xml&pid=LawStatuts"   
		            			dataField="datas" required="true" valueField="code" textField="name"  />
		            		<span class="content-required">*</span>
		            	</td>
		            </tr>
		            <tr>
		             	<td class="input_label_desc">合同号:  </td>  
                	 	<td class="td-content" colspan="3" align="left" >
	                		<input name="contractid" id="contractid" label="合同号"  class="mini-hidden"    type="text" />
	                 		<div id="id_contract_info4" class="mini-listbox" style="width:100%;height:150px;" name="contractids" required="true"
			                 	 textField="contractnumber" valueField="contractid"  dataField="datas" showCheckBox="true" multiSelect="true"
			                     url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
	               			</div> 
           				</td>
           			</tr> 
		            <tr class="content-separator">
			            <td colspan='4'>
			               <a  style="margin-left:20px;" iconCls="icon-ok" class="mini-button" onclick="onClick5"><span>确定</span></a>
					        <a  style="margin-left:20px;"  iconCls="icon-close" class="mini-button" onclick="onClick5"><span>取消</span></a>
			            </td>
		            </tr>
	           </table>
       	  </div>
     </center>
</div>
	
	
