package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hasan.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	public Artist findByArtistName(String n);
	
	@Query("Select a from Artist a join a.festivals f where f.festivalName=:f")
	public List<Artist> findAllByFestivalName(String f);
}
