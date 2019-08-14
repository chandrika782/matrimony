package com.ing.matrimony.dto;

import java.util.List;

import com.ing.matrimony.entity.User;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SearchResponseDTO {
	
	private int statusCode;
	private List<User> user;

}
