<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
mini.parse();
var cust_id="<%= request.getParameter("cust_id")%>";
var param1={};
if(cust_id!="null" || cust_id==""){param1.CUST_ID=cust_id;
param1.radom=Math.random();}
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	jQuery(function(){
		
		  var editWindow = mini.get("id_detailInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable1){
			new ApTable1({
				      renderTo:'id_tableRentContainer',
                 title:'租金催收',
                width:window.formWidth||parseInt("${param1.tableWidth}")||pageWidth,
                height:200,
                id:'id_table_form',
                pageSize:10,
				    showPager:true, 
				  showFooter:false,
				    showToolbar:false,
				    hiddenQueryArea : true,
				    editFormPopupWindowWidth:580,
				    xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rentrecord_info.xml',
			        params:param1,
					//multiSelect : true,//是否可以多选，true多选，false为单选,
				   tools : [ {
				    	html:"增加",
				    	plain:true,
				    	iconCls:"icon-addnew",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
				    		var  form = new mini.Form("#id_detailInfoForm2");
				    		form.clear();
				    		 var param2={};
				    	        param2.cust_id=cust_id;
				    	        param2.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustSelect.xml';
				    	    	ajaxRequest({
				    			     url:'${pageContext.request.contextPath}/table/getTableData.action',
				    			     method:'POST',
				    			     success:function(res){
				    		   		    var scustinfo=res.responseText;
				    		   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
				    		   		    var cust=eval("("+scustinfo+")");
				    		   		    var currentRowData=cust.datas[0];
				    		   		    mini.get("id_rcustname").setValue(currentRowData.name);
				    		   		    mini.get("id_is_liaisoner").setValue("${sessionScope.loginUser.realname}");
				    		   	
				    		   		    mini.get("id_vcustid").setValue(cust_id);
				    		   		 mini.get("id_contract_info11").enable();
				    		   		    editWindow.show();
				    			     },
				    			     async:false,
				    			     failure:function(res){
				    			    	 editWindow.hide();
				    				     },
				    			     params:param2
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
				    		var  form = new mini.Form("#id_detailInfoForm2");
				    		form.clear();
				    		form.setData(selectedRowData);
				    		var data=mini.get("id_contract_info11").getData();
				    		for(var i=0;i<data.length;i++){
				    			if(selectedRowData.contractid==data[i].contractid){
				    				mini.get("id_contract_info11").select(data[i]);
				    				
				    			}
				    			
				    		}
				    		mini.get("id_contract_info11").disable();
				    		
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
									url:"${pageContext.request.contextPath}/leasing/acl/removeDunningRecord1.acl",
									data:{formData:selectedRowData.id},
									dataType:'json',
									   success: function(msg){
											mini.get("id_table_form").reload();  
									   }
									}
								); 
							}
				    }],  
				   // tools:'新增|复制|修改|删除',
				     columns:[
                     /* {type:'indexcolumn'}, */
                     {type:'checkcolumn'},
                     {header:'id',field:'id',visible:false},
                     {header:'客户id',field:'custid',visible:false},
                     {header:'客户名称',field:'custname'},
  		           // {header:'合同名',field:'contractid'},
 		            {header:'合同号',field:'contractnumber'},
 		            {header:'催款员',field:'liaisoner'},
 		            {header:'联系方式',field:'liaisonwayname'},
 		            {header:'联系日期',field:'liaisondate'},
 		            {header:'承诺还款日',field:'paydate'},
 		            {header:'承诺还款金额',field:'paymoney'},
 		            {header:'下次联系日期',field:'nextliaisondate'},
 		            {header:'联系情况',field:'liaisoninfo'},
 		            {header:'登记时间',field:'createdate'},
 		            {header:'最后修改时间',field:'modifydate'}
		  	    	    
		  		   ]
			});
			
		});
		
});
	function onClick2(e){
		  var editWindow = mini.get("id_detailInfoWindowContainer");
		  var  form = new mini.Form("#id_detailInfoForm2");
		   
		var button = e.sender;
		
		if(button.iconCls=="icon-ok"){
			 form.validate();
		       if (form.isValid() == false) 
		    	   return;   
			var data= form.getData();
			var json=mini.decode(data);
			//alert(mini.encode(json));
			var id=json.id;
			var url;
			if(""==id){
				url="${pageContext.request.contextPath}/leasing/acl/addDunningRecord1.acl";
			}else{
				url="${pageContext.request.contextPath}/leasing/acl/updateDunningRecord1.acl";
			}
		jQuery.ajax({
				url:url,
				data:{formData:encodeURI(mini.encode(json))
					//contracts:items
					},
				dataType:'json',
				   success: function(msg){
					      form.clear();
						  mini.get("id_table_form").reload();  
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
    <div id="id_tableRentContainer"></div>
       <div id="id_detailInfoWindowContainer" class="mini-window" title="租金催收" style="width:900px;padding-top:20px;" 
    showModal="true" allowResize="true" allowDrag="true">
	        <center>
	         <div id="id_detailInfoForm2" class="form" >
			        <table style="width:90%">
			       <tr style="display:none"><td>
			       <input  name="id" class="mini-hidden" /></td></tr>
			
			            <tr>
			            	<td class="input_label_desc">客户名称:  </td>  
			            	<td class="td-content" >
							<input name="custid" id="id_vcustid" class="mini-hidden" />
			            		<input name="custname" id="id_rcustname"  label="客户名称" readonly="readonly" required="true" class="mini-textbox"  type="text" /></td>	
			                <td class="input_label_desc">催款员:  </td>  
			            	<td class="td-content">
			            	<input  id="id_is_liaisoner" name="liaisoner"  label="存款人" required="true" class="mini-textbox"  type="text" /></td>			  
			            	</td>
			               </tr>
			            <tr>
			            	<td class="input_label_desc">联系方式:  </td>  
			            	<td class="td-content">
			            	<input class="mini-combobox" required="true" url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\combos\\comboDict.xml&pid=contact_type"   dataField="datas" width="167" require="true" name="liaisonway" valueField="code" textField="name"  id="id_is_liaisonway"/>
			            	</td>
			            	<td class="input_label_desc">联系日期:  </td>  
			            	<td class="td-content">
			            	<input name="liaisondate" id="liaisondate" required="true" format="yyyy-MM-dd"  label="联系日期"  class="mini-datepicker"      />
			            	<span class="content-required">*</span></td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">承诺还款日:  </td>  
			            	<td class="td-content">
			            	<input name="paydate" id="paydate"  label="承诺还款日" class="mini-datepicker" required="false"   format="yyyy-MM-dd"   /></td>
			            	<td class="input_label_desc">承诺还款金额:  </td>  
			            	<td class="td-content">
			            	   <input name="paymoney"  label="承诺还款金额" required="false" vtype="float" type="text" class="mini-textbox" />
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">下次联系日期:  </td>  
			            	<td class="td-content" >
			            	<input name="nextliaisondate" id="nextliaisondate" required="false" format="yyyy-MM-dd"  label="承诺还款日"  class="mini-datepicker"      /></td>
			           <td></td><td></td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">联系情况 :  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="liaisoninfo" require="true" required="true"  class="mini-textarea"  style="width:80%" label="联系情况"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">登记时间:  </td>  
			            	<td class="td-content" align="left" >
			            		<input name="createdate" id="createdate" label="登记时间" isDefaultDate="true"  class="mini-textbox" readOnly   type="text" /></td>
			                <td class="input_label_desc">最后修改时间:  </td>  
			            	<td class="td-content" align="left">
			            	<input name="modifydate" id="modifydate" label="登记时间" isDefaultDate="true" class="mini-textbox" readOnly   type="text" /></td>	
			            			            </tr>
                   <!--    <tr  style="display:none" id="3333">
			             <td class="input_label_desc">合同号:  </td>  
			            	<td class="td-content" colspan="2" align="left" >
              	           <input name="contractid" id="contractid" label="合同号"  class="mini-textbox" readOnly   type="text" />
              	           </td>		
              		     <td></td> 
              	       </tr>  -->
              	       
              	         <tr class="tr-even" >
			             <td class="input_label_desc"   >合同号:  </td>  
                 <td class="td-content"  >
                 <input name="contractid" id="contractid" label="合同号"  class="mini-hidden" readOnly   type="text" />
                  <div id="id_contract_info11" class="mini-listbox" style="width:300px;height:150px;" name="contractids" required="true"
                    textField="contractnumber" valueField="contractid"  dataField="datas" showCheckBox="true" multiSelect="true"
                    url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                
                </div> 
              	       
			           <%--     <tr  style="display:none" id="2222">
			             <td class="input_label_desc">合同号:  </td>  
                 <td class="td-content" colspan="2" align="left" >
                <div id="id_contract_info2" class="mini-listbox" style="width:300px;height:150px;"    name="contractids"                 
                     textField="contractnumber" valueField="contractid" dataField="datas" showCheckBox="true" multiSelect="true"  
                     url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\jsp\\fund_overduerent\\cust_contract_info.xml&cust_id=<%= request.getParameter("cust_id")%>">
                      <div property="columns">
                        <div header="合同号" field="contractid"></div>
                        <div header="合同名" field="contractnumber"></div>
                    </div>
                </div> --%>
            </td>
            <td></td>
            </tr>  
			            <tr class="content-separator">
				            <td colspan='4'>
				               <a  style="margin-left:20px;" iconCls="icon-ok" class="mini-button" onclick="onClick2"><span>确定</span></a>
						        <a  style="margin-left:20px;"  iconCls="icon-close" class="mini-button" onclick="onClick2"><span>取消</span></a>
				            </td>
			            </tr>
			
        
			        </table>
		       </div>
	        </center>
	</div>
	<script language="javascript">

</script>