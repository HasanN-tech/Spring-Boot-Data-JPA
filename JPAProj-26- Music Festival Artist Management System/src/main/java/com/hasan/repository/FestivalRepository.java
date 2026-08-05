package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hasan.entity.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Integer> {
	public Festival findByFestivalName(String f);
	
	@Query("Select f from Festival f join f.artists a where a.artistName=:n")
	public List<Festival> getByArtistName(String n);
}
