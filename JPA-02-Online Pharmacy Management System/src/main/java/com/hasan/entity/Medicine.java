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
@Table(name="Medicine11")
public class Medicine {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer medId;
	
	@NonNull
	public String mName;
	
	@NonNull
	public String category;
	
	@NonNull
	public String manufacturer;
	
	@NonNull
	public Double price;
	
	@NonNull
	public Integer stock;
	

}
