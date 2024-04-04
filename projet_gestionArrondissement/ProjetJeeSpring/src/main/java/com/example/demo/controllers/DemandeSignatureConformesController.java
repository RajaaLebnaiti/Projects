package com.example.demo.controllers;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DemandeSignature;
import com.example.demo.models.DemandeSignatureConformes;
import com.example.demo.repositories.DemandeSignatureConformesRepository;

@Controller
public class DemandeSignatureConformesController {

    private final DemandeSignatureConformesRepository demandeSignatureConformesRepository;

    @Autowired
    public DemandeSignatureConformesController(DemandeSignatureConformesRepository demandeSignatureConformesRepository) {
        this.demandeSignatureConformesRepository = demandeSignatureConformesRepository;
    }

    // Endpoint pour afficher la liste des demandes de signatures conformes
    @GetMapping("/DemandeSignaturesConformes")
    public String showDemandeSignaturesConformes(Model model) {
        List<DemandeSignatureConformes> demandesSignaturesConformes = demandeSignatureConformesRepository.findAll();
        model.addAttribute("demandesSignaturesConformes", demandesSignaturesConformes);
        return "DemandeSignaturesConformes";
    }

    // Endpoint pour afficher les détails d'une demande de signature conforme
    @GetMapping("/detailsDemandeSignatureConforme/{demandeId}")
    public String showDetailsDemandeSignatureConforme(@PathVariable Long demandeId, Model model) {
    	System.out.println("aaaaaaaaaaaaaaa");
        DemandeSignatureConformes demande = demandeSignatureConformesRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));
        model.addAttribute("demande", demande);
        return "DetailsDemandeSignatureConforme";
    }

    @GetMapping("/telechargerDocumentSigneConforme/{demandeId}")
    public ResponseEntity<byte[]> telechargerDocumentSigneConforme(@PathVariable Long demandeId) {
    	System.out.println("bbbbbbbbbbbbbbbbb");
        // Récupérez la demande
        DemandeSignatureConformes demande = demandeSignatureConformesRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        // Récupérez le fichier associé à la demande (assurez-vous que votre entité a une méthode getFichier())
        byte[] fichier = demande.getFichier();

        // Retournez le fichier en tant que réponse HTTP
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline;filename=" + demande.getMotif())
                .contentType(MediaType.APPLICATION_PDF)
                .body(fichier);
    }
    
    
    

    /*Raj3iha le controlleur dyal conforme*/

    @GetMapping("/detailsDemandeSignatureconforme/{demandeId}")
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

            return "DetailsDemandeSignatureConforme";
        } else {
            return "redirect:/erreur";
        }
    }

    
    @PostMapping("/traiterRaisonconforme")
    public String rejeterDemandeconforme(@RequestParam Long demandeId, @RequestParam String raison) {
    	System.out.println("ddddddddddddddddddddd");
        DemandeSignatureConformes demande = demandeSignatureConformesRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        demande.setEtat("Rejeté");
        demande.setRaison(raison);

        demandeSignatureConformesRepository.save(demande);

        return "redirect:/detailsDemandeSignatureConforme/" + demandeId;
    }

    
    @PostMapping("/traiterSignatureconforme")
    public String traiterSignatureconforme(@RequestParam Long demandeId, @RequestParam("signatureBase64") String signatureBase64) {
        DemandeSignatureConformes demande = demandeSignatureConformesRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        // Convertir la chaîne base64 en tableau de bytes
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        // Enregistrer la signature dans l'attribut fichier de l'entité DemandeSignature
        demande.setFichier(signatureBytes);

        // Mettre à jour l'état ou d'autres champs si nécessaire
        demande.setEtat("Signé");
        demande.setRaison("-");
        System.out.println("ggggggggggggggg");
        // Sauvegarder la demande mise à jour
        demandeSignatureConformesRepository.save(demande);

        return "redirect:/DemandeSignaturesConformes";
    }

    
    
    
    
}
