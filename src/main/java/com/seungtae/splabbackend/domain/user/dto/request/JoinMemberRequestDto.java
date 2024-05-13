package com.seungtae.splabbackend.domain.user.dto.request;


import lombok.Data;


@Data
public class JoinMemberRequestDto {
	private Long groupId;
	private Long memberId;
}
