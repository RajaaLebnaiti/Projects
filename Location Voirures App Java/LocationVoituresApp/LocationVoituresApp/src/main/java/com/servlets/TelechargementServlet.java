package com.servlets;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.jpaClass.modele.facturation;
import com.jpaClass.modele.voiture;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.OutputStream;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "TelechargementServlet", urlPatterns = {"/TelechargementServlet"})
public class TelechargementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
       
 
    public TelechargementServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
		    EntityManager em = emf.createEntityManager();

		    try {
		        em.getTransaction().begin();

		        // Retrieve the idFacture parameter from the request
		        String idFactureParam = request.getParameter("idFacture");

		        // Check if the parameter is not null and is a valid integer
		        if (idFactureParam != null && idFactureParam.matches("\\d+")) {
		            int idFacture = Integer.parseInt(idFactureParam);

		            // Fetch the specific facturation based on the idFacture
		            facturation facturation = em.find(facturation.class, idFacture);

		            em.getTransaction().commit();

		            // Check if the specific facturation is found
		            if (facturation != null) {
		                response.setContentType("application/pdf");
		                response.setHeader("Content-Disposition", "attachment; filename=Facture.pdf");

		                Document document = new Document();
		                PdfWriter.getInstance(document, response.getOutputStream());
		                document.open();
	            
	         // On ajoute le contenu du PDF ici
	             
	            	document.addTitle("Facture \'Location AutoPlus \'");

	            	// Adresse de l'entreprise
	            	Paragraph companyInfo = new Paragraph("Location AutoPlus", titleFont);
	            	companyInfo.setAlignment(Element.ALIGN_CENTER);
	            	document.add(companyInfo);

	            	companyInfo = new Paragraph("13 Rue Centrale, Rabat", normalFont);
	            	companyInfo.setAlignment(Element.ALIGN_CENTER);
	            	document.add(companyInfo);

	            	companyInfo = new Paragraph("+1 234 567 890", normalFont);
	            	companyInfo.setAlignment(Element.ALIGN_CENTER);
	            	document.add(companyInfo);

	            	companyInfo = new Paragraph("contact@LocationAutoPlus.com", normalFont);
	            	companyInfo.setAlignment(Element.ALIGN_CENTER);
	            	document.add(companyInfo);

	            	document.add(Chunk.NEWLINE);


	                // En-tête de la facture
	                Paragraph title = new Paragraph("Facture ", titleFont);
	                title.setAlignment(Element.ALIGN_CENTER);
	                document.add(title);
	                document.add(Chunk.NEWLINE);

	                // Ligne horizontale
	                LineSeparator lineSeparator = new LineSeparator();
	                document.add(lineSeparator);
	                document.add(Chunk.NEWLINE);

	                // Détails de la facture
	                document.add(new Paragraph("Intitulé :"+facturation.getReservation().getClient().getNom_client()+" "+facturation.getReservation().getClient().getPrenom_client(), subtitleFont));

	                // Total Hors Taxe
	                document.add(new Paragraph("Total Hors Taxe :"+facturation.getMontant()+" DHS", subtitleFont));
	                // TVA à 20%
	                float TVA= (float) (facturation.getMontant()*0.2);
	                document.add(new Paragraph("TVA à 20% : "+TVA+"  DHS", subtitleFont));
	                // Total TTC
	                float total= TVA+facturation.getMontant();
	                document.add(new Paragraph("Total TTC en DHS : "+total+" DHS", subtitleFont));
	                document.add(Chunk.NEWLINE);

	                // Détails de la réservation
	                document.add(new Paragraph("Détails de la réservation:", subtitleFont));
	                document.add(new Paragraph("Date de début: " + facturation.getReservation().getDate_debut(), normalFont));
	                document.add(new Paragraph("Date de fin: " + facturation.getReservation().getDate_fin(), normalFont));
	                document.add(Chunk.NEWLINE);
	                
	                // Pied de facture
	                document.add(new Paragraph("En votre aimable règlement,", normalFont));
	                document.add(new Paragraph("Cordialement,", normalFont));
	                document.add(Chunk.NEWLINE);

	                // Conditions de paiement
	                document.add(new Paragraph("Conditions de paiement :",subtitleFont));
	                document.add(new Paragraph("Paiement à réception de facture, à 30 jours...", normalFont));
	                document.add(new Paragraph("Aucun escompte consenti pour règlement anticipé", normalFont));
	                document.add(new Paragraph("Tout incident de paiement est passible d'intérêt de retard. Le montant des pénalités résulte de l'application aux sommes restant dues d'un taux d'intérêt légal en vigueur au moment de l'incident.", normalFont));
	                document.add(Chunk.NEWLINE);
	                document.add(Chunk.NEWLINE);
	                document.add(Chunk.NEWLINE);


	                // Signature
	                Paragraph signature = new Paragraph("Signature:__________________", normalFont);
	                signature.setAlignment(Element.ALIGN_RIGHT);
	                document.add(signature);
	                document.add(Chunk.NEWLINE);
	                
	                Image signatureImage = PngImage.getImage(getServletContext().getResource("/images/signature.png"));
	                signatureImage.setAlignment(Image.ALIGN_CENTER);
	                signatureImage.scalePercent(25f); // Ajustez la taille de l'image selon vos besoins
	                document.add(signatureImage);
	                
	             // Informations légales
	                Paragraph legalInfo = new Paragraph("N° Siret 210.896.764 00015 RCS Rabat", normalFont);
	                legalInfo.setAlignment(Element.ALIGN_CENTER);
	                document.add(legalInfo);

	                legalInfo = new Paragraph("Code APE 947A - N° TVA Intracom. FR 77825896764000", normalFont);
	                legalInfo.setAlignment(Element.ALIGN_CENTER);
	                document.add(legalInfo);
	                
	                document.close();
	          	 
	            
	           
		            } else {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Facturation introuvable");
		            }
		        } else {
		            response.sendError(HttpServletResponse.SC_BAD_REQUEST, " idFacture Invalide ");
		        }
		    } catch (Exception e) {
		        if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (em != null) {
		            em.close();
		        }
		    }
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
