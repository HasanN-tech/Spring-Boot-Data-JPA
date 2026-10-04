package com.hasan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Order;
import com.hasan.service.OrderServices;

@Component
public class OrderRunner implements CommandLineRunner {

	@Autowired
	private OrderServices os;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		IO.println("Add New Order\r\n" + "View All Orders\r\n" + "Update Order Status\r\n" + "Delete Order\r\n"
				+ "Display Order with Created and Last Modified Timestamp");
		boolean flag=true;
		while(flag) {
			int choice=Integer.parseInt(IO.readln("Enter your choice: "));
			
			switch (choice) {
			case 1 -> os.add(new Order("Hasan", "Laptop", 1, 30000.0, "Delivered"));
			
			case 2 -> os.viewAll().forEach(IO::println);
			
			case 3 -> os.update(1, "Pending");
			
			case 4 -> os.delete(Integer.parseInt(IO.readln("Enter id: ")));
			
			case 5 -> IO.println(os.lastModified(1));
			
			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
