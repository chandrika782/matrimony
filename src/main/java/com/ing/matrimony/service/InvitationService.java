package com.ing.matrimony.service;

import com.ing.matrimony.dto.InvitationDto;
import com.ing.matrimony.dto.InvitationRequestDto;

public interface InvitationService {

	public InvitationDto invite(InvitationRequestDto invitationDto);
}
