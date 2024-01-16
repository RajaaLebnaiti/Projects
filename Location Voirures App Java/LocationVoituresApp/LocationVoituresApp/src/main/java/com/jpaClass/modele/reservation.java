package com.jpaClass.modele;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reservation")
public class reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_reservation;
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	@Column(name="date_debut")
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	
	
	@Column(name="date_fin")
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	@Column(name="lieuPrise")
	private String lieuPrise;
	public String getLieuPrise() {
		return lieuPrise;
	}
	public void setLieuPrise(String lieuPrise) {
		this.lieuPrise = lieuPrise;
	}
	
	
	@Column(name="lieuRetour")
	private String lieuRetour;
	public String getLieuRetour() {
		return lieuRetour;
	}
	public void setLieuRetour(String lieuRetour) {
		this.lieuRetour = lieuRetour;
	}
	
	
	@Column(name="modePaiment")
	private String modePaiment;
	public String getModePaiment() {
		return modePaiment;
	}
	public void setModePaiment(String modePaiment) {
		this.modePaiment = modePaiment;
	}
	
	@Column(name="statut")
	private String statut;
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public reservation() {
		super();
	}


	  @ManyToOne
	    @JoinColumn(name = "id_client")  
	    private client client;
	  @OneToOne(mappedBy = "reservation")
	    private facturation facture;
	public client getClient() {
		return client;
	}
	public void setClient(client client) {
		this.client = client;
	}
	public facturation getFacture() {
		return facture;
	}
	public void setFacture(facturation facture) {
		this.facture = facture;
	}
	

	  @ManyToOne
	    @JoinColumn(name = "id_personnel")  
	    private personnel personnel;
	public personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(personnel personnel) {
		this.personnel = personnel;
	}

}
