package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Citoyen;
import com.example.demo.models.Fonctionnaire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// Annotations du contrôleur
@Controller
@RequestMapping("/citoyen")
public class supprimerCitoyenControllers {

    // EntityManager injecté
    @PersistenceContext
    private EntityManager entityManager;

    // Méthode pour supprimer un fonctionnaire
    @GetMapping("/supprimer/{id}")
    @Transactional
    public String supprimercitoyen(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Récupération du fonctionnaire par son ID
    	Citoyen citoyen = entityManager.find(Citoyen.class, id);

        if (citoyen != null) {
            // Suppression du fonctionnaire
            entityManager.remove(citoyen);

            // Ajout d'un attribut pour afficher un message de confirmation sur la page suivante
            redirectAttributes.addFlashAttribute("message", "citoyen supprimé avec succès");
        } else {
            // Le fonctionnaire n'existe pas, ajout d'un message d'erreur
            redirectAttributes.addFlashAttribute("errorMessage", "citoyen non trouvé");
        }

        // Redirection vers la page "listdesfonctionnaires"
        return "redirect:/listdesCitoyen";
    }
}