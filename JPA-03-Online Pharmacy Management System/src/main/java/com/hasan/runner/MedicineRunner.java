package com.hasan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Order;
import com.hasan.repository.OrderRepository;
import com.hasan.service.OrderServices;

@Component
public class MedicineRunner implements CommandLineRunner {

	@Autowired
	private OrderServices os;
	
	@Autowired
	private OrderRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=true;
		while(flag) {
			int choice=Integer.parseInt(IO.readln("Enter your choice: "));
			
			switch (choice) {
			case 1 -> os.add(new Order("nawab", "ring", "jewellery", 30000.0, "Debit card","Delivered"));
			
			case 2 -> os.viewAll().forEach(IO::println);
			
			case 3 -> repo.displayPayment("UPI") .forEach(IO::println);
			
			case 4 -> repo.diaplayCategory("Electronics").forEach(IO::println);
			
			case 5 -> repo.aboveAmount(25000.0).forEach(IO::println);
			
			case 6 -> os.delete(Integer.parseInt(IO.readln("Enter id: ")));
			
			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
