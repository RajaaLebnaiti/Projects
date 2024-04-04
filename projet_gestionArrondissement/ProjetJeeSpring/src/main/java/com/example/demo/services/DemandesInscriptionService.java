package com.example.demo.services;


import org.springframework.stereotype.Service;

import com.example.demo.models.DemandeInscription;

@Service
public interface DemandesInscriptionService {

 

    DemandeInscription getDemandeById(Long id);

    void accepterDemande(Long id);

    void refuserDemande(Long id);
    
    String getCitizenCinByDemandeId(Long id); 
   
    void insererMotif(Long id, String motif); 

}