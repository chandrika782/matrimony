package com.ing.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.matrimony.entity.Invitation;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

}
