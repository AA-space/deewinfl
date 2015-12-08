<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
mini.parse();
var cust_id="<%= request.getParameter("cust_id")%>";
var param3={};
if(cust_id!="null" || cust_id==""){param3.CUST_ID=cust_id;
param3.radom=Math.random();}
   // var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		 var editWindow = mini.get("id_riskInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable4){
			new ApTable4({
				      renderTo:'id_tableriskContainer11',
               title:'风险处置',
              width:window.formWidth||parseInt("${param3.tableWidth}")||pageWidth,
              height:200,
              id:'id_tablerisk',
              pageSize:10,
				    showPager:true, 
				     showFooter:false,
				    showToolbar:false,
				    hiddenQueryArea : true,
				    editFormPopupWindowWidth:580,
				    xmlFileName:'/eleasing/jsp/fund_overduerent/custriskprocess1.xml',
			      params:param3,
			      columns:[
		                    {type:'checkcolumn'},
		                        {header:'id',field:'id',visible:false},
								{header:'合同编号',field:'contractid'},
								{header:'合同号',field:'contractnumber'},
								{header:'被告人Id',field:'custid',visible:false},
								{header:'被告人',field:'custname'},
								{header:'处理方式Id',field:'lawtype',visible:false},
								{header:'处理方式',field:'lawtname'},
								{header:'处理时间',field:'lawdate'},//lawMemo
								{header:'登记人',field:'creator'},
								{header:'登记时间',field:'createdate'},
								{header:'修改人',field:'modificator'},
								{header:'修改时间',field:'modifydate'}
								
				  		   ],
				  tools : [ {
				    	html:"增加",
				    	plain:true,
				    	iconCls:"icon-addnew",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
				    		//alert("");
				    		var  form = new mini.Form("#id_detailInfoForm3");
				    		form.clear();
				    		 var param4={};
				    	        param4.cust_id=cust_id;
				    	        param4.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustSelect.xml';
				    	    	ajaxRequest({
				    			     url:'${pageContext.request.contextPath}/table/getTableData.action',
				    			     method:'POST',
				    			     success:function(res){
				    			    	 mini.parse();
				    		   		    var scustinfo=res.responseText;
				    		   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
				    		   		    var cust=eval("("+scustinfo+")");
				    		   		    var currentRowData=cust.datas[0];
				    		   		    mini.get("id_risk_custname").setValue(currentRowData.name);
				    		   		    mini.get("id_risk_cust_id").setValue(cust_id);
				    		   		 mini.get("id_contract_info2").enable();
				    		   		// alert("---");
				    		   		  editWindow.show();
				    			     },
				    			     async:false,
				    			     failure:function(res){
				    			    	 editWindow.hide();
				    				     },
				    			     params:param4
				    	    	 });
						}},'-',
						{
				    	html:"修改",
				    	plain:true,
				    	iconCls:"icon-edit",
				    	handler : function(miniTable, buttonText) {
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
				    		var  form = new mini.Form("#id_detailInfoForm3");
				    		form.clear();
				    		form.setData(selectedRowData);
				    		var data=mini.get("id_contract_info2").getData();
				    		for(var i=0;i<data.length;i++){
				    			if(selectedRowData.contractid==data[i].contractid){
				    				mini.get("id_contract_info2").select(data[i]);
				    				
				    			}
				    			
				    		}
				    		mini.get("id_contract_info2").disable();
				    		
				   			editWindow.show();
						}},'-',{
					    	html:"删除",
					    	plain:true,
					    	iconCls:"icon-remove",
					    	handler : function(miniTable, buttonText) {//按钮响应函数
					    		//alert("=====");
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
								alert(selectedRowData.id);
								jQuery.ajax({
									url:"${pageContext.request.contextPath}/leasing/acl/removeCustRiskProcess1.acl",
									data:{formData:selectedRowData.id},
									dataType:'json',
									   success: function(msg){
											mini.get("id_tablerisk").reload();  
									   }
									}
								); 
							}
				    }] 

				    
			});
			
		});
		
});

  function onClick3(e){
		// alert("===");
		  var editWindow = mini.get("id_riskInfoWindowContainer");
		var button = e.sender;
		//alert(button.iconCls);
		 var  form = new mini.Form("#id_detailInfoForm3");
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
				url="${pageContext.request.contextPath}/leasing/acl/addCustRiskProcess1.acl";
			}else{
				url="${pageContext.request.contextPath}/leasing/acl/updateCustRiskProcess1.acl";
			}
		jQuery.ajax({
				url:url,
				data:{formData:encodeURI(mini.encode(json))
					//contracts:items
					},
				dataType:'json',
				   success: function(msg){
					      form.clear();
						  mini.get("id_tablerisk").reload();  
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

 <div id="id_tableriskContainer11"></div>
<div id="id_riskInfoWindowContainer" class="mini-window" title="风险处置" style="width:900px;padding-top:20px;" 
    showModal="true" allowResize="true" allowDrag="true">
	        <center>
	         <div id="id_detailInfoForm3" class="form" >
			        <table style="width:90%">
	 	<tr>
	 	<td colspan="4">&nbsp;</td>
	 	</tr>
	 	<tr style="display:none"><td>
	 	<input name="id" class="mini-hidden" type="text" />
	 	<input name="custid" id="id_risk_cust_id" class="mini-hidden" type="text"/></td></tr>
		<tr class="tr-even">
			<td class="input_label_desc" align="left">被告人:  </td>  
           	<td class="td-content">
			    <input id="id_risk_custname" name="custname" required="true"  readonly="readonly"  label="被告人" class="mini-textbox"   /><span class="content-required">*</span></td>
			    
			<td class="input_label_desc" align="left">处理时间:</td>
			<td class="td-content">
			<input name="lawdate" id="lawdate" required="true" label="处理时间"  class="mini-datepicker"    type="text" /><span class="content-required">*</span>
			</td>
		</tr>
		<tr class="tr-odd">
			<td class="input_label_desc" align="left">采取措施详情:</td>
			<td class="td-content" colspan="3">
			<textarea rows="2" cols="95" name="lawmemo" class="mini-textarea" required="true" label="采取措施详情" style="width:84%" ></textarea><span class="content-required">*</span>
			</td>
		</tr>
		<tr class="tr-even">
		<td class="input_label_desc" align="left">处理类型:</td>
			<td class="td-content">
			<input class="mini-combobox" url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\combos\\comboDict.xml&pid=contract_risk_process_type"   dataField="datas" width="167" required="true" name="lawtype" valueField="code" textField="name"  id="id_is_lawtype"/>
			<span class="content-required">*</span>
			</td>
			<td></td>
				<td></td>
		</tr>
		<tr class="tr-even">
			<td class="input_label_desc">修改人 :  </td>  
			<td class="td-content">
			    <input name="modificator" id="modificator" label="修改人 " class="mini-textbox" readonly="readonly" type="text" />
			</td> 
			<td class="input_label_desc">修改时间</td>  
			<td class="td-content">
			    <input name="modifydate" id="modifydate" label="修改时间" class="mini-textbox"  readonly="readonly" type="text" />
	    	</td>
	    </tr>
		<!--  <tr class="tr-even" >
			             <td class="input_label_desc" colspan="2"   >合同号:  </td>  
			            	<td class="td-content" colspan="2" >
              	           <input name="contractid" id="contractid" label="合同号"  class="mini-textbox" readOnly   type="text" />
              	           </td>		
              	       </tr>  -->
			               <tr class="tr-even" >
			             <td class="input_label_desc"   >合同号:  </td>  
                 <td class="td-content"  >
                 <input name="contractid" id="contractid" label="合同号"  class="mini-hidden" readOnly    type="text" />
               <div id="id_contract_info2" class="mini-listbox" style="width:300px;height:150px;" name="contractids" required="true"
                    textField="contractnumber" valueField="contractid"  dataField="datas" showCheckBox="true" multiSelect="true"
                    url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                 <span class="content-required">*</span>
                </div>
                 
                <%-- <div id="id_contract_info2" class="mini-listbox" style="width:300px;height:150px;"    name="contractids"                 
                     textField="contractnumber" valueField="contractid" dataField="datas" showCheckBox="true" multiSelect="true"  
                     url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                      <div property="columns">
                        <div header="合同号" field="contractid"></div>
                        <div header="合同名" field="contractnumber"></div>
                    </div>
                </div> --%>
            </td>
            </tr> 
		
		<tr class="content-separator">
			<td colspan='4'>
			<a  style="margin-left:20px;" iconCls="icon-ok" class="mini-button" onclick="onClick3"><span>确定</span></a>
		<a  style="margin-left:20px;"  iconCls="icon-close" class="mini-button" onclick="onClick3"><span>取消</span></a>
			</td>                                                                                             
		</tr>
</table>
</div>
</center>
</div> 