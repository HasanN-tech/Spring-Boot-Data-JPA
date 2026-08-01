package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="OTM_Doctor")
public class Doctor {
	@Id
	@SequenceGenerator(name = "doctor_otm", sequenceName = "doctor_otm", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_otm")
	private Long doctorId;
	
	@NonNull
	@Column(length = 30)
	private String doctorName;
	
	@NonNull
	@Column(length = 30)
	private String specialization;
	
	@NonNull
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	private List<Patient> patients;
}
