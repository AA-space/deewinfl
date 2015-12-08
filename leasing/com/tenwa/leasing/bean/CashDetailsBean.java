package com.tenwa.leasing.bean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 现金流明细bean)
 */
public class CashDetailsBean {

	private String	contract_id="";		// 合同号
	private String	plan_date="";			// 日期
	private String	fund_in="0";			// 流入量

	private String	fund_in_details="";	// 流入量清单
	private String	fund_out="0";			// 流出量
	private String	fund_out_details="";	// 流出量清单
	private String	net_flow="0";			// 净流量
	private String	quot_id="0";			// 净流量


	public String getQuot_id() {
		return quot_id;
	}


	public void setQuot_id(String quot_id) {
		this.quot_id = quot_id;
	}


	public CashDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CashDetailsBean(String contract_id, String plan_date, String fund_in, String fund_in_details, String fund_out, String fund_out_details, String net_flow, String quot_id) {
		super();
		this.contract_id = contract_id;
		this.plan_date = plan_date;
		this.fund_in = fund_in;
		this.fund_in_details = fund_in_details;
		this.fund_out = fund_out;
		this.fund_out_details = fund_out_details;
		this.net_flow = net_flow;
		this.quot_id = quot_id;
	}


	public String getContract_id() {
		return contract_id;
	}


	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}


	public String getFund_in() {
		return fund_in;
	}


	public void setFund_in(String fund_in) {
		this.fund_in = fund_in;
	}


	public String getFund_in_details() {
		return fund_in_details;
	}


	public void setFund_in_details(String fund_in_details) {
		this.fund_in_details = fund_in_details;
	}


	public String getFund_out() {
		return fund_out;
	}


	public void setFund_out(String fund_out) {
		this.fund_out = fund_out;
	}


	public String getFund_out_details() {
		return fund_out_details;
	}


	public void setFund_out_details(String fund_out_details) {
		this.fund_out_details = fund_out_details;
	}


	public String getNet_flow() {
		return net_flow;
	}


	public void setNet_flow(String net_flow) {
		this.net_flow = net_flow;
	}


	public String getPlan_date() {
		return plan_date;
	}


	public void setPlan_date(String plan_date) {
		this.plan_date = plan_date;
	}

}
