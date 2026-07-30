package com.hasan.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Footballer;

import jakarta.transaction.Transactional;

@Repository
public interface FootballPlayerRepository extends JpaRepository<Footballer, Long> {
	@Query("Select f from Footballer f where f.club=:club")
	public List<Footballer> findByClub(String club);

	@Query("SELECT f FROM Footballer f WHERE f.salary > :salary")
	List<Footballer> findPlayersWithSalaryGreaterThan(@Param("salary") Double salary);

	@Query("SELECT f FROM Footballer f WHERE f.position = :position AND f.country = :country")
	List<Footballer> findByPositionAndCountry(@Param("position") String position, @Param("country") String country);

	@Query("SELECT f FROM Footballer f WHERE f.playerName LIKE CONCAT(:prefix, '%')")
	List<Footballer> findByNameStartsWith(@Param("prefix") String prefix);

	@Query("SELECT f FROM Footballer f WHERE f.jerseyNumber BETWEEN :start AND :end")
	List<Footballer> findByJerseyNumberBetween(@Param("start") Integer start, @Param("end") Integer end);

	@Query("SELECT COUNT(f) FROM Footballer f WHERE f.country = :country")
	Long countPlayersByCountry(@Param("country") String country);


	@Query("SELECT f FROM Footballer f WHERE f.salary = (SELECT MAX(f2.salary) FROM Footballer f2)")
	public Footballer findHighestPaidPlayers();

	@Modifying
	@Transactional
	@Query("UPDATE Footballer f SET f.salary = :salary, f.version = f.version + 1, f.updatedAt=:time WHERE f.playerId = :id")
	public int updateSalary(@Param("id") Long id, @Param("salary") Double salary,LocalDateTime time);

	@Modifying
	@Transactional
	@Query("DELETE FROM Footballer f WHERE f.club = :club")
	int deleteByClub(@Param("club") String club);
}
