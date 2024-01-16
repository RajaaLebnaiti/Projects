package com.jpaClass.modele;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="personnel")
public class personnel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_personnel;
	private  String nom_personnel;
	private  String prenom_personnel;
	private  String email_personnel;
	private  String poste_personnel;
	private  String nom_utilisateur;
	private  String motdepasse;
	private  String CIN;
	@Temporal(TemporalType.DATE)
	private  Date dateNaissance;
	@Column(name="image")
	@Lob
    private byte[] image;
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public String getNom_personnel() {
		return nom_personnel;
	}
	public void setNom_personnel(String nom_personnel) {
		this.nom_personnel = nom_personnel;
	}
	public String getPrenom_personnel() {
		return prenom_personnel;
	}
	public void setPrenom_personnel(String prenom_personnel) {
		this.prenom_personnel = prenom_personnel;
	}
	public String getEmail_personnel() {
		return email_personnel;
	}
	public void setEmail_personnel(String email_personnel) {
		this.email_personnel = email_personnel;
	}
	public String getPoste_personnel() {
		return poste_personnel;
	}
	public void setPoste_personnel(String poste_personnel) {
		this.poste_personnel = poste_personnel;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private List<reservation> reservations;
	public List<reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<reservation> reservations) {
		this.reservations = reservations;
	}
}




