package com.hasan.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class VehicleInsurance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long insuranceId;

	@Nonnull
	@Column(length = 15)
	private String vehicleNumber;

	@Nonnull
	@Column(length = 35)
	private String ownerName;

	@Nonnull
	@Column(length = 35)
	private String insuranceCompany;

	@Nonnull
	private Double amount;
}
