package com.maxminmajcdg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxminmajcdg.entities.CADemographics2016Entity;

@Repository
public interface CADemographicsRepository extends JpaRepository<CADemographics2016Entity, Long> {
	
}
