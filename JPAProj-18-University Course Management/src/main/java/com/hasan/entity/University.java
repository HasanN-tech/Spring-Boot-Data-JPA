package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="OTM_University")
public class University {
	@Id
	@SequenceGenerator(name = "university", sequenceName = "university_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "university")
	@Column(name="univ_id")
	private Long universityId;

	@NonNull
	@Column(length = 30)
	private String universityName;

	@NonNull
	@Column(length = 20)
	private String city;
	
	@NonNull
	@OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "univ_id",referencedColumnName = "univ_id")
	private List<Course> courses;

}
