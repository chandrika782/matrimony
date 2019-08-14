package com.ing.matrimony.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.LoginDto;
import com.ing.matrimony.dto.LoginResponseDto;
import com.ing.matrimony.entity.User;

import com.ing.matrimony.exception.UserNotFoundException;
import com.ing.matrimony.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto login(LoginDto loginDto) {
		
		LOGGER.info("inside Login");
		LoginResponseDto loginResponseDto=new LoginResponseDto();
		User user = userRepository.findByMobileNoAndPassword(loginDto.getMobileNo(), loginDto.getPassword());
		if (user != null) {
			loginResponseDto.setUserId(user.getUserId());
			loginResponseDto.setMessage("Logged in Successfully");
			return loginResponseDto;
		} else {
			
			throw new UserNotFoundException();
		}

	}

	

} 
