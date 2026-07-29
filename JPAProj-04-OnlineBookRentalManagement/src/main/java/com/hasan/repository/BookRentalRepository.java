package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.RentalBook;

public interface BookRentalRepository extends JpaRepository<RentalBook, Long>{

}
