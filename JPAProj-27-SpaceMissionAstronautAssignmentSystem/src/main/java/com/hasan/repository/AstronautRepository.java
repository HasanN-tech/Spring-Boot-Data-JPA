package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hasan.entity.Astronaut;
import java.util.List;


public interface AstronautRepository extends JpaRepository<Astronaut, Integer> {
	public List<Astronaut> findByAstronautName(String astronautName);
	
	@Query("Select a from Astronaut a join a.missions m where m.missionName=:m")
	public List<Astronaut> findByMission(String m);
}
