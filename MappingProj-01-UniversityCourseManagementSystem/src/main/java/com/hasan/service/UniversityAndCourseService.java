package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.University;
import com.hasan.repository.UniversityRepository;

@Service
public class UniversityAndCourseService {
	@Autowired
	private UniversityRepository repo;
	
	public String saveUniversity(University u) {
		if(u!=null) {
			repo.save(u);
			return "Data Successfully saved.";
		}else
		return "Invalid Data.";
	}
	
	public List<University> getAllData(){
		return repo.findAll();
	}
}
