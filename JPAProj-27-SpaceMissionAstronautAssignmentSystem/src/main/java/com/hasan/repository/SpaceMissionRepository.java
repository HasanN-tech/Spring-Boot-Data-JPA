package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hasan.entity.SpaceMission;
import java.util.List;


public interface SpaceMissionRepository extends JpaRepository<SpaceMission, Integer> {
	public List<SpaceMission> findByMissionName(String missionName);
	
	@Query("Select m from Astronaut a join a.missions m where a.astronautName=:name")
	public List<SpaceMission> findMissionByAstronaut(String name);
}
