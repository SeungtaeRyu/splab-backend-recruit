package com.seungtae.splabbackend.domain.user.entity;


import com.seungtae.splabbackend.common.entity.BaseEntity;
import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import com.seungtae.splabbackend.domain.invite.entity.InviteEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;
	private String userPhone;
	private String userEmail;

	@OneToMany(mappedBy = "member")
	private List<InviteEntity> invitedGroups = new ArrayList<>();
}
