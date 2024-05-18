package com.seungtae.splabbackend.domain.group.service;


import com.seungtae.splabbackend.domain.group.dto.request.GroupCreateRequestDto;
import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import com.seungtae.splabbackend.domain.group.repository.GroupRepository;
import com.seungtae.splabbackend.exception.CustomException;
import com.seungtae.splabbackend.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

	private final GroupRepository groupRepository;

	public Long create(GroupCreateRequestDto groupCreateRequestDto) {
		// 그룹 이름으로 이미 존재하는 그룹이 있는지 확인
		if (groupRepository.existsByGroupName(groupCreateRequestDto.getGroupName())) {
			throw new CustomException(ErrorCode.DATA_BAD_REQUEST);
		}

		GroupEntity group = GroupEntity.builder()
			.managerId(groupCreateRequestDto.getUserId())
			.groupName(groupCreateRequestDto.getGroupName())
			.build();

		group = groupRepository.save(group);
		System.out.println("group.getGroupId() = " + group.getGroupId());
		return group.getGroupId();
	}

}
