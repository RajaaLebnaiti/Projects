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

import com.jpaClass.modele.facturation;
@WebServlet(name = "FacturationServlet", urlPatterns = { "/FacturationServlet" })


public class FacturationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Récupérer les réservations avec les détails du client
            //String jpql = "SELECT * FROM facturation f JOIN reservation r WHERE f.id_reservation=r.id_reservation";
            String jpql = "SELECT r FROM facturation r JOIN FETCH r.reservation";
            Query query = em.createQuery(jpql);
            List<facturation> facturations = query.getResultList();

            em.getTransaction().commit();
            
            request.setAttribute("facturations", facturations);
            request.getRequestDispatcher("/facturation.jsp").forward(request, response);

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