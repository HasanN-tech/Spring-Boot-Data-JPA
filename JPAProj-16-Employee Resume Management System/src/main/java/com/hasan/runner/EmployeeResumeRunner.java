package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.EmployeeResume;
import com.hasan.services.EmployeeResumeService;

@Component
public class EmployeeResumeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeResumeService rs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		List<EmployeeResume> list = List.of(
				new EmployeeResume("David", "Full Stack Developer",
						"Skilled in Java, Angular, Spring Boot and REST APIs"),
				new EmployeeResume("Smith", "Software Engineer",
						"Expert in Core Java, Hibernate, SQL and Web Services"));

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> {
				IO.println(rs.addData(new EmployeeResume("Mohd Hasan", "Developer", "Number 1 developer of the era.")));
			}

			case 2 -> {
				IO.println(rs.getEmployee(2L));
			}
			case 3 -> rs.viewAll().forEach(IO::println);

			case 4 -> IO.println(rs.deleteEmployee(1002L));

			case 5 -> IO.println(rs.addMultiple(list));

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
