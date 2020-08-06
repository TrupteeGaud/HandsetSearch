package com.billing.dto;

public class Bill {
	
	private Product product;
	
	private int quantity;
	
	private double totalCost;
	
	public Bill(Product product,int quantity) {
		super();
		this.product=product;
		this.quantity=quantity;
		this.totalCost = product.getPrice() * quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public double getDiscountedPrice(double discountPercentage) {
		if(product.isDiscountable() && discountPercentage != 0 ) {
			return (totalCost - totalCost * discountPercentage/100);
		}
		return totalCost;
	}
	

}
