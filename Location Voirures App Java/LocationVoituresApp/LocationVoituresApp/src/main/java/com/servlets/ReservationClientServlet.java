package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jpaClass.modele.client;
import com.jpaClass.modele.facturation;
import com.jpaClass.modele.reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "ReservationClientServlet", urlPatterns = {"/ReservationClientServlet"})
public class ReservationClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    public ReservationClientServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vous pouvez gérer les actions GET si nécessaire
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 // Récupérez l'objet client à partir de la session
        HttpSession session = request.getSession();
        client clientObj = (client) session.getAttribute("utilisateur");
        
        if (clientObj != null) {
            String lieuPrise = request.getParameter("lieuPrise");
            String lieuRetour = request.getParameter("lieuRetour");
            String modePaiment = request.getParameter("modePaiment");

            // Récupérez la date de début et la date de fin à partir du formulaire
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = null;
            Date dateFin = null;

            try {
                dateDebut = dateFormat.parse(request.getParameter("dateDebut"));
                dateFin = dateFormat.parse(request.getParameter("dateFin"));
            } catch (ParseException e) {
                // Gérez l'erreur de parsing, par exemple en affichant un message d'erreur
                e.printStackTrace();
            }

            // Initialisez votre EntityManagerFactory et EntityManager ici
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
            EntityManager em = emf.createEntityManager();

            

            // Créez une nouvelle réservation
            reservation nouvelleReservation = new reservation();
            nouvelleReservation.setClient(clientObj);
            nouvelleReservation.setLieuPrise(lieuPrise);
            nouvelleReservation.setLieuRetour(lieuRetour);
            nouvelleReservation.setModePaiment(modePaiment);
            nouvelleReservation.setDate_debut(dateDebut);
            nouvelleReservation.setDate_fin(dateFin);
            

            em.getTransaction().begin();
            try {
                em.persist(nouvelleReservation);
                em.getTransaction().commit();
                // Redirigez l'utilisateur vers une page de confirmation ou une autre page appropriée
                session.setAttribute("successMessage", "Réservation établie avec succès");
                response.sendRedirect("ReservationClient.jsp");
            } catch (Exception e) {
                // Gérez les exceptions, par exemple, affichez un message d'erreur
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        } else {
        	session.setAttribute("successMessage", "WIIIIIIIIIIIIIIIIK WIIIK ");
            response.sendRedirect("ReservationClient.jsp");
        }

       
    }
}