package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	public List<Course> findByCategory(String category);
	
	public List<Course> findByInstructorName(String instructorName);
	
	public List<Course> findByPriceLessThan(Double price);
	public List<Course> findByPriceGreaterThan(Double price);
	public List<Course> findByDuration(int duration);
	public List<Course> findByRatingGreaterThanEqual(Double rating);
	public List<Course> findByLanguage(String language);
	public List<Course> findByCourseTitleContaining(String keyword);
}
