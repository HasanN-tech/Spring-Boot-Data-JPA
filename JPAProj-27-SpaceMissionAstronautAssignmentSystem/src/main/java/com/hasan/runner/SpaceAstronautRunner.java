package com.hasan.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Astronaut;
import com.hasan.entity.SpaceMission;
import com.hasan.service.AstronautServices;
import com.hasan.service.SpaceMissionService;

@Component
public class SpaceAstronautRunner implements CommandLineRunner {

	@Autowired
	private AstronautServices as;

	@Autowired
	private SpaceMissionService sm;

	@Override
	public void run(String... args) throws Exception {
		SpaceMission m1 = new SpaceMission("Mission Mangalam", 2020, "Mars", "7 months");
		SpaceMission m2 = new SpaceMission("Chandrayan 1", 2014, "Moon south pole", "3 months");
		SpaceMission m3 = new SpaceMission("Chandrayan 2", 2017, "Moon north pole", "9 months");

		Astronaut a1 = new Astronaut("Neil arm strong", "Moon Walker", "American", 3);
		Astronaut a2 = new Astronaut("Vaibhav", "Pilot", "Indian", 7);
		Astronaut a3 = new Astronaut("Hasan", "Director", "Indian", 10);

		a1.setMissions(Set.of(m1, m2));
		a2.setMissions(Set.of(m2, m3));
		a3.setMissions(Set.of(m3, m1));

		m1.setAstronauts(Set.of(a2, a3));
		m2.setAstronauts(Set.of(a1, a2));
		m3.setAstronauts(Set.of(a2, a3));

		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));

			switch (choice) {
			case 1 -> IO.println(as.addAstronaut(a3));

			case 2 -> IO.println(sm.addMission(m3));

			case 3 -> as.getByName("Vaibhav").forEach(IO::println);

			case 4 -> sm.getByMission("Chandrayan 1").forEach(IO::println);

			case 5 -> as.getAstronautsByMission("Chandrayan 1").forEach(IO::println);

			case 6 -> sm.getMissionsByAstronaut("Neil arm strong").forEach(IO::println);

			case 7 -> IO.println(sm.updateDestination(2, "Jupiter"));
			
			case 8 -> IO.println(as.updateFlights(2, 6));
			
			case 9 -> IO.println(as.deleteAstronaut(53));

			case 10 -> IO.println(sm.deleteMission(53));
			
			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}

	}

}
