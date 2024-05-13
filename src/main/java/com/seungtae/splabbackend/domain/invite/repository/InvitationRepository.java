package com.seungtae.splabbackend.domain.invite.repository;


import com.seungtae.splabbackend.domain.invite.entity.InvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvitationRepository extends JpaRepository<InvitationEntity, Long> {
}
