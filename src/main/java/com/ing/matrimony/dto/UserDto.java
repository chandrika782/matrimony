package com.ing.matrimony.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private String firstName;
	private String lastName;
	private String mobileNo;
	private int age;
	private String email;
	private String password;
	private String confirmPassword;
	private String dateOfBirth;
	private String address;

	private String maritalStatus;
	private String gender;
	private String motherTongue;
	private String membershipType;
}
