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

import com.jpaClass.modele.personnel;
@WebServlet(name = "AffichagePersonnel", urlPatterns = { "/AffichagePersonnel" })
public class AffichagePersonnel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    

    public AffichagePersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}

       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        		
        try {
            em.getTransaction().begin();

            // Récupérer les informations du personnel depuis la base de données
            String jpql = "SELECT p FROM personnel p";
            Query query = em.createQuery(jpql);
            List<personnel> personnels = query.getResultList();

            em.getTransaction().commit();
            
            request.setAttribute("personnels", personnels);
            request.getRequestDispatcher("/AffichagePersonnel.jsp").forward(request, response);

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