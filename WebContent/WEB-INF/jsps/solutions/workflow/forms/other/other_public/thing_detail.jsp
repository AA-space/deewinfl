
<%---物件详情 ，要对照实体bean在改一下--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function validataTotalMoney(){//验证金额，add by Jason
		if(chenckCondiotn){
			//计算租赁物的总交易价格
			var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
			var data = currentTable1.tableData;
			var totalPrice = 0;
			for(var i=0;i<data.length;i++){
				totalPrice += parseFloat(data[i]['price']);
			}
			//计算商务条件的设备款
			var equipAmt = parseFloat($("#equipAmt").val());
			if(totalPrice !=  equipAmt){//如果不相等，则跳出执行
				alert("<租赁物明细>标签的合计交易价格和<拟商务条件>标签中的设备款不相等,请检查.");
				return false;
			} else{
				return true;
			}
		}else{
			alert("您修改过商务条件中的值且未进行过测算!");
			return false;
		}
	}
</script>    
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_equip_container',
	    width:formWidth,
	    isAutoHeight:true,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipname',  header:'规格/型号',nullable:false,readOnly:false},
	       {name:'model',  header:'入库时间'},
	       {name:'equipnum',  header:'已售时间',nullable:false,type:'number',defaultValue:1},
	       {name:'total',  header:'数量',nullable:false,type:'double'/*,otherAttributes:" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' "*/},
	       {name:'nowtotal',  header:'采购价',nullable:false,type:'double'},
	       {name:'price',  header:'销售价',nullable:false,type:'double'},
	       {name:'brand',  header:'差额(销售价-采购价)',nullable:false},
	       {name:'vndr', header:'购置税',nullable:false,type:'combobox',defaultRawValue:'',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       params:{
	    	   				custType:'cust_type.vndr'
				       } 
		   }},
	       {name:'manufacturer',  header:'保费',nullable:false,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			  			custType:'cust_type.manufacturer'
			       }
   			}},
	       {name:'devicetype',  header:'其他融资额',nullable:false,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'device_type'
			       } 
			}},
	       {name:'eqipid',  header:'总价格'},
	       {name:'equipdeliveryplace',  header:'制造商'},
	       {name:'equipdeliverydate',  header:'交付时间',nullable:false,type:'date'},
	       {name:'equipplace',  header:'交付地点'},
	       {name:'equipplace',  header:'设备类型'},
	       {name:'cenote', header:'备注',type:'textarea'}
	     ]
	 });
});

</script>