package com.example.demo.services;




import java.util.List;

import com.example.demo.models.DemandeInscription;
import com.example.demo.models.DemandeModification;


public interface DemandesModificatioService {



	DemandeModification getDemandeById(Long id);

 void accepterDemande(Long id);

 void refuserDemande(Long id);

List<DemandeModification> findByEtat(String etat);

List<DemandeModification> getAllDemandes();
}