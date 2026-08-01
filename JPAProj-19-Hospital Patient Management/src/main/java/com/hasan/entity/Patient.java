package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="OTM_Patient")
public class Patient {
	@Id
	@SequenceGenerator(name = "patient_otm", sequenceName = "patient_otm", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_otm")
	private Long patientId;

	@NonNull
	@Column(length = 30)
	private String patientName;

	@NonNull
	@Column(length = 20)
	private String disease;
	
	@NonNull
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

}
