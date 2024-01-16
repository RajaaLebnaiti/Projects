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
import java.io.IOException;
import java.util.List; // Correct import for List
import com.jpaClass.modele.voiture;
import com.jpaClass.modele.client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "VoitureServlet", urlPatterns = {"/VoitureServlet"})


@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size

public class VoitureServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	public VoitureServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<voiture> query = em.createQuery("SELECT v FROM voiture v", voiture.class);
            List<voiture> voitures = query.getResultList();
            
            // Exemple: définir la disponibilité en fonction d'une condition
            for (voiture v : voitures) {
                v.isDisponible();
            }

            request.setAttribute("voitures", voitures);
            RequestDispatcher rd = request.getRequestDispatcher("Voiture.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            em.close();
            emf.close();
        }

    }
}