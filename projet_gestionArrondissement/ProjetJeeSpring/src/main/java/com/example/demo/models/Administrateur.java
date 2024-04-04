package com.example.demo.models;
import java.util.Date;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNais() {
		return DateNais;
	}

	public void setDateNais(Date dateNais) {
		DateNais = dateNais;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Citoyen> getCitoyens() {
		return citoyens;
	}

	public void setCitoyens(List<Citoyen> citoyens) {
		this.citoyens = citoyens;
	}

	public List<Fonctionnaire> getFonctionnaires() {
		return fonctionnaires;
	}

	public void setFonctionnaires(List<Fonctionnaire> fonctionnaires) {
		this.fonctionnaires = fonctionnaires;
	}

	private String nomComplet;

    private String tel;

    private String cin;

    @Temporal(TemporalType.DATE)
    private Date DateNais;

    private byte[] photo;

    private String sexe;

    private String email;

    private String password;

    @ManyToMany
    private List<Citoyen> citoyens;

    @ManyToMany
    private List<Fonctionnaire> fonctionnaires;

    // Getters et Setters
}

// D'autres classes avec leurs attributs et annotations