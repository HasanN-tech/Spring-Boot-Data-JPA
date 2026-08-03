package com.hasan.entity;

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
@Table(name="OTM_Book")
public class Book {
	@Id
	@SequenceGenerator(name = "Book1", sequenceName = "Book1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Book1")
	private Long bookId;

	@NonNull
	@Column(length = 30)
	private String bookTitle;

	@NonNull
	@Column(length = 20)
	private String authorName;
	
	@NonNull
	private Double price;
	
//	@ManyToOne
//	@JoinColumn(name="library_id")
//	private Library library;
	
}
