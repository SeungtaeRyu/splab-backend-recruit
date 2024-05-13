package com.seungtae.splabbackend.domain.user.repository;


import com.seungtae.splabbackend.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserPhone(String userPhoneList);

}
