package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
