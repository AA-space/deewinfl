<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function validataTotalMoney() {//验证金额，add by Jason ###蔡雅超8-15改
		if (chenckCondiotn) {
			//计算租赁物的总交易价格
			var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
			var data = currentTable1.tableData;
			var totalPrice = 0;
			for ( var i = 0; i < data.length; i++) {
				totalPrice += parseFloat(data[i]['nowtotal']);
			}
			//计算商务条件的设备款
			var equipAmt = parseFloat($("#equipAmt").val());
			if (totalPrice != equipAmt) {//如果不相等，则跳出执行
				alert("【租赁物明细】标签的合计总价[" + totalPrice + "]和【拟商务条件】标签中的设备款[" + equipAmt + "]不相等,请检查.");
				return false;
			} else {
				return true;
			}
		} else {
			alert("您修改过商务条件中的值且未进行过测算!");
			return false;
		}
	}
</script>
<script>
function AdjustMoney(){//算出差额
	var differential_swap=$("#id_differential_swap");
	var purchaseprice=$("#id_purchaseprice").val();
	var saleprice=$("#id_saleprice").val();
	purchaseprice=purchaseprice||0;
	saleprice=saleprice||0;
	var temp=parseFloat(saleprice)-parseFloat(purchaseprice);
	$("#id_differential_swap").val(temp.toFixed(2));
}
function AdjustTotal(){//算出总价---总计[销售价+购置税+保费+其他融资额]
	var differential_swap=$("#id_nowtotal");
	var equipnum=$("#id_equipnum").val();
	var saleprice=$("#id_saleprice").val();
	var purchasetax=$("#id_purchasetax").val();
	var insuremoney=$("#id_insuremoney").val();
	var leasingmoney=$("#id_leasingmoney").val();
	equipnum=equipnum||0;
	saleprice=saleprice||0;
	purchasetax=purchasetax||0;
	insuremoney=insuremoney||0;
	leasingmoney=leasingmoney||0;
	//Edit by Jason 2013-11-23 为temp添加var 变成局部变量
	var temp=parseFloat(saleprice)*parseFloat(equipnum)+parseFloat(purchasetax)+parseFloat(insuremoney)+parseFloat(leasingmoney);
	$("#id_nowtotal").val(temp.toFixed(2));
}
var nominalPrice = $("#nominalPrice");
var liugoujiasum = 0;
jQuery(function(){
	    var currentIsNeedTools = true;
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_doc_send_info',
	    width:formWidth,
	    isAutoHeight:true,
	    isShowCopyCount:true,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    tools:'修改',
	    datas:JsonUtil.decode('${empty json_reg_list_str ? "[]" : json_reg_list_str }'),
	    columns:[
	         	   {name:'id',  header:'id',hidden:true},
	   	       {name:'docnumber',  header:'docnumber',hidden:true},
	  	       {name:'contractid',  header:'contractid',hidden:true},
	  	       {name:'docname',  header:'docname',hidden:true},
	  	       {name:'rowvalue_docname', header:'合同档案名称'},
	  	       {name:'rowvalue_doc', header:'合同档案名称code',hidden:true},
	  	       {name:'contractperson', width:70,  header:'合同对方'},
	  	       //{name:'totalprice', width:102,  header:'合同金额'},
	  	       {name:'docpart', width:70, header:'合同份数'},
	  	       {name:'contracta', width:120, header:'我方签约人'},
	  	       {name:'contractb', header:'对方签约人'},
	  	       {name:'sendpart',  header:'寄送份数',width:50},
	  	       {name:'sendno',  header:'快递单号'},
	  	       {name:'maincount',  header:'主车台数',nullable:false},
	  	       {name:'gcount',  header:'挂车台数',nullable:false},
	  	       {name:'sdy',  header:'是否抵押',nullable:false}
	  	     ]
	 });
	    
});
		

</script>
