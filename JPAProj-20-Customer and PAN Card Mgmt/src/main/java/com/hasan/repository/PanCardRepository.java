package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.PanCard;

@Repository
public interface PanCardRepository extends JpaRepository<PanCard, Long> {

}
