package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DemandeDocs;
import com.example.demo.models.Document;
import com.example.demo.repositories.DemandeDocsRepository;
import com.example.demo.repositories.DocumentRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DemandeDocumentsController {

    private final DemandeDocsRepository demandeDocsRepository;
    private final DocumentRepository documentRepository;  // Ajoutez cette ligne

    // Injectez le repository DocumentRepository dans le constructeur
    public DemandeDocumentsController(DemandeDocsRepository demandeDocsRepository, DocumentRepository documentRepository) {
        this.demandeDocsRepository = demandeDocsRepository;
        this.documentRepository = documentRepository;
    }

    @GetMapping("/DemandeDocuments")
    public String showDemandesDocs(Model model) {
        List<DemandeDocs> demandes = demandeDocsRepository.findAll();
        model.addAttribute("DemandeDocuments", demandes);
        return "DemandeDocuments";
    }

    @GetMapping("/detailsDemandeDocs/{demandeId}")
    public String showDetailsDemandeDocs(@PathVariable Long demandeId, Model model) throws IllegalArgumentException {
        DemandeDocs demande = demandeDocsRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        model.addAttribute("demande", demande);

        return "detailsDemandeDocs";
    }
    
    //Confirmer la demande
  
    
    @PostMapping("/confirmerDemande")
    public String confirmerDemande(@RequestParam Long demandeId) {
        DemandeDocs demandeExistante = demandeDocsRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        DemandeDocs nouvelleDemande = new DemandeDocs();
        nouvelleDemande.setCitoyen(demandeExistante.getCitoyen());
        nouvelleDemande.setMotif("Acte de Naissance");
        nouvelleDemande.setEtat("En attente");  
        nouvelleDemande.setRaison("-");

        // Enregistrez la nouvelle demande
        demandeDocsRepository.save(nouvelleDemande);

        // Mettez à jour l'état de la demande existante si nécessaire
        demandeExistante.setEtat("Confirmé");
        demandeDocsRepository.save(demandeExistante);

        // Créez le fichier et enregistrez-le dans la base de données
        creerEtEnregistrerFichier(nouvelleDemande);

        return "redirect:/DemandeDocuments";
    }

    private void creerEtEnregistrerFichier(DemandeDocs demande) {
    	LocalDate dateDuJour = LocalDate.now();


        // Création du contenu de l'acte de naissance
    	String signatureImage = "<img src='/img//signature.jpg' alt='Signature de l\\'officier'>";

    	String contenu = "ROYAUME DU MAROC\n\n"
    	                + "ACTE DE NAISSANCE\n\n"
    	                + "Je soussigné(e), " + ", officier de l'état civil de l'arrondissement de [Nom de l'arrondissement], " + "ville" + ", certifie que\n"
    	                + "le " + demande.getCitoyen().getDateNaiss() + ", est né(e) à Khouribga "+"\n"
    	                + "un enfant du sexe " + demande.getCitoyen().getSexe() + ", du nom de " + demande.getCitoyen().getNomComplet() + " "  + ",\n"
    	                + "fils/fille de [Prénom et Nom du père] et de [Prénom et Nom de la mère].\n\n"
    	                + "Fait à Khouribga"  + ", le " + dateDuJour + ".\n\n"
    	                + "NOOM FONCTIONNAIRE"+ "\n"
    	                + "fonctionOfficier" + "\n\n"
    	                + "Signature de l'officier :\n\n"
    	                + signatureImage
    	                + "\n\nPolitique de Sécurité : Ce document est protégé conformément aux lois et réglementations en vigueur.\n"
    	                + "Toute utilisation frauduleuse est passible de poursuites judiciaires.";


        // Convertissez le contenu en tableau d'octets (byte[])
        byte[] fichierBytes = contenu.getBytes();

        // Enregistrez le fichier dans la base de données
        Document document = new Document();
        document.setNom("Acte_de_Naissance_" + demande.getCitoyen().getNomComplet() + ".txt");
        document.setFichier(fichierBytes);
        documentRepository.save(document);
        demande.setEtat("Validé"); 
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Rejeter une demande 
    @PostMapping("/rejeterDemande")
    public String rejeterDemande(@RequestParam Long demandeId, @RequestParam String raison) {
        DemandeDocs demande = demandeDocsRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        demande.setEtat("Rejeté");
        demande.setRaison(raison);

        demandeDocsRepository.save(demande);

        return "redirect:/DetailsDemandesSignature";
    }
}
