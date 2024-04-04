package com.example.demo.services;


import com.example.demo.models.DemandeInscription;
import com.example.demo.models.DemandeModification;
import com.example.demo.repositories.DemandeModificationRepository;
import com.example.demo.repositories.DemandeModificationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandesModificationServiceImpl implements DemandesModificatioService {

    @Autowired
    private DemandeModificationRepository demandeRepository;

  
    

    @Override
    public DemandeModification getDemandeById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    @Override
    public void accepterDemande(Long id) {
    	DemandeModification demande = getDemandeById(id);
        if (demande != null) {
            demande.setEtat("acceptée");
            demandeRepository.save(demande);
        }
    }

    @Override
    public void refuserDemande(Long id) {
    	DemandeModification demande = getDemandeById(id);
        if (demande != null) {
            demande.setEtat("refusée");
            demandeRepository.save(demande);
        }
    }
    @Override
    public List<DemandeModification> findByEtat(String etat) {
        return demandeRepository.findByEtat(etat);
    }

    @Override
    public List<DemandeModification> getAllDemandes() {
        return demandeRepository.findAll();
    }
}