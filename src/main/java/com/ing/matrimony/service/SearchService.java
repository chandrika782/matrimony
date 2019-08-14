package com.ing.matrimony.service;

import java.util.List;

import com.ing.matrimony.entity.User;

public interface SearchService {
	
	public List<User> search(int fromAge,int toAge,String gender);

}
