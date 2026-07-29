package com.hasan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hasan.entity.GymMember;

@Service
public interface GymMemberService {
	 public String saveMember(GymMember book);
	 public String saveAllMembers(List<GymMember> members);
	 public GymMember getMemberById(Long id);
	 public List<GymMember> getAllMembers();
	 public String updateMember(Long id,Double fees);
	 public String deleteMemberById(Long id);
	 public String deleteAllMembers();
	 public long countMembers();
	 public String MemberExists(Long id);
}
