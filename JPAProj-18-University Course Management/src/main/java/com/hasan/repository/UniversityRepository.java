package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}
