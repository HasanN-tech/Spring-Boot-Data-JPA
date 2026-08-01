package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Doctor;
import com.hasan.repository.DoctorRepository;

@Service
public class DoctorAndPatientService {

	@Autowired
	private DoctorRepository docRepo;
	
//	@Autowired
//	private CourseRepository couRepo;

	public String addData(Doctor b) {
		docRepo.save(b);
		return "Data added.";
	}

	public Doctor getData(Long id) {
		return docRepo.findById(id).get();
		
	}

	public List<Doctor> viewAll(){
		return docRepo.findAll();
	}
	
	public String deleteRecord(Long id) {
		if(docRepo.existsById(id)) {
			docRepo.deleteById(id);
			return "Record deleted.";
		}
		else return "Record not found.";
	}

}
