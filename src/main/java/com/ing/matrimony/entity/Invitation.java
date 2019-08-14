package com.ing.matrimony.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Invitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invitationId;
	private Long senderID;
	private Long receiverId;
	private String invitationStatus;

}
