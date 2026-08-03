package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Library;
import com.hasan.service.LibraryService;

@Component
public class LibraryRunner implements CommandLineRunner {

	@Autowired
	private LibraryService ss;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			String desc1 = """
					Spring Boot is an open-source Java framework used
					to create stand-alone, production-ready applications.
					It reduces configuration and speeds up development.
					""";
			Library l1 = new Library("Spring Boot", "Rod Johnson", desc1);

			String desc2 = """
					Java Persistence API (JPA) is a specification
					that provides object-relational mapping for Java applications.
					It simplifies database interaction.
					""";
			Library l2 = new Library("JPA Guide", "James Gosling", desc2);

			List<Library> list = List.of(l1, l2);

			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> {
				IO.println(ss.addRecord(new Library("Java", "Hasan", "This is my personal Java Book.")));
			}

			case 2 -> {
				IO.println(ss.addMultiData(list));
			}
			case 3 -> ss.viewAll().forEach(IO::println);

			case 4 -> IO.println(ss.update(100, "This book is only for java based app development."));

			case 5 -> IO.println(ss.delete(100));

			case 6 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
