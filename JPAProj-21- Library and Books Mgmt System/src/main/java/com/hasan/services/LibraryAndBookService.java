package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Library;
import com.hasan.repository.LibraryRepository;

@Service
public class LibraryAndBookService {

	@Autowired
	private LibraryRepository docRepo;
	
//	@Autowired
//	private CourseRepository couRepo;

	public String addData(Library b) {
		docRepo.save(b);
		return "Data added.";
	}

	public Library getData(Long id) {
		return docRepo.findById(id).get();
		
	}

	public List<Library> viewAll(){
		return docRepo.findAll();
	}
	
	public String deleteRecord(Long id) {
		if(docRepo.existsById(id)) {
			docRepo.deleteById(id);
			return "Record deleted.";
		}
		else return "Record not found.";
	}

}
