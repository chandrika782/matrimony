package com.ing.matrimony.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.matrimony.dto.ProfileResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplTest {

	@InjectMocks
	ProfileServiceimpl profileServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void testFindUserById() {
		User user = new User();
		user.setFirstName("Chandu");
		user.setUserId(1l);
		when(userRepository.findByUserId(user.getUserId())).thenReturn(user);
		ProfileResponseDto profileResponseDto = profileServiceImpl.showProfile(1l);
		Assert.assertEquals(user.getFirstName(), profileResponseDto.getFirstName());
	}
}
