package com.seungtae.splabbackend.domain.invite.repository;


import com.seungtae.splabbackend.domain.invite.entity.InviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InviteRepository extends JpaRepository<InviteEntity, Long> {
}
