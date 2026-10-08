package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MTM_Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
	private String courseName;

	@NonNull
	private Integer duration;
	
	
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Student> students;


	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", duration=" + duration + "]";
	}
}
