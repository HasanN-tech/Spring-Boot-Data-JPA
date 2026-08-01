package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Doctor;
import com.hasan.entity.Patient;
import com.hasan.services.DoctorAndPatientService;

@Component
public class DoctorAndPatientRunner implements CommandLineRunner {

	@Autowired
	private DoctorAndPatientService dps;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {

			case 1 -> {
				Patient p1 = new Patient("Raj", "Heart Problem", 68);
				Patient p2 = new Patient("Ravi", "Corona", 33);
				Patient p3 = new Patient("Naresh", "Lungs infection", 45);

				Doctor d1 = new Doctor("Dr. Hasan", "All rounder", List.of(p1, p3));
				Doctor d2 = new Doctor("Dr. Sharma", "Cardiologist", List.of(p2));

				p1.setDoctor(d1);
				p2.setDoctor(d2);
				p3.setDoctor(d1);

				dps.addData(d1);
				dps.addData(d2);
			}

			case 2 -> {
				Doctor uni = dps.getData(7L);
				IO.println("Doctor Details::");
				IO.println("Doctor id: " + uni.getDoctorId());
				IO.println("Doctor Name: " + uni.getDoctorName());
				IO.println("Specilaization: " + uni.getSpecialization());

				uni.getPatients().forEach(cou -> {
					IO.println("\nPatient Details::");
					IO.println("Patient id: " + cou.getPatientId());
					IO.println("Patient name: " + cou.getPatientName());
					IO.println("Patient age: " + cou.getAge());
					IO.println("Disease: " + cou.getDisease());
					IO.println("Doctor: "+cou.getDoctor().getDoctorName());
				});
			}
			case 3 -> dps.viewAll().forEach(uni -> {
				IO.println("Doctor Details::");
				IO.println("Doctor id: " + uni.getDoctorId());
				IO.println("Doctor Name: " + uni.getDoctorName());
				IO.println("Specilaization: " + uni.getSpecialization());

				uni.getPatients().forEach(cou -> {
					IO.println("\nPatient Details::");
					IO.println("Patient id: " + cou.getPatientId());
					IO.println("Patient name: " + cou.getPatientName());
					IO.println("Patient age: " + cou.getAge());
					IO.println("Disease: " + cou.getDisease());
					IO.println("Doctor: "+cou.getDoctor().getDoctorName());
				});

			});

			case 4 -> IO.println(dps.deleteRecord(4L));

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
