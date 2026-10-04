package com.hasan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Medicine;
import com.hasan.service.MedicineServices;

@Component
public class MedicineRunner implements CommandLineRunner {

	@Autowired
	private MedicineServices os;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=true;
		while(flag) {
			int choice=Integer.parseInt(IO.readln("Enter your choice: "));
			
			switch (choice) {
			case 1 -> os.add(new Medicine("PCM", "Antibiotic", "Government", 30000.0, 12));
			
			case 2 -> os.serachCategory("Antibiotic").forEach(IO::println);
			
			case 3 -> os.serachManufacturer("Government").forEach(IO::println);
			
			case 4 -> os.stockGreater(8).forEach(IO::println);
			
			case 5 -> os.delete(Integer.parseInt(IO.readln("Enter id: ")));
			
			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
