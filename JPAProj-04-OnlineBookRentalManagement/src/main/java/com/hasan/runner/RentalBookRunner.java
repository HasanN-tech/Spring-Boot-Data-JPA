package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.RentalBook;
import com.hasan.services.RentalBookServices;

@Component
public class RentalBookRunner implements CommandLineRunner {

	@Autowired
	private RentalBookServices rs;

	public List<RentalBook> listOfBooks() {
		return List.of(new RentalBook("Advanced Java", "Kathy Sierra", "Technologies", 1500.0),
				new RentalBook("Spring Boot", "Craig Walls", "Technologies", 1800.0),
				new RentalBook("Effective Java", "Joshua Bloch", "Technologies", 2200.0),
				new RentalBook("Python Basics", "Dan Bader", "Technologies", 950.0),
				new RentalBook("Fluent Python", "Luciano Ramalho", "Technologies", 2500.0),
				new RentalBook("JavaScript Info", "Ilya Kantor", "Technologies", 1100.0),
				new RentalBook("React Up & Running", "Stoyan Stefanov", "Technologies", 1350.0),
				new RentalBook("Angular in Action", "Jeremy Wilken", "Technologies", 1400.0));
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Add a new rental book using save().\r\n" + "2. Add multiple rental books using saveAll().\r\n"
				+ "3. Search a book by ID using findById().\r\n" + "4. Display all books using findAll().\r\n"
				+ "5. Update rental price of a book using save().\r\n" + "6. Delete a book using deleteById().\r\n"
				+ "7. Delete all books using deleteAll().\r\n" + "8. Count total books using count().\r\n"
				+ "9. Check whether a book exists using existsById().\r\n" + "10. Exit.");

		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> IO.println(rs.saveBook(new RentalBook("JAVA", "James", "Technologies", 1200.0)));

			case 2 -> IO.println(rs.saveAllBooks(listOfBooks()));

			case 3 -> IO.println(rs.getBookById(Long.parseLong(IO.readln("Enter id for search: "))));

			case 4 -> rs.getAllBooks().forEach(IO::println);

			case 5 -> IO.println(rs.updateBook(1000.0,Long.parseLong(IO.readln("Enter id for search: "))));

			case 6 -> IO.println(rs.deleteBookById(Long.parseLong(IO.readln("Enter id for delete: "))));

			case 7 -> IO.println(rs.deleteAllBooks());

			case 8 -> IO.println(rs.countBooks());

			case 9 -> IO.println(rs.existsBook(Long.parseLong(IO.readln("Enter id for search: "))));

			case 10 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
