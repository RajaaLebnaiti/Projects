package com.example.demo.repositories;

//FonctionnaireRepository.java

import com.example.demo.models.Fonctionnaire;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionnaireRepository extends JpaRepository<Fonctionnaire, Long> {

   

	Fonctionnaire findByCinAndEmail(String cin, String email);
}