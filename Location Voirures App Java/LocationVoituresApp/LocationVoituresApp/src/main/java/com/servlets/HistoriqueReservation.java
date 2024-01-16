package com.servlets;

import java.io.IOException;
import java.util.List;

import com.jpaClass.modele.client;
import com.jpaClass.modele.reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "HistoriqueReservation", urlPatterns = {"/HistoriqueReservation"})
public class HistoriqueReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HistoriqueReservation() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		client client = (client) session.getAttribute("utilisateur");
        int id_client = client.getId_client();
        // Utilisez le nom d'utilisateur pour récupérer l'historique des réservations depuis la base de données
        List<reservation> historiqueReservations = getHistoriqueReservations(id_client);

        // Transmettez l'historique des réservations à la page JSP
        request.setAttribute("historiqueReservations", historiqueReservations);
        request.getRequestDispatcher("HistoriqueReservationClient.jsp").forward(request, response);
    }

    private List<reservation> getHistoriqueReservations(int id_client) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<reservation> query = em.createQuery("SELECT r FROM reservation r WHERE r.client.id_client = :id_client", reservation.class);
        query.setParameter("id_client", id_client);

        List<reservation> historiqueReservations = query.getResultList();
        em.close();
        emf.close();
        return historiqueReservations;
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
