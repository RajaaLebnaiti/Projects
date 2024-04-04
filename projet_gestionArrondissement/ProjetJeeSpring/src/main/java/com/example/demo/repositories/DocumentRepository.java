package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
