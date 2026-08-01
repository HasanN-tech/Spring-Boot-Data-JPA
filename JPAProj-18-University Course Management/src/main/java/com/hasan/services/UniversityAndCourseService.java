package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.University;
import com.hasan.repository.UniversityRepository;

@Service
public class UniversityAndCourseService {

	@Autowired
	private UniversityRepository uniRepo;
	
//	@Autowired
//	private CourseRepository couRepo;

	public String addData(University b) {
		uniRepo.save(b);
		return "Data added.";
	}

	public University getData(Long id) {
		return uniRepo.findById(id).get();
		
	}

	public List<University> viewAll(){
		return uniRepo.findAll();
	}
	
	public String deleteRecord(Long id) {
		if(uniRepo.existsById(id)) {
			uniRepo.deleteById(id);
			return "Record deleted.";
		}
		else return "Record not found.";
	}

}
