<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
     <style type="text/css">
        .tabs-panels{
          border:0px solid #ddd;
        }
     </style>
     <script type="text/javascript">
     jQuery(function(){
      var isInit=isSubTable||false;
        if(isInit==true){
     //dict('id_insure_type','proj_condition.insure_type','insure_type','${requestScope["proj_condition.insure_type"]}','${requestScope["rawValue_proj_condition.insure_type"]}');
     var combo1 = new tracywindyComboBox({
 		id:'id_combo_is_before_interest',
 				renderTo:'id_is_notice_offer',
 				loadMode:'local',
 				width:165,
 			    datas:[{title:'否',name:'否'},{title:'是',name:'是'}],
 			    readOnly:true,
 			    dropListHeight:70,
 			    topAdd:0,
 		        leftAdd:0,
 		        isContainEmpty:false,
 				rawValue:'${empty requestScope["rawValue_proj_condition.is_before_interest"] ? "否" : requestScope["rawValue_proj_condition.is_before_interest"] }',
 				value:'${empty requestScope["proj_condition.is_before_interest"] ? "否" : requestScope["proj_condition.is_before_interest"] }',
 				name:'proj_condition.is_before_interest',
 				displayField:'title',
 				valueField:'name',
 				leftAdd:0,
 				onSelect:function(combo){
 					chargeBefInte();
 					}
 	});
     }});
     </script>
	<table class="fillTable" cellspacing="0" cellpadding="0">
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-condition"></div>付款通知书是否提供</td>
          </tr>
                
          <tr class="tr-project-condition tr-odd">
             
             <td class="td-content-title">通知书是否提供：</td><td class="td-content"><div id="id_is_notice_offer"></div></td>
           
          </tr>
                          
	</table>
</div>