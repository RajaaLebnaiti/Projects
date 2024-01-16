package com.jpaClass.modele;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Table
@Entity(name="voiture")
public class voiture {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id_voiture;
	    public int getId_voiture() {
	 		return id_voiture;
		}
		public void setId_voiture(int id_voiture) {
			this.id_voiture = id_voiture;
		}

		@Column(name="marque")
	    private String marque;
	    public String getMarque() {
			return marque;
		}
	    public void setMarque(String marque) {
			this.marque = marque;
		}
	    
	    @Column(name="modele")
	    private String modele;
	    public String getModele() {
			return modele;
		}
		public void setModele(String modele) {
			this.modele = modele;
		}

		@Column(name="annee")
		@Temporal(TemporalType.DATE)
	    private Date annee;
	    public Date getAnnee() {
			return annee;
		}
		public void setAnnee(Date annee) {
			this.annee = annee;
		}

		@Column(name="couleur")
	    private String couleur;
	    public String getCouleur() {
			return couleur;
		}
		public void setCouleur(String couleur) {
			this.couleur = couleur;
		}
		@Column(name="disponible")
	    private boolean disponible;
	    public boolean isDisponible() {
			return disponible;
		}
		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}
	    
		@Column(name="matricule")
	    private String matricule;
	    public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}
	    
		@Column(name="Kilométrage_prevu")
	    private int kilometragePrevu;
	    public int getKilometragePrevu() {
			return kilometragePrevu;
		}
		public void setKilometragePrevu(int kilometragePrevu) {
			this.kilometragePrevu = kilometragePrevu;
		}
	    
		@Column(name="nbPlaces")
	    private int nbPlaces;
		public int getNbPlaces() {
			return nbPlaces;
		}
		public void setNbPlaces(int nbPlaces) {
			this.nbPlaces = nbPlaces;
		}

		@Column(name="photo")
		@Lob
	    private byte[] photo;
		public byte[] getPhoto() {
			return photo;
		}
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
		public voiture() {
			super();
		}
		
}
