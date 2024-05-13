package com.seungtae.splabbackend.domain.group.dto.request;


import lombok.Data;


@Data
public class GroupCreateRequestDto {
	private Long user;
	private String groupName;
}
