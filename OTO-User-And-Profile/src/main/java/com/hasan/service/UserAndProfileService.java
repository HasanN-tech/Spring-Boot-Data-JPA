package com.hasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Profile;
import com.hasan.entity.User;
import com.hasan.repository.ProfilRepository;
import com.hasan.repository.UserRepository;

@Service
public class UserAndProfileService {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ProfilRepository prepo;
	
	public String addData(User u) {
		if(u!=null) {
			urepo.save(u);
			return "Data Added.";
		}else return "Data INVALID.";
	}
	
	public Profile getByprofile(int id) {
		return prepo.findById(id).get();
	}
	
	public List<User> getAll(){
		return urepo.findAll();
	}
	
}
