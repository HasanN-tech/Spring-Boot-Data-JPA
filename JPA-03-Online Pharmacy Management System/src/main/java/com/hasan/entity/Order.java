package com.hasan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name="Order111")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer orderId;
	
	@NonNull
	public String cName;
	
	@NonNull
	public String pName;
	
	@NonNull
	public String category;
	
	@NonNull
	public Double amount;
	
	@NonNull
	public String paymentMode;
	
	@NonNull
	public String status;
	

}
