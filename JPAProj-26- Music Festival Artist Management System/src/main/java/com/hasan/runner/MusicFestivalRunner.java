package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Artist;
import com.hasan.entity.Festival;
import com.hasan.service.MusicFestivalService;

@Component
public class MusicFestivalRunner implements CommandLineRunner {

	@Autowired
	private MusicFestivalService ss;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			
			Festival f1=new Festival("Sunburn","Goa","12/12/2020",5000.0);
			Festival f2=new Festival("Diwali","Pune","20/06/2021",6000.0);
			Festival f3=new Festival("Lohri","Punjab","14/02/2019",4500.0);
			Festival f4=new Festival("Holi","Haryana","27/08/2022",5500.0);

			
			
			Artist a1=new Artist("Arijit Singh", "Playback", "India", 10);
			a1.setFestivals(List.of(f1,f2));
			Artist a2=new Artist("Honey Singh", "Rap", "Canada", 13);
			a2.setFestivals(List.of(f3,f4));
			
			f1.setArtists(List.of(a1,a2));
			f2.setArtists(List.of(a1));
			
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {
			case 1 -> {
				IO.println(ss.addArtistRecord(a1));
			}

			case 2 -> {
				IO.println(ss.addFestivalRecord(f1));
			}
			
			case 3 -> {
				IO.println(ss.findArtistByName("Honey Singh"));
			}
			
			case 4 -> {
				IO.println(ss.findFestivalByName("Holi"));
			}
			case 5 -> ss.findAllArtistByFestival("Lohri").forEach(IO::println);

			case 6 -> ss.findAllFestivalByArtist("Honey Singh").forEach(IO::println);

			case 7 -> IO.println(ss.updateTicketPrice(100, 4800.0));

			case 8 -> IO.println(ss.updateArtistExp(100, 15));
			
			case 9 -> IO.println(ss.deleteArtist(100));
			
			case 10 -> IO.println(ss.deleteFestival(100));

			case 11 -> ss.viewArtist().forEach(IO::println);

			case 12 -> ss.viewFestival().forEach(IO::println);
			
			case 13 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
