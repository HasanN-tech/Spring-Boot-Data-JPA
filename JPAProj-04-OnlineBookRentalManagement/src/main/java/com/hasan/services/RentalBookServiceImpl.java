package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.RentalBook;
import com.hasan.repository.BookRentalRepository;

@Service
public class RentalBookServiceImpl implements RentalBookServices {
	@Autowired
	private BookRentalRepository repo;
	
	@Override
	public String saveBook(RentalBook book) {
		if(book !=null) {
			repo.save(book);
			return "Record saved successfully";
		}
		return "record not found";
	}

	@Override
	public String saveAllBooks(List<RentalBook> books) {
		if(books !=null) {
			repo.saveAll(books);
			return "Records saved successfully";
		}
		return "records not found";
	}

	@Override
	public RentalBook getBookById(Long id) {
		if(id !=null) {
			return repo.findById(id).get(); 
		}
		IO.println("Id: "+id+" is not found.");
		return null ;
	}

	@Override
	public List<RentalBook> getAllBooks() {
		
			return repo.findAll(); 
		
	}

	@Override
	public String updateBook(Double price,Long id) {
		if(repo.existsById(id)) {
			RentalBook b = repo.findById(id).get();
			b.setRentalPrice(price);
			repo.save(b);
			 return "Record Updated";
		}
		return "Record is not found.";
	}

	@Override
	public String deleteBookById(Long id) {
		if(id !=null) {
			 repo.deleteById(id); 
			 return "Record Deleted";
		}
		return "ID: "+id+" is not found.";
	}

	@Override
	public String deleteAllBooks() {
		
			 repo.deleteAll(); 
			 return "All Record Deleted";
	
	}

	@Override
	public long countBooks() {
		return repo.count();
	}

	@Override
	public RentalBook existsBook(Long id) {
		if(repo.existsById(id)) {
			return repo.findById(id).get();
		}
		IO.println("Record not exist.");
		return null;
	}

}
