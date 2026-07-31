package com.hasan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.entity.ArchiveDocument;

@Repository
public interface ArchiveDocumentRepository extends JpaRepository<ArchiveDocument, Long> {

}
