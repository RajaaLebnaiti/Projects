package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DemandeModification;

public interface demandeModificationReposity extends JpaRepository<DemandeModification, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}