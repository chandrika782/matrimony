package com.ing.matrimony.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.matrimony.dto.ProfileResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.service.ProfileService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProfileController.class)

public class ProfileControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProfileService profileService;

	ProfileResponseDto profileResponseDto;
	User user;

	@Before
	public void setup() {
		profileResponseDto = new ProfileResponseDto();
		profileResponseDto.setAddress("kdp");
		profileResponseDto.setAge(24);
		profileResponseDto.setEducation("b.e");
		profileResponseDto.setFirstName("c");
		profileResponseDto.setLastName("r");
		profileResponseDto.setMaritalStatus("single");
		profileResponseDto.setMembershipType("classic");
		profileResponseDto.setMobileNo("13457889");
		 user=new User();
		user.setUserId(1L);
		BeanUtils.copyProperties(profileResponseDto, user);
		}

	@Test
	public void testShowProfile() throws Exception {
		Mockito.when(profileService.showProfile(Mockito.anyLong())).thenReturn(profileResponseDto);
		mockMvc.perform(MockMvcRequestBuilders.get("/matrimony/api/myProfile/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(profileResponseDto))).andReturn();
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
