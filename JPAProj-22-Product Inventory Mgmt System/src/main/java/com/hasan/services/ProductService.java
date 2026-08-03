package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Product;
import com.hasan.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public String addData(Product b) {
		repo.save(b);
		return "Data added.";
	}

	public String addMultiData(List<Product> b) {
		repo.saveAll(b);
		return "Multiple Data added.";
	}

	public Product getData(Long id) {
		return repo.findById(id).get();

	}

	public List<Product> viewAll() {
		return repo.findAll();
	}

	public String update(Long id, Product p) {
		if (repo.existsById(id)) {
			Product p1 = repo.findById(id).get();
			p1.setPrice(p.getPrice());
			p1.setQuantity(p.getQuantity());
			repo.save(p1);
			return "Record Updated.";
		} else
			return "Record not found.";
	}

	public String deleteRecord(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		} else
			return "Record not found.";
	}

}
