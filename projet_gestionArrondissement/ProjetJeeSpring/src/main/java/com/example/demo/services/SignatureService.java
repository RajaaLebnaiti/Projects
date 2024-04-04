package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.example.demo.models.Reclamation;
import com.example.demo.models.DemandeSignature;
import com.example.demo.repositories.ReclamationRepository;
import com.example.demo.repositories.SignatureRepository;

@Service
public class SignatureService {

@Autowired
	
	private SignatureRepository SignatureRepository;
	public void save(DemandeSignature r) {
		SignatureRepository.save(r);
	}
	
	

    
    public List<DemandeSignature> getAllReclamations() {
        return SignatureRepository.findAll();
    }





}
