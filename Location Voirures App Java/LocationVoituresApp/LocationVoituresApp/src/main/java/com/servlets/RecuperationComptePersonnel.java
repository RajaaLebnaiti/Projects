package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.personnel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "RecuperationComptePersonnel", urlPatterns = {"/RecuperationComptePersonnel"})
public class RecuperationComptePersonnel extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
  
    public RecuperationComptePersonnel() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation des données saisit par le client
		String CIN = request.getParameter("CIN");
		String DateNaissance = request.getParameter("DateNaissance");
		String message = "";
		
		// Utilisez JPA pour vérifier les informations d'identification
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        // Requête JPQL pour rechercher un utilisateur par nom d'utilisateur et mot de passe
        TypedQuery<personnel> query = em.createQuery("SELECT u FROM personnel u WHERE u.dateNaissance = :DateNaissance AND u.CIN = :CIN", personnel.class);
        query.setParameter("CIN", CIN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = null;
		try {
			dateNaissance = dateFormat.parse(DateNaissance);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
        query.setParameter("DateNaissance", dateNaissance);

        // Exécution de la requête
        List<personnel> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty()) {
            // Authentification réussie
            personnel authenticatedPersonel = resultList.get(0); 
            String username = authenticatedPersonel.getNom_utilisateur();
            String password = authenticatedPersonel.getMotdepasse();

            // Set these values as attributes to pass to the JSP
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            // Forward to a JSP page that will display the username and password
            request.getRequestDispatcher("WEB-INF/DisplayCredentialsPersonnel.jsp").forward(request, response);
        } else {
            // Authentification échouée, redirigez l'utilisateur vers la page de connexion avec un message d'erreur
            message = "CIN ou date de naissance incorrect. Réessayer";
            request.setAttribute("message", message);
            request.getRequestDispatcher("RecuperationDonnesPersonnel.jsp").forward(request, response);
        }

        // Fermez les ressources JPA
        em.close();
        emf.close();
    }

	}


