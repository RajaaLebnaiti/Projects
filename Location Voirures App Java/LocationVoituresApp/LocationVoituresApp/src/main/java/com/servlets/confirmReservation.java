package com.servlets;



import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.reservation;

@WebServlet(name = "confirmReservation", urlPatterns = { "/confirmReservation" })
public class confirmReservation extends HttpServlet {
	
	

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de la réservation à confirmer depuis le formulaire
        int idReservation = Integer.parseInt(request.getParameter("id"));

        // Appeler la méthode pour changer le statut de "en cours de traitement" à "confirmé"
        confirmerReservation(idReservation);

        
        response.sendRedirect("/LocationVoituresApp/HistoriqueServlet");
    }

    private void confirmerReservation(int idReservation) {
        // Créer l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");

        // Créer l'EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Début de la transaction
            em.getTransaction().begin();

            // Trouver la réservation dans la base de données
            reservation reservationToUpdate = em.find(reservation.class, idReservation);

            // Vérifier si la réservation existe
            if (reservationToUpdate != null) {
                // Changer le statut de la réservation à "confirmé"
                reservationToUpdate.setStatut("Confirmé");

                // Valider la transaction
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            // Gérer les exceptions
            e.printStackTrace();
        } finally {
            // Fermer l'EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}