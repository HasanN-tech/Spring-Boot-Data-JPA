package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class EmployeeResume {
	@Id
	@SequenceGenerator(name = "resume", sequenceName = "resume_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_seq")
	private Long employeeId;

	@NonNull
	@Column(length = 30)
	private String employeeName;

	@NonNull
	@Column(length = 20)
	private String designation;
	
	@NonNull
	@Lob
	@Column(columnDefinition = "CLOB")
	private String resume_Content;

}
