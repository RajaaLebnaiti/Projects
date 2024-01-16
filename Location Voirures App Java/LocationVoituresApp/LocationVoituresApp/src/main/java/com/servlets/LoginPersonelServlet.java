package com.servlets;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.jpaClass.modele.client;
import java.util.List;




import jakarta.persistence.TypedQuery;
import com.jpaClass.modele.personnel;


import jakarta.servlet.http.HttpSession;


@WebServlet(name = "LoginPersonelServlet", urlPatterns = {"/LoginPersonelServlet"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size
public class LoginPersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginPersonelServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des champs du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";

        // Utilisez JPA pour vérifier les informations d'identification
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        // Requête JPQL pour rechercher un utilisateur par nom d'utilisateur et mot de passe
        TypedQuery<personnel> query = em.createQuery("SELECT p FROM personnel p WHERE p.nom_utilisateur = :username AND p.motdepasse = :password", personnel.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        // Exécution de la requête
        List<personnel> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty())  {
            // Si les informations d'identification sont correctes
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
         // Récupérer et stocker l'ID du personnel dans la session
            int idPersonnel = resultList.get(0).getId_personnel();
            session.setAttribute("idPersonnel", idPersonnel);
            
            response.sendRedirect("/LocationVoituresApp/TableauServlet");
            } else {
            // Authentification échouée, redirigez l'utilisateur vers la page de connexion avec un message d'erreur
            message = "Nom d'utilisateur ou mot de passe incorrect. Réessayez";
            request.setAttribute("message", message);
            request.getRequestDispatcher("loginPersonnel.jsp").forward(request, response);
        }

        // Fermez les ressources JPA
        em.close();
        emf.close();
    }

    
}