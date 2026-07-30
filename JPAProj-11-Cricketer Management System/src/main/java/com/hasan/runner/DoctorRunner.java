package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Cricketer;
import com.hasan.repository.CricketerRepository;
import com.hasan.services.CricketerService;

@Component
public class DoctorRunner implements CommandLineRunner {

	@Autowired
	private CricketerService cs;

	@SuppressWarnings("unused")
	@Autowired
	private CricketerRepository repo;

	public List<Cricketer> listOfCricketers() {
		return List.of(new Cricketer("Virat Kohli","India","Batsman","RCB",57.8,300,82,37,false),
				new Cricketer("Rohit Sharma","India","Batsman","MI",49.3,280,35,39,false),
				new Cricketer("Jasprit Bumrah","India","Bowler","MI",18.5,180,0,33,false),
				new Cricketer("Joe Root","England","Batsman","Yorkshire",50.6,210,36,35,false),
				new Cricketer("Ben Stokes","England","All-Rounder","Durham",37.2,160,13,34,false),
				new Cricketer("David Warner","Australia","Batsman","Delhi Capitals",45.8,190,25,39,true),
				new Cricketer("Pat Cummins","Australia","Bowler","SRH",20.1,170,0,34,false),
				new Cricketer("Babar Azam","Pakistan","Batsman","Peshawar",54.5,145,31,31,false));
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.saveAll(listOfCricketers());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> cs.country("Australia").forEach(IO::println);
			
			case 2 -> cs.avgGreater(30.0).forEach(IO::println);
			
			case 3 -> cs.batsman().forEach(IO::println);
			
			case 4 -> cs.nameStarting("Ben").forEach(IO::println);
			
			case 5 -> cs.retiredPlayer().forEach(IO::println);
			
			case 6 -> cs.moreCenturies(20).forEach(IO::println);
			
			case 7 -> cs.ageRange(35, 40).forEach(IO::println);
			
			case 8 -> cs.team("RCB").forEach(IO::println);
			
			case 9 -> IO.println(cs.countryCount("England"));
			
			case 10 -> IO.println(cs.topAvg());
			
			case 11 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
