package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Citoyen;
import com.example.demo.repositories.CitoyenRepository;

@Service

public class CitoyenService {
	
	@Autowired
	private  CitoyenRepository citizenRepository;
	
	
	public  void deleteCitizenByCin(String refusedCin) {
        Optional<Citoyen> citizenOptional = citizenRepository.findByCin(refusedCin);

        if (citizenOptional.isPresent()) {
        	Citoyen citizen = citizenOptional.get();
            citizenRepository.delete(citizen);
        }
    }
	
@Autowired
	
	private CitoyenRepository citoyenRepository;
	public void save(Citoyen c) {
		citoyenRepository.save(c);
	}
	public Citoyen login(String email,String password) {
		Citoyen c=citoyenRepository.findByEmailAndPassword(email,password);
		return c;
	}
	

}