package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Doctor;
import com.hasan.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository repo;

	public List<Doctor> nameLike(String s){
		return repo.findByDoctorNameLike(s);
	}
	
	public List<Doctor> specializationIn(List<String> spec){
		return repo.findBySpecializationIn(spec);
	}
	
	public List<Doctor> nameStartsWith(String s){
		return repo.findByDoctorNameStartingWith(s);
	}
	
	public List<Doctor> nameEndsWith(String e){
		return repo.findByDoctorNameEndingWith(e);
	}
	
	public List<Doctor> cityIn(List<String> c){
		return repo.findByCityIn(c);
	}
	
	public List<Doctor> hispitalNameLike(String n){
		return repo.findByHospitalNameLike(n);
	}
	
	public List<Doctor> emailEndingWith(String e){
		return repo.findByEmailEndingWith(e);
	}
	
	public List<Doctor> specsStartsWith(String s){
		return repo.findBySpecializationStartingWith(s);
	}
	
	public Doctor updateRecord(Long id,int idx) {
		if(repo.existsById(id)) {
			Doctor doc=repo.findById(id).get();
			doc.setExperience(idx);
			return repo.save(doc);
		}
		else return null;
	}
}
