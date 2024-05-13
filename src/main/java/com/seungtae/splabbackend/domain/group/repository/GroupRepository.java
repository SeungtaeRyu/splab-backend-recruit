package com.seungtae.splabbackend.domain.group.repository;


import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
