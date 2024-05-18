package com.seungtae.splabbackend.domain.user.service;


import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import com.seungtae.splabbackend.domain.group.repository.GroupRepository;
import com.seungtae.splabbackend.domain.invite.entity.InvitationEntity;
import com.seungtae.splabbackend.domain.invite.repository.InvitationRepository;
import com.seungtae.splabbackend.domain.user.dto.request.InviteMemberRequestDto;
import com.seungtae.splabbackend.domain.user.dto.request.MemberDto;
import com.seungtae.splabbackend.domain.user.dto.request.UserCreateRequestDto;
import com.seungtae.splabbackend.domain.user.dto.response.UserCreateResponseDto;
import com.seungtae.splabbackend.domain.user.entity.UserEntity;
import com.seungtae.splabbackend.domain.user.repository.UserRepository;
import com.seungtae.splabbackend.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.seungtae.splabbackend.domain.invite.entity.InvitaionStatus.PENDING;
import static com.seungtae.splabbackend.exception.ErrorCode.DATA_BAD_REQUEST;
import static com.seungtae.splabbackend.exception.ErrorCode.NOT_FOUND_ENTITY;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final GroupRepository groupRepository;
	private final InvitationRepository invitationRepository;

	public Boolean inviteMember(InviteMemberRequestDto memberInvitationRequestDto) {

		UserEntity manager = userRepository.findById(memberInvitationRequestDto.getManagerId()).orElseThrow(() -> {
			throw new CustomException(NOT_FOUND_ENTITY);
			}
		);

		GroupEntity group = groupRepository.findById(memberInvitationRequestDto.getGroupId()).orElseThrow(() -> {
			throw new CustomException(NOT_FOUND_ENTITY);
		});

		// 메일 발송자가 그룹매니저가 아니면 에러처리
		if (!Objects.equals(group.getManagerId(), manager.getUserId())) {
			throw new CustomException(DATA_BAD_REQUEST);
		}

		// 입력 데이터에 만족하는 유저가 없을 시 에러처리
		for(MemberDto memberDto: memberInvitationRequestDto.getMembers()) {
			UserEntity u = userRepository.findByUserPhone(memberDto.getUserPhone());
			if(!Objects.equals(u.getUserName(), memberDto.getUserName()) && !Objects.equals(u.getUserEmail(), memberDto.getUserEmail())) {
				throw new CustomException(DATA_BAD_REQUEST);
			}
		}

		// 초대장 등록
		for(MemberDto memberDto: memberInvitationRequestDto.getMembers()) {
			UserEntity member = userRepository.findByUserPhone(memberDto.getUserPhone());
			InvitationEntity invite = InvitationEntity.builder()
				.group(group)
				.member(member)
				.message(memberInvitationRequestDto.getInvitationMassage())
				.status(PENDING)
				.build();
			invitationRepository.save(invite);
		}

		/**
		 * Todo : 초대장 링크 보내기
		 */

		return true;
	}


	public UserCreateResponseDto create(UserCreateRequestDto userCreateRequestDto) {
		// 이메일 중복 검사 생략

		// 휴대폰 중복 검사 생략

		UserEntity user = UserEntity.builder()
			.userName(userCreateRequestDto.getUserName())
			.userPhone(userCreateRequestDto.getUserPhone())
			.userEmail(userCreateRequestDto.getUserEmail())
			.build();
		UserEntity saved = userRepository.save(user);
		UserCreateResponseDto userCreateResponseDto = UserCreateResponseDto.fromEntity(saved);
		return userCreateResponseDto;
	}

}
