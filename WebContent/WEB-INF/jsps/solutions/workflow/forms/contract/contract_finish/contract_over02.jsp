<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
   
    
         <table cellspacing="0" cellpadding="0" id="contract_over">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-info"></div>合同结束清单</td>
          </tr>
          <tr class="tr-contractect-info tr-even">
             <td class="td-content-title">结束时间 ：</td><td class="td-content">
            
             <input name="contract_info.actualenddate" id="leaseAmtDate" class="Wdate td-content-input td-content-readonly"  
             type="text" datatype="Date" value="${requestScope['contract_info.actualenddate'] }"  onclick="WdatePicker(this,{readOnly:true})" readonly require="true" label="合同结束日期"/>
               
               <font class="required-content">*</font></td>
             <td class="td-content-title">结束类型：</td><td class="td-content"><div class="leftComboContainer" id="id_finish_type"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">结束合同的IRR ：</td><td class="td-content"><input id="actualirr" name="contract_condition.endirr" class="td-content-input td-content-readonly" readOnly require="true" label="请点击结算IRR按钮，实际IRR"  type="text" value="${requestScope['contract_condition.endirr'] }" ></td>
         </tr>
          <!--<tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title">备注 ：</td>
             <td colspan="3"><textarea rows="10"   style="width: 98%; margin-top: 5px;margin-left: -10px;margin-button: 5px;overflow-y:scroll" name="contract_end_info.endmemo" >${requestScope['contract_end_info.endmemo']}</textarea></td>
          </tr>     
        --></table>
        <script language="javascript">
    jQuery(function(){
        if(isSubTable){
          // dict('id_finish_type','','finish_type','${requestScope[""]}',null,'require="true" label="项目类型"');
           dict('id_finish_type','contract_info.endtype','finish_type','${requestScope["contract_info.endtype"]}','${requestScope["RawValue_contract_info.endtype"]}','require="true" label="结束类型"');
        }
      });
    function IRR_Calc(id){
        
    	if(!window.currentDeleteFileLoadMask)
		 {
		 window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"正在加载数据 请稍等...");
	  } 
	  window.currentDeleteFileLoadMask.show();
        var url="${pageContext.request.contextPath}/leasing/getActualIRRData.action";
        var params={};
        //alert(id);
        params["id"]=id;
        ajaxRequest({
        	 method:'POST',
        	 url:getRootPath()+url,
        	 params:params,
             success:function(res){
     	   		res=res.responseText.replace(/(^\s+)|(\s+$)/g, ""); 
         	    if(res!=''){
	  	        	 $("#actualirr").val(res); 
	  	        	jQuery("#id_workflowAdviseContainer").css("overflow","auto");
               		jQuery("#id_workflowFormContainer").css("overflow","auto");
               		window.currentDeleteFileLoadMask.hide();  
         	    }else{
         	    	jQuery("#id_workflowAdviseContainer").css("overflow","auto");
               		jQuery("#id_workflowFormContainer").css("overflow","auto");
               		window.currentDeleteFileLoadMask.hide();
         	    	alert("请求测算成功,但无结果返回,请重新尝试!");
         	    }
             },
             failure:function(res){
         		jQuery("#id_workflowAdviseContainer").css("overflow","auto");
           		jQuery("#id_workflowFormContainer").css("overflow","auto");
           		window.currentDeleteFileLoadMask.hide();
             	alert("访问服务器进行测算失败[服务器正忙,或者无法连通,或者服务器出现异常]!");
              }
        });
    	return false;
    }
    </script>
        
        