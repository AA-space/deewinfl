<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!-- 隐藏域 -->
<input type="hidden" name="fund_standard_interest.id" value="${requestScope['fund_standard_interest.id'] }"/>
<table id="fund_standard_interest" cellspacing="0" cellpadding="0">
  <tr>
    <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-fund_standard_interest"></div>
      央行利率基本信息</td>
  </tr>
  <tr class="tr-fund_standard_interest tr-even">
    <td class="td-content-title">利率开始执行日期：</td>
    <td class="td-content" colspan="3"><input name="fund_standard_interest.startdate" id="fund_standard_interest.startdate" value="${requestScope['fund_standard_interest.startdate'] }"  class="td-content-input td-content-readonly"  readOnly   type="text" /></td>
    
  </tr>
  <tr class="tr-fund_standard_interest tr-odd">
  <td class="td-content-title">利息调整幅度_六月：</td>
    <td class="td-content"><input name="fund_standard_interest.ratehalf" id="fund_standard_interest.ratehalf" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_standard_interest.ratehalf']}"  ></td>
    <td class="td-content-title">利息央行基准_六月：</td>
    <td class="td-content"><input name="fund_standard_interest.baseratehalf" id = "fund_standard_interest.baseratehalf" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.baseratehalf'] }"></td>
    
  </tr>
  <tr class="tr-fund_standard_interest tr-even">
  
    <td class="td-content-title">利息调整幅度_1年：</td>
    <td class="td-content" ><input  name="fund_standard_interest.rateone" id="fund_standard_interest.rateone" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_standard_interest.rateone']}"></td>
    <td class="td-content-title">利息央行基准_1年：</td>
    <td class="td-content"><input name="fund_standard_interest.baserateone" id = "fund_standard_interest.baserateone" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.baserateone'] }"></td>
    
   
  </tr>
  <tr class="tr-fund_standard_interest tr-odd">
  
    <td class="td-content-title">利息调整幅度_3年：</td>
    <td class="td-content"><input name="fund_standard_interest.ratethree" id = "fund_standard_interest.ratethree" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.ratethree'] }"></td>
    <td class="td-content-title">利息央行基准_3年：</td>
    <td class="td-content"><input name="fund_standard_interest.baseratethree" id = "fund_standard_interest.baseratethree" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.baseratethree'] }"></td>
    
    
  </tr>
  <tr class="tr-fund_standard_interest tr-even">
   <td class="td-content-title">利息调整幅度_5年：</td>
    <td class="td-content"><input name="fund_standard_interest.ratefive" id = "fund_standard_interest.ratefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.ratefive'] }"></td>
    <td class="td-content-title">利息央行基准_5年：</td>
    <td class="td-content"><input name="fund_standard_interest.baseratefive" id = "fund_standard_interest.baseratefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.baseratefive'] }"></td>
    
  </tr>
  <tr class="tr-fund_standard_interest tr-odd">
  
    <td class="td-content-title">利息调整幅度_5年以上：</td>
    <td class="td-content"><input name="fund_standard_interest.rateabovefive" id = "fund_standard_interest.rateabovefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.rateabovefive'] }"></td>
    
    <td class="td-content-title">利息央行基准_5年以上：</td>
    <td class="td-content"><input name="fund_standard_interest.baserateabovefive" id = "fund_standard_interest.baserateabovefive" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['fund_standard_interest.baserateabovefive'] }"></td>
  </tr>
</table>
