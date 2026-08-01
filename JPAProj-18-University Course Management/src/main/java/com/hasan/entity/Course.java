package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="OTM_Course")
public class Course {
	@Id
	@SequenceGenerator(name = "course1", sequenceName = "course1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course1")
	private Long courseId;
	
	@NonNull
	@Column(length = 30)
	private String courseName;
	
	@NonNull
	@Column(length = 30)
	private String duration;
	
	@NonNull
	private Double fee;
}
