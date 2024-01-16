package com.servlets;

import java.io.IOException;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.jpaClass.modele.client;
import com.jpaClass.modele.personnel;
import com.jpaClass.modele.reclamation;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ReclamationServlet", urlPatterns = {"/ReclamationServlet"})
public class ReclamationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReclamationServlet() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Afficher le formulaire de réclamation
        request.getRequestDispatcher("Reclamation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sujet = request.getParameter("sujet");
        String description = request.getParameter("description");

        // Récupérer le client actuellement connecté depuis la session
        HttpSession session = request.getSession();
        client client = (client) session.getAttribute("utilisateur");

        // Créer une nouvelle réclamation
        reclamation nouvelleReclamation = new reclamation();
        nouvelleReclamation.setSujet(sujet);
        nouvelleReclamation.setDescription(description);
        nouvelleReclamation.setDateSoumission(new Date());
        nouvelleReclamation.setClient(client);
        personnel personnel = new personnel(); 
        personnel.setId_personnel(1); // Set the personnel ID

        // Set the personnel object in the reclamation entity
        nouvelleReclamation.setPersonnel(personnel);

        // Now you can set the personnel ID
        nouvelleReclamation.getPersonnel().setId_personnel(1);

        // Enregistrez la réclamation dans votre base de données
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(nouvelleReclamation);
        em.getTransaction().commit();

        em.close();
        emf.close();

        // Réponse de confirmation
        request.setAttribute("message", "Réclamation envoyée avec succès");

        // Redirigez vers Reclamation.jsp
        request.getRequestDispatcher("Reclamation.jsp").forward(request, response);
    }
}