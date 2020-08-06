package com.billing.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.billing.base.BillingSystemBuilder;
import com.billing.dto.Bill;
import com.billing.dto.Product;

public class BillingTest {

	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = BillingSystemBuilder.getNonDiscountableProduct();
		Bill item = new Bill(product, 4);
		Assert.assertEquals(199.96, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Bill item = new Bill(product, 4);
		Assert.assertEquals(220.36, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = BillingSystemBuilder.getDiscountableProduct();
		Bill item = new Bill(product, 4);
		Assert.assertEquals(231.96, item.getDiscountedPrice(0), 0);
		
	}
}
