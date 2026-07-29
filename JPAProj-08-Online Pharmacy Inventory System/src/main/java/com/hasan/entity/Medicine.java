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
public class Medicine {
	@Id
	@SequenceGenerator(name="medicine_gen",sequenceName = "medicine_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medicine_seq")
	private Long medicineId;

	@Nonnull
	@Column(length = 30)
	private String medicineName;

	@Nonnull
	@Column(length = 25)
	private String category;
	
	@Nonnull
	@Column(length = 25)
	private String manufacturer;

	@Nonnull
	private Double price;
	
	@Nonnull
	private Integer stockQuantity;
	
	@Nonnull
	private LocalDate expiryDate;
	
	@Nonnull
	private Double rating;
}
