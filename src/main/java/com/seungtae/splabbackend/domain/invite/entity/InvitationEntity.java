package com.seungtae.splabbackend.domain.invite.entity;


import com.seungtae.splabbackend.common.entity.BaseEntity;
import com.seungtae.splabbackend.domain.group.entity.GroupEntity;
import com.seungtae.splabbackend.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
@Builder
@Table(name = "invitation")
public class InvitationEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invitationId")
	private Long invitationId;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupEntity group;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private UserEntity member;

	private String message;

	private InvitaionStatus status;



}
