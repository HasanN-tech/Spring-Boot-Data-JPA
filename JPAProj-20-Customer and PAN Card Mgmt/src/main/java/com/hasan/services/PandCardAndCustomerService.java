package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Customer;
import com.hasan.repository.CustomerRepository;

@Service
public class PandCardAndCustomerService {

	@Autowired
	private CustomerRepository docRepo;
	
//	@Autowired
//	private CourseRepository couRepo;

	public String addData(Customer b) {
		docRepo.save(b);
		return "Data added.";
	}

	public Customer getData(Long id) {
		return docRepo.findById(id).get();
		
	}

	public List<Customer> viewAll(){
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
