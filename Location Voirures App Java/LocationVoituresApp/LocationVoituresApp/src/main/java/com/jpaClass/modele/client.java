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
@Table(name="client")
public class client {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id_client;
		public int getId_client() {
			return id_client;
		}
		public void setId_client(int id_client) {
			this.id_client = id_client;
		}
		
		
		@Column(name="nom_client")
	    private String nom_client;
		public String getNom_client() {
			return nom_client;
		}
		public void setNom_client(String nom_client) {
			this.nom_client = nom_client;
		}
		
		
		@Column(name="prenom_client")
	    private String prenom_client;
		public String getPrenom_client() {
			return prenom_client;
		}
		public void setPrenom_client(String prenom_client) {
			this.prenom_client = prenom_client;
		}
		
		
		@Column(name="email_client")
	    private String email_client;
	    public String getEmail_client() {
			return email_client;
		}
		public void setEmail_client(String email_client) {
			this.email_client = email_client;
		}
		
		
		@Column(name="adresse_client")
	    private String adresse_client;
	    public String getAdresse_client() {
			return adresse_client;
		}
		public void setAdresse_client(String adresse_client) {
			this.adresse_client = adresse_client;
		}
		
		
		@Column(name="telephone_client")
	    private String telephone_client;
	    public String getTelephone_client() {
			return telephone_client;
		}
		public void setTelephone_client(String telephone_client) {
			this.telephone_client = telephone_client;
		}
		
		
	    @Column(name="nom_utilisateur")
	    private String nom_utilisateur;
	    public String getNom_utilisateur() {
			return nom_utilisateur;
		}
		public void setNom_utilisateur(String nom_utilisateur) {
			this.nom_utilisateur = nom_utilisateur;
		}
		
		
		@Column(name="motdepasse")
	    private String motdepasse;
		public String getMotdepasse() {
			return motdepasse;
		}
		public void setMotdepasse(String motdepasse) {
			this.motdepasse = motdepasse;
		}
		
		
	    @Column(name="CIN", unique = true)
	    private String CIN;

		public String getCIN() {
			return CIN;
		}
		public void setCIN(String cIN) {
			CIN = cIN;
		}
		
		
		@Column(name="DateNaissance")
		@Temporal(TemporalType.DATE)
	    private Date DateNaissance;
		public Date getDateNaissance() {
			return DateNaissance;
		}
		public void setDateNaissance(Date dateNaissance) {
			DateNaissance = dateNaissance;
		}
		
		
		@Column(name="image")
		@Lob
	    private byte[] image;
		public byte[] getimage() {
			return image;
		}
		public void setimage(byte[] image) {
			this.image = image;
		}
		
		
		 @Column(name = "CarteBancaire")
		    private String carteBancaire; 
		 
		public String getCarteBancaire() {
			return carteBancaire;
		}
		public void setCarteBancaire(String carteBancaire) {
			this.carteBancaire = carteBancaire;
		}
		//constructeur non parametré
		public client() {
			super();
		}
	    
		@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	    private List<reservation> reservations;
		public List<reservation> getReservations() {
			return reservations;
		}
		public void setReservations(List<reservation> reservations) {
			this.reservations = reservations;
		}
		
		@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	    private List<reclamation> reclamations;
		public List<reclamation> getReclamations() {
			return reclamations;
		}
		public void setReclamations(List<reclamation> reclamations) {
			this.reclamations = reclamations;
		}
	    
}
