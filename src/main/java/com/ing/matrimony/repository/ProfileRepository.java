package com.ing.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.matrimony.entity.User;

@Repository
public interface ProfileRepository extends JpaRepository<User, Long> {

	@Query("select t from User t where t.age BETWEEN :from AND :to AND t.gender=:gender")
	public List<User> findByAgeRangeAndGender( @Param("from") Integer from, @Param("to") Integer to, @Param("gender") String gender);
	
	
}


