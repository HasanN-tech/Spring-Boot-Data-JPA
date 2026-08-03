package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
