package com.hasan.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@AllArgsConstructor
@Entity
@Table
public class GymMember {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long memberId;
	
	@Nonnull
	@Column(length=35)
	private String memberName;
	
	@Nonnull
	@Column(length=35)
	private String membershipType;
	
	@Nonnull
	private Integer duration;
	
	@Nonnull
	private Double fees;
}
