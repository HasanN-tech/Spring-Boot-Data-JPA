package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Course;
import com.hasan.entity.University;
import com.hasan.services.UniversityAndCourseService;

@Component
public class UniversityAndCourseRunner implements CommandLineRunner {

	@Autowired
	private UniversityAndCourseService ucs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;
		
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			
			case 1 -> {
				Course c1=new Course("Math","8 Months", 2000.0);
				Course c2=new Course("Science","6 Months", 2500.0);
				Course c3=new Course("S.St","3 Months", 1500.0);
				ucs.addData(new University("NIT", "Ayodhya", List.of(c1,c2,c3)));
			}

			case 2 -> {
				University uni=ucs.getData(3L);
				IO.println("University Details::");
				IO.println("University id: "+uni.getUniversityId());
				IO.println("University Name: "+uni.getUniversityName());
				IO.println("City: "+uni.getCity());
				
				uni.getCourses().forEach(cou->{
					IO.println("\nCourse Details::");
					IO.println("Course id: "+cou.getCourseId());
					IO.println("Course name: "+cou.getCourseName());
					IO.println("Course duration: "+cou.getDuration());
					IO.println("Course fee: "+cou.getFee());
				});
			}
			case 3 -> ucs.viewAll().forEach(uni->{
				IO.println("University Details::");
				IO.println("University id: "+uni.getUniversityId());
				IO.println("University Name: "+uni.getUniversityName());
				IO.println("City: "+uni.getCity());
				
				uni.getCourses().forEach(cou->{
					IO.println("\nCourse Details::");
					IO.println("Course id: "+cou.getCourseId());
					IO.println("Course name: "+cou.getCourseName());
					IO.println("Course duration: "+cou.getDuration());
					IO.println("Course fee: "+cou.getFee());
				});
				
			});

			case 4 -> IO.println(ucs.deleteRecord(2L));

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
