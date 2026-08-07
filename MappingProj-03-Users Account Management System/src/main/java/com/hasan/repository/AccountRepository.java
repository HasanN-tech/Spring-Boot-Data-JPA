package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
