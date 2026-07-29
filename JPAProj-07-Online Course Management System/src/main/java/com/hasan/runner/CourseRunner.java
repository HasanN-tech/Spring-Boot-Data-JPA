package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Course;
import com.hasan.repository.CourseRepository;
import com.hasan.services.CourseService;

@Component
public class CourseRunner implements CommandLineRunner {

	@Autowired
	private CourseService cs;
	
	@Autowired
	private CourseRepository repo;

	public List<Course> listOfCourse() {
		return List.of(
				new Course("Java Programming Masterclass", "Development", "John Doe", 4999.00, 45, 4.8, "English"),
				new Course("Data Science with Python", "Data Science", "Jane Smith", 5500.00, 32, 4.7, "English"),
				new Course("UI/UX Design Fundamentals", "Design", "Alex Jones", 2999.00, 15, 4.5, "Spanish"),
				new Course("Digital Marketing 101", "Marketing", "Sarah Connor", 1999.00, 12, 4.3, "English"),
				new Course("Advanced Spring Boot", "Development", "Michael Scott", 6499.00, 22, 4.9, "English"),
				new Course("Introduction to Cloud Computing", "IT & Software", "Bruce Wayne", 3500.00, 18, 4.6,
						"German"),
				new Course("Financial Analysis Masterclass", "Finance", "Clark Kent", 4200.00, 28, 4.4, "English"),
				new Course("Creative Writing Workshop", "Lifestyle", "Diana Prince", 1500.00, 10, 4.2, "French"));
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("Operation 1: Display all courses by category.\r\n"
				+ "Operation 2: Display all courses taught by instructor.\r\n"
				+ "Operation 3: Display all courses with price less than.\r\n"
				+ "Operation 4: Display all courses with price greater than.\r\n"
				+ "Operation 5: Display all courses having duration greater than X hours.\r\n"
				+ "Operation 6: Display all courses having rating greater than or equal.\r\n"
				+ "Operation 7: Display all courses available in language.\r\n"
				+ "Operation 8: Display all courses by title." + "9. Exit.");
		repo.saveAll(listOfCourse());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> cs.getByCategory(IO.readln("Enter the category: ")).forEach(IO::println);
			
			case 2 -> cs.getByInstructor(IO.readln("Enter the Instructor: ")).forEach(IO::println);

			case 3 -> cs.getByPriceLess(Double.parseDouble(IO.readln("Enter price for get lesser data: "))).forEach(IO::println);

			case 4 -> cs.getByPriceGreater(Double.parseDouble(IO.readln("Enter price for get lesser data: "))).forEach(IO::println);
			
			case 5 -> cs.getByDuration(Integer.parseInt(IO.readln("Enter duration for get greater data: "))).forEach(IO::println);

			case 6 -> cs.getByRating(Double.parseDouble(IO.readln("Enter rating for get greater/equal data: "))).forEach(IO::println);

			case 7 -> cs.getByLanguage(IO.readln("Enter the language: ")).forEach(IO::println);

			case 8 -> cs.getByTitle(IO.readln("Enter the title: ")).forEach(IO::println);

			case 9 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
