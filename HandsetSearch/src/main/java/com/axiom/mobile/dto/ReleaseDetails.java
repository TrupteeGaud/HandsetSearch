package com.axiom.mobile.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReleaseDetails {

	@Id
	private String annouceDate;
	private double priceEur;
	
	public String getAnnouceDate() {
		return annouceDate;
	}
	public void setAnnouceDate(String annouceDate) {
		this.annouceDate = annouceDate;
	}
	public double getPriceEur() {
		return priceEur;
	}
	public void setPriceEur(double priceEur) {
		this.priceEur = priceEur;
	}
	
	
}
