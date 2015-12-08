<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script language="javascript">
jQuery(function(){
	 var isInit=isSubTable||false;
     if(isInit==true){
    //######项目上基本信息#########
    //dict('id_repeal_reasontype','proj_info.repealreasontype','repeal_type','${requestScope["proj_info.repealreasontype"]}','${ requestScope["rawValue_proj_info.repealreason"]}','require="true" label="撤销类型"');
                                                            //放数据字典里的编号      repeal_type
    dict('id_repeal_reasontype','proj_info.repealreasontype','repeal_type','${requestScope["proj_info.repealreasontype"]}',null,'require="true" label="撤销类型"');
    }
    });

</script>
<table class="fillTable" cellspacing="0" cellpadding="0" width="50%" id="proj_cancel_info">       
  <tr class="tr-project-cancal tr-odd">   
 <td class="td-content-title">撤销时间：</td>
 <td class="td-content"><input name="proj_info.repealdate" id="id_repeal_date" class="Wdate td-content-input td-content-readonly"  
            dataType="Date" type="text" value="${requestScope['proj_info.repealdate'] }"   onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="撤销时间" /><font class="required-content">*</font></td>
 <td class="td-content-title">撤销类型：</td>
 <td class="td-content" ><div class="leftComboContainer" id="id_repeal_reasontype"></div><font class="required-content">*</font> </td>
 </tr>
<tr class="tr-project-cancal tr-even">  
<td class="td-content-title">撤销原因：</td>
<td class="td-content"  style="text-indent:0px;" colspan=3><textarea  require="true" label="撤销原因" rows="5" cols="150" style="width: 98%" name="proj_info.repealreason" id="id_repeal_reason">${requestScope['proj_info.repealreason'] }</textarea> </td>
</tr>
</table>
 	