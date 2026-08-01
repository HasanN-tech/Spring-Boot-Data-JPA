package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.EmployeeResume;

@Repository
public interface EmployeeResumeRepository extends JpaRepository<EmployeeResume, Long> {

}
