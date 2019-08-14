package com.ing.matrimony.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.matrimony.dto.ProfileResponseDto;
import com.ing.matrimony.service.LoginServiceImpl;
import com.ing.matrimony.service.ProfileService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
	@GetMapping("/myProfile/{userId}")
	
	public ResponseEntity<ProfileResponseDto> showProfile(@PathVariable Long userId)
	{
		LOGGER.info("inside MyProfile");
		ProfileResponseDto profileResponseDto=profileService.showProfile(userId);
		
		return new ResponseEntity<>(profileResponseDto,HttpStatus.OK);
	}
	

}
