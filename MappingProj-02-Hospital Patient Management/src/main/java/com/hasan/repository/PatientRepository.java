package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
