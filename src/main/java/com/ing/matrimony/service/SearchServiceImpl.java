package com.ing.matrimony.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.entity.User;
import com.ing.matrimony.repository.ProfileRepository;

@Service
public class SearchServiceImpl implements SearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public List<User> search(int fromAge, int toAge, String gender) {
		
		LOGGER.info("In SearchServiceImpl");

		List<User> searchProfiles=profileRepository.findByAgeRangeAndGender(fromAge, toAge, gender);
		
		return searchProfiles;
	}

}
