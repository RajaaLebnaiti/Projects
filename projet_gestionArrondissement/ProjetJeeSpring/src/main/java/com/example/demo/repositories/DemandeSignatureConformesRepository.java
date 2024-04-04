package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeSignatureConformes;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface DemandeSignatureConformesRepository extends JpaRepository<DemandeSignatureConformes, Long>{

	List<DemandeSignatureConformes> findByCitoyen(Citoyen citoyen);
    static Specification<DemandeSignatureConformes> findByCitoyenId(Long citoyenId) {
        return (Root<DemandeSignatureConformes> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            // Mettez en place la logique pour filtrer par ID de citoyen
            // Exemple : 
            return builder.equal(root.get("citoyen").get("id"), citoyenId);
        };
    }

    List<DemandeSignatureConformes> findAll(Specification<DemandeSignatureConformes> specification);



}