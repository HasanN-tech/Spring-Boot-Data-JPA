package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	public List<Doctor> findByDoctorNameLike(String pattern);
	public List<Doctor> findBySpecializationIn(List<String> specializations);
	public List<Doctor> findByDoctorNameStartingWith(String prefix);
	public List<Doctor> findByDoctorNameEndingWith(String suffix);
	public List<Doctor> findByCityIn(List<String> cities);
	public List<Doctor> findByHospitalNameLike(String pattern);
	public List<Doctor> findByEmailEndingWith(String domain);
	public List<Doctor> findBySpecializationStartingWith(String prefix);
}
