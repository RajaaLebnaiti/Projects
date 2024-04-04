package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Citoyen;
import com.example.demo.models.Fonctionnaire;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("citoyen")
public class TableauDeBordCitoyenController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ...
 // ...

 // ...



    @GetMapping("/TableauDeBordCitoyen")
    public String showTableauDeBordCitoyen(Model model, HttpSession session) {
        // Récupérer le citoyen connecté depuis la session
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");

        if (loggedInCitoyen == null) {
            return "redirect:/citoyen/LoginCitoyen";
        } else {
            // Récupérer le nombre total de demandes de signature pour le citoyen connecté
            int nombreDemandesSignature = getCountDemandesSignature(loggedInCitoyen.getId());

            // Récupérer le nombre de réclamations soumises par le citoyen connecté
            int nombreReclamations = getCountReclamations(loggedInCitoyen.getId());

            // Récupérer le nombre de réclamations en cours de traitement
            int enCoursTraitement = getCountByEtatReclamation(loggedInCitoyen.getId(), 0);

            // Récupérer le nombre de réclamations traitées
            int traite = getCountByEtatReclamation(loggedInCitoyen.getId(), 1);

            // Ajoutez les données au modèle pour les rendre disponibles dans la vue Thymeleaf
            model.addAttribute("nombreDemandesSignature", nombreDemandesSignature);
            model.addAttribute("nombreReclamations", nombreReclamations);
            model.addAttribute("enCoursTraitement", enCoursTraitement);
            model.addAttribute("traite", traite);
            System.out.println("traite"+ traite);
            System.out.println("enCoursTraitement"+ enCoursTraitement);
            return "citoyen/TableauDeBord";
        }
    }

    // Méthode pour récupérer le nombre de demandes de signature effectuées par le citoyen connecté
    private int getCountDemandesSignature(Long citoyenId) {
        String query = "SELECT COUNT(*) FROM Demande_signature WHERE citoyen_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{citoyenId}, Integer.class);
    }

    // Méthode pour récupérer le nombre de réclamations soumises par le citoyen connecté
    private int getCountReclamations(Long citoyenId) {
        String query = "SELECT COUNT(*) FROM Reclamation WHERE citoyen_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{citoyenId}, Integer.class);
    }

    // Méthode pour récupérer le nombre de réclamations en fonction de l'état
    private int getCountByEtatReclamation(Long citoyenId, int traite) {
        String query = "SELECT COUNT(*) FROM Reclamation WHERE citoyen_id = ? AND traite = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{citoyenId, traite}, Integer.class);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    
    private int getCountByEtatDocumentSigne(String etatDocumentSigne) {
    	 String query = "SELECT COUNT(*) FROM demande_signature WHERE etat = ?";
    	 return jdbcTemplate.queryForObject(query, new Object[]{etatDocumentSigne}, Integer.class);
    	}

    
    // ...
}