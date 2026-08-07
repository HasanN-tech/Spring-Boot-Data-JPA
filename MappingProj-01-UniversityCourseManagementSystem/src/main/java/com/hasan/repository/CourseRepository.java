package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
