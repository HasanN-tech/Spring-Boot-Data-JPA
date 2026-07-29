package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.GymMember;
import com.hasan.services.GymMemberService;

@Component
public class RentalBookRunner implements CommandLineRunner {

	@Autowired
	private GymMemberService rs;

	public List<GymMember> listOfMembers() {
		return List.of(new GymMember("John Doe", "Premium", 12, 1200.00),
				new GymMember("Jane Smith", "Basic", 3, 350.00), new GymMember("Alex Jones", "Standard", 6, 650.00),
				new GymMember("Sarah Connor", "VIP", 24, 2500.00), new GymMember("Michael Scott", "Basic", 1, 150.00),
				new GymMember("Bruce Wayne", "VIP", 12, 1800.00), new GymMember("Clark Kent", "Standard", 12, 1100.00),
				new GymMember("Diana Prince", "Premium", 6, 800.00));
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Register a gym member using save().\r\n" + "2. Register multiple members using saveAll().\r\n"
				+ "3. Display all members using findAll().\r\n" + "4. Search member details using findById().\r\n"
				+ "5. Check member availability using existsById().\r\n"
				+ "6. Count registered members using count().\r\n" + "7. Update membership fees using save().\r\n"
				+ "8. Delete a member using deleteById().\r\n" + "9. Delete all members using deleteAll()."
				+ "10. Exit.");

		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> IO.println(rs.saveMember(new GymMember("Hasan", "V.VIP", 12, 3200.0)));

			case 2 -> IO.println(rs.saveAllMembers(listOfMembers()));

			case 3 -> rs.getAllMembers().forEach(IO::println);

			case 4 -> IO.println(rs.getMemberById(Long.parseLong(IO.readln("Enter id for search: "))));

			case 5 -> IO.println(rs.MemberExists(Long.parseLong(IO.readln("Enter id for search: "))));
			
			case 6 -> IO.println("Total Members: "+rs.countMembers());
			
			case 7 -> IO.println(rs.updateMember(Long.parseLong(IO.readln("Enter id for update: ")),Double.parseDouble(IO.readln("Enter updated fees: "))));

			case 8 -> IO.println(rs.deleteMemberById(Long.parseLong(IO.readln("Enter id for delete: "))));

			case 9 -> IO.println(rs.deleteAllMembers());

			case 10 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
