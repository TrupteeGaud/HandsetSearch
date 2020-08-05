package com.billing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.billing.dto.Bill;
import com.billing.dto.Customer;

class DiscountCalculationTest {

	
	DiscountCalculation discountCal = new DiscountCalculation();
	
	@ParameterizedTest
	@CsvFileSource(resources = "/billData.csv" , numLinesToSkip=1)
	void getDiscountedAmount(double billAmt,String itemType,int custId, String customerType, int numOfYears, double expected) {
		double actualValue = discountCal.calculateDiscount(new Bill(billAmt,itemType),new Customer(custId,customerType,numOfYears));
		assertEquals(expected,actualValue);
	}

}
