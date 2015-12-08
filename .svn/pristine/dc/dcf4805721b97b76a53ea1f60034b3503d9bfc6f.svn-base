<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <input name="proj_info.custInfo" id="proj_info.custInfo" type="hidden"  value="${requestScope['proj_info.custInfo'] }"/>
    <input name="proj_info.projstatus" id="proj_info.projstatus" type="hidden"  value="${requestScope['proj_info.projstatus'] }"/>
    <input name="proj_info.custclass" id="proj_info.custclass" type="hidden"  value="${requestScope['proj_info.custclass'] }"/>
    
    <div id="form1">
    <div class="mini-panel" title="合同信息" showCollapseButton="true" style="width: 99%;">
	    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
	         <tr class="tr-project-info tr-even">
	             <td class="td-content-title">活动类型：</td>
	             <td class="td-content">
	             <input name="proj_info.dictionarydatabyprojtype"   class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="true" 
							   onenter="onenter" searchField="name"
							   onbeforeshowpopup="onbeforeshowpopup" data-options="{_params:{pid:'proj_type'}}" 
				 />
				 <font class="required-tag">*</font>
				 <input id="rawValue_proj_info.dictionarydatabyprojtype" name="rawValue_proj_info.dictionarydatabyprojtype" value="${requestScope['rawValue_proj_info.dictionarydatabyprojtype']}" class="mini-textbox" style="display:none"/>
	             </td>
	          </tr>
	</table>
	</div>
</div>
<script language="javascript">
	mini.parse();
	function onbeforeshowpopup(e) { 
// 		var event = e || window.event;  
//         var code = event.keyCode || event.which || event.charCode; 
//         alert(code);   
//         if (code == 13) { 
//             alert(1);
//         }
	   miniui_ext.onbeforeshowpopup(e);
	}
	function onenter(e){
		var sender = e.sender;
// 		if("" == sender.text) return;
// 		if("" == sender.data) return;
		var text = escape(encodeURIComponent(sender.text)); 
		sender.setUrl("<%=request.getContextPath()%>/table/getTableData.action?xmlFileName=/combos/comboDict.xml&pid=proj_type&name="+text);
	}
</script>

