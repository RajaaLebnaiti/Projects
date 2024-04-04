package com.example.demo.controllers;

import com.example.demo.models.Fonctionnaire;
import com.example.demo.repositories.FonctionnaireRepository;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("fonctionnaire")
public class Profil {

    private final JdbcTemplate jdbcTemplate;
    private final FonctionnaireRepository fonctionnaireRepository;

    @Autowired
    public Profil(FonctionnaireRepository fonctionnaireRepository, JdbcTemplate jdbcTemplate) {
        this.fonctionnaireRepository = fonctionnaireRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/Profil")
    public String showProfil(HttpSession session, Model model) {
        Fonctionnaire fonctionnaire = (Fonctionnaire) session.getAttribute("fonctionnaire");

        if (fonctionnaire != null && fonctionnaire.getId() == null) {
            String nomComplet = fonctionnaire.getNomComplet();

            if (nomComplet != null) {
                String query = "SELECT id FROM fonctionnaire WHERE nom_complet = ?";
                Long fonctionnaireId = jdbcTemplate.queryForObject(query, Long.class, nomComplet);

                if (fonctionnaireId != null) {
                    fonctionnaire.setId(fonctionnaireId);

                    session.setAttribute("fonctionnaire", fonctionnaire);
                }
            }
        }

        // Chargement de la photo du fonctionnaire
        Fonctionnaire fonctionnaireWithPhoto = fonctionnaireRepository.findById(fonctionnaire.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid fonctionnaire Id: " + fonctionnaire.getId()));

        // Convertissez les données binaires en base64 pour la photo du fonctionnaire
        byte[] photoBytes = fonctionnaireWithPhoto.getPhoto();
        if (photoBytes != null) {
            String base64PhotoFonctionnaire = Base64.getEncoder().encodeToString(photoBytes);
            model.addAttribute("base64PhotoFonctionnaire", base64PhotoFonctionnaire);
        } else {
            System.out.println("La propriété photo du fonctionnaire est null.");
        }

        model.addAttribute("fonctionnaire", fonctionnaireWithPhoto);
        return "Profil";
    }
    @PostMapping("/Profil")
    public String updateProfil(@ModelAttribute("fonctionnaire") @Validated Fonctionnaire updatedFonctionnaire,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Gérer les erreurs de validation
            return "redirect:/error";
        }

        Long id = updatedFonctionnaire.getId();

        // Mettre à jour les autres champs
        String updateQuery = "UPDATE fonctionnaire SET nom_complet = ?, tel = ?, cin = ?, email = ?, sexe = ?, fonction = ?, password=? WHERE id = ?";
        try {
            int rowsUpdated = jdbcTemplate.update(
                    updateQuery,
                    updatedFonctionnaire.getNomComplet(),
                    updatedFonctionnaire.getTel(),
                    updatedFonctionnaire.getCin(),
                    updatedFonctionnaire.getEmail(),
                    updatedFonctionnaire.getSexe(),
                    updatedFonctionnaire.getFonction(),
                    updatedFonctionnaire.getPassword(),
                    id);

            if (rowsUpdated > 0) {
                System.out.println("Mise à jour réussie !");
            } else {
                System.out.println("Aucune mise à jour effectuée.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }

        return "redirect:/Profil";
    }


}