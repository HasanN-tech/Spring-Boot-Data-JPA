package com.hasan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Library_clob")
@RequiredArgsConstructor
@NoArgsConstructor
public class Library {
	@Id
	@SequenceGenerator(name = "lib_clob", sequenceName = "lib_clob", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lib_clob")
	private Integer bookId;

	@NonNull
	private String bookTitle;
	
	@NonNull
	private String author;
	
	@NonNull
	@Lob
	private String description;
	
}
