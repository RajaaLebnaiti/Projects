package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.util.List;

@Entity
public class Fonctionnaire {
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

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public DemandeDocs getDemandeDocs() {
		return demandeDocs;
	}

	public void setDemandeDocs(DemandeDocs demandeDocs) {
		this.demandeDocs = demandeDocs;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<DemandeSignature> getDemandesSignature() {
		return demandesSignature;
	}

	public void setDemandesSignature(List<DemandeSignature> demandesSignature) {
		this.demandesSignature = demandesSignature;
	}

	private String nomComplet;

    private String tel;

    private String cin;

    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Lob
    @Column(name = "photo", columnDefinition = "blob")
    private byte[] photo;


    private String sexe;

    private String email;

    private String password;
    
    private String role;
    private String fonction;

    public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	@OneToOne
    private DemandeDocs demandeDocs;

    @OneToMany
    private List<Reclamation> reclamations;

    @OneToMany
    private List<DemandeSignature> demandesSignature;

    // Getters et Setters
    
}