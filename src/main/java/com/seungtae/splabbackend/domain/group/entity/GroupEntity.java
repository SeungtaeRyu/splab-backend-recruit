package com.seungtae.splabbackend.domain.group.entity;


import com.seungtae.splabbackend.common.entity.BaseEntity;
import com.seungtae.splabbackend.domain.invite.entity.InviteEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
public class GroupEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;

	private String groupName;
	private Long managerId;

	@OneToMany(mappedBy = "group")
	private List<InviteEntity> invitedMember = new ArrayList<>();
}
