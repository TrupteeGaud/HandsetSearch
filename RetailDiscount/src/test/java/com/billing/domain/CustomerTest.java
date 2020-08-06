package com.billing.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.billing.base.BillingSystemBuilder;
import com.billing.dto.Customer;

public class CustomerTest {
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingSystemBuilder.getAffiliateCustomer();
		Assert.assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
}
