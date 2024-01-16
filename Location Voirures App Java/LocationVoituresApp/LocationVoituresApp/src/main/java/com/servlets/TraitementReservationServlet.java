package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.client;
import com.jpaClass.modele.personnel;
import com.jpaClass.modele.reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "TraitementReservationServlet", urlPatterns = {"/TraitementReservationServlet"})
public class TraitementReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TraitementReservationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Récupérez l'objet client à partir de la session
        HttpSession session = request.getSession();
        client clientObj = (client) session.getAttribute("utilisateur");

        if (clientObj != null) {
            String dateDebutStr = request.getParameter("date_debut");
            String dateFinStr = request.getParameter("date_fin");
            String lieuPrise = request.getParameter("lieuPrise");
            String lieuRetour = request.getParameter("lieuRetour");
            String modePaiement = request.getParameter("modePaiement");
            String statut = "en cours de traitement";
            // Parsez les dates depuis les chaînes
            Date dateDebut = parseDate(dateDebutStr);
            Date dateFin = parseDate(dateFinStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
            EntityManager em = emf.createEntityManager();

         // Créez une nouvelle réservation
            reservation nouvelleReservation = new reservation();
            nouvelleReservation.setDate_debut(dateDebut);
            nouvelleReservation.setDate_fin(dateFin);
            nouvelleReservation.setLieuPrise(lieuPrise);
            nouvelleReservation.setLieuRetour(lieuRetour);
            nouvelleReservation.setModePaiment(modePaiement);
            nouvelleReservation.setClient(clientObj);
            nouvelleReservation.setStatut(statut);
            
            if (modePaiement.equals("en_ligne")) {
            	// Stockez les informations nécessaires dans la session
                session.setAttribute("dateDebut", dateDebut);
                session.setAttribute("dateFin", dateFin);
                session.setAttribute("lieuPrise", lieuPrise);
                session.setAttribute("lieuRetour", lieuRetour);
                session.setAttribute("modePaiement", modePaiement);
                session.setAttribute("statut", statut);

                
                response.sendRedirect("PaimentEnLigne.jsp");
                return; //pour arreter de  de rediriger la réponse vers une autre page après que la réponse a déjà été partiellement ou complètement envoyée au client
            }
            personnel personnelObj = em.find(personnel.class, 1);
            nouvelleReservation.setPersonnel(personnelObj);
            nouvelleReservation.setClient(clientObj);

            em.getTransaction().begin();
            try {
                em.persist(nouvelleReservation);
                em.getTransaction().commit();
            } catch (Exception e) {
                // Gérez les exceptions, par exemple, affichez un message d'erreur
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                // Fermez EntityManager et EntityManagerFactory ici
                em.close();
                emf.close();
                // Redirigez l'utilisateur vers une page de confirmation ou une autre page appropriée
                session.setAttribute("successMessage", "Réservation établie avec succès");
                response.sendRedirect("confirmationReservation.jsp");
            
            
        } }else {
            session.setAttribute("successMessage", "Une erreur s'est produite. Réessayez.");
            response.sendRedirect("confirmationReservation.jsp");
        }
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}