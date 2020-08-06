package com.billing;

import java.util.List;

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
	public double calculateDiscount(List<Bill> bills, Customer cust)
	{
		double discountAmt=0;
		double discountPercentage = checkCustomerBasedDiscount(cust);
		for (Bill bill : bills) {
			discountAmt += + bill.getDiscountedPrice(discountPercentage);
		}
		return Math.round(discountAmt - getDiscountBasedOnTotalAmount(discountAmt));
	}

	/*
	 * This method calculates discount based on customer type
	 */
	private double checkCustomerBasedDiscount(Customer cust) {
		if(cust.getCustomerType().equalsIgnoreCase("employee"))
			return discountProperties.getEmployee();
		else
			if(cust.getCustomerType().equalsIgnoreCase("affiliate"))
				return discountProperties.getAffiliate();
			else 
				if (cust.isAvailableForLoyaltyDiscount())
					return discountProperties.getTwoYears();

		return 0;
	}
	
	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * discountProperties.getPerhundred();
	}
}
