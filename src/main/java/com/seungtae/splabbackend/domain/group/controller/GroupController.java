package com.seungtae.splabbackend.domain.group.controller;


import com.seungtae.splabbackend.common.dto.ResultDto;
import com.seungtae.splabbackend.domain.group.dto.request.GroupCreateRequestDto;
import com.seungtae.splabbackend.domain.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

	private final GroupService groupService;

	@PostMapping("/create")
	public ResponseEntity<ResultDto<Boolean>> create(@RequestBody GroupCreateRequestDto groupCreateRequestDto) {
		Long groupId = groupService.create(groupCreateRequestDto);
		return ResponseEntity.ok().body(ResultDto.ofSuccess());
	}
}
