package com.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jpaClass.modele.client;
import com.jpaClass.modele.facturation;

@WebServlet(name = "FactureServlet", urlPatterns = {"/FactureServlet"})
public class FactureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FactureServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  // Récupérez le client à partir de la session
        HttpSession session = request.getSession();
        client client = (client) session.getAttribute("utilisateur");

        // Utilisez JPA pour obtenir les factures du client
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        List<facturation> factures = getFacturesForClient(em, client);

        // Stockez les factures dans la requête pour les afficher dans la page JSP
        request.setAttribute("factures", factures);

        // Redirigez vers la page de factures du client
        request.getRequestDispatcher("Facture.jsp").forward(request, response);

        // Fermez les ressources JPA
        em.close();
        emf.close();
    }

    private List<facturation> getFacturesForClient(EntityManager em, client client) {
        // Écrivez une requête JPQL pour obtenir les factures du client
    	String jpql = "SELECT f.id_facture, f.montant, f.date_facturation " +
                "FROM facturation f " +
                "JOIN f.reservation r " +
                "JOIN r.client c " +
                "WHERE c.id_client = :clientId";

        TypedQuery<facturation> query = em.createQuery(jpql, facturation.class);
        query.setParameter("clientId", client.getId_client());

        return query.getResultList();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}