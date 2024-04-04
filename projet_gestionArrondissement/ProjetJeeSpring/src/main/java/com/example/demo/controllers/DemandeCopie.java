package com.example.demo.controllers;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeSignatureConformes;
import com.example.demo.repositories.DemandeSignatureConformesRepository;
import com.example.demo.services.CitoyenService;
import com.example.demo.services.DemandeSignatureConformesService;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
@Controller
public class DemandeCopie {

	private final DemandeSignatureConformesService demandeSignatureConformesService;
	private final DemandeSignatureConformesRepository demandeSignatureConformesRepository;
	private final CitoyenService citoyenService;

    @Autowired
    public DemandeCopie(DemandeSignatureConformesService demandeSignatureConformesService, CitoyenService citoyenService,DemandeSignatureConformesRepository demandeSignatureConformesRepository) {
        this.demandeSignatureConformesService = demandeSignatureConformesService;
        this.citoyenService = citoyenService;
        this.demandeSignatureConformesRepository = demandeSignatureConformesRepository;
    }

    @PostMapping("/saveDocCopie")
    public String sauvegarderDemande(@ModelAttribute DemandeSignatureConformes demandeSignatureConformes, HttpSession session) {
    	Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
    	demandeSignatureConformes.setCitoyen(loggedInCitoyen);
        demandeSignatureConformesService.saveDemandeSignatureConformes(demandeSignatureConformes);
        // Redirigez ou faites ce que vous voulez après la sauvegarde
        return "citoyen/confirmationDemandeSignature";
    }
	 @GetMapping("/DemandeCopie")
	    public String showEffectuerCopie() {
	        return "citoyen/DemandeCopie"; 
	    }
	 @GetMapping("/ListeDemandesCopie")
	    public String showListeDocsSignes(Model model , HttpSession session) {
		 Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
		  List<DemandeSignatureConformes> demandesDuCitoyen = demandeSignatureConformesService.getDemandesByCitoyen(loggedInCitoyen);
            System.out.println("les demandes recuperes sont "+demandesDuCitoyen);
	        // Ajoutez les demandes au modèle pour les afficher dans votre template Thymeleaf
	        model.addAttribute("demandesDuCitoyen", demandesDuCitoyen);
	        return "citoyen/ListeCopie"; 
	    }
	 

	    @GetMapping("/detailsDemandeSignatureconformer/{demandeId}")
	    public String showDetailsDemandeSignatureconforme(@PathVariable Long demandeId, Model model) {
	    	System.out.println("ccccccccccccccc");
	        Optional<DemandeSignatureConformes> demandeOptional = demandeSignatureConformesRepository.findById(demandeId);

	        if (demandeOptional.isPresent()) {
	            DemandeSignatureConformes demande = demandeOptional.get();
	            
	            // Convertissez les données binaires en base64 pour l'image de la demande
	            String base64ImageDemande = Base64.getEncoder().encodeToString(demande.getFichier());
	            System.out.println("Longuuuuuuuuuuueur de base64ImageDemande : " + base64ImageDemande.length());

	            // Convertissez les données binaires en base64 pour la signature du citoyen
	            String base64SignatureCitoyen = Base64.getEncoder().encodeToString(demande.getCitoyen().getSignature());
	            
	            // Ajoutez la demande de signature, l'image base64 et la signature du citoyen au modèle
	            model.addAttribute("demande", demande);
	            model.addAttribute("base64ImageDemande", base64ImageDemande);
	            model.addAttribute("base64SignatureCitoyen", base64SignatureCitoyen);

	            return "citoyen/DetailsDemandeSignatureConforme";
	        } else {
	            return "redirect:/erreur";
	        }
	    }
	
	
}