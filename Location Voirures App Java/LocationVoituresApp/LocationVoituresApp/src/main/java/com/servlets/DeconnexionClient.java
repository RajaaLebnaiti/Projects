package com.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DeconnexionClient", urlPatterns = {"/DeconnexionClient"})
public class DeconnexionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeconnexionClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Récupérer la session de l'utilisateur
        HttpSession session = request.getSession();

        // Déconnectez l'utilisateur en invalidant sa session
        session.invalidate();

        // Redirigez l'utilisateur vers une page de déconnexion ou une page d'accueil
        response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
