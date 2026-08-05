package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.SpaceMission;
import com.hasan.repository.SpaceMissionRepository;

@Service
public class SpaceMissionService {
	@Autowired
	private SpaceMissionRepository repo;

	public String addMission(SpaceMission m) {
		if (m != null) {
			repo.save(m);
			return "Data Saved.";
		} else
			return "Invalid Data";
	}
	
	public List<SpaceMission> getByMission(String m){
		return repo.findByMissionName(m);
	}
	
	public List<SpaceMission> getMissionsByAstronaut(String n){
		return repo.findMissionByAstronaut(n);
	}
	
	public String updateDestination(int id,String dest) {
		if(repo.existsById(id)) {
			SpaceMission sm=repo.findById(id).get();
			sm.setDestination(dest);
			repo.save(sm);
			return "Updated.";
		}else return "Id not found.";
	}
	
	public String deleteMission(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Deleted.";
		}else return "Id not found.";
	}
	
}
