package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeModification;
@Repository
public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {

	Optional<Citoyen> findByCin(String cin);
	Citoyen findByEmailAndPassword(String email ,String password);
   
}