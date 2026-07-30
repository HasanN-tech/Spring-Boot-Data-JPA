package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Cricketer {
	@Id
	@SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
	private Long id;

	@NonNull
	@Column(length = 30)
	private String playerName;

	@NonNull
	@Column(length = 20)
	private String country;

	@NonNull
	@Column(length = 20)
	private String role;

	@NonNull
	@Column(length = 20)
	private String team;

	@NonNull
	private Double battingAverage;


	@NonNull
	private Integer matchesPlayed;

	@NonNull
	private Integer centuries;

	@NonNull
	private Integer age;

	@NonNull
	private Boolean retired;
}
