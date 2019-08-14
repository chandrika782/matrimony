package com.ing.matrimony.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.matrimony.dto.LoginDto;
import com.ing.matrimony.dto.LoginResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.service.LoginService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)

public class LoginControllerTest {

	
	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	LoginService loginService;

	User user;
	LoginDto loginDto;
	LoginResponseDto loginResponseDto;

	@Before
	public void init() {

		user = new User();

		loginResponseDto = new LoginResponseDto();
		 loginDto=new LoginDto();

		mockMvc = MockMvcBuilders.standaloneSetup(loginService).build();

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
 	public void login() throws Exception {
		Mockito.when(loginService.login(loginDto)).thenReturn(loginResponseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/matrimony/api/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loginResponseDto))).andReturn();

	}

}
