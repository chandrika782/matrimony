package com.ing.matrimony.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String message;
}
