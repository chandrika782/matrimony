package com.ing.matrimony.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;
import com.ing.matrimony.entity.Invitation;
import com.ing.matrimony.repository.InvitationRepository;



@RunWith(SpringJUnit4ClassRunner.class)
public class InvitationServiceImplTest {

	
	@Mock
	InvitationRepository invitationRepository;
	
	@InjectMocks
	InvitationServiceImpl invitationServiceImpl;
	
	
	@Test
	public void testInvite() {
		
		Invitation invitation=new Invitation();

		invitation.setReceiverId(1L);
		invitation.setSenderID(2L);
		invitation.setInvitationStatus("PENDING");
		InvitationRequestDto InvitationRequestDto=new InvitationRequestDto();
		InvitationRequestDto.setRecieverId(1L);
		InvitationRequestDto.setSenderId(2L);
	when(invitationRepository.save(Mockito.any())).thenReturn(invitation);
	InvitationDto InvitationDto=invitationServiceImpl.invite(InvitationRequestDto);
	
	assertEquals("invitation send", InvitationDto.getMessage());
	}

}
