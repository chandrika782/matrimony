package com.ing.matrimony.service;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.matrimony.dto.LoginDto;
import com.ing.matrimony.dto.LoginResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.exception.UserNotFoundException;
import com.ing.matrimony.repository.UserRepository;


@RunWith(SpringRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginServiceImpl LoginServiceImpl;

	@Mock
	UserRepository userRepository ;

	LoginDto loginDto;
	LoginResponseDto loginResponseDto;
	User user;

	@Before
	public void init() {

		User user= new User();
		user.setUserId(1L);
		user.setFirstName("chandu");
		user.setLastName("raju");
		user.setAddress("kdp");
		user.setAge(23);
		
		user.setPassword("chandu12");
		user.setMobileNo("9715266407");
		user.setEmail("adfd@gmail.com");
		
		loginDto=new LoginDto();
		loginDto.setMobileNo("9715266407");
		loginDto.setPassword("chandu12");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("LOGGED IN SUCCESSFULLY");
		loginResponseDto.setUserId(user.getUserId());

	}

	@Test
	public void login() {

		Mockito.when(userRepository.findByMobileNoAndPassword(loginDto.getMobileNo(), loginDto.getPassword()))
				.thenReturn(user);
		LoginResponseDto loginResponseDto = LoginServiceImpl.login(loginDto);
		Assert.assertEquals(loginResponseDto.getUserId(),user.getUserId());

	}
}
