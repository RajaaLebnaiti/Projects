package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.DemandeInscription;



@Repository
public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Long> {

	List<DemandeInscription> findByEtat(String etat);
   
	
}