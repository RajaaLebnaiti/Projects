package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.DemandeSignature;

public interface DemandeSignatureRepository extends JpaRepository<DemandeSignature, Long> {

}
