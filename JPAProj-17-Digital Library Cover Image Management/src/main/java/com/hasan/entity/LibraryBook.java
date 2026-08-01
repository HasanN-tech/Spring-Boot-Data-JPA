package com.hasan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class LibraryBook {
	@Id
	@SequenceGenerator(name = "library", sequenceName = "library_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_seq")
	private Long bookId;

	@NonNull
	@Column(length = 30)
	private String bookTitle;

	@NonNull
	@Column(length = 20)
	private String authorName;
	
	@NonNull
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] coverImage;

}
