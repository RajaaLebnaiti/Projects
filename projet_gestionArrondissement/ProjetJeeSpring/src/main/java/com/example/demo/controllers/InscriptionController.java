package com.example.demo.controllers;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeInscription;
import com.example.demo.repositories.CitoyenRepository;
import com.example.demo.repositories.DemandeInscriptionRepository;
import com.example.demo.services.CitoyenService;
import com.example.demo.services.DemandesInscriptionService;
import com.example.demo.services.EmailService;

import java.util.UUID;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {
    private final EmailService emailService ;

    @Autowired
    public InscriptionController(EmailService emailService) {
        this.emailService = emailService;
    }

    private final Logger logger = LoggerFactory.getLogger(InscriptionController.class);

    @Autowired
    private DemandeInscriptionRepository demandeInscriptionRepository;

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Autowired
    private DemandesInscriptionService demandesInscriptionService;

    @Autowired
    private CitoyenService citoyenService;

    @Transactional
    @PostMapping("/accepter")
    public String accepterInscription(@RequestParam Long demandeId, @RequestParam(name = "action", defaultValue = "0") int action) {
        try {
            DemandeInscription demande = demandesInscriptionService.getDemandeById(demandeId);

            if (action == 1)  {
                demandesInscriptionService.accepterDemande(demandeId);
                logger.info("Accepter Inscription - Demande ID: {}", demandeId);

                DemandeInscription demandeInscription = demandeInscriptionRepository.findById(demandeId)
                        .orElseThrow(() -> new RuntimeException("Demande d'inscription non trouvée pour l'ID : " + demandeId));

                if ("acceptée".equalsIgnoreCase(demandeInscription.getEtat())) {
                    creerCitoyen(demandeInscription);
                    return "Demande_inscription";
                } else {
                    return "Demande_inscription";
                }
            } else if (action == 0)  {
                demandesInscriptionService.refuserDemande(demandeId);
                String refusedCin = demandesInscriptionService.getCitizenCinByDemandeId(demandeId);
                citoyenService.deleteCitizenByCin(refusedCin);
                return "redirect:/inscription/afficherFormulaireRefus/" + demandeId;
            } else {
                return "Demande_inscription";
            }
        } catch (Exception e) {
            logger.error("Une erreur s'est produite lors du traitement de la demande d'inscription.", e);
            return "redirect:/demandeModification";
        }
    }

    private void creerCitoyen(DemandeInscription demandeInscription) {
        Citoyen citoyen = new Citoyen();
        citoyen.setCin(demandeInscription.getCin());
        citoyen.setDateNaiss(demandeInscription.getDate_naiss());
        citoyen.setEmail(demandeInscription.getEmail());
        citoyen.setNomComplet(demandeInscription.getNom_complet());

        citoyen.setPhoto(demandeInscription.getPhoto());
        citoyen.setSexe(demandeInscription.getSexe());
        citoyen.setTel(demandeInscription.getTel());

        String uuid = UUID.randomUUID().toString();
        String codeConfidentiel = uuid.substring(0, 7);
        citoyen.setCodeConfid(codeConfidentiel);
        citoyen.setPassword(codeConfidentiel);
        citoyenRepository.save(citoyen);
        String toEmail = citoyen.getEmail(); // Récupérez l'adresse e-mail du citoyen depuis la réclamation
        String subject = "Confirmation de creation de compte";
        String body = "Bonjour " + demandeInscription.getNom_complet() + ", votre mot de passe est : " + codeConfidentiel;

        emailService.sendEmail(toEmail, subject, body);
    }

    @GetMapping("/afficherFormulaireRefus/{demandeId}")
    public String afficherFormulaireRefus(@PathVariable Long demandeId, Model model) {
        DemandeInscription demandeInscription = demandesInscriptionService.getDemandeById(demandeId);
        model.addAttribute("demandeInscription", demandeInscription);
        return "formulaireRefus";
    }

    
    
    @PostMapping("/traiterRefus")
    public String traiterRefus(@RequestParam Long demandeId, @RequestParam String motifRefus) {
        DemandeInscription demandeInscription = demandeInscriptionRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande d'inscription non trouvée pour l'ID : " + demandeId));

        demandeInscription.setMotif(motifRefus);

        demandeInscriptionRepository.save(demandeInscription);

        return "redirect:/Demande_inscription";
    }
}