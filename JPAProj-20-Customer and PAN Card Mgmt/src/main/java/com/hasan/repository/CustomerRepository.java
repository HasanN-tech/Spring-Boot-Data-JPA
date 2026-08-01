package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
