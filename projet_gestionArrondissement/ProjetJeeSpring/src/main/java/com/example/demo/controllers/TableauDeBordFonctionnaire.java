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

import com.example.demo.models.Fonctionnaire;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("fonctionnaire")

public class TableauDeBordFonctionnaire {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/login")
	public String showLoginPage() {
	    return "login";
	}



@PostMapping("/TableauDeBordFonctionnaire")
public ModelAndView authenticateAndRedirect(@RequestParam String username, @RequestParam String password, @RequestParam String statut, HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();

    // Utilisation de JDBC Template pour exécuter des requêtes SQL
    String query = "SELECT * FROM fonctionnaire WHERE nom_complet = ? AND password = ?";
    
    try {
        // Exécute la requête SQL
        @SuppressWarnings("deprecation")
		Fonctionnaire fonctionnaire = jdbcTemplate.queryForObject(
                query,
                new Object[]{username, password},
                (resultSet, rowNum) -> {
                    Fonctionnaire admin = new Fonctionnaire();
                    admin.setNomComplet(resultSet.getString("nom_complet"));
                    admin.setPassword(resultSet.getString("password"));
                    return admin;
                });

        if (fonctionnaire != null) {
        	// Passez les détails de l'utilisateur à la vue
            session.setAttribute("fonctionnaire", fonctionnaire);

            modelAndView.setViewName("redirect:/TableauDeBordFonctionnaire");
        } else {
            modelAndView.setViewName("redirect:/login?error=true");
        }
    } catch (Exception e) {
        e.printStackTrace();
        modelAndView.setViewName("redirect:/login?error=true");
    }
    
    return modelAndView;
}




//Methode pour les graphes du dashboard 

@GetMapping("/TableauDeBordFonctionnaire")
public String showTableauDeBordFonctionnaire(Model model) {
    // Récupérez les données de la base de données pour les demandes de documents
    int confirme = getCountByEtat("Confirmé");
    int rejete = getCountByEtat("Rejeté");
    int enAttente = getCountByEtat("En attente");
    int signe = getCountByEtatDocumentSigne("Signé");
    int rejeteDocument = getCountByEtatDocumentSigne("Rejeté");
    int enCoursTraitement = getCountByEtatDocumentSigne("En cours de traitement");

    // Ajoutez les données au modèle pour les rendre disponibles dans la vue Thymeleaf
    model.addAttribute("signe", signe);
    model.addAttribute("rejeteDocument", rejeteDocument);
    model.addAttribute("enCoursTraitement", enCoursTraitement);
    // Récupérez les données de la base de données pour les réclamations
    long nombreTraite = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM reclamation WHERE traite = true", Long.class);
    long nombreNonTraite = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM reclamation WHERE traite = false", Long.class);

    // Récupérez le nombre total de citoyens
    long nombreCitoyens = getNombreCitoyens();

    // Ajoutez les données au modèle pour les rendre disponibles dans la vue Thymeleaf
    model.addAttribute("confirme", confirme);
    model.addAttribute("rejete", rejete);
    model.addAttribute("enAttente", enAttente);
    model.addAttribute("nombreTraite", nombreTraite);
    model.addAttribute("nombreNonTraite", nombreNonTraite);
    model.addAttribute("nombreCitoyens", nombreCitoyens);

    return "TableauDeBordFonctionnaire";
}


// Méthode pour obtenir le nombre de demandes pour un état spécifique
private int getCountByEtat(String etat) {
    String query = "SELECT COUNT(*) FROM demande_docs WHERE etat = ?";
    System.out.println("querrrrrrrrrry"+query.length());
    return jdbcTemplate.queryForObject(query, new Object[]{etat}, Integer.class);
}


//methode pour le nombre de citoyens dans notre applications
// Méthode pour obtenir le nombre de citoyens
private long getNombreCitoyens() {
    String query = "SELECT COUNT(*) FROM citoyen";
    return jdbcTemplate.queryForObject(query, Long.class);
}

//methode pour les documents signés en cours de traitement rejeté
//Méthode pour obtenir le nombre de documents signés pour un état spécifique
private int getCountByEtatDocumentSigne(String etatDocumentSigne) {
 String query = "SELECT COUNT(*) FROM demande_signature WHERE etat = ?";
 return jdbcTemplate.queryForObject(query, new Object[]{etatDocumentSigne}, Integer.class);
}



}