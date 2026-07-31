package com.hasan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.ArchiveDocument;
import com.hasan.repository.ArchiveDocumentRepository;

@Service
public class ArcheiveDocumentService {

	@Autowired
	private ArchiveDocumentRepository repo;

	public String addData(ArchiveDocument b) {
		repo.save(b);
		return "Data added.";
	}

	public ArchiveDocument getDocument(Long id) {
		return repo.findById(id).get();
	}

	public String deleteDocument(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		}
		else return "Record not found.";
	}

}
