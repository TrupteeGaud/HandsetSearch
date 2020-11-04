package com.axiom.mobile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Builder;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.axiom.mobile.dto.Handset;
import com.axiom.mobile.repo.HandsetRepository;
import com.axiom.mobile.service.HandsetService;

@SpringBootTest
public class HandsetServiceTest {

	private HandsetService handsetService;
	private HandsetRepository handsetRepository = mock(HandsetRepository.class);
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.handsetService = new HandsetService(handsetRepository);
	}
	
	@Test
	public void get_by_specification_should_return_entities_list() {
		// Given
		Specification querySpec = mock(Specification.class);
		
		when(handsetRepository.findAll(querySpec)).thenCallRealMethod();
		List<Handset> foundHandset = handsetService.get(querySpec);
		
		// Then
		verify(handsetRepository, times(1)).findAll(querySpec);
		assertThat("Apple").isEqualTo(foundHandset.get(0).getBrand());
	}

}
