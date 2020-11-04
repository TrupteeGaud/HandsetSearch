package com.axiom.mobile.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Hardware {
	
	private String audioJack;
	private String gps;
	private String battery;
	
	public String getAudioJack() {
		return audioJack;
	}
	public void setAudioJack(String audioJack) {
		this.audioJack = audioJack;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	
	public Hardware() {}
}
