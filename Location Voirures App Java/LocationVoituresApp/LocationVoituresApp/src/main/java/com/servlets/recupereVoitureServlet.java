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

@WebServlet(name = "recupereVoitureServlet", urlPatterns = { "/recupereVoitureServlet" })
public class recupereVoitureServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'identifiant de la voiture depuis les paramètres de la requête
    	String ID =request.getParameter("id");
        int id = Integer.parseInt(ID);

        // Récupérer l'EntityManager à partir du contexte
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Trouver la voiture à partir de son ID
            voiture voitureARecuperer = em.find(voiture.class, id);

            // Mettre les informations de la voiture dans les attributs de la requête
            request.setAttribute("voiture", voitureARecuperer);

            // Rediriger vers la JSP pour afficher les informations
            request.getRequestDispatcher("/ModifierVoiture.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Vérifier si l'EntityManager n'est pas null avant de le fermer
            if (em != null) {
                em.close();
            }
        }
    }
}