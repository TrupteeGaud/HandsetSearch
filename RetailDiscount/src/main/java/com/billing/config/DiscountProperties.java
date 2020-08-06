package com.billing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
@ConfigurationProperties
public class DiscountProperties {

	private double employee;
	
	private double affiliate;
	
	private double twoYears;
	
	private int perhundred;
	
	public double getEmployee() {
		return employee;
	}
	public void setEmployee(double employee) {
		this.employee = employee;
	}
	public double getAffiliate() {
		return affiliate;
	}
	public void setAffiliate(double affiliate) {
		this.affiliate = affiliate;
	}
	public double getTwoYears() {
		return twoYears;
	}
	public void setTwoYears(double twoYears) {
		this.twoYears = twoYears;
	}
	public int getPerhundred() {
		return perhundred;
	}
	public void setPerhundred(int perhundred) {
		this.perhundred = perhundred;
	}
	
	
	
}
