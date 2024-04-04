package com.example.demo.controllers;

import java.util.Base64;
import java.util.List;
import com.example.demo.services.ReclamationService;
import java.util.Objects;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Citoyen;
import com.example.demo.models.Reclamation;
import com.example.demo.services.ReclamationService;
import com.example.demo.services.CitoyenService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class CitoyenController {
	
	@Autowired
	CitoyenService service;
	@GetMapping("/LoginClient")
    public String showLoginPage() {
        return "citoyen/LoginClient"; 
    }
	
	@GetMapping("/Inscription")
    public String ShowInscriptionPage() {
        return "citoyen/inscription"; 
    }
	/*
	@GetMapping("/profilCitoyen")
    public String ShowProfil() {
        return "citoyen/profilCitoyen"; 
    }*/
	
	@GetMapping("/profilCitoyen")
    public String profilCitoyen(Model model, HttpSession session) {
        // Retrieve the logged-in citizen from the session
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
        
        if (loggedInCitoyen != null) {
            // Add the citizen to the model for the profile page
            model.addAttribute("loggedInCitoyen", loggedInCitoyen);
           
            byte[] photoBytes = loggedInCitoyen.getPhoto();
            String base64Image = Base64.getEncoder().encodeToString(photoBytes);
            model.addAttribute("base64Image", base64Image);
            return "citoyen/profilCitoyen";
            
        } else {
            // Redirect to the login page if the citizen is not logged in


            return "redirect:/LoginClient";
        }
    }
	
	@GetMapping("/documentCitoyen")
    public String DocumentCitoyen() {
        return "citoyen/demandeDocEffectue"; 
    }
	
	@GetMapping("/succes")
    public String pageSucces() {
        return "citoyen/pageSucces"; 
    }
	
	private String genererCodeConfidentiel() {
        return UUID.randomUUID().toString();
    }
	@PostMapping("/loginCitoyen")
    public String login(@ModelAttribute Citoyen citoyen ,Model model,HttpSession session) {
		Citoyen c=service.login(citoyen.getEmail(),citoyen.getPassword());
		if(Objects.nonNull(c)) {
			session.setAttribute("loggedInCitoyen", c);
			return "redirect:/TableauDeBordCitoyen"; 
		}
		else {
			 model.addAttribute("erreurLogin", "Adresse e-mail ou mot de passe incorrect");
			 return "citoyen/LoginClient";
        }
    }
	@PostMapping("/saveCitoyen")
    public String ajouterCitoyen(@ModelAttribute Citoyen citoyen) {
		String codeConfidentiel = genererCodeConfidentiel();
        citoyen.setCodeConfid(codeConfidentiel);
		service.save(citoyen);
        return "redirect:/profilCitoyen"; 
    }
	

}
