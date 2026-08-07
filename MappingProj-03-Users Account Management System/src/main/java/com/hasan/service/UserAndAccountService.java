package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Account;
import com.hasan.entity.User;
import com.hasan.repository.AccountRepository;
import com.hasan.repository.UserRepository;

@Service
public class UserAndAccountService {
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AccountRepository aRepo;
	
	public String saveUser(User u) {
		if(u!=null) {
			uRepo.save(u);
			return "Data Successfully saved.";
		}else
		return "Invalid Data.";
	}
	
	public List<User> getAllUser(){
		return uRepo.findAll();
	}
	
	public List<Account> getAllAccount(){
		return aRepo.findAll();
	}
	
}
