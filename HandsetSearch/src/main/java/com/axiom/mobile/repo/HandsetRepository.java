package com.axiom.mobile.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.axiom.mobile.dto.Handset;

@Repository
public interface HandsetRepository extends PagingAndSortingRepository<Handset,String>,JpaSpecificationExecutor<Handset>{
	

}
