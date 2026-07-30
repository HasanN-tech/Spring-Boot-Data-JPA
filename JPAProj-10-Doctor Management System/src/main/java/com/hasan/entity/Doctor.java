package com.hasan.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Doctor {
	@Id
	@SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
	private Long doctorId;

	@NonNull
	@Column(length = 35)
	private String doctorName;

	@NonNull
	@Column(length = 20)
	private String specialization;

	@NonNull
	@Column(length = 25)
	private String hospitalName;

	@NonNull
	@Column(length = 20)
	private String city;

	@NonNull
	private Double consultationFee;

	@NonNull
	private Integer experience;


	@NonNull
	@Column(length = 50)
	private String email;

	@Version
	private Integer version;

	@CreationTimestamp
	private LocalDate createdAt;

	@UpdateTimestamp
	private LocalDate updatedAt;
}
