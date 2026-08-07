package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Course;
import com.hasan.entity.University;
import com.hasan.service.UniversityAndCourseService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private UniversityAndCourseService service;
	
	@Override
	public void run(String... args) throws Exception {
//		University u1=new University("RMLAU","Faizabad");
//		u1.setCourses(List.of(new Course("Java","1 year",30000.0),new Course("Python", "6 months", 22000.0)));
//		IO.println(service.saveUniversity(u1));
		
		University u2=new University("LU","Lucknow");
		u2.setCourses(List.of(new Course("Oracle","4 months",12000.0),new Course("CRT", "4 months", 10000.0)));
		IO.println(service.saveUniversity(u2));
		
		service.getAllData().forEach(IO::println);;
		
	}

}
