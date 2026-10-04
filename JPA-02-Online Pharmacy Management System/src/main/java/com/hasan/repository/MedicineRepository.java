package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Medicine;
import java.util.List;


public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	List<Medicine> findByCategory(String category);
	
	List<Medicine> findByManufacturer(String manufacturer);
	
	List<Medicine> findByStockGreaterThan(Integer stock);
	
}
