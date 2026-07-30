package com.hasan.entity;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Booking {
	@Id
	@SequenceGenerator(name="booking_gen",sequenceName = "booking_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "booking_gen")
	private Long bookingId;

	@Nonnull
	@Column(length = 30)
	private String guestName;

	@Nonnull
	@Column(length = 25)
	private String roomType;
	
	@Nonnull
	@Column(length = 20)
	private String city;

	@Nonnull
	private Double bookingAmount;
	
	@Nonnull
	private Integer numberOfDays;
	
	@Nonnull
	private LocalDate bookingDate;
	
	@Nonnull
	@Column(length = 20)
	private String bookingStatus;
}
