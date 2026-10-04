package com.hasan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="order11")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer orderId;
	
	@NonNull
	public String cName;
	
	@NonNull
	public String pName;
	
	@NonNull
	public Integer quantiy;
	
	@NonNull
	public Double amount;
	
	@NonNull
	public String status;
	
	@CreationTimestamp
	public LocalDateTime createdAt;
	
	@UpdateTimestamp
	public LocalDateTime updatedAt;
}
