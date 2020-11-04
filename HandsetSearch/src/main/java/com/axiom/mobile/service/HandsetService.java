package com.axiom.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.axiom.mobile.dto.Handset;
import com.axiom.mobile.repo.HandsetRepository;

@Service
public class HandsetService {

	HandsetRepository handsetRepository;

	@Autowired
	public HandsetService(HandsetRepository handsetRepository) {
		super();
		this.handsetRepository = handsetRepository;
	}


	public List<Handset> get(Specification<Handset> spec)
	{
		return handsetRepository.findAll(spec);
	}

	public Iterable<Handset> save(List<Handset> handsets)
	{
		return handsetRepository.saveAll(handsets);
	}


}
