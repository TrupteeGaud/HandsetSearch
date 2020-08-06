package com.billing.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.billing.dto.Bill;
import com.billing.dto.Customer;
import com.billing.dto.Product;

public class BillingSystemBuilder {
private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU12344345");
		product.setName("SpiderManStickers");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU99999999");
		product.setName("Oats");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		Customer customer = new Customer(101,"affiliate", new Date());
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(102,"employee", new Date());
		return customer;
	}
	
	public static Bill getItemWithDiscountableProduct(int quantity) {
		return new Bill(getDiscountableProduct(), quantity);
	}
	
	public static Bill getItemWithNonDiscountableProduct(int quantity) {
		return new Bill(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Bill> getItemListWithMultipleProducts() {
		List<Bill> items = new ArrayList<Bill>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}

}
