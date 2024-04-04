package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.DemandeModification;
import com.example.demo.repositories.DemandeModificationRepository;

@Service
public class DemandeModificationService {

@Autowired
	
	private DemandeModificationRepository demandeModificationRepository;
	public void save(DemandeModification d) {
		demandeModificationRepository.save(d);
	}
}
