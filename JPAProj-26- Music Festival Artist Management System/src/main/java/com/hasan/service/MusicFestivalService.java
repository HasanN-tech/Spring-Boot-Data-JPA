package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Artist;
import com.hasan.entity.Festival;
import com.hasan.repository.ArtistRepository;
import com.hasan.repository.FestivalRepository;

@Service
public class MusicFestivalService {
	
	@Autowired
	private ArtistRepository artRepo;
	
	@Autowired
	private FestivalRepository festRepo;
	
	public String addArtistRecord(Artist a) {
		if(a!=null) {
			artRepo.save(a);
			return "Data Saved";
		}
		return "Invalid Data";
	}
	
	public String addFestivalRecord(Festival f) {
		if(f!=null) {
			festRepo.save(f);
			return "Data Saved";
		}
		return "Invalid Data";
	}
	
	public Artist findArtistByName(String name) {
		if(name!=null) {
			return artRepo.findByArtistName(name);
		}
		IO.println("Invalid Data");
		return null;
	}
	
	public Festival findFestivalByName(String f) {
		if(f!=null) {
			return festRepo.findByFestivalName(f);
		}
		IO.println("Invalid Data");
		return null;
	}
	
	public List<Artist> findAllArtistByFestival(String f){
		return artRepo.findAllByFestivalName(f);
	}
	
	public List<Festival> findAllFestivalByArtist(String s){
		return festRepo.getByArtistName(s);
	}
	
	public String updateTicketPrice(int id, Double c) {
		if(festRepo.existsById(id)) {
			Festival s=festRepo.findById(id).get();
			s.setTicketPrice(c);
			festRepo.save(s);
			return "Data Updated.";
		}
		else return "Id not found.";
	}
	
	public String updateArtistExp(int id, Integer c) {
		if(artRepo.existsById(id)) {
			Artist s=artRepo.findById(id).get();
			s.setExperienceYear(c);
			artRepo.save(s);
			return "Data Updated.";
		}
		else return "Id not found.";
	}
	
	public String deleteArtist(Integer id) {
		if(artRepo.existsById(id)) {
			artRepo.deleteById(id);
			return "Data deleted";
		}
		else return "Id not found.";
	}
	
	public String deleteFestival(Integer id) {
		if(festRepo.existsById(id)) {
			festRepo.deleteById(id);
			return "Data deleted";
		}
		else return "Id not found.";
	}
	
	public List<Artist> viewArtist(){
		return artRepo.findAll();
	}
	
	public List<Festival> viewFestival(){
		return festRepo.findAll();
	}
	
}
