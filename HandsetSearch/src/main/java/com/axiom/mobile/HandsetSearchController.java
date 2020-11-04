package com.axiom.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.mobile.dto.Handset;
import com.axiom.mobile.repo.HandsetRepository;
import com.axiom.mobile.service.HandsetService;

import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
@RequestMapping("/search")
public class HandsetSearchController {

	private final HandsetService handsetService;
	
	
	@Autowired
	public HandsetSearchController(HandsetService handsetService)
	{
		this.handsetService=handsetService;
	}
	
	@GetMapping(value="",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Handset>> get(
			@And({ 
					@Spec(path="brand", params="brand", spec= Equal.class),
					@Spec(path="phone", params="phone", spec= Like.class),
					@Spec(path="priceEur", params="priceEur", spec= Equal.class),
					@Spec(path="resolution", params="resolution", spec= Equal.class),
					@Spec(path="audioJack", params="audioJack", spec= Equal.class),
					@Spec(path="gps", params="gps", spec= Equal.class),
					@Spec(path="battery", params="battery", spec= Like.class),
			}) Specification<Handset> spec)
	{
		List<Handset> response = handsetService.get(spec);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
