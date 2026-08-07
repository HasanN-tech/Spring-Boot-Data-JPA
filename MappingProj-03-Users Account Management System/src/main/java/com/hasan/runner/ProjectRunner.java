package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Account;
import com.hasan.entity.User;
import com.hasan.service.UserAndAccountService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private UserAndAccountService service;
	
	@Override
	public void run(String... args) throws Exception {
		User u1=new User("Hasan","18/11/2002");
		User u2=new User("Nawab","22/08/2003");
		
		Account a1=new Account("123ABC89", "current");
		Account a2=new Account("456ABC07", "saving");
		
		u1.setAccount(List.of(a1,a2));
		
//		IO.println(service.saveUser(u1));
		
		service.getAllUser().forEach(d->IO.println(d));
	}

}
