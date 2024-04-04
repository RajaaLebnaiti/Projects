package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Citoyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adresse;
    public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	private String nomComplet;

    private String tel;

    private String cin;

    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
@Lob
@Column(name = "photo", columnDefinition = "LONGBLOB")

    private byte[] photo;
@Lob
@Column(name = "signature", columnDefinition = "LONGBLOB")

    private byte[] signature;
    


    public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

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

	public String getCodeConfid() {
		return codeConfid;
	}

	public void setCodeConfid(String codeConfid) {
		this.codeConfid = codeConfid;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<DemandeInscription> getDemandesInscription() {
		return demandesInscription;
	}

	public void setDemandesInscription(List<DemandeInscription> demandesInscription) {
		this.demandesInscription = demandesInscription;
	}

	private String sexe;

    private String email;

    private String password;

    private String codeConfid;

    @ManyToMany
    private List<Reclamation> reclamations;

    @ManyToMany
    private List<DemandeInscription> demandesInscription;
 
    @OneToMany(mappedBy="citoyen")
    private List<DemandeSignatureConformes> demandeSignatureConformes;
    
    @OneToMany(mappedBy="citoyen")
    private List<DemandeSignature> DemandeSignature;
   

    // Getters et Setters
}