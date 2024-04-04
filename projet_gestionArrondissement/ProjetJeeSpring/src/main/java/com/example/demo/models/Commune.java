package com.example.demo.models;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;

    @OneToMany
    private List<Fonctionnaire> fonctionnaires;

    @OneToMany
    private List<Administrateur> administrateurs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Fonctionnaire> getFonctionnaires() {
		return fonctionnaires;
	}

	public void setFonctionnaires(List<Fonctionnaire> fonctionnaires) {
		this.fonctionnaires = fonctionnaires;
	}

	public List<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

    
}