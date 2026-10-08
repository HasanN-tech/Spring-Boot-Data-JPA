package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="OTM_Student_04")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="student_course",joinColumns=@JoinColumn(name = "sId"),inverseJoinColumns = @JoinColumn(name="cId"))
	private List<Course> courses;
}
