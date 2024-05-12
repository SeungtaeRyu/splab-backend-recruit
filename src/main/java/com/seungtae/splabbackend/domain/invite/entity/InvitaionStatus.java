package com.seungtae.splabbackend.domain.invite.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum InvitaionStatus {
	ACVTIVATED("활성화"),
	PENDING("초대 발송 후 참여 대기");

	private final String text;
}
