package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Student;
import com.hasan.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public String addRecord(Student s) {
		if(s!=null) {
			repo.save(s);
			return "Data Saved";
		}
		return "Invalid Data";
	}
	
	public String addMultiData(List<Student> list) {
		if(list!=null) {
			repo.saveAll(list);
			return "Multiple Data Saved";
		}
		return "Invalid Data";
	}
	
	public List<Student> viewAll(){
		return repo.findAll();
	}
	
	public String update(int id, String c) {
		if(repo.existsById(id)) {
			Student s=repo.findById(id).get();
			s.setCourse(c);
			repo.save(s);
			return "Data Updated.";
		}
		else return "Id not found.";
	}
	
	public String delete(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Data deleted";
		}
		else return "Id not found.";
	}
	
}
