package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import com.jpaClass.modele.client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "RecuperationCompteClient", urlPatterns = {"/RecuperationCompteClient"})
public class RecuperationCompteClient extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
    public RecuperationCompteClient() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
        TypedQuery<client> query = em.createQuery("SELECT u FROM client u WHERE u.DateNaissance = :DateNaissance AND u.CIN = :CIN", client.class);
        query.setParameter("CIN", CIN);

        // Convert the DateNaissance string to a Date object and set it as a parameter
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = null;
		try {
			dateNaissance = dateFormat.parse(DateNaissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        query.setParameter("DateNaissance", dateNaissance);

        // Exécution de la requête
        List<client> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty()) {
            // Authentification réussie
            client authenticatedClient = resultList.get(0); // Assuming there's only one match
            String username = authenticatedClient.getNom_utilisateur();
            String password = authenticatedClient.getMotdepasse();

            // Set these values as attributes to pass to the JSP
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            // Forward to a JSP page that will display the username and password
            request.getRequestDispatcher("WEB-INF/DisplayCredentials.jsp").forward(request, response);
        } else {
            // Authentification échouée, redirigez l'utilisateur vers la page de connexion avec un message d'erreur
            message = "CIN ou date de naissance incorrect. Réessayer";
            request.setAttribute("message", message);
            request.getRequestDispatcher("RecuperationDonnesClient.jsp").forward(request, response);
        }

        // Fermez les ressources JPA
        em.close();
        emf.close();
    }

}
