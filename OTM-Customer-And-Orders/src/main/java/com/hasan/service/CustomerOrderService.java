package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Customer;
import com.hasan.repository.CustomerRepository;

@Service
public class CustomerOrderService {
	
	@Autowired
	private CustomerRepository crepo;
	
	public String addData(Customer u) {
		if(u!=null) {
			crepo.save(u);
			return "Data Added.";
		}else return "Data INVALID.";
	}
	
	public Customer getDataById(int id) {
		return crepo.findById(id).get();
	}
	
	public List<Customer> getAll(){
		return crepo.findAll();
	}
	
}
