package com.hasan.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hasan.entity.HockeyPlayer;

import jakarta.transaction.Transactional;

@Repository
public interface HockeyPlayerRepository extends JpaRepository<HockeyPlayer, Long> {

	@Query("Select h from HockeyPlayer h WHERE h.teamName=:team")
	public List<HockeyPlayer> findByTeamName(String team);

	@Query("SELECT h FROM HockeyPlayer h WHERE h.goals > :goals")
	public List<HockeyPlayer> findPlayersWithGoalsGreaterThan(@Param("goals") Integer goals);

	@Query("SELECT h FROM HockeyPlayer h WHERE h.role = :role AND h.country = :country")
	public List<HockeyPlayer> findByRoleAndCountry(@Param("role") String role, @Param("country") String country);

	@Query("SELECT h FROM HockeyPlayer h WHERE h.playerName LIKE %:keyword%")
	public List<HockeyPlayer> findByNameContains(@Param("keyword") String keyword);

	@Query("SELECT h FROM HockeyPlayer h WHERE h.experience BETWEEN :minExp AND :maxExp")
	public List<HockeyPlayer> findByExperienceBetween(@Param("minExp") Integer minExp, @Param("maxExp") Integer maxExp);

	@Query("SELECT COUNT(h) FROM HockeyPlayer h WHERE h.teamName = :team")
	public Long countPlayersByTeam(@Param("team") String team);

	@Query("SELECT h FROM HockeyPlayer h ORDER BY h.goals DESC")
	public List<HockeyPlayer> findPlayersOrderByGoalsDesc();

	@Modifying
	@Transactional
	@Query("UPDATE HockeyPlayer h SET h.goals = :goals, h.version=version+1, updatedAt=:time WHERE h.playerId = :id")
	public int updateGoals(@Param("id") Long id, @Param("goals") Integer goals, @Param("time") LocalDateTime time);

	@Modifying
	@Transactional
	@Query("DELETE FROM HockeyPlayer h WHERE h.country = :country")
	public int deleteByCountry(@Param("country") String country);

	@Query("SELECT h.playerName, h.goals FROM HockeyPlayer h")
	public List<Object[]> getPlayerNameAndGoals();

}
