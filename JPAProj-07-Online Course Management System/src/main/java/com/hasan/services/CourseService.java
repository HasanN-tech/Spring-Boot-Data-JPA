package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Course;
import com.hasan.repository.CourseRepository;

@Service
public class CourseService{
	@Autowired
	private CourseRepository repo;
	
	public List<Course> getByCategory(String c){
		return repo.findByCategory(c);
	}
	
	public List<Course> getByInstructor(String i){
		return repo.findByInstructorName(i);
	}
	
	public List<Course> getByPriceLess(Double p){
		return repo.findByPriceLessThan(p);
	}
	
	public List<Course> getByPriceGreater(Double p){
		return repo.findByPriceGreaterThan(p);
	}
	
	public List<Course> getByDuration(int d){
		return repo.findByDuration(d);
	}
	
	public List<Course> getByRating(Double r){
		return repo.findByRatingGreaterThanEqual(r);			
	}
	
	public List<Course> getByLanguage(String l){
		return repo.findByLanguage(l);
	}
	
	public List<Course> getByTitle(String t){
		return repo.findByCourseTitleContaining(t);
	}
	
}
