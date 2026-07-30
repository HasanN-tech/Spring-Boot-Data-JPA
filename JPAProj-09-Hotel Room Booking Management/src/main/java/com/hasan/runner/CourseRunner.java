package com.hasan.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Booking;
import com.hasan.repository.BookingRepository;
import com.hasan.services.BookingService;

@Component
public class CourseRunner implements CommandLineRunner {

	@Autowired
	private BookingService bs;
	
	@Autowired
	private BookingRepository repo;

	public List<Booking> listOfBooking() {
		return List.of(
			    new Booking("Alice Smith", "Deluxe", "New York", 450.00, 3, LocalDate.of(2026, 6, 20), "CONFIRMED"),
			    new Booking("Bob Jones", "Standard", "London", 120.00, 1, LocalDate.of(2026, 6, 21), "PENDING"),
			    new Booking("Charlie Brown", "Suite", "Paris", 1250.50, 5, LocalDate.of(2026, 6, 22), "CONFIRMED"),
			    new Booking("Diana Prince", "Deluxe", "Tokyo", 600.00, 2, LocalDate.of(2026, 6, 23), "CANCELLED"),
			    new Booking("Evan Wright", "Standard", "Berlin", 240.00, 2, LocalDate.of(2026, 6, 24), "CONFIRMED"),
			    new Booking("Fiona Gallagher", "Suite", "Chicago", 750.00, 3, LocalDate.of(2026, 6, 25), "PENDING"),
			    new Booking("George Clark", "Deluxe", "Sydney", 880.00, 4, LocalDate.of(2026, 6, 26), "CONFIRMED"),
			    new Booking("Hannah Abbott", "Standard", "Mumbai", 95.00, 1, LocalDate.of(2026, 6, 27), "CONFIRMED"),
			    new Booking("Ian Malcolm", "Suite", "Las Vegas", 1600.00, 4, LocalDate.of(2026, 6, 28), "CANCELLED"),
			    new Booking("Julia Roberts", "Deluxe", "Rome", 500.00, 2, LocalDate.of(2026, 6, 29), "CONFIRMED")
			);
	}

	@Override
	public void run(String... args) throws Exception {
		IO.println("1. Chennai or Suite.\r\n"
				+ "2. Amount 5000-15000.\r\n"
				+ "3. Days 2-5.\r\n"
				+ "4. Confirmed or Hyderabad.\r\n"
				+ "5. Dates 2026-01-01 to 2026-03-31.\r\n"
				+ "6. Anita or Cancelled.\r\n"
				+ "7. Deluxe or Pending.\r\n"
				+ "8. IDs 101-110." + "9. Exit.");
		repo.saveAll(listOfBooking());
		boolean flag = true;
		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> bs.cityOrRoomType(IO.readln("Enter the city: "),IO.readln("Enter thee room type: ")).forEach(IO::println);
			
			case 2 -> bs.bookingAmtBtwn(200.0, 500.0).forEach(IO::println); 
			
			case 3 -> bs.numOfDaysBtwn(2, 4).forEach(IO::println);
			
			case 4 -> bs.statusOrCity("Pending", "kh").forEach(IO::println);
			
			case 5 -> bs.dateBtwn(LocalDate.of(2026, 06, 20),LocalDate.of(2026, 06, 25)).forEach(IO::println);
			
			case 6 -> bs.nameOrStatus("Evan Wright", "CANCELLED").forEach(IO::println);
			
			case 7-> bs.roomOrStatus("Suite", "Pending").forEach(IO::println);
			
			case 8 -> bs.idBtwn(2L, 5L).forEach(IO::println);
			
			case 9 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
