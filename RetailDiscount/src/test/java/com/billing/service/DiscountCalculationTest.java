package com.billing.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.billing.DiscountCalculation;
import com.billing.base.BillingSystemBuilder;
import com.billing.dto.Bill;
import com.billing.dto.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
class DiscountCalculationTest {

	@Autowired
	private DiscountCalculation discountCal;
	
	private List<Bill> items;
	
	@BeforeEach
	void setUp() {
		items = BillingSystemBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = BillingSystemBuilder.getAffiliateCustomer();
		Assert.assertEquals(737.00, discountCal.calculateDiscount(items, affiliateCustomer), 0);
	}
	
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Customer employeeCustomer = BillingSystemBuilder.getEmployeeCustomer();
		Assert.assertEquals(626.00, discountCal.calculateDiscount(items, employeeCustomer), 0);
	}
}
