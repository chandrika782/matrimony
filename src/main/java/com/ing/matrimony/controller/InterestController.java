package com.ing.matrimony.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.service.InvitationService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class InterestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InterestController.class);
	
	@Autowired
	private InvitationService invitationService;
	
	
	@PostMapping("/raiseInterest")
	public ResponseEntity<InvitationDto> invitation(@RequestBody InvitationRequestDto invitationRequest)
	{
		LOGGER.info("In Interest Controller");
		
		return new ResponseEntity<>(invitationService.invite(invitationRequest),HttpStatus.OK);
	}
	
	
	
}
