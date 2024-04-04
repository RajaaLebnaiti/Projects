// ReclamationController.java

package com.example.demo.controllers;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeDocs;
import com.example.demo.models.DemandeSignature;
import com.example.demo.models.DemandeSignatureConformes;
import com.example.demo.models.Document;
import com.example.demo.models.Reclamation;
import com.example.demo.repositories.DemandeSignatureConformesRepository;
import com.example.demo.repositories.DemandeSignatureRepository;
import com.example.demo.repositories.ReclamationRepository;
import com.example.demo.services.ReclamationService;
import com.example.demo.services.EmailService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ReclamationController {
    private final ReclamationRepository reclamationRepository;
    private final DemandeSignatureRepository demandeSignatureRepository;
    
    private final ReclamationService reclamationService;
    private final EmailService emailService;



    public ReclamationController(ReclamationRepository reclamationRepository,DemandeSignatureRepository demandeSignatureRepository ,ReclamationService reclamationService, EmailService emailService) {
        this.reclamationRepository = reclamationRepository;
		this.demandeSignatureRepository = demandeSignatureRepository;
		this.reclamationService = reclamationService;
	    this.emailService = emailService;
    }

    @GetMapping("/reclamations")
    public String showReclamations(Model model) {
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        model.addAttribute("reclamations", reclamationRepository.findAll());
        return "reclamations";
    }

    //Repondre au message et reclaations du citoyen
    
    @PostMapping("/repondreReclamation")
    public String repondreReclamation(@RequestParam Long reclamationId, @RequestParam String reponse) {
    	System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        Reclamation reclamation = reclamationRepository.findById(reclamationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reclamation Id: " + reclamationId));
        reclamation.setReponse(reponse);
        reclamation.setTraite(true);
        System.out.println("reeeeeeeeeeponseee "+reponse);
        System.out.println("idddddddddddddddd"+reclamationId);
        reclamationRepository.save(reclamation);
        return "redirect:/detailsReclamations/" + reclamationId;

    }

    
    
    
 // ReclamationController.java
    @GetMapping("/detailsReclamations/{id}")
    public String showDetailsReclamations(@PathVariable Long id, Model model) {
        // Récupérez les détails de la réclamation en fonction de l'id
        Optional<Reclamation> reclamationOptional = reclamationRepository.findById(id);

        if (reclamationOptional.isPresent()) {
            Reclamation reclamation = reclamationOptional.get();
            model.addAttribute("reclamation", reclamation);
            return "DetailsReclamations";
        } else {
            // Gérez le cas où la réclamation n'est pas trouvée
            return "redirect:/reclamations"; // Redirigez vers la liste des réclamations
        }
    }

    
    

    @GetMapping("/detailsDemandeSignature/{demandeId}")
    public String showDetailsDemandeSignature(@PathVariable Long demandeId, Model model) {
        Optional<DemandeSignature> demandeOptional = demandeSignatureRepository.findById(demandeId);

        if (demandeOptional.isPresent()) {
            DemandeSignature demande = demandeOptional.get();
            
            // Convertissez les données binaires en base64 pour l'image de la demande
            String base64ImageDemande = Base64.getEncoder().encodeToString(demande.getFichier());
            
            // Convertissez les données binaires en base64 pour la signature du citoyen
            String base64SignatureCitoyen = Base64.getEncoder().encodeToString(demande.getCitoyen().getSignature());
            
            // Ajoutez la demande de signature, l'image base64 et la signature du citoyen au modèle
            model.addAttribute("demande", demande);
            model.addAttribute("base64ImageDemande", base64ImageDemande);
            model.addAttribute("base64SignatureCitoyen", base64SignatureCitoyen);

            return "DetailsDemandesSignature";
        } else {
            return "redirect:/erreur";
        }
    }
    
    @PostMapping("/traiterRaison")
    public String rejeterDemande(@RequestParam Long demandeId, @RequestParam String raison) {
        DemandeSignature demande = demandeSignatureRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        demande.setEtat("Rejeté");
        demande.setRaison(raison);

        demandeSignatureRepository.save(demande);

        return "redirect:/detailsDemandeSignature/" + demandeId;
    }

    
    
    @PostMapping("/traiterSignature")
    public String traiterSignature(@RequestParam Long demandeId, @RequestParam String signatureBase64) {
        DemandeSignature demande = demandeSignatureRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        // Convertir la chaîne base64 en tableau de bytes
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        // Enregistrer la signature dans l'attribut fichier de l'entité DemandeSignature
        demande.setFichier(signatureBytes);

        // Mettre à jour l'état ou d'autres champs si nécessaire
        demande.setEtat("Signé");
        demande.setRaison("-");

        // Sauvegarder la demande mise à jour
        demandeSignatureRepository.save(demande);

        return "redirect:/detailsDemandeSignature/" + demandeId;
    }

    
    // ADDED
    
  

    @GetMapping("/Reclamation")
    public String showReclamationForm() {    
        return "citoyen/Reclamation"; // Affiche le formulaire de réclamation
    }

    @PostMapping("/saveReclamation")
    public String saveReclamation(Reclamation reclamation,HttpSession session) {
        // Enregistrez la réclamation à l'aide du service
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
        reclamation.setCitoyen(loggedInCitoyen);
        
        reclamationService.save(reclamation);
        String toEmail = reclamation.getCitoyen().getEmail(); // Récupérez l'adresse e-mail du citoyen depuis la réclamation
        String subject = "Confirmation de réclamation";
        String body = "Votre réclamation a été enregistrée avec succès."
        		+ "\nIdaraty";

        emailService.sendEmail(toEmail, subject, body);
        return "citoyen/confirmationReclamation"; // Redirige vers la page de confirmation
        }
    
    
    @Autowired
    private ReclamationRepository  ReclamationRepository;
    @GetMapping("/AffichReclamations")
    public String showReclamations(Model model,HttpSession session) {
        Citoyen loggedInCitoyen = (Citoyen) session.getAttribute("loggedInCitoyen");
        if(loggedInCitoyen==null) {
        	return "citoyen/LoginCitoyen";
        }else {
        	List<Reclamation> reclamations = ReclamationRepository.findAll(com.example.demo.repositories.ReclamationRepository.findByCitoyenId(loggedInCitoyen.getId()));
  
        model.addAttribute("reclamations", reclamations);
        return "citoyen/AffichReclamations";
        }
    }
    
    @GetMapping("/detailsReclamation/{id}")
    public String showDetailsReclamation(@PathVariable Long id, Model model) throws IllegalArgumentException {
        Reclamation reclamation = ReclamationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reclamation Id: " + id));

        model.addAttribute("reclamation", reclamation);

        return "citoyen/detailsReclamation";
    }
    
    
    
    
    
    
    
   
    
    
    
}
