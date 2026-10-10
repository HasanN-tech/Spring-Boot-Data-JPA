package com.hasan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Profile;
import com.hasan.entity.User;
import com.hasan.service.UserAndProfileService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private UserAndProfileService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.addData(new User("Hasan", "123", new Profile(9999999L, "Hyderabad")));
		service.getByprofile(1);
		service.getAll().forEach(IO::println);
	}

}
