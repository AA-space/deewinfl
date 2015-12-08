<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var cust_id="${param.cust_id}";

//var param0={};
//if(cust_id!="null" || cust_id==""){param0.CUST_ID=cust_id;}
	var constantFlagTable = "User";
	var ebankUploadUrl="";
	var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	 mini.parse();
	jQuery(function(){
		
		  var editWindow = mini.get("id_vdetailInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable0){
			new ApTable0({
				   // width:formWidth,
				    //height:formHeight,
				  //  pageSize:20,
				      renderTo:'id_tableVistContainer',
                   title:'走访记录',
                  width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
                  height:200,
                  id:'id_from_table',
                  pageSize:10,
				    showPager:true, 
				  showFooter:false,
				    showToolbar:false,
				    hiddenQueryArea : true,
				    editFormPopupWindowWidth:580,
				    xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_visitrecord_info.xml',
			        params:{CUST_ID:cust_id,
			        	//CONTRACT_ID:contract_id,
			        	radom:Math.random()},
					//multiSelect : true,//是否可以多选，true多选，false为单选,
				   tools : [ {
				    	html:"增加",
				    	plain:true,
				    	iconCls:"icon-addnew",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
				    		var  form = new mini.Form("#id_detailInfoForm11");
				    		form.clear();
				    		mini.get("id_visitcustid").setValue(cust_id);
				    		//jQuery("#id_visitcustid").val(cust_id);
				       	   	var custInfoParam = {};
				       		custInfoParam.contractid = contract_id;
				       		custInfoParam.custid = cust_id;
				       		    $.post('${pageContext.request.contextPath}/leasing/acl/getCustVisitInfo.acl?radom=' + Math.random(), custInfoParam, function(value){
				       			// var src = null;
				       			if(value.indexOf("查询失败") != -1){
				       				alert(value);
				       				return;
				       			}
				       			value = eval('(' + value + ')'); 
				       			mini.get("id_vicustname").setValue(value.custname);
   			              // mini.get("id_is_equipamt").setValue(value.equipamt);
   			              // mini.get("corpus").setValue(value.equipamt-value.incomedata);
				       			
   			                editWindow.show();	
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
				    		var  form = new mini.Form("#id_detailInfoForm11");
				    		form.clear();
				    		form.setData(selectedRowData);
				   			editWindow.show();
						}},'-',{
					    	html:"删除",
					    	plain:true,
					    	iconCls:"icon-remove",
					    	handler : function(miniTable, buttonText) {//按钮响应函数
					    		alert();
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
									url:"${pageContext.request.contextPath}/leasing/acl/removeFundOverduerent1.acl",
									data:{formData:selectedRowData.id},
									dataType:'json',
									   success: function(msg){
											mini.get("id_from_table").reload();  
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
			            {header:'走访日期',field:'contactdate'},
			           /*  {header:'合同金额(元)',field:'rent'},
			            {header:'合同余额(万元)',field:'corpus'}, */
			            {header:'走访方式',field:'contacttypename'},
			            {header:'走访方式',field:'contacttype',visible:false},
			            {header:'走访对象',field:'contactperson'},
			            {header:'客户异常',field:'custexp'},
			            {header:'客户需求',field:'custrequire'},
			            {header:'登记时间',field:'createdate'},
			            {header:'最后修改时间',field:'modifydate'}
		  		   ]
			});
			
		});
		
		
});
	function onClick(e){
		  var editWindow = mini.get("id_vdetailInfoWindowContainer");
		var button = e.sender;
		var  form = new mini.Form("#id_detailInfoForm11");
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
				url="${pageContext.request.contextPath}/leasing/acl/addFundOverduerent1.acl";
			}else{
				url="${pageContext.request.contextPath}/leasing/acl/updateFundOverduerent1.acl";
			}
		jQuery.ajax({
				url:url,
				data:{formData:encodeURI(mini.encode(json))},
				dataType:'json',
				   success: function(msg){
					   form.clear();
						  mini.get("id_from_table").reload();  
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
    <div id="id_tableVistContainer" calss="mini-datagrid"></div>
  <!--   <div id="id_vdetailInfoWindowContainer"  closed="true" modal="true" title="走访记录" style="display:none;width:900px;padding-top:20px;"> -->
	    
	       <div id="id_vdetailInfoWindowContainer" class="mini-window" title="走访记录" style="width:900px;padding-top:20px;" 
    showModal="true" allowResize="true" allowDrag="true">
        <center>
    <div id="id_detailInfoForm11" class="form" >
			        <table style="width:90%">
			            <tr style="display:none"><td><input class="mini-hidden" name="id" /></td></tr>
			            <tr>
			            	<td class="input_label_desc">客户名称:  </td>  
			            	<td class="td-content" >
			            	    <input class="mini-hidden" name="custid" id="id_visitcustid"  />
			            		<input name="custname" class="mini-textbox" id="id_vicustname"  required="true" readonly="readonly"  label="客户名称"   /><span class="content-required">*</span></td>
			                <td class="input_label_desc">走访日期:  </td>  
			            	<td class="td-content">
			            		<input name="contactdate" id="contactdate"  label="走访日期" required="true"  dateFormat="yyyy-MM-dd" class="mini-datepicker"    /><span class="content-required">*</span>
			            </tr>
			            <!-- <tr>
			            	<td class="input_label_desc">合同金额(元）:  </td>  
			            	<td class="td-content">
			            		<input id="id_is_equipamt" name="rent" label="合同金额(元）" required="true" readonly="readonly" class="mini-textbox"  /><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">合同余额(万元):  </td>  
			            	<td class="td-content">
			            	<input name="corpus" id="corpus" label="合同余额(万元)" required="true" readonly="readonly" class="mini-textbox"    /><span class="content-required">*</span>
			            	</td> 
			            </tr> -->
			            <tr>
			            	<td class="input_label_desc">走访方式:  </td>  
			            	<td class="td-content">
			            	 <input class="mini-combobox" url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\combos\\comboDict.xml&pid=contact_type"   dataField="datas" width="167" required="true" name="contacttype" valueField="code" textField="name"  id="id_is_contactType"/>
			            	<span class="content-required">*</span>
			            	<!--  <div id="id_is_contactType" class="mini-combobox" require="true" style="float:left"></div> --><font color="red">*</font>
			            	</td>
			            	<td class="input_label_desc">走访对象:  </td>  
			            	<td class="td-content">
			            	   <input name="contactperson" required="true" label="走访对象"    class="mini-textbox" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">客户异常:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="custexp" required="true"   class="mini-textarea"   style="width:84%" label="客户异常"   type="text" ></textarea><span class="content-required">*</span>
			            	
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">客户需求:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="custrequire" required="true"  class="mini-textbox"  style="width:84%" label="客户需求"   type="text" ></textarea><span class="content-required">*</span>
			            	
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">登记时间:  </td>  
			            	<td  style="float:left">
			            	<input name="createdate" id="createdate"  class="mini-textbox" label="登记时间" isDefaultDate="true"  readOnly   type="text" />
			            	</td>
			         		<td class="input_label_desc">最后修改时间:  </td>  
			            	<td  style="float:left" >
			            	<input name="modifydate" id="modifydate"  class="mini-textbox" label="登记时间" isDefaultDate="true"  readOnly   type="text" /></td>
			            </tr>
			            <tr class="content-separator">
				            <td colspan='4'>
				                 <a  style="margin-left:20px;" iconCls="icon-ok" class="mini-button" onclick="onClick"><span>确定</span></a>
						         <a  style="margin-left:20px;"  iconCls="icon-close" class="mini-button" onclick="onClick"><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
			        </div>
			        </center>
			        </div>
		        
	        
	
	<script language="javascript">
function initVisitrCustInfoName(cust_id){
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
        var param0={};
        param0.custID=cust_id;
        param0.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustSelect.xml';
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
	   		    var scustinfo=res.responseText;
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    $("#id_vcustname").val(currentRowData.name);
	   		    $("#id_vcustid").val(cust_id);
	   		   currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param0
	 });
    }
</script>