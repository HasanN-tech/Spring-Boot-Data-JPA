package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Doctor;
import com.hasan.entity.Patient;
import com.hasan.repository.DoctorRepository;
import com.hasan.repository.PatientRepository;

@Service
public class DoctorAndPatientService {
	@Autowired
	private DoctorRepository dRepo;
	
	@Autowired
	private PatientRepository pRepo;
	
	public String saveDoctor(Doctor u) {
		if(u!=null) {
			dRepo.save(u);
			return "Data Successfully saved.";
		}else
		return "Invalid Data.";
	}
	
	public List<Doctor> getAllDoctor(){
		return dRepo.findAll();
	}
	
	public List<Patient> getAllPatient(){
		return pRepo.findAll();
	}
	
}
