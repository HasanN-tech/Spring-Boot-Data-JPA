package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="OTO_PanCard")
public class PanCard {
	@Id
	@SequenceGenerator(name = "PanCard1", sequenceName = "PanCard1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PanCard1")
	private Long panId;

	@NonNull
	@Column(length = 30)
	private String panNumber;

	@NonNull
	@Column(length = 20)
	private String issueDate;
		
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

}
