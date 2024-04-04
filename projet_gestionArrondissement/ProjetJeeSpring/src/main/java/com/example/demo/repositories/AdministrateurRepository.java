package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}