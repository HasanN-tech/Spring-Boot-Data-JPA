package com.hasan.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Course {
	@Id
	@SequenceGenerator(name="course_gen",sequenceName = "course_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen")
	private Long courseID;

	@Nonnull
	@Column(length = 35)
	private String courseTitle;

	@Nonnull
	@Column(length = 25)
	private String category;

	@Nonnull
	@Column(length = 25)
	private String instructorName;

	@Nonnull
	private Double price;
	
	@Nonnull
	private Integer duration;
	
	@Nonnull
	private Double rating;
	
	@Nonnull
	private String language;
}
