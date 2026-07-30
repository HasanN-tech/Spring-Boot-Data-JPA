package com.hasan.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.HockeyPlayer;
import com.hasan.repository.HockeyPlayerRepository;

@Service
public class HockeyPlayerService {

	@Autowired
	private HockeyPlayerRepository repo;

	public List<HockeyPlayer> team(String s) {
		return repo.findByTeamName(s);
	}

	public List<HockeyPlayer> goalGreater(Integer g) {
		return repo.findPlayersWithGoalsGreaterThan(g);
	}

	public List<HockeyPlayer> roleAndCountry(String r, String c) {
		return repo.findByRoleAndCountry(r, c);
	}

	public List<HockeyPlayer> name(String n) {
		return repo.findByNameContains(n);
	}

	public List<HockeyPlayer> experienceBtwn(int s, int e) {
		return repo.findByExperienceBetween(s, e);
	}

	public Long countByTeam(String t) {
		return repo.countPlayersByTeam(t);
	}

	public List<HockeyPlayer> descOrderByGoal() {
		return repo.findPlayersOrderByGoalsDesc();
	}

	public void update(long id,int g) {
		int z=repo.updateGoals(id,g,LocalDateTime.now());
		if(z>0) IO.println("Updated.");
		else IO.println("Not updated.");
	}

	public void dltByCountry(String c) {
		int z= repo.deleteByCountry(c);
		if(z>0) IO.println(z+" records deleted.");
		else IO.println("Invalid country");
	}
	
	public List<Object[]> nameAndGoal(){
		return repo.getPlayerNameAndGoals();
	}
}
