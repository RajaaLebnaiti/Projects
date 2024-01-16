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
import jakarta.servlet.http.HttpSession;

import com.jpaClass.modele.client;

@WebServlet(name = "ProfilClient", urlPatterns = {"/ProfilClient"})
public class ProfilClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProfilClient() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		client client = (client) session.getAttribute("utilisateur");

		// Créez une nouvelle session pour "client"
		HttpSession clientSession = request.getSession();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
		EntityManager em = emf.createEntityManager();
		

		request.setAttribute("client", client);

		// Stockez également "client" dans la session "client"
		clientSession.setAttribute("client", client);

		request.getRequestDispatcher("ProfilClient.jsp").forward(request, response);

		em.close();
		emf.close();


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
