package com.ing.matrimony.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.service.InvitationService;


@RunWith(SpringJUnit4ClassRunner.class)
public class InterestControllerTest {

	@Mock
	InvitationService invitationService;
	
	@InjectMocks
	InterestController interestController;
	
	private MockMvc mockMvc;
	InvitationRequestDto invitationRequest;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(interestController).build();
	}
	
	
	@Test
	public void test() throws Exception {
		
		InvitationRequestDto invitationRequest=new InvitationRequestDto();
		invitationRequest.setRecieverId(1L);
		invitationRequest.setSenderId(2L);
		
		InvitationDto invitationDto=new InvitationDto();
		
		invitationDto.setMessage("invitation sent");
		invitationDto.setStatusCode(200);
		
		Mockito.when(invitationService.invite(Mockito.any())).thenReturn(invitationDto);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/raiseInterest").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(invitationRequest))).andReturn();

		ResponseEntity<InvitationDto> actual=interestController.invitation(invitationRequest);
		
		assertEquals("invitation sent", actual.getBody().getMessage());
		
		
	
	}
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
