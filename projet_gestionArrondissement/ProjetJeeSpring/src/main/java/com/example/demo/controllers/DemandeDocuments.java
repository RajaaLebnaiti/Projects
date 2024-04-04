package com.example.demo.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeSignature;
import com.example.demo.models.Document;
import com.example.demo.models.DocumentSigne;
import com.example.demo.models.Reclamation;
import com.example.demo.repositories.ReclamationRepository;
import com.example.demo.repositories.SignatureRepository;
import com.example.demo.services.EmailService;
import com.example.demo.services.SignatureService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

@Controller
public class DemandeDocuments {

    @Autowired
    private SignatureRepository SignatureRepository;

    @GetMapping("/DemandeSignature")
    public String showDemandeSignatures(Model model,HttpSession session) {
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
        if(loggedInCitoyen==null) {
        	return "citoyen/LoginCitoyen";
        }else { 
        	List<DemandeSignature> demandesSignatures = SignatureRepository.findAll(com.example.demo.repositories.SignatureRepository.findByCitoyenId(loggedInCitoyen.getId()));
        model.addAttribute("demandesSignatures", demandesSignatures);
        return "citoyen/AffichDemandesSignature";
        }
    }
    
    @GetMapping("/citoyen-DemandeDocument")
    public String showDemandeDocumentsCitoyen() {
        return "citoyen/DemandeDocuments"; 
    }
    
    @PostMapping("/saveDocs")
    public String EnregistrerDemande(DemandeSignature DemandeSignature,HttpSession session) {
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
        DemandeSignature.setCitoyen(loggedInCitoyen);
        SignatureRepository.save(DemandeSignature);
        return "citoyen/confirmationDemandeSignature"; 
    }

    
    @GetMapping("/detailsDocSigne/{id}")
    public String showDetailsDocSigne(@PathVariable Long id, Model model) throws IllegalArgumentException {
    	DemandeSignature DemandeSignature = SignatureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reclamation Id: " + id));
        
    	
        byte[] imageData = DemandeSignature.getFichier();
        String base64Image = Base64.getEncoder().encodeToString(imageData);

        model.addAttribute("DemandeSignature", DemandeSignature);
        model.addAttribute("base64ImageDemande", base64Image);

        return "citoyen/detailsDocSigne";
    }


    @GetMapping("/telechargerDocumentSign/{demandeId}")
    public ResponseEntity<byte[]> telechargerDocumentSigne(@PathVariable Long demandeId) {
        // Récupérez la demande
        DemandeSignature demande = SignatureRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        // Récupérez le fichier associé à la demande
        byte[] fichier = demande.getFichier();

        // Retournez le fichier en tant que réponse HTTP
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline;filename=" + demande.getMotif())
                .contentType(MediaType.APPLICATION_PDF)
                .body(fichier);
    }


}