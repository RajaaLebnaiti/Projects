package com.servlets;

import java.io.IOException;
import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import com.jpaClass.modele.client;
import com.jpaClass.modele.voiture;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "AuthentificationClientServlet", urlPatterns = {"/AuthentificationClientServlet"})
public class AuthentificationClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AuthentificationClientServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des champs du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        // Requête JPQL pour rechercher un utilisateur par nom d'utilisateur et mot de passe
        TypedQuery<client> query = em.createQuery("SELECT u FROM client u WHERE u.nom_utilisateur = :username AND u.motdepasse = :password", client.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        // Exécution de la requête
        List<client> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty()) {
            // Authentification réussie
            // ON stocke les informations de l'utilisateur dans la session
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", resultList.get(0));
            session.setAttribute("username", username);
            
            // Récupération de la liste des voitures et stockage dans un attribut request
            List<voiture> voitures = getVoituresFromDatabase();
            session.setAttribute("voitures", voitures);

            // Redirection vers la page HomePageClient.jsp
            request.getRequestDispatcher("HomePageClient.jsp").forward(request, response);
        } else {
            // Authentification échouée, redirigez l'utilisateur vers la page de connexion avec un message d'erreur
            message = "Nom d'utilisateur ou mot de passe incorrect. Réessayez";
            request.setAttribute("message", message);
            request.getRequestDispatcher("loginClient.jsp").forward(request, response);
        }

        // Fermez les ressources JPA
        em.close();
        emf.close();
    }

    // Méthode pour récupérer les données des voitures depuis la base de données
    private List<voiture> getVoituresFromDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        // Utilisez une requête JPQL pour récupérer les voitures
        List<voiture> voitures = em.createQuery("SELECT v FROM voiture v", voiture.class).getResultList();

        // Fermez les ressources JPA
        em.close();
        emf.close();

        return voitures;
    }
}