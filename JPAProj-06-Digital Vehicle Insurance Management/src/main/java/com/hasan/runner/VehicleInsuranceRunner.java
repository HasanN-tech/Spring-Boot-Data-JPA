package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.VehicleInsurance;
import com.hasan.services.VehicleInsuranceService;

@Component
public class VehicleInsuranceRunner implements CommandLineRunner {

	@Autowired
	private VehicleInsuranceService rs;

	public List<VehicleInsurance> listOfVehicleDetails() {
		return List.of(new VehicleInsurance("TS-09-EA-1234", "John Doe", "Tata AIG", 12000.00),
				new VehicleInsurance("DL-01-CA-5678", "Jane Smith", "HDFC Ergo", 8500.00),
				new VehicleInsurance("MH-12-BP-9012", "Alex Jones", "Bajaj Allianz", 9800.00),
				new VehicleInsurance("KA-03-MM-3456", "Sarah Connor", "ICICI Lombard", 15500.00),
				new VehicleInsurance("HR-26-ZZ-7890", "Michael Scott", "Star Alliance", 6200.00),
				new VehicleInsurance("KA-51-BB-0007", "Bruce Wayne", "Reliance General", 25000.00),
				new VehicleInsurance("UP-16-XY-4321", "Clark Kent", "National Insurance", 7400.00),
				new VehicleInsurance("MH-02-EE-8888", "Diana Prince", "Oriental Insurance", 11200.00));
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Add a vehicle insurance policy using save().\r\n"
				+ "2. Add multiple insurance policies using saveAll().\r\n"
				+ "3. Display all policies using findAll().\r\n" + "4. Search policy by ID using findById().\r\n"
				+ "5. Check policy existence using existsById().\r\n" + "6. Count total policies using count().\r\n"
				+ "7. Update premium amount using save().\r\n" + "8. Delete a policy using deleteById().\r\n"
				+ "9. Delete all policies using deleteAll()." + "10. Exit.");

		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> IO.println(rs.addPolicy(new VehicleInsurance("UP-42-AA-9012", "Mohd Hasan", "Third Party", 3200.0)));

			case 2 -> IO.println(rs.addMultiplePolicies(listOfVehicleDetails()));

			case 3 -> rs.getAllPolicies().forEach(IO::println);

			case 4 -> IO.println(rs.getPolicyById(Long.parseLong(IO.readln("Enter id for search: "))));

			case 5 -> IO.println(rs.PolicyExists(Long.parseLong(IO.readln("Enter id for search: "))));

			case 6 -> IO.println("Total Members: " + rs.countPolicies());

			case 7 -> IO.println(rs.updatePolicy(Long.parseLong(IO.readln("Enter id for update: ")),
					Double.parseDouble(IO.readln("Enter updated fees: "))));

			case 8 -> IO.println(rs.deletePolicy(Long.parseLong(IO.readln("Enter id for delete: "))));

			case 9 -> IO.println(rs.deleteAllPolicies());

			case 10 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
