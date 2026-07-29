package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.entity.GymMember;

public interface GymMemberRepository extends JpaRepository<GymMember, Long>{

}
