package com.hasan.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.HockeyPlayer;
import com.hasan.repository.HockeyPlayerRepository;
import com.hasan.services.HockeyPlayerService;

@Component
public class HockeyPlayerRunner implements CommandLineRunner {

	@Autowired
	private HockeyPlayerService hs;

	@SuppressWarnings("unused")
	@Autowired
	private HockeyPlayerRepository repo;

	public List<HockeyPlayer> listOfHockeyPlayers() {
		return List.of(new HockeyPlayer("Hasan", "India Tigers", "India", "Forward", 120, 8),
				new HockeyPlayer("Vaibhav", "Delhi Warriors", "India", "Midfielder", 95, 6),
				new HockeyPlayer("Bhupendra", "Mumbai Strikers", "India", "Defender", 40, 10),
				new HockeyPlayer("John Smith", "London Lions", "England", "Forward", 150, 12),
				new HockeyPlayer("David Miller", "Sydney Sharks", "Australia", "Goalkeeper", 10, 15),
				new HockeyPlayer("Ali Khan", "Lahore Eagles", "Pakistan", "Midfielder", 85, 7),
				new HockeyPlayer("Rahim Das", "Dhaka Dragons", "Bangladesh", "Forward", 110, 9),
				new HockeyPlayer("Michael Brown", "Toronto Titans", "Canada", "Defender", 35, 11),
				new HockeyPlayer("Chris Wilson", "Cape Cobras", "South Africa", "Forward", 130, 13),
				new HockeyPlayer("Tom Anderson", "Berlin Bears", "Germany", "Midfielder", 75, 5));
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.saveAll(listOfHockeyPlayers());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> hs.team("Mumbai Strikers").forEach(IO::println);

			case 2 -> hs.goalGreater(7).forEach(IO::println);

			case 3 -> hs.roleAndCountry("Forward", "England").forEach(IO::println);

			case 4 -> hs.name("Hasan").forEach(IO::println);

			case 5 -> hs.experienceBtwn(5, 9).forEach(IO::println);

			case 6 -> IO.println(hs.countByTeam("India Tigers"));

			case 7 -> hs.descOrderByGoal().forEach(IO::println);

			case 8 -> hs.update(7L, 58);

			case 9 -> hs.dltByCountry("Germany");

			case 10 -> hs.nameAndGoal().forEach(row -> IO.println(Arrays.toString(row)));

			case 11 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
