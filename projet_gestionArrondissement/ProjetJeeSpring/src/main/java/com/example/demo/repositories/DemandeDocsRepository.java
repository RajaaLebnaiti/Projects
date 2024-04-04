package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.DemandeDocs;

public interface DemandeDocsRepository extends JpaRepository<DemandeDocs, Long> {
	//@Query("SELECT d.nom as nom  ,COUNT(d.id) as count FROM demande_docs d GROUP BY d.nom")
    
	//List<Object[]> getStatistiquesDocsParNom();
}
