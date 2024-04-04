package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.models.DemandeDocs;
import com.example.demo.repositories.DemandeDocsRepository;

@Service
public class DemandeDocsService {

@Autowired
	
	private DemandeDocsRepository demandeDocsRepository;
	public void save(DemandeDocs d) {
		demandeDocsRepository.save(d);
	}
}
