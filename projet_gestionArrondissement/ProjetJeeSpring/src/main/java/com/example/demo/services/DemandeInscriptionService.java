package com.example.demo.services;

import com.example.demo.models.DemandeInscription;
import com.example.demo.repositories.DemandeInscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeInscriptionService {

    private final DemandeInscriptionRepository demandeInscriptionRepository;

    @Autowired
    public DemandeInscriptionService(DemandeInscriptionRepository demandeInscriptionRepository) {
        this.demandeInscriptionRepository = demandeInscriptionRepository;
    }

    public List<DemandeInscription> getAllDemandes() {
        // Logique pour récupérer toutes les demandes d'inscription depuis le repository
        return demandeInscriptionRepository.findAll();
    }

    public List<DemandeInscription> findByEtat(String etat) {
        // Logique pour récupérer les demandes d'inscription en fonction de l'état depuis le repository
        return demandeInscriptionRepository.findByEtat(etat);
    }

    public Optional<DemandeInscription> getDemandeById(Long demandeId) {
        // Utilisez la méthode findByDemandeId de votre service ou repository
        return demandeInscriptionRepository.findById(demandeId);
    }


	//ADDED
  
    	public void save(DemandeInscription d) {
    		demandeInscriptionRepository.save(d);
    	}

    

}