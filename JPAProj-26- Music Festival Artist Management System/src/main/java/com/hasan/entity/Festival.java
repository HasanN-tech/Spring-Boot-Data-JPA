package com.hasan.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MTM_Festival")
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Festival {
	@Id
	@SequenceGenerator(name = "Festival", sequenceName = "festival_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "festival_seq")
	private Integer festivalId;

	@NonNull
	private String festivalName;
	
	@NonNull
	private String city;
	
	@NonNull
	private String eventDate;
	
	@NonNull
	private Double ticketPrice;

	@ManyToMany(mappedBy = "festivals",fetch = FetchType.EAGER)
	private List<Artist> artists;
}
