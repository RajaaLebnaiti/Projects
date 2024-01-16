package com.jpaClass.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reclamation;
    private String sujet;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSoumission;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private client client;

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(Date dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
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

