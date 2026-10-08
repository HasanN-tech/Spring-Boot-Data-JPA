package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Course;
import com.hasan.entity.Student;
import com.hasan.service.StudentCourseService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private StudentCourseService service;

	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student("Hasan", "hasan@gmail.com");
		Student s2 = new Student("Vaibhav", "Vaibhav@gmail.com");

		Course c1 = new Course("Java", 8);
		Course c2 = new Course("Oracle", 4);

		s1.setCourses(List.of(c1, c2));
		s2.setCourses(List.of(c1, c2));

		c1.setStudents(List.of(s1, s2));
		c2.setStudents(List.of(s1, s2));

//		service.addStudent(s1);
//		IO.println("s1 added");
//		
//		service.addStudent(s2);
//		IO.println("s1 added");
//		
//		service.addCourse(c1);
//		IO.println("c1 added");
//		
//		service.addCourse(c2);
//		IO.println("c1 added");
		
//		IO.println(service.getStudentById(1));
		IO.println(service.getCourseById(1) +"Students"+ service.getCourseById(1).getStudents());
		IO.println();
		
	}
}
