package com.ing.matrimony.service;

import com.ing.matrimony.dto.UserDto;
import com.ing.matrimony.dto.UserResponseDto;

public interface UserService {

	UserResponseDto register(UserDto userDto);

}
