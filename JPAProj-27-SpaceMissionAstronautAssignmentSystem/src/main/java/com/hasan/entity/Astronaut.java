package com.hasan.entity;

import java.util.Set;

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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MTM_Astronaut")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Astronaut {
	@Id
	@SequenceGenerator(name = "astro", sequenceName = "astro_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "astro_seq")
	private Integer astronautId;

	@NonNull
	private String astronautName;

	@NonNull
	private String specialization;

	@NonNull
	private String nationality;

	@NonNull
	private Integer totalFlights;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "astronaut_mission", joinColumns = @JoinColumn(name = "astronautId"), inverseJoinColumns = @JoinColumn(name = "missionId"))
	private Set<SpaceMission> missions;

	/*
	 * @Override public String toString() { return "Astronaut [astronautId=" +
	 * astronautId + ", astronautName=" + astronautName + ", specialization=" +
	 * specialization + ", nationality=" + nationality + ", totalFlights=" +
	 * totalFlights + ", missions=" + missions + "]"; }
	 */

}
