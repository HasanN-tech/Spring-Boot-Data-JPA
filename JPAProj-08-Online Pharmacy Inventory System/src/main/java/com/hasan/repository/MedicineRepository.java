package com.hasan.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	public List<Medicine> findByCategoryOrManufacturer(String category, String manufacturer);
	public List<Medicine> findByPriceBetween(Double minPrice, Double maxPrice);
	public List<Medicine> findByStockQuantityBetween(Integer minStock, Integer maxStock);
	public List<Medicine> findByMedicineNameOrCategory(String medicineName, String category);
	public List<Medicine> findByExpiryDateBetween(LocalDate startDate, LocalDate endDate);
	public List<Medicine> findByRatingBetween(Double minRating, Double maxRating);
	public List<Medicine> findByMedicineIdBetween(Long startId, Long endId);
}
