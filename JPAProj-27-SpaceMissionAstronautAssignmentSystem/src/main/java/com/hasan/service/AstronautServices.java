package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Astronaut;
import com.hasan.repository.AstronautRepository;

@Service
public class AstronautServices {
	@Autowired
	private AstronautRepository repo;

	public String addAstronaut(Astronaut a) {
		if (a != null) {
			repo.save(a);
			return "Data Saved.";
		} else
			return "Invalid Data";
	}
	
	public List<Astronaut> getByName(String n){
		return repo.findByAstronautName(n);
	}
	
	public List<Astronaut> getAstronautsByMission(String m){
		return repo.findByMission(m);
	}
	
	public String updateFlights(int id,Integer f) {
		if(repo.existsById(id)) {
			Astronaut a=repo.findById(id).get();
			a.setTotalFlights(f);
			repo.save(a);
			return "Updated.";
		}else return "Id not found.";
	}
	
	public String deleteAstronaut(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Deleted.";
		}else return "Id not found.";
	}
}
