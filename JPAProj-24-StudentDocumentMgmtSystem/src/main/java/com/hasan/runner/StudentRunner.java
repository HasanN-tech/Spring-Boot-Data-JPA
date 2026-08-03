package com.hasan.runner;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Student;
import com.hasan.service.StudentService;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private StudentService ss;
	
	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			File f1=new File("C:\\Users\\DELL\\OneDrive\\Desktop\\My passport photo.jpg");
			byte[] p1=Files.readAllBytes(f1.toPath());
			
			File f2=new File("E:\\mobile pics\\Hyderabad\\ABC.jpg");
			byte[] p2=Files.readAllBytes(f2.toPath());
			
			File f3=new File("C:\\Users\\DELL\\OneDrive\\Desktop\\My pan card.jpg");
			byte[] p3=Files.readAllBytes(f3.toPath());
			
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			List<Student> list = List.of(new Student("Hasan","java",p1), new Student("Nawab","Oracle",p2),
					new Student("Faraz","Spring", p3));
			switch (choice) {
			case 1 -> {
				IO.println(ss.addRecord(new Student("Raaz","C", p1)));
			}

			case 2 -> {
				IO.println(ss.addMultiData(list));
			}
			case 3 -> ss.viewAll().forEach(IO::println);

			case 4 -> IO.println(ss.update(100, "Python"));
			
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
