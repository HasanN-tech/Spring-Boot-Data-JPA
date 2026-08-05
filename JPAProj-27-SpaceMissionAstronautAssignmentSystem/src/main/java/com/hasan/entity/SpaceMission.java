package com.hasan.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MTM_Missions")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class SpaceMission {
	@Id
	@SequenceGenerator(name = "mission", sequenceName = "mission_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mission_seq")
	private Integer missionId;
	
	@NonNull
	private String missionName;
	
	@NonNull
	private Integer launchYear;
	
	@NonNull
	private String destination;
	
	@NonNull
	private String missionDuration;
	
	@ManyToMany(mappedBy = "missions",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Astronaut> astronauts;

	@Override
	public String toString() {
		return "SpaceMission [missionId=" + missionId + ", missionName=" + missionName + ", launchYear="
				+ launchYear + ", destination=" + destination + ", missionDuration=" + missionDuration + "]";
	}
		
}
