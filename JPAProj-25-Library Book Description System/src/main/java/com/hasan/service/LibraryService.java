package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Library;
import com.hasan.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository repo;
	
	public String addRecord(Library s) {
		if(s!=null) {
			repo.save(s);
			return "Data Saved";
		}
		return "Invalid Data";
	}
	
	public String addMultiData(List<Library> list) {
		if(list!=null) {
			repo.saveAll(list);
			return "Multiple Data Saved";
		}
		return "Invalid Data";
	}
	
	public List<Library> viewAll(){
		return repo.findAll();
	}
	
	public String update(int id, String c) {
		if(repo.existsById(id)) {
			Library s=repo.findById(id).get();
			s.setDescription(c);
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
