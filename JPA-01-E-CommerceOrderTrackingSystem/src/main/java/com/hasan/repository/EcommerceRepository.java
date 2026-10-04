package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Order;

public interface EcommerceRepository extends JpaRepository<Order, Integer> {

}
