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

import java.util.List; // Correct import for List

import com.jpaClass.modele.client;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.annotation.MultipartConfig;

@WebServlet(name = "ListeClientsServlet", urlPatterns = { "/ListeClientsServlet" })
@MultipartConfig
public class ListeClientsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'EntityManager à partir du contexte
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        try {
            // Commencer une transaction
            em.getTransaction().begin();

            // Récupérer la liste des clients depuis la base de données
            TypedQuery<client> query = em.createQuery("SELECT c FROM client c", client.class);
            List<client> clients = query.getResultList();
            

            // Terminer la transaction
            em.getTransaction().commit();

            // Mettre la liste des clients dans la requête pour l'afficher dans la JSP
            request.setAttribute("clients", clients);

            // Rediriger vers la JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListeClients.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Annuler la transaction en cas d'erreur
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // Fermer l'EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}