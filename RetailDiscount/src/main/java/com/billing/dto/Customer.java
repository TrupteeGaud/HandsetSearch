package com.billing.dto;

public class Customer {

	private int customerId;
	private String customerType;
	private int noOfYears;
	
	public Customer(int custId, String customerType2, int numOfYears) {
		super();
		setCustomerId(custId);
		setCustomerType(customerType2);
		setNoOfYears(numOfYears);
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}
	
	
}
