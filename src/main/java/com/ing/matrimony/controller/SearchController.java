package com.ing.matrimony.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.matrimony.dto.SearchResponseDTO;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.exception.ValidAgeValidator;
import com.ing.matrimony.service.SearchService;


@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
@RequestMapping("/api")
public class SearchController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
	
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search/{fromAge}/{toAge}/{gender}")
	public ResponseEntity<SearchResponseDTO> search(@PathVariable int fromAge,@PathVariable int toAge,@PathVariable String gender)
	{
		SearchResponseDTO searchResponseDTO=new SearchResponseDTO();
		LOGGER.info("In SearchController search()");
		List<User> searchList=searchService.search(fromAge, toAge, gender);
		if(searchList.size()>0)
		{
		searchResponseDTO.setStatusCode(200);
		searchResponseDTO.setUser(searchList);
		}
		else
		{
			
				throw new ValidAgeValidator();
		
		}
		return new ResponseEntity<>(searchResponseDTO,HttpStatus.OK);
	}
	

}
