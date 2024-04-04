package com.example.demo.controllers;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Fonctionnaire;
import com.example.demo.repositories.FonctionnaireRepository;
import com.example.demo.services.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class reccupererLogin {
    private final EmailService emailService ;

    @Autowired
    public reccupererLogin(EmailService emailService) {
        this.emailService = emailService;
    }


    @Autowired
    private FonctionnaireRepository fonctionnaireRepository;

    @PostMapping("/reccuperationAffichage")
    public String processLogin(@RequestParam String cin, @RequestParam String email, HttpSession session, Model model) {
        // Vérifier si la date_naiss ou le cin sont vides
        if (email.isEmpty() || cin.isEmpty()) {
            model.addAttribute("error", "La date de naissance et le CIN sont requis.");
            return "reccupererInfo";
        }

        try {
            

            // Vérifier les informations dans la base de données
            Fonctionnaire fonctionnaire = fonctionnaireRepository.findByCinAndEmail(cin, email);

            if (fonctionnaire != null) {
                // Les informations sont correctes, rediriger vers le nouveau chemin
                session.setAttribute("loggedInUser", fonctionnaire);
                String password= fonctionnaire.getPassword();
                String toEmail = fonctionnaire.getEmail(); // Récupérez l'adresse e-mail du citoyen depuis la réclamation
                String subject = "Recuperation de compte";
                String body = "Soyez le bienvenue dans notre platforme Idaraty; votre mot de passe est:"+password;
                emailService.sendEmail(toEmail, subject, body);
                return "redirect:/reccuperationAffichage";
            } else {
                // Les informations sont incorrectes, afficher un message d'erreur
                model.addAttribute("errorMessage", "Les données saisies sont incorrectes.");
                return "reccupererInfo"; // Rediriger vers la page de login avec un message d'erreur
            }
        } catch (IllegalArgumentException e) {
            // Gérer l'exception si la conversion échoue
            model.addAttribute("errorMessage", "Format de date incorrect.");
            return "reccupererInfo";
        }
    }

    @GetMapping("/reccuperationAffichage")
    public String afficherRecuperation(HttpSession session, Model model) {
        // Récupérer les informations nécessaires depuis la session
        Fonctionnaire fonctionnaire = (Fonctionnaire) session.getAttribute("loggedInUser");

        // Ajouter les informations au modèle pour l'affichage
        model.addAttribute("fonctionnaire",fonctionnaire);

        // Retourner la page d'affichage
        return "reccuperationAffichage";
    }
    
  
}