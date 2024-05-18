package com.seungtae.splabbackend.domain.user.dto.request;


import lombok.Data;

@Data
public class UserCreateRequestDto {
	private String userName;
	private String userPhone;
	private String userEmail;
}
