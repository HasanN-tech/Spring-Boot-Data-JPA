package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
