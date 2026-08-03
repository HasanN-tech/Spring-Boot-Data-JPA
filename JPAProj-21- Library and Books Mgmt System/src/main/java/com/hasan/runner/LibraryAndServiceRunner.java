package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Book;
import com.hasan.entity.Library;
import com.hasan.services.LibraryAndBookService;

@Component
public class LibraryAndServiceRunner implements CommandLineRunner {

	@Autowired
	private LibraryAndBookService lbs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {

			case 1 -> {
				Book b1 = new Book("Java Fun", "James Gosling", 1800.0);
				Book b2 = new Book("Oracle DB", "Alex James", 1500.0);
				Book b3 = new Book("Spring Boot", "Peter", 2200.0);
				Book b4 = new Book("Never Give Up", "John", 1200.0);

				Library l1 = new Library("NIT", "Hyderabad", List.of(b1, b2));
				Library l2 = new Library("Silence", "Faizabad", List.of(b3, b4));

				lbs.addData(l1);
				lbs.addData(l2);
			}

			case 2 -> {
				Library uni = lbs.getData(2L);
				IO.println("Library Details::");
				IO.println("Library id: " + uni.getLibraryId());
				IO.println("Library Name: " + uni.getLibraryName());
				IO.println("Library location: " + uni.getLocation());
				IO.println("\nBook Details: ");
				uni.getBook().forEach(b -> {
					IO.println("Id: " + b.getBookId());
					IO.println("Title: " + b.getBookTitle());
					IO.println("Author: " + b.getAuthorName());
					IO.println("Price: " + b.getPrice());
				});
			}
			case 3 -> lbs.viewAll().forEach(uni -> {
				IO.println("Library Details::");
				IO.println("Library id: " + uni.getLibraryId());
				IO.println("Library Name: " + uni.getLibraryName());
				IO.println("Library location: " + uni.getLocation());
				IO.println("\nBook Details: ");
				uni.getBook().forEach(b -> {
					IO.println("Id: " + b.getBookId());
					IO.println("Title: " + b.getBookTitle());
					IO.println("Author: " + b.getAuthorName());
					IO.println("Price: " + b.getPrice());
				});
			});

			case 4 -> IO.println(lbs.deleteRecord(3L));

			case 5 -> {
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
