package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.models.DemandeInscription;
import com.example.demo.services.DemandeInscriptionService;
@Controller
public class demandeInscriptionController {
	
	
	@Autowired
	 DemandeInscriptionService service;
	
	@GetMapping("/inscriptionReussite")
    public String showLoginPage() {
        return "citoyen/InscriptionReussite"; 
    }
	
	@PostMapping("/saveDemandeInscription")
    public String ajouterDemande(@ModelAttribute DemandeInscription demandeInscription) {
		service.save(demandeInscription);
        return "redirect:/inscriptionReussite"; 
    }

}
