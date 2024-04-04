package com.example.demo.services;

import com.example.demo.models.DemandeInscription;
import com.example.demo.repositories.DemandesInscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandesInscriptionServiceImpl implements DemandesInscriptionService {

    @Autowired
    private DemandesInscriptionRepository demandeRepository;

    

    @Override
    public DemandeInscription getDemandeById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    @Override
    public void accepterDemande(Long id) {
        DemandeInscription demande = getDemandeById(id);
        if (demande != null) {
            demande.setEtat("acceptée");
            demandeRepository.save(demande);
        }
    }

    @Override
    public void refuserDemande(Long id) {
        DemandeInscription demande = getDemandeById(id);
        if (demande != null) {
        	
            demande.setEtat("refusée");
            demandeRepository.save(demande);
        }
    }
    
    
    @Override
    public String getCitizenCinByDemandeId(Long id) {
        DemandeInscription demandeInscription = getDemandeById(id);
        return demandeInscription.getCin();
    }
    
    @Override
    public void insererMotif(Long id, String motif) {
        DemandeInscription demande = getDemandeById(id);
        if (demande != null) {
            demande.setMotif(motif);
            demandeRepository.save(demande);
        }
    }
    
    
}