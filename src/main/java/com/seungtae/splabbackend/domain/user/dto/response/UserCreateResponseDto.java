package com.seungtae.splabbackend.domain.user.dto.response;


import com.seungtae.splabbackend.domain.invite.entity.InvitationEntity;
import com.seungtae.splabbackend.domain.user.entity.UserEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserCreateResponseDto {
	private final Long userId;
	private final String userName;
	private final String userPhone;
	private final String userEmail;
	private List<InvitationEntity> invitedGroups = new ArrayList<>();



	public static UserCreateResponseDto fromEntity(UserEntity user) {

		return UserCreateResponseDto.builder()
			.userId(user.getUserId())
			.userName(user.getUserName())
			.userEmail(user.getUserEmail())
			.userPhone(user.getUserPhone())
			.build();
	}
}
