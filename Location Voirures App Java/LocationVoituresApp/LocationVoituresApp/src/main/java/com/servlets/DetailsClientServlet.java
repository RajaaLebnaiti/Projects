package com.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.jpaClass.modele.client;

@WebServlet(name="DetailsClientServlet", urlPatterns = {"/DetailsClientServlet"})
public class DetailsClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter("id"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            client clientDetails = em.find(client.class, clientId);
            System.out.println("Client"+clientDetails);
            request.setAttribute("clientDetails", clientDetails);
            request.getRequestDispatcher("DetailsClient.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}