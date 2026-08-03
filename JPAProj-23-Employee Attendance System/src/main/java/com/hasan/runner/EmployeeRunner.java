package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Employee;
import com.hasan.services.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeService lbs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			List<Employee> list = List.of(new Employee("Hasan","Development", 55000.0), new Employee("Vaibhav","Database", 17000.0),
					new Employee("Bhupi","HR", 12000.0));
			switch (choice) {
			case 1 -> {
				IO.println(lbs.addData(new Employee("Nawab","Intern", 20000.0)));
			}

			case 2 -> {
				IO.println(lbs.addMultiData(list));
			}
			case 3 -> lbs.viewAll().forEach(IO::println);

			case 4 -> lbs.update(8L, 15000.0);
			
			case 5 -> IO.println(lbs.deleteRecord(7L));

			case 6 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
