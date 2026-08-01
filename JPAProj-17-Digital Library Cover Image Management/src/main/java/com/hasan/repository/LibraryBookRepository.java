package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.LibraryBook;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {

}
