<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
   
    <!-- 隐藏域 -->
    
         <table id="the_bank_information" cellspacing="0" cellpadding="0">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-info"></div>合同基本信息</td>
          </tr>
          <tr class="tr-contractect-info tr-even">
             <td class="td-content-title">利率开始执行日期：</td><td class="td-content"><input name="interest_rate.startdate" id="interest_rate.startdate" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['interest_rate.startdate']}"></td>
             <td class="td-content-title">利息调整幅度_六月：</td><td class="td-content"><input name="interest_rate.ratehalf" id="interest_rate.ratehalf" class="td-content-input" type="text" value="${requestScope['interest_rate.ratehalf']}" require="true" label="利息调整幅度_六月" ><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">
             <td class="td-content-title">利息调整幅度_1年：</td><td class="td-content" colspan=5><input style="width:60%" name="interest_rate.rateone" id="interest_rate.rateone" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['interest_rate.rateone']}"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-contractect-info tr-even">   
          	<td class="td-content-title">利息调整幅度_3年：</td><td class="td-content"><input name="interest_rate.ratethree" id = "interest_rate.ratethree" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.ratethree'] }"><font class="required-content">*</font></td>
             <td class="td-content-title">利息调整幅度_5年：</td><td class="td-content"><input name="interest_rate.ratefive" id = "interest_rate.ratefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.ratefive'] }"><font class="required-content">*</font></td>
         </tr>
           <tr class="tr-contractect-info tr-odd">
             <td class="td-content-title">利息调整幅度_5年以上：</td><td class="td-content"><input name="interest_rate.rateabovefive" id = "interest_rate.rateabovefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.rateabovefive'] }"></td>
             <td class="td-content-title">利息央行基准_六月：</td><td class="td-content"><input name="interest_rate.baseratehalf" id = "interest_rate.baseratehalf" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.baseratehalf'] }"></td>
          </tr>
          <tr class="tr-contractect-info tr-even">  
             <td class="td-content-title">利息央行基准_1年：</td><td class="td-content"><input name="interest_rate.baserateone" id = "interest_rate.baserateone" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.baserateone'] }"></td>
             <td class="td-content-title">利息央行基准_3年：</td><td class="td-content"><input name="interest_rate.baseratethree" id = "interest_rate.baseratethree" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.baseratethree'] }"></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">利息央行基准_5年：</td><td class="td-content"><input name="interest_rate.baseratefive" id = "interest_rate.baseratefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.baseratefive'] }"></td>
             <td class="td-content-title">利息央行基准_5年以上：</td><td class="td-content"><input name="interest_rate.baserateabovefive" id = "interest_rate.baserateabovefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.baserateabovefive'] }"></td>
         </tr>  
          <tr class="tr-contractect-info tr-even">   
             <td class="td-content-title">是否调息结束：</td><td class="td-content"><input name="interest_rate.isclose" id = "interest_rate.isclose" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.isclose'] }"></td>
             <td class="td-content-title">创建人员：</td><td class="td-content"><input name="interest_rate.creator" id = "interest_rate.creator" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['interest_rate.creator'] }"></td>
         </tr>
          <tr class="tr-contractect-info tr-odd">   
             <td class="td-content-title">创建时间：</td><td class="td-content"><input name="interest_rate.reatordate" id="interest_rate.reatordate"  label="创建时间"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" /></td>
          </tr>
        </table>
        <script language="javascript">
	        function showEwlpCustInfo(cust_id){
		    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
		    	var params = {cust_id:cust_id};
			    openFullScreenWindow(URL,params);
		    }
	        jQuery("#contract_base_info").css("width",formWidth+"px");

		    function checkContractStatus(){
				var contractStatus = $("#contract_info.projstatus").val();
				if('11' == contractStatus){
					return true;
				}else{
					alert("项目状态不正确,不可提交！");
					return false;
				}
			}
	    </script>
        