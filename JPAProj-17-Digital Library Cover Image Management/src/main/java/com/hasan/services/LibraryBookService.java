package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.LibraryBook;
import com.hasan.repository.LibraryBookRepository;

@Service
public class LibraryBookService {

	@Autowired
	private LibraryBookRepository repo;

	public String addData(LibraryBook b) {
		repo.save(b);
		return "Data added.";
	}

	public LibraryBook getBook(Long id) {
		return repo.findById(id).get();
	}

	public List<LibraryBook> viewAll(){
		return repo.findAll();
	}
	
	public String deleteBook(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		}
		else return "Record not found.";
	}

}
