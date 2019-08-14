package com.ing.matrimony.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String firstName;
	private String lastName;
	private String mobileNo;
	private int age;
	private String address;
	private String education;
	private String maritalStatus;
	private String motherTongue;
	private String membershipType;

}
