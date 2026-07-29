package com.hasan.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class RentalBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@Nonnull
	@Column(length=35)
	private String bookTitle;
	
	@Nonnull
	@Column(length=35)
	private String authorName;
	
	@Nonnull
	@Column(length=35)
	private String category;
	
	@Nonnull
	@Column(precision = 6, secondPrecision = 2)
	private Double rentalPrice;
}
