<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
   
         <table cellspacing="0" cellpadding="0" id="cont_base_info">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-info"></div>产权转移单</td>
          </tr>
          <tr class="tr-contractect-info tr-even">
             <td class="td-content-title">合同编号：</td><td class="td-content"><input name="contract_equip.contractid" class="td-content-input " readOnly type="text" value="${requestScope['contract_equip.contractid']}"></td>
             <td class="td-content-title">已付款金额：</td><td class="td-content"><input name="contract_devolution.payedmoney" class="td-content-input" type="text" value="${requestScope['contract_devolution.payedmoney']}" > </td>
         </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">设备编号：</td><td class="td-content"><input name="contract_equip.eqipid" class="td-content-input " readOnly  type="text" value="${requestScope['contract_equip.eqipid'] }" ></td>
             <td class="td-content-title">名称：</td><td class="td-content"><input name="contract_equip.eqipname"  class="td-content-input " readOnly  type="text"  value="${requestScope['contract_equip.eqipname'] }"></td>
         </tr>
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">型号：</td><td class="td-content"><input name="contract_equip.model" class="td-content-input " readOnly  type="text" value="${requestScope['contract_equip.model'] }" ></td>
             <td class="td-content-title">计量单位：</td><td class="td-content"><input name="equip_model.unit" class="td-content-input " readOnly  type="text"  value="${requestScope['equip_model.unit'] }"></td>
         </tr>
         <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">数量：</td><td class="td-content"><input name="contract_equip.equipnum" class="td-content-input " readOnly  type="text" value="${requestScope['contract_equip.equipnum'] }" ></td>
             <td class="td-content-title">单价：</td><td class="td-content"><input name="contract_equip.price" class="td-content-input " readOnly  type="text"  value="${requestScope['contract_equip.price'] }"></td>
         </tr>
         <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">产地：</td><td class="td-content"><input name="contract_equip.equipplace" class="td-content-input " readOnly type="text" value="${requestScope['contract_equip.equipplace'] }" ></td>
             <td class="td-content-title">厂商：</td><td class="td-content"><input name="contract_equip.manufacturer" class="td-content-input " readOnly type="text" value="${requestScope['contract_equip.manufacturer'] }"></td>
        </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">设备状态：</td><td class="td-content"><input name="contract_equip.eqipstatus" class="td-content-input " readOnly  type="text" value="${requestScope['contract_equip.eqipstatus'] }" ></td>
              <td class="td-content-title">交付验收时间：</td><td class="td-content"><input name="contract_equip.equipdeliverydate" id="leaseAmtDate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_equip.equipdeliverydate'] }"  onclick="WdatePicker(this,{readOnly:true})" readonly/>
               </td>
         </tr>
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><input name="contract_info.projectdept" class="td-content-input " readOnly type="text" value="${requestScope['contract_info.projectdept'] }" ></td>
             <td class="td-content-title">品牌：</td><td class="td-content"><input name="contract_equip.brand" class="td-content-input " readOnly  type="text"  value="${requestScope['contract_equip.brand'] }"></td>
         </tr>
         <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">设备新旧：</td><td class="td-content"><input name="contract_devolution.oldstatus" class="td-content-input " readOnly type="text" value="${requestScope['contract_devolution.oldstatus'] }" ></td>
             <td class="td-content-title"> 发票凭证号码：</td><td class="td-content"><input name="contract_devolution.invoiceno" class="td-content-input "   readOnly  type="text"  value="${requestScope['contract_devolution.invoiceno'] }"></td>
         </tr>
         <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">设备来源：</td><td class="td-content"><input name="contract_info.projSource" class="td-content-input " readOnly type="text" value="${requestScope['contract_info.projSource'] }" > </td>
             <td class="td-content-title"> 行业类别：</td><td class="td-content"><input name="contract_info.indusrytype" class="td-content-input "     readOnly  type="text"  value="${requestScope['contract_info.indusrytype'] }"> </td>
          </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">转移价格：</td><td class="td-content"><input name="contract_end_info.endprice" id="id_endprice" class="td-content-input " readOnly require="true" label="转移价格"  type="text" value="${requestScope['contract_end_info.endprice'] }" ><font class="required-content">*</font></td>
             <td class="td-content-title"> 接收方名称：</td><td class="td-content"><input id="id_endcust" name="contract_end_info.endcust" class="td-content-input " readOnly  type="text"  require="true" label="接收方名称"  value="${requestScope['contract_end_info.endcust'] }"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-contractect-info tr-even"> 
              <td class="td-content-title">接收时间：</td><td colspan="3" class="td-content"><input name="contract_end_info.enddate" id="id_enddate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_end_info.enddate'] }"  onclick="WdatePicker(this,{readOnly:true})" dataType="Date" require="true" label="接收时间" readonly />
               <font class="required-content">*</font></td>
          </tr>  
          <!--<tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title">备注 ：</td>
             <td colspan="3"><textarea rows="10"   style="width: 98%; margin-top: 5px;margin-left: -10px;margin-button: 5px;overflow-y:scroll" id="id_cenote" name="contract_equip.cenote" >${requestScope['contract_equip.cenote']}</textarea></td>
          </tr>
        -->
        </table>
        <script type="text/javascript">
           jQuery("#contract_base_info").css("width",formWidth+"px");
        </script>