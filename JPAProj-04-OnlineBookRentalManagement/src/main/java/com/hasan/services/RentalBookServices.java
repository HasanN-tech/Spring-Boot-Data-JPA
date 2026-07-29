package com.hasan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hasan.entity.RentalBook;

@Service
public interface RentalBookServices {
	 public String saveBook(RentalBook book);
	 public String saveAllBooks(List<RentalBook> books);
	 public RentalBook getBookById(Long id);
	 public List<RentalBook> getAllBooks();
	 public String updateBook(Double price,Long id);
	 public String deleteBookById(Long id);
	 public String deleteAllBooks();
	 public long countBooks();
	 public RentalBook existsBook(Long id);
}
