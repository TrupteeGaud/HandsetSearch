package com.axiom.mobile.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Release {
	
	private String announceDate;
	private double priceEur;
	
	
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public double getPriceEur() {
		return priceEur;
	}
	public void setPriceEur(double priceEur) {
		this.priceEur = priceEur;
	}
	
	public Release() {}
}
