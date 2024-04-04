package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DemandeInscription;
import com.example.demo.services.DemandeInscriptionService;

import java.util.List;


@Controller
public class DemandesInscriptionController {

   
    
    @Autowired
    private DemandeInscriptionService demandeInscriptionService;

    @GetMapping("/Demande_inscription")
    public String getDemande_inscription(@RequestParam(name = "etat", required = false) String etat, Model model) {
    	 List<DemandeInscription> demandes;

         // Vérifiez si un état est sélectionné
         if (etat != null && !etat.isEmpty()) {
             demandes = demandeInscriptionService.findByEtat(etat);
         } else {
             // Si aucun état sélectionné, récupérez toutes les demandes
             demandes = demandeInscriptionService.getAllDemandes();
         }
    	

        model.addAttribute("demande_insc",  demandes);
        return "Demande_inscription";
    }
}