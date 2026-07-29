package com.hasan.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Medicine;
import com.hasan.repository.MedicineRepository;
import com.hasan.services.MedicineService;

@Component
public class MedicineRunner implements CommandLineRunner {

	@Autowired
	private MedicineService ms;
	
	@Autowired
	private MedicineRepository repo;

	public List<Medicine> listOfMedicines() {
		return List.of(
			    new Medicine("Dwa", "All rounder", "Hasan Nawab", 1000.0, 100, LocalDate.of(2026, 6, 29), 5.0),
			    new Medicine("Paracetamol", "Analgesic", "GlobalPharma", 5.50, 150, LocalDate.of(2027, 4, 15), 4.5),
			    new Medicine("Amoxicillin", "Antibiotic", "BioHealth Corp", 12.75, 80, LocalDate.of(2026, 11, 30), 4.2),
			    new Medicine("Ibuprofen", "NSAID", "MedLife Labs", 4.20, 200, LocalDate.of(2028, 2, 10), 4.7),
			    new Medicine("Metformin", "Antidiabetic", "Zeta Care", 8.90, 120, LocalDate.of(2027, 8, 25), 4.0),
			    new Medicine("Atorvastatin", "Statins", "Nova Pharma", 15.30, 60, LocalDate.of(2027, 1, 18), 4.6),
			    new Medicine("Omeprazole", "Antacid", "Aura Health", 6.80, 95, LocalDate.of(2026, 9, 5), 4.3),
			    new Medicine("Cetirizine", "Antihistamine", "Apex Labs", 3.50, 250, LocalDate.of(2028, 5, 22), 4.8),
			    new Medicine("Losartan", "Antihypertensive", "OmniMedic", 11.20, 110, LocalDate.of(2027, 12, 14), 4.1),
			    new Medicine("Azithromycin", "Antibiotic", "Vedic Life", 14.60, 45, LocalDate.of(2026, 8, 30), 4.4),
			    new Medicine("Albuterol", "Bronchodilator", "BreatheEasy", 22.10, 70, LocalDate.of(2027, 10, 10), 4.9)
			);
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Antibiotic or ABC Pharma.\r\n"
				+ "2. Price 100-500.\r\n"
				+ "3. Stock 50-200.\r\n"
				+ "4. Paracetamol or Pain Relief.\r\n"
				+ "5. Expiry 2026-06-01 to 2026-12-31.\r\n"
				+ "6. Rating 4.0-5.0.\r\n"
				+ "7. IDs 201-210" + "8. Exit.");
		repo.saveAll(listOfMedicines());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			
			case 1 -> ms.categoryOrManufacturer("Antibiotic", "Hasan Nawab").forEach(IO::println);
			
			case 2 -> ms.priceBtwn(4.0, 10.0).forEach(IO::println);
			
			case 3 -> ms.stockBtwn(30, 100).forEach(IO::println);
			
			case 4 -> ms.nameOrCategory("Paracetamol", "Antacid").forEach(IO::println);
			
			case 5 -> ms.expiryBtwn(LocalDate.now(), LocalDate.of(2027, 12, 31)).forEach(IO::println);
			
			case 6 -> ms.ratingBtwn(4.1, 4.6).forEach(IO::println);
			
			case 7 -> ms.idBtwn(63L, 70L).forEach(IO::println);
			
			case 8 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
