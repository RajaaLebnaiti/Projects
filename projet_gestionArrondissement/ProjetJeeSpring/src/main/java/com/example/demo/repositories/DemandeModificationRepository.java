package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DemandeModification;

@Repository
public interface DemandeModificationRepository extends JpaRepository<DemandeModification, Long> {
	 List<DemandeModification> findByEtat(String etat);
}