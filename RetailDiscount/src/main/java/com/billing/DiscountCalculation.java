package com.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.config.DiscountProperties;
import com.billing.dto.Bill;
import com.billing.dto.Customer;

@Service
public class DiscountCalculation {
	
	@Autowired
	private DiscountProperties discountProperties;

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
			return billAmt * discountProperties.getEmployee();
		else
			if(cust.getCustomerType().equalsIgnoreCase("affiliate"))
				return billAmt * discountProperties.getAffiliate();
			else 
				if (cust.getNoOfYears() >= 2)
					return billAmt * discountProperties.getTwoYears();

		return 0;
	}
}
