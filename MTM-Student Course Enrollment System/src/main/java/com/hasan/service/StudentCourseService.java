package com.hasan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Course;
import com.hasan.entity.Student;
import com.hasan.repository.CourseRepository;
import com.hasan.repository.StudentRepository;

@Service
public class StudentCourseService {
	
	@Autowired
	private StudentRepository srepo;
	
	@Autowired
	private CourseRepository crepo;
	
	public String addStudent(Student u) {
		if(u!=null) {
			srepo.save(u);
			return "Data Added.";
		}else return "Data INVALID.";
	}
	
	public String addCourse(Course u) {
		if(u!=null) {
			crepo.save(u);
			return "Data Added.";
		}else return "Data INVALID.";
	}
	
	
	public Student getStudentById(int id) {
		return srepo.findById(id).get();
	}
	
	public Course getCourseById(int id) {
		return crepo.findById(id).get();
	}
}
