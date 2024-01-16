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

import com.jpaClass.modele.reservation;
@WebServlet(name = "selectionneReservation", urlPatterns = { "/selectionneReservation" })


public class selectionneReservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

           
            String jpql = "SELECT r FROM reservation r";
            Query query = em.createQuery(jpql);
            List<reservation> reservations = query.getResultList();

            em.getTransaction().commit();
            
            request.setAttribute("reservations", reservations);
            request.getRequestDispatcher("/AjouterFacture.jsp").forward(request, response);

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