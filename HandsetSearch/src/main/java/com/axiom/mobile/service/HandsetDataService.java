package com.axiom.mobile.service;

import java.net.URI;

import org.springframework.http.HttpRequest;
import org.springframework.web.client.RestTemplate;

import com.axiom.mobile.dto.Handset;

public abstract class HandsetDataService<T> {

	private final Class<T> clazz;

	public HandsetDataService(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Class<T> getClazz() {
		return this.clazz;
	}

	public <T> T instantiateObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		return clazz.newInstance();  // use reflection to create instance
	}

	public T getHandsetData() throws IllegalAccessException, InstantiationException
	{
		T t = instantiateObject(this.clazz);
		final String uri = "https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list";
		RestTemplate restTemplate = new RestTemplate();

		 t = restTemplate.getForObject(uri, this.clazz);
		return t;  
	}
}
