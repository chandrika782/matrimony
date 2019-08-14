package com.ing.matrimony.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.UserDto;
import com.ing.matrimony.dto.UserResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.exception.MobileNumberExistException;
import com.ing.matrimony.exception.PasswordNotMatchException;
import com.ing.matrimony.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponseDto register(UserDto userDto) {
		
		LOGGER.info("In UserServiceImpl");
		User user;
		UserResponseDto userResponseDto;

		if (userDto != null) {
			if(userDto.getAge()>=18) {
			if (userDto.getPassword().equals(userDto.getConfirmPassword())) {

				user = new User();
				String birthDay = userDto.getDateOfBirth();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dob = LocalDate.parse(birthDay, formatter);

				
				user.setDateOfBirth(dob);
				List<User> listUser = userRepository.findAll();

				int count = 0;

				for (User users : listUser) {
					System.out.println("DATA" + users.getMobileNo());
					if ((users.getMobileNo().equals(userDto.getMobileNo()))) {
						count = count + 1;
					}
				}

				if (count == 0) {
					BeanUtils.copyProperties(userDto, user);
					User responseUser = userRepository.save(user);
					userResponseDto = new UserResponseDto();
					userResponseDto.setUserId(responseUser.getUserId());
					userResponseDto.setMessage("Registration Successful");
					return userResponseDto;
				} else {
					throw new MobileNumberExistException();
				}

			}
			else {
				throw new PasswordNotMatchException();
			}
			}
			else {
				return null;
			}
		} else {
			userResponseDto = new UserResponseDto();
			return userResponseDto;
		}

	}

}
