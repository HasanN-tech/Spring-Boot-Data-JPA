package com.hasan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Employee_timestamp")
public class Employee {
	@Id
	@SequenceGenerator(name = "product_ver", sequenceName = "product_ver", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_ver")
	private Long employeeId;

	@NonNull
	@Column(length = 30)
	private String employeeName;
	
	@NonNull
	@Column(length = 30)
	private String department;

	@NonNull
	private Double salary;
	
	@CreationTimestamp
	private LocalDateTime creation;
	
	@UpdateTimestamp
	private LocalDateTime updation;
}
