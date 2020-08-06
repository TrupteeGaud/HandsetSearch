package com.billing.dto;

import java.util.Calendar;
import java.util.Date;

public class Customer {

	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
			
	private int customerId;
	private String customerType;
	private Date registrationDate;
	
	public Customer(int custId, String customerType2, Date registrationDate) {
		super();
		this.customerId=custId;
		this.customerType=customerType2;
		this.registrationDate=registrationDate;

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
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public boolean isAvailableForLoyaltyDiscount() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(registrationDate);
		cal.add(Calendar.YEAR, CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS);
		Date dateToCompare = cal.getTime();
		return registrationDate.before(dateToCompare);
	}
	
}
