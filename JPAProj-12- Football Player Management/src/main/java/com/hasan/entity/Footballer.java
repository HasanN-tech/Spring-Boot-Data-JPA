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
public class Footballer {
	@Id
	@SequenceGenerator(name = "players", sequenceName = "player_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players")
	private Long playerId;

	@NonNull
	@Column(length = 30)
	private String playerName;

	@NonNull
	@Column(length = 20)
	private String country;

	@NonNull
	@Column(length = 20)
	private String club;

	@NonNull
	@Column(length = 20)
	private String position;

	@NonNull
	private Double salary;


	@NonNull
	private Integer jerseyNumber;

	@Version
	private Integer version;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
