package com.hasan.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Booking;
import com.hasan.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repo;

	public List<Booking> cityOrRoomType(String c, String r) {
		return repo.findByCityOrRoomType(c, r);
	}

	public List<Booking> bookingAmtBtwn(Double min, Double max) {
		return repo.findByBookingAmountBetween(min, max);
	}

	public List<Booking> numOfDaysBtwn(int min, int max) {
		return repo.findByNumberOfDaysBetween(min, max);
	}

	public List<Booking> statusOrCity(String s, String c) {
		return repo.findByBookingStatusOrCity(s, c);
	}

	public List<Booking> dateBtwn(LocalDate s, LocalDate e) {
		return repo.findByBookingDateBetween(s, e);
	}

	public List<Booking> nameOrStatus(String n, String s) {
		return repo.findByGuestNameOrBookingStatus(n, s);
	}
	
	public List<Booking> roomOrStatus(String r,String s){
		return repo.findByRoomTypeOrBookingStatus(r, s);
	}
	
	public List<Booking> idBtwn(Long s,Long e){
		return repo.findByBookingIdBetween(s, e);
	}
}
