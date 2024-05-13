package com.seungtae.splabbackend.domain.group.service;


import com.seungtae.splabbackend.domain.group.dto.request.GroupCreateRequestDto;
import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import com.seungtae.splabbackend.domain.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

	private final GroupRepository groupRepository;

	public Long create(GroupCreateRequestDto groupCreateRequestDto) {
		GroupEntity group = GroupEntity.builder()
			.managerId(groupCreateRequestDto.getUser())
			.groupName(groupCreateRequestDto.getGroupName())
			.build();
		GroupEntity saved = groupRepository.save(group);
		return saved.getGroupId();
	}

}
