package com.reckon.bean;

import java.math.BigDecimal;

import com.reckon.base.ReckonKey;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22下午05:59:49
 * @info 用于租金测算时的租金计划类
 * @Copyright 
 * Tenwa
 */
public class RentPlan extends ReckonKey implements Comparable<RentPlan> {

	private Integer rentList;
	private String planDate;
	private BigDecimal rent;
	private BigDecimal rentAdjust;
	private BigDecimal corpus;
	private BigDecimal interest;
	private BigDecimal corpusBusiness;
	private BigDecimal interestBusiness;
	private BigDecimal yearRate;
	private BigDecimal rentOverage;
	private BigDecimal corpusOverage;
	private BigDecimal interestOverage;
	
	public Integer getRentList() {
		return rentList;
	}

	public void setRentList(Integer rentList) {
		this.rentList = rentList;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public BigDecimal getRent() {
		return rent;
	}

	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}

	public BigDecimal getRentAdjust() {
		return rentAdjust;
	}

	public void setRentAdjust(BigDecimal rentAdjust) {
		this.rentAdjust = rentAdjust;
	}

	public BigDecimal getCorpus() {
		return corpus;
	}

	public void setCorpus(BigDecimal corpus) {
		this.corpus = corpus;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getCorpusBusiness() {
		return corpusBusiness;
	}

	public void setCorpusBusiness(BigDecimal corpusBusiness) {
		this.corpusBusiness = corpusBusiness;
	}

	public BigDecimal getInterestBusiness() {
		return interestBusiness;
	}

	public void setInterestBusiness(BigDecimal interestBusiness) {
		this.interestBusiness = interestBusiness;
	}

	public BigDecimal getYearRate() {
		return yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

	public BigDecimal getRentOverage() {
		return rentOverage;
	}

	public void setRentOverage(BigDecimal rentOverage) {
		this.rentOverage = rentOverage;
	}

	public BigDecimal getCorpusOverage() {
		return corpusOverage;
	}

	public void setCorpusOverage(BigDecimal corpusOverage) {
		this.corpusOverage = corpusOverage;
	}

	public BigDecimal getInterestOverage() {
		return interestOverage;
	}

	public void setInterestOverage(BigDecimal interestOverage) {
		this.interestOverage = interestOverage;
	}

	@Override
	public int compareTo(RentPlan o) {
		return this.getRentList().compareTo(o.getRentList());
	}
}
