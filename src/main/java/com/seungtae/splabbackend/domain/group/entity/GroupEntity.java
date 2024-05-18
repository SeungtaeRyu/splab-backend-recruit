package com.seungtae.splabbackend.domain.group.entity;


import com.seungtae.splabbackend.common.entity.BaseEntity;
import com.seungtae.splabbackend.domain.invite.entity.InvitationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "team")
public class GroupEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;

	private String groupName;
	private Long managerId;

	@OneToMany(mappedBy = "group")
	private List<InvitationEntity> invitedMember = new ArrayList<>();
}
