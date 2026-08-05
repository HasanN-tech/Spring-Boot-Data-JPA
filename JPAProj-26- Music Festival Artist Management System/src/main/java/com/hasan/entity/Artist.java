package com.hasan.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "MTM_Artist")
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Artist {
	@Id
	@SequenceGenerator(name = "artist", sequenceName = "artist_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_seq")
	private Integer artistId;

	@NonNull
	private String artistName;

	@NonNull
	private String genre;

	@NonNull
	private String country;

	@NonNull
	private Integer experienceYear;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "artist_festival", joinColumns = @JoinColumn(name = "artistId"), inverseJoinColumns = @JoinColumn(name = "festivalId"))
	private List<Festival> festivals;

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", genre=" + genre + ", country="
				+ country + ", experienceYear=" + experienceYear + "]";
	}

}
