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
import com.jpaClass.modele.client;

@WebServlet(name = "reccupererClient", urlPatterns = { "/reccupererClient" })
public class reccupererClient extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'identifiant de client depuis les paramètres de la requête
    	String ID =request.getParameter("id");
        int id = Integer.parseInt(ID);

        // Récupérer l'EntityManager à partir du contexte
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Trouver la voiture à partir de son ID
            client clientARecuperer = em.find(client.class, id);

            // Mettre les informations de la voiture dans les attributs de la requête
            request.setAttribute("client", clientARecuperer);

            // Rediriger vers la JSP pour afficher les informations
            request.getRequestDispatcher("/ModifierClient.jsp").forward(request, response);

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