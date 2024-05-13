package com.seungtae.splabbackend.domain.user.dto.request;


import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class InviteMemberRequestDto {
	private Long groupId;
	private Long managerId;
	private String invitationMassage;
	private List<MemberDto> members;
}
