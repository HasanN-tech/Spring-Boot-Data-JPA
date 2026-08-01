package com.hasan.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OTO_Customer")
public class Customer {
	@Id
	@SequenceGenerator(name = "customer_otm", sequenceName = "customer_otm", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_otm")
	private Long customerId;

	@NonNull
	@Column(length = 30)
	private String customerName;

	@NonNull
	@Column(length = 30)
	private String email;

	@NonNull
	@Column(length = 30)
	private String city;

	@NonNull
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private PanCard panCard;
}
