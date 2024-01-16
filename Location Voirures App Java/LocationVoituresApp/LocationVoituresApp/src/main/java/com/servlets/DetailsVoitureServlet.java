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

import com.jpaClass.modele.voiture;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "DetailsVoitureServlet", urlPatterns = {"/DetailsVoitureServlet"})
public class DetailsVoitureServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Récupérer le paramètre de requête "id" qui représente l'identifiant de la voiture
            String voitureId = request.getParameter("id");

            // Exécuter la requête JPA pour récupérer les détails de la voiture
            TypedQuery<voiture> query = em.createQuery("SELECT v FROM voiture v WHERE v.id_voiture = :id", voiture.class);
            query.setParameter("id", Long.parseLong(voitureId));
            voiture v = query.getSingleResult();

            // Passer les données à la page JSP
            request.setAttribute("voiture", v);
            RequestDispatcher rd = request.getRequestDispatcher("DetailsVoiture.jsp");
            rd.forward(request, response);
        } finally {
            em.close();
            emf.close();
        }
    }
}