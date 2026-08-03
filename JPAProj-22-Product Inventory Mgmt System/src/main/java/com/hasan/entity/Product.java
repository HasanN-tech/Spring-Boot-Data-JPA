package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Product_Version")
public class Product {
	@Id
	@SequenceGenerator(name = "product_ver", sequenceName = "product_ver", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_ver")
	private Long productId;

	@NonNull
	@Column(length = 30)
	private String productName;

	@NonNull
	private Double price;
	
	@NonNull
	private Integer quantity;
	
	@Version
	private Integer version;
		
}
