package com.hasan.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Footballer;
import com.hasan.repository.FootballPlayerRepository;

@Service
public class FootballService {

	@Autowired
	private FootballPlayerRepository repo;

	public List<Footballer> club(String s) {
		return repo.findByClub(s);
	}

	public List<Footballer> salGreater(Double sal) {
		return repo.findPlayersWithSalaryGreaterThan(sal);
	}

	public List<Footballer> positionAndCountry(String p, String c) {
		return repo.findByPositionAndCountry(p, c);
	}

	public List<Footballer> nameStartsWith(String n) {
		return repo.findByNameStartsWith(n);
	}

	public List<Footballer> jerseyNumBtwn(int s, int e) {
		return repo.findByJerseyNumberBetween(s, e);
	}

	public Long countByCountry(String c) {
		return repo.countPlayersByCountry(c);
	}

	public Footballer highestPaid() {
		return repo.findHighestPaidPlayers();
	}

	public void updateSal(Long id, Double sal) {
		/*
		 * if (repo.existsById(id)) { Footballer f = repo.findById(id).get();
		 * f.setSalary(sal); repo.save(f); IO.println(f); } else return;
		 */
		int z=repo.updateSalary(id, sal, LocalDateTime.now());
		if(z>0) {
			IO.println("Updated..");
		}else IO.println("id not found.");
	}

	public int dltByClub(String c) {
		return repo.deleteByClub(c);
	}
}
