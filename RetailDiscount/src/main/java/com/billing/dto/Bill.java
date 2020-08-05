package com.billing.dto;

public class Bill {
	
	private double totalAmount;
	private String itemTypes;
	
	public Bill(double billAmt, String itemType) {
		super();
		setTotalAmount(billAmt);
		setItemTypes(itemType);
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getItemTypes() {
		return itemTypes;
	}
	public void setItemTypes(String itemTypes) {
		this.itemTypes = itemTypes;
	}
	
	

}
