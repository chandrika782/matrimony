package com.ing.matrimony.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.matrimony.service.SearchService;


@RunWith(SpringJUnit4ClassRunner.class)
public class SearchControllerTest {
	
	@Mock
	SearchService searchService;
	
	@InjectMocks
	SearchController SearchController;
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
