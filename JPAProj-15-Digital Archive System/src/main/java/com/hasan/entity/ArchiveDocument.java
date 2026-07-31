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
public class ArchiveDocument {
	@Id
	@SequenceGenerator(name = "documents", sequenceName = "documents_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documents_seq")
	private Long documentId;

	@NonNull
	@Column(length = 30)
	private String documentTitle;

	@NonNull
	@Column(length = 20)
	private String ownerName;

	@NonNull
	@Column(length = 20)
	private String fileType;
	
	@NonNull
	@Lob
	private byte[] documentData;

}
