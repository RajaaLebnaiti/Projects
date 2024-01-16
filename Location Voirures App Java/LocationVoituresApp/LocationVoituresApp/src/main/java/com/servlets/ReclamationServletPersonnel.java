package com.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.reclamation;
@WebServlet(name = "ReclamationServletPersonnel", urlPatterns = { "/ReclamationServletPersonnel" })


public class ReclamationServletPersonnel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Récupérer les réservations avec les détails du client
            String jpql = "SELECT r FROM reclamation r JOIN FETCH r.client";
            Query query = em.createQuery(jpql);
            List<reclamation> reclamations = query.getResultList();

            em.getTransaction().commit();
            
            request.setAttribute("reclamations", reclamations);
            request.getRequestDispatcher("/ReclamationPersonnel.jsp").forward(request, response);

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