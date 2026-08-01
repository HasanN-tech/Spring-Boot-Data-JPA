package com.hasan.runner;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.LibraryBook;
import com.hasan.services.LibraryBookService;

@Component
public class LibraryBookRunner implements CommandLineRunner {

	@Autowired
	private LibraryBookService rs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;
		
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			
			case 1 -> {
				File f1=new File("E:/mobile pics/Hyderabad/ABC.jpg");
				byte[] pic1=Files.readAllBytes(f1.toPath());

				IO.println(rs.addData(new LibraryBook("Spring Boot","Hasan Nawab",pic1)));
			}

			case 2 -> {
				IO.println(rs.getBook(2L));
			}
			case 3 -> rs.viewAll().forEach(IO::println);

			case 4 -> IO.println(rs.deleteBook(52L));

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
