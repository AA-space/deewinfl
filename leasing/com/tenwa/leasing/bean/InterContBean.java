package com.tenwa.leasing.bean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息央行记录与合同相关联信息的载体)
 */
public class InterContBean {

	private String	id				= "";	//
	private String	contract_id		= "";	// 合同编号
	private String	adjust_id		= "";	// 调息id
	private String	start_list		= "";	// 调息开始期项
	private String	rate_original	= "";	// 调整前利率
	private String	rate_adjust		= "";	// 调整后利率
	private String	creator			= "";	// 登记人

	private String	old_irr			= "";	// 旧的合同irr
	private String	new_irr			= "";	// 新合同irr
	private String	old_plan_irr	= "";	// 旧会计irr
	private String	new_plan_irr	= "";	// 新会计irr
	private String	adjustDate		= "";	// 调息开始时间
	private String	measure_id		= "";	// measure_id
	


	public String getMeasure_id() {
		return measure_id;
	}


	public void setMeasure_id(String measure_id) {
		this.measure_id = measure_id;
	}


	public String getAdjustDate() {
		return adjustDate;
	}


	public void setAdjustDate(String adjustDate) {
		this.adjustDate = adjustDate;
	}


	public InterContBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAdjust_id() {
		return adjust_id;
	}


	public void setAdjust_id(String adjust_id) {
		this.adjust_id = adjust_id;
	}


	public String getContract_id() {
		return contract_id;
	}


	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNew_irr() {
		
		return new_irr.equals("")?"0":new_irr;
	}


	public void setNew_irr(String new_irr) {
		this.new_irr = new_irr;
	}


	public String getNew_plan_irr() {
		return new_plan_irr;
	}


	public void setNew_plan_irr(String new_plan_irr) {
		this.new_plan_irr = new_plan_irr;
	}


	public String getOld_irr() {
		return old_irr;
	}


	public void setOld_irr(String old_irr) {
		this.old_irr = old_irr;
	}


	public String getOld_plan_irr() {
		return old_plan_irr;
	}


	public void setOld_plan_irr(String old_plan_irr) {
		this.old_plan_irr = old_plan_irr;
	}


	public String getRate_adjust() {
		return rate_adjust;
	}


	public void setRate_adjust(String rate_adjust) {
		this.rate_adjust = rate_adjust;
	}


	public String getRate_original() {
		return rate_original;
	}


	public void setRate_original(String rate_original) {
		this.rate_original = rate_original;
	}


	public String getStart_list() {
		return start_list;
	}


	public void setStart_list(String start_list) {
		this.start_list = start_list;
	}


	public InterContBean(String id, String contract_id, String adjust_id,
			String start_list, String rate_original, String rate_adjust,
			String creator, String old_irr, String new_irr,
			String old_plan_irr, String new_plan_irr, String adjustDate) {
		super();
		this.id = id;
		this.contract_id = contract_id;
		this.adjust_id = adjust_id;
		this.start_list = start_list;
		this.rate_original = rate_original;
		this.rate_adjust = rate_adjust;
		this.creator = creator;
		this.old_irr = old_irr;
		this.new_irr = new_irr;
		this.old_plan_irr = old_plan_irr;
		this.new_plan_irr = new_plan_irr;
		this.adjustDate = adjustDate;
	}

}
