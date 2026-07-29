package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.GymMember;
import com.hasan.repository.GymMemberRepository;

@Service
public class GymMemberServiceImpl implements GymMemberService {
	@Autowired
	private GymMemberRepository repo;

	@Override
	public String saveMember(GymMember member) {
		if (member != null) {
			repo.save(member);
			return "Record saved successfully";
		}
		return "Given record is empty.";
	}

	@Override
	public String saveAllMembers(List<GymMember> members) {
		if (members != null) {
			repo.saveAll(members);
			return "Records saved successfully";
		}
		return "records not found";
	}

	@Override
	public GymMember getMemberById(Long id) {
		if (id != null) {
			return repo.findById(id).get();
		}
		IO.println("Id: " + id + " is not found.");
		return null;
	}

	@Override
	public List<GymMember> getAllMembers() {
		if (repo.count() > 0)
			return repo.findAll();
		else
			IO.println("No record found.");
		return null;

	}

	@Override
	public String updateMember(Long id,Double fee) {
		if (repo.findById(id).isPresent()) {
			GymMember mem=repo.findById(id).get();
			mem.setFees(fee);
			repo.save(mem);
			return "Record Updated";
		}
		return "Record is not found.";
	}

	@Override
	public String deleteMemberById(Long id) {
		if (id != null) {
			repo.deleteById(id);
			return "Record Deleted";
		}
		return "ID: " + id + " is not found.";
	}

	@Override
	public String deleteAllMembers() {
		if (repo.count() > 0) {
			repo.deleteAll();
			return "All records are deleted";
		}
		return "No records are found table is empty.";

	}

	@Override
	public long countMembers() {
		return repo.count();
	}

	@Override
	public String MemberExists(Long id) {
		if (repo.existsById(id)) {
			return "Member exist with id: "+id;
		}
		return "Record not exist with id: "+id;
		 
	}

}
