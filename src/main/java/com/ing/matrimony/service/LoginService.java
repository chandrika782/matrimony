package com.ing.matrimony.service;

import com.ing.matrimony.dto.LoginDto;
import com.ing.matrimony.dto.LoginResponseDto;

public interface LoginService {

	LoginResponseDto login(LoginDto loginDto);

}
