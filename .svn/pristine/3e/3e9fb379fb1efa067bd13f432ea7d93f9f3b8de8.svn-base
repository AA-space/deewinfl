<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script language="javascript">
	var targ = false;
	jQuery(function() {
		if (isSubTable) {
			//租赁类型
			dictOnSelect('id_word_leas_form', 'contract_word.leasform',
					'leas_form',
					'${empty leas_form ? "lease_form2" : leas_form }',
					chargeTemplate, null, true, null, true, null, false);
			//合作方类型
			dictOnSelect(
					'id_word_partner_type',
					'contract_word.partner_type',
					'partner_type',
					'${empty contract_word_partner_type ? "partner_type1" : contract_word_partner_type }',
					chargeTemplate, null, true);
			//是否挂靠
			dictOnSelect(
					'id_word_car_affiliated',
					'contract_word.car_affiliated',
					'car_affiliated',
					'${empty contract_word_car_affiliated ? "" : contract_word_car_affiliated }',
					chargeTemplate, null, true);
			//是否抵押
			dictOnSelect(
					'id_word_mortgage_type',
					'contract_word.mortgage_type',
					'mortgage_type',
					'${empty contract_word_mortgage_type ? "" : contract_word_mortgage_type }',
					chargeTemplate, null, true);
			//担保类型
			dictOnSelect(
					'id_word_assurance',
					'contract_word.assurance',
					'assurance_type',
					'${empty contract_word_assurance ? "assurance_type1" : contract_word_assurance }',
					chargeTemplate, null, true);
			var contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件
			var contractEquipDatas = contractEquip.getRowsJsonData();
			var moneyTotle = 0;
			for (var i = 0; i < contractEquipDatas.length; i++) {
				moneyTotle = moneyTotle
						+ parseInt(contractEquipDatas[i].nowtotal);
			}
			$("#id_equip_money_totle").val(moneyTotle);
			if (!targ) {
				//默认为直租
				targ = true;
				//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数
				var leasform = getTracywindyObject("id_combo_id_word_leas_form")
						.getValue();
				var partner_type = getTracywindyObject(
						"id_combo_id_word_partner_type").getValue();
				var car_affiliated = getTracywindyObject(
						"id_combo_id_word_car_affiliated").getValue();
				var mortgage_type = getTracywindyObject(
						"id_combo_id_word_mortgage_type").getValue();
				var assurance = getTracywindyObject(
						"id_combo_id_word_assurance").getValue();
				var cust_class = "${requestScope['cust_info.custclass']}";
				if (cust_class = "经销商") {
					partner_type = "partner_type1";
				}
				 
				config = {
					templateDiv : 'contract_word_check_list',
					oneClassify : 'wordtempletypefirst4',
					twoClassify : 'lease_form2',
					threethClassify : partner_type,
					sixClassify : 'assurance_type1',
					changeRowNum : 3
				};
				loadTemplate(config);
			}
		}
	});
	function chargeTemplate() {
		targ = true;
		//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数
		var leasform = getTracywindyObject("id_combo_id_word_leas_form")
				.getValue();
		//合作方类型
		var partner_type = getTracywindyObject("id_combo_id_word_partner_type")
				.getValue();
		//是否挂靠
		var car_affiliated = getTracywindyObject(
				"id_combo_id_word_car_affiliated").getValue();
		//是否抵押
		var mortgage_type = getTracywindyObject(
				"id_combo_id_word_mortgage_type").getValue();
		//担保类型
		var assurance = getTracywindyObject("id_combo_id_word_assurance")
				.getValue();

		//一.抵押
		//1.选择条件为抵押时→显示所有的合同模板
		//2.选择条件为不抵押→除了抵押的合同其他都显示（排除7,7,6）
		if (mortgage_type == "mortgage_type1") {
			mortgage_type = "";
		}
		//二.挂靠
		//1.挂靠显示所有合同
		//2.不挂靠 除了挂靠的合同都显示
		if (car_affiliated == "car_affiliated1") {
			car_affiliated = "";
		}
		//三.合作方类型 下拉选项→经销商、专用车企
		//1.经销商显示经销商的所有合同
		//2.专用车企 只显示担保模式的 合同加+租赁物回购合同(专用车企业适用)合同

		//四.如果客户是法人 显示 股东会决议和董事会决议两个模板
		var cust_class = "${requestScope['cust_info.custclass']}";
		if (cust_class == "法人"&&leasform !="lease_form2") {
			cust_class = "CUST_INFO_COMPANY";
		}
		config = {
			templateDiv : 'contract_word_check_list',
			oneClassify : 'wordtempletypefirst4',
			twoClassify : leasform,
			threethClassify : partner_type,
			fourClassify : car_affiliated,
			fiveClassify : mortgage_type,
			sixClassify : assurance,
			sevenClassify : cust_class,
			changeRowNum : 3
		};
		loadTemplate(config);
	}
	function ajaxChargeTemplateCallBack(rs) {
		var svote = rs.responseText;
		svote = svote.replace(/(^\s+)|(\s+$)/g, "");
		currentDeleteFileLoadMask.hide();
		document.getElementById("contract_word_check_list").innerHTML = svote;
	}
	function createWord() {
		//在生成合同前保持数据到json
		//注分fileListTable:合同列表多行控件的ID(取这个table)
		//modename:'模板分类',第一级分类
		//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数
		var leasform = getTracywindyObject("id_combo_id_word_leas_form")
				.getValue();
		//合作方类型
		var partner_type = getTracywindyObject("id_combo_id_word_partner_type")
				.getValue();
		//是否挂靠
		var car_affiliated = getTracywindyObject(
				"id_combo_id_word_car_affiliated").getValue();
		//是否抵押
		var mortgage_type = getTracywindyObject(
				"id_combo_id_word_mortgage_type").getValue();
		//担保类型
		var assurance = getTracywindyObject("id_combo_id_word_assurance")
				.getValue();

		//合同第一步可以修改租赁物明细
		var contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件
		var contractEquipDatas = contractEquip.getRowsJsonData();
		var moneyTotle = 0;
		var equipdeliveryplace = contractEquipDatas[0].equipdeliveryplace;
		for (var i = 0; i < contractEquipDatas.length; i++) {
			moneyTotle = moneyTotle + parseInt(contractEquipDatas[i].nowtotal);
		}
		//获取页面租金计划每月租金和总租金
		var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');
		var tabledata2 = currentTable2.getRowsData();
		var sumMoney = null;
		for (var j = 0; j < tabledata2.length; j++) {
			sumMoney = sumMoney + parseFloat(tabledata2[j].rent);
		}
		var rentmoney = (sumMoney / parseInt(tabledata2.length)).toFixed(2);
		$("#id_equip_money_totle").val(moneyTotle);

		//是否上牌
		var isregistration = getTracywindyObject("id_combo_id_is_registration")
				.getRawValue();
		var isguaranty = getTracywindyObject("id_combo_id_is_guaranty")
				.getRawValue();
		if (leasform == "") {
			alert("请选择租赁物类型!");
			return false;
		}
		if (partner_type == "") {
			alert("请选择合作方类型!");
			return false;
		}
		if (car_affiliated == "") {
			alert("请选择挂靠类型!");
			return false;
		}
		if (mortgage_type == "") {
			alert("请选择抵押类型!");
			return false;
		}
		if (assurance == "") {
			alert("请选择担保类型!");
			return false;
		}
		createWordByIds({
			fileListTable : 'table_id_table_leasing_contract_list_container',
			modename : 'wordtempletypefirst4',
			'equip.equip_money_totle' : $("#id_equip_money_totle").val(),
			'json_proj_equip_str' : JsonUtil.encode(contractEquip
					.getRowsJsonData()),
			'contract_info.equipdeliveryplace' : equipdeliveryplace,
			'framework_condition.rent' : rentmoney,
			'framework_condition.renttotalmoney' : sumMoney.toFixed(2),
			'framework_condition.isregistration' : isregistration,
			'framework_condition.isguaranty' : isguaranty
		});
	}
</script>
<!-- 合同制作下拉菜单选择的值-->
<input type="hidden" id="id_equip_money_totle"
	name="equip.equip_money_totle" value="${empty equip_money_totle ? " " : equip_money_totle }"/>
<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">
		<tr class="tr-contractect-word-info tr-even">
			<td class="td-content-title">租赁类型：</td>
			<td class="td-content"><div class="leftComboContainer"
					id="id_word_leas_form"></div></td>

			<%--<td class="td-content-title">租赁物类型：</td>
		<td class="td-content"><div class="leftComboContainer" id="id_word_industry"></div></td> --%>

			<td class="td-content-title">合作方类型：</td>
			<td class="td-content"><div class="leftComboContainer"
					id="id_word_partner_type"></div></td>

			<td class="td-content-title">挂靠类型：</td>
			<td class="td-content"><div class="leftComboContainer"
					id="id_word_car_affiliated"></div></td>
			<td class="td-content-title">抵押类型：</td>
			<td class="td-content"><div class="leftComboContainer"
					id="id_word_mortgage_type"></div></td>

		</tr>
		<tr class="tr-contractect-word-info tr-even">
			<td class="td-content-title">担保类型：</td>
			<td class="td-content"><div class="leftComboContainer"
					id="id_word_assurance"></div></td>
			<td class="td-content-title" id="contract_multi_choice"><input
				id="inputCheck" type="checkbox" />全选<input id="select_reverse"
				type="checkbox" />反选</td>
		</tr>
		<tr class="tr-contractect-word-info tr-odd">
			<td class="td-content-title" id="id_contract_model">合同模板：</td>
			<td class="td-content" colspan=7><script type="text/javascript">
				//得到流程名称
				var currentWorkFlowDisplayName = "${currentWorkFlowDisplayName}";
				//得到节点名称
				var currentTaskActivityName = "${currentTaskActivityName}";
				if ((currentWorkFlowDisplayName == "合同审批流程" || currentWorkFlowDisplayName == "合同变更流程")
						&& currentTaskActivityName == "01发起") {
					$("#contract_word_check_list").show();
					$("#id_contract_model").show();
					$("#btn_create_contract").show();
					$("#contract_multi_choice").show();
				} else {
					$("#contract_word_check_list").hide();
					$("#id_contract_model").hide();
					$("#btn_create_contract").hide();
					$("#contract_multi_choice").hide();
				}
			</script>
				<div id="contract_word_check_list">
					<span>请先选择!</span>
				</div></td>
		</tr>
		<tr class="tr-contractect-word-info tr-even" id="btn_create_contract">
			<td class="td-content" colspan=8 align="right"><input
				style="margin-top: 2px; margin-bottom: 2px;" id="btn_rent_cal"
				class="btn btn-primary" type="button" value="生成合同"
				onclick="createWord()" /> <!--  <input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="合同在线编辑" onclick="openoverdue()"/> -->
			</td>
		</tr>
		<tr class="tr-contractect-word-info tr-odd">
			<td class="x-panel-table-div-title" colspan=8><div
					class="toggle-icon-expanded" title="折叠"
					toggleClass="tr-contractect-word-list"></div>合同清单</td>
		</tr>
		<tr class="tr-contractect-word-list">
			<td class="td-content" colspan=8>
				<div id="id_table_leasing_contract_list_container"
					style="overflow: hidden;">
					<jsp:include page="contract_list_info.jsp"></jsp:include><%--合同清单 --%>
				</div>
			</td>
		</tr>
	</table>
</div>