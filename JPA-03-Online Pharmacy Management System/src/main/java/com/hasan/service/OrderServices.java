package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Order;
import com.hasan.repository.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository repo;
	
	public String add(Order o) {	
//		repo.saveAll(List.of(new Order("Hasan", "Laptop", "Electronics", 24000.0,"UPI","Pending"),new Order("Bhupendra", "Mobile", "Electronics", 30000.0,"credit card","Delivered")));
		if(o!=null) {
			repo.save(o);
			return "Added.";
		}
		else return "Invalid data.";
	}
	
	public List<Order> viewAll(){
		return repo.findAll();				
	}	
	
	public String delete(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		}else return "Record not found.";
	}
	
}
