package com.hasan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Stduent_blob")
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@SequenceGenerator(name = "std_blob", sequenceName = "std_blob", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "std_blob")
	private Integer studentId;

	@NonNull
	private String studentName;
	
	@NonNull
	private String course;
	
	@NonNull
	@Lob
	private byte[] photo;

}
