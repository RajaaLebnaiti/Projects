package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeModification;
import com.example.demo.models.Reclamation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    static Specification<Reclamation> findByCitoyenId(Long citoyenId) {
        return (Root<Reclamation> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            // Mettez en place la logique pour filtrer par ID de citoyen
            // Exemple : 
            return builder.equal(root.get("citoyen").get("id"), citoyenId);
        };
    }

    List<Reclamation> findAll(Specification<Reclamation> specification);
}