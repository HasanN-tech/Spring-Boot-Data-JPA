package com.hasan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class HockeyPlayer {
	@Id
	@SequenceGenerator(name = "hockey_players", sequenceName = "hockey_player_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hockey_players")
	private Long playerId;

	@NonNull
	@Column(length = 30)
	private String playerName;

	@NonNull
	@Column(length = 20)
	private String teamName;
	
	@NonNull
	@Column(length = 20)
	private String country;

	@NonNull
	@Column(length = 20)
	private String role;

	@NonNull
	private Integer goals;
	
	@NonNull
	private Integer experience;

	@Version
	private Integer version;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
