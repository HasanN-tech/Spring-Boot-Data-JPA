package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
