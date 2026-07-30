package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Cricketer;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long>{
	@Query("SELECT c FROM Cricketer c WHERE c.country = :country")
	public List<Cricketer> findByCountry(String country);
	
	
	@Query("select c from Cricketer c where c.battingAverage>:avg")
	public List<Cricketer> findPlayerWithAverageGreaterThan(Double avg);
	
	@Query("Select c from Cricketer c where role='Batsman'")
	public List<Cricketer> findAllBatsman();
	
	@Query("Select c from Cricketer c where c.playerName like CONCAT(:fName,'%')")
	public List<Cricketer> findPlayersStartingWith(String fName);
	
	@Query("SELECT c FROM Cricketer c WHERE c.retired = true")
	public List<Cricketer> findRetiredPlayers();
	
	@Query("SELECT c FROM Cricketer c WHERE c.centuries > :count")
	public List<Cricketer> findPlayersWithMoreCenturies(Integer count);
	
	@Query("SELECT c FROM Cricketer c WHERE c.age BETWEEN :minAge AND :maxAge")
	public List<Cricketer> findPlayersByAgeRange(Integer minAge, Integer maxAge);
	
	@Query("SELECT c FROM Cricketer c WHERE c.team = :team")
	public List<Cricketer> findByTeam(String team);
	
	@Query("SELECT COUNT(c) FROM Cricketer c WHERE c.country = :country")
	public Long countPlayersByCountry(String country);
	
	@Query("SELECT c FROM Cricketer c WHERE c.battingAverage = (SELECT MAX(x.battingAverage) FROM Cricketer x)")
	public Cricketer findTopAveragePlayer();
	
	
}
