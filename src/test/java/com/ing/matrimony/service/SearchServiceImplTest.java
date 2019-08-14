package com.ing.matrimony.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.matrimony.entity.User;
import com.ing.matrimony.repository.ProfileRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceImplTest {

	@Mock
	ProfileRepository profileRepositoryMock;
	
	@InjectMocks
	SearchServiceImpl searchServiceImplMock;
	
	
	@Test
	public void searchTest() {
		
		List<User> userList=new ArrayList<>();
		User user=new User();
		user.setAddress("BTM");
		user.setAge(23);
		user.setDateOfBirth(LocalDate.now());
		user.setEmail("a@a.com");
		user.setFirstName("shashank");
		user.setGender("Male");
		user.setLastName("kumar");
		user.setMaritalStatus("single");
		user.setMembershipType("classic");
		user.setMobileNo("8970297757");
		user.setMotherTongue("hindi");
		user.setPassword("ok");
		user.setUserId(1L);
		userList.add(user);
		
		when(profileRepositoryMock.findByAgeRangeAndGender(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenReturn(userList);
		
		List<User> userListActual=searchServiceImplMock.search(20, 27, "male");
		
        assertEquals(1, userListActual.size());
	
	}

}
