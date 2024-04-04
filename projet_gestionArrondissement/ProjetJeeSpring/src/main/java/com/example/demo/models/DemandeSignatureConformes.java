package com.example.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class DemandeSignatureConformes {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	  

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}

		public String getMotif() {
			return motif;
		}

		@Lob
		@Column(name = "fichier", columnDefinition = "LONGBLOB")
		private byte[] fichier;

		public byte[] getFichier() {
			return fichier;
		}

		public void setFichier(byte[] fichier) {
			this.fichier = fichier;
		}

		public void setMotif(String motif) {
			this.motif = motif;
		}

		public String getRaison() {
			return raison;
		}

		public void setRaison(String raison) {
			this.raison = raison;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public List<DocumentSigne> getDocumentsSignes() {
			return documentsSignes;
		}

		public void setDocumentsSignes(List<DocumentSigne> documentsSignes) {
			this.documentsSignes = documentsSignes;
		}

		private String etat="en cours de traitement";

	    private String motif;
	    private String titre;

	    public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		private String raison;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date date;

	    @OneToMany
	    private List<DocumentSigne> documentsSignes;
	    
	    @OneToOne
	    private Document document;

	    public Document getDocument() {
			return document;
		}

		public void setDocument(Document document) {
			this.document = document;
		}
		
		


		@OneToMany
	    private List<Document> documents;

	    @ManyToOne
	    @JoinColumn(name = "citoyen_id") 
	    private Citoyen citoyen;

	    // Getters et Setters pour la propriété citoyen
	    public Citoyen getCitoyen() {
	        return citoyen;
	    }

	    public void setCitoyen(Citoyen citoyen) {
	        this.citoyen = citoyen;
	    }
	    //

		public List<Document> getDocuments() {
			return documents;
		}

		public void setDocuments(List<Document> documents) {
			this.documents = documents;
		}

		@PrePersist
	    protected void onCreate() {
	        this.date = new Date(System.currentTimeMillis());
	    }
	}