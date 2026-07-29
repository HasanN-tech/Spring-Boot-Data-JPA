package com.hasan.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Medicine;
import com.hasan.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository repo;
	
	public List<Medicine> categoryOrManufacturer(String c,String m){
		return repo.findByCategoryOrManufacturer(c, m);
	}
	
	public List<Medicine> priceBtwn(Double min,Double max){
		return repo.findByPriceBetween(min, max);
	}
	
	public List<Medicine> stockBtwn(int min,int max){
		return repo.findByStockQuantityBetween(min, max);
	}
	
	public List<Medicine> nameOrCategory(String n,String c){
		return repo.findByMedicineNameOrCategory(n, c);
	}
	
	public List<Medicine> expiryBtwn(LocalDate s,LocalDate e){
		return repo.findByExpiryDateBetween(s, e);
	}
	
	public List<Medicine> ratingBtwn(Double min,Double max){
		return repo.findByRatingBetween(min, max);
	}
	
	public List<Medicine> idBtwn(Long s,Long e){
		return repo.findByMedicineIdBetween(s, e);
	}
	
	
}
