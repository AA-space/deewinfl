<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
mini.parse();
var cust_id="<%= request.getParameter("cust_id")%>";
var param5={};
if(cust_id!="null" || cust_id==""){param5.CUST_ID=cust_id;
param5.radom=Math.random();
}
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	jQuery(function(){
		
		  var editWindow = mini.get("id_riskAdjustInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable3){
			new ApTable3({
				      renderTo:'id_tableRiskAdjustContainer',
                 title:'风险级别调整',
                width:window.formWidth||parseInt("${param5.tableWidth}")||pageWidth,
                height:200,
                id:'id_risk_adjust_table_form',
                pageSize:10,
				    showPager:true, 
				  showFooter:false,
				    showToolbar:false,
				    hiddenQueryArea : true,
				    editFormPopupWindowWidth:580,
				    xmlFileName:'/eleasing/jsp/fund_overduerent/contractriskadjust.xml',
			        params:param5,
					//multiSelect : true,//是否可以多选，true多选，false为单选,
				   tools : [ {
				    	html:"增加",
				    	plain:true,
				    	iconCls:"icon-addnew",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
				    		var  form = new mini.Form("#id_detailInfoForm4");
				    		form.clear();
				    		 var param6={};
				    	        param6.cust_id=cust_id;
				    	        param6.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustSelect.xml';
				    	    	ajaxRequest({
				    			     url:'${pageContext.request.contextPath}/table/getTableData.action',
				    			     method:'POST',
				    			     success:function(res){
				    		   		    var scustinfo=res.responseText;
				    		   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
				    		   		    var cust=eval("("+scustinfo+")");
				    		   		    var currentRowData=cust.datas[0];
				    		   		    mini.get("id_adjust_custname").setValue(currentRowData.name);
				    		   		    //mini.get("id_adjust_custid").setValue(currentRowData.id);
				    		   		    mini.get("id_isuse").setValue("1");
				    		   		    mini.get("revokedate").disable();
				    		    	    mini.get("revokewhy").disable();
				    		    	    mini.get("id_contract_info4").enable();
				    		   		   // document.getElementById("5555").style.display="none";
				    		   		   /*  document.getElementById("222222").style.display="block";
				    		   		   document.getElementById("333333").style.display="none"; */
				    		   		var editWindow = mini.get("id_riskAdjustInfoWindowContainer");
				    		   		   editWindow.show();
				    			     },
				    			     async:false,
				    			     failure:function(res){
				    			    	 editWindow.hide();
				    				     },
				    			     params:param6
				    	    	 });
						}},'-',
						{
				    	html:"修改",
				    	plain:true,
				    	iconCls:"icon-edit",
				    	handler : function(miniTable, buttonText) {
				    		var editWindow = mini.get("id_riskAdjustInfoWindowContainer");
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
				    		var  form = new mini.Form("#id_detailInfoForm4");
				    		form.clear();
				    		//select();
				    		form.setData(selectedRowData);
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
						}},'-',{
					    	html:"删除",
					    	plain:true,
					    	iconCls:"icon-remove",
					    	handler : function(miniTable, buttonText) {//按钮响应函数
					    	//	alert("=====");
					    		 var selectedDataSize=miniTable.getSelecteds().length;
					    		if(0 == selectedDataSize){
									mini.alert("请选择需要删除的数据！");
									return ;
								}
								if(1 < selectedDataSize ){
									mini.alert("只能选择单条数据进行删除操作！");
									return ;
								}
								var selectedRowData = miniTable.getSelected ();
								jQuery.ajax({
									url:"${pageContext.request.contextPath}/leasing/acl/removeContractRiskAdjust.acl",
									data:{formData:selectedRowData.id},
									dataType:'json',
									   success: function(msg){
											mini.get("id_risk_adjust_table_form").reload();  
									   }
									}
								); 
							}
				    }],  
				     columns:[   
				              
                     {type:'checkcolumn'},
                     {header:'id',field:'id',visible:false},
                     {header:'客户id',field:'custid',visible:false},
                     {header:'客户名称',field:'custname'},
                     {header:'是否撤销',field:'isuse',visible:false},
  		            {header:'合同编号',field:'contractid'},
 		            {header:'合同号',field:'contractnumber'},
 		            {header:'调整原因',field:'adjustwhy',visible:false},
 		            {header:'调整级别',field:'adjustname'},
 		           {header:'调整级别id',field:'adjustrank',visible:false},
 		            {header:'调整日期',field:'adjustdate'},
 		            {header:'撤销原因',field:'revokewhy'},
 		            {header:'撤销时间',field:'revokedate'},
 		            {header:'创建人',field:'creator'},
 		            {header:'创建时间',field:'createdate'}
		  	    	    
		  		   ]
			});
			
		});
		
});
	function onClick4(e){
		  var editWindow = mini.get("id_riskAdjustInfoWindowContainer");
		  var  form = new mini.Form("#id_detailInfoForm4");
		var button = e.sender;
		if(button.iconCls=="icon-ok"){
			form.validate();
		    if (form.isValid() == false) 
		    return;
			var data= form.getData();
			var json=mini.decode(data);
			//alert(mini.encode(data));
			var id=json.id;
			var url;
			if(""==id){
				//if(""==json.contractids)return false;
				url="${pageContext.request.contextPath}/leasing/acl/addContractRiskAdjust.acl";
			}else{
				url="${pageContext.request.contextPath}/leasing/acl/updateContractRiskAdjust.acl";
			}
		jQuery.ajax({
				url:url,
				data:{formData:encodeURI(mini.encode(json)),cust_id:cust_id
					//contracts:items
					},
				dataType:'json',
				  success: function(msg){
					      form.clear();
						  mini.get("id_risk_adjust_table_form").reload();  
					      editWindow.hide();
				   }
				}
			);
				}else if(button.iconCls=="icon-close"){
				 form.clear();
			    editWindow.hide();
		   }
	    }
  function onValueChanged(e){
	  var checked = this.getChecked();
	//  alert(checked);
     if(checked){
    	 mini.get("id_isuse").setValue("0");
    	 //alert(document.getElementById("5555").style.display);
    	 mini.get("revokedate").enable();
    	 mini.get("revokewhy").enable();
     }else{
    	 mini.get("revokedate").setValue("");
    	 mini.get("revokewhy").setValue("");
    	 mini.get("revokedate").disable();
    	 mini.get("revokewhy").disable();
    	 mini.get("id_isuse").setValue("1");
     }
  }
</script>
    <div id="id_tableRiskAdjustContainer"></div>
       <div id="id_riskAdjustInfoWindowContainer" class="mini-window" title="风险调整" style="width:900px;padding-top:20px;" 
    showModal="true" allowResize="true" allowDrag="true">
	        <center>
	         <div id="id_detailInfoForm4" class="form" >
			        <table style="width:90%">
			       <tr style="display:none"><td>
			       <input  name="id" class="mini-hidden" />
			              
			       </td></tr>
			            <tr>
			            	<td class="input_label_desc">客户名称:  </td>  
			            	<td class="td-content" >
							
			            		<input name="custname" id="id_adjust_custname"  label="客户名称" readonly="readonly" required="true" class="mini-textbox"  type="text" /><span class="content-required">*</span></td>	
			                <td class="input_label_desc">调整级别:  </td>  
			            	<td class="td-content">
			            	<input class="mini-combobox" required="true" url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\combos\\comboDict.xml&pid=contract_risk_adjust_type"   dataField="datas" width="167" require="true" name="adjustrank" valueField="code" textField="name"  id="id_is_adjustrank"/><span class="content-required">*</span>
			            	</td>
			               </tr>
			            <tr>
			            	<td class="input_label_desc">调整原因 :  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="adjustwhy" require="true" required="true"  class="mini-textarea"  style="width:80%" label="联系情况"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">调整时间:  </td>  
			            	<td class="td-content">
			            	<input name="adjustdate" id="adjustdate"  label="调整时间" class="mini-datepicker"   required="true"    /><span class="content-required">*</span></td>
			            	<td class="input_label_desc">  </td>  
			            	<td >
			            	<input id="id_isuse" name="isuse" class="mini-hidden"/>
			            <div  class="mini-checkbox" id="id_check_use" readOnly="false" text="是否撤销" onvaluechanged="onValueChanged"></div>
			            	</td>
			            </tr>
			            
			             <tr>
			            	<td class="input_label_desc">撤销原因 :  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea id="revokewhy" name="revokewhy"  class="mini-textarea"  style="width:80%" label="联系情况"   type="text" ></textarea>
			            		<!-- <span class="content-required">*</span> -->
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">撤销时间:  </td>  
			            	<td class="td-content">
			            	<input  name="revokedate" id="revokedate"  label="撤销时间" class="mini-datepicker"       /></td>
			            	<td >
			            	</td>
			            </tr>
			        
                       <!--   <tr  style="display:none" id="333333">
			             <td class="input_label_desc">合同号:  </td>  
			            	<td class="td-content" colspan="2" align="left" >
              	          
              	           </td>		
              		     <td></td> 
              	       </tr>  -->
			               <tr  >
			             <td class="input_label_desc">合同号:  </td>  
                 <td class="td-content" colspan="2" align="left" >
               <!--    <input name="contractid" id="contractid" label="合同号"  class="mini-hidden" readOnly   type="text" /> -->
                <%-- <div id="id_contract_info4" class="mini-listbox" style="width:300px;height:150px;"    name="contractids"                 
                     textField="contractnumber" valueField="contractid" dataField="datas" showCheckBox="true" multiSelect="true"  
                     url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                      <div property="columns">
                        <div header="合同号" field="contractid"></div>
                        <div header="合同名" field="contractnumber"></div>
                    </div>
                </div> --%>
                
                 <input name="contractid" id="contractid" label="合同号"  class="mini-hidden"    type="text" />
                  <div id="id_contract_info4" class="mini-listbox" style="width:300px;height:150px;" name="contractids" required="true"
                    textField="contractnumber" valueField="contractid"  dataField="datas" showCheckBox="true" multiSelect="true"
                    url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                
                </div> 
                 
            </td>
            <td></td>
            </tr> 
			            <tr class="content-separator">
				            <td colspan='4'>
				               <a  style="margin-left:20px;" iconCls="icon-ok" class="mini-button" onclick="onClick4"><span>确定</span></a>
						        <a  style="margin-left:20px;"  iconCls="icon-close" class="mini-button" onclick="onClick4"><span>取消</span></a>
				            </td>
			            </tr>
			
        
			        </table>
		       </div>
	        </center>
	</div>
	
	
