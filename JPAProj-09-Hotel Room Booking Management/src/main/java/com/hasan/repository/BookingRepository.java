package com.hasan.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	public List<Booking> findByCityOrRoomType(String city, String roomType);
	public List<Booking> findByBookingAmountBetween(Double minAmount, Double maxAmount);
	public List<Booking> findByNumberOfDaysBetween(Integer minDays, Integer maxDays);
	public List<Booking> findByBookingStatusOrCity(String status, String city);
	public List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
	public List<Booking> findByGuestNameOrBookingStatus(String guestName, String status);
	public List<Booking> findByRoomTypeOrBookingStatus(String roomType, String status);
	public List<Booking> findByBookingIdBetween(Long startId, Long endId);
}
