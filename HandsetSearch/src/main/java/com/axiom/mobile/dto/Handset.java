package com.axiom.mobile.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Handset {

	@Id
	private int id;
	private String brand;
	private String phone;
	private String picture;;
	//private ReleaseDetails release;
	private String sim;
	private String resolution;
	//private Hardware hardware;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/*
	 * public ReleaseDetails getRelease() { return release; } public void
	 * setRelease(ReleaseDetails release) { this.release = release; }
	 */
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	/*
	 * public Hardware getHardware() { return hardware; } public void
	 * setHardware(Hardware hardware) { this.hardware = hardware; }
	 */
	
	
}
