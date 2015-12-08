<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="javascript">
jQuery(function(){
  //  dict('id_mortgageitem','mortgageitem','dealer_mortgage','${requestScope["mortgageitem"]}',null,'require="true" label="活动类型"'); 
    var combo = new tracywindyComboBox({
        id:'id_combo_dealer_mortgage',
        width:400,
        renderTo:'id_mortgageitem',
        xmlFileName:'\\combos\\comboDict.xml',
        loadMode:'ajax',
        readOnly:true,
        otherAttributes:'require="true" label="活动类型"',
        value:'${requestScope["mortgageitem"]}',
        rawValue:'',
        name:'mortgageitem',
        displayField:'name',
        valueField:'code',
        isCheck:true,
        leftAdd:0,
        params:{
           pid:'dealer_mortgage'
        }
     });
    commonSelectOverall('provincename',"(select id,name from t_district where pid in('HB','DB','HD','HZ','XN','XB','HN','TQ')) rs",'id',"name",'province','${requestScope["province"]}','','require="true"  label="省份"', function(combo,data){ choseNext(combo,'id_combo_cityname','t_district');},true);//省份
	commonSelectOverall('cityname',"(select id,name from t_district where 1=1) rs",'id',"name",'city','${requestScope["city"]}','','label="城市"', function(combo,data){ choseNext(combo,'id_combo_countyname','t_district');},true);//城市
	commonSelectOverall('countyname',"(select id,name from t_district where 1=1) rs",'id',"name",'county','${requestScope["county"]}','','label="区县"',null,true);//地区
	function choseNext(parentCombo,childComboId,table){//多级联动函数
		 var parentValue = parentCombo.getValue();
		 var childCombo  = getTracywindyObject(childComboId);
		 childCombo.params['tableName'] ="(select id,name from "+table+" where pid='"+parentValue+"') rs" ;
		 childCombo.reload();
	}
});

</script>
<table cellspacing="0" cellpadding="0">
	<tr>
       <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-matter"></div>事项</td>
     </tr>
      <tr class="tr-other-matter tr-even">   
             <td class="td-content-title" style="width:17%">项目：</td>
             <td class="td-content" colspan="3">
             <div id="id_mortgageitem"></div>
             </td>
     </tr>
     <tr class="tr-other-matter tr-odd">
             <td class="td-content-title">区域：</td>
             <td class="td-content" colspan="3">
             <!-- input name="districtprovince"  type="text" value="${requestScope['districtprovince'] }">省
             <input name="districtcity"  type="text" value="${requestScope['districtcity'] }">市
             <input name="districtcounty" type="text" value="${requestScope['districtcounty'] }">区(县)-->
             <div style="float:left" class="leftComboContainer" id="provincename"></div>
             <div style="float:left" class="leftComboContainer" id="cityname"></div>
             <div style="float:left" class="leftComboContainer" id="countyname"></div>
             </td>
     </tr>
      <tr class="tr-other-matter tr-even" >   
           <td class="td-content-title" >期限：</td><td class="td-content" colspan="3"><input  name="mortgagenumber" class="td-content-input " type="text" style="width:40%" value="${requestScope['mortgagenumber'] }" require="true" label="期限"><font class="required-content">*</font></td>
     </tr>
</table>