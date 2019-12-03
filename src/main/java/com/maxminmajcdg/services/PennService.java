package com.maxminmajcdg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxminmajcdg.entities.ElectionCategory;
import com.maxminmajcdg.entities.PADemographicsEntity;
import com.maxminmajcdg.entities.PennEntity;
import com.maxminmajcdg.repo.PADemographicsRepository;
import com.maxminmajcdg.repo.PAVotesCong2016Repository;
import com.maxminmajcdg.repo.PAVotesCong2018Repository;
import com.maxminmajcdg.repo.PAVotesPres2016Repository;
import com.maxminmajcdg.repo.PennRepository;

@Service
public class PennService {
	
	@Autowired
	private PennRepository pennRepository;
	
	@Autowired
	private PAVotesCong2016Repository paVotesCong2016Repository;
	
	@Autowired
	private PAVotesPres2016Repository paVotesPres2016Repository;
	
	@Autowired
	private PAVotesCong2018Repository paVotesCong2018Repository;
	
	@Autowired
	private PADemographicsRepository paDemographicsRepository;
	
	public List<PennEntity> getAllPrecincts() {
		return pennRepository.findAll();
	}

	public Optional<?> getPrecinctVoteData(ElectionCategory election, Long geomID) {
		switch(election) {
		case CONGRESSIONAL2016:
			return paVotesCong2016Repository.findById(geomID);
		case PRESIDENTIAL2016:
			return paVotesPres2016Repository.findById(geomID);
		case CONGRESSIONAL2018:
			return paVotesCong2018Repository.findById(geomID);
			default:
				return null;
		}
		
	}
	
	public Optional<?> getPrecinctDemographicData(ElectionCategory election, Long geomID) {
		switch(election) {
		case CONGRESSIONAL2016:
		case PRESIDENTIAL2016:
			return paDemographicsRepository.findById(geomID);
		case CONGRESSIONAL2018:
			return paDemographicsRepository.findById(geomID);
			default:
				return null;
		}
	}
}
