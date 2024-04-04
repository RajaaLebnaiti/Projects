package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.example.demo.models.Reclamation;
import com.example.demo.repositories.ReclamationRepository;

@Service
public class ReclamationService {

@Autowired
	
	private ReclamationRepository ReclamationRepository;
	public void save(Reclamation r) {
		ReclamationRepository.save(r);
	}
	
	

    
    public List<Reclamation> getAllReclamations() {
        return ReclamationRepository.findAll();
    }





}