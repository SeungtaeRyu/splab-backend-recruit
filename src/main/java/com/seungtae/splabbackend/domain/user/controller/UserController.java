package com.seungtae.splabbackend.domain.user.controller;


import com.seungtae.splabbackend.common.dto.ResultDto;
import com.seungtae.splabbackend.domain.user.dto.request.InviteMemberRequestDto;
import com.seungtae.splabbackend.domain.user.dto.request.JoinMemberRequestDto;
import com.seungtae.splabbackend.domain.user.dto.request.UserCreateRequestDto;
import com.seungtae.splabbackend.domain.user.dto.response.UserCreateResponseDto;
import com.seungtae.splabbackend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class UserController {

	private final UserService userService;


	@PostMapping("/create")
	public ResponseEntity<ResultDto<UserCreateResponseDto>> create(@RequestBody UserCreateRequestDto userCreateRequestDto) {
		UserCreateResponseDto userCreateResponseDto = userService.create(userCreateRequestDto);
		return ResponseEntity.ok().body(ResultDto.of(userCreateResponseDto));
	}

	@PostMapping("/invite")
	public ResponseEntity<ResultDto<Boolean>> inviteMember(@RequestBody InviteMemberRequestDto inviteMemberRequestDto) {
		userService.inviteMember(inviteMemberRequestDto);
		return ResponseEntity.ok().body(ResultDto.ofSuccess());
	}


	@PostMapping("/joinMember")
	public ResponseEntity<ResultDto<Boolean>> joinMember(@RequestBody JoinMemberRequestDto joinMemberRequestDto) {
		return ResponseEntity.ok().body(ResultDto.ofSuccess());
	}

}
