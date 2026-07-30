package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Doctor;
import com.hasan.repository.DoctorRepository;
import com.hasan.services.DoctorService;

@Component
public class DoctorRunner implements CommandLineRunner {

	@Autowired
	private DoctorService ds;

	@SuppressWarnings("unused")
	@Autowired
	private DoctorRepository repo;

	public List<Doctor> listOfDoctors() {
		return List.of(
				new Doctor("Dr. Aris Thorne", "Cardiology", "Heart Institute", "New York", 150.00d, 14,
						"aris.thorne@metroheart.com"),
				new Doctor("Dr. Elena Rostova", "Neurology", "St. Medical Center", "Chicago", 200.00, 18,
						"e.rostova@stjude.org"),
				new Doctor("Dr. Marcus Vance", "Pediatrics", "Childrens Hospital", "Boston", 120.00, 8,
						"mvance@childgen.org"),
				new Doctor("Dr. Saira Khan", "Dermatology", "Skin & Laser Care", "San Francisco", 175.50, 11,
						"saira.khan@skincare.com"),
				new Doctor("Dr. Julian Mercer", "Orthopedics", "Bone & Joint Hospital", "Austin", 190.00, 22,
						"jmercer@apexjoint.com"),
				new Doctor("Dr. Amara Patel", "Oncology", "Hope Cancer Center", "Houston", 250.00, 15,
						"a.patel@hopecancer.com"),
				new Doctor("Dr. Kenji Sato", "Gastroenterology", "Pacific Medical Hub", "Seattle", 165.00, 12,
						"kenji.sato@pacificmed.com"),
				new Doctor("Dr. Chloe Dubois", "Psychiatry", "Mind Care Alliance", "Denver", 180.00, 9,
						"c.dubois@mindcare.org"),
				new Doctor("Dr. Thomas Wright", "Ophthalmology", "Clear Eye Institute", "Miami", 140.00, 16,
						"twright@clearvision.com"),
				new Doctor("Dr. Linda Nwosu", "Endocrinology", "Valley Diabetes Clinics", "Phoenix", 160.00, 13,
						"linda.nwosu@valleyendocrinology.com"));
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Find doctors whose names match LIKE '%Raj%'.\r\n"
				+ "2. Find doctors whose specialization is in [Cardiology, Neurology].\r\n"
				+ "3. Find doctors whose names start with 'Dr. A'.\r\n"
				+ "4. Find doctors whose names end with 'Kumar'.\r\n"
				+ "5. Find doctors located in Chennai or Bengaluru using IN.\r\n"
				+ "6. Find hospitals matching LIKE '%Care%'.\r\n"
				+ "7. Find doctors with email ending '@hospital.com'.\r\n"
				+ "8. Find specializations starting with 'Ortho'.\r\n"
				+ "9. Update a doctor record and verify version increments.\r\n"
				+ "10. Verify createdAt remains unchanged while updatedAt changes after update." + "11. Exit.");
//		repo.saveAll(listOfDoctors());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> ds.nameLike("%Julian%").forEach(IO::println);
			
			case 2 -> ds.specializationIn(List.of("Cardiology","Neurology")).forEach(IO::println);
			
			case 3 -> ds.nameStartsWith("Dr").forEach(IO::println);
			
			case 4 -> ds.nameEndsWith("khan").forEach(IO::println);
			
			case 5 -> ds.cityIn(List.of("Miami","Austin")).forEach(IO::println);
			
			case 6 -> ds.hispitalNameLike("%Care%").forEach(IO::println);
			
			case 7 -> ds.emailEndingWith(".org").forEach(IO::println);
			
			case 8 -> ds.specsStartsWith("Ortho").forEach(IO::println);
			
			case 9 -> IO.println(ds.updateRecord(Long.parseLong(IO.readln("Enter id for change the experience: ")), Integer.parseInt(IO.readln("Enter the experience: "))));
			
			case 10 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
