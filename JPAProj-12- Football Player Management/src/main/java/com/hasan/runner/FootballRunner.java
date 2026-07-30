package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Footballer;
import com.hasan.repository.FootballPlayerRepository;
import com.hasan.services.FootballService;

@Component
public class FootballRunner implements CommandLineRunner {

	@Autowired
	private FootballService fs;

	@SuppressWarnings("unused")
	@Autowired
	private FootballPlayerRepository repo;

	public List<Footballer> listOfFootballers() {
		return List.of(new Footballer("Hasan", "India", "barcelona", "Striker", 1200.0, 7),
				new Footballer("Kamil", "Poland", "barcelona", "Midfielder", 4500.0, 8),
				new Footballer("Arjun", "India", "real madrid", "Defender", 3200.0, 4),
				new Footballer("Leo", "Argentina", "inter miami", "Striker", 9500.0, 10),
				new Footballer("Marcus", "England", "manchester united", "Winger", 6100.0, 11),
				new Footballer("Luca", "Croatia", "real madrid", "Midfielder", 5500.0, 10),
				new Footballer("Yuki", "Japan", "arsenal", "Winger", 2800.0, 14),
				new Footballer("Carlos", "Brazil", "psg", "Defender", 4100.0, 3),
				new Footballer("Diego", "Spain", "atletico madrid", "Goalkeeper", 2300.0, 1),
				new Footballer("Rohan", "India", "bengaluru fc", "Midfielder", 850.0, 6),
				new Footballer("Amara", "Nigeria", "chelsea", "Striker", 3900.0, 9),
				new Footballer("Sven", "Germany", "bayern munich", "Goalkeeper", 5000.0, 12));
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.saveAll(listOfFootballers());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> fs.club("barcelona").forEach(IO::println);

			case 2 -> fs.salGreater(3500.0).forEach(IO::println);

			case 3 -> fs.positionAndCountry("Striker", "India").forEach(IO::println);

			case 4 -> fs.nameStartsWith("A%").forEach(IO::println);

			case 5 -> fs.jerseyNumBtwn(10, 15).forEach(IO::println);

			case 6 -> IO.println(fs.countByCountry("Japan"));

			case 7 -> IO.println(fs.highestPaid());

			case 8 -> IO.println(fs.dltByClub("barcelona"));

			case 9 -> fs.updateSal(1011L, 2000.0);

			case 10 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
