package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DemandeModification;
import com.example.demo.services.DemandeModificationService;

import java.util.List;
import java.util.Map;

@Controller
public class DemandeModificationController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/demandeModification")
    public String getDemande_inscription(Model model) {
      
        List<Map<String, Object>> demande_modification = jdbcTemplate.queryForList("SELECT * FROM demande_modification where etat='en cours de traitement' or etat='refusée'");
        model.addAttribute("demande_modification", demande_modification);
        return "demandeModification";
    }
    
    @PostMapping("/AfficherDemandeParEtat")
    public String getDemandeParEtat(@RequestParam String etat, Model model) {
        // Filtrer les demandes de modification par état
        List<Map<String, Object>> demande_modification = jdbcTemplate.queryForList("SELECT * FROM demande_modification where etat=?", etat);
        model.addAttribute("demande_modification", demande_modification);
        return "demandeModification";
    }
    
    
    
    // ADDED
    
    @Autowired
	 DemandeModificationService service;
	@PostMapping("/saveDemandeModification")
   public String ajouterDemande(@ModelAttribute DemandeModification demandeModification) {
		service.save(demandeModification);
       return "redirect:/succes"; 
   }
}