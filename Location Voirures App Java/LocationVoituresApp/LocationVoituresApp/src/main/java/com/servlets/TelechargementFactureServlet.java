package com.servlets;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.jpaClass.modele.facturation;
import com.jpaClass.modele.voiture;

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

@WebServlet(name = "TelechargementFactureServlet", urlPatterns = {"/TelechargementFactureServlet"})

public class TelechargementFactureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public TelechargementFactureServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Récupérer l'identifiant de la facture depuis la requête
		String idFactureStr = request.getParameter("idFacture");
		if (idFactureStr != null && !idFactureStr.isEmpty()) {
		    try {
		        int idFacture = Integer.parseInt(idFactureStr);

		        // Récupérer la facture depuis la base de données
		        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
		             EntityManager em = emf.createEntityManager()) {

		            facturation facture = em.find(facturation.class, idFacture);

		            if (facture != null && facture.getFacture() != null) {
		                // Configurer la réponse HTTP
		                response.setContentType("application/pdf");
		                response.setHeader("Content-Disposition", "attachment; filename=facture_" + idFacture + ".pdf");

		                // Envoyer le fichier en tant que flux de données
		                try (OutputStream out = response.getOutputStream()) {
		                    out.write(facture.getFacture());
		                }
		            } else {
		                response.getWriter().println("La facture n'existe pas ou le fichier est vide.");
		            }
		        }
		    } catch (NumberFormatException e) {
		        response.getWriter().println("Identifiant de facture non valide.");
		    } catch (IOException e) {
		        e.printStackTrace(); // Handle or log the exception appropriately
		        response.getWriter().println("Une erreur s'est produite lors de la récupération de la facture.");
		    }
		} else {
		    response.getWriter().println("Identifiant de facture non spécifié.");
		}}


    



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
