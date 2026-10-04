package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Medicine;
import com.hasan.repository.MedicineRepository;

@Service
public class MedicineServices {

	@Autowired
	private MedicineRepository repo;
	
	public String add(Medicine o) {
		
		repo.saveAll(List.of(new Medicine("ABC", "Pain Relief", "NIT", 1200.0,10)));
		if(o!=null) {
			repo.save(o);
			return "Added.";
		}
		else return "Invalid data.";
	}
	
	public List<Medicine> viewAll(){
		return repo.findAll();				
	}
	
	public List<Medicine> serachCategory(String c){
		return repo.findByCategory(c);				
	}
	
	public List<Medicine> serachManufacturer(String c){
		return repo.findByManufacturer(c);				
	}
	
	public List<Medicine> stockGreater(Integer c){
		return repo.findByStockGreaterThan(c);				
	}
	
	
	
	public String delete(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		}else return "Record not found.";
	}
	
}
