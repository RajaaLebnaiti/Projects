package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.List;

@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateReclamation() {
		return dateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}

	public boolean isTraite() {
		return traite;
	}

	public void setTraite(boolean traite) {
		this.traite = traite;
	}
private String titre;
	public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}
	private String message;
	private String reponse;

    public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Temporal(TemporalType.DATE)
    private Date dateReclamation;
	
	@PrePersist
	protected void onCreate() {
	    this.dateReclamation = new Date();
	}

    private boolean traite;

    
 // Dans la classe Reclamation
    @ManyToOne
    @JoinColumn(name = "citoyen_id") // Assurez-vous d'ajuster le nom de la colonne en fonction de votre modèle
    private Citoyen citoyen;
    // Getters et Setters



	public Citoyen getCitoyen() {
		return citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
}