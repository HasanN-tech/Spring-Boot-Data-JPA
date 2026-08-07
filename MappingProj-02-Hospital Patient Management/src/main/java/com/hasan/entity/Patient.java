package com.hasan.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	
	@NonNull
	private String patientName;
	
	@NonNull
	private String disease;
	
	@NonNull
	private Integer age;
	
	@ManyToOne(cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	@JoinColumn(name="doctorId")
	private Doctor doctor;

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", disease=" + disease + ", age="
				+ age + "]";
	}
}
