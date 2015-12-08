<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="申请人自然情况" showCollapseButton="true" style="width: 100%;">
	<div id="personForm">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">申请人姓名：</td><td class="td-content">
	             <input name="person.a1" id =""  class="mini-textbox" value="${requestScope['person.a1'] }">
	             </td>
	             <td class="td-content-title">性别：</td><td class="td-content">
	             		<div name="person.a2" class="mini-radiobuttonlist"
							data="[{id:'0',text:'男'},{id:'1',text:'女'}]"
							textField="text" valueField="id" 
							value="${requestScope['person.a2'] }"
							>
						</div>
	             </td>
	         </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">证件类型：</td>
	             <td class="td-content">
	             	<input id="" name="person.a3" class="mini-textbox" value="${requestScope['person.a3'] }"/>
	             </td>
	             <td class="td-content-title">证件号码：</td>
	             <td class="td-content">
		             <input name="person.a4" class="mini-textbox" value="${requestScope['person.a4'] }"/>
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">  
	             <td class="td-content-title">出生日期：</td>
	             <td class="td-content">
		             <input name="person.a5" class="mini-datepicker" value="${requestScope['person.a5'] }"/>
	             </td>
	             <td class="td-content-title">婚烟状态：</td>
	             <td class="td-content">
		             <input name="person.a6" class="mini-combobox" textField="name" 
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'marital_status'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['person.a6'] }" 
							   text="${requestScope['rawValue_person.a6']}" 
							   onvaluechanged="comboboxChanged(e)"
						/>
						<input id="rawValue_person.a6" name="rawValue_person.a6" value="${requestScope['rawValue_person.a6']}"  class="mini-textbox" style="display:none"/>
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">  
	             <td class="td-content-title">学历：</td>
	             <td class="td-content">
		             <input name="person.a7" class="mini-combobox" textField="name" 
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'school'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['person.a7'] }" 
							   text="${requestScope['rawValue_person.a7']}" 
							   onvaluechanged="comboboxChanged(e)"
						/>
						<input id="rawValue_person.a7" name="rawValue_person.a7" value="${requestScope['rawValue_person.a7']}"  class="mini-textbox" style="display:none"/>
	             </td>
	             <td class="td-content-title">户口所在地：</td>
	             <td class="td-content">
		             <input id="" name="person.a8" class="mini-textbox" value="${requestScope['person.a8'] }"/>
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">邮寄地址：</td>
	             <td class="td-content" colspan=3>
	             	<input id="" name="person.a9"  require="true" value="${requestScope['person.a9'] }" class="mini-textbox" style="width: 50%;">
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">  
	             <td class="td-content-title">手机号码：</td>
	             <td class="td-content">
		             <input id="" name="person.a10" class="mini-textbox" value="${requestScope['person.a10'] }"/>
	             </td>
	             <td class="td-content-title">电话：</td>
	             <td class="td-content">
		             <input id="" name="person.a11" class="mini-textbox" value="${requestScope['person.a11'] }"/>
	             </td>
	          </tr>
		</table>
	</div>
</div>

