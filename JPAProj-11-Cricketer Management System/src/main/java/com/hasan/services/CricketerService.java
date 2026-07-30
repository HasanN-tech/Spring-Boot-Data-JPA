package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Cricketer;
import com.hasan.repository.CricketerRepository;

@Service
public class CricketerService {
	
	@Autowired
	private CricketerRepository repo;

	public List<Cricketer> country(String str){
		return repo.findByCountry(str);
	}
	
	public List<Cricketer> avgGreater(Double avg){
		return repo.findPlayerWithAverageGreaterThan(avg);
	}
	
	public List<Cricketer> batsman(){
		return repo.findAllBatsman();
	}
	
	public List<Cricketer> nameStarting(String pre){
		return repo.findPlayersStartingWith(pre);
	}
	
	public List<Cricketer> retiredPlayer(){
		return repo.findRetiredPlayers();
	}
	
	public List<Cricketer> moreCenturies(int c){
		return repo.findPlayersWithMoreCenturies(c);
	}
	
	public List<Cricketer> ageRange(int min,int max){
		return repo.findPlayersByAgeRange(min, max);
	}
	
	public List<Cricketer> team(String t){
		return repo.findByTeam(t);
	}
	
	public Long countryCount(String c){
		return repo.countPlayersByCountry(c);
	}
	
	public Cricketer topAvg(){
		return repo.findTopAveragePlayer();
	}
	
}
