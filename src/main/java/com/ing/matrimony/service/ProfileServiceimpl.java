package com.ing.matrimony.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.ProfileResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.exception.UserNotFoundException;
import com.ing.matrimony.repository.UserRepository;

@Service
public class ProfileServiceimpl implements ProfileService{
	@Autowired
	UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
	@Override
	public ProfileResponseDto showProfile(Long userId) {
		LOGGER.info("inside MyProfile");
		
		ProfileResponseDto profileResponseDto=new ProfileResponseDto();

		User user=userRepository.findByUserId(userId);
		if(user!=null) 
		{
			
			profileResponseDto.setAddress(user.getAddress());
			profileResponseDto.setAge(user.getAge());
			profileResponseDto.setFirstName(user.getFirstName());
			profileResponseDto.setLastName(user.getLastName());
			profileResponseDto.setMaritalStatus(user.getMaritalStatus());
			profileResponseDto.setMembershipType(user.getMembershipType());
			profileResponseDto.setMobileNo(user.getMobileNo());
			profileResponseDto.setMotherTongue(user.getMotherTongue());
		}
		else {
			
			  throw new  UserNotFoundException();
		}
		return profileResponseDto;
		}
}
