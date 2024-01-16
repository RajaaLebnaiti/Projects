package com.jpaClass.modele;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="facturation")
public class facturation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_facture;
	public int getId_facture() {
		return id_facture;
	}
	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}
	
	@Column(name="montant")
	private float montant;
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	@Column(name="date_facturation")
	private Date date_facturation;
	public Date getDate_facturation() {
		return date_facturation;
	}
	public void setDate_facturation(Date date_facturation) {
		this.date_facturation = date_facturation;
	}
	
	@Column(name="facture", columnDefinition="LONGBLOB")
	@Lob
    private byte[] facture;
	
	public byte[] getFacture() {
		return facture;
	}
	public void setFacture(byte[] facture) {
		this.facture = facture;
	}
	public facturation() {
		super();
		
	}
	public facturation(Integer id_facture, Float montant, Timestamp date_facturation) {
	    this.id_facture = id_facture;
	    this.montant = montant;
	    this.date_facturation = date_facturation;
	}

	// Dans l'entité Facturation
	
	@OneToOne
    @JoinColumn(name = "id_reservation")
    private reservation reservation;
	public reservation getReservation() {
		return reservation;
	}
	public void setReservation(reservation reservation) {
		this.reservation = reservation;
	}

		

}
