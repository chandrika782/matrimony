package com.ing.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.matrimony.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserId(Long userId);

	public User findByMobileNoAndPassword(String mobileNo, String password);
	

}
