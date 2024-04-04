package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeModification;
import com.example.demo.repositories.CitoyenRepository;
import com.example.demo.repositories.DemandeModificationRepository;
import com.example.demo.services.DemandesModificatioService;

import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/modification")
public class AppliquerModificationController {

    private final Logger logger = LoggerFactory.getLogger(AppliquerModificationController.class);

    @Autowired
    private DemandeModificationRepository demandeModificationRepository;

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Autowired
    private DemandesModificatioService demandesModificatioService;

    private static final String ACTION_ACCEPTEE = "acceptée";

    @Transactional
    @PostMapping("/traiterModification")
    public String traiterModification(@RequestParam long demandeId, @RequestParam(name = "action", defaultValue = "0") int action) {
        try {
            DemandeModification demande = demandesModificatioService.getDemandeById(demandeId);
            logger.info("Accepter modification - Demande ID: {}", demandeId);

            if (action == 1) {
                demandesModificatioService.accepterDemande(demandeId);

                DemandeModification demandeModification = demandeModificationRepository.findById(demandeId)
                        .orElseThrow(() -> new RuntimeException("Demande de modification non trouvée pour l'ID : " + demandeId));

                logger.info("État de la demande de modification : {}", demandeModification.getEtat());

                if (ACTION_ACCEPTEE.equalsIgnoreCase(demandeModification.getEtat())) {
                    Citoyen citoyen = citoyenRepository.findByCin(demandeModification.getCin())
                            .orElseThrow(() -> new RuntimeException("Citoyen non trouvé pour l'ID : " + demandeModification.getId()));

                    logger.info("DemandeModification ID: {}", demandeModification.getId());
                    logger.info("Citoyen ID: {}", citoyen.getId());

                    citoyen.setEmail(demandeModification.getEmail());
                    citoyen.setNomComplet(demandeModification.getNomComplet());
                    citoyen.setPassword(demandeModification.getPassword());
                    citoyen.setPhoto(demandeModification.getPhoto());
                    citoyen.setSexe(demandeModification.getSexe());
                    citoyen.setTel(demandeModification.getTel());

                    citoyenRepository.save(citoyen);

                    return "redirect:/demandeModification";
                } else {
                    return "redirect:/demandeModification";
                }
            } else if (action == 0) {
                demandesModificatioService.refuserDemande(demandeId);
                return "redirect:/modification/afficherFormulaireRefusModification/" + demandeId;
            } else {
                return "redirect:/demandeModification";
            }
        } catch (Exception e) {
            logger.error("Une erreur s'est produite lors du traitement de la demande de modification.", e);
            return "redirect:/demandeModification";
        }
    }

    @GetMapping("/afficherFormulaireRefusModification/{modificationId}")
    public String afficherFormulaireRefusModification(@PathVariable Long modificationId, Model model) {
        DemandeModification demandeModification = demandesModificatioService.getDemandeById(modificationId);
        model.addAttribute("demandeModification", demandeModification);
        return "formulaireRefusModification";
    }

    @PostMapping("/traiterRefusModification")
    public String traiterRefusModification(@RequestParam Long modificationId, @RequestParam String motifRefus) {
        DemandeModification demandeModification = demandeModificationRepository.findById(modificationId)
                .orElseThrow(() -> new RuntimeException("Demande de modification non trouvée pour l'ID : " + modificationId));

        demandeModification.setMotif(motifRefus);
        demandeModificationRepository.save(demandeModification);

        return "redirect:/demandeModification";
    }
}