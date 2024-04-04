package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DemandeInscription;

public interface DemandesInscriptionRepository extends JpaRepository<DemandeInscription, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}