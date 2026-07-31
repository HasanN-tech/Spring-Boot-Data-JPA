package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.RecipeBook;
import com.hasan.repository.RecipeBookRepository;

@Service
public class RecipeBookService {

	@Autowired
	private RecipeBookRepository repo;

	public String addData(RecipeBook b) {
		repo.save(b);
		return "Data added.";
	}
	
	public RecipeBook byId(Long id) {
		return repo.findById(id).get();
	}
//	
	public RecipeBook updateIngredients(Long id, List<String> i) {
		RecipeBook rb=repo.findById(id).get();
		rb.setIngerdients(i);
		repo.save(rb);
		return rb;
	}
	
	public String delete(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record Deleted.";
		}
		else return "Record Not Found.";
	}
	
}
