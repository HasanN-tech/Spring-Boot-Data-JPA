package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Customer;
import com.hasan.entity.Order04;
import com.hasan.service.CustomerOrderService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private CustomerOrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		Order04 o1=new Order04("Laptop",65000.0);
		Order04 o2=new Order04("Phone", 30000.0);
		
		Customer c1=new Customer("Hasan", "hasan@gmail.com", List.of(o1, o2));
		
		o1.setCust(c1);
		o2.setCust(c1);
		service.addData(c1);
		service.getDataById(1);
		service.getAll().forEach(IO::println);
	}

}
