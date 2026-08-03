package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
