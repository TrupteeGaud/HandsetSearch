package com.billing;

import com.billing.dto.Bill;
import com.billing.dto.Customer;

public class DiscountCalculation {

	/*
	 * This method calculates discount for based on various scenarios
	 */
	public double calculateDiscount(Bill bill, Customer cust)
	{
		double discountAmt=0;
		double billAmt = bill.getTotalAmount();

		try {
			if(!bill.getItemTypes().equalsIgnoreCase("groceries"))
				discountAmt = checkCustomerBasedDiscount(cust,billAmt);
			else
				discountAmt=0;
			
			if(billAmt >= 100)
			{
				discountAmt += billAmt / 20;
			}

			billAmt = billAmt - discountAmt;
		}catch (Exception e) {
			System.out.println("Error occured :" + e.getMessage());
		}
		return billAmt;
	}

	/*
	 * This method calculates discount based on customer type
	 */
	private double checkCustomerBasedDiscount(Customer cust, double billAmt) {
		if(cust.getCustomerType().equalsIgnoreCase("employee"))
			return billAmt * 0.3;
		else
			if(cust.getCustomerType().equalsIgnoreCase("affiliate"))
				return billAmt * 0.1;
			else 
				if (cust.getNoOfYears() >= 2)
					return billAmt * 0.05;

		return 0;
	}
}
