package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Product;
import com.hasan.services.ProductService;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductService lbs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			List<Product> list = List.of(new Product("Laptop", 55000.0, 10), new Product("Mouse", 700.0, 50),
					new Product("Keyboard", 1200.0, 30));
			switch (choice) {
			case 1 -> {
				IO.println(lbs.addData(new Product("CPU", 20000.0, 12)));
			}

			case 2 -> {
				IO.println(lbs.addMultiData(list));
			}
			case 3 -> lbs.viewAll().forEach(IO::println);

			case 4 -> lbs.update(3L, new Product("Laptop", 12000.0, 3));
			
			case 5 -> IO.println(lbs.deleteRecord(3L));

			case 6 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}

//IO.println(rs.addData(new RecipeBook("Java", "NIT", List.of("SQL", "MYSQl", "Oracle"),
//		List.of("eat", "sleep", "repeat"))));
