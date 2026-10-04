package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Order;
import com.hasan.repository.EcommerceRepository;

@Service
public class OrderServices {

	@Autowired
	private EcommerceRepository repo;
	
	public String add(Order o) {
		if(o!=null) {
			repo.save(o);
			return "Added.";
		}
		else return "Invalid data.";
	}
	
	public List<Order> viewAll(){
		return repo.findAll();				
	}
	
	public void update(int id, String str) {
		Order o=repo.findById(id).get();
		o.setStatus(str);
		repo.save(o);
		o.getUpdatedAt();
		IO.println("Updated.");
	}
	
	public String delete(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		}else return "Record not found.";
	}
	
	public Order lastModified(int id) {
		Order o=repo.findById(id).get();
		repo.save(o);
		return o;
	}
}
