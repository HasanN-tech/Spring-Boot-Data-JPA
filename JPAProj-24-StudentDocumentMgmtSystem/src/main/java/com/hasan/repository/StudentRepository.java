package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
