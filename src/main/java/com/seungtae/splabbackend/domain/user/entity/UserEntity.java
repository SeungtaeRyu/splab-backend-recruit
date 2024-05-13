package com.seungtae.splabbackend.domain.user.entity;


import com.seungtae.splabbackend.common.entity.BaseEntity;
import com.seungtae.splabbackend.domain.invite.entity.InvitationEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Table(name = "users")
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;
	private String userPhone;
	private String userEmail;

	@OneToMany(mappedBy = "member")
	private List<InvitationEntity> invitedGroups = new ArrayList<>();
}
