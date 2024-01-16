package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.facturation;
import com.jpaClass.modele.reservation;

@WebServlet(name = "AjouterFacture", urlPatterns = { "/AjouterFacture" })
public class AjouterFacture extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        float montant = Float.parseFloat(request.getParameter("montant"));
        String dateFacturationString = request.getParameter("dateFacturation");

        // Convertir la chaîne de date en objet Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFacturation = null;
        try {
            dateFacturation = sdf.parse(dateFacturationString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int idReservation = Integer.parseInt(request.getParameter("idReservation"));

     // Créer un nouvel objet facturation
     facturation nouvelleFacture = new facturation();
     nouvelleFacture.setMontant(montant);
     nouvelleFacture.setDate_facturation(dateFacturation);

     
     reservation reservation = new reservation();
     reservation.setId_reservation(idReservation);

     nouvelleFacture.setReservation(reservation);

    

        
        // Enregistrer la nouvelle facture dans la base de données
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(nouvelleFacture);
            em.getTransaction().commit();

            // Rediriger vers une page de confirmation
            response.sendRedirect("/LocationVoituresApp/FacturationServlet");
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
}