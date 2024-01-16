package com.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.jpaClass.modele.client;
import com.jpaClass.modele.facturation;
@WebServlet(name = "ModifierFacturationServlet", urlPatterns = { "/ModifierFacturationServlet" })
public class ModifierFacturationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Afficher la page de modification
        RequestDispatcher dispatcher = request.getRequestDispatcher("ModifierClient.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
    	String idfacture = request.getParameter("id");
    	int FactureId = 0; // Valeur par défaut ou ajustez selon vos besoins

    	if (idfacture != null && !idfacture.isEmpty()) {
    	    try {
    	    	FactureId = Integer.parseInt(idfacture);
    	    } catch (NumberFormatException e) {
    	        e.printStackTrace(); // Ou logguer l'erreur
    	    }
    	}
    	
    	String idReservation= request.getParameter("ID_Reservation");
    	int ReservationId = 0; // Valeur par défaut ou ajustez selon vos besoins

    	if (idReservation != null && !idReservation.isEmpty()) {
    	    try {
    	    	ReservationId = Integer.parseInt(idReservation);
    	    } catch (NumberFormatException e) {
    	        e.printStackTrace(); // Ou logguer l'erreur
    	    }
    	}
    
        
    	String montantString = request.getParameter("montant");
    	float montant = Float.parseFloat(montantString);

        
        
        
    	String dateReservationString = request.getParameter("DateReservation");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	java.util.Date dateReservation = null;
    	try {
    	    dateReservation = sdf.parse(dateReservationString);
    	} catch (ParseException e) {
    	    e.printStackTrace();
    	}

    	// Convertir la java.util.Date en java.sql.Date
    	java.sql.Date sqlDateReservation = new java.sql.Date(dateReservation.getTime());


        // Mettre à jour les détails du client dans la base de données (à implémenter)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Trouver le client dans la base de données
            facturation facturationToUpdate = em.find(facturation.class,FactureId);

            if (facturationToUpdate != null) {
                // Mettre à jour les détails du client
                
            	facturationToUpdate.setMontant(montant);
            	
            	
            	facturationToUpdate.setDate_facturation(dateReservation);

                // Valider la transaction
                em.getTransaction().commit();

                // Rediriger vers une page de confirmation
                response.sendRedirect("/LocationVoituresApp/FacturationServlet");
            } else {
                // Le client n'a pas été trouvé dans la base de données
                response.getWriter().println("Client non trouvé dans la base de données.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer l'EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}